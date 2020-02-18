package project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Observatory extends UtilityClass {

    public String observatoryName;
    String countryName;
    int galamseyStartingYear;
    int areaCovered;
    UtilityClass event;
    ArrayList<Galamsey> galamseylist;
    FileWriter fileWriter;

    Observatory() throws IOException {
        observatoryName = null;
        countryName = null;
        galamseyStartingYear = 0;
        areaCovered = 0;
        event = null;
    }

    Observatory(String observatoryName, String countryName, int galamseyStartingYear, int areaCovered, UtilityClass event) throws IOException {
        this.observatoryName = observatoryName;
        this.countryName = countryName;
        this.galamseyStartingYear = galamseyStartingYear;
        this.areaCovered = areaCovered;
        this.event = event;
        fileWriter = new FileWriter("C:\\Users\\Basingnaa\\Desktop\\icp\\Observatory Data.txt");
    }

    public String getObservatoryName() {
        return observatoryName;
    }

    public void setObservatoryName(String observatoryName) {
        this.observatoryName = observatoryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getGalamseyStartingYear() {
        return galamseyStartingYear;
    }

    public void setGalamseyStartingYear(int galamseyStartingYear) {
        this.galamseyStartingYear = galamseyStartingYear;
    }

    public int getAreaCovered() {
        return areaCovered;
    }

    public void setAreaCovered(int areaCovered) {
        this.areaCovered = areaCovered;
    }

    public UtilityClass getEvent() {
        return event;
    }

    public void setEvent(UtilityClass event) {
        this.event = event;
    }

    public ArrayList<Galamsey> getGalamseylist() {
        return galamseylist;
    }

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


    void writeToFile() throws IOException {
        fileWriter = new FileWriter("C:\\Users\\Basingnaa\\Desktop\\icp\\Observatory Data.txt");
        fileWriter.write(observatoryName + "\n");
        fileWriter.write(countryName + "\n");
        fileWriter.write(galamseyStartingYear + "\n");
        fileWriter.write(areaCovered + "\n");
        //fileWriter.write("Largest Colour Values\t" + obv_largestColourValue() + "\n");
        //fileWriter.write("Average Colour Value\t" + obv_avgColourValue() + "\n");

        System.out.println("Observatory Data Done");

        fileWriter.close();

    }
}

