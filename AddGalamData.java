package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;



public class AddGalamData{
    @FXML
    public TextField vegTextField;

    @FXML
    public TextField yearTextField;

    @FXML
    public TextField longTextField;

    @FXML
    public TextField latTextField;

    @FXML
    public Button saveData;

    @FXML
    private Button CloseBtn;




    private Galamsey.VC veg;
    private int year;
    private int lngt;
    private int latt;
    private Object Node;

    public UtilityClass collect;


    public void exit(ActionEvent event) throws IOException {
        Parent exitScreen = FXMLLoader.load(AddGalamData.class.getResource("addData.fxml"));
        Scene addData = new Scene(exitScreen);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(addData);
        window.show();
    }


    public void saveData(ActionEvent event) throws Exception {
        Stage window;
        Parent popUp;

        veg = Galamsey.VC.valueOf(vegTextField.getText());
        year = Integer.parseInt(yearTextField.getText());
        lngt = Integer.parseInt(longTextField.getText());
        latt = Integer.parseInt(latTextField.getText());

        Galamsey newData = new Galamsey(veg,year,latt,lngt);
        newData.writeDb();
        collect = new UtilityClass(50);
        collect.addEntry(newData);
        window = new Stage();
        popUp = FXMLLoader.load(getClass().getResource("addGalamPopUp.fxml"));
        window.setScene(new Scene(popUp));
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
        longTextField.clear();
        yearTextField.clear();
        vegTextField.clear();
        latTextField.clear();
    }

    public void close(ActionEvent event) throws IOException {
        Stage window;
        window = (Stage) CloseBtn.getScene().getWindow();
        window.close();
    }


}
