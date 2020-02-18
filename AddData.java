package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddData {
    private Object Node;

    public void addNewObsData(ActionEvent event) throws IOException {
        Parent addNewObsParent = FXMLLoader.load(AddData.class.getResource("addObsData.fxml"));
        Scene addNewObsScene = new Scene(addNewObsParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(addNewObsScene);
        window.show();
    }

    public void addNewGalamData(ActionEvent event) throws IOException {
        Parent addNewGalamParent = FXMLLoader.load(AddData.class.getResource("addGalamData.fxml"));
        Scene addNewGalamScene = new Scene(addNewGalamParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(addNewGalamScene);
        window.show();
    }

}
