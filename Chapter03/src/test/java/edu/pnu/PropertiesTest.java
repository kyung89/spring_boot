package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
public class PropertiesTest {

	@Autowired
	Environment environment;
	
	@Test
	public void testMethod() {
		System.out.println("이름: " +  environment.getProperty("author.name"));
		System.out.println("나이: " +  environment.getProperty("author.age"));
		System.out.println("국가: " +  environment.getProperty("author.nation"));
	}
}
