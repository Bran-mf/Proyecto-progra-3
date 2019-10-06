///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package proyecto.Dto;
//
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// *
// * @author Bran
// */
//@XmlRootElement(name="Expediente") //
//@XmlAccessorType(XmlAccessType.FIELD)
//public class CuExpedienteDto {
//
//    private Long expId;
//    private List<CuReportecita> cuReporteCitaList; //lista re citas del paciente
//    private CuPacientes cuPaciente; //paciente
//    private List<CuExamen> cuExamensList; //lista de examenes
//    private List<CuAntecedentes> cuAntecedentesesList; //listas de antecedentes de esta persona
//    //metodos 
//    //get and set 
//
//    public Long getExpId() {
//        return expId;
//    }
//
//    public void setExpId(Long id) {
//        this.expId = id;
//    }
//
//    public List<CuReportecita> getCuReporteCitaList() {
//        return cuReporteCitaList;
//    }
//
//    public void setCuReporteCitaList(List<CuReportecita> cuReporteCitaList) {
//        this.cuReporteCitaList = cuReporteCitaList;
//    }
//
//    public CuPacientes getCuPaciente() {
//        return cuPaciente;
//    }
//
//    public void setCuPaciente(CuPacientes cuPaciente) {
//        this.cuPaciente = cuPaciente;
//    }
//
//    public List<CuExamen> getCuExamensList() {
//        return cuExamensList;
//    }
//
//    public void setCuExamensList(List<CuExamen> cuExamensList) {
//        this.cuExamensList = cuExamensList;
//    }
//
//    public List<CuAntecedentes> getCuAntecedentesesList() {
//        return cuAntecedentesesList;
//    }
//
//    public void setCuAntecedentesesList(List<CuAntecedentes> cuAntecedentesesList) {
//        this.cuAntecedentesesList = cuAntecedentesesList;
//    }
//    //constructor 
//
//    public CuExpedienteDto(Long id, List<CuReportecita> cuReporteCitaList, CuPacientes cuPaciente, List<CuExamen> cuExamensList, List<CuAntecedentes> cuAntecedentesesList) {
//        this.expId = id;
//        this.cuReporteCitaList = cuReporteCitaList;
//        this.cuPaciente = cuPaciente;
//        this.cuExamensList = cuExamensList;
//        this.cuAntecedentesesList = cuAntecedentesesList;
//    }
//
//    public CuExpedienteDto() {
//        this.cuReporteCitaList = new ArrayList();
//        this.cuExamensList = new ArrayList();
//        this.cuAntecedentesesList = new ArrayList();
//    }
//
//    public CuExpedienteDto(CuExpediente cuExpediente) {
//        cuReporteCitaList = cuExpediente.getCuReportecitaList();
//        cuPaciente = cuExpediente.getPacCedula();
//        cuExamensList = cuExpediente.getCuExamenList();  
//        cuAntecedentesesList = cuExpediente.getCuAntecedentesList();
//    }
//
//}
