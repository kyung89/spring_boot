package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistance.BoardRepository;
import edu.pnu.persistance.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataInit implements ApplicationRunner {
	
	private final BoardRepository boardRepo;
	private final MemberRepository memberRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

//		Random rd = new Random();
//		for (int i=1; i<5; i++) {
//			boardRepo.save(Board.builder()
//					.title("title1" + i)
//					.writer("member1")
//					.content("content1" + i)
//					.createDate(new Date())
//					.cnt(Math.abs(rd.nextLong()%100L))
//					.build()
//					);
//		}
//		for (int i=1; i<5; i++) {
//			boardRepo.save(Board.builder()
//					.title("title2" + i)
//					.writer("member2")
//					.content("content2" + i)
//					.createDate(new Date())
//					.cnt(Math.abs(rd.nextLong()%100L))
//					.build()
//					);
//		}
		
		Member m1 = new Member();
		m1.setId("member1");
		m1.setPassword("1234");
		m1.setName("member1");
		m1.setRole("developer");
		memberRepo.save(m1);
		
		Member m2 = new Member();
		m2.setId("member2");
		m2.setPassword("1234");
		m2.setName("k2");
		m2.setRole("developer");
		memberRepo.save(m2);
		
		Random rd = new Random();
		for (int i=1; i<5; i++) {
			boardRepo.save(Board.builder()
					.title("title1" + i)
					.content("content1" + i)
					.createDate(new Date())
					.cnt(Math.abs((long)Math.random()*100))
					.member(m1)
					.build()
					);
		}
		for (int i=1; i<5; i++) {
			boardRepo.save(Board.builder()
					.title("title2" + i)
					.content("content2" + i)
					.createDate(new Date())
					.cnt(Math.abs((long)Math.random()*100))
					.member(m2)
					.build()
					);
		}
	}

}
