package ch13.ex7;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class MySMTPAthenticator extends Authenticator {
 protected PasswordAuthentication getPasswordAuthentication() {
  String username = "leebs126@gmail.com"; // gmail �����;
  String password = "dlqudtmd1";  // �н�����;
  return new PasswordAuthentication(username, password);
 }

}


