package ch12.ex3;

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

	public void insertMember(MemberBean m){
		try{
			 Connection con = dataFactory.getConnection();
			 Statement stmt = con.createStatement();
			 String id=m.getId();
			 String name = m.getName();
			String age  = m.getAge();
			String weight = m.getWeight();
			String height = m.getHeight();
			String  query = "insert into t_member(id,name,age,weight,height) values  (";
			          query = query + "'" + id +"' ,";
					  query = query + "'" + name +"' ,";
					  query = query +  age    +",";
					  query = query + "'" + weight    +"' ,";
					  query = query + "'" + height    +"') ";				
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
				String age = rs.getString("age");
				String weight = rs.getString("weight");
				String height = rs.getString("height");

		MemberBean  bean  = new MemberBean(id,name,age,weight,height);
					list.add(bean);
			}

			rs.close();
			stmt.close();
			con.close();
   }catch(Exception e){}
	   return  list;
	}//end showMember()
}