/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bran
 */
@XmlRootElement(name = "Usuario") //
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)

public class CuUsuarioDto {

    @XmlTransient
    private String usuCedula;
    @XmlTransient
    private String usuNombre;
    @XmlTransient
    private String usuApellido;
    @XmlTransient
    private String usuCorreo;
    @XmlTransient
    private String usuTipo;
    @XmlTransient
    private String usuIdioma;
    @XmlTransient
    private String usuEstado;
    @XmlTransient
    private String usuUsuario;
    @XmlTransient
    private String usuContrasena;
    @XmlTransient
    private String usuTemp;
    @XmlTransient
    private String usuCodact;
    @XmlTransient
    private Long usuVersion; //revisar
  
    //constructores
    public CuUsuarioDto() {
    }
    //a este estado le falta temporal, no se si agregar o sieste metodo se llegara a usar

    public CuUsuarioDto(String usuCedula, String usuNombre, String usuApellido, String usuCorreo, String usuTipo, String usuIdioma, String usuEstado, String usuUsuario, String usuContrasena, String usuTemp, String usuCodact, Long usuVersion) {
        this.usuCedula = usuCedula;
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuCorreo = usuCorreo;
        this.usuTipo = usuTipo;
        this.usuIdioma = usuIdioma;
        this.usuEstado = usuEstado;
        this.usuUsuario = usuUsuario;
        this.usuContrasena = usuContrasena;
        this.usuTemp = usuTemp;
        this.usuCodact = usuCodact;
        this.usuVersion = usuVersion;
    }
    
    
    
   public CuUsuarioDto(CuUsuarioDto usuario) {
        this.usuCedula = usuario.getUsuCedula();
        this.usuNombre = usuario.getUsuNombre();
        this.usuApellido = usuario.getUsuApellido();
        this.usuCorreo = usuario.getUsuCorreo();
        this.usuContrasena = usuario.getUsuContrasena();
        this.usuEstado = usuario.getUsuEstado();
        this.usuTipo = usuario.getUsuTipo();
        this.usuVersion = usuario.getUsuVersion();
        this.usuIdioma = usuario.getUsuIdioma();
        this.usuCodact = usuario.getUsuCodact();
        this.usuTemp = usuario.getUsuTemp();
    }
    /*
    public CuUsuarios getModel(){
        return new CuUsuarios(usuCedula, usuNombre, usuApellido, usuCorreo, usuTipo, usuIdioma, usuEstado, usuUsuario, usuContrasena, usuCodact, usuTemp);
    }
*/
    
    //metodos set y get

    public String getUsuCedula() {
        return usuCedula;
    }

    public void setUsuCedula(String usuCedula) {
        this.usuCedula = usuCedula;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuTipo() {
        return usuTipo;
    }

    public void setUsuTipo(String usuTipo) {
        this.usuTipo = usuTipo;
    }

    public String getUsuIdioma() {
        return usuIdioma;
    }

    public void setUsuIdioma(String usuIdioma) {
        this.usuIdioma = usuIdioma;
    }

    public String getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public String getUsuTemp() {
        return usuTemp;
    }

    public void setUsuTemp(String usuTemp) {
        this.usuTemp = usuTemp;
    }

    public String getUsuCodact() {
        return usuCodact;
    }

    public void setUsuCodact(String usuCodact) {
        this.usuCodact = usuCodact;
    }

    public Long getUsuVersion() {
        return usuVersion;
    }

    public void setUsuVersion(Long usuVersion) {
        this.usuVersion = usuVersion;
    }

    public String data(String idioma) {
        String dato;
        if(idioma.endsWith("1")){
            dato =  "Datos\nCedula: " + usuCedula + "\nNombre: " + usuNombre + "\nApellidos: " + usuApellido + "\nCorreo: " + usuCorreo;
            if("M".equals(this.usuTipo)){
                dato += "\nTipo: Medico";
            }else{
                dato += "\nTipo: Recepcionista";
            }
            dato += "\nIdioma : Español\nUsuario: "+usuUsuario+"\nContraseña: "+usuContrasena;
        }else{
            dato =  "Information\nID Number: " + usuCedula + "\nName: " + usuNombre + "\nLast Name: " + usuApellido + "\nE-mail: " + usuCorreo+"\nUser Role: ";
            if("M".equals(this.usuTipo)){
                dato += "Doctor";
            }else{
                dato += "Recepcionist";
            }
            dato += "\nLengauge : English\nUser: "+usuUsuario+"\nPassword: "+usuContrasena;
        }
        return dato;
         
    }
    
    
    
}
