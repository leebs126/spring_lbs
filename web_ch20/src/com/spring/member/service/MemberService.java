package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberService {
	// �Խù� List
		public List getMemberList() throws DataAccessException;

		// ȸ������ insert
		public int insertMember(MemberVO memberVO) throws DataAccessException;

		// ȸ������ update
		public int updateMember(MemberVO memberVO, String num) throws DataAccessException;

		// ȸ������ delete
		public int deleteMember(String num, String password) throws DataAccessException;
}