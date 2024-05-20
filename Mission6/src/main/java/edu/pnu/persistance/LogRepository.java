package edu.pnu.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.Log;
import edu.pnu.domain.Member;

public interface LogRepository extends JpaRepository<Log, Integer> {
	
}
