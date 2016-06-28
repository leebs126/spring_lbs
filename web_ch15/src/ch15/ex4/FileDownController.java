package ch15.ex4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/fileDownload.do")*/
public class FileDownController extends HttpServlet {
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
			
			String file_repo="C:\\file_repo";
			//자바 I/O를 이용해서 파일을 전송한다.
			String fileName = (String)request.getParameter("fileName");
			System.out.println("fileName="+fileName);
			OutputStream out = response.getOutputStream();
			String downFile=file_repo+"\\"+fileName;
			File f=new File(downFile);
			
			response.setHeader("Cache-Control","no-cache");
			response.addHeader("Content-disposition", "attachment; fileName="+fileName);
			FileInputStream in=new FileInputStream(f); 
			byte[] buffer=new byte[1024*8];
			while(true){
				int count=in.read(buffer); //버퍼에 읽어들인 문자개수
				if(count==-1)  //버퍼의 마지막에 도달했는지 체크
					break;
				out.write(buffer,0,count);
			}
			in.close();
			out.close();
	    }

}
