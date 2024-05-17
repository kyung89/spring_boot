package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
import edu.pnu.persistance.BoardRepository;
import edu.pnu.persistance.DynamicBoardRepository;

@SpringBootTest
public class DynamicQueryTest {

	@Autowired private DynamicBoardRepository boardRepo;
	
	@Test
	@Order(1)
	public void dataPrepare() {
		Random rd = new Random();
		for (int i=1; i<=100; i++) {
			boardRepo.save(Board.builder()
					.title("테스트 제목 " + i)
					.writer("테스터")
					.content("테스트 내용 " + i)
					.createDate(new Date())
					.cnt(Long.valueOf(rd.nextInt(100)))
					.build()
					);
		}
	}
	
	@Test
	public void testDynamicQuery() {
		String searchCondition = "TITLE";
		String searchKeyword = "테스트 제목 10";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if(searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if (searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		
		Pageable paging = PageRequest.of(0, 5);
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
}
