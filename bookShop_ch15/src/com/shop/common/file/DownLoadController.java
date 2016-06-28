package com.shop.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class DownLoadController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException,IOException{
		doHandle(request, response);
		}
		
		protected void doPost(HttpServletRequest request,HttpServletResponse response)
		  throws ServletException, IOException{
			doHandle(request, response);
		}
		  
		
		protected void doHandle(HttpServletRequest request,HttpServletResponse response)
		  throws ServletException, IOException{
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			String file = (String)request.getParameter("fileName");
			String goods_id = (String)request.getParameter("goods_id");
			System.out.println("file="+file);
			System.out.println("goods_id:"+goods_id);
			OutputStream out = response.getOutputStream();
			String fileName="c:\\file_repo\\"+goods_id+"\\"+file;
			File f=new File(fileName);
			response.setHeader("Cache-Control", "no-cache");
			response.addHeader("Content-disposition", "attachment; filename=" + fileName);
			FileInputStream in=new FileInputStream(f); 
			
			byte[] buffer=new byte[1024*8];
			while(true){
				int count=in.read(buffer); 
				if(count==-1)  
					break;
				out.write(buffer,0,count);
			}
			
			in.close();
			out.close();
	    }

}
