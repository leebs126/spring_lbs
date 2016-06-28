package ch15.ex2;

import java.sql.*;
import java.util.*;
import javax.sql.*;

import ch15.ex3.MemberVO;

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
   }catch(Exception e){}
	   return  list;
	}//end insertMember()
}