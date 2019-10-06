/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import proyecto.Dto.CuUsuarioDto;
import proyecto.Service.UsuarioService;
import proyecto.util.AppContext;
import proyecto.util.FlowController;
import proyecto.util.Mensaje;
import proyecto.util.Respuesta;

/**
 *
 * @author Bran
 */
public class LoginController extends Controller implements Initializable {

    @FXML private JFXButton btn_Registrarse;
    @FXML private JFXButton btn_Acceder;
    @FXML private JFXTextField tF_usuario001;
    @FXML private ImageView iv_con;
    @FXML private ImageView iv_usu;
    @FXML private JFXButton btn_Ayuda;
    @FXML private JFXTextField tF_password001;
    UsuarioService usuarioService;
    CuUsuarioDto usu;
    Mensaje men;
    @FXML
    private Label LBL_TB;
    @FXML
    private JFXToggleButton tg_idioma;
    @FXML
    private Label LBL_TITULO;
    String tit1, tit2, tit3, tit4;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarobjetos();
        men = new Mensaje();
        usu = new CuUsuarioDto();
        tit1 = "INICIAR SESION";
        tit2 = "Sesion iniciada".toUpperCase();
        tit3 = "Usted esta registrado, pero no activo".toUpperCase();
        tit4 = "Por favor llene ambos campos".toUpperCase();
        
        
    }

    @Override
    public void initialize() {
    }
    @FXML
    private void accionRegistrarse(ActionEvent event) {
        FlowController.getInstance().goViewInWindowModal("Registro", Boolean.FALSE, StageStyle.DECORATED);
    }

    @FXML
    private void accion_Acceder(ActionEvent event) {
        if (tF_usuario001.getText().isEmpty()
                && tF_password001.getText().isEmpty()) {
            Alert alert  = new Alert(Alert.AlertType.ERROR);
            men.showModal(Alert.AlertType.WARNING, tit1, this.getStage(), tit4);
        }else{
            Respuesta res = usuarioService.getUsuario(tF_usuario001.getText(), tF_password001.getText());
            if(res.getEstado()){
                AppContext.getInstance().set("UsuarioActivo", res.getResultado("Usuario"));
                usu = (CuUsuarioDto) res.getResultado("Usuario");
                if(usu.getUsuEstado().equals("A")){
                    men.showModal(Alert.AlertType.INFORMATION, tit1, this.getStage(), tit2);
                }else{
                    men.showModal(Alert.AlertType.INFORMATION, tit1, this.getStage(), tit3);
                }
                //abrir a la vista principal
            }else{
                men.showModal(Alert.AlertType.INFORMATION, tit1, this.getStage(), res.getMensaje());
            }
        }
    }

    public void iniciarobjetos() { //escribir en este metodo todo lo que sea inicializar
        //inicializa todos los elementos
        usuarioService = new UsuarioService();
    }

    @FXML
    private void accionHelp(ActionEvent event) {
        int i = men.showOptionBotton("CONFIRMACION", this.getStage(), "Elija una opcion");
    }

    @FXML
    private void accionIdioma(ActionEvent event) {
        if(tg_idioma.isSelected()){
            Estableceridioma(true);
        }else{
            Estableceridioma(false);
        }
    }

    void Estableceridioma(boolean i){
        if(i){
            tit1 = "LOG IN";
            tit2 = "Session started".toUpperCase();
            tit3 = "You are registered, but not active".toUpperCase();
            tit4 = "Please fill both fields".toUpperCase();
            LBL_TITULO.setText("LOG IN");
            tF_usuario001.setPromptText("USER NAME");
            tF_password001.setPromptText("PASSWORD");
            btn_Acceder.setText("TO ACCESS");
            btn_Ayuda.setText("HELP");
            btn_Registrarse.setText("CHECK IN");
        }else{
            tit1 = "INICIAR SESION";
            tit2 = "Sesion iniciada".toUpperCase();
            tit3 = "Usted esta registrado, pero no activo".toUpperCase();
            tit4 = "Por favor llene ambos campos".toUpperCase();
            LBL_TITULO.setText("INICIAR SESION");
            tF_usuario001.setPromptText("NOMBRE DE USUARIO");
            tF_password001.setPromptText("CONTRASEÑA");
            btn_Acceder.setText("ACCEDER");
            btn_Ayuda.setText("AYUDA");
            btn_Registrarse.setText("REGISTRARSE");
        }
    }

}
