package IDB.controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Cadastro_ControllerFX implements Initializable {

    @FXML
    private Label titulo;
    @FXML
    private Button voltar;
    @FXML
    private Button cadastrar;
    @FXML
    private TextField nome_piloto;
    @FXML
    private TextField usuario_piloto;
    @FXML
    private TextField senha_piloto;
    @FXML
    private TextField foto_piloto;
    @FXML
    private CheckBox adm_option;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
