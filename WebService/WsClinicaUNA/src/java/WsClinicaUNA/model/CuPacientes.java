/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.model;

import WsClinicaUNA.Dto.CuPacienteDto;
import WsClinicaUNA.util.Convertidor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivana
 */
@Entity
@Table(name = "CU_PACIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuPacientes.findAll", query = "SELECT c FROM CuPacientes c")
    , @NamedQuery(name = "CuPacientes.findByPacNombre", query = "SELECT c FROM CuPacientes c WHERE c.pacNombre = :pacNombre")
    , @NamedQuery(name = "CuPacientes.findByPacApellido", query = "SELECT c FROM CuPacientes c WHERE c.pacApellido = :pacApellido")
    , @NamedQuery(name = "CuPacientes.findByPacCedula", query = "SELECT c FROM CuPacientes c WHERE c.pacCedula = :pacCedula")
    , @NamedQuery(name = "CuPacientes.findByPacCorreo", query = "SELECT c FROM CuPacientes c WHERE c.pacCorreo = :pacCorreo")
    , @NamedQuery(name = "CuPacientes.findByPacGenero", query = "SELECT c FROM CuPacientes c WHERE c.pacGenero = :pacGenero")
    , @NamedQuery(name = "CuPacientes.findByPacNacimiento", query = "SELECT c FROM CuPacientes c WHERE c.pacNacimiento = :pacNacimiento")
    , @NamedQuery(name = "CuPacientes.findByPacVersion", query = "SELECT c FROM CuPacientes c WHERE c.pacVersion = :pacVersion")})
public class CuPacientes implements Serializable {

    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    Convertidor conv = new Convertidor();
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "PAC_ID_GENERATOR", sequenceName = "PACIENTESEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAC_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "PAC_ID")
    private Long pacId;
    @Basic(optional = false)
    @Column(name = "PAC_CEDULA")
    private String pacCedula;
    @Basic(optional = false)
    @Column(name = "PAC_NOMBRE")
    private String pacNombre;
    @Basic(optional = false)
    @Column(name = "PAC_APELLIDO")
    private String pacApellido;
    @Basic(optional = false)
    @Column(name = "PAC_CORREO")
    private String pacCorreo;
    @Basic(optional = false)
    @Column(name = "PAC_GENERO")
    private String pacGenero;
    @Basic(optional = false)
    @Column(name = "PAC_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacNacimiento;
    @Version
    @Column(name = "PAC_VERSION")
    private Long pacVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacCedula")
    private List<CuExpediente> cuExpedienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacCedula")
    private List<CuCitas> cuCitasList;

    public CuPacientes() {
    }

    public CuPacientes(Long pacId, String pacCedula, String pacNombre, String pacApellido, String pacCorreo, String pacGenero, Date pacNacimiento, Long pacVersion) {
        this.pacId = pacId;
        this.pacCedula = pacCedula;
        this.pacNombre = pacNombre;
        this.pacApellido = pacApellido;
        this.pacCorreo = pacCorreo;
        this.pacGenero = pacGenero;
        this.pacNacimiento = pacNacimiento;
        this.pacVersion = pacVersion;
    }

    

    public CuPacientes(CuPacienteDto cuPacienteDto) {
        this.pacNombre =cuPacienteDto.getPacNombre();
        this.pacCedula=cuPacienteDto.getPacCedula();
        this.pacApellido=cuPacienteDto.getPacApellido();
        this.pacGenero=cuPacienteDto.getPacGenero();
        this.pacVersion =cuPacienteDto.getVersion();
        this.pacCorreo=cuPacienteDto.getPacCorreo();
        this.pacNacimiento =cuPacienteDto.getPacNacimiento(); //revisar
        this.cuCitasList=conv.dtoToCitas(cuPacienteDto.getListaCitas());
        this.cuExpedienteList =conv.dtoToExpediente(cuPacienteDto.getListaExpedientes());
        
    }

    CuPacientes(CuPacientes cuPaciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPacNombre() {
        return pacNombre;
    }

    public void setPacNombre(String pacNombre) {
        this.pacNombre = pacNombre;
    }

    public String getPacApellido() {
        return pacApellido;
    }

    public void setPacApellido(String pacApellido) {
        this.pacApellido = pacApellido;
    }

    public String getPacCedula() {
        return pacCedula;
    }

    public void setPacCedula(String pacCedula) {
        this.pacCedula = pacCedula;
    }

    public String getPacCorreo() {
        return pacCorreo;
    }

    public void setPacCorreo(String pacCorreo) {
        this.pacCorreo = pacCorreo;
    }

    public String getPacGenero() {
        return pacGenero;
    }

    public void setPacGenero(String pacGenero) {
        this.pacGenero = pacGenero;
    }

    public Date getPacNacimiento() {
        return pacNacimiento;
    }

    public void setPacNacimiento(Date pacNacimiento) {
        this.pacNacimiento = pacNacimiento;
    }

    public Long getPacVersion() {
        return pacVersion;
    }

    public void setPacVersion(Long pacVersion) {
        this.pacVersion = pacVersion;
    }

    @XmlTransient
    public List<CuExpediente> getCuExpedienteList() {
        return cuExpedienteList;
    }

    public void setCuExpedienteList(List<CuExpediente> cuExpedienteList) {
        this.cuExpedienteList = cuExpedienteList;
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
        hash += (pacCedula != null ? pacCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuPacientes)) {
            return false;
        }
        CuPacientes other = (CuPacientes) object;
        if ((this.pacCedula == null && other.pacCedula != null) || (this.pacCedula != null && !this.pacCedula.equals(other.pacCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WsClinicaUNA.model.CuPacientes[ pacCedula=" + pacCedula + " ]";
    }

    public CuPacientes(Long pacId) {
        this.pacId = pacId;
    }


    public Long getPacId() {
        return pacId;
    }

    public void setPacId(Long pacId) {
        this.pacId = pacId;
    }

    
    
}
