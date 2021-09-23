package com.hammall.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hammall.domain.CategoryVO;
import com.hammall.domain.ProductVO;
import com.hammall.dto.Criteria;
import com.hammall.service.UserProductService;
import com.hammall.util.FileUploadUtils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/product/*")
public class UserProductController {

	@Setter(onMethod_ = @Autowired)
	private UserProductService userProductService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	// 카테고리
	@ResponseBody
	@GetMapping("/subCategoryList/{ctg_code}")
	public ResponseEntity<List<CategoryVO>> subCategoryList(@PathVariable("ctg_code") String ctg_code) throws Exception{
		
		ResponseEntity<List<CategoryVO>> entity = null;
		
		try {
			entity = new ResponseEntity<List<CategoryVO>> (userProductService.getSubCategoryList(ctg_code), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<CategoryVO>> (HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	// 2차 카테고리에 의한 상품목록정보
	@GetMapping("/product_list")
	public String getProductListBysubCate(@ModelAttribute("cri") Criteria cri, String ctg_code, Model model) throws Exception{
//		log.info("getProductListBysubCate: " + ctg_code);
//		log.info("Criteria cri: " + cri);
		
		cri.setAmount(9); // 상품출력 개수
		
		model.addAttribute("productVOList", userProductService.getProductListBysubCate(cri, ctg_code));
		
		return "/product/product_list";
	}
	
	// 상품 이미지 뷰
	@ResponseBody
	@GetMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		
		return FileUploadUtils.getFile(uploadPath, fileName);
	}
	
	// 상품상세설명(상품조회)
	@GetMapping("/product_read")
	public void product_read(@RequestParam("prod_num") int prod_num, Model model) throws Exception{
		log.info("product_read: " + prod_num);
		
		ProductVO vo = userProductService.getProductByNum(prod_num);
		vo.setProd_img(FileUploadUtils.thumbToOriginName(vo.getProd_img()));
		
		model.addAttribute("productVO", vo);
	}
	
	
	
	
	
	
	
	
	
	
	
}
