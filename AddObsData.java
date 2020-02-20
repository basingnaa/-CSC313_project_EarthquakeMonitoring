package project;

/**
 * @author Anthony Basingnaa
 * @version 1.0
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddObsData extends AddGalamData{
    private Object Node;
    public String obsName;
    private String country;
    private int year;
    private int area;

    @FXML
    private TextField obsNameTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField yearTextField;

    @FXML
    private TextField areaTextField;

    @FXML
    private TextField eventTextField;

    @FXML
    private Button CloseBtn;

    //method that take you back to the main menu
    public void exit(ActionEvent event) throws IOException {
        Parent exitScreen = FXMLLoader.load(getClass().getResource("addData.fxml"));
        Scene addData = new Scene(exitScreen);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(addData);
        window.show();
    }

    //method that saves input data to the database
    public void saveData(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        obsName = obsNameTextField.getText();
        country = countryTextField.getText();
        year = Integer.parseInt(yearTextField.getText());
        area = Integer.parseInt(areaTextField.getText());

        Observatory newData = new Observatory(obsName,country,year,area,collect);
        newData.writeToDb();

        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("addObsPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        obsNameTextField.clear();
        countryTextField.clear();
        yearTextField.clear();
        areaTextField.clear();
    }

    //method that closes the pop up window
    public void close(ActionEvent event) throws IOException {
        Stage window;
        window = (Stage) CloseBtn.getScene().getWindow();
        window.close();
    }
}
