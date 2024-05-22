package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistance.BoardRepository;
import edu.pnu.persistance.MemberRepository;
import lombok.RequiredArgsConstructor;


@Component
public class DataInit implements ApplicationRunner {
	
	@Autowired
	private BoardRepository boardRepo;

	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		Member member1 = new Member();
		member1.setId("member1");
		member1.setName("둘리");
		member1.setPassword("member111");
		member1.setRole("ROLE_USER");
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setName("도우너");
		member2.setPassword("member222");
		member2.setRole("ROLE_ADMIN");
		memberRepo.save(member2);
		
		Random rd = new Random();
		for (int i=1; i<=3; i++) {
			boardRepo.save(Board.builder()
					.title("둘리가 등록한 게시글" + i)
					.writer("둘리")
					.content("둘리가 등록한 게시글 내용" + i)
					.build()
					);
		}
		for (int i=1; i<=3; i++) {
			boardRepo.save(Board.builder()
					.title("도우너가 등록한 게시글" + i)
					.writer("도우너")
					.content("도우너가 등록한 게시글 내용" + i)
					.build()
					);
		}
	}

}
