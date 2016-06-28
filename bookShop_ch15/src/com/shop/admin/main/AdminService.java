package com.shop.admin.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminService{
	
	AdminDao dao=new AdminDao();
	public String  addGoods(AGoodsVO goodsVO) throws SQLException{
		String goods_id=dao.getMaxGoodsId();  
		goodsVO.setGoods_id(goods_id);
		dao.addGoods(goodsVO);
		
		return goods_id;
	}
}
