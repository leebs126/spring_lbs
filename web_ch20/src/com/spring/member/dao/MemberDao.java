package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDao {
	// �۸�� ����
			public List selectMemberList() throws DataAccessException;
			// �� �߰��ϱ�
			public int insertMember(MemberVO memberVO) throws DataAccessException;
			// �ۼ���
			/*	public int updateBoard(Board board, String num) throws DataAccessException;
			// �ۻ���
			public int deleteBoard(String num, String password) throws DataAccessException;
			// �� ���� ����
			public Board viewContents(String num) throws DataAccessException; 
			
*/
			
}
