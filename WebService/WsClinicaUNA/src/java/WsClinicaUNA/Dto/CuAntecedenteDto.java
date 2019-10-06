/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.Dto;

import WsClinicaUNA.model.CuAntecedentes;
import WsClinicaUNA.model.CuExpediente;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bran
 */
@XmlRootElement(name = "Antecedente") //
@XmlAccessorType(XmlAccessType.FIELD)
public class CuAntecedenteDto {
    private String antTipo;
    private String antTratamiento;
    private Long antHededado;
    private String antParentesco;
    private String antEnfermedad;
    private Long antId;
    private CuExpedienteDto expId; 
    private Long antVersion;
    //metodos
    //get and set

    public String getAntTipo() {
        return antTipo;
    }

    public Long getAntHededado() {
        return antHededado;
    }

    public void setAntHededado(Long antHededado) {
        this.antHededado = antHededado;
    }
    

    public void setAntTipo(String antTipo) {
        this.antTipo = antTipo;
    }

    public String getAntTratamiento() {
        return antTratamiento;
    }

    public void setAntTratamiento(String antTratamiento) {
        this.antTratamiento = antTratamiento;
    }

    public Long getAntHederado() {
        return antHededado;
    }

    public void setAntHederado(Long antHederado) {
        this.antHededado = antHederado;
    }

    public String getAntParentesco() {
        return antParentesco;
    }

    public void setAntParentesco(String antParentesco) {
        this.antParentesco = antParentesco;
    }

    public String getAntEnfermedad() {
        return antEnfermedad;
    }

    public void setAntEnfermedad(String antEnfermedad) {
        this.antEnfermedad = antEnfermedad;
    }

    public Long getAntId() {
        return antId;
    }

    public void setAntId(Long antId) {
        this.antId = antId;
    }

    public CuExpedienteDto getExpId() {
        return expId;
    }

    public void setExpId(CuExpedienteDto expId) {
        this.expId = expId;
    }

    public CuAntecedenteDto(String antTipo, String antTratamiento, Long antHededado, String antParentesco, String antEnfermedad, Long antId, CuExpediente expId) {
        this.antTipo = antTipo;
        this.antTratamiento = antTratamiento;
        this.antHededado = antHededado;
        this.antParentesco = antParentesco;
        this.antEnfermedad = antEnfermedad;
        this.antId = antId;
        this.expId = new CuExpedienteDto(expId);
    }

    
    
   

    public CuAntecedenteDto(CuAntecedentes antecedentes){
        this.antTipo = antecedentes.getAntTipo();
        this.antTratamiento = antecedentes.getAntTratamiento();
        this.antHededado = antecedentes.getAntHeredado();
        this.antParentesco = antecedentes.getAntParentesco();
        this.antEnfermedad = antecedentes.getAntEnfermedad();
        this.antId = antecedentes.getAntId();
        this.expId = new CuExpedienteDto(antecedentes.getExpId());
        this.antVersion = antecedentes.getAntVersion();
    }

    public Long getAntVersion() {
        return antVersion;
    }
    public void setAntVersion(Long vs){
        this.antVersion= vs;
    }
    
}
