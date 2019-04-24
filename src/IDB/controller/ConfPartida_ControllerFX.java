package IDB.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ConfPartida_ControllerFX implements Initializable {

    @FXML
    private ListView<?> pilotos;
    @FXML
    private Button iniciar;
    @FXML
    private Button iniciar1;
    @FXML
    private TextField tempo_qualificacao;
    @FXML
    private TextField voltas_qualificacao;
    @FXML
    private TextField voltas_corrida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
