package project;

import java.io.IOException;
import java.util.ArrayList;

public class Monitoring extends Observatory {

    Monitoring(String observatoryName, String countryName, int galamseyStartingYear, int areaCovered, UtilityClass event) throws IOException {
        super(observatoryName, countryName, galamseyStartingYear, areaCovered, event);
    }

    int obv_largestColourValue(){
        int maxColourValue = 0;

        for(int i = 0; i < event.numOperations; i++){
            if(event.galamseys[i].getColour_value() > maxColourValue){
                maxColourValue = event.galamseys[i].getColour_value();
            }
        }
        return maxColourValue;
    }

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
