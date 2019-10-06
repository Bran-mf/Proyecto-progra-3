/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.Dto;

import WsClinicaUNA.model.CuAntecedentes;
import WsClinicaUNA.model.CuExamen;
import WsClinicaUNA.model.CuExpediente;
import WsClinicaUNA.model.CuPacientes;
import WsClinicaUNA.model.CuReportecita;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bran
 */
@XmlRootElement(name = "Expediente") //
@XmlAccessorType(XmlAccessType.FIELD)
public class CuExpedienteDto {

    private Long expId;
    private List<CuReporteCitaDto> cuReporteCitaList; //lista re citas del paciente
    private CuPacientes cuPaciente; //paciente
    private List<CuExamenDto> cuExamensList; //lista de examenes
    private List<CuAntecedenteDto> cuAntecedentesesList; //listas de antecedentes de esta persona
    //metodos 
    //get and set 

    public Long getExpId() {
        return expId;
    }

    public void setExpId(Long id) {
        this.expId = id;
    }

    public List<CuReporteCitaDto> getCuReporteCitaList() {
        return cuReporteCitaList;
    }

    public void setCuReporteCitaList(List<CuReporteCitaDto> cuReporteCitaList) {
        this.cuReporteCitaList = cuReporteCitaList;
    }

    public CuPacientes getCuPaciente() {
        return cuPaciente;
    }

    public void setCuPaciente(CuPacientes cuPaciente) {
        this.cuPaciente = cuPaciente;
    }

    public List<CuExamenDto> getCuExamensList() {
        return cuExamensList;
    }

    public void setCuExamensList(List<CuExamenDto> cuExamensList) {
        this.cuExamensList = cuExamensList;
    }

    public List<CuAntecedenteDto> getCuAntecedentesesList() {
        return cuAntecedentesesList;
    }

    public void setCuAntecedentesesList(List<CuAntecedenteDto> cuAntecedentesesList) {
        this.cuAntecedentesesList = cuAntecedentesesList;
    }
    //constructor 

    public CuExpedienteDto(Long id, List<CuReporteCitaDto> cuReporteCitaList, CuPacientes cuPaciente, List<CuExamenDto> cuExamensList, List<CuAntecedenteDto> cuAntecedentesesList) {
        this.expId = id;
        this.cuReporteCitaList = cuReporteCitaList;
        this.cuPaciente = cuPaciente;
        this.cuExamensList = cuExamensList;
        this.cuAntecedentesesList = cuAntecedentesesList;
    }

    public CuExpedienteDto() {
        this.cuReporteCitaList = new ArrayList();
        this.cuExamensList = new ArrayList();
        this.cuAntecedentesesList = new ArrayList();
    }

    public CuExpedienteDto(CuExpediente cuExpediente) {
        cuReporteCitaList = ModeloToDtoReporteCitas(cuExpediente.getCuReportecitaList());
        cuPaciente = cuExpediente.getPacId();
        cuExamensList = ModeloToDtoExamenes( cuExpediente.getCuExamenList());
        cuAntecedentesesList = ModeloToDtoAntecedentes(cuExpediente.getCuAntecedentesList());
    }

    public List<CuReporteCitaDto> ModeloToDtoReporteCitas(List<CuReportecita> lista) {
        List<CuReporteCitaDto> reporteList = new ArrayList<>();
        for (CuReportecita reporte : lista) {
            reporteList.add(new CuReporteCitaDto(reporte));
        }
        return reporteList;
    }

    public List<CuExpedienteDto> ModeloToDtoExpediente(List<CuExpediente> lista) {
        List<CuExpedienteDto> reporteList = new ArrayList<>();
        for (CuExpediente reporte : lista) {
            reporteList.add(new CuExpedienteDto(reporte));
        }
        return reporteList;
    }

    public List<CuExamenDto> ModeloToDtoExamenes(List<CuExamen> lista) {
        List<CuExamenDto> examenList = new ArrayList<>();
        for (CuExamen reporte : lista) {
            examenList.add(new CuExamenDto(reporte));
        }
        return examenList;
    }

    public List<CuAntecedenteDto> ModeloToDtoAntecedentes(List<CuAntecedentes> lista) {
        List<CuAntecedenteDto> antecedenteList = new ArrayList<>();
        for (CuAntecedentes reporte : lista) {
            antecedenteList.add(new CuAntecedenteDto(reporte));
        }
        return antecedenteList;
    }

}
