package com.shop.admin.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.jdbc.OracleResultSet;
import oracle.sql.CLOB;

public class AdminDao {
	private DataSource dataFactory;

	public AdminDao() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void addGoods(AGoodsVO goodsVO) throws SQLException {
		Connection con = dataFactory.getConnection();
		Statement stmt = con.createStatement();

		String query = "insert into t_Goods_info (goods_id,"+
													"goods_sort,"+
													"goods_title,"+
													"goods_writer,"+
													"goods_publisher,"+
													
													"goods_price,"+
													"goods_sales_price,"+
													"goods_point,"+
													"goods_published_date,"+
													"GOODS_total_page,"+
													
													"goods_isbn,"+
													"goods_delivery_price,"+  
													"goods_delivery_date,"+
													"goods_type,"+
													
													"goods_writer_intro,"+
													"goods_intro,"+
													"goods_publisher_comment,"+
													"goods_recommendation,"+
													"goods_contents_order)";
			query+=" values('"+
					goodsVO.getGoods_id()+"','"+
					goodsVO.getGoods_sort()+"','"+
					goodsVO.getGoods_title()+"','"+
					goodsVO.getGoods_writer()+"','"+
					goodsVO.getGoods_publisher()+"',"+
					
					goodsVO.getGoods_price()+","+
					goodsVO.getGoods_sales_price()+","+
					goodsVO.getGoods_point()+",'"+
					goodsVO.getGoods_published_date()+"',"+
					goodsVO.getGoods_page_total()+",'"+
					
					goodsVO.getGoods_isbn()+"',"+
					goodsVO.getGoods_delivery_price()+",'"+
					goodsVO.getGoods_delivery_date()+"','"+
					goodsVO.getGoods_type()+"','"+
					
					goodsVO.getGoods_writer_intro()+"','"+
					goodsVO.getGoods_intro()+"','"+
					goodsVO.getGoods_publisher_comment()+"','"+
					goodsVO.getGoods_recommendation()+"','"+
					goodsVO.getGoods_contents_order()+"')";
			System.out.println(query);
			stmt.executeUpdate(query);
			String goods_id=goodsVO.getGoods_id();

	}
	
	
	public String getMaxGoodsId() throws SQLException{
		Connection con = dataFactory.getConnection();
		Statement stmt = con.createStatement();

		String query = "select nvl(max(to_number(goods_id)),0)+1 from t_goods_info";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		String goods_id=rs.getString(1);
		
		return goods_id;
	}
}
