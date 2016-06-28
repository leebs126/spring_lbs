package com.spring.ex5;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;


public class TranDao {
   private SqlSession sqlSession;    
   public void setSqlSession(SqlSession sqlSession){
      this.sqlSession = sqlSession;
   }
   
   public void insertMember() throws DataAccessException{
	   MemberBean bean=new MemberBean();
		/*bean.setId("hong");
		bean.setName("È«±æµ¿");
		bean.setHeight(186);
		bean.setWeight(77);
		bean.setAge(20);*/

	   
	   bean.setId("hong");
	   bean.setName("È«±æ¼ø");
	   bean.setHeight(166);
	   bean.setWeight(87);
	   bean.setAge(23);
	   
	   sqlSession.insert("mapper.member.insertData1",bean);
	   sqlSession.insert("mapper.member.insertData2",bean);
   }
}
