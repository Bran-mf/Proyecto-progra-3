/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.model;

import WsClinicaUNA.Dto.CuCitasDto;
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
    @Version
    @Column(name = "CIT_VERSION")
    private Long citVersion;
    @JoinColumn(name = "MED", referencedColumnName = "MED_ID")
    @ManyToOne(optional = false)
    private CuMedicos med;
    @JoinColumn(name = "PAC_ID", referencedColumnName = "PAC_ID")
    @ManyToOne(optional = false)
    private CuPacientes pacId;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(optional = false)
    private CuUsuarios usuId;

    public CuCitas() {
    }

    public CuCitas(Long citId) {
        this.citId = citId;
    }

    public CuCitas(Long citId, String citEstado, String citMotivo, String citTelefono, String citCorreo, Date citFecha, String citHora, String citEspacios, Long citVersion, CuMedicos med, CuPacientes pacId, CuUsuarios usuId) {
        this.citId = citId;
        this.citEstado = citEstado;
        this.citMotivo = citMotivo;
        this.citTelefono = citTelefono;
        this.citCorreo = citCorreo;
        this.citFecha = citFecha;
        this.citHora = citHora;
        this.citEspacios = citEspacios;
        this.citVersion = citVersion;
        this.med = med;
        this.pacId = pacId;
        this.usuId = usuId;
    }

    
    
    public CuCitas(CuCitasDto cucitasDto){
        this.citId=cucitasDto.getCitId();
        this.citEstado= cucitasDto.getCitEstado();
        this.citMotivo=cucitasDto.getCitMotivo();
        this.citTelefono = cucitasDto.getCitTelefono();
        this.citCorreo= cucitasDto.getCitCorreo();
        this.citFecha =cucitasDto.getCitFecha();
        this.citHora =cucitasDto.getCitHora();
        this.citEspacios=cucitasDto.getCitEspacios();
        this.med=new CuMedicos(cucitasDto.getMed());// por terminar
        this.pacId= new CuPacientes(cucitasDto.getPacId());
        this.usuId= new CuUsuarios(cucitasDto.getUsuId());
        this.citVersion=cucitasDto.getCitVersion();
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

    public CuMedicos getMed() {
        return med;
    }

    public void setMed(CuMedicos med) {
        this.med = med;
    }

    public CuPacientes getPacId() {
        return pacId;
    }

    public void setPacId(CuPacientes pacId) {
        this.pacId = pacId;
    }

    public CuUsuarios getUsuId() {
        return usuId;
    }

    public void setUsuId(CuUsuarios usuId) {
        this.usuId = usuId;
    }
    
}
