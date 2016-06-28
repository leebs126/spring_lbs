package ch7.ex7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	private DataSource dataFactory;
	
	public MemberDao(){
		try{
			Context ctx=new InitialContext();
			dataFactory=(DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean isExisted(MemberVO vo) {
		boolean result=false;
		String id=vo.getId();
		try{
		Connection con=dataFactory.getConnection();
		Statement stmt=con.createStatement();
		
		String query="select count(*) as num from t_member";
		query+= " where id='"+id+"'";
		
		System.out.println(query);
		ResultSet rs=stmt.executeQuery(query);
		rs.next();
		int num=rs.getInt("num");
		System.out.println("num="+num);
		if(num==1)
			result=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
