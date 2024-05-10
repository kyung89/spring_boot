package edu.pnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.pnu", "etc"}) // 패키지 뒤지기
public class Mission3Application {

	public static void main(String[] args) {
		SpringApplication.run(Mission3Application.class, args);
	}

}

//2024-05-10
//DI: dependency injection (의존성 주입)ㅣ 자기가 직접 만들지 않고, 외부에서 만들어서 넣어준다
//1. MemberService memberService = new MemberService(new MemberDao());
//2. MemberDao dao = new MemberDao();
// MemberService memberService = new MemberService(dao);
//3. set 방식도 있다
//
//IoC: 제어의 역전(Spring container) : 아래 annotation 붙은 것들 올리고, Autowired 인 것들 객체 생성 -> 일단 실행되고 올린다는 점에서 제어의 역전이라고 부른다.
//
//[class에 붙음]
//@RestController
//@Controller
//@Service
//@Repository
//@Configuration
//@Component
//
//[method에 붙음]
//@Bean
//
//@Autowired: 부트가 자동으로 DI 해준다
//
//1. 필드에다가 Autowired 붙이기
//2. 생성자에 넣기: 예전에는 생성자에도 Autowired 붙였지만, 지금은 생략해도 된다.
//   -> 조심할 점: 순환 참조가 될 가능성이 있다: A(B), B(A): 순환참조가 안되게끔 코딩을 하라!
//   -> 별로 추천드리는 방법은 아니다.
//3. setter 를 이용한 방법
// @Autowired
// public void setMemberService(MemberService memberService) {
//    this.memberService = memberService;
//}
//4. private final MemberService memberService: final 로 설정하고
//   -> 클래스 위에 @RequiredArgsConstructor 붙인다
//   -> 이게 제일 많이 쓰인다.
