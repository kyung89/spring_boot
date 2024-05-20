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

		Member m1 = new Member();
		m1.setId(1);
		m1.setPass("1234");
		m1.setName("member1");
		m1.setRegidate(new Date());
		memberRepo.save(m1);
		
		Member m2 = new Member();
		m2.setId(2);
		m2.setPass("1234");
		m2.setName("member2");
		m2.setRegidate(new Date());
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
