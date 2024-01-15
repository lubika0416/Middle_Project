package util;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	
	public static void main(String[] args) {
		EmailUtil.sendEmail("falcomm@naver.com");
	}
	
	/**
	 * 사용자에게 새로운 임시비밀번호를 전송하는 메소드
	 * @param userEmail 메일을 수신받을 이메일
	 * @return 전송 성공 여부
	 */
	public static String sendEmail(String userEmail) {
		
		
		
		String host = "smtp.naver.com";
		final String id = "falcomm@naver.com";
		final String password = "sf9860!@";
		String tempPw = "";
		
		boolean result = false;
		
		Properties props = new Properties();

		props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(id, password);
			}
		});

		try {

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(id));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));

			message.setSubject("임시 비밀번호 설정 안내");
			
			tempPw = UUID.randomUUID().toString().substring(0,8);

			message.setText("새로운 비밀번호는 " + tempPw + " 입니다.");

			Transport.send(message);

			System.out.println("전송완료");
			
			result = true;
			
			
			
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return tempPw;

	}

}
