package ch8.ex2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("*.do")
public class TestServlet3 extends HttpServlet {

  public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException {

    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Test Servlet</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY BGCOLOR='yellow'>");
    out.println("<B>TestServlet3¿‘¥œ¥Ÿ.</B>");
    out.println("</BODY>");
    out.println("</HTML>");
    out.close();
  }
}
