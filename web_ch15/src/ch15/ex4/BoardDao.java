/*
���ϸ�:BoardDAO2.java

*/

package ch15.ex4;

import javax.sql.*;


import javax.naming.*;
import java.sql.*;
import java.util.*;

public class BoardDao{
	private DataSource dataFactory;
	public BoardDao(){
		try{
				Context  ctx = new InitialContext();
				dataFactory = ( DataSource)ctx.lookup( "java:comp/env/jdbc/Oracle11g" );
		}catch( Exception e){
			e.printStackTrace();
		}
	}//end BoardDAO
	public ArrayList listWrite(){
		ArrayList list = new ArrayList();	
		
		try{
			
			Connection con = dataFactory.getConnection();
			Statement stmt = con.createStatement();
			String query ="select group_id,  "
					     +"parent_id,"
                         +"msg_id,"
                         +"author,"
                         +"email,"
                         +"title,"
                         +"content,"
                         +"passwd,"
                         +"writeday"
                         +" from t_board" 
                         +" order by group_id desc ,parent_id asc,writeday desc";
			ResultSet rs =stmt.executeQuery( query);
			while(rs.next()){
				int group_id =rs.getInt("group_id");
				int msg_id =rs.getInt("msg_id");
				int parent_id=rs.getInt("parent_id");
				String  author = rs.getString("author");
				String title = rs.getString("title");
				String email = rs.getString("email");
				String content =rs.getString("content");
				Timestamp writeday = rs.getTimestamp("writeday");
				
				WriteVO msg = new WriteVO();
				msg.setGroup_id(group_id);
				msg.setMsg_id( msg_id);
				msg.setParent_id(parent_id);
				msg.setAuthor( author);
				msg.setTitle(title);
				msg.setEmail( email);
				msg.setContent(content);;
				msg.setWriteday(writeday);
				
				list.add(msg);	
			} //end while
		rs.close();
		stmt.close();
		con.close();		
		}catch(Exception e){
			e.printStackTrace();	
		}
		return list;
	} //end listBoard()
	
	public int getNewMsgId(){
		try{
			Connection con = dataFactory.getConnection();
			Statement stmt = con.createStatement();

			String query = "SELECT  max(msg_id) from t_board ";
				System.out.println(query);
			ResultSet rs =stmt.executeQuery( query);
			if(rs.next())
				return (rs.getInt(1) + 1);
				rs.close();
				stmt.close();
				con.close();
			
		}	catch(Exception e){
			e.printStackTrace();	
		}
		return 0;
	}//end getNewMsgId()
	
	public int getNewGroupId(){
		try{
			Connection con = dataFactory.getConnection();
			Statement stmt = con.createStatement();

			String query = "SELECT  max(group_id) from t_board ";
				System.out.println(query);
			ResultSet rs =stmt.executeQuery( query);
			if(rs.next())
				return (rs.getInt(1) + 1);
			
				rs.close();
				stmt.close();
				con.close();
			
		}	catch(Exception e){
			e.printStackTrace();	
		}
		return 0;
	}//
	
	public String makeField(String str){
		return "'" + str +"'";	
	}
	
	public void writeBoard(WriteVO writeVO){
		try{
			Connection con = dataFactory.getConnection();
			Statement stmt = con.createStatement();
			String query = "INSERT INTO t_board (msg_id,group_id,parent_id, author, email, title, content, passwd,imageFile) VALUES (";	
					query +=writeVO.getMsg_id() + ",";
					query +=writeVO.getGroup_id() + ",";
					query +=writeVO.getParent_id() + ",";
					query +=makeField(writeVO.getAuthor() ) +",";
					query +=makeField(writeVO.getEmail() ) +",";
					query +=makeField(writeVO.getTitle() ) +",";
					query +=makeField(writeVO.getContent() ) +",";
					query +=makeField(writeVO.getPasswd()) + ",";
					query +=makeField(writeVO.getImageFile()) + ")";
					stmt.executeUpdate( query);
					stmt.close();
					con.close();
				   System.out.println(query);
		}catch(Exception e){
			e.printStackTrace();	
		}
	
	}//end write()
	
	
	public WriteVO viewWrite(String _msg_id){
		WriteVO msg=new WriteVO();
		try{
			Connection con = dataFactory.getConnection();
			Statement stmt = con.createStatement();
			String query ="select group_id,"
				    +"parent_id,"
                    +"msg_id,"
                    +"author,"
                    +"email,"
                    +"title,"
                    +"content,"
                    +"passwd,"
                    +"imageFile,"
                    +"writeday"
                    +" from t_board" 
                    +" where msg_id="+_msg_id;
				System.out.println(query);
			ResultSet rs =stmt.executeQuery( query);
			rs.next();
			int group_id =rs.getInt("group_id");
			int msg_id =rs.getInt("msg_id");
			int parent_id=rs.getInt("parent_id");
			String  author = rs.getString("author");
			String title = rs.getString("title");
			String email = rs.getString("email");
			String content =rs.getString("content");
			String imageFile =rs.getString("imageFile");
			Timestamp writeday = rs.getTimestamp("writeday");
			
			msg.setGroup_id(group_id);
			msg.setMsg_id( msg_id);
			msg.setParent_id(parent_id);
			msg.setAuthor( author);
			msg.setTitle(title);
			msg.setEmail( email);
			msg.setContent(content);
			msg.setImageFile(imageFile);
			msg.setWriteday(writeday);
			
			rs.close();
			stmt.close();
			con.close();
			
		}	catch(Exception e){
			e.printStackTrace();	
		}
		return msg;
	}
	
	public void writeReply(WriteVO writeVO) {
		try{
			Connection con = dataFactory.getConnection();
			Statement stmt = con.createStatement();
			String query = "INSERT INTO t_board (msg_id,group_id,parent_id, author, email, title, content, passwd) values (";	
					query +=writeVO.getMsg_id() + ",";
					query +=writeVO.getGroup_id() + ",";
					query +=writeVO.getParent_id() + ",";
					query +=makeField(writeVO.getAuthor() ) +",";
					query +=makeField(writeVO.getEmail() ) +",";
					query +=makeField(writeVO.getTitle() ) +",";
					query +=makeField(writeVO.getContent() ) +",";
					query +=makeField(writeVO.getPasswd()) + ")";
					stmt.executeUpdate( query);
					stmt.close();
					con.close();
						System.out.println(query);
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
}
