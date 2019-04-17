package IDB.view;

import IDB.facade.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
     */
    public static void main(String[] args) {
        facade = new FacadeBackEnd();
        launch(args);
    }
}
