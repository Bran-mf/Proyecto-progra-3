/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.Dto;

import WsClinicaUNA.model.CuExamen;
import java.math.BigDecimal;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bran
 */@XmlRootElement(name="Examen") //
@XmlAccessorType(XmlAccessType.FIELD)
public class CuExamenDto {
    private Long exaId;
    private Date exaFecha;
    private String exaNombre;
    private String exaAnotacones;
    private String exaAdjunto;
    private Long version;
    private CuExpedienteDto cuExpedienteDto;
    //metodos
    //get and set

    public Long getVersion() {
        return version;
    }

    public CuExpedienteDto getCuExpedienteDto() {
        return cuExpedienteDto;
    }

    public void setCuExpedienteDto(CuExpedienteDto cuExpedienteDto) {
        this.cuExpedienteDto = cuExpedienteDto;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }

    
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

    public CuExamenDto(Long exaId, Date exaFecha, String exaNombre, String exaAnotaciones, String exaAdjunto) {
        this.exaId = exaId;
        this.exaFecha = exaFecha;
        this.exaNombre = exaNombre;
        this.exaAnotacones = exaAnotaciones;
        this.exaAdjunto = exaAdjunto;
    }

    public CuExamenDto(CuExamen exa) {
        this.exaId = exa.getExaId();
        this.exaFecha = exa.getExaFecha();
        this.exaNombre = exa.getExaNombre();
        this.exaAnotacones = exa.getExaAnotacones();
        this.exaAdjunto = exa.getExaAdjunto();
    }

    
}
