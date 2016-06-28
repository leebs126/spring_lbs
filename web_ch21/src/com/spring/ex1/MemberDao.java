package com.spring.ex1;

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
				
			 
	    try{
	    	memlist=session.selectList("mapper.member.selectAllMemberList");
		}catch(Exception e){
			e.printStackTrace();
		}
	    return memlist;		
	}
}
