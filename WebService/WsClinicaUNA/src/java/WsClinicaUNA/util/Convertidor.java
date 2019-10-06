/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.util;

import WsClinicaUNA.Dto.CuAntecedenteDto;
import WsClinicaUNA.Dto.CuExpedienteDto;
import WsClinicaUNA.Dto.CuReporteCitaDto;
import WsClinicaUNA.Dto.cuExamenDto;
import WsClinicaUNA.model.CuAntecedentes;
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

    public List<cuExamenDto> ModeloToDtoExamenes(List<CuExamen> lista) {
        List<cuExamenDto> examenList = new ArrayList<>();
        for (CuExamen reporte : lista) {
            examenList.add(new cuExamenDto(reporte));
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
