package com.spring.ex4.member.dao;

import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.ex4.member.vo.MemberBean;

public class MemberDaoImpl implements MemberDao {
   private SqlSession sqlSession;    
    public void setSqlSession(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }
	
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
