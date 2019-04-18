package com.example.ex190418_mongodb.model.member.dao;

import java.util.List;

import com.example.ex190418_mongodb.model.member.dto.MemberDTO;


public interface MemberDAO {
	
	MemberDTO loginCheck(String userid, String passwd); // 로그인체크 함수
	void join(MemberDTO member); // 회원가입 함수
	
}
