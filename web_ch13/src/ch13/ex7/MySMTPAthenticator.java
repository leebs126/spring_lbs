package ch13.ex7;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class MySMTPAthenticator extends Authenticator {
 protected PasswordAuthentication getPasswordAuthentication() {
  String username = "leebs126@gmail.com"; // gmail 사용자;
  String password = "dlqudtmd1";  // 패스워드;
  return new PasswordAuthentication(username, password);
 }

}


