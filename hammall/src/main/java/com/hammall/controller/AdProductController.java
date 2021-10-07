package com.hammall.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hammall.domain.CategoryVO;
import com.hammall.domain.ProductVO;
import com.hammall.dto.Criteria;
import com.hammall.dto.PageDTO;
import com.hammall.service.AdProductService;
import com.hammall.util.FileUploadUtils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/product/*")
public class AdProductController {

	@Setter(onMethod_ = @Autowired)
	private AdProductService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;  // servlet-context.xml설정
	
	
	// 상품등록 폼: 1차 카테고리정보 출력
	@GetMapping("/product_insert")
	public void product_insert(Model model) throws Exception{
		log.info("...상품 등록 폼");
		
		model.addAttribute("categoryList", service.getCategoryList());
	}
	
	// 2차 카테고리 정보
	@ResponseBody
	@GetMapping("/subCategoryList/{ctg_code}")
	public ResponseEntity<List<CategoryVO>> subCategoryList(@PathVariable("ctg_code") String ctg_code) throws Exception{
		log.info("subCategoryList: " + ctg_code);
		
		ResponseEntity<List<CategoryVO>> entity = null;
		
		try {
			entity = new ResponseEntity<List<CategoryVO>>(service.getSubCategoryList(ctg_code), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<CategoryVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	// 상품 등록
	@PostMapping("/insert")
	public String product_insert(ProductVO vo, RedirectAttributes rttr) throws Exception{
		
		log.info("insert: " + vo); // 상품이미지명 없는 상태
		
		// 1) 파일업로드 작업
		vo.setProd_img(FileUploadUtils.uploadFile(uploadPath, vo.getFile1().getOriginalFilename(), vo.getFile1()));
		
		// 2) 상품정보DB 삽입작업
		service.product_insert(vo); // 상품이미지명이 있는 상태
		
		return "redirect:/admin/product/pro_list";
	}
	
	// CKEditor 4.0 업로드처리(상품상세설명에서 사용하는 이미지에 대한 업로드)
		@PostMapping("/imgUpload")
		public void imgUpload(HttpServletRequest req, HttpServletResponse res, MultipartFile upload) {
		
			// 1) CKEditor를 통하여 업로드된 작업처리
			// 2) 업로드처리를 한 후, 파일정보를 CKEditor에게 돌려줌.
			
			// 출력스트림을 이용하여, 파일업로드 작업
			// 기능핵심 : 클래스의 메서드 학습
			
			
			log.info("imgUpload");
			
			OutputStream out = null;
			PrintWriter printWriter = null;
			
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");
			
			try {
				String fileName = upload.getOriginalFilename();
				byte[] bytes = upload.getBytes();
				
				
				// was(tomcat9.0)에서 관리하는 프로젝트의 루트경로를 참고해서, 실제업로드 경로를 반환
				/*개발용*/
				String uploadPath = req.getSession().getServletContext().getRealPath("/") + "resources\\upload\\";
				
				if(!new File(uploadPath).exists()) new File(uploadPath).mkdir();
				
				
				
				// 서버 배포용
				/*
				String uploadPath = "/usr/local/tomcat/tomcat-9/webapps/upload/";
				
				File uploadFolder = new File(uploadPath);
				
				if(!uploadFolder.exists()) {
					uploadFolder.mkdir();
				}
				*/
				
				uploadPath = uploadPath + fileName;
				
				log.info("ckeditor 파일업로드 경로" + uploadPath);
				
				out = new FileOutputStream(new File(uploadPath));
				out.write(bytes);
				
				// CKEditor에게 업로드한 파일정보를 돌려줘야한다.
				
				printWriter = res.getWriter();
				// 클라이언트가 직접 이미지를 요청하는 경로
				String fileUrl = "/upload/" + fileName;
				
				// {"filename":"abc.gif", "uploaded":1, "url":"/upload/abc.gif"} JSON포맷
				printWriter.println("{\"filename\":\"" + fileName + "\", \"uploaded\":1,\"url\":\"" + fileUrl + "\"}");
				printWriter.flush(); // 전송 (return과 같은 역할: 클라이언트로 보냄)

				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(out != null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				if(printWriter != null) {
					printWriter.close();
				}
			}
					
		}
	
	// 상품리스트
	@GetMapping("/pro_list")
	public String product_list(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		
		model.addAttribute("pro_list", service.product_list(cri));
		
		int totalCount = service.getTotalCountProduct(cri);
		
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));
		
		return "/admin/product/product_list";
	}
	
	// 상품이미지 뷰
	@ResponseBody
	@GetMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		
		return FileUploadUtils.getFile(uploadPath, fileName);
	}
		
	// 상품 수정 폼
	@GetMapping("/modify")
	public String modify(@RequestParam("prod_num") Long prod_num, @ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		log.info("...상품 수정" + prod_num);
		
		model.addAttribute("categoryList", service.getCategoryList());
		
		ProductVO vo = service.product_modify(prod_num);
		
		// 1차 카테고리
		String ctg_prt_code = vo.getCtg_prt_code();
		
		// 상품정보(1차,2차 카테고리)
		model.addAttribute("productVO", vo);
		
		// 2차 카테고리
		model.addAttribute("subCategoryList", service.getSubCategoryList(ctg_prt_code));
		
		return "/admin/product/product_modify";
	}
		
	// 상품 수정 저장	
	@PostMapping("/modify")
	public String modify(ProductVO vo, Criteria cri, RedirectAttributes rttr) throws Exception{
		log.info("...상품 수정 저장" + vo); // (DB)상품이미지명 있는 상태
		
		// 1) 파일업로드작업(상품이미지 변경시)
		if(vo.getFile1() != null && vo.getFile1().getSize() > 0) {
			
			// 기본이미지파일 삭제
			String oldImageFileName = vo.getProd_img();
			
			FileUploadUtils.deleteFile(uploadPath, oldImageFileName);
			
			// 변경이미지파일 정보
			vo.setProd_img(FileUploadUtils.uploadFile(uploadPath, vo.getFile1().getOriginalFilename(), vo.getFile1()));
		}
		
		// 2) 상품정보DB 삽입작업
		service.product_modify(vo); // 상품이미지명이 있는 상태
		
		log.info("Criteria " + cri);
		
		// 리스트 원래상태정보(Criteria cri -> 페이징, 감색포함)
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/admin/product/pro_list";
	}
		
	// 상품 삭제
	@GetMapping("/delete")
	public String delete(long prod_num, String prod_img, Criteria cri, RedirectAttributes rttr) throws Exception{
		log.info("...상품 삭제 " + prod_num); // (DB)상품이미지명 있는 상태
		
		// DB에서 상품정보삭제
		service.product_deleteOk(prod_num);
		
		// 상품이미지 삭제
		FileUploadUtils.deleteFile(uploadPath, prod_img);
		
		// 리스트 원래상태정보(Criteria cri -> 페이징, 감색포함)
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/admin/product/pro_list";
	}
	

	
}
