package project;

/**
 * @author Anthony Basingnaa
 * @version 1.0
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGui extends Application{

    @Override
    //main class for running the gui of the code
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AddData.fxml"));
        primaryStage.setTitle("Earthquake Monitoring");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args){launch(args);}
}
