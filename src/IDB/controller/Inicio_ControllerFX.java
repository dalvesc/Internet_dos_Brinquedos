package IDB.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Inicio_ControllerFX implements Initializable {
    
    @FXML
    private Label titulo;
    @FXML
    private ListView<?> classificacao;
    @FXML
    private Button cadastro;
    @FXML
    private Label label_qualificacao;
    @FXML
    private Label tempo_de_qualidicacao;
    @FXML
    private Label label_recorde;
    @FXML
    private Label recorde_circuito;
    @FXML
    private Label recorde_circuito_corredor;
    @FXML
    private Button login;
    @FXML
    private Label label_qualificacao1;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
