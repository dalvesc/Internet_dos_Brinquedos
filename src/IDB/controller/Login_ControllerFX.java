package IDB.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Login_ControllerFX implements Initializable {

    @FXML
    private Button voltar;
    @FXML
    private Button entrar;
    @FXML
    private TextField usuario;
    @FXML
    private TextField senha;
    @FXML
    private Label loginInvalido;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}