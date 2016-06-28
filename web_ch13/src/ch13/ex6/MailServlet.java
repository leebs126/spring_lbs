package ch13.ex6;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/*@WebServlet("/mail.do")*/
public class MailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			doHandle(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			doHandle(request, response);
		}catch(Exception e){
		   e.printStackTrace();
		}
	}
		
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String from=request.getParameter("from");
		String  to=request.getParameter("to");
		String cc=request.getParameter("cc");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		File logoFile = new File("c:\\duke_swing.gif");
		
		sendEmail(from,to,cc,subject,content,logoFile);
		RequestDispatcher dis = request.getRequestDispatcher("/ex6/result.jsp");
		dis.forward(request, response);
		
	}
	
	
	
	 private static  void sendEmail(String from, String to, String cc, String subject, String content,File logoFile)
			  throws Exception {
		
	   // Properties 설정
	   // 프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
		    Properties props = new Properties();
	   // g-mail smtp 사용시
	   props.put("mail.transport.protocol", "smtp");// 프로토콜 설정
	   props.put("mail.smtp.host", "smtp.gmail.com");// gmail smtp 서비스 주소(호스트)
	   props.put("mail.smtp.port", "465");// gmail smtp 서비스 포트 설정
	   props.put("mail.smtp.starttls.enable","true");
	   props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	   props.put("mail.smtp.auth", "true");// SMTP 인증을 설정
	   Authenticator auth = new MySMTPAthenticator();
	   Session mailSession = Session.getDefaultInstance(props, auth);
			  
	   // 메시지 객체를 생성한다.
	   Message msg = new MimeMessage(mailSession);
	   // 메시지 객체에 받는 주소를 설정한다.
	   msg.setFrom(new InternetAddress(from));//보내는 사람 설정
	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));//받는 사람설정
			  
	   if(!cc.trim().equals("")) {
		 msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));
	   }
			  
	   StringBuffer sb = new StringBuffer();
	   sb.append("<html><body>");
		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>");
		sb.append("<h1>"+content+"<h1><br />");
		sb.append("<a href='http://localhost:8090/web_ch13/ex6/goods.jsp' >");
		sb.append("<img  src='http://localhost:8090/web_ch13/fileDownload.do?fileName=image.jpg' /> </a><br>");
		sb.append("<a href='http://localhost:8090/web_ch13/ex6/goods.jsp'>상품보기</a>");
		sb.append("</body></html>");
		String str=sb.toString();
		// 메시지 객체에 제목과 내용을 세팅한다.
		msg.setContent(str,"text/html; charset=UTF-8");
		msg.setSubject(subject); // 제목 설정
		msg.setSentDate(new Date());// 보내는 날짜 설정
		Transport.send(msg);  // 메일 보내기
		
	}
}
