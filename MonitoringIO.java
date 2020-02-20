package project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MonitoringIO{
    public static Monitoring stats;
    //public static UtilityClass collect = new UtilityClass(50);
    //public static UtilityClass collect;
    public static Observatory[] Obs = new Observatory[50];
    public static int n = 0;

    public static Observatory observatoryData() throws Exception {
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

    public static Galamsey galamseyData() throws Exception {

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
        Galamsey newGalam = new Galamsey(Galamsey.VC.valueOf(col),yr,lat,lng);
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

    public static void addToObsList(Observatory add){
        Obs[n] = add;
        n++;
    }

    public static Observatory getObs() throws IOException {
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




    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        System.out.print("Continue or Exit >> ");
        String dec = scan.next();




        while (!dec.equals("Exit")) {
            System.out.print("1. Enter Observatory data \n2. Enter Galamsey data  \n3. Monitoring Statistics\n" + "\nPrompt >> ");
            int input = scan.nextInt();

            switch (input) {
                case 1:
                    Observatory obsdata = observatoryData();
                    obsdata.writeToDb();
                    //addToObsList(obsdata);
                    //int n = 0;
                    //Obs[n] = obsdata;
                    //n++;
                    for(int i =0;i<n;i++){
                        System.out.println(Obs[i].getObservatoryName());
                    }

                    stats = new Monitoring(obsdata.getObservatoryName(),obsdata.getCountryName(),obsdata.galamseyStartingYear,obsdata.getAreaCovered(),obsdata.event);
                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;

                case 2:
                    Observatory currObs = getObs();
                    Galamsey galamdata = galamseyData();
                    currObs.event.addEntry(galamdata);
                    galamdata.writeDb();
                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;
                case 3:
//                    Scanner obsNm = new Scanner(System.in);
//                    System.out.println("Enter Observatory name");
//                    String name = obsNm.nextLine();
//                    for(int i = 0;i < 100; i++){
//                        if(Obs.get(i).getObservatoryName().equals(name)){
//                            return;
//                        }
//                    }
                    //Observatory curObs = getObs();
                    int col_value = 1;
                    ArrayList<Galamsey>  galamList = Obs[0].event.operationList();
                    ArrayList<Galamsey> array = stats.galamseyList_colourvalabove(galamList,col_value);
                    System.out.println("Galamsey with colour value above 1 is: ");
                    stats.printGalamList(array);
                    System.out.println("Galamsey with largest colour value is: " + stats.obv_largestColourValue());
                    System.out.println("Average colour of Galamsey is: " + stats.obv_avgColourValue());


                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;
                }
            }
        }
    }