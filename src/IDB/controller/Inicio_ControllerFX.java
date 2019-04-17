package IDB.controller;

import IDB.exception.*;
import IDB.facade.*;
import IDB.model.*;
import IDB.view.*;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Inicio_ControllerFX implements Initializable {

    @FXML
    private ListView<Piloto> classificacao;
    @FXML
    private Button cadastro;
    @FXML
    private Label tempo_de_qualidicacao;
    @FXML
    private Label recorde_circuito;
    @FXML
    private Label recorde_circuito_corredor;
    @FXML
    private Button login;
    @FXML
    private Label label_tipo_corrida;

    FacadeBackEnd facade = Internet_dos_Brinquedos.getFacade();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PassarTela tela = new PassarTela();

        cadastro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.cadastro();
                cadastro.getScene().getWindow().hide();
            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.login();
                login.getScene().getWindow().hide();
            }
        });

        ObservableList<Piloto> data = FXCollections.observableArrayList();

        try {
            Iterator itr = facade.getPilotos().iterator();
            while (itr.hasNext()) {
                Piloto pil = (Piloto) itr.next();
                data.add(pil);
            }
            classificacao.setItems(data);
        } catch (SemPilotos ex) {
            Logger.getLogger(Inicio_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
