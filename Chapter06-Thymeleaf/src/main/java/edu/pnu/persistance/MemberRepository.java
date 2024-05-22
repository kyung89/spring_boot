package edu.pnu.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
