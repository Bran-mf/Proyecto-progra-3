/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.model;

import WsClinicaUNA.Dto.CuReporteCitaDto;
import WsClinicaUNA.util.Convertidor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivana
 */
@Entity
@Table(name = "CU_REPORTECITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuReportecita.findAll", query = "SELECT c FROM CuReportecita c")
    , @NamedQuery(name = "CuReportecita.findByRcFecha", query = "SELECT c FROM CuReportecita c WHERE c.rcFecha = :rcFecha")
    , @NamedQuery(name = "CuReportecita.findByRcId", query = "SELECT c FROM CuReportecita c WHERE c.rcId = :rcId")
    , @NamedQuery(name = "CuReportecita.findByRcHora", query = "SELECT c FROM CuReportecita c WHERE c.rcHora = :rcHora")
    , @NamedQuery(name = "CuReportecita.findByRcPresion", query = "SELECT c FROM CuReportecita c WHERE c.rcPresion = :rcPresion")
    , @NamedQuery(name = "CuReportecita.findByRcPeso", query = "SELECT c FROM CuReportecita c WHERE c.rcPeso = :rcPeso")
    , @NamedQuery(name = "CuReportecita.findByRcTalla", query = "SELECT c FROM CuReportecita c WHERE c.rcTalla = :rcTalla")
    , @NamedQuery(name = "CuReportecita.findByRcTemperatura", query = "SELECT c FROM CuReportecita c WHERE c.rcTemperatura = :rcTemperatura")
    , @NamedQuery(name = "CuReportecita.findByRcImc", query = "SELECT c FROM CuReportecita c WHERE c.rcImc = :rcImc")
    , @NamedQuery(name = "CuReportecita.findByRcNotasenfermeria", query = "SELECT c FROM CuReportecita c WHERE c.rcNotasenfermeria = :rcNotasenfermeria")
    , @NamedQuery(name = "CuReportecita.findByRcRazon", query = "SELECT c FROM CuReportecita c WHERE c.rcRazon = :rcRazon")
    , @NamedQuery(name = "CuReportecita.findByRcObservaciones", query = "SELECT c FROM CuReportecita c WHERE c.rcObservaciones = :rcObservaciones")
    , @NamedQuery(name = "CuReportecita.findByRcPlan", query = "SELECT c FROM CuReportecita c WHERE c.rcPlan = :rcPlan")
    , @NamedQuery(name = "CuReportecita.findByRcExamen", query = "SELECT c FROM CuReportecita c WHERE c.rcExamen = :rcExamen")
    , @NamedQuery(name = "CuReportecita.findByRcTratamiento", query = "SELECT c FROM CuReportecita c WHERE c.rcTratamiento = :rcTratamiento")
    , @NamedQuery(name = "CuReportecita.findByRcVersion", query = "SELECT c FROM CuReportecita c WHERE c.rcVersion = :rcVersion")})
public class CuReportecita implements Serializable {

    

