package com.shop.main;

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

import com.shop.goods.GoodsDao;
import com.shop.goods.GoodsService;
import com.shop.goods.GoodsVO;

@WebServlet("/main/main.do")
public class MainController extends HttpServlet {
	GoodsDao goodsDAO;
	HttpSession session;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doHandle(request,response);
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doHandle(request,response);
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		session=request.getSession();
		session.setAttribute("side_menu", "user");
		GoodsService service = new GoodsService();
		ArrayList goods_list;
		try {
			HashMap<String,ArrayList<GoodsVO>> goodsMap=service.listGoods();
			request.setAttribute("goodsMap", goodsMap);

			RequestDispatcher dis = request.getRequestDispatcher("/jsp/main/index.jsp");
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
