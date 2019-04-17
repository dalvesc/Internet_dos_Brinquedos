package IDB.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ConfPartida_ControllerFX implements Initializable {

    @FXML
    private Button cadastro;
    @FXML
    private Label titulo;
    @FXML
    private ListView<?> pilotos;
    @FXML
    private Label recorde_circuito_corredor;
    @FXML
    private Button corrida;
    @FXML
    private Button iniciar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}