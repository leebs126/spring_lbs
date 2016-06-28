package ch13.ex4;

import java.sql.*;
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

	public boolean overlapedId(String id){
		 Connection con=null;
		 Statement stmt=null;
		 ResultSet rs=null;
		boolean isOverlapped=false;
		 try{
			 con = dataFactory.getConnection();
			 stmt = con.createStatement();
			String query = "select count(*) from  t_member where id='"+id+"'";
			System.out.println(query); 
			rs=stmt.executeQuery(query);
			rs.next();
			int count=rs.getInt(1);
			if(count==1)
				isOverlapped=true;
			 rs.close();
			 stmt.close();
			con.close();
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return isOverlapped;
   }
}