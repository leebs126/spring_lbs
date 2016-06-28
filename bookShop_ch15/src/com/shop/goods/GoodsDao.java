package com.shop.goods;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GoodsDao {
	private DataSource dataFactory;

	public GoodsDao() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList listGoods(String goodsType) throws Exception {
		ArrayList list = new ArrayList();
		Connection con = dataFactory.getConnection();
		Statement stmt = con.createStatement();

		String query="select g.*,d.fileName from t_goods_info g, t_goods_detail_image d";
        query+=" where ";
        query+="g.goods_id=d.goods_id ";
        query+=" and d.filetype='main_image'" ;
        query+=" and g.goods_type='"+goodsType+"'";
        query+=" order by g.goods_creDate desc";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			String goods_id = rs.getString("goods_id");
			String goods_sort = rs.getString("goods_sort");
			String goods_title = rs.getString("goods_title");
			String goods_writer = rs.getString("goods_writer");
			int goods_price = rs.getInt("goods_price");
			String goods_publisher = rs.getString("goods_publisher");
			String goods_type = rs.getString("goods_type");
			String goods_fileName = rs.getString("fileName");

			GoodsVO goods = new GoodsVO();
			goods.setGoods_id(goods_id);
			goods.setGoods_sort(goods_sort);
			goods.setGoods_title(goods_title);
			goods.setGoods_writer(goods_writer);
			goods.setGoods_price(goods_price);
			goods.setGoods_publisher(goods_publisher);
			goods.setGoods_type(goods_type);
			goods.setGoods_fileName(goods_fileName);
			list.add(goods);
		}

		rs.close();
		stmt.close();
		con.close();

		return list;
	}

	
	public GoodsVO goods_detail(String _goods_id) throws Exception {
		GoodsVO goodsVO = new GoodsVO();
		Connection con = dataFactory.getConnection();
		Statement stmt = con.createStatement();

		String query="select g.*,d.fileName from t_goods_info g, t_goods_detail_image d";
               query+=" where ";
               query+="g.goods_id=d.goods_id ";
               query+=" and d.filetype='main_image'" ;
               query+=" and g.goods_id="+_goods_id;
               query+=" order by g.goods_id";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
		String goods_id = rs.getString("goods_id");
		String goods_sort = rs.getString("goods_sort");
		String goods_title = rs.getString("goods_title");
		String goods_writer = rs.getString("goods_writer");
		int goods_price = rs.getInt("goods_price");
		String goods_publisher = rs.getString("goods_publisher");
		int goods_sales_price = rs.getInt("goods_sales_price");
		int goods_point = rs.getInt("goods_point");
		String goods_published_date = rs.getString("goods_published_date");
		int goods_page_total=rs.getInt("goods_total_page");
		String goods_isbn=rs.getString("goods_isbn");
		String goods_delivery_price=rs.getString("goods_delivery_price");
		String goods_delivery_date=rs.getString("goods_delivery_date");
		String goods_writer_intro = rs.getString("goods_writer_intro");
		String goods_contents_order= rs.getString("goods_contents_order");
		String goods_intro=rs.getString("goods_intro");
		String goods_fileName=rs.getString("fileName");
		String goods_publisher_comment=rs.getString("goods_publisher_comment");
		String goods_recommendation=rs.getString("goods_recommendation");

		goodsVO.setGoods_id(goods_id);
		goodsVO.setGoods_sort(goods_sort);
		goodsVO.setGoods_title(goods_title);
		goodsVO.setGoods_writer(goods_writer);
		goodsVO.setGoods_price(goods_price);
		goodsVO.setGoods_id(goods_id);
		goodsVO.setGoods_publisher(goods_publisher);
		goodsVO.setGoods_point(goods_point);
		goodsVO.setGoods_published_date(goods_published_date);
		goodsVO.setGoods_page_total(goods_page_total);
		goodsVO.setGoods_isbn(goods_isbn);
		goodsVO.setGoods_delivery_price(goods_delivery_price);
		goodsVO.setGoods_delivery_date(goods_delivery_date);
		goodsVO.setGoods_contents_order(goods_contents_order);
		goodsVO.setGoods_writer_intro(goods_writer_intro);
		goodsVO.setGoods_intro(goods_intro);
		goodsVO.setGoods_fileName(goods_fileName);
		goodsVO.setGoods_recommendation(goods_recommendation);
		goodsVO.setGoods_publisher_comment(goods_publisher_comment);

		}
		return goodsVO;
	}
	
	public ArrayList goods_detail_image(String _goods_id) throws Exception {
		ArrayList imageList=new ArrayList();
		Connection con = dataFactory.getConnection();
		Statement stmt = con.createStatement();

		String query = "select * from t_goods_detail_image where goods_id='"+_goods_id+"'";
				query+=" and fileType!='main_image'";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			String image=rs.getString("fileName");
			ImageFileVO imageVO=new ImageFileVO();
			imageVO.setFileName(image);
			imageList.add(imageVO);
		}
		return imageList;
		
	}

}
