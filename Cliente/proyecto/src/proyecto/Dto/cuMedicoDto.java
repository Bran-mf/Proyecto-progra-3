/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Dto;



/**
 *
 * @author ivana
 */
public class cuMedicoDto {
    
    public String medFolio;
    public String medCodigo;
    public String medCerne;
    public String medEstado;
    public String medInicio;
    public String medFinal;
    public String medEspacios;
    public Long medVersion;
   // public CuUsuarios usuCedula;

    public cuMedicoDto(String medFolio, String medCodigo, String medCerne, String medEstado, String medInicio, String medFinal, String medEspacios, Long medVersion /*,CuUsuarios usuCedula*/) {
        this.medFolio = medFolio;
        this.medCodigo = medCodigo;
        this.medCerne = medCerne;
        this.medEstado = medEstado;
        this.medInicio = medInicio;
        this.medFinal = medFinal;
        this.medEspacios = medEspacios;
        this.medVersion = medVersion;
       // this.usuCedula = usuCedula;
    }
    
//    public cuMedicoDto(CuMedicos med){
//        this.medFolio = med.getMedFolio();
//        this.medCodigo = med.getMedCodigo();
//        this.medCerne = med.getMedCerne();
//        this.medEstado = med.getMedEstado();
//        this.medInicio = med.getMedInicio();
//        this.medFinal = med.getMedFinal();
//        this.medEspacios = med.getMedEspacios();
//        this.medVersion = med.getMedVersion();
//        this.usuCedula = med.getUsuCedula();
//    }

    public String getMedFolio() {
        return medFolio;
    }

    public void setMedFolio(String medFolio) {
        this.medFolio = medFolio;
    }

    public String getMedCodigo() {
        return medCodigo;
    }

    public void setMedCodigo(String medCodigo) {
        this.medCodigo = medCodigo;
    }

    public String getMedCerne() {
        return medCerne;
    }

    public void setMedCerne(String medCerne) {
        this.medCerne = medCerne;
    }

    public String getMedEstado() {
        return medEstado;
    }

    public void setMedEstado(String medEstado) {
        this.medEstado = medEstado;
    }

    public String getMedInicio() {
        return medInicio;
    }

    public void setMedInicio(String medInicio) {
        this.medInicio = medInicio;
    }

    public String getMedFinal() {
        return medFinal;
    }

    public void setMedFinal(String medFinal) {
        this.medFinal = medFinal;
    }

    public String getMedEspacios() {
        return medEspacios;
    }

    public void setMedEspacios(String medEspacios) {
        this.medEspacios = medEspacios;
    }

    public Long getMedVersion() {
        return medVersion;
    }

    public void setMedVersion(Long medVersion) {
        this.medVersion = medVersion;
    }

//    public CuUsuarios getUsuCedula() {
//        return usuCedula;
//    }
//
//    public void setUsuCedula(CuUsuarios usuCedula) {
//        this.usuCedula = usuCedula;
//    }
    
    
    
}
