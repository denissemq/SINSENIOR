package com.vortexbird.spring.demo.mail;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
 
@Scope("singleton")
@Service("EnviarMensajeSimpleMailMessageImplementacion")
public class EnviarMensajeSimpleMailMessageImplementacion implements
                                    IEnviarMensajeSimpleMailMessage {
 
    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage templateMessage;
 
    public void enviarMensaje(String to,String mensaje, String subject) throws Exception {
 
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);

        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(mensaje);
 
        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}