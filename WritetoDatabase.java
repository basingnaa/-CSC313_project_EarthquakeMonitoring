package project;

/**
 * @author Kwaku Ofusu-Agyemang and Anthony Basingnaa
 * @Version 1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

class WritetoDatabase {
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/galam";

	static final String USER="root";
	static final String PASS="admin";

	/**
	 *
	 * @param observatoryName name of the observatory
	 * @param colour colour observed
	 * @param colour_value value of the colour
	 * @param year year event occured
	 * @param latitude positional latitude
	 * @param longitude positional longitude
	 * @throws SQLException
	 * @throws Exception
	 */
	void writeToDatabaseGalamsey(String observatoryName, Enum colour, int colour_value, int year, double latitude, double longitude) throws SQLException, Exception {
		Connection myCon;
		String str = "'" + colour + "'";
		String str1="'"+observatoryName+"'";
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);

		PreparedStatement insertGalam = myCon.prepareStatement("INSERT INTO galamseydata(observatoryName,colour,colour_value, year_observed, latitude,longitude) VALUES ("+str1+", " + str + ","+colour_value+"," + year + "," + latitude + "," + longitude + ");");
		insertGalam.executeUpdate();
		System.out.println("Galamsey Data Added.");

	}

	/**
	 *
	 * @param observatoryName name of the observatory
	 * @param countryName name of country where observatory is located
	 * @param year year it was established
	 * @param area area it covers
	 * @throws SQLException
	 * @throws Exception
	 */
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


	/**
	 *
	 * @param areaCovered area observatory to be deleted covers
	 * @throws SQLException
	 * @throws Exception
	 */

	void deletefromdatabaseObseratory(int areaCovered)throws SQLException,Exception{
		Connection myCon;
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("DELETE FROM observatorydata WHERE areaCovered="+areaCovered);
		insertObservatory.executeUpdate();

	}

	/**
	 *
	 * @param latitude of galamsey to be deleted
	 * @param longitude of galamsey to be deleted
	 * @throws SQLException
	 * @throws Exception
	 */
	void deletefromdatabaseGalamsey(double latitude,double longitude)throws SQLException,Exception{
		Connection myCon;
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("DELETE FROM galamseydata WHERE latitude="+latitude+"and longitude="+longitude);
		insertObservatory.executeUpdate();
	}
}
