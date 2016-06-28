package com.shop.common.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shop.goods.ImageFileVO;

public class FileDao {
	private DataSource dataFactory;
	
	public FileDao() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addFile(HashMap fileMap){
		String goods_id=(String)fileMap.get("goods_id");
		ArrayList fileList=(ArrayList)fileMap.get("fileList");
		
		String query = "insert into t_goods_detail_image (goods_id,"+
													    "fileName,"+
													    "fileType,"+
													    "image_Id,"+
													    "id)";
													
		query+=" values(?,?,?,?,?)";
		System.out.println(query);
		try {
			Connection con = dataFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			
			for(int i=0; i<fileList.size();i++){
				ImageFileVO vo=(ImageFileVO)fileList.get(i);
				String fileName=vo.getFileName();
				String fileType=vo.getFileType();
				String image_id=getImageId();
				
				pstmt.setString(1,goods_id);
		    	pstmt.setString(2,fileName);
		    	pstmt.setString(3,fileType);
		    	pstmt.setString(4,image_id);
		    	pstmt.setString(5,"");
				pstmt.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private  String getImageId() throws SQLException{
		Connection con = dataFactory.getConnection();
		Statement stmt = con.createStatement();

		String query = "select nvl(max(to_number(image_id)),0)+1 from t_goods_detail_image";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		String goods_id=rs.getString(1);
		return goods_id;
	}	

}
