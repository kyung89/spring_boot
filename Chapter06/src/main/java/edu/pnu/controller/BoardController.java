package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;

	@GetMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = service.getBoardList(board);

		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		service.insertBoard(board);
		return "redirect:getBoardList";
	}
	
// [1]
//	@GetMapping("/getBoard")
//	public String getBoard(Model model, Board board) {
//		model.addAttribute("board", service.getBoard(board));
//		return "getBoard";
//	}
	
// [2] - start
	@GetMapping("/getBoard")
	public String getBoard(Model model, Long seq) {
		model.addAttribute("board", service.getBoard(seq));
		return "getBoard";
	}

	
	@GetMapping("/getBoard1")
	public ModelAndView getBoard1(Long seq) {
		Board b = service.getBoard(seq);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", b);
		mv.setViewName("getBoard");
		
		return mv;
	}
// [2] - end
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		service.updateBoard(board);
		return "redirect:getBoardList"; // 에러: getBoardList 를 @Request 로 하거나, 여기에 forward 대신 redirect 로 수정하거나 (getBoardList 가 Post 가 아니라서 그럼)
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		service.deleteBoard(board);
		return "redirect:getBoardList";
	}
}
