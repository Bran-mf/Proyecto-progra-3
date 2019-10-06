/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Bran
 */
public class Correos {
    private String correo; //correo de donde se envia
    private String password; //password del correo que se envia
    private String destino; //Email donde se va enviar
    private String motivo; //motivo del email
    private String imagenWeb; //imagen del baner
    private String html;
    
    public void sendActivationMail() { //link de activacion
        try {
            Properties propiedades = new Properties();
            propiedades.put("mail.smtp.host", "smtp.gmail.com");
            propiedades.put("mail.smtp.auth", "true");
            propiedades.put("mail.debug", false);
            propiedades.put("mail.smtp.ssl.enable", "true");
//          String myCuenta = "sistemacontrolroles@gmail.com";
//          String pass = "programacion3";
            Session session = Session.getDefaultInstance(propiedades);
            Message mensage = new MimeMessage(session);
            InternetAddress from = new InternetAddress(correo, "");
            InternetAddress to = new InternetAddress(destino);
            mensage.setRecipient(Message.RecipientType.TO, to);
            mensage.setSubject(motivo);
            mensage.setContent(html,"text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(correo, password);
            transport.sendMessage(mensage, mensage.getRecipients(Message.RecipientType.TO));
            transport.close();

        } catch (AddressException | UnsupportedEncodingException ex) {
            Logger.getLogger(Correos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Correos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Correos(String correo, String password, String motivo, String imagenWeb) {
        this.correo = correo;
        this.password = password;
        this.motivo = motivo;
        this.imagenWeb = imagenWeb;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public String getDestino() {
        return destino;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getImagenWeb() {
        return imagenWeb;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setImagenWeb(String imagenWeb) {
        this.imagenWeb = imagenWeb;
    }

    public Correos() {
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
    public void cargarHtml(){
        try {
            FileReader filereader= new  FileReader("testeo.html");
            BufferedReader br= new BufferedReader(filereader);
            String temp;
            while((temp=br.readLine())!=null){
                html= html+temp;
            }
            br.close();
        } catch (FileNotFoundException ex) {     
        } catch (IOException ex) {   
        }
        
    }
    public void setDatosHtml(String nombre,String link){
        this.html =html.replace("VarNombre", nombre);
       this.html =html.replace("VarLink", link);
        System.out.println(html);
    }
    
}
