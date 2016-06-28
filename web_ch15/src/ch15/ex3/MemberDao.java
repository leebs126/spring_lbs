package ch15.ex3;

import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;

public class MemberDao {
    
	private DataSource dataFactory;
	
    public MemberDao(){
		try{
				Context ctx = new InitialContext();
				dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		}catch( Exception e){
			e.printStackTrace();
		}
	}

	public void insertMember(MemberVO m){
		try{
			 Connection con = dataFactory.getConnection();
			 Statement stmt = con.createStatement();
			 String id=m.getId();
			 String name = m.getName();
			 int age  = m.getAge();
			 int weight = m.getWeight();
			 int height = m.getHeight();
			String  query = "insert into t_member(id,name,age,weight,height) values  (";
			          query += "'" + id +"' ,";
					  query += "'" + name +"' ,";
					  query +=  age    +",";
					  query += "'" + weight    +"' ,";
					  query += "'" + height    +"') ";				
			System.out.println(query); 
			stmt.executeUpdate(query);
			 stmt.close();
			 con.close();

			}catch(SQLException e1){
				e1.printStackTrace();
            } 
	}//end insertMember()

	public ArrayList  listMember(){
		   ArrayList  list  = new ArrayList();
		   try{
			 Connection con = dataFactory.getConnection();
			 Statement stmt = con.createStatement();
			String query = "select * from  t_member";
			System.out.println(query); 
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String id=rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int weight = rs.getInt("weight");
				int  height = rs.getInt("height");

				MemberVO  vo  = new MemberVO(id,name,height,weight,age);
				list.add(vo);
			}

			rs.close();
			stmt.close();
			con.close();
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return  list;
	}//end insertMember()
	
	public MemberVO selectMember(String _id){
		MemberVO memVO=null;
		try{
			Connection con = dataFactory.getConnection();
			 Statement stmt = con.createStatement();
			String query = "select * from  t_member";
					query+=" where id='"+_id+"'";
			System.out.println(query); 
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			String id=rs.getString("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			int weight = rs.getInt("weight");
			int  height = rs.getInt("height");
			 memVO  = new MemberVO(id,name,age,weight,height);
		}catch(Exception e){
			e.printStackTrace();
		}
		return memVO;
	}
	
	public void modMember(MemberVO vo){
		
		String id=vo.getId();
		String name=vo.getName();
		int age=vo.getAge();
		int weight=vo.getWeight();
		int height=vo.getHeight();
		try{
			
		   Connection con = dataFactory.getConnection();
		   Statement stmt = con.createStatement();
	       String query = "update t_member";
	    		   query+=" set name='"+name+"',";
	       			query+=" age="+age+",";
	       			query+=" weight="+weight+",";
	       			query+=" height="+height;
					query+= " where id='"+id+"'";
			System.out.println(query);
			stmt.executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void delMember(String id){
		try{
			 Connection con = dataFactory.getConnection();
			 Statement stmt = con.createStatement();
			String query = "delete from t_member";
					query+= " where id='"+id+"'";
			System.out.println(query); 
			stmt.executeUpdate(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}