package com.example.ex190418_mongodb.service.member;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.ex190418_mongodb.model.member.dao.MemberDAO;
import com.example.ex190418_mongodb.model.member.dto.MemberDTO;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO memberDao;

	@Override
	public MemberDTO loginCheck(String userid, String passwd) {
		return memberDao.loginCheck(userid, passwd);
	}

	@Override
	public void join(MemberDTO member) {
		memberDao.join(member);
	}

}
