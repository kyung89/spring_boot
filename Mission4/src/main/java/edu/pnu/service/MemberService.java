package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {

	private MemberDao dao = new MemberDao();
	private LogDao logDao = new LogDao();

	public MemberService() {
		
	}

	public List<MemberVO> getAllMember() {
		logDao.addLog("getAllMember()", null, true);
		return dao.getAllMember();
	}

	public MemberVO getMemberById(Integer id) {
		if(dao.getMemberById(id) == null) logDao.addLog("getMemberById(Integer id)", null, false);
		else logDao.addLog("getMemberById(Integer id)", null, true);
		return dao.getMemberById(id);
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		if(dao.addMember(memberVO) == null) logDao.addLog("addMember(MemberVO memberVO)", null, false);
		else logDao.addLog("addMember(MemberVO memberVO)", null, true);
		return dao.addMember(memberVO);
	}
	
	public int updateMember(MemberVO memberVO) {
		if(dao.updateMember(memberVO) == 0) logDao.addLog("updateMember(MemberVO memberVO)", null, false);
		else logDao.addLog("updateMember(MemberVO memberVO)", null, true);
		return dao.updateMember(memberVO);
	}
	
	public int removeMember(Integer id) {
		if(dao.removeMember(id) == 0) logDao.addLog("removeMember(Integer id)", null, false);
		else logDao.addLog("removeMember(Integer id)", null, true);
		return dao.removeMember(id);
	}
}
