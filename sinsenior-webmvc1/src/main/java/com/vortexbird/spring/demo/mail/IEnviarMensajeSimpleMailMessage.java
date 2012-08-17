package com.vortexbird.spring.demo.mail;
 
public interface IEnviarMensajeSimpleMailMessage {
 
    public void enviarMensaje(String to,String mensaje, String subject)throws Exception;
 
}