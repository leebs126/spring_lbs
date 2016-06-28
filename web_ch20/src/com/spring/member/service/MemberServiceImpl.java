package com.spring.member.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDao;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl  implements MemberService{
	protected final Log logger = LogFactory.getLog(getClass());
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	@Override
	public List getMemberList() throws DataAccessException {
		List boardList = null;
		boardList = memberDao.selectMemberList();
		return boardList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		return memberDao.insertMember(memberVO);
	}

	@Override
	public int updateMember(MemberVO memberVO, String num) throws DataAccessException {
		return 0;
	}

	@Override
	public int deleteMember(String num, String password) throws DataAccessException {
		return 0;
	}
}
