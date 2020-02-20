package project;

import com.mysql.cj.jdbc.JdbcConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.sql.*;

public class AddData {
    private Object Node;
    private ObservableList<Galamsey> data;
    private ObservableList<Observatory> data2;
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/galam";

    static final String USER="root";
    static final String PASS="admin";

    @FXML
    private TableView<Galamsey> tableGalam;

    @FXML
    private TableColumn<Galamsey, Enum> columnVegColor;

    @FXML
    private TableColumn<Galamsey, Integer> columnYear;

    @FXML
    private TableColumn<Galamsey, Double> columnLong;

    @FXML
    private TableColumn<Galamsey, Double> columnLatt;

    @FXML
    private TableView<Observatory> tableObs;

    @FXML
    private TableColumn<Observatory, String> columnObsName;

    @FXML
    private TableColumn<Observatory, String> columnCountry;

    @FXML
    private TableColumn<Observatory, Integer> columnStartingYear;

    @FXML
    private TableColumn<Observatory, Integer> columnArea;

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

    public void viewGalam(ActionEvent event) throws IOException{
        Parent galam = FXMLLoader.load(AddGalamData.class.getResource("viewGalam.fxml"));
        Scene viewgalam = new Scene(galam);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(viewgalam);
        window.show();
    }



    public void viewObs(ActionEvent event) throws IOException{
        Parent obs = FXMLLoader.load(AddGalamData.class.getResource("viewObs.fxml"));
        Scene viewobs = new Scene(obs);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(viewobs);
        window.show();
    }

    public void loadGalam(ActionEvent event) {
        try {
            data = FXCollections.observableArrayList();
            Connection con;

            con = DriverManager.getConnection(DB_URL, USER, PASS);
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM galamseydata");
            while (rs.next()) {
                String col = rs.getString(1);
                data.add(new Galamsey(Galamsey.VC.valueOf(col), rs.getInt(2), rs.getDouble(3), rs.getDouble(4)));
            }

        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }

        columnVegColor.setCellValueFactory(new PropertyValueFactory<>("veg_colour"));
        columnYear.setCellValueFactory(new PropertyValueFactory<>("year_of_event"));
        columnLatt.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        columnLong.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        tableGalam.setItems(null);
        tableGalam.setItems(data);

    }

    public void loadObs(ActionEvent event) {
        try {
            data2 = FXCollections.observableArrayList();
            Connection con;

            con = DriverManager.getConnection(DB_URL, USER, PASS);
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM observatorydata");
            while (rs.next()) {
                data2.add(new Observatory(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),MonitoringIO.collect));
            }

        }catch (SQLException | IOException ex){
            System.err.println("Error"+ex);
        }

        columnCountry.setCellValueFactory(new PropertyValueFactory<>("countryName"));
        columnObsName.setCellValueFactory(new PropertyValueFactory<>("observatoryName"));
        columnStartingYear.setCellValueFactory(new PropertyValueFactory<>("galamseyStartingYear"));
        columnArea.setCellValueFactory(new PropertyValueFactory<>("areaCovered"));
        tableObs.setItems(null);
        tableObs.setItems(data2);

    }

    public void exit(ActionEvent event) throws IOException {
        Parent exitScreen = FXMLLoader.load(AddGalamData.class.getResource("addData.fxml"));
        Scene addData = new Scene(exitScreen);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(addData);
        window.show();
    }

}
