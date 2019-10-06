/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.Dto;

import WsClinicaUNA.model.CuPacientes;
import WsClinicaUNA.util.Convertidor;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bran
 */
@XmlRootElement(name="Paciente") //
@XmlAccessorType(XmlAccessType.FIELD)
public class CuPacienteDto {
    private String pacCedula;
    private String pacNombre;
    private String  pacApellido;
    private String pacCorreo;
    private String pacGenero;
    private Date pacNacimiento;
    private Long version;
    List<CuExpedienteDto> listaExpedientes;
    List<CuCitasDto> listaCitas;
    //metodos
    //get and set
    Convertidor conv = new Convertidor();

    public String getPacCedula() {
        return pacCedula;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<CuExpedienteDto> getListaExpedientes() {
        return listaExpedientes;
    }

    public void setListaExpedientes(List<CuExpedienteDto> listaExpedientes) {
        this.listaExpedientes = listaExpedientes;
    }

    public List<CuCitasDto> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(List<CuCitasDto> listaCitas) {
        this.listaCitas = listaCitas;
    }
    

    public void setPacCedula(String pacCedula) {
        this.pacCedula = pacCedula;
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

    public CuPacienteDto(String pacCedula, String pacNombre, String pacApellido, String pacCorreo, String pacGenero, Date pacNacimiento) {
        this.pacCedula = pacCedula;
        this.pacNombre = pacNombre;
        this.pacApellido = pacApellido;
        this.pacCorreo = pacCorreo;
        this.pacGenero = pacGenero;
        this.pacNacimiento = pacNacimiento;
    }
   
    public CuPacienteDto(CuPacientes paciente){
       this.pacCedula = paciente.getPacCedula();
        this.pacNombre = paciente.getPacNombre();
        this.pacApellido = paciente.getPacApellido();
        this.pacCorreo = paciente.getPacCorreo();
        this.pacGenero = paciente.getPacGenero();
        this.pacNacimiento = paciente.getPacNacimiento();
        this.listaExpedientes =conv.ModeloToDtoExpediente(paciente.getCuExpedienteList());
        this.listaCitas = conv.ModeloToDtoCitas(paciente.getCuCitasList());
    }
}
