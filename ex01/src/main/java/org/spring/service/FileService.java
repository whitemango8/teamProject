package org.spring.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	public void saveFile(MultipartFile file, String destinationDir) throws IOException {
//		File destination 
//			= new File(destinationDir+File.separator+file.getOriginalFilename());
		// 파일경로 + 파일명 사이에 / 인데 운영체제에 따라 다르기 때문에 총괄하는 separator씀
		
		// 랜덤이름까지 한꺼번에 전달하기로 했을 때
		File destination 
		= new File(destinationDir+File.separator);
		file.transferTo(destination);
	}
}
