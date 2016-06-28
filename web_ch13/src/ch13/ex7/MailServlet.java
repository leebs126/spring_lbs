package ch13.ex7;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.mail.ByteArrayDataSource;

import ch13.ex6.MySMTPAthenticator;


@WebServlet("/mail.do")
public class MailServlet extends HttpServlet {
	String fileServer="C:\\mail_file";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doHandle(request, response);
		} catch (Exception e) {
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

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HashMap mailMap=processFile(request,response);
		String from=(String)mailMap.get("from");
		String to=(String)mailMap.get("to");
		String cc=(String)mailMap.get("cc");
		String subject=(String)mailMap.get("subject");
		String content=(String)mailMap.get("content");
		String fileName=(String)mailMap.get("fileName");
		sendEmail(from,to,cc,subject,content,fileServer+"\\"+fileName);
		
		File file =new File(fileServer+"\\"+fileName);
		file.delete();
		
		RequestDispatcher rd = request.getRequestDispatcher("/ex7/result.jsp");
		rd.forward(request, response);
	}

	private HashMap processFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HashMap mailMap=new HashMap();
		byte[] bytes = new byte[512];
		int state = 0;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try{
			String encoding="utf-8";
			//String tempDir = "C:\\file_repo";
			File currentDirPath =new File(fileServer);
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath );
			factory.setSizeThreshold(1024*1024);
			ServletFileUpload upload=new ServletFileUpload(factory);
			
			List<?> items = upload.parseRequest(request);
			for(int i=0; i < items.size();i++){
				FileItem fileItem = (FileItem) items.get(i);
				
				if(fileItem.isFormField()){
					System.out.println(fileItem.getFieldName()+ "=" +fileItem.getString(encoding));
					String key=fileItem.getFieldName();
					String value=fileItem.getString(encoding);
					mailMap.put(key,value);
				}else{
					
					System.out.println("파라미터명:"+fileItem.getFieldName());
					System.out.println("파일명:"+fileItem.getName());
					System.out.println("파일크기:"+fileItem.getSize( ) + "bytes");
					//업로드한 파일이 존재하는 경우
					if(fileItem.getSize() > 0){
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx ==-1){
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx+1);
						mailMap.put("fileName",fileName);
						try{
							File uploadFile = new  File(currentDirPath +"\\"+ fileName);
							
							//fileItem.
							fileItem.write(uploadFile);
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				
				}
			
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mailMap;
	}
	
	private void sendEmail(String from, String to, String cc, String subject,
			  String content, String fileName) throws Exception {
		 Properties props = new Properties(); 
	        props.setProperty("mail.transport.protocol", "smtp"); 
	        props.setProperty("mail.host", "smtp.gmail.com"); 
	        props.put("mail.smtp.auth", "true"); 
	        props.put("mail.smtp.port", "465"); 
	        props.put("mail.smtp.socketFactory.port", "465"); 
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
	        props.put("mail.smtp.socketFactory.fallback", "false"); 
	        props.setProperty("mail.smtp.quitwait", "false"); 
	    
	        Authenticator auth = new MySMTPAthenticator();
	        Session mailSession = Session.getDefaultInstance(props,auth);
	         
	        MimeMessage message = new MimeMessage(mailSession); 
	        message.setSender(new InternetAddress(from)); 
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));//받는 사람설정
	        message.setSubject(subject); 
	 
	        if(!cc.isEmpty())
	          message.setRecipient(Message.RecipientType.CC, new InternetAddress(cc)); 
	         
	        Multipart mp = new MimeMultipart();
	        MimeBodyPart mbp1 = new MimeBodyPart();
	        mbp1.setText(content);
	        mp.addBodyPart(mbp1);
	 
	        if(fileName != null){
	            if(fileSizeCheck(fileName)){
	                MimeBodyPart mbp2 = new MimeBodyPart();
	                FileDataSource fds = new FileDataSource(fileName);
	                mbp2.setDataHandler(new DataHandler(fds));
	                mbp2.setFileName(MimeUtility.encodeText(fds.getName(), "UTF-8", "B"));
	             
	                mp.addBodyPart(mbp2);
	            }else{
	                throw new Exception("file size overflow !");
	            }
	        }
	         
	        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
	        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
	        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
	        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
	        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
	        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
	        CommandMap.setDefaultCommandMap(mc);
	         
	        message.setContent(mp);
	        Transport.send(message);
	    }
	    
     protected boolean fileSizeCheck(String filename) {
        if (new File(filename).length() > (1024 * 1024 * 2.5)) {
            return false;
        }
        return true;
    }
}
