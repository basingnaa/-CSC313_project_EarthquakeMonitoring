package project;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
Monitoring class that extends Observatory class
 */
public class Monitoring extends Observatory {

    public static Monitoring stats;
    //public static UtilityClass collect = new UtilityClass(50);
    //public static UtilityClass collect;
    public static Observatory[] Obs = new Observatory[50];
    public static int n = 0;

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
   int obv_largestColourValue() throws SQLException, ClassNotFoundException {
        int maxColourValue = 0;
        for(int i = 0; i < event.numOperations; i++){
            if(event.galamseys[i].getColour_value() > maxColourValue){
                maxColourValue = event.galamseys[i].getColour_value();
            }
        }
       return maxColourValue;
//    }

    /**
     *
     */


//        double average;
//        double accumulated = 0;
//        final double TOTAL_ENTRIES = event.numOperations;
//
//        for(int i = 0; i < event.numOperations; i++){
//            accumulated += event.galamseys[i].getColour_value();
//        }
//        average = accumulated / TOTAL_ENTRIES;
//        return average;
    }

    /**
     *
     * @param colourvalue takes in arbitrary colour value from the user
     * @return :an ArrayList for all galamsey operations with colour value greater than the arbitrary number provided by the user
     */
    ArrayList<Galamsey> galamseyList_colourvalabove(ArrayList<Galamsey> galamseylist,int colourvalue){
        galamseylist = new ArrayList<>(event.getNumOperations());

        for(int i = 0; i < event.numOperations; i++){
            if(event.galamseys[i].getColour_value() > colourvalue){
                galamseylist.add(event.galamseys[i]);
            }
        }
        return galamseylist;
    }

    public static void printStats(ArrayList<Galamsey> list){
        for(int i = 0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public Observatory observatoryData() throws Exception {
        //UtilityClass coll;
        Scanner obs = new Scanner(System.in);
        System.out.println("Enter Observatory name: ");
        String name = obs.nextLine();
        //newObs.setObservatoryName(name);
        System.out.println("Enter Country name: ");
        String country = obs.nextLine();
        //newObs.setCountryName(country);
        System.out.println("Enter Area Covered: ");
        int area = obs.nextInt();
        //newObs.setAreaCovered(area);
        System.out.println("Enter Starting Year: ");
        int yr = obs.nextInt();
        //newObs.setGalamseyStartingYear(yr);
        UtilityClass coll = null;
        Observatory newObs = new Observatory(name,country,yr,area,coll);
        newObs.event = coll;
        addToObsList(newObs);
        //stats = new Monitoring(name,country,yr,area,collect);
        //ArrayList<Observatory> Obs = new ArrayList<>();
        //Obs.add(newObs);
        //newObs.writeToDb();
        return newObs;
        //ArrayList<ArrayList<Object>> ops = new ArrayList();
//        for(int i=0;i<100;i++){
//            ops.add(new ArrayList<Object>(ops));
//        }
    }

    public Galamsey galamseyData() throws Exception {

        Scanner gam = new Scanner(System.in);
        System.out.println("Enter Vegetation Colour(GREEN, BROWN, YELLOW): ");
        String colour = gam.nextLine();
        String col = colour.toUpperCase();
        //newGalam.setVeg_colour(Galamsey.VC.valueOf(col));
        System.out.println("Enter Year of Event: ");
        int yr = gam.nextInt();
        //newGalam.setYear_of_event(yr);
        System.out.println("Enter Longitude: ");
        double lng = gam.nextDouble();
        System.out.println("Enter Latitude: ");
        double lat = gam.nextDouble();
        //newGalam.setPosition(lng,lat);
        System.out.println("Enter Observatory");
        String obsName = gam.nextLine();
        Galamsey newGalam = new Galamsey(obsName,Galamsey.VC.valueOf(col),yr,lat,lng);
        System.out.println(String.valueOf(newGalam.getVeg_colour())+ newGalam.getYear_of_event() + newGalam.getLatitude()+ newGalam.getLongitude());
        return newGalam;
        //newGalam.writeDb();
        //collect = new UtilityClass(50);
        //collect.addEntry(newGalam);
//        ArrayList<ArrayList<Object>> ops = new ArrayList();
//        for(int i=0;i<100;i++){
//            ops.add(new ArrayList<Object>(ops));
        //}
    }

    public void addToObsList(Observatory add){
        Obs[n] = add;
        n++;
    }

    public Observatory getObs() throws IOException {
        Observatory current = null;
        Scanner obsNm = new Scanner(System.in);
        System.out.println("Enter Observatory name");
        String name = obsNm.nextLine();
        for(Observatory i : Obs){
            System.out.println(i.getObservatoryName());
            if(i.getObservatoryName().equals(name)){
                current = i;
            }
        }
        return current;
    }
    
}
