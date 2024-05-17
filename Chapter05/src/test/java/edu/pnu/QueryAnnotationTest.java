package edu.pnu;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistance.BoardRepository;

@SpringBootTest
public class QueryAnnotationTest {
	
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
	public void testQueryAnnotationTest1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목 10");
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
	@Test
	@Order(3)
	public void testQueryAnnotationTest2() {
		List<Board> boardList = boardRepo.queryAnnotationTest2("테스트 제목 10");
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
	@Test
	@Order(3)
	public void testQueryAnnotationTest3() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest3("테스트 제목 10");
		
		System.out.println("검색 결과");
		for (Object[] row : boardList) {
			System.out.println("--->" + Arrays.toString(row));
		}
	}
	
	@Test
	@Order(4)
	public void testQueryAnnotationTest4() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest4("테스트 제목 10");
		
		System.out.println("검색 결과");
		for (Object[] row : boardList) {
			System.out.println("--->" + Arrays.toString(row));
		}
	}

}
