package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.domain.Log;
import edu.pnu.domain.Board;
import edu.pnu.persistance.BoardRepository;
import edu.pnu.persistance.LogRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private LogRepository logRepo;

	public Log generateLog(String method, String sqlstring, boolean success) {
		Log log = new Log();
		log.setMethod(method);
		log.setSqlString(sqlstring);
		log.setSuccess(success);
		log.setRegidate(new Date());
		return log;
	}

	public List<Board> getAllBoard() {
		logRepo.save(generateLog("getAllBoard()", "", true));
		return boardRepo.findAll();
	}

	public Board getBoardById(Long id) {
		if(boardRepo.findById(id) == null) logRepo.save(generateLog("getBoardById(Integer id)", "", false));
		else logRepo.save(generateLog("getBoardById(Integer id)", "", true));
		return boardRepo.findById(id).get();
	}
	
	public Board addBoard(Board Board) {
		if(boardRepo.save(Board) == null) logRepo.save(generateLog("addBoard(BoardVO BoardVO)", "", false));
		else logRepo.save(generateLog("addBoard(BoardVO BoardVO)", "", true));
		return boardRepo.save(Board);
	}
	
	public Board updateBoard(Board Board) {
		if(boardRepo.save(Board) == null) logRepo.save(generateLog("updateBoard(BoardVO BoardVO)", "", false));
		else logRepo.save(generateLog("updateBoard(BoardVO BoardVO)", "", true));
		return boardRepo.save(Board);
	}
	
	public void removeBoard(Long id) {
		logRepo.save(generateLog("removeBoard(Integer id)", "", true));
		boardRepo.deleteById(id);
	}
}
