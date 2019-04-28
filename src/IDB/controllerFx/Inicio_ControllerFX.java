package IDB.controllerFx;

import IDB.controller.*;
import IDB.exception.*;
import IDB.facade.*;
import IDB.model.*;
import IDB.view.*;
import java.net.URL;
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

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Inicio_ControllerFX implements Initializable {

    @FXML
    private ListView<String> classificacao;
    @FXML
    private Button cadastro;
    @FXML
    private Label tempo_de_qualidicacao;
    @FXML
    private Label recorde_circuito; //tempo
    @FXML
    private Label recorde_circuito_corredor; //nome(equipe)
    @FXML
    private Button login;
    @FXML
    private Label label_tipo_corrida;
    @FXML
    private Button testar;

    FacadeBackEnd facade = Internet_dos_Brinquedos.getFacade();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PassarTela tela = new PassarTela();

        ObservableList<String> data = FXCollections.observableArrayList();

        testar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Piloto rapido = null;
                try {
                    data.clear();
                    facade.atzPosicao();
                    label_tipo_corrida.setText("Corrida");
                    for (Piloto piloto : facade.getPilotosPartida()) {
                        String pil = piloto.getNome() + "|" + piloto.getEquipe() + "|"
                                + piloto.getTempoVolta() + "|" + piloto.getNumVoltas();
                        data.add(pil);
                    }
                    classificacao.setItems(data);
                } catch (SemPilotos | SemCorrida ex) {
                    Logger.getLogger(Inicio_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    rapido = facade.posicaoSessaoRecorde(facade.getPilotos());
                } catch (SemPilotos | SemCorrida ex) {
                    Logger.getLogger(Inicio_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    recorde_circuito.setText(Double.toString(facade.retornarVoltaMaisRapida(rapido)));
                } catch (SemCorrida ex) {
                    Logger.getLogger(Inicio_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
                }
                recorde_circuito_corredor.setText(rapido.getNome() + " | " + rapido.getEquipe());
            }
        });

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

        try {
            for (Piloto piloto : facade.getPilotosPartida()) {
                String pil = piloto.getNome() + "|" + piloto.getEquipe() + "|"
                        + piloto.getTempoVolta() + "|" + piloto.getNumVoltas();
                data.add(pil);
            }
            classificacao.setItems(data);
        } catch (SemPilotos | SemCorrida ex) {
            Logger.getLogger(Inicio_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
