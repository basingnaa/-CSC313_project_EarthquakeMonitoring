package Project_1;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Observatory extends UtilityClass {

    //All instance variables
    public String observatoryName;
    String countryName;
    int galamseyStartingYear;
    int areaCovered;
    UtilityClass event;
    ArrayList<Galamsey> galamseylist;
    FileWriter fileWriter;
    int OID;

    //Default constructor
    Observatory() throws IOException {
        observatoryName = null;
        countryName = null;
        galamseyStartingYear = 0;
        areaCovered = 0;
        event = null;
    }

    /**
     * Overloaded constructor
     * @param observatoryName Takes in the Observatory name
     * @param countryName Takes the name of the country of the galamsey operation
     * @param galamseyStartingYear Takes the beginning year of the galamsey operation
     * @param areaCovered Takes in the total distance of the area covered by the galamsey operation
     * @param event An instance of the utility class named event
     * @throws IOException Exception thrown to catch all possible errors in the program
     */
    Observatory(String observatoryName, String countryName, int galamseyStartingYear, int areaCovered, UtilityClass event) throws IOException {
        this.observatoryName = observatoryName;
        this.countryName = countryName;
        this.galamseyStartingYear = galamseyStartingYear;
        this.areaCovered = areaCovered;
        this.event = event;
        //fileWriter = new FileWriter("C:\\Users\\Kwaku Ofosu-Agyeman\\Desktop\\Observatory Data.txt");
    }
    Observatory(String observatoryName, String countryName, int galamseyStartingYear, int areaCovered, UtilityClass event, int OID) throws IOException {
        this.observatoryName = observatoryName;
        this.countryName = countryName;
        this.galamseyStartingYear = galamseyStartingYear;
        this.areaCovered = areaCovered;
        this.event = event;
        this.OID=OID;
        //fileWriter = new FileWriter("C:\\Users\\Kwaku Ofosu-Agyeman\\Desktop\\Observatory Data.txt");
    }



    /**
     *
     * @return String data type observatoryName returned
     */
    public String getObservatoryName() {
        return observatoryName;
    }

    public void setObservatoryName(String observatoryName) {
        this.observatoryName = observatoryName;
    }

    /**
     *
     * @return String data type countryName returned
     */
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     *
     * @return :Int data type galamseyStartingYear returned
     */
    public int getGalamseyStartingYear() {
        return galamseyStartingYear;
    }

    public void setGalamseyStartingYear(int galamseyStartingYear) {
        this.galamseyStartingYear = galamseyStartingYear;
    }

    /**
     *
     * @return Int data type areaCovered
     */
    public int getAreaCovered() {
        return areaCovered;
    }

    public void setAreaCovered(int areaCovered) {
        this.areaCovered = areaCovered;
    }

    /**
     *
     * @return Utility class instance returned
     */
    public UtilityClass getEvent() {
        return event;
    }

    public void setEvent(UtilityClass event) {
        this.event = event;
    }

    /**
     *
     * @return ArrayList returned
     */
    public ArrayList<Galamsey> getGalamseylist() {
        return galamseylist;
    }

    /**
     * Setter method for OID
     * @param OID
     */
    public void setOID(int OID){ this.OID=OID; }

    /**
     * Setter method for OID
     * @return OID:int
     */
    public int getOID() { return this.OID;}


    int obv_largestColourValue() {
        int maxColourValue = 0;

        for(int i = 0; i < event.numOperations; i++){
            if(event.galamseys[i].getColour_value() > maxColourValue){
                maxColourValue = event.galamseys[i].getColour_value();
            }
        }
        return maxColourValue;
    }

    double obv_avgColourValue() {
        double average;
        double accumulated = 0;
        final double TOTAL_ENTRIES = event.numOperations;

        for(int i = 0; i < event.numOperations; i++){
            accumulated += event.galamseys[i].getColour_value();
        }
        average = accumulated / TOTAL_ENTRIES;

        return average;
    }

    ArrayList<Galamsey> galamseyList_colourvalabove(int colourvalue) {
        galamseylist = new ArrayList<>(event.getNumOperations());

        for(int i = 0; i < event.numOperations; i++){
            if(event.galamseys[i].getColour_value() > colourvalue){
                galamseylist.add(event.galamseys[i]);
            }
        }
        return galamseylist;
    }


    //Storing data in a new file using the FileWriter class
   /* void writeToFile() throws IOException {
        fileWriter = new FileWriter("C:\\Users\\Kwaku Ofosu-Agyeman\\Desktop\\Observatory Data.txt");
        fileWriter.write(observatoryName + "\n");
        fileWriter.write("Largest Colour Values\t" + obv_largestColourValue() + "\n");
        fileWriter.write("Average Colour Value\t" + obv_avgColourValue() + "\n");

        System.out.println("Observatory Data Done");

        fileWriter.close();

    }*/
    void writeToDb()throws SQLException,Exception {
        WritetoDatabase util=new WritetoDatabase();
        util.writeToDatabaseObservatory(getObservatoryName(),getCountryName(),getGalamseyStartingYear(),getAreaCovered());
    }
}

