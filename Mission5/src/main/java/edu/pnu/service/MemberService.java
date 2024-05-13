package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	@Autowired
	private LogDao logDao;

	public MemberService() {
		
	}

	public List<MemberVO> getAllMember() {
		logDao.addLog("getAllMember()", "", true);
		return dao.getAllMember();
	}

	public MemberVO getMemberById(Integer id) {
		if(dao.getMemberById(id) == null) logDao.addLog("getMemberById(Integer id)", "", false);
		else logDao.addLog("getMemberById(Integer id)", "", true);
		return dao.getMemberById(id);
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		if(dao.addMember(memberVO) == null) logDao.addLog("addMember(MemberVO memberVO)", "", false);
		else logDao.addLog("addMember(MemberVO memberVO)", "", true);
		return dao.addMember(memberVO);
	}
	
	public int updateMember(MemberVO memberVO) {
		if(dao.updateMember(memberVO) == 0) logDao.addLog("updateMember(MemberVO memberVO)", "", false);
		else logDao.addLog("updateMember(MemberVO memberVO)", "", true);
		return dao.updateMember(memberVO);
	}
	
	public int removeMember(Integer id) {
		if(dao.removeMember(id) == 0) logDao.addLog("removeMember(Integer id)", "", false);
		else logDao.addLog("removeMember(Integer id)", "", true);
		return dao.removeMember(id);
	}
}
