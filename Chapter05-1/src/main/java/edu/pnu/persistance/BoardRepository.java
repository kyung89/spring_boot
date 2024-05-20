package edu.pnu.persistance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	List<Board> findByTitle(String searchKeyword);
	
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	List<Board> findByContentContaining(String searchKeyword);
	
	List<Board> findByContentContaining(String searchKeyword, Pageable paging);
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	List<Board> findByTitleContaining(String searchKeyword);
	
	List<Board> findByTitleContainingAndCntGreaterThan(String searchKeyword, int cnt);
	
	List<Board> findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(int greater, int less);
	
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	
	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC") // Board: 클래스 Board 와 같아야 한다 대소문자 구분함
	List<Board> queryAnnotationTest1(String searchKeyword);
	
	@Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest2(String searchKeyword);
	
	@Query("SELECT b.seq, b.title, b.member, b.createDate FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	
	@Query(value="select seq, member, create_date from board where title like '%'||?1||'%' order by seq desc", nativeQuery=true)
	List<Object[]> queryAnnotationTest4(String searchKeyword);

}
 // 하이버네이트가 이 인터페이스의 소스 코드를 자동으로 만들어주면서 자동으로 올려주기에 이 인터페이스에는 annotation 이 붙지 않는다