    private static final long serialVersionUID = 1L;
    Convertidor conv = new Convertidor();
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "RC_ID_GENERATOR", sequenceName = "EXPEDIENTESEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RC_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "RC_ID")
    private Long rcId;
    @Basic(optional = false)
    @Column(name = "RC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rcFecha;
    @Column(name = "RC_HORA")
    private String rcHora;
    @Column(name = "RC_PRESION")
    private String rcPresion;
    @Column(name = "RC_TALLA")
    private String rcTalla;
    @Column(name = "RC_TEMPERATURA")
    private String rcTemperatura;
    @Column(name = "RC_NOTASENFERMERIA")
    private String rcNotasenfermeria;
    @Column(name = "RC_RAZON")
    private String rcRazon;
    @Column(name = "RC_OBSERVACIONES")
    private String rcObservaciones;
    @Column(name = "RC_PLAN")
    private String rcPlan;
    @Column(name = "RC_EXAMEN")
    private String rcExamen;
    @Column(name = "RC_TRATAMIENTO")
    private String rcTratamiento;
    @Column(name = "RC_PESO")
    private Long rcPeso;
    @Column(name = "RC_IMC")
    private Long rcImc;
    @Version
    @Column(name = "RC_VERSION")
    private Long rcVersion;
    @Column(name = "RC_FRECCARD")
    private String rcFreccard;
    @JoinColumn(name = "EXP_ID", referencedColumnName = "EXP_ID")
    @ManyToOne(optional = false)
    private CuExpediente expId;

    public CuReportecita() {
    }

    public CuReportecita(Long rcId) {
        this.rcId = rcId;
    }

    public CuReportecita(Long rcId, Date rcFecha) {
        this.rcId = rcId;
        this.rcFecha = rcFecha;
    }

    public CuReportecita(Long rcId, Date rcFecha, String rcHora, String rcPresion, Long rcPeso, String rcTalla, String rcTemperatura, Long rcImc, String rcNotasenfermeria, String rcRazon, String rcObservaciones, String rcPlan, String rcExamen, String rcTratamiento, Long rcVersion, CuExpediente expId) {
        this.rcId = rcId;
        this.rcFecha = rcFecha;
        this.rcHora = rcHora;
        this.rcPresion = rcPresion;
        this.rcPeso = rcPeso;
        this.rcTalla = rcTalla;
        this.rcTemperatura = rcTemperatura;
        this.rcImc = rcImc;
        this.rcNotasenfermeria = rcNotasenfermeria;
        this.rcRazon = rcRazon;
        this.rcObservaciones = rcObservaciones;
        this.rcPlan = rcPlan;
        this.rcExamen = rcExamen;
        this.rcTratamiento = rcTratamiento;
        this.rcVersion = rcVersion;
        this.expId = expId;
    }

    public CuReportecita(CuReporteCitaDto dto) {
        this.expId = new CuExpediente(dto.getExpId());
        this.rcExamen = dto.getRcExamen();
        this.rcFecha = dto.getRcFecha();
        this.rcHora = dto.getRcHora();
        this.rcId = dto.getRcId();
        this.rcImc = dto.getRcImc();
        this.rcNotasenfermeria = dto.getRcNotasenfermeria();
        this.rcObservaciones = dto.getRcObservaciones();
        this.rcPeso = dto.getRcPeso();
        this.rcPlan = dto.getRcPlan();
        this.rcPresion = dto.getRcPlan();
        this.rcPresion = dto.getRcPresion();
        this.rcRazon = dto.getRcPresion();
        this.rcTalla = dto.getRcTalla();
        this.rcTemperatura = dto.getRcTemperatura();
        this.rcTratamiento = dto.getRcTratamiento();
        
    }

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

    public void setRcNotasenfermeria(String rcNotasenfermeria) {
        this.rcNotasenfermeria = rcNotasenfermeria;
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

    public String getRcTratamiento() {
        return rcTratamiento;
    }

    public void setRcTratamiento(String rcTratamiento) {
        this.rcTratamiento = rcTratamiento;
    }

    public Long getRcVersion() {
        return rcVersion;
    }

    public void setRcVersion(Long rcVersion) {
        this.rcVersion = rcVersion;
    }

    public CuExpediente getExpId() {
        return expId;
    }

    public void setExpId(CuExpediente expId) {
        this.expId = expId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rcId != null ? rcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuReportecita)) {
            return false;
        }
        CuReportecita other = (CuReportecita) object;
        if ((this.rcId == null && other.rcId != null) || (this.rcId != null && !this.rcId.equals(other.rcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WsClinicaUNA.model.CuReportecita[ rcId=" + rcId + " ]";
    }

    public String getRcFreccard() {
        return rcFreccard;
    }

    public void setRcFreccard(String rcFreccard) {
        this.rcFreccard = rcFreccard;
    }

}
