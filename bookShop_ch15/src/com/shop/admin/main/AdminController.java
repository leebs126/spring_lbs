package com.shop.admin.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/admin/admin.do")
public class AdminController extends HttpServlet {
	AdminService service=new AdminService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doHandle(request, response);
		} catch( Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doHandle(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doHandle(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException ,SQLException{
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String type = request.getParameter("type");
		HttpSession session=request.getSession();
		session.setAttribute("side_menu", "admin_mode");
		request.setAttribute("command", command);
		if(command == null || command.equals("manage_goods")) {
		
		}else if(command.equals("add_goods_page")){
		
		}else if(command.equals("add_goods")){
			String goods_sort = request.getParameter("goods_sort");
			String goods_title=request.getParameter("goods_title");
			String goods_writer=request.getParameter("goods_writer");
			String goods_publisher=request.getParameter("goods_publisher");
			String goods_price=request.getParameter("goods_price");
			
			String goods_sales_price=request.getParameter("goods_sales_price");
			String goods_point=request.getParameter("goods_point");
			String goods_published_date=request.getParameter("goods_published_date");
			String goods_page_total=request.getParameter("goods_page_total");
			String goods_isbn=request.getParameter("goods_isbn");
			
			String goods_delivery_date=request.getParameter("goods_delivery_date");
			String goods_type=request.getParameter("goods_type");
			String goods_contents_order = request.getParameter("goods_contents_order");
			String goods_recommendation =request.getParameter("goods_recommendation");
			
			String goods_writer_intro=request.getParameter("goods_writer_intro");
			String goods_intro=request.getParameter("goods_intro");
			String goods_publisher_comment=request.getParameter("goods_publisher_comment");
			
			
			AGoodsVO goodsVO=new AGoodsVO();
			goodsVO.setGoods_sort(goods_sort);
			goodsVO.setGoods_title(goods_title);
			goodsVO.setGoods_writer(goods_writer);
			goodsVO.setGoods_publisher(goods_publisher);
			goodsVO.setGoods_price(Integer.parseInt(goods_price));
			
			goodsVO.setGoods_sales_price(Integer.parseInt(goods_sales_price));
			goodsVO.setGoods_point(Integer.parseInt(goods_point));
			goodsVO.setGoods_published_date(goods_published_date);
			goodsVO.setGoods_page_total(Integer.parseInt(goods_page_total));
			goodsVO.setGoods_isbn(goods_isbn);
			
			goodsVO.setGoods_delivery_date(goods_delivery_date);
			goodsVO.setGoods_type(goods_type);
			goodsVO.setGoods_contents_order(goods_contents_order);
			goodsVO.setGoods_recommendation(goods_recommendation);
			
			goodsVO.setGoods_writer_intro(goods_writer_intro);
			goodsVO.setGoods_intro(goods_intro);
			goodsVO.setGoods_publisher_comment(goods_publisher_comment);
			
			String goods_id=service.addGoods(goodsVO);
			
			request.setAttribute("goods_id",goods_id);
			request.setAttribute("command", "add_goods_imagefile");
		}else if(command.equals("add_goods_imagefile")){
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("/jsp/admin/main/admin_page.jsp");
		dis.forward(request, response);
	}
}

