package com.spring.member.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberBean;



public interface MemberDao {
		// 회원목록 보기
			public List selectMemberList() throws DataAccessException;
			// 회원 추가하기
			public int insertMember(MemberBean memberBean) throws DataAccessException;
			// 회원삭제
			public int deleteMember(String id) throws DataAccessException;
			
			
}
