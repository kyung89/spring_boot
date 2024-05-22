package edu.pnu.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.exception.BoardNotFoundException;

@Controller
public class ExceptionController {

	@RequestMapping("/boardError")
	public String boardError() {
		throw new BoardNotFoundException("검색된 게시글이 없습니다.");
	}
	
	@RequestMapping("/illegalArgumentError")
	public String illegalArgumentError() {

		throw new IllegalArgumentException("부적절한 인자가 전달되었습니다.");
	}
	
	@RequestMapping("/sqlError")
	public String sqlError() throws SQLException {

		throw new SQLException("SQL 구문에 오류가 있습니다.");
	}
	
	@ExceptionHandler(SQLException.class)
	public String numberFormatException(SQLException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("stackTrace", exception.getStackTrace());
		return "errors/sqlError";
	}
}
