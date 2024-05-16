package edu.pnu.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	List<Board> findByTitle(String searchKeyword);
	
	List<Board> findByContentContaining(String searchKeyword);
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);

}
 // 하이버네이트가 이 인터페이스의 소스 코드를 자동으로 만들어주면서 자동으로 올려주기에 이 인터페이스에는 annotation 이 붙지 않는다