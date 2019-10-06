/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.model;

import WsClinicaUNA.Dto.CuAntecedenteDto;
import java.io.Serializable;
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
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivana
 */
@Entity
@Table(name = "CU_ANTECEDENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuAntecedentes.findAll", query = "SELECT c FROM CuAntecedentes c")
    , @NamedQuery(name = "CuAntecedentes.findByAntTipo", query = "SELECT c FROM CuAntecedentes c WHERE c.antTipo = :antTipo")
    , @NamedQuery(name = "CuAntecedentes.findByAntTratamiento", query = "SELECT c FROM CuAntecedentes c WHERE c.antTratamiento = :antTratamiento")
    , @NamedQuery(name = "CuAntecedentes.findByAntHeredado", query = "SELECT c FROM CuAntecedentes c WHERE c.antHeredado = :antHeredado")
    , @NamedQuery(name = "CuAntecedentes.findByAntParentesco", query = "SELECT c FROM CuAntecedentes c WHERE c.antParentesco = :antParentesco")
    , @NamedQuery(name = "CuAntecedentes.findByAntEnfermedad", query = "SELECT c FROM CuAntecedentes c WHERE c.antEnfermedad = :antEnfermedad")
    , @NamedQuery(name = "CuAntecedentes.findByAntVersion", query = "SELECT c FROM CuAntecedentes c WHERE c.antVersion = :antVersion")
    , @NamedQuery(name = "CuAntecedentes.findByAntId", query = "SELECT c FROM CuAntecedentes c WHERE c.antId = :antId")})
public class CuAntecedentes implements Serializable {

   

    private static final long serialVersionUID = 1L;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ANT_ID_GENERATOR", sequenceName = "ANTECEDENTESSEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANT_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "ANT_ID")
    private Long antId;
    @Basic(optional = false)
    @Column(name = "ANT_TIPO")
    private String antTipo;
    @Column(name = "ANT_TRATAMIENTO")
    private String antTratamiento;
    @Column(name = "ANT_PARENTESCO")
    private String antParentesco;
    @Column(name = "ANT_ENFERMEDAD")
    private String antEnfermedad;
    @JoinColumn(name = "EXP_ID", referencedColumnName = "EXP_ID")
    @ManyToOne(optional = false)
    private CuExpediente expId;
    @Column(name = "ANT_HEREDADO")
    private Long antHeredado;
    @Version
    @Column(name = "ANT_VERSION")
    private Long antVersion;

    public CuAntecedentes() {
    }

    public CuAntecedentes(Long antId) {
        this.antId = antId;
    }

    public CuAntecedentes(Long antId, String antTipo, String antTratamiento, Long antHeredado, String antParentesco, String antEnfermedad, CuExpediente expId, Long antVersion) {
        this.antId = antId;
        this.antTipo = antTipo;
        this.antTratamiento = antTratamiento;
        this.antHeredado = antHeredado;
        this.antParentesco = antParentesco;
        this.antEnfermedad = antEnfermedad;
        this.expId = expId;
        this.antVersion = antVersion;
    }
    public CuAntecedentes(CuAntecedenteDto adto){
        this.antId = adto.getAntId();
        this.antTipo=adto.getAntTipo();
        this.antTratamiento=adto.getAntTratamiento();
        this.antHeredado = adto.getAntHederado(); // si ven eso me recuerderdan att:bran
        this.antParentesco= adto.getAntParentesco();
        this.antEnfermedad= adto.getAntParentesco();
        this.expId= new CuExpediente(adto.getExpId()); // esto esta  por terminarse.
        this.antVersion = adto.getAntVersion();
        
    }

    

    public String getAntTipo() {
        return antTipo;
    }

    public void setAntTipo(String antTipo) {
        this.antTipo = antTipo;
    }

    public String getAntTratamiento() {
        return antTratamiento;
    }

    public void setAntTratamiento(String antTratamiento) {
        this.antTratamiento = antTratamiento;
    }

    public Long getAntHeredado() {
        return antHeredado;
    }

    public void setAntHeredado(Long antHeredado) {
        this.antHeredado = antHeredado;
    }

    public String getAntParentesco() {
        return antParentesco;
    }

    public void setAntParentesco(String antParentesco) {
        this.antParentesco = antParentesco;
    }

    public String getAntEnfermedad() {
        return antEnfermedad;
    }

    public void setAntEnfermedad(String antEnfermedad) {
        this.antEnfermedad = antEnfermedad;
    }

    public Long getAntVersion() {
        return antVersion;
    }

    public void setAntVersion(Long antVersion) {
        this.antVersion = antVersion;
    }

    public Long getAntId() {
        return antId;
    }

    public void setAntId(Long antId) {
        this.antId = antId;
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
        hash += (antId != null ? antId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuAntecedentes)) {
            return false;
        }
        CuAntecedentes other = (CuAntecedentes) object;
        if ((this.antId == null && other.antId != null) || (this.antId != null && !this.antId.equals(other.antId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WsClinicaUNA.model.CuAntecedentes[ antId=" + antId + " ]";
    }

}
