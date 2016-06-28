package com.spring.ex4.member.service;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.spring.ex4.member.vo.MemberBean;


public interface MemberService {
	// �Խù� List
		public List getMemberList() throws DataAccessException;

		// ȸ������ insert
		public int insertMember(MemberBean memberBean) throws DataAccessException;

		// ȸ������ update
		public int updateMember(MemberBean memberBean, String num) throws DataAccessException;

		// ȸ������ delete
		public int deleteMember(String id) throws DataAccessException;
}