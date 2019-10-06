/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Dto;


import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bran
 */
@XmlRootElement(name = "Cita") //
@XmlAccessorType(XmlAccessType.FIELD)
public class CuCitasDto {
    
    private Long citId;
    private String citEstado;
    private String citMotivo;
    private String citTelefono;
    private String citCorreo;
    private Date citFecha;
    private String citHora;
    private String citEspacios;
//    private CuMedicos medFolio;
//    private CuPacientes pacCedula;
//    private CuUsuarios usuCedula;

    public Long getCitId() {
        return citId;
    }

    public void setCitId(Long citId) {
        this.citId = citId;
    }

    public String getCitEstado() {
        return citEstado;
    }

    public void setCitEstado(String citEstado) {
        this.citEstado = citEstado;
    }

    public String getCitMotivo() {
        return citMotivo;
    }

    public void setCitMotivo(String citMotivo) {
        this.citMotivo = citMotivo;
    }

    public String getCitTelefono() {
        return citTelefono;
    }

    public void setCitTelefono(String citTelefono) {
        this.citTelefono = citTelefono;
    }

    public String getCitCorreo() {
        return citCorreo;
    }

    public void setCitCorreo(String citCorreo) {
        this.citCorreo = citCorreo;
    }

    public Date getCitFecha() {
        return citFecha;
    }

    public void setCitFecha(Date citFecha) {
        this.citFecha = citFecha;
    }

    public String getCitHora() {
        return citHora;
    }

    public void setCitHora(String citHora) {
        this.citHora = citHora;
    }

    public String getCitEspacios() {
        return citEspacios;
    }

    public void setCitEspacios(String citEspacios) {
        this.citEspacios = citEspacios;
    }

//    public CuMedicos getMedFolio() {
//        return medFolio;
//    }
//
//    public void setMedFolio(CuMedicos medFolio) {
//        this.medFolio = medFolio;
//    }
//
//    public CuPacientes getPacCedula() {
//        return pacCedula;
//    }
//
//    public void setPacCedula(CuPacientes pacCedula) {
//        this.pacCedula = pacCedula;
//    }
//
//    public CuUsuarios getUsuCedula() {
//        return usuCedula;
//    }
//
//    public void setUsuCedula(CuUsuarios usuCedula) {
//        this.usuCedula = usuCedula;
//    }
//
//    public CuCitasDto(Long citId, String citEstado, String citMotivo, String citTelefono, String citCorreo, Date citFecha, String citHora, String citEspacios, CuMedicos medFolio, CuPacientes pacCedula, CuUsuarios usuCedula) {
//        this.citId = citId;
//        this.citEstado = citEstado;
//        this.citMotivo = citMotivo;
//        this.citTelefono = citTelefono;
//        this.citCorreo = citCorreo;
//        this.citFecha = citFecha;
//        this.citHora = citHora;
//        this.citEspacios = citEspacios;
//        this.medFolio = medFolio;
//        this.pacCedula = pacCedula;
//        this.usuCedula = usuCedula;
//    }
//    
//    public CuCitasDto(CuCitas cita) {
//        this.citId = cita.getCitId();
//        this.citEstado = cita.getCitEstado();
//        this.citMotivo = cita.getCitMotivo();
//        this.citTelefono = cita.getCitTelefono();
//        this.citCorreo = cita.getCitCorreo();
//        this.citFecha = cita.getCitFecha();
//        this.citHora = cita.getCitHora();
//        this.citEspacios = cita.getCitEspacios();
//        this.medFolio = cita.getMedFolio();
//        this.pacCedula = cita.getPacCedula();
//        this.usuCedula = cita.getUsuCedula();
//    }
//    
//    
//    
    
    
}