package org.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class CommonsException {
	
	@ExceptionHandler(Exception.class) // 모든 예외에 대해서 이 메서드를 실행시킬게
	public String except(Exception ex, Model model) { // model: 화면으로 넘긴다
		System.out.println("Exception" + ex.getMessage());
		model.addAttribute("exception",ex);
		return "error_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class) // 컨트롤러 예외가 아닌 모든 예외
	@ResponseStatus(HttpStatus.NOT_FOUND)// 클라이언트단에서 일어난 예외
	public String handle404(NoHandlerFoundException ex) { 
		return "client404";
	}
}
