package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.service.BoardService;
import edu.pnu.service.MemberService;

@RestController
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping("/boards")
	public List<Board> getAllBoard() {
		return service.getAllBoard();
	}
	
	@GetMapping("/board")
	public Board getMemberById(Long id) {
		return service.getBoardById(id);
	}
	
	@PostMapping("/board")
	public Board addMember(@RequestBody Board board) {
		return service.addBoard(board);
	}
	
	@PutMapping("/board")
	public Board updateMember(@RequestBody Board board) {
		return service.updateBoard(board);
	}
	
	@DeleteMapping("/board")
	public void removeMember(Long id) {
		service.removeBoard(id);
	}
	
	@PostMapping("/boardJSON")
	public Board addMemberJSON(@RequestBody Board board) {
		return service.addBoard(board);
	}
}
