/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.model;

import WsClinicaUNA.Dto.CuUsuarioDto;
import WsClinicaUNA.util.Convertidor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivana
 */
@Entity
@Table(name = "CU_USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuUsuarios.findAll", query = "SELECT c FROM CuUsuarios c")
    , @NamedQuery(name = "CuUsuarios.findByUsuNombre", query = "SELECT c FROM CuUsuarios c WHERE c.usuNombre = :usuNombre")
    , @NamedQuery(name = "CuUsuarios.findByUsuApellido", query = "SELECT c FROM CuUsuarios c WHERE c.usuApellido = :usuApellido")
    , @NamedQuery(name = "CuUsuarios.findByUsuCedula", query = "SELECT c FROM CuUsuarios c WHERE c.usuCedula = :usuCedula")
    , @NamedQuery(name = "CuUsuarios.findByUsuCorreo", query = "SELECT c FROM CuUsuarios c WHERE c.usuCorreo = :usuCorreo")
    , @NamedQuery(name = "CuUsuarios.findByUsuTipo", query = "SELECT c FROM CuUsuarios c WHERE c.usuTipo = :usuTipo")
    , @NamedQuery(name = "CuUsuarios.findByUsuIdioma", query = "SELECT c FROM CuUsuarios c WHERE c.usuIdioma = :usuIdioma")
    , @NamedQuery(name = "CuUsuarios.findByUsuEstado", query = "SELECT c FROM CuUsuarios c WHERE c.usuEstado = :usuEstado")
    , @NamedQuery(name = "CuUsuarios.findByUsuUsuario", query = "SELECT c FROM CuUsuarios c WHERE c.usuUsuario = :usuUsuario")
    , @NamedQuery(name = "CuUsuarios.findByUsuContrasena", query = "SELECT c FROM CuUsuarios c WHERE c.usuContrasena = :usuContrasena")
    , @NamedQuery(name = "CuUsuarios.findByUsuVersion", query = "SELECT c FROM CuUsuarios c WHERE c.usuVersion = :usuVersion")
    , @NamedQuery(name = "CuUsuarios.findByUsuTemp", query = "SELECT c FROM CuUsuarios c WHERE c.usuTemp = :usuTemp")
    , @NamedQuery(name = "CuUsuarios.Login", query = "SELECT c FROM CuUsuarios c WHERE c.usuUsuario = :usuUsuario and c.usuContrasena = :usuContrasena")
    , @NamedQuery(name = "CuUsuarios.Activacion", query = "SELECT c FROM CuUsuarios c WHERE c.usuCodact = :usuCodact")
})
public class CuUsuarios implements Serializable {
    
    Convertidor conv = new Convertidor();
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "USU_ID_GENERATOR", sequenceName = "USUARIOSEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USU_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "USU_ID")
    private Long usuId;
    @Basic(optional = false)
    @Column(name = "USU_CEDULA")
    private String usuCedula;
    @Basic(optional = false)
    @Column(name = "USU_NOMBRE")
    private String usuNombre;
    @Basic(optional = false)
    @Column(name = "USU_APELLIDO")
    private String usuApellido;
    @Basic(optional = false)
    @Column(name = "USU_CORREO")
    private String usuCorreo;
    @Basic(optional = false)
    @Column(name = "USU_TIPO")
    private String usuTipo;
    @Basic(optional = false)
    @Column(name = "USU_IDIOMA")
    private String usuIdioma;
    @Basic(optional = false)
    @Column(name = "USU_ESTADO")
    private String usuEstado;
    @Basic(optional = false)
    @Column(name = "USU_USUARIO")
    private String usuUsuario;
    @Basic(optional = false)
    @Column(name = "USU_CONTRASENA")
    private String usuContrasena;
    @Basic(optional = false)
    @Column(name = "USU_TEMP")
    private String usuTemp;
    @Column(name = "USU_CODACT")
    private String usuCodact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuCedula")
    private List<CuMedicos> cuMedicosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuCedula")
    private List<CuCitas> cuCitasList;
    @Version
    @Column(name = "USU_VERSION")
    private Long usuVersion;
    
    public CuUsuarios() {
    }

    public CuUsuarios(String usuCedula) {
        this.usuCedula = usuCedula;
    }

    public CuUsuarios(String usuCedula, String usuNombre, String usuApellido, String usuCorreo, String usuTipo, String usuIdioma, String usuEstado, String usuUsuario, String usuContrasena, String usuTemp) {
        this.usuCedula = usuCedula;
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuCorreo = usuCorreo;
        this.usuTipo = usuTipo;
        this.usuIdioma = usuIdioma;
        this.usuEstado = usuEstado;
        this.usuUsuario = usuUsuario;
        this.usuContrasena = usuContrasena;
        this.usuTemp = usuTemp;
    }
    
    public CuUsuarios(CuUsuarioDto dto){
        this.usuCedula = dto.getUsuCedula();
        this.usuNombre = dto.getUsuNombre();
        this.usuApellido = dto.getUsuApellido();
        this.usuCorreo = dto.getUsuCorreo();
        this.usuTipo = dto.getUsuTipo();
        this.usuIdioma = dto.getUsuIdioma();
        this.usuEstado = dto.getUsuEstado();
        this.usuUsuario = dto.getUsuUsuario();
        this.usuContrasena = dto.getUsuContrasena();
        this.usuTemp = dto.getUsuTemp();
        this.usuCodact = dto.getUsuCodact();
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuCedula() {
        return usuCedula;
    }

    public void setUsuCedula(String usuCedula) {
        this.usuCedula = usuCedula;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuTipo() {
        return usuTipo;
    }

    public void setUsuTipo(String usuTipo) {
        this.usuTipo = usuTipo;
    }

    public String getUsuIdioma() {
        return usuIdioma;
    }

    public void setUsuIdioma(String usuIdioma) {
        this.usuIdioma = usuIdioma;
    }

    public String getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public Long getUsuVersion() {
        return usuVersion;
    }

    public void setUsuVersion(Long usuVersion) {
        this.usuVersion = usuVersion;
    }

    public String getUsuTemp() {
        return usuTemp;
    }

    public void setUsuTemp(String usuTemp) {
        this.usuTemp = usuTemp;
    }

    @XmlTransient
    public List<CuMedicos> getCuMedicosList() {
        return cuMedicosList;
    }

    public void setCuMedicosList(List<CuMedicos> cuMedicosList) {
        this.cuMedicosList = cuMedicosList;
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
        hash += (usuCedula != null ? usuCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuUsuarios)) {
            return false;
        }
        CuUsuarios other = (CuUsuarios) object;
        if ((this.usuCedula == null && other.usuCedula != null) || (this.usuCedula != null && !this.usuCedula.equals(other.usuCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WsClinicaUNA.model.CuUsuarios[ usuCedula=" + usuCedula + " ]";
    }
    
    public String getUsuCodact() {
        return usuCodact;
    }

    public void setUsuCodact(String usuCodact) {
        this.usuCodact = usuCodact;
    }

    public CuUsuarios(Long usuId) {
        this.usuId = usuId;
    }

    public CuUsuarios(Long usuId, String usuContrasena) {
        this.usuId = usuId;
        this.usuContrasena = usuContrasena;
    }

    public String getUsuContraseña() {
        return usuContrasena;
    }

    public void setUsuContraseña(String usuContraseña) {
        this.usuContrasena = usuContraseña;
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }
    
}
