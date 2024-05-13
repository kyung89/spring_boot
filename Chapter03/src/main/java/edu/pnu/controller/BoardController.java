package edu.pnu.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BoardVO;

@RestController
public class BoardController {

	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello: " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO vo = new BoardVO();
		vo.setWriter("테스터");
		return vo;
	}
}
