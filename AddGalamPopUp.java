package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class AddGalamPopUp{
    //AddData insert = new AddData();
    //private static boolean answer;

    @FXML
    public Button YesBtn;

    @FXML
    public Button NoBtn;

    public Stage window;

    public Parent popUp;

    public void load(Stage window) throws IOException {
//        Stage window;
//        Parent popUp;
        window = new Stage();
        popUp = FXMLLoader.load(getClass().getResource("addGalamPopUp.fxml"));
        window.setScene(new Scene(popUp));
        window.initModality(Modality.APPLICATION_MODAL);
        //window.initOwner(saveData.getScene().getWindow());
        window.show();
    }

//    public void yesOrNo(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
////        if(event.getSource()==YesBtn){
////            stage = (Stage) YesBtn.getScene().getWindow();
////            longTextField.clear();
////            yearTextField.clear();
////            vegTextField.clear();
////            latTextField.clear();
////            stage.close();
////        }
////        else if(event.getSource()==NoBtn){
////            stage = (Stage) NoBtn.getScene().getWindow();
////
////            collect.writeToFile();
////            stage.close();
//        }
//    }
}
