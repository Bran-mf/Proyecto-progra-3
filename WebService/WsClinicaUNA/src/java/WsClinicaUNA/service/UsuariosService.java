/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.service;

import WsClinicaUNA.Dto.CuUsuarioDto;
import WsClinicaUNA.model.CuUsuarios;
import WsClinicaUNA.util.CodigoRespuesta;
import WsClinicaUNA.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ivana
 */

@Stateless
@LocalBean
public class UsuariosService {
    
    private static final Logger LOG = Logger.getLogger(UsuariosService.class.getName());
    @PersistenceContext(unitName = "WsClinicaUNAPU")
    private EntityManager em;
    
    public Respuesta Login(String usuario, String contrasena){
        try{
            Query query = em.createNamedQuery("CuUsuarios.Login", CuUsuarios.class);
            query.setParameter("usuUsuario", usuario);
            query.setParameter("usuContrasena", contrasena);
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Usuario", new CuUsuarioDto((CuUsuarios)query.getSingleResult()));
        }catch(NoResultException ex){
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un usuario con las credenciales ingresadas.", "validarUsuario NoResultException");
        }catch(NonUniqueResultException ex){
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario, mas de uno con mismo usuario o contrasena.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario NonUniqueResultException"); 
        }catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario " + ex.getMessage());
        }
    }
    
    public Respuesta guardarUsuario(CuUsuarioDto dto){
        try{
            CuUsuarios usuario;
            String mensaje;
            usuario = em.find(CuUsuarios.class, dto.getUsuCedula());
            if(usuario == null){
                usuario = new CuUsuarios(dto);
                em.persist(usuario);
                mensaje = "Su registro se realizo con exito";
            }else{
                usuario = new CuUsuarios(dto);
                em.merge(usuario);
                mensaje = "Su actualizacion se realizo con exito";
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "Su actualizacion se realizo con exito", "", "Usuario", new CuUsuarioDto(usuario));
        }catch(Exception ex){
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el usuario.", "guardarUsuario " + ex.getMessage());
        }
    }
    
    public Respuesta updateUser(String codAct){
        try{
            CuUsuarios usu;
            Query query = em.createNamedQuery("CuUsuarios.Activacion", CuUsuarios.class);
            query.setParameter("usuCodact", codAct);
            usu = (CuUsuarios) query.getSingleResult();
            usu.setUsuCodact("");
            usu.setUsuEstado("A");
            try{
                em.merge(usu);
                return new Respuesta(true, CodigoRespuesta.CORRECTO, "Su actualizacion se realizo con exito", "", "Usuario", new CuUsuarioDto(usu));
            }catch(Exception ex){
                LOG.log(Level.SEVERE, "Ocurrio un error al guardar el usuario.", ex);
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el usuario.", "guardarUsuario " + ex.getMessage());
            }
        }catch(NoResultException ex){
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un usuario con las credenciales ingresadas.", "activerUsurio NoResultException");
        }catch(NonUniqueResultException ex){
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario, mas de uno con mismo usuario o contrasena.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario NonUniqueResultException"); 
        }catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario " + ex.getMessage());
        }
    }
}
