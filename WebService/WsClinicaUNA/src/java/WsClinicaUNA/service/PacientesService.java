/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.service;

import WsClinicaUNA.Dto.CuPacienteDto;
import WsClinicaUNA.model.CuPacientes;
import WsClinicaUNA.util.CodigoRespuesta;
import WsClinicaUNA.util.Respuesta;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bran
 */
@Stateless
@LocalBean
public class PacientesService {

    @PersistenceContext(unitName = "WsClinicaUNAPU")
    private EntityManager em;

    public Respuesta getPacientes() {
        try {
            Query query = em.createNamedQuery("CuPacientes.findAll");
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", query.getResultList());
        } catch (Exception ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error al obtener lso datos", "Error PacientesService lugar:Servidor");
        }
    }

    public Respuesta borrarPaciente(Long id) {
        try {
            if (id != null && id > 0) {
                CuPacientes cuPacientes;
                cuPacientes = em.find(CuPacientes.class, id);
                CuPacienteDto cuPacienteDto = new CuPacienteDto(cuPacientes);
                if (cuPacienteDto == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se encontro el atributo buscado", "error Paciente Lugar: Server No Target");
                } 
                em.remove(cuPacientes);

            }
            return new Respuesta(true,CodigoRespuesta.CORRECTO,"","");
            
        } catch (Exception ex) {
             return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "ocurrio un error", "Error Exception BorrarPaciente Lugar:Server");
        }
       
    }

}
