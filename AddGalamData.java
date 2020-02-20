package project;

/**
 * @author Anthony Basingnaa
 * @version 1.0
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    @FXML
    private TextField obsTextField;




    private Galamsey.VC veg;
    private int year;
    private int lngt;
    private int latt;
    private String obsName;
    private Object Node;
    public UtilityClass collect;

    //method that take you back to the main menu
    public void exit(ActionEvent event) throws IOException {
        Parent exitScreen = FXMLLoader.load(AddGalamData.class.getResource("addData.fxml"));
        Scene addData = new Scene(exitScreen);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(addData);
        window.show();
    }

    //method that saves input data to the database
    public void saveData(ActionEvent event) throws Exception {
        Stage window;
        Parent popUp;

        String upp = vegTextField.getText().toUpperCase();
        veg = Galamsey.VC.valueOf(upp);
        year = Integer.parseInt(yearTextField.getText());
        lngt = Integer.parseInt(longTextField.getText());
        latt = Integer.parseInt(latTextField.getText());
        obsName = obsTextField.getText();

        Galamsey newData = new Galamsey(obsName,veg,year,latt,lngt);
        newData.writeDb();
        window = new Stage();
        popUp = FXMLLoader.load(getClass().getResource("addGalamPopUp.fxml"));
        window.setScene(new Scene(popUp));
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
        longTextField.clear();
        yearTextField.clear();
        vegTextField.clear();
        latTextField.clear();
        obsTextField.clear();
    }

    //method that closes the pop up window
    public void close(ActionEvent event) throws IOException {
        Stage window;
        window = (Stage) CloseBtn.getScene().getWindow();
        window.close();
    }


}
