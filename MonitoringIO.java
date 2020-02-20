package project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MonitoringIO{
    public static Monitoring stats;
    public static UtilityClass collect;

    public static void observatoryData() throws Exception {
        Observatory newObs = new Observatory();
        Scanner obs = new Scanner(System.in);
        System.out.println("Enter Observatory name: ");
        String name = obs.nextLine();
        newObs.setObservatoryName(name);
        System.out.println("Enter Country name: ");
        String country = obs.nextLine();
        newObs.setCountryName(country);
        System.out.println("Enter Area Covered: ");
        int area = obs.nextInt();
        newObs.setAreaCovered(area);
        System.out.println("Enter Starting Year: ");
        int yr = obs.nextInt();
        newObs.setGalamseyStartingYear(yr);
        stats = new Monitoring(name,country,yr,area,collect);
        ArrayList<Observatory> Obs = new ArrayList<>();
        Obs.add(newObs);
        newObs.writeToDb();
        ArrayList<ArrayList<Object>> ops = new ArrayList();
//        for(int i=0;i<100;i++){
//            ops.add(new ArrayList<Object>(ops));
//        }
    }

    public static void galamseyData() throws Exception {
        Galamsey newGalam = new Galamsey();
        Scanner gam = new Scanner(System.in);
        System.out.println("Enter Vegetation Colour(GREEN, BROWN, YELLOW): ");
        String colour = gam.nextLine();
        String col = colour.toUpperCase();
        newGalam.setVeg_colour(Galamsey.VC.valueOf(col));
        System.out.println("Enter Year of Event: ");
        int yr = gam.nextInt();
        newGalam.setYear_of_event(yr);
        System.out.println("Enter Longitude: ");
        double lng = gam.nextDouble();
        System.out.println("Enter Latitude: ");
        double lat = gam.nextDouble();
        newGalam.setPosition(lng,lat);
        newGalam.writeDb();
        collect = new UtilityClass(50);
        collect.addEntry(newGalam);
//        ArrayList<ArrayList<Object>> ops = new ArrayList();
//        for(int i=0;i<100;i++){
//            ops.add(new ArrayList<Object>(ops));
        //}
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
                    observatoryData();
                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;

                case 2:
                    galamseyData();
                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;
                case 3:
                    int col_value = 1;
                    ArrayList<Galamsey>  galamList = collect.operationList();
                    ArrayList<Galamsey> array = stats.galamseyList_colourvalabove(galamList,col_value);
                    System.out.println("Galamsey with colour value above 1 is: ");
                    stats.printGalamList(array);
                    System.out.println("Galamsey with largest colour value is: " + stats.obv_largestColourValue());
                    System.out.println("Average colour of Galamsey is: " + stats.obv_avgColourValue());

//                    FileReader fileReader = new FileReader("C:\\Users\\Basingnaa\\Desktop\\icp\\Observatory Data.txt");
//                    Scanner scan1 = new Scanner(fileReader);
//                    while (scan1.hasNext()) {
//                        System.out.println(scan1.nextLine());
//                    }
//                    FileReader fileReader2 = new FileReader("C:\\Users\\Basingnaa\\Desktop\\icp\\Galamsey Data.txt");
//                    Scanner scan2 = new Scanner(fileReader2);
//                    while (scan2.hasNext()) {
//                        System.out.println(scan2.nextLine());
//                    }

                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;
                }
            }
        }
    }