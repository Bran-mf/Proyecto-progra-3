/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import proyecto.Dto.CuUsuarioDto;
import proyecto.Service.UsuarioService;
import proyecto.util.Formato;
import proyecto.util.Mensaje;
import proyecto.util.Respuesta;

/**
 * FXML Controller class
 *
 * @author IVAN
 */
public class RegistroController extends Controller implements Initializable {

    @FXML private Label lbl_Titulo;
    @FXML private JFXTextField tf_Nombre;
    @FXML private JFXTextField tf_Apellido;
    @FXML private JFXTextField tf_Cedula;
    @FXML private JFXTextField tf_Correo;
    @FXML private JFXButton btn_aceptar;
    @FXML private JFXButton btn_Cancelar;
    @FXML private JFXRadioButton rb_Administrador;
    @FXML private ToggleGroup tg_tipUsuario;
    @FXML private JFXRadioButton rb_Recepcionista;
    @FXML private JFXTextField tf_UserName;
    @FXML private JFXTextField tf_Contrasenha;
    @FXML private ImageView imv_fondo;
    @FXML private VBox vb_der;
    CuUsuarioDto usu;
    UsuarioService ser;
    Mensaje men;
    String t1, t2, t3, t4;
    @FXML
    private Label LBL_TB;
    @FXML
    private JFXToggleButton tg_idioma;
    @FXML
    private Label lbl_tu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initVariablesAndNodes();
        Formato();
    }    

    public void initVariablesAndNodes(){
        usu = new CuUsuarioDto();
        ser = new UsuarioService();
        rb_Administrador.setUserData("A");
        rb_Recepcionista.setUserData("R");
        men = new Mensaje();
        t1 = "Zona de Registro".toUpperCase();
        t2 = "Faltan datos".toUpperCase();
        t3 = "Usuario registrado con exito".toUpperCase();
    }
    
    /**
     * Verifica que los espacios necesarios no esten nulos
     * @return 
     */
    public boolean validarRequeridos(){
        usu = new CuUsuarioDto();
        usu.setUsuIdioma(tg_idioma.isSelected() ? "0" : "1");
        if(!tf_Contrasenha.getText().isEmpty()){
            usu.setUsuContrasena(tf_Contrasenha.getText());
            if(!tf_Cedula.getText().isEmpty()){
                usu.setUsuCedula(tf_Cedula.getText());
                if(!tf_Nombre.getText().isEmpty()){
                    usu.setUsuNombre(tf_Nombre.getText());
                    if(!tf_Apellido.getText().isEmpty()){
                        usu.setUsuApellido(tf_Apellido.getText());
                        if(!tf_Correo.getText().isEmpty()){
                            usu.setUsuCorreo(tf_Correo.getText());
                            if(!tf_UserName.getText().isEmpty()){
                                usu.setUsuUsuario(tf_UserName.getText());
                                if(tg_tipUsuario.getSelectedToggle() != null){
                                    usu.setUsuTipo((String)tg_tipUsuario.getSelectedToggle().getUserData());
                                    usu.setUsuTemp("N");
                                    usu.setUsuCodact(CodigoActivacion());
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    
    public void Formato(){
        tf_Nombre.setTextFormatter(Formato.getInstance().maxLengthFormat(30));
        tf_Apellido.setTextFormatter(Formato.getInstance().maxLengthFormat(30));
        tf_Cedula.setTextFormatter(Formato.getInstance().maxLengthFormat(15));
        tf_Correo.setTextFormatter(Formato.getInstance().maxLengthFormat(50));
        tf_UserName.setTextFormatter(Formato.getInstance().maxLengthFormat(30));
        tf_Contrasenha.setTextFormatter(Formato.getInstance().maxLengthFormat(30));
    }
    
    public String CodigoActivacion(){
        String codigo = "";
        int numero, num2, li, ls, counter = 0;
        while(counter < 30){
            num2 = (int) (Math.random() * 3) + 1; 
            switch (num2) {
                case 1:
                case 0:
                    li = 47;
                    ls = 57;
                    break;
                case 2:
                    li = 64;
                    ls = 91;
                    break;
                default:
                    li = 96;
                    ls = 123;
                    break;
            }
            do{
                numero = (int) (Math.random() * 123) + 1;
            }while(!(numero > li && numero < ls));
            codigo += (char)numero;
            counter++;
        }
        return codigo;
    } 
    
    
    @FXML
    private void accionAceptar(ActionEvent event) {
        if(validarRequeridos()){
            String tit = usu.getUsuIdioma().equals("1") ? "Su informacion" : "Your Information";
            men.show(Alert.AlertType.CONFIRMATION, tit, usu.data(usu.getUsuIdioma()));
            Respuesta res = ser.guardarUsuario(usu);
            usu = (CuUsuarioDto) res.getResultado("Usuario");
            if(usu == null){
                men.show(Alert.AlertType.ERROR, t1, res.getMensaje());
            }else{
                men.show(Alert.AlertType.INFORMATION, t1, t3);
            }
        }else{
            men.show(Alert.AlertType.WARNING, t1, t2);
        }
    }

    @FXML
    private void accionCancelar(ActionEvent event) {
        this.getStage().close();
    }

    @Override
    public void initialize() {
         usu = new CuUsuarioDto();
    }

    @FXML
    private void accionIdioma(ActionEvent event) {
        if(tg_idioma.isSelected()){            
            EstablecerIdioma(false);
        }else{
            EstablecerIdioma(true);
        }
    }
    
    public void EstablecerIdioma(boolean i){
        if(i){
            rb_Administrador.setText("Administrador");
            rb_Recepcionista.setText("Recepcionista");
            t1 = "ZONA DE REGISTRO";
            lbl_Titulo.setText(t1);
            t2 = "FALTAN DATOS";
            lbl_tu.setText("TIPO DE USUARIO");
            t3 = "USUARIO REGISTRADO EXITOSAMENTE";
            tf_Apellido.setPromptText("APELLIDOS");
            tf_Cedula.setPromptText("IDENTIFICACION");
            tf_Contrasenha.setPromptText("CONTRASEÑA");
            tf_Correo.setPromptText("CORREO ELECTRONICO");
            tf_Nombre.setPromptText("NOMBRE");
            tf_UserName.setPromptText("NOMBRE DE USUARIO");
            btn_aceptar.setText("ACEPTAR");
            btn_Cancelar.setText("CANCELAR");
        }else{
            rb_Administrador.setText("Administrator");
            rb_Recepcionista.setText("Recepcionist");
            t1 = "REGISTRATION AREA";
            lbl_Titulo.setText(t1);
            t2 = "MISSING DATA";
            lbl_tu.setText("USER ROLE");
            t3 = "REGISTRATED USER SUCESSFULLY";
            tf_Apellido.setPromptText("SURMANES");
            tf_Cedula.setPromptText("ID");
            tf_Contrasenha.setPromptText("PASSWORD");
            tf_Correo.setPromptText("EMAIL");
            tf_Nombre.setPromptText("NAME");
            tf_UserName.setPromptText("USER NAME");
            btn_aceptar.setText("OK");
            btn_Cancelar.setText("CANCEL");
        }
    }
}


