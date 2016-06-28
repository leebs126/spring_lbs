package com.shop.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/goods/goods.do")
public class GoodsController extends HttpServlet {
	String command;
	GoodsVO goodsVO;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doHandle(request,response);
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doHandle(request,response);
	}

	
	public void doHandle(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.setCharacterEncoding("utf-8");
		try{
			GoodsService service=new GoodsService();
			command = request.getParameter("command");
			String type=request.getParameter("type");
			System.out.println("command:" + command);
			System.out.println("type:" + type);
			if (command.equals("goods_main")) {
					HashMap<String,ArrayList<GoodsVO>> goodsMap=service.listGoods();
					request.setAttribute("goodsMap", goodsMap);
			}else if (command.equals("goods_detail")){
				String goods_id = request.getParameter("goods_id");
				HashMap goodsMap=service.goods_detail(goods_id);
				request.setAttribute("goodsMap",goodsMap);
		   }
			request.setAttribute("command", command);
			RequestDispatcher dis=request.getRequestDispatcher("/jsp/goods/goods_page.jsp");
			dis.forward(request,response);
		
		}catch(Exception e){
			e.printStackTrace();
		}
				
	}
	

}
