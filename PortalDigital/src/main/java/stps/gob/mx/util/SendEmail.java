package stps.gob.mx.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

public class SendEmail {	
	
	public String enviar(String Mensage, String To, String Subject, String from, String pws) throws Exception {
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.clave", pws);
		props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        
        System.out.println( "Datos ingresados: " + from + "\t" + pws );
        
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(from, pws);
//                    }
//                });
        
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        
        try {
        	//Message message = new MimeMessage(session);
        	message.setFrom(new InternetAddress(from));
        	message.setRecipients(Message.RecipientType.TO,
                   InternetAddress.parse(To));
        	
        	message.setSubject(Subject);
        	message.setText(Mensage);
        	
        	Transport transport = session.getTransport("smtp");
        	transport.connect("smtp.gmail.com", from, pws);
        	transport.sendMessage(message, message.getAllRecipients());
        	transport.close();
        	
        	return "Se envio el correo correctamente";
        	
        }catch( MessagingException e ) {
        	System.out.println("Se presento un error al enviar el correo electrónico\n\n" + e.getMessage());
        	
        	throw new Exception("Se presento un error al enviar el correo electrónico\n" + e.getMessage());
        }
	}

}
