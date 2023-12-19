package org.spring.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.spring.domain.BoardVO;
import org.spring.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


// 깃주석222
@Controller // 이거 컨트롤러얌
@RequestMapping("/board/*") // board 접근하는 애들은 다 이 컨트롤러가 관리
@AllArgsConstructor // 기본생성자 자동 호출(boardService주입)
@Log4j
public class BoardController {
	private final BoardService boardService; // 의존성 주입시켜 객체 생성
	// BoardServiceImpl를 주입한 것과 똑같다(그래서 인터페이스를 주입)
	// 스프링에서 인터페이스 주입시 해당 인터페이스를 구현한 객체를 주입하기 때문
	
	
	@GetMapping("/list")
	public void listAll(Model model) {
		log.info("전체회원목록");
		model.addAttribute("boardList", boardService.listAll());
		// boardList이름으로 바인딩해서 jsp에게 넘겨줌 (이때 스프링이 기본적으로 주는 통이 model)
		// model: 매핑된 jsp 등의 화면으로 이동시에 전달되는 객체
		// 바인딩: name과 value의 쌍으로 저장
	}
	
	// list의 버튼이 url을 직접적으로 전달하기 때문에 get 방식
	// 화면 전환을 담당(board/register.jsp)
	@GetMapping("/register")
	public void registerGet() {
		log.info("글 쓰기 시작");
	}
	
	// form이나 Ajax로 controller접근: 데이터 이동이 발생 = post방식 이용
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("글내용: "+board);
		Integer bno = boardService.registerKey(board);
		rttr.addFlashAttribute("alert", bno+"번 글이 등록되었습니다.");
		
		
//				boardService.register(board);
		
//		int maxBno = boardService.getMaxBno();
		// 먼저 글을 등록하고 maxBno를 찾으면 +1을 안해도 된다
//		rttr.addFlashAttribute("alert", maxBno+"번 글이 등록되었습니다.");
		
		// 글이 등록된 후에 bno생성되기 때문에 안됨
//		rttr.addFlashAttribute("alert", board.getBno()+"번 글이 등록되었습니다.");
		
		// addFlashAttribute는 임시로 저장하는 방식, 성공실패여부 메세지와 같이
		// 임시로 사용되는 데이터를 다루는데 적합하다 
		
		return "redirect:/board/list"; 
		// 그냥 /board/list를 보내면 DB를 거치지 않고 jsp로 가기때문에 껍데기만 보임
		// redirect는 포워딩하는 애라서 컨트롤러를 거쳐서 간다(controller의 list로)
		// redirect: 클라이언트의 브라우저에게 다른 URL로 이동하라는 명령,
		// 				새로고침으로 인한 중복요청 방지
	}
	
	@GetMapping({"/get","/modify"}) // 여러개 맵핑이 가능해요!
	public void get(@RequestParam("bno") Integer bno, Model model) {
		log.info("현재 글 번호: "+bno);
		model.addAttribute("boardSelect", boardService.get(bno)) ;
	}

	
//	@GetMapping("/modify")
//	public void modifyGet(int bno,Model model) {
//		model.addAttribute("boardUpdate", boardService.get(bno)) ;
//	}
	
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		log.info("수정내용: "+vo);
		int count = boardService.modify(vo);
		// 수정된 튜플이 1개라면 "alert"이라는 name에 메세지를 바인딩하여 화면으로 전달
		if (count == 1) {
			rttr.addFlashAttribute("alert", "글 수정 완료");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") Integer bno, RedirectAttributes rttr) {
		log.info("글 삭제");
		boardService.remove(bno);
		rttr.addFlashAttribute("alert", "글 삭제 완료");
		return "redirect:/board/list";
		
	}
	
}
