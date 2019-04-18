package IDB.controller;

import IDB.exception.*;
import IDB.facade.*;
import IDB.view.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
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

    FacadeBackEnd facade = Internet_dos_Brinquedos.getFacade();
    @FXML
    private CheckBox adm_check;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PassarTela tela = new PassarTela();

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.telaInicial();
                voltar.getScene().getWindow().hide();
            }
        });

        entrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    if (adm_check.isSelected()) {
                        facade.login(usuario.getText(), senha.getText(), "adm");
                        tela.confPartida();
                        entrar.getScene().getWindow().hide();
                    } else {
                        facade.login(usuario.getText(), senha.getText(), "Piloto");
                        tela.selCarro();
                        entrar.getScene().getWindow().hide();
                    }
                } catch (LoginInvalido ex) {
                    loginInvalido.setText("Login Invalido!");
                    Logger.getLogger(Login_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );
    }

}
