package com.spring.ex4.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.ex4.member.vo.MemberBean;


public interface MemberDao {
		// ȸ����� ����
			public List selectMemberList() throws DataAccessException;
			// ȸ�� �߰��ϱ�
			public int insertMember(MemberBean memberBean) throws DataAccessException;
			// ȸ������
			public int deleteMember(String id) throws DataAccessException;
			
			
}
