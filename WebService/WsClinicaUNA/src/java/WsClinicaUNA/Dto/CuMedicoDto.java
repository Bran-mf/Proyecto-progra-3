/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.Dto;

import WsClinicaUNA.model.CuMedicos;
import WsClinicaUNA.model.CuUsuarios;
import WsClinicaUNA.util.Convertidor;
import java.util.List;

/**
 *
 * @author ivana
 */
public class CuMedicoDto {
    public Convertidor conv = new Convertidor();
    public String medId;
    public String medFolio;
    public String medCodigo;
    public String medCerne;
    public String medEstado;
    public String medInicio;
    public String medFinal;
    public String medEspacios;
    public Long medVersion;
    public CuUsuarioDto usuCedula;
    public List<CuCitasDto> listaCucitasDto;

    public CuMedicoDto(String medId, String medFolio, String medCodigo, String medCerne, String medEstado, String medInicio, String medFinal, String medEspacios, Long medVersion, CuUsuarioDto usuCedula) {
        this.medId = medId;
        this.medFolio = medFolio;
        this.medCodigo = medCodigo;
        this.medCerne = medCerne;
        this.medEstado = medEstado;
        this.medInicio = medInicio;
        this.medFinal = medFinal;
        this.medEspacios = medEspacios;
        this.medVersion = medVersion;
        this.usuCedula = usuCedula;
    }
    
    public CuMedicoDto(CuMedicos med){
        this.medId = med.getMedId().toString();
        this.medFolio = med.getMedFolio();
        this.medCodigo = med.getMedCodigo();
        this.medCerne = med.getMedCerne();
        this.medEstado = med.getMedEstado();
        this.medInicio = med.getMedInicio();
        this.medFinal = med.getMedFinal();
        this.medEspacios = med.getMedEspacios();
        this.medVersion = med.getMedVersion();
        this.usuCedula = new CuUsuarioDto(med.getUsuId());
        this.listaCucitasDto = conv.ModeloToDtoCitas(med.getCuCitasList());
    }

    public String getMedId() {
        return medId;
    }

    public void setMedId(String medId) {
        this.medId = medId;
    }

    
    public String getMedFolio() {
        return medFolio;
    }

    public void setMedFolio(String medFolio) {
        this.medFolio = medFolio;
    }

    public List<CuCitasDto> getListaCucitasDto() {
        return listaCucitasDto;
    }

    public void setListaCucitasDto(List<CuCitasDto> listaCucitasDto) {
        this.listaCucitasDto = listaCucitasDto;
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

    public CuUsuarioDto getUsuCedula() {
        return usuCedula;
    }

    public void setUsuCedula(CuUsuarioDto usuCedula) {
        this.usuCedula = usuCedula;
    }
    
    
    
}
