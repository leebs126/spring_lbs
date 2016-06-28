package com.spring.ex3.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.ex3.member.dao.MemberDao;
import com.spring.ex3.member.vo.MemberBean;

@Service("memberService")
public class MemberServiceImpl  implements MemberService{
	@Autowired
	private MemberDao memberDao;

	@Override
	public List getMemberList() throws DataAccessException {
		List boardList = null;
		boardList = memberDao.selectMemberList();
		return boardList;
	}

	@Override
	public int addMember(MemberBean memberBean) throws DataAccessException {
		return memberDao.insertMember(memberBean);
	}

	@Override
	public int modMember(MemberBean memberBean, String num) throws DataAccessException {
		return 0;
	}

	@Override
	public int delMember(String id) throws DataAccessException{
		return memberDao.deleteMember(id);
	}
}
