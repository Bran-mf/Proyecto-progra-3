/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.model;

import WsClinicaUNA.Dto.CuMedicoDto;
import WsClinicaUNA.util.Convertidor;
import java.io.Serializable;
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
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivana
 */
@Entity
@Table(name = "CU_MEDICOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuMedicos.findAll", query = "SELECT c FROM CuMedicos c")
    , @NamedQuery(name = "CuMedicos.findByMedFolio", query = "SELECT c FROM CuMedicos c WHERE c.medFolio = :medFolio")
    , @NamedQuery(name = "CuMedicos.findByMedCodigo", query = "SELECT c FROM CuMedicos c WHERE c.medCodigo = :medCodigo")
    , @NamedQuery(name = "CuMedicos.findByMedCerne", query = "SELECT c FROM CuMedicos c WHERE c.medCerne = :medCerne")
    , @NamedQuery(name = "CuMedicos.findByMedEstado", query = "SELECT c FROM CuMedicos c WHERE c.medEstado = :medEstado")
    , @NamedQuery(name = "CuMedicos.findByMedInicio", query = "SELECT c FROM CuMedicos c WHERE c.medInicio = :medInicio")
    , @NamedQuery(name = "CuMedicos.findByMedFinal", query = "SELECT c FROM CuMedicos c WHERE c.medFinal = :medFinal")
    , @NamedQuery(name = "CuMedicos.findByMedEspacios", query = "SELECT c FROM CuMedicos c WHERE c.medEspacios = :medEspacios")
    , @NamedQuery(name = "CuMedicos.findByMedVersion", query = "SELECT c FROM CuMedicos c WHERE c.medVersion = :medVersion")})
public class CuMedicos implements Serializable {

    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    
    
    Convertidor conv = new Convertidor();
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "MED_ID_GENERATOR", sequenceName = "MEDICOSEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MED_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "MED_ID")
    private Long medId;
    @Basic(optional = false)
    @Column(name = "MED_FOLIO")
    private String medFolio;
    @Basic(optional = false)
    @Column(name = "MED_CODIGO")
    private String medCodigo;
    @Basic(optional = false)
    @Column(name = "MED_CERNE")
    private String medCerne;
    @Basic(optional = false)
    @Column(name = "MED_ESTADO")
    private String medEstado;
    @Basic(optional = false)
    @Column(name = "MED_INICIO")
    private String medInicio;
    @Basic(optional = false)
    @Column(name = "MED_FINAL")
    private String medFinal;
    @Basic(optional = false)
    @Column(name = "MED_ESPACIOS")
    private String medEspacios;
    @Version
    @Column(name = "MED_VERSION")
    private Long medVersion;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(optional = false)
    private CuUsuarios usuId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medFolio")
    private List<CuCitas> cuCitasList;

    public CuMedicos() {
    }

    public CuMedicos(Long medId, String medFolio, String medCodigo, String medCerne, String medEstado, String medInicio, String medFinal, String medEspacios, Long medVersion, CuUsuarios usuId) {
        this.medId = medId;
        this.medFolio = medFolio;
        this.medCodigo = medCodigo;
        this.medCerne = medCerne;
        this.medEstado = medEstado;
        this.medInicio = medInicio;
        this.medFinal = medFinal;
        this.medEspacios = medEspacios;
        this.medVersion = medVersion;
        this.usuId = usuId;
    }

    public void setMedId(Long medId) {
        this.medId = medId;
    }

    public Long getMedId() {
        return medId;
    }


    public String getMedFolio() {
        return medFolio;
    }

    public void setMedFolio(String medFolio) {
        this.medFolio = medFolio;
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


    @XmlTransient
    public List<CuCitas> getCuCitasList() {
        return cuCitasList;
    }

    public void setCuCitasList(List<CuCitas> cuCitasList) {
        this.cuCitasList = cuCitasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medFolio != null ? medFolio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuMedicos)) {
            return false;
        }
        CuMedicos other = (CuMedicos) object;
        if ((this.medFolio == null && other.medFolio != null) || (this.medFolio != null && !this.medFolio.equals(other.medFolio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WsClinicaUNA.model.CuMedicos[ medFolio=" + medFolio + " ]";
    }
    public CuMedicos(CuMedicoDto dto){
        this.cuCitasList= conv.dtoToCitas(dto.getListaCucitasDto());
        this.medCerne =dto.getMedCerne();
        this.medCodigo = dto.getMedCodigo();
        this.medEspacios = dto.getMedEspacios();
        this.medFinal = dto.getMedEspacios();
        this.medFinal= dto.getMedFinal();
        this.medFolio =dto.getMedFolio();
        this.medInicio =dto.getMedInicio();
        this.medVersion = dto.getMedVersion();
        
    }


    public CuUsuarios getUsuId() {
        return usuId;
    }

    public void setUsuId(CuUsuarios usuId) {
        this.usuId = usuId;
    }

    
}
