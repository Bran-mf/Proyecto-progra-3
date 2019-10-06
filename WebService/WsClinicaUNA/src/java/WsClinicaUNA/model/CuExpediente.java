/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivana
 */
@Entity
@Table(name = "CU_EXPEDIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuExpediente.findAll", query = "SELECT c FROM CuExpediente c")
    , @NamedQuery(name = "CuExpediente.findByExpId", query = "SELECT c FROM CuExpediente c WHERE c.expId = :expId")})
public class CuExpediente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "EXP_ID_GENERATOR", sequenceName = "AMTECEDENTESSEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXP_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "EXP_ID")
    private BigDecimal expId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expId")
    private List<CuReportecita> cuReportecitaList;
    @JoinColumn(name = "PAC_CEDULA", referencedColumnName = "PAC_CEDULA")
    @ManyToOne(optional = false)
    private CuPacientes pacCedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expId")
    private List<CuExamen> cuExamenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expId")
    private List<CuAntecedentes> cuAntecedentesList;

    public CuExpediente() {
    }

    public CuExpediente(BigDecimal expId) {
        this.expId = expId;
    }

    public BigDecimal getExpId() {
        return expId;
    }

    public void setExpId(BigDecimal expId) {
        this.expId = expId;
    }

    @XmlTransient
    public List<CuReportecita> getCuReportecitaList() {
        return cuReportecitaList;
    }

    public void setCuReportecitaList(List<CuReportecita> cuReportecitaList) {
        this.cuReportecitaList = cuReportecitaList;
    }

    public CuPacientes getPacCedula() {
        return pacCedula;
    }

    public void setPacCedula(CuPacientes pacCedula) {
        this.pacCedula = pacCedula;
    }

    @XmlTransient
    public List<CuExamen> getCuExamenList() {
        return cuExamenList;
    }

    public void setCuExamenList(List<CuExamen> cuExamenList) {
        this.cuExamenList = cuExamenList;
    }

    @XmlTransient
    public List<CuAntecedentes> getCuAntecedentesList() {
        return cuAntecedentesList;
    }

    public void setCuAntecedentesList(List<CuAntecedentes> cuAntecedentesList) {
        this.cuAntecedentesList = cuAntecedentesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expId != null ? expId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuExpediente)) {
            return false;
        }
        CuExpediente other = (CuExpediente) object;
        if ((this.expId == null && other.expId != null) || (this.expId != null && !this.expId.equals(other.expId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WsClinicaUNA.model.CuExpediente[ expId=" + expId + " ]";
    }
    
}
