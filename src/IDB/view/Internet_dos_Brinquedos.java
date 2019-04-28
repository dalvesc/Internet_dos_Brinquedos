package IDB.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import IDB.exception.*;
import IDB.facade.*;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Internet_dos_Brinquedos extends Application {

    static FacadeBackEnd facade;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Início");
        stage.setScene(scene);
        stage.show();
    }

    static public FacadeBackEnd getFacade() {
        return facade;
    }

    /**
     * @param args the command line arguments
     * @throws IDB.exception.CarroSelecionado
     */
    public static void main(String[] args) throws CarroSelecionado {
        try {
            facade = new FacadeBackEnd();
        } catch (IOException ex) {
            Logger.getLogger(Internet_dos_Brinquedos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CadastroInvalido ex) {
            Logger.getLogger(Internet_dos_Brinquedos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LoginInvalido ex) {
            Logger.getLogger(Internet_dos_Brinquedos.class.getName()).log(Level.SEVERE, null, ex);
        }
        launch(args);
    }
}
