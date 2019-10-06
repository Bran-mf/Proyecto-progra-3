/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Dto;


import java.math.BigDecimal;
import java.math.BigInteger;
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
    //private CuExpediente expId; 
    //metodos
    //get and set

    public String getAntTipo() {
        return antTipo;
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

//    public CuExpediente getExpId() {
//        return expId;
//    }

//    public void setExpId(CuExpediente expId) {
//        this.expId = expId;
//    }
//
//    public CuAntecedenteDto(String antTipo, String antTratamiento, Long antHededado, String antParentesco, String antEnfermedad, Long antId, CuExpediente expId) {
//        this.antTipo = antTipo;
//        this.antTratamiento = antTratamiento;
//        this.antHededado = antHededado;
//        this.antParentesco = antParentesco;
//        this.antEnfermedad = antEnfermedad;
//        this.antId = antId;
//        this.expId = expId;
//    }
//
//    
//    
//   
//
//    public CuAntecedenteDto(CuAntecedentes antecedentes){
//        this.antTipo = antecedentes.getAntTipo();
//        this.antTratamiento = antecedentes.getAntTratamiento();
//        this.antHededado = antecedentes.getAntHeredado();
//        this.antParentesco = antecedentes.getAntParentesco();
//        this.antEnfermedad = antecedentes.getAntEnfermedad();
//        this.antId = antecedentes.getAntId();
//        this.expId = antecedentes.getExpId();
//    }
//    
}
