package project;

import java.io.IOException;
import java.sql.*;

public class testProgram {

    public static void main(String[] args) throws IOException {

        //Galamsey Operations
        Galamsey operation1 = new Galamsey("Beans",Galamsey.VC.BROWN, 2000, 101.65, 200.53);
        Galamsey operation2 = new Galamsey("Beans",Galamsey.VC.GREEN, 1970, 200.77, 190.56 );
//        Galamsey operation3 = new Galamsey(Galamsey.VC.YELLOW, 2019, 302.12, 100.42 ,"Beans");
//        Galamsey operation4 = new Galamsey(Galamsey.VC.GREEN, 2020, 750.75, 420.63 ,"Beans");


        //Utility Object, collection: To Store Galamsey Operations
        UtilityClass collection = new UtilityClass(6);
        collection.addEntry(operation1);
        collection.addEntry(operation2);
//        collection.addEntry(operation3);
//        collection.addEntry(operation4);
        collection.writeToFile();
        Observatory observatory1 = new Observatory("NATIONAL OBSERVATORY", "Ghana", 2019, 1000, collection);
        observatory1.writeToFile();

        //Writing To the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myCon=null;
            myCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/galam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","kwaku128@");
            operation1.writeDb();
            operation2.writeDb();
            observatory1.writeToDb();
            WritetoDatabase m=new WritetoDatabase();
            //m.deletefromdatabaseObseratory(1000);
            //m.deletefromdatabaseGalamsey(101.65,200.53);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Successfully Updated both tables");


    }
}
