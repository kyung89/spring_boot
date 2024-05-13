package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;

	@GetMapping("/members")
	public List<MemberVO> getAllMember() {
		return service.getAllMember();
	}
	
	@GetMapping("/member")
	public MemberVO getMemberById(Integer id) {
		return service.getMemberById(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(@RequestBody MemberVO memberVO) {
		return service.addMember(memberVO);
	}
	
	@PutMapping("/member")
	public int updateMember(@RequestBody MemberVO memberVO) {
		return service.updateMember(memberVO);
	}
	
	@DeleteMapping("/member")
	public int removeMember(Integer id) {
		return service.removeMember(id);
	}
	
	@PostMapping("/memberJSON")
	public MemberVO addMemberJSON(@RequestBody MemberVO memberVO) {
		return service.addMember(memberVO);
	}
	
	/*
	@GetMapping("/board/{id}")
	public String board(@PathVariable Integer id) {
		System.out.println("id: " + id);
		
		return boardService.getBoard(id);
	}
	*/
}
