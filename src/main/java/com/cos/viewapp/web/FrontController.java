package com.cos.viewapp.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// RestController (데이터를 리턴한다) - Buffer로 데이터 응답한다
// Controller ( 파일을 리턴한다) - 파일을 만들어서 파일로 응답한다

@Controller
public class FrontController {
	
	// http://localhost:8080/home    
	// 디스패쳐서블릿이 받아서-> /home (파싱)
	// IoC 컨테이너에 @RestController @Controller로 생성된 객체만 찾는다
	// 메서드를 호출
	// 컨트롤러 안에 전역 변수 안쓰는게 좋음 충돌 남 -> stack이 여러개 되면 그안에 다 들어가니깐
	
	@GetMapping("/home")
	public String home(Model model) { // 매개변수에 디스패쳐서블릿이 주입해줌 // request == model
		// ViewResolver 클래스 - 프레임워크에서 제공 
		// src/main/resources/templates (prefix) - 앞에붙음
		// .mustache (suffix) - 뒤에붙음
		// (prefix) (suffix)사이에 home 집어넣어줌
		
		String name = "박정인";
		model.addAttribute("name", name);
		
		List<Board> boards  = new ArrayList<>();
		boards.add(new Board(1, "제목1"));
		boards.add(new Board(2, "제목2"));

	
		
		model.addAttribute("boards", boards);
		return "home"; // RequestDispatcher 가 자동 작동 -> Request에 저장하면 name 끌고감 
	}
}
