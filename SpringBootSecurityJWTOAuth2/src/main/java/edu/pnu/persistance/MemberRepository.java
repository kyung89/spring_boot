package edu.pnu.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
