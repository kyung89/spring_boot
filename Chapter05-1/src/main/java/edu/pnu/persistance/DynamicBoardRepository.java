package edu.pnu.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import edu.pnu.domain.Board;

public interface DynamicBoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

}
