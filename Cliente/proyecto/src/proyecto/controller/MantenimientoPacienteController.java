/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Bran
 */
public class MantenimientoPacienteController implements Initializable {

    @FXML
    private Label lbl_main;
    @FXML
    private TableView<?> tv_pacientes001;
    @FXML
    private TableColumn<?, ?> clm_nombre001;
    @FXML
    private TableColumn<?, ?> clm_apellido001;
    @FXML
    private TableColumn<?, ?> clm_cedula001;
    @FXML
    private TableColumn<?, ?> clm_correo001;
    @FXML
    private TableColumn<?, ?> clm_genero001;
    @FXML
    private TableColumn<?, ?> clm_nacimiento001;
    @FXML
    private JFXTextField tf_nombre001;
    @FXML
    private JFXTextField tf_apellido001;
    @FXML
    private JFXTextField tf_cedula001;
    @FXML
    private JFXTextField tf_correo001;
    @FXML
    private JFXComboBox<?> cb_genero001;
    @FXML
    private JFXDatePicker dp_fechaNacimiento001;
    @FXML
    private JFXButton btn_guardar001;
    @FXML
    private JFXButton btn_eliminar001;
    @FXML
    private JFXButton btn_buscar001;
    @FXML
    private JFXButton btn_limpiar001;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cargar_paciente(MouseEvent event) {
    }

    @FXML
    private void guardar_paciente(ActionEvent event) {
    }

    @FXML
    private void eliminar_paciente(ActionEvent event) {
    }

    @FXML
    private void buscar_paciente(ActionEvent event) {
    }

    @FXML
    private void limpiar_paciente001(ActionEvent event) {
    }
    
}
