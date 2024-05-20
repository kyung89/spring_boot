package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistance.BoardRepository;
import edu.pnu.persistance.MemberRepository;

@SpringBootTest
public class RelationMappingTest {

	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	public void testManyToOneSelect() {
		Board board = boardRepo.findById(5L).get();
		
		System.out.println("[" + board.getSeq() + "번 게시글 정보]");
		System.out.println("제목: " + board.getTitle());
		System.out.println("내용: " + board.getContent());
		System.out.println("작성자: " + board.getMember().getName());
		System.out.println("작성자 궘한: " + board.getMember().getRole());
	}
	
	@Test
	public void testTwowayMapping() {
		Member member = memberRepo.findById("member1").get();
		
		System.out.println("=========================");
		System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
		System.out.println("=========================");
		List<Board> list = member.getBoardList();
		for(Board board : list) {
			System.out.println(board.toString());
		}
	}
	
	@Test
	public void testCascadeDelete() {
		memberRepo.deleteById("member2");
	}
}
