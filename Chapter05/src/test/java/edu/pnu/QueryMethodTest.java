package edu.pnu;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.persistance.BoardRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@SpringBootTest
public class QueryMethodTest {

	@Autowired private BoardRepository boardRepo;
	
	@BeforeEach
	public void dataPrepare() {
		for (int i=1; i<=200; i++) {
			boardRepo.save(Board.builder()
					.title("테스트 제목 " + i)
					.writer("테스터")
					.content("테스트 내용 " + i)
					.createDate(new Date())
					.cnt(0L)
					.build()
					);
		}
	}
	
//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
//	
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
//	
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("3", "7");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17", PageRequest.of(0, 5));
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
	
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0,  5, Sort.Direction.DESC, "seq");
		
		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
		
		System.out.println("PAGE SIZE: " + pageInfo.getSize());
		System.out.println("TOTAL PAGES: " + pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT: " + pageInfo.getTotalElements());
		System.out.println("NEXT: " + pageInfo.nextPageable());
		
		List<Board> boardList = pageInfo.getContent();
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
}
