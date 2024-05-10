package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;

	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	public MemberVO getMemberById(Integer id) {
		return dao.getMemberById(id);
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		return dao.addMember(memberVO);
	}
	
	public int updateMember(MemberVO memberVO) {
		return dao.updateMember(memberVO);
	}
	
	public int removeMember(Integer id) {
		return dao.removeMember(id);
	}
}
