/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WsClinicaUNA.controller;

import WsClinicaUNA.Dto.CuUsuarioDto;
import WsClinicaUNA.service.UsuariosService;
import WsClinicaUNA.util.CodigoRespuesta;
import WsClinicaUNA.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ivana
 */
@Path("/UsuariosController")
public class UsuariosController {

    @EJB
    UsuariosService service;
    
    @GET
    @Path("/login/{usuario}/{contrasena}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("usuario") String usuario, @PathParam("contrasena") String contrasena) {
        try {
            Respuesta res = service.Login(usuario, contrasena);
            if(!res.getEstado()){
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            return Response.ok((CuUsuarioDto) res.getResultado("Usuario")).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obtenido al iniciar el Ususario").build();
        }
    }
    
    @GET
    @Path("/save/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(@PathParam("user") CuUsuarioDto user){
        try{
            Respuesta res = service.guardarUsuario(user);
            if(!res.getEstado()){
                return Response.status(res.getCodigoRespuesta().getValue()).encoding(res.getMensaje()).build();
            }
            return Response.ok((CuUsuarioDto) res.getResultado("Usuario")).build();
        }catch(Exception ex){
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obtenido al iniciar el Ususario").build();
        }
    }
    
    @GET
    @Path("/activate/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response activateUser(@PathParam("code") CuUsuarioDto user){
        try{
            Respuesta res = service.guardarUsuario(user);
            if(!res.getEstado()){
                return Response.status(res.getCodigoRespuesta().getValue()).encoding(res.getMensaje()).build();
            }
            return Response.ok((CuUsuarioDto) res.getResultado("Usuario")).build();
        }catch(Exception ex){
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obtenido al iniciar el Ususario").build();
        }
    }
}
