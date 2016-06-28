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
	   // Properties ����
	   // ������Ƽ �� �ν��Ͻ� ������ �⺻����(SMTP ���� ȣ��Ʈ ����)
	   Properties props = new Properties();
	   // g-mail smtp ����
	   props.put("mail.transport.protocol", "smtp");// �������� ����
	   props.put("mail.smtp.host", "smtp.gmail.com");// gmail smtp ���� �ּ�(ȣ��Ʈ)
	   props.put("mail.smtp.port", "465");// gmail smtp ���� ��Ʈ ����
	   props.put("mail.smtp.starttls.enable","true");
	   props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	   props.put("mail.smtp.auth", "true");// SMTP ������ ����
	   Authenticator auth = new MySMTPAthenticator();
	   Session mailSession = Session.getDefaultInstance(props, auth);
			  
	   // �޽��� ��ü�� �����Ѵ�.
	   Message msg = new MimeMessage(mailSession);
	   // �޽��� ��ü�� �޴� �ּҸ� �����Ѵ�.
	   msg.setFrom(new InternetAddress(from));//������ ��� ����
	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));//�޴� �������
			  
	   if(!cc.trim().equals("")) {
		 msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));
	   }
			  
		// �޽��� ��ü�� ����� ������ �����Ѵ�.
		msg.setSubject(subject); // ���� ����
		msg.setText(content);  // ���� ����
		msg.setSentDate(new Date());// ������ ��¥ ����
			  
		Transport.send(msg);  // ���� ������
	}
}
