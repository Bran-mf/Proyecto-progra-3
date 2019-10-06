/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Service;

import java.nio.charset.CodingErrorAction;
import java.util.HashMap;
import java.util.Map;
import proyecto.Dto.CuUsuarioDto;
import proyecto.util.Request;
import proyecto.util.Respuesta;

/**
 *
 * @author Bran
 */
public class UsuarioService {
    public Respuesta getUsuario(String usuario,String password){
        try{
            Map<String,Object> parametros = new HashMap<>();
            parametros.put("usuario", usuario);
            parametros.put("contrasena", password);
            Request request = new Request("UsuariosController/login","/{usuario}/{contrasena}",parametros);
            request.get();
            if(request.isError()){
                return new Respuesta(false,request.getError(),"");
            }
            CuUsuarioDto usuarioDto = (CuUsuarioDto) request.readEntity(CuUsuarioDto.class);
            return new Respuesta(true,"","","Usuario",usuarioDto);
        }catch(Exception ex){
            return new Respuesta(false,"error interno","error exception Cliente Service");
        }
    }
    
    public Respuesta guardarUsuario(CuUsuarioDto usu){
        try{
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("user", usu);
            Request request = new Request("UsuariosController/saveUser","/{user}", parametros);
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "");
            }
            CuUsuarioDto usuarioDto = (CuUsuarioDto) request.readEntity(CuUsuarioDto.class);
            return new Respuesta(true,"","","Usuario",usuarioDto);
        }catch(Exception ex){
            return new Respuesta(false,"error interno","error exception Cliente Service");
        }
    }
    
}


