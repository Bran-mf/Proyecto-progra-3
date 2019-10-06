/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.model;

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
@Table(name = "CU_EXAMEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuExamen.findAll", query = "SELECT c FROM CuExamen c")
    , @NamedQuery(name = "CuExamen.findByExaId", query = "SELECT c FROM CuExamen c WHERE c.exaId = :exaId")
    , @NamedQuery(name = "CuExamen.findByExaFecha", query = "SELECT c FROM CuExamen c WHERE c.exaFecha = :exaFecha")
    , @NamedQuery(name = "CuExamen.findByExaNombre", query = "SELECT c FROM CuExamen c WHERE c.exaNombre = :exaNombre")
    , @NamedQuery(name = "CuExamen.findByExaAnotacones", query = "SELECT c FROM CuExamen c WHERE c.exaAnotacones = :exaAnotacones")
    , @NamedQuery(name = "CuExamen.findByExaAdjunto", query = "SELECT c FROM CuExamen c WHERE c.exaAdjunto = :exaAdjunto")
    , @NamedQuery(name = "CuExamen.findByExaVersion", query = "SELECT c FROM CuExamen c WHERE c.exaVersion = :exaVersion")})
public class CuExamen implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "EXA_ID_GENERATOR", sequenceName = "EXAMENIDSEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXA_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "EXA_ID")
    private Long exaId;
    @Column(name = "EXA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exaFecha;
    @Column(name = "EXA_NOMBRE")
    private String exaNombre;
    @Column(name = "EXA_ANOTACONES")
    private String exaAnotacones;
    @Column(name = "EXA_ADJUNTO")
    private String exaAdjunto;
    @Version
    private Long exaVersion;
    @JoinColumn(name = "EXP_ID", referencedColumnName = "EXP_ID")
    @ManyToOne(optional = false)
    private CuExpediente expId;

    public CuExamen() {
    }

    public CuExamen(Long exaId) {
        this.exaId = exaId;
    }

    public Long getExaId() {
        return exaId;
    }

    public void setExaId(Long exaId) {
        this.exaId = exaId;
    }

    public Date getExaFecha() {
        return exaFecha;
    }

    public void setExaFecha(Date exaFecha) {
        this.exaFecha = exaFecha;
    }

    public String getExaNombre() {
        return exaNombre;
    }

    public void setExaNombre(String exaNombre) {
        this.exaNombre = exaNombre;
    }

    public String getExaAnotacones() {
        return exaAnotacones;
    }

    public void setExaAnotacones(String exaAnotacones) {
        this.exaAnotacones = exaAnotacones;
    }

    public String getExaAdjunto() {
        return exaAdjunto;
    }

    public void setExaAdjunto(String exaAdjunto) {
        this.exaAdjunto = exaAdjunto;
    }

    public Long getExaVersion() {
        return exaVersion;
    }

    public void setExaVersion(Long exaVersion) {
        this.exaVersion = exaVersion;
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
        hash += (exaId != null ? exaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuExamen)) {
            return false;
        }
        CuExamen other = (CuExamen) object;
        if ((this.exaId == null && other.exaId != null) || (this.exaId != null && !this.exaId.equals(other.exaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WsClinicaUNA.model.CuExamen[ exaId=" + exaId + " ]";
    }
    
}
