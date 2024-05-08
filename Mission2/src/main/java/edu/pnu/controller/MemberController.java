package edu.pnu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	MemberService service = new MemberService();

	@GetMapping("/members")
	public List<MemberVO> getAllMember() {
		return service.getAllMember();
	}
	
	@GetMapping("/member")
	public MemberVO getMemberById(Integer id) {
		return service.getMemberById(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		return service.addMember(memberVO);
	}
	
	@PutMapping("/member")
	public int updateMember(MemberVO memberVO) {
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
}
