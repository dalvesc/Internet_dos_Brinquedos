package IDB.controllerFx;

import IDB.controller.PassarTela;
import IDB.exception.*;
import IDB.facade.*;
import IDB.model.*;
import IDB.view.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class SelCarro_ControllerFX implements Initializable {

    @FXML
    private Button voltar;
    @FXML
    private Button selecionar;
    @FXML
    private Label jaEscolhido;
    @FXML
    private CheckBox carro1;
    @FXML
    private CheckBox carro2;
    @FXML
    private CheckBox carro3;
    @FXML
    private CheckBox carro4;

    FacadeBackEnd facade = Internet_dos_Brinquedos.getFacade();

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

        ArrayList<Carro> carro = new ArrayList(4);
        Iterator itr = facade.listarEquipes();
        while (itr.hasNext()) {
            carro.add((Carro) itr.next());
        }

        carro1.setText(carro.get(0).getEquipe());
        carro2.setText(carro.get(1).getEquipe());
        carro3.setText(carro.get(2).getEquipe());
        carro4.setText(carro.get(3).getEquipe());

        selecionar.setOnAction(new EventHandler<ActionEvent>() {
            private boolean selecionou = true;

            @Override
            public void handle(ActionEvent event) {
                try {
                    if (carro1.isSelected()) {
                        facade.escolherEquipe(facade.getPilotoLogado(), carro.get(0));
                    }
                    if (carro2.isSelected()) {
                        facade.escolherEquipe(facade.getPilotoLogado(), carro.get(1));
                    }
                    if (carro3.isSelected()) {
                        facade.escolherEquipe(facade.getPilotoLogado(), carro.get(2));
                    }
                    if (carro4.isSelected()) {
                        facade.escolherEquipe(facade.getPilotoLogado(), carro.get(3));
                    }
                } catch (CarroSelecionado ex) {
                    jaEscolhido.setText("Já selecionado!");
                    selecionou = false;
                    Logger.getLogger(SelCarro_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (selecionou) {
                    tela.telaInicial();
                    selecionar.getScene().getWindow().hide();
                }
            }
        });
    }
}
