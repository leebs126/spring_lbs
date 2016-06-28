package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberService {
	// 게시물 List
		public List getMemberList() throws DataAccessException;

		// 회원정보 insert
		public int insertMember(MemberVO memberVO) throws DataAccessException;

		// 회원정보 update
		public int updateMember(MemberVO memberVO, String num) throws DataAccessException;

		// 회원정보 delete
		public int deleteMember(String num, String password) throws DataAccessException;
}