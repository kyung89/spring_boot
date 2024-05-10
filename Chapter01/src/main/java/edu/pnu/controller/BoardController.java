package edu.pnu.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BoardVO;

@RestController
public class BoardController {

	public BoardController() {
		System.out.println("===> BoardController 생성");
	}

	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello: " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목...");
		board.setWriter("테스터");
		board.setContent("테스트 내용입니다....");
		board.setCreateDate(new Date());
		board.setCnt(0);
		
		return board;
	}
}

// 프레임워크: 이미 만들어져있는데다가 내가 쓸 수 있는 거 가져오기 
// 라이브러리: 모듈들을 가져오는 방식

// @RestController
// @Controller
// @Component
// @Service
// @Repository
// @Configuration - @Bean