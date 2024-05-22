package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seq;
	
	private String title;
	
	@Column(updatable=false)
	private String writer;
	
	private String content;
	
	@Builder.Default
	@Column(insertable=false, updatable=false, columnDefinition="date default (curdate())") // Oracle 에서는 sysdate
	private Date createDate = new Date();
	@Builder.Default
	@Column(insertable=false, updatable=false, columnDefinition="number default 0")
	private Long cnt = 0L;
}
