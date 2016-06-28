package com.spring.ex3.member.service;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.spring.ex3.member.vo.MemberBean;


public interface MemberService {
	// 게시물 List
		public List getMemberList() throws DataAccessException;

		// 회원정보 insert
		public int addMember(MemberBean memberBean) throws DataAccessException;

		// 회원정보 update
		public int modMember(MemberBean memberBean, String num) throws DataAccessException;

		// 회원정보 delete
		public int delMember(String id) throws DataAccessException;
}