/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import proyecto.util.FlowController;

/**
 *
 * @author Bran
 */
public class Proyecto extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FlowController.getInstance().InitializeFlow(stage);
        FlowController.getInstance().goViewInWindowModal("Login", Boolean.TRUE, StageStyle.DECORATED);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
