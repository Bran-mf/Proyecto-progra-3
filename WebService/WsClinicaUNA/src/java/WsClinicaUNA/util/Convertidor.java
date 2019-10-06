/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.util;

import WsClinicaUNA.Dto.CuAntecedenteDto;
import WsClinicaUNA.Dto.CuCitasDto;
import WsClinicaUNA.Dto.CuExpedienteDto;
import WsClinicaUNA.Dto.CuReporteCitaDto;
import WsClinicaUNA.Dto.CuExamenDto;
import WsClinicaUNA.model.CuAntecedentes;
import WsClinicaUNA.model.CuCitas;
import WsClinicaUNA.model.CuExamen;
import WsClinicaUNA.model.CuExpediente;
import WsClinicaUNA.model.CuReportecita;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bran
 */
/*
El proposito de esta calse es hacer todas las conversiones que se lleguen a necesitar, de momento contine las 
conversiones mas basicas de Listas de modelos, a listas de  DTO de estos modelos
*/
public class Convertidor {
    
    
    
    // de modelos a dto
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
     public List<CuCitasDto> ModeloToDtoCitas(List<CuCitas> lista) {
        List<CuCitasDto> reporteList = new ArrayList<>();
        for (CuCitas reporte : lista) {
            reporteList.add(new CuCitasDto(reporte));
        }
        return reporteList;
    }
     //de Dto a modelos
     public List<CuReportecita> DtoToDtoReporteCitas(List<CuReporteCitaDto> lista) {
        List<CuReportecita> reporteList = new ArrayList<>();
        for (CuReporteCitaDto reporte : lista) {
            reporteList.add(new CuReportecita(reporte));
        }
        return reporteList;
    }

    public List<CuExpediente> dtoToExpediente(List<CuExpedienteDto> lista) {
        List<CuExpediente> reporteList = new ArrayList<>();
        for (CuExpedienteDto reporte : lista) {
            reporteList.add(new CuExpediente(reporte));
        }
        return reporteList;
    }

    public List<CuExamen> dtoToExamenes(List<CuExamenDto> lista) {
        List<CuExamen> examenList = new ArrayList<>();
        for (CuExamenDto reporte : lista) {
            examenList.add(new CuExamen(reporte));
        }
        return examenList;
    }

    public List<CuAntecedentes> dtoToAntecedentes(List<CuAntecedenteDto> lista) {
        List<CuAntecedentes> antecedenteList = new ArrayList<>();
        for (CuAntecedenteDto reporte : lista) {
            antecedenteList.add(new CuAntecedentes(reporte));
        }
        return antecedenteList;
    }
     public List<CuCitas> dtoToCitas(List<CuCitasDto> lista) {
        List<CuCitas> reporteList = new ArrayList<>();
        for (CuCitasDto reporte : lista) {
            reporteList.add(new CuCitas(reporte));
        }
        return reporteList;
    }
}
