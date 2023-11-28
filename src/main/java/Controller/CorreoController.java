package Controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import Model.Correo;

public class CorreoController {
	private Properties properties;
	private Session session;
	private MimeMessage mcorreo;
	
	public CorreoController() {
		properties = new Properties();
	}
	
	public void correo(Correo correo) {
		
		Correo objCorreo = new Correo();
		objCorreo.setCorreoEnviar("toolsnestferreterias@gmail.com");
		objCorreo.setCorreoRecibir(correo.getCorreoRecibir());
		objCorreo.setclave("tkjsbxswzgpgshbq");
		objCorreo.setPara(correo.getPara());
		objCorreo.setAsunto("Gracias por Comprar en Ferreterías ToolsNest");
		
		String saludo = "¡Hola " + correo.getPara() + "!";
		String contenidoHTML = "<html>"
		        + "<body style='font-family: Arial, sans-serif; color: #F5F5F5; font-size: 18px;'>"
		        + "<div style='background-color: #33344E; padding: 20px; border-radius: 10px;'>"
		        + "<h1 style='color: #F5F5F5;'>" + saludo + "</h1>"
		        + "<p>En nombre de todo el equipo de ToolsNest, queremos expresar nuestro más sincero agradecimiento por tu reciente compra. Valoramos tu confianza en nosotros y estamos emocionados de tenerte como nuestro cliente.</p>"
		        + "<p>"
		        + "Para mostrarte nuestra gratitud, queremos ofrecerte un vistazo a nuestro catálogo de productos más populares. Estamos seguros de que encontrarás algo más que se ajuste a tus necesidades y gustos."
		        + "</p>"
		        + "<p>"
		        + "Puedes explorar nuestro catálogo completo <a href='https://online.fliphtml5.com/nffti/jcbk/#p=60' style='text-decoration: none; color: #FFFFFF; font-weight: bold;'>aquí</a>. ¡Esperamos que encuentres algo que te encante!"
		        + "</p>"
		        + "<p>"
		        + "Agradecemos tu continuo apoyo y esperamos poder servirte en muchas más ocasiones. Si tienes alguna pregunta o comentario, no dudes en ponerte en contacto con nosotros."
		        + "</p>"
		        + "<p style='color: #F5F5F5; font-size: 16px;'>"
		        + "¡Gracias de nuevo y que tengas un maravilloso día!"
		        + "</p>"				        
		        + "<img src='https://img.freepik.com/vector-premium/plantilla-banner-servicio-tienda-herramientas-construccion_38901-507.jpg?w=900' alt='img' style='width: 100%; max-width: 850px; height: auto;'>"
		        + "</div>"
		        + "</body>"
		        + "</html>";
		
		objCorreo.setContenido(contenidoHTML);
		objCorreo.setTipoContenido("text/html; charset=utf-8");
		
		 try {
             MimeMessage mimeMessage = crearCorreo(objCorreo);
             enviarCorreo(objCorreo, mimeMessage);
             System.out.println("CORREO ENVIADO");
         } catch (MessagingException e) {
             // Manejo de excepciones
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error al enviar el correo");
         }
		
	}
	
	private MimeMessage crearCorreo(Correo objCorreo) throws MessagingException {
		 properties.put("mail.smtp.host", "smtp.gmail.com");
		 properties.put("mail.smpt.ssl.trust", "smtp.gmail.com");
		 properties.setProperty("mail.smtp.port", "465"); // Cambia el puerto a 465
		 properties.setProperty("mail.smtp.user", objCorreo.getCorreoEnviar());
		 properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); // Puedes mantener o eliminar esta línea según tus necesidades
		 properties.setProperty("mail.smtp.ssl.enable", "true");

	        session = Session.getDefaultInstance(properties);

	        mcorreo = new MimeMessage(session);
	        mcorreo.setFrom(new InternetAddress(objCorreo.getCorreoEnviar()));
	        mcorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(objCorreo.getCorreoRecibir()));
	        mcorreo.setSubject(objCorreo.getAsunto());
	        mcorreo.setText(objCorreo.getContenido(), "UTF-8", "html");

	        return mcorreo;
	    }
	
	 private void enviarCorreo(Correo objCorreo, MimeMessage mimeMessage) {
	        try {
	            Transport transport = session.getTransport("smtp");
	            transport.connect(objCorreo.getCorreoEnviar(), objCorreo.getclave());
	            transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
	            transport.close();
	        } catch (MessagingException e) {
	            // Manejo de excepciones
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al enviar el correo");
	        }
	    }
	
}
