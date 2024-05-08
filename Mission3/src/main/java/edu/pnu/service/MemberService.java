package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {

	private MemberDao dao = new MemberDao();

	public MemberService() {
		
	}

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
