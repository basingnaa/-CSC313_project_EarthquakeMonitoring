package project;

import java.io.IOException;
import java.util.ArrayList;

/*
Monitoring class that extends Observatory class
 */
public class Monitoring extends Observatory {

    /**
     *
     * @param observatoryName Takes in the Observatory name
     * @param countryName Takes the name of the country of the galamsey operation
     * @param galamseyStartingYear Takes the beginning year of the galamsey operation
     * @param areaCovered Takes in the total distance of the area covered by the galamsey operation
     * @param event An instance of the utility class named event
     * @throws IOException Exception thrown to catch all possible errors in the program
     */
    Monitoring(String observatoryName, String countryName, int galamseyStartingYear, int areaCovered, UtilityClass event) throws IOException {
        super(observatoryName, countryName, galamseyStartingYear, areaCovered, event);
    }

    /**
     *
     * @return : An int data type for the largest value in the galamsey array
     */
    int obv_largestColourValue(){
        int maxColourValue = 0;

        for(int i = 0; i < event.numOperations; i++){
            if(event.galamseys[i].getColour_value() > maxColourValue){
                maxColourValue = event.galamseys[i].getColour_value();
            }
        }
        return maxColourValue;
    }

    /**
     *
     * @return : A double data type for the average colour values of all galamsey operations in the galamsey array
     */
    double obv_avgColourValue(){
        double average;
        double accumulated = 0;
        final double TOTAL_ENTRIES = event.numOperations;

        for(int i = 0; i < event.numOperations; i++){
            accumulated += event.galamseys[i].getColour_value();
        }
        average = accumulated / TOTAL_ENTRIES;
        return average;
    }

    /**
     *
     * @param colourvalue takes in arbitrary colour value from the user
     * @return :an ArrayList for all galamsey operations with colour value greater than the arbitrary number provided by the user
     */
    ArrayList<Galamsey> galamseyList_colourvalabove(int colourvalue){
        ArrayList<Galamsey> galamseylist = new ArrayList<>(event.getNumOperations());

        for(int i = 0; i < event.numOperations; i++){
            if(event.galamseys[i].getColour_value() > colourvalue){
                galamseylist.add(event.galamseys[i]);
            }
        }
        return galamseylist;
    }
    
}
