package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDao {
	// 글목록 보기
			public List selectMemberList() throws DataAccessException;
			// 글 추가하기
			public int insertMember(MemberVO memberVO) throws DataAccessException;
			// 글수정
			/*	public int updateBoard(Board board, String num) throws DataAccessException;
			// 글삭제
			public int deleteBoard(String num, String password) throws DataAccessException;
			// 글 내용 보기
			public Board viewContents(String num) throws DataAccessException; 
			
*/
			
}
