package Project_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

class WritetoDatabase {
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/galam";

	static final String USER="root";
	static final String PASS="kwaku128@";

	void writeToDatabaseGalamsey(Enum colour, int year, double latitude, double longitude,int gal) throws SQLException, Exception {
		Connection myCon;
		String str = "'" + colour + "'";
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertGalam = myCon.prepareStatement("INSERT INTO galamseydata(colour, year_observed, latitude,longitude,ID) VALUES (" + str + "," + year + "," + latitude + "," + longitude + "," + gal + ");");
		insertGalam.executeUpdate();
	}

    void writeToDatabaseObservatory(String observatoryName,String countryName, int year, int area)throws SQLException,Exception {
    	Connection myCon;
		String str="'"+observatoryName+"'";
		String str1="'"+countryName+"'";
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("INSERT INTO observatorydata(observatoryName, countryName, galamseyStartyear, areaCovered ) VALUES ("+str+","+str1+","+year+","+area+");");
		insertObservatory.executeUpdate();
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

	void deletefromdatabase(String tablename,String condition)throws SQLException,Exception{
		Connection myCon;
		String str="'"+tablename+"'";
		String str1="'"+condition+"'";
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("DELETE FROM"+tablename +" WHERE"+condition);
		insertObservatory.executeUpdate();
	}

	void createGalamsey()throws SQLException,Exception{
		Connection myCon;
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement(
				"Create table if not exists galamseydata(\n" +
						"\tcolour varchar(10),\n" +
						"    year_observed year,\n" +
						"    GID mediumint auto_increment primary key,\n" +
						"    latitude double,\n" +
						"    longitude double,\n" +
						"    ID mediumint, \n" +
						"    foreign key(ID) references observatorydata(ID) On update cascade On delete cascade\n" +
						"\t);");
		insertObservatory.executeUpdate();
	}

	void createObservatory()throws SQLException,Exception{
		Connection myCon;
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement(" create table if not exists observatorydata(\n" +
				"\tobservatoryName varchar(35),\n" +
				"    countryName varchar(20),\n" +
				"    ID mediumint auto_increment,\n" +
				"    primary key(ID),\n" +
				"    galamseyStartYear mediumint,\n" +
				"    areaCovered mediumint\n" +
				"\t);");
		insertObservatory.executeUpdate();
	}

	void deleteDatabase()throws SQLException,Exception{
		Connection myCon;
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("Drop database galam");
		insertObservatory.executeUpdate();
	}

	void deletegalamseydata()throws SQLException,Exception{
		Connection myCon;
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("Drop table galamseydata");
		insertObservatory.executeUpdate();
	}
	void deleteobservatorydata()throws SQLException,Exception{
		Connection myCon;
		Class.forName("com.mysql.jdbc.Driver");
		myCon = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement insertObservatory=myCon.prepareStatement("Drop table observatorydata");
		insertObservatory.executeUpdate();
	}


}
