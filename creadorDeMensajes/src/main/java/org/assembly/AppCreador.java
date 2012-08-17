package org.assembly;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


public class AppCreador

{

 public static void main( String[] args )

 {

  BeanFactory fabricaDeBeans = new XmlBeanFactory(new FileSystemResource("src/main/resources/spring-context.xml"));



  EnviadorDeMensajes enviador = (EnviadorDeMensajes) fabricaDeBeans.getBean("miEnviadorDeMensajes");



  enviador.enviarUnMensaje();

 }

}

