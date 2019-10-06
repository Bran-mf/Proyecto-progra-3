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
 */@XmlRootElement(name="Examen") //
@XmlAccessorType(XmlAccessType.FIELD)
public class cuExamenDto {
    private Long exaId;
    private Date exaFecha;
    private String exaNombre;
    private String exaAnotacones;
    private String exaAdjunto;
    //metodos
    //get and set

    public Long getExaId() {
        return exaId;
    }

    public void setExaId(Long exaId) {
        this.exaId = exaId;
    }

    public Date getExaFecha() {
        return exaFecha;
    }

    public void setExaFecha(Date exaFecha) {
        this.exaFecha = exaFecha;
    }

    public String getExaNombre() {
        return exaNombre;
    }

    public void setExaNombre(String exaNombre) {
        this.exaNombre = exaNombre;
    }

    public String getExaAnotacones() {
        return exaAnotacones;
    }

    public void setExaAnotacones(String exaAnotaciones) {
        this.exaAnotacones = exaAnotaciones;
    }

    public String getExaAdjunto() {
        return exaAdjunto;
    }

    public void setExaAdjunto(String exaAdjunto) {
        this.exaAdjunto = exaAdjunto;
    }

    public cuExamenDto(Long exaId, Date exaFecha, String exaNombre, String exaAnotaciones, String exaAdjunto) {
        this.exaId = exaId;
        this.exaFecha = exaFecha;
        this.exaNombre = exaNombre;
        this.exaAnotacones = exaAnotaciones;
        this.exaAdjunto = exaAdjunto;
    }

//    public cuExamenDto(CuExamen exa) {
//        this.exaId = exa.getExaId();
//        this.exaFecha = exa.getExaFecha();
//        this.exaNombre = exa.getExaNombre();
//        this.exaAnotacones = exa.getExaAnotacones();
//        this.exaAdjunto = exa.getExaAdjunto();
//    }
}
