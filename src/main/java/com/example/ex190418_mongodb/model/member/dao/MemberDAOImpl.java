package com.example.ex190418_mongodb.model.member.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.example.ex190418_mongodb.model.member.dto.MemberDTO;

@Component("memberDao")
public class MemberDAOImpl implements MemberDAO {

	@Inject
	MongoTemplate mongoTemplate;
	static String COLLECTION_NAME = "member";
	
	@Override
	public MemberDTO loginCheck(String userid, String passwd) {
		// _id와 passwd가 같은 document(레코드)를 찾음
		Query query = new Query(new Criteria("_id").is(userid).and("passwd").is(passwd));
		
		// COLLECTION_NAME테이블의 query로 조회된 첫번째 document 값(get(0))을 MemberDTO.class 에 저장한다는 의미
		List<MemberDTO> list = mongoTemplate.find(query, MemberDTO.class, COLLECTION_NAME);
		
		if(list.size() > 0) {
			return list.get(0);
		}else {
			return null;			
		}

	}

	@Override
	public void join(MemberDTO member) {
		// document 저장
		mongoTemplate.insert(member, COLLECTION_NAME);

	}

}
