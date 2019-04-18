package IDB.controller;

import IDB.exception.*;
import IDB.facade.*;
import IDB.model.*;
import IDB.view.*;
import java.util.Iterator;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ConfPartida_ControllerFX implements Initializable {

    @FXML
    private ListView<String> pilotos;
    @FXML
    private Button iniciar;
    @FXML
    private TextField tempo_qualificacao;
    @FXML
    private TextField voltas_qualificacao;
    @FXML
    private TextField voltas_corrida;
    @FXML
    private Button selecionar;

    FacadeBackEnd facade = Internet_dos_Brinquedos.getFacade();
    @FXML
    private Label corrida_cheia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PassarTela tela = new PassarTela();

        ObservableList<String> data = FXCollections.observableArrayList();

        try {
            Iterator itr = facade.getPilotos().iterator();
            while (itr.hasNext()) {
                Piloto piloto = (Piloto) itr.next();
                String pil = piloto.getNome();
                data.add(pil);
            }
            pilotos.setItems(data);
        } catch (SemPilotos ex) {
            Logger.getLogger(Inicio_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
        }

        selecionar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MultipleSelectionModel<String> selecionandos = pilotos.selectionModelProperty().get();

                ObservableList<String> sel = selecionandos.getSelectedItems();
                if (facade.verificaUsuarioCadastrado(sel.get(0))) {
                    try {
                        facade.pilotoEscolhido(facade.getPil());
                    } catch (CorridaCheia ex) {
                        corrida_cheia.setText("Corrida cheia!");
                        Logger.getLogger(ConfPartida_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        facade.escolherConfClassif(Float.parseFloat(tempo_qualificacao.getText()),
                Integer.parseInt(voltas_qualificacao.getText()));

        facade.escolherConfCorrida(Integer.parseInt(voltas_corrida.getText()));
        if (!facade.pilotoCheio() && tempo_qualificacao.getText() != null
                && voltas_qualificacao.getText() != null && voltas_corrida.getText() != null) {

            iniciar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //métodos de começar corrida
                    tela.telaInicial();
                    iniciar.getScene().getWindow().hide();
                }
            });
        }
    }

}
