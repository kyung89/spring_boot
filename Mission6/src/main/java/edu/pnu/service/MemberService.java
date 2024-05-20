package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Log;
import edu.pnu.domain.Member;
import edu.pnu.persistance.LogRepository;
import edu.pnu.persistance.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private LogRepository logRepo;

	public MemberService() {
		
	}
	
	public Log generateLog(String method, String sqlstring, boolean success) {
		Log log = new Log();
		log.setMethod(method);
		log.setSqlString(sqlstring);
		log.setSuccess(success);
		log.setRegidate(new Date());
		return log;
	}

	public List<Member> getAllMember() {
		logRepo.save(generateLog("getAllMember()", "", true));
		return memberRepo.findAll();
	}

	public Member getMemberById(Integer id) {
		if(memberRepo.findById(id) == null) logRepo.save(generateLog("getMemberById(Integer id)", "", false));
		else logRepo.save(generateLog("getMemberById(Integer id)", "", true));
		return memberRepo.findById(id).get();
	}
	
	public Member addMember(Member member) {
		if(memberRepo.save(member) == null) logRepo.save(generateLog("addMember(MemberVO memberVO)", "", false));
		else logRepo.save(generateLog("addMember(MemberVO memberVO)", "", true));
		return memberRepo.save(member);
	}
	
	public Member updateMember(Member member) {
		if(memberRepo.save(member) == null) logRepo.save(generateLog("updateMember(MemberVO memberVO)", "", false));
		else logRepo.save(generateLog("updateMember(MemberVO memberVO)", "", true));
		return memberRepo.save(member);
	}
	
	public void removeMember(Integer id) {
		logRepo.save(generateLog("removeMember(Integer id)", "", true));
		memberRepo.deleteById(id);
	}
}
