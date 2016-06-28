package com.spring.ex3.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.ex3.member.vo.MemberBean;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;    
	
	@Override
	public List selectMemberList() throws DataAccessException {
		 List<MemberBean>	memlist=null;
		    memlist=sqlSession.selectList("mapper.member.selectAllMemberList");
		    return memlist;		
	}

	@Override
	public int insertMember(MemberBean memberBean) throws DataAccessException {
		int result=0;	 
	    result=sqlSession.insert("mapper.member.insertMember",memberBean);
	    return result;	
	}
	
	public int deleteMember(String id) throws DataAccessException{
		int result=0;	 
	    result=sqlSession.insert("mapper.member.deleteMember",id);
	    return result;
	}
}
