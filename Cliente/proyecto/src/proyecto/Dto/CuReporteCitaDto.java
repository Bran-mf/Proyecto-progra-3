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
 */
@XmlRootElement(name="ReporteCita") //
@XmlAccessorType(XmlAccessType.FIELD)
public class CuReporteCitaDto {

    private Date rcFecha;
    private Long rcId;
    private String rcHora;
    private String rcPresion;
    private Long rcPeso;
    private String rcTalla;
    private String rcTemperatura;
    private Long rcImc; //indice masa corporal
    private String rcNotasenfermeria;
    private String rcRazon;
    private String rcObservaciones;
    private String rcPlan;
    private String rcExamen;
   // private CuExpediente expId; //expediente al que pertenece , llave foranea
    //metodos
    //get and set

    public Date getRcFecha() {
        return rcFecha;
    }

    public void setRcFecha(Date rcFecha) {
        this.rcFecha = rcFecha;
    }

    public Long getRcId() {
        return rcId;
    }

    public void setRcId(Long rcId) {
        this.rcId = rcId;
    }

    public String getRcHora() {
        return rcHora;
    }

    public void setRcHora(String rcHora) {
        this.rcHora = rcHora;
    }

    public String getRcPresion() {
        return rcPresion;
    }

    public void setRcPresion(String rcPresion) {
        this.rcPresion = rcPresion;
    }

    public Long getRcPeso() {
        return rcPeso;
    }

    public void setRcPeso(Long rcPeso) {
        this.rcPeso = rcPeso;
    }

    public String getRcTalla() {
        return rcTalla;
    }

    public void setRcTalla(String rcTalla) {
        this.rcTalla = rcTalla;
    }

    public String getRcTemperatura() {
        return rcTemperatura;
    }

    public void setRcTemperatura(String rcTemperatura) {
        this.rcTemperatura = rcTemperatura;
    }

    public Long getRcImc() {
        return rcImc;
    }

    public void setRcImc(Long rcImc) {
        this.rcImc = rcImc;
    }

    public String getRcNotasenfermeria() {
        return rcNotasenfermeria;
    }

    public void setRcNotasenfermeria(String rcNotaenfermeria) {
        this.rcNotasenfermeria = rcNotaenfermeria;
    }

    public String getRcRazon() {
        return rcRazon;
    }

    public void setRcRazon(String rcRazon) {
        this.rcRazon = rcRazon;
    }

    public String getRcObservaciones() {
        return rcObservaciones;
    }

    public void setRcObservaciones(String rcObservaciones) {
        this.rcObservaciones = rcObservaciones;
    }

    public String getRcPlan() {
        return rcPlan;
    }

    public void setRcPlan(String rcPlan) {
        this.rcPlan = rcPlan;
    }

    public String getRcExamen() {
        return rcExamen;
    }

    public void setRcExamen(String rcExamen) {
        this.rcExamen = rcExamen;
    }

//    public CuExpediente getExpId() {
//        return expId;
//    }
//
//    public void setExpId(CuExpediente expId) {
//        this.expId = expId;
//    }

    public CuReporteCitaDto(Date rcFecha, Long rcId, String rcHora, String rcPresion, Long rcPeso, String rcTalla, String rcTemperatura, Long rcImc, String rcNotaenfermeria, String rcRazon, String rcObservaciones, String rcPlan, String rcExamen/*, CuExpediente expId*/) {
        this.rcFecha = rcFecha;
        this.rcId = rcId;
        this.rcHora = rcHora;
        this.rcPresion = rcPresion;
        this.rcPeso = rcPeso;
        this.rcTalla = rcTalla;
        this.rcTemperatura = rcTemperatura;
        this.rcImc = rcImc;
        this.rcNotasenfermeria = rcNotaenfermeria;
        this.rcRazon = rcRazon;
        this.rcObservaciones = rcObservaciones;
        this.rcPlan = rcPlan;
        this.rcExamen = rcExamen;
       // this.expId = expId;
    }

    
//    public CuReporteCitaDto(CuReportecita rc){
//        this.rcFecha = rc.getRcFecha();
//        this.rcId = rc.getRcId();
//        this.rcHora = rc.getRcHora();
//        this.rcPresion = rc.getRcPresion();
//        this.rcPeso = rc.getRcPeso();
//        this.rcTalla = rc.getRcTalla();
//        this.rcTemperatura = rc.getRcTemperatura();
//        this.rcImc = rc.getRcImc();
//        this.rcNotasenfermeria = rc.getRcNotasenfermeria();
//        this.rcRazon = rc.getRcRazon();
//        this.rcObservaciones = rc.getRcObservaciones();
//        this.rcPlan = rc.getRcPlan();
//        this.rcExamen = rc.getRcExamen();
//        this.expId = rc.getExpId();
//    }
}