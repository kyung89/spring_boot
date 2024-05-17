package edu.pnu;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistance.BoardRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class QueryMethodTest2 {

	@Autowired private BoardRepository boardRepo;
	
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
	@Order(2)
	public void testFindByTitleContaining() {
		List<Board> boardList = boardRepo.findByTitleContaining("1");
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
	@Test
	@Order(3)
	public void testFindByTitleContainingCntGreaterThan() {
		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50);
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
	@Test
	@Order(4)
	public void testFindByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc() {
		List<Board> boardList = boardRepo.findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(10, 50);
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
	@Test
	@Order(5)
	public void testFindByTitleContainingOrContentContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
}
