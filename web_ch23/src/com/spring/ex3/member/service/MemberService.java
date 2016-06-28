package com.spring.ex3.member.service;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.spring.ex3.member.vo.MemberBean;


public interface MemberService {
	// �Խù� List
		public List getMemberList() throws DataAccessException;

		// ȸ������ insert
		public int addMember(MemberBean memberBean) throws DataAccessException;

		// ȸ������ update
		public int modMember(MemberBean memberBean, String num) throws DataAccessException;

		// ȸ������ delete
		public int delMember(String id) throws DataAccessException;
}