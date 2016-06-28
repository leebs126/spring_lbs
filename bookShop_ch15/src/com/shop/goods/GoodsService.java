package com.shop.goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class GoodsService {
	GoodsDao dao = new GoodsDao();
	
	public HashMap<String,ArrayList<GoodsVO>> listGoods() throws Exception{
		HashMap<String,ArrayList<GoodsVO>> goodsMap=new HashMap<String,ArrayList<GoodsVO>>();
		ArrayList goodsList=dao.listGoods("bestseller");
		goodsMap.put("bestseller",goodsList);
		goodsList=dao.listGoods("newbook");
		goodsMap.put("newbook",goodsList);
		
		goodsList=dao.listGoods("steadyseller");
		goodsMap.put("steadyseller",goodsList);
		return goodsMap;
	}
		
	public HashMap goods_detail(String _goods_id) throws Exception {
		HashMap goodsMap=new HashMap();
		GoodsVO goodsVO = dao.goods_detail(_goods_id);
		goodsMap.put("goodsVO", goodsVO);
		ArrayList imageList =dao.goods_detail_image(_goods_id);
		goodsMap.put("imageList", imageList);
		
		return goodsMap;
	}
}
