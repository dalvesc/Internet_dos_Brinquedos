package IDB.controller;

import IDB.exception.*;
import IDB.facade.*;
import IDB.view.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Cadastro_ControllerFX implements Initializable {

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
    @FXML
    private Label jaCadastrado;

    FacadeBackEnd facade = Internet_dos_Brinquedos.getFacade();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PassarTela tela = new PassarTela();

        cadastrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean cadastrou = true;
                if (adm_option.isSelected()) {
                    try {
                        facade.cadastrarADM(nome_piloto.getText(),
                                usuario_piloto.getText(), senha_piloto.getText());
                    } catch (CadastroInvalido ex) {
                        jaCadastrado.setText("User já cadastrado!");
                        cadastrou = false;
                        Logger.getLogger(Cadastro_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    facade.cadastrarPiloto(nome_piloto.getText(),
                            usuario_piloto.getText(), senha_piloto.getText(),
                            foto_piloto.getText());
                } catch (CadastroInvalido ex) {
                    jaCadastrado.setText("User já cadastrado!");
                    cadastrou = false;
                    Logger.getLogger(Cadastro_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (cadastrou) {
                    tela.telaInicial();
                    cadastrar.getScene().getWindow().hide();
                }
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.telaInicial();
                voltar.getScene().getWindow().hide();
            }
        });
    }
}
