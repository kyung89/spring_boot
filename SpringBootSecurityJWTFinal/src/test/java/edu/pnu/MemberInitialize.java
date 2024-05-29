package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.MemberRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MemberInitialize {
	

	@Autowired
	MemberRepository memRepo;
	
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Test
	public void doWork() {
		
		memRepo.save(Member.builder()
				.username("marketing")
				.password(encoder.encode("abcd"))
				.role(Role.ROLE_MARKET)
				.enabled(true).build());
		
		memRepo.save(Member.builder()
				.username("develop")
				.password(encoder.encode("abcd"))
				.role(Role.ROLE_DEVELOP)
				.enabled(true).build());
		
		memRepo.save(Member.builder()
				.username("finance")
				.password(encoder.encode("abcd"))
				.role(Role.ROLE_FINANCE)
				.enabled(true).build());
		
		memRepo.save(Member.builder()
				.username("admin")
				.password(encoder.encode("abcd"))
				.role(Role.ROLE_ADMIN)
				.enabled(true).build());
	}
}