package edu.pnu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.persistance.BoardRepository;

@RestController
public class TestController {

	@Autowired
	private BoardRepository boardRepo;
	
	@GetMapping("/boards")
	public List<Board> getBoards() {
		return boardRepo.findAll();
	}
	
	@GetMapping("/board")
	public Board getBoard(Long seq) {
		return boardRepo.findById(seq).get();
	}
	
	@GetMapping("/board/{seq}")
	public Board getBoardByPathVariable(@PathVariable Long seq) {
		return boardRepo.findById(seq).get();
	}
	
	@PostMapping("/board")
	public Board insertBoard(@RequestBody Board board) {
		Board bd = board;
		bd.setCreateDate(new Date());
		return boardRepo.save(bd);
	}
	
	@PutMapping("/board")
	public Board updateBoard(@RequestBody Board board) {
		Board bd = boardRepo.findById(board.getSeq()).get();
		bd.setTitle(board.getTitle());
		bd.setWriter(board.getWriter());
		bd.setContent(board.getContent());
		bd.setCnt(board.getCnt());
		//Board에서 update 메서드를 만들어 처리할 수 있다
		return boardRepo.save(bd);
	}
	
	@DeleteMapping("/board")
	public void removeBoard(Long seq) {
		// 삭제할 것을 가져와서 리턴하는 식으로 구현할 수도 있다.
		boardRepo.deleteById(seq);
	}
}
