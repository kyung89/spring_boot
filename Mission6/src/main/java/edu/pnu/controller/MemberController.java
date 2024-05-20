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

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;

	@GetMapping("/members")
	public List<Member> getAllMember() {
		return service.getAllMember();
	}
	
	@GetMapping("/member")
	public Member getMemberById(Integer id) {
		return service.getMemberById(id);
	}
	
	@PostMapping("/member")
	public Member addMember(@RequestBody Member member) {
		return service.addMember(member);
	}
	
	@PutMapping("/member")
	public Member updateMember(@RequestBody Member member) {
		return service.updateMember(member);
	}
	
	@DeleteMapping("/member")
	public void removeMember(Integer id) {
		service.removeMember(id);
	}
	
	@PostMapping("/memberJSON")
	public Member addMemberJSON(@RequestBody Member member) {
		return service.addMember(member);
	}
	
	/*
	@GetMapping("/board/{id}")
	public String board(@PathVariable Integer id) {
		System.out.println("id: " + id);
		
		return boardService.getBoard(id);
	}
	*/
}
