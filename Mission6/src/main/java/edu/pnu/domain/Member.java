package edu.pnu.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

	@Id
	@Column(name="MEMBER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pass;
	private String name;
	private Date regidate;
	
	//@ToString.Exclude // 나중에 JPA 사용하면 @JpaEgnore 사용
	//@OneToMany(mappedBy="member", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	//private List<Board> boardList = new ArrayList<Board>();
}
