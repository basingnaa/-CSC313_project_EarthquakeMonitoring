package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

class WritetoDatabase {
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/galam";

	static final String USER="root";
	static final String PASS="admin";
	void writeToDatabaseGalamsey(Enum colour, int year, double latitude, double longitude) throws SQLException, Exception {
		Connection myCon;
		String str = "'" + colour + "'";

		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertGalam = myCon.prepareStatement("INSERT INTO galamseydata(colour, year_observed, latitude,longitude) VALUES (" + str + "," + year + "," + latitude + "," + longitude + ");");
		insertGalam.executeUpdate();
		System.out.println("Galamsey Data Added.");

	}

    void writeToDatabaseObservatory(String observatoryName,String countryName, int year, int area)throws SQLException,Exception {
    	Connection myCon;
		String str="'"+observatoryName+"'";
		String str1="'"+countryName+"'";

		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("INSERT INTO observatorydata(observatoryName, countryName, galamseyStartyear, areaCovered ) VALUES ("+str+","+str1+","+year+","+area+");");
		insertObservatory.executeUpdate();
		System.out.println("Observatory Data Added.");

    }
    void insertIntoDatabaseGalamsey(Enum colour, int year, double latitude, double longitude) throws SQLException,Exception{
		Connection myCon;
		String str = "'" + colour + "'";

		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertGalam = myCon.prepareStatement("INSERT INTO galamseydata(colour, year_observed, latitude,longitude) VALUES (" + str + "," + year + "," + latitude + "," + longitude + ");");
		insertGalam.executeUpdate();


	}
	void insertIntoDatabaseObservatory(String observatoryName,String countryName, int year, int area)throws SQLException,Exception{
		Connection myCon;
		String str="'"+observatoryName+"'";
		String str1="'"+countryName+"'";
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("INSERT INTO observatorydata(observatoryName, countryName, galamseyStartyear, areaCovered ) VALUES ("+str+","+str1+","+year+","+area+");");
		insertObservatory.executeUpdate();

	}
	void deletefromdatabaseObseratory(int areaCovered)throws SQLException,Exception{
		Connection myCon;
		//String str="'"+countryName+"'";
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("DELETE FROM observatorydata WHERE areaCovered="+areaCovered);
		insertObservatory.executeUpdate();

	}
	void deletefromdatabaseGalamsey(double latitude,double longitude)throws SQLException,Exception{
		Connection myCon;
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("DELETE FROM galamseydata WHERE latitude="+latitude+"and longitude="+longitude);
		insertObservatory.executeUpdate();
	}
}
