package org.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.spring.domain.SampleDTO;
import org.spring.domain.TodoDTO;
import org.spring.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;


// 테스트 주석ㄹㄹㄹ
@Controller
@RequestMapping("/sample/*") // sample/aaa sample/bbb smaple/
public class SampleController {

	private final FileService fileService;
	
	@Autowired // 주입하는것(new객체 만드는 것보다)
	public SampleController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@RequestMapping("/")
	public void basic() {
		System.out.println("basic..");
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet() {
		System.out.println("basic get..");
	}

	// DTO : Data Transfer Object
	// 데이터를 간단한 객체 형태로 표현 및 전달을 위해 사용되는 개념
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println(dto);
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		return "ex02";
	}

	// sample/ex02List?chk="a"&chk="b"
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("chk") ArrayList<String> chk) {
		for (String c : chk) {
			System.out.println(c);
		}
		System.out.println("chk: " + chk);
		return "ex02List";
	}

	// list는 get방식으로 전달 불가능. post방식을 사용해야 한다.
	@GetMapping("/ex02ParaList")
	public String ex02ParaList(@RequestParam("n") ArrayList<String> array) {
		System.out.println(array);
		return "ex02ParaList";
	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		System.out.println(todo);
		return "ex03";
	}

	// void : 접속한 url과 동일한 이름의 jsp파일과 연결
	// views/sample/ex04.jsp로 이동
	// 포워딩 view를 따로 지정할 필요 x
	@GetMapping("/ex04")
	public void ex04() {
		System.out.println("ex04");
	}

	@GetMapping("/exUpload")
	public void exUpload(ArrayList<MultipartFile> files) {
		System.out.println("exUpload");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			System.out.println("name: " + file.getOriginalFilename());
			System.out.println("size: " + file.getSize());
			
			if(file.getSize() > 0) {
				// 저장 기능 구현 (저장할파일, 경로가 필요) -> fileService에 메서드 만들기
				String newFileName = generateFileName(file.getOriginalFilename());
				try {
					// 랜덤이름 통째로 붙여서 보내기로 했을 때
					fileService.saveFile(file, "C:/fileUpload/desti/"+newFileName);
				} catch (IOException e) {
//					log.error(e.getMessage());
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	// 랜덤한 파일이름을 만들어주는 방법
	private String generateFileName(String originalFileName) {
		long uploadTime = System.currentTimeMillis();
		return uploadTime + "_" + originalFileName;
	}

}
