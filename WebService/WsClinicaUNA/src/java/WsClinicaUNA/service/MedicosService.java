/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.service;

import WsClinicaUNA.Dto.cuMedicoDto;
import WsClinicaUNA.model.CuMedicos;
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
public class MedicosService {

    @PersistenceContext(unitName = "WsClinicaUNAPU")
    private EntityManager em;

    public Respuesta getMedicos() {
        try {
            Query query = em.createNamedQuery("CuMedicos.findAll");
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", query.getResultList());

        } catch (Exception ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error al obtener los Medicos", "Error en Medicos Service getMedicos WS");
        }
    }

    public Respuesta eliminarMedico(String folio) {
        try {
            if (!folio.equals("")) {
                CuMedicos cuMedico;
                cuMedico = em.find(CuMedicos.class, folio);
                cuMedicoDto medicoDto = new cuMedicoDto(cuMedico);
                if (medicoDto == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el medico", "error cuMedico=null");
                }
                em.remove(folio);
            }
            return new Respuesta(true,CodigoRespuesta.CORRECTO,"","");
        } catch (Exception ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error interno al eliminar el  medico",
                    "Error en Medicos Service eliminarMedicos Ws");
        }
        

    }
//    public Respuesta GuardarMedico(cuMedicoDto dto){
//        try{
//           Query query = em.createNamedQuery("")
//        }
//    } //falta crear este metodo  en proceso
}
