package com.spring.ex2;

import java.util.*;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDao   {
	public static SqlSessionFactory sqlMapper = null;
	
	public static SqlSessionFactory getInstance(){
		if(sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}		
	
	public List<MemberBean> selectMemberAllList(){
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		 List<MemberBean>	memlist=null;
	    	memlist=session.selectList("mapper.member.selectAllMemberList");
	    return memlist;		
	}
	
	public MemberBean selectMember(String id){
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
	    	MemberBean bean=(MemberBean)session.selectOne("mapper.member.selectMember",id);
	    return bean;		
	}
	
	public int insertMember(MemberBean bean){
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result=0;	 
	    result=session.insert("mapper.member.insertMember",bean);
	    session.commit();	
	    return result;		
	}
	
	public int insertMember(HashMap<String,String> memberMap){
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result=0;	 
	    result=session.insert("mapper.member.insertMember2",memberMap);
	    session.commit();	
	    return result;		
	}	
	
	public int updatetMember(MemberBean bean){
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result=0;	 
	    result=session.update("mapper.member.updateMember",bean);
	    session.commit();	
	    return result;		
	}	

	public int delMember(MemberBean bean){
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result=0;	 
	    result=session.update("mapper.member.delMember",bean);
	    session.commit();	
	    return result;		
		
		
	}	
}
