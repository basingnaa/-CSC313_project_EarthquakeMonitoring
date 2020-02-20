package project;
/**
 * @author Anthony Basingnaa
 * @version 1.0
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class AddGalamPopUp{
    public Stage window;

    public Parent popUp;

    //method to load pop up window
    public void load(Stage window) throws IOException {
        window = new Stage();
        popUp = FXMLLoader.load(getClass().getResource("addGalamPopUp.fxml"));
        window.setScene(new Scene(popUp));
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
    }
}
