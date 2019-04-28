package IDB.controller;

import IDB.controllerFx.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Metódos que irão servir para passar de uma tela para outra da interface
 * *Precisa de revisão para saber se será assim mesmo
 *
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class PassarTela {

    /**
     * Passa para a tela de login
     */
    public void login() {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/IDB/view/Login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Login_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Login");
    }

    /**
     * Passa para a tela de cadastro
     */
    public void cadastro() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/IDB/view/Cadastro.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Cadastro_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Cadastro");
    }

    /**
     * Passa para a tela inicial
     */
    public void telaInicial() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/IDB/view/Inicio.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Inicio_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Tela Inicial");
    }

    /**
     * Passa para a tela de configuração da partida
     */
    public void confPartida() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/IDB/view/ConfPartida.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConfPartida_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Configuração da Partida");
    }

    /**
     * Passa para a tela de seleção de carro
     */
    public void selCarro() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/IDB/view/SelCarro.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(SelCarro_ControllerFX.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Selecionar Carro");
    }
}
