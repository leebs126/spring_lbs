package ch13.ex5;
import java.io.IOException;
import java.util.Date;
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

/*@WebServlet("/mail.do")*/
public class MailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			doHandler(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		   doHandler(request, response);
		}catch(Exception e){
		   e.printStackTrace();
		}
	}
	
	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String from=request.getParameter("from");
		String  to=request.getParameter("to");
		String cc=request.getParameter("cc");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		sendEmail(from,to,cc,subject,content);
		RequestDispatcher dis = request.getRequestDispatcher("/ex5/result.jsp");
		dis.forward(request, response);
		
	}
	 private static  void sendEmail(String from, String to, String cc, String subject, String content)
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
			  
		// 메시지 객체에 제목과 내용을 세팅한다.
		msg.setSubject(subject); // 제목 설정
		msg.setText(content);  // 내용 설정
		msg.setSentDate(new Date());// 보내는 날짜 설정
			  
		Transport.send(msg);  // 메일 보내기
	}
}
