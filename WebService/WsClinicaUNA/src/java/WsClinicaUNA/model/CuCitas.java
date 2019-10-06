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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivana
 */
@Entity
@Table(name = "CU_CITAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuCitas.findAll", query = "SELECT c FROM CuCitas c")
    , @NamedQuery(name = "CuCitas.findByCitEstado", query = "SELECT c FROM CuCitas c WHERE c.citEstado = :citEstado")
    , @NamedQuery(name = "CuCitas.findByCitMotivo", query = "SELECT c FROM CuCitas c WHERE c.citMotivo = :citMotivo")
    , @NamedQuery(name = "CuCitas.findByCitTelefono", query = "SELECT c FROM CuCitas c WHERE c.citTelefono = :citTelefono")
    , @NamedQuery(name = "CuCitas.findByCitCorreo", query = "SELECT c FROM CuCitas c WHERE c.citCorreo = :citCorreo")
    , @NamedQuery(name = "CuCitas.findByCitVersion", query = "SELECT c FROM CuCitas c WHERE c.citVersion = :citVersion")
    , @NamedQuery(name = "CuCitas.findByCitFecha", query = "SELECT c FROM CuCitas c WHERE c.citFecha = :citFecha")
    , @NamedQuery(name = "CuCitas.findByCitHora", query = "SELECT c FROM CuCitas c WHERE c.citHora = :citHora")
    , @NamedQuery(name = "CuCitas.findByCitEspacios", query = "SELECT c FROM CuCitas c WHERE c.citEspacios = :citEspacios")
    , @NamedQuery(name = "CuCitas.findByCitId", query = "SELECT c FROM CuCitas c WHERE c.citId = :citId")})
public class CuCitas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "CIT_ID_GENERATOR", sequenceName = "CITASIDSEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIT_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "CIT_ID")
    private Long citId;
    @Basic(optional = false)
    @Column(name = "CIT_ESTADO")
    private String citEstado;
    @Column(name = "CIT_MOTIVO")
    private String citMotivo;
    @Basic(optional = false)
    @Column(name = "CIT_TELEFONO")
    private String citTelefono;
    @Basic(optional = false)
    @Column(name = "CIT_CORREO")
    private String citCorreo;
    @Basic(optional = false)
    @Column(name = "CIT_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date citFecha;
    @Basic(optional = false)
    @Column(name = "CIT_HORA")
    private String citHora;
    @Basic(optional = false)
    @Column(name = "CIT_ESPACIOS")
    private String citEspacios;
    @JoinColumn(name = "MED_FOLIO", referencedColumnName = "MED_FOLIO")
    @ManyToOne(optional = false)
    private CuMedicos medFolio;
    @JoinColumn(name = "PAC_CEDULA", referencedColumnName = "PAC_CEDULA")
    @ManyToOne(optional = false)
    private CuPacientes pacCedula;
    @JoinColumn(name = "USU_CEDULA", referencedColumnName = "USU_CEDULA")
    @ManyToOne(optional = false)
    private CuUsuarios usuCedula;
    @Column(name = "CIT_VERSION")
    private Long citVersion;

    public CuCitas() {
    }

    public CuCitas(Long citId) {
        this.citId = citId;
    }

    public CuCitas(Long citId, String citEstado, String citMotivo, String citTelefono, String citCorreo, Date citFecha, String citHora, String citEspacios, CuMedicos medFolio, CuPacientes pacCedula, CuUsuarios usuCedula, Long citVersion) {
        this.citId = citId;
        this.citEstado = citEstado;
        this.citMotivo = citMotivo;
        this.citTelefono = citTelefono;
        this.citCorreo = citCorreo;
        this.citFecha = citFecha;
        this.citHora = citHora;
        this.citEspacios = citEspacios;
        this.medFolio = medFolio;
        this.pacCedula = pacCedula;
        this.usuCedula = usuCedula;
        this.citVersion = citVersion;
    }

    

    public String getCitEstado() {
        return citEstado;
    }

    public void setCitEstado(String citEstado) {
        this.citEstado = citEstado;
    }

    public String getCitMotivo() {
        return citMotivo;
    }

    public void setCitMotivo(String citMotivo) {
        this.citMotivo = citMotivo;
    }

    public String getCitTelefono() {
        return citTelefono;
    }

    public void setCitTelefono(String citTelefono) {
        this.citTelefono = citTelefono;
    }

    public String getCitCorreo() {
        return citCorreo;
    }

    public void setCitCorreo(String citCorreo) {
        this.citCorreo = citCorreo;
    }

    public Long getCitVersion() {
        return citVersion;
    }

    public void setCitVersion(Long citVersion) {
        this.citVersion = citVersion;
    }

    public Date getCitFecha() {
        return citFecha;
    }

    public void setCitFecha(Date citFecha) {
        this.citFecha = citFecha;
    }

    public String getCitHora() {
        return citHora;
    }

    public void setCitHora(String citHora) {
        this.citHora = citHora;
    }

    public String getCitEspacios() {
        return citEspacios;
    }

    public void setCitEspacios(String citEspacios) {
        this.citEspacios = citEspacios;
    }

    public Long getCitId() {
        return citId;
    }

    public void setCitId(Long citId) {
        this.citId = citId;
    }

    public CuMedicos getMedFolio() {
        return medFolio;
    }

    public void setMedFolio(CuMedicos medFolio) {
        this.medFolio = medFolio;
    }

    public CuPacientes getPacCedula() {
        return pacCedula;
    }

    public void setPacCedula(CuPacientes pacCedula) {
        this.pacCedula = pacCedula;
    }

    public CuUsuarios getUsuCedula() {
        return usuCedula;
    }

    public void setUsuCedula(CuUsuarios usuCedula) {
        this.usuCedula = usuCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citId != null ? citId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuCitas)) {
            return false;
        }
        CuCitas other = (CuCitas) object;
        if ((this.citId == null && other.citId != null) || (this.citId != null && !this.citId.equals(other.citId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WsClinicaUNA.model.CuCitas[ citId=" + citId + " ]";
    }
    
}
