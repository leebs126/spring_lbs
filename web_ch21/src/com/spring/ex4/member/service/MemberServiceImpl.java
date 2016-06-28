package com.spring.ex4.member.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.spring.ex4.member.dao.MemberDao;
import com.spring.ex4.member.vo.MemberBean;


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
	public int insertMember(MemberBean memberBean) throws DataAccessException {
		return memberDao.insertMember(memberBean);
	}

	@Override
	public int updateMember(MemberBean memberBean, String num) throws DataAccessException {
		return 0;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException{
		return memberDao.deleteMember(id);
	}
}
