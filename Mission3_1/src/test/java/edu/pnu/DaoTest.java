package edu.pnu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DaoTest {
	
	@Autowired
	private MemberDao dao;
	
	@Test
	public void test() {
		List<MemberVO> list = dao.getAllMember();
		
		int i = 1;
		for(MemberVO m : list) {
			System.out.println(m);
			assertEquals(i++, m.getId());
		}
	}

}
