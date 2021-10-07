package com.hammall.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Log4j
public class FileUploadUtils {

	/*
	 * 파일 업로드
	 * 
	 * @Params
	 * String uploadPath: 기본 파일 업로드 경로
	 * String originName: 원본 파일명
	 * byte[] fileData:   파일 데이터
	 * 
	 * @return
	 * String uploadedFileName : 날짜 경로 + 파일 이름 (ex.\\2020\\03\\13\\uuid+fileName)
	 * 
	 */
	public static String uploadFile(String uploadPath, String originName, MultipartFile multipartFile) throws Exception{
	
		// 파일 경로 설정 ex) 날짜경로
		String savedPath = getDateFolder(uploadPath); // 날짜포맷의 폴더명. ex.\\2020\\03\\13
		
		// 파일명 설정 ex) uuid_파일명
		UUID uuid = UUID.randomUUID(); // 파일명 중복방지 목적
		String savedName = uuid.toString() + "_" + originName; // 고유한 파일명 생성
		
		// 설정한 정보로 빈 파일 생성
		File saveFile = new File(uploadPath + savedPath, savedName);
		
		multipartFile.transferTo(saveFile); // 기본파일 작업
		
		String uploadedFileName = "";
		
		// 기본 첨부파일이 이미지, 일반파일에 따라서 썸네일작업 진행.
		if(checkImageType(saveFile)) {
			uploadedFileName = makeThumbNail(uploadPath, savedPath, savedName, multipartFile);
		}else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		
		
		return uploadedFileName;
	}
	
	// 날짜포맷의 폴더명 생성기능. uploadFolder -> "D:\\dev\\upload"
	private static String getDateFolder(String uploadFolder) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		String osGetSepStr = str.replace("-", File.separator); 
		
		makeDir(uploadFolder, osGetSepStr);
		
		// 반환값으로 년월일에 해당하는 폴더를 계층적으로 생성을하는 목적때문에, 각  운영체제에서 관리하는 경로구분자로 바꿔야 한다. 
		return osGetSepStr; // "2020-03-31" -> "2020\03\31"
	}

	// 업로드 폴더와 날짜포맷의 폴더명을 이용한 실제 폴더생성
	private static void makeDir(String uploadFolder, String osGetSepStr) {
		
		File uploadPath = new File(uploadFolder, osGetSepStr);
		
		// uploadFolderPath 폴더명이 존재하지 않으면
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();// "D:\\dev\\upload" "2021/03/30"
		}
		
	}
	
	private static boolean checkImageType(File file) {
			
		String contentType;
		try {
			// 해당 파일의 MIME(파일변환)를 확인하고자 할때 사용.
			contentType = Files.probeContentType(file.toPath());
							
			return contentType.startsWith("image"); // image/jpg, image/png, image/gif,...등등
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/*
	 * uploadPath : 업로드폴더명 (d:\\dev\\upload)
	 * savedPath : 날짜폴더명 (2021\\04\\09)
	 * uploadFileName : UUID를 적용한 파일명
	 * multipartFile : 첨부된 파일을 참조
	 */
	private static String makeThumbNail(String uploadPath, String savedPath, String uploadFileName, MultipartFile multipartFile) throws Exception {
		
		// "d:\\dev\\upload\\2021\\04\\09\\s_sdfsfsaf234sfsfsdr239d_abc.psd"
		String thumbNailName = uploadPath + savedPath + File.separator + "s_" + uploadFileName;
		
		// 1)uploadPath->"D:\\upload\\tmp" + "2021\\03\\31" 2)uploadFileName->"s_" + "sdfsfsaf234sfsfsdr239d_abc.psd"
		FileOutputStream thumbnail = new FileOutputStream(new File(thumbNailName));
		
		//썸네일이미지 생성(pom.xml에서 thumbnailator 라이브러리에서 기능사용)
		Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
		thumbnail.close();
		
		// "2021\\04\\09\\s_sdfsfsaf234sfsfsdr239d_abc.psd"
		return thumbNailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception{
		String iconName = uploadPath + path + File.separator + fileName;
		
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	public static void deleteFile(String uploadPath, String fileName) {
		
		// 2021/04/12/s_698beeda-aa91-4402-852d-ecb934bdf73d_연동연습.PNG
		
		//  날짜경로+ UUID_fileName
		String front = fileName.substring(0, 11); 	// 날짜 경로  2021/04/12/
		String end = fileName.substring(13); 		// UUID_fileName
		String origin = front + end;  // 2021/04/12/698beeda-aa91-4402-852d-ecb934bdf73d_연동연습.PNG
		
		new File(uploadPath+origin.replace('/', File.separatorChar)).delete(); 		// 원본 파일 지우기
		new File(uploadPath+fileName.replace('/', File.separatorChar)).delete(); 	// 썸네일 파일 지우기
	}
	
	/*
	 * 썸네일 파일명(DB) -> 원래 파일명
	 * ex) 2020/03/20/s_UUID파일명 -> 2020/03/20/UUID파일명
	 */
	public static String thumbToOriginName(String thumbnailName) {
		String front = thumbnailName.substring(0, 11); 	// 날짜 경로
		String end = thumbnailName.substring(13); 		// UUID_fileName
		
		return front+end;
		
	}
	
	// 이미지를 출력하는 기능.(이미지 업로드폴더가 프로젝트 외부에 존재하기때문에)
	public static ResponseEntity<byte[]> getFile(String uploadPath, String fileName){
		
		log.info("fileName:" + fileName);
		
		File file = new File(uploadPath + fileName); // 이미지파일을 대상으로 File객체생성
		
		log.info("file: " + file);
		
		ResponseEntity<byte[]> result = null;
		
		// 패킷의 header와 body로 구성
		// @ResponseBody가 이미지소스를 가리키는 <byte[]>를  body 저장한다.
		// 브라우저에서 서버로부터 보내온 패킷(header + body) 중 header파트에 내용을 참고하여, body파트를 해석하게 된다.
		HttpHeaders header = new HttpHeaders(); 
		
		// 클라이언트에게 보낼 데이터의 MIME정보(image/png, image/gif)를 패킷의 Header파트 부분에 설정
		try {
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]> (FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;

		
	}
}
