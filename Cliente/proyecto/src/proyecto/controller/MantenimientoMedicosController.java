/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import proyecto.Dto.cuMedicoDto;

/**
 * FXML Controller class
 *
 * @author Bran
 */
public class MantenimientoMedicosController implements Initializable {

    @FXML
    private TableView<cuMedicoDto> tv_medicos;
    @FXML
    private TableColumn<cuMedicoDto, String> clm_Codigo;
    @FXML
    private TableColumn<cuMedicoDto, String> clm_folio;
    @FXML
    private TableColumn<cuMedicoDto, String> clm_carnet;
    @FXML
    private TableColumn<cuMedicoDto, String> clm_estado;
    @FXML
    private TableColumn<cuMedicoDto, String> clm_espacios;
    @FXML
    private Label lbl_folio001;
    @FXML
    private Label lbl_carnet001;
    @FXML
    private Label lbl_codigo001;
    @FXML
    private JFXTextField tf_folio001;
    @FXML
    private JFXTextField tf_carnet001;
    @FXML
    private JFXTextField tf_codigo001;
    @FXML
    private JFXTimePicker tf_inicioJornada001;
    @FXML
    private JFXTimePicker tf_finalJornada;
    @FXML
    private JFXComboBox<cuMedicoDto> tf_espaciosHora;
    @FXML
    private JFXButton btn_guardar;
    @FXML
    private JFXButton btn_editar;
    @FXML
    private JFXButton btn_limpiar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cargarMedico(MouseEvent event) {
    }

    @FXML
    private void guardarEditar_medico(ActionEvent event) {
    }

    @FXML
    private void eliminar_medico(ActionEvent event) {
    }

    @FXML
    private void buscar_medico(ActionEvent event) {
    }

    @FXML
    private void limpiar_campos(ActionEvent event) {
    }
    
}
