package project;
/**
 * @author Anthony Basingnaa
 * @version 1.0
 */

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MonitorStats {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/galam";

    static final String USER="root";
    static final String PASS="admin";
    Connection myCon;
    ArrayList<Galamsey> galamList = new ArrayList<>();

    //gets the average colour value from the database of a particular observatory
    public String obv_avgColourValue(String observatoryName) throws SQLException, ClassNotFoundException {
        String str="'"+observatoryName+"'";
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement insertObservatory = myCon.createStatement();
        ResultSet rs = insertObservatory.executeQuery("SELECT AVG(colour_value)'Average Color Value' FROM galamseydata WHERE observatoryName="+str);
        String g = null;
        while (rs.next()){
            g = rs.getString("Average Color Value");
        }
        return g;
    }

    //gets the largest colour value from the database of a particular observatory
    public String obv_largestColourValue(String observatoryName) throws SQLException, ClassNotFoundException {
        String str="'"+observatoryName+"'";
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement insertObservatory = myCon.createStatement();
        ResultSet rs = insertObservatory.executeQuery("SELECT MAX(colour_value) as colour_value FROM galamseydata WHERE observatoryName="+str);
        String g = null;
        while (rs.next()){
            g = rs.getString("colour_value");
        }
        return g;
    }

    //gets the galamseys which have a colour value above a given colour value.
    public ArrayList<Galamsey> obv_colourValueAbove(int n) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement insertObservatory = myCon.createStatement();
        ResultSet rs = insertObservatory.executeQuery("SELECT * FROM galamseydata WHERE colour_value >" + n);
        while (rs.next()){
            String col = rs.getString(2);
            galamList.add(new Galamsey(rs.getString(1),Galamsey.VC.valueOf(col), rs.getInt(4), rs.getDouble(5), rs.getDouble(6)));
        }
        return galamList;
    }
}
