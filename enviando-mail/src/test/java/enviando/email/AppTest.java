package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AppTest {
	
	private String userName = "glauciovarela7@gmail.com";
	private String senha = "JesusCristo1977"; 
	
	
	@org.junit.Test
	public void testEmail() {
		try {
		
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");/*Autorização*/
		properties.put("mail.smtp.starttls", "true");/*Autenticação*/
		properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor hotmail*/
		properties.put("mail.smtp.ports", "465"); /*Porta do Srvidor*/
		properties.put("mail.smtp.socketFactory.port", "465"); /*porta usada socket*/
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe Socket*/
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, senha);
			}
		});
		
		Address[] toUser = InternetAddress.parse("glauciovarela7@gmail.com");
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName));/*Quem está enviando o e-mail*/
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject("Chegou o e-mail enviado com Java");
		message.setText("Olá programador, vc acaba de receber um e-mail enviado com Java");
		
		Transport.send(message);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
