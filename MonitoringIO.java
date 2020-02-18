package project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MonitoringIO{
    public static void observatoryData() throws IOException {
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
        ArrayList<Observatory> Obs = new ArrayList<>();
        Obs.add(newObs);
        newObs.writeToFile();
        ArrayList<ArrayList<Object>> ops = new ArrayList();
        for(int i=0;i<100;i++){
            ops.add(new ArrayList<Object>(ops));
        }

    }

    public static void galamseyData() throws IOException{
        Galamsey newGalam = new Galamsey();
        Scanner gam = new Scanner(System.in);
        System.out.println("Enter Vegetation Colour(GREEN, BROWN, YELLOW): ");
        String colour = gam.nextLine();
        newGalam.setVeg_colour(Galamsey.VC.valueOf(colour));
        System.out.println("Enter Year of Event: ");
        int yr = gam.nextInt();
        newGalam.setYear_of_event(yr);
        System.out.println("Enter Longitude: ");
        double lng = gam.nextDouble();
        System.out.println("Enter Latitude: ");
        double lat = gam.nextDouble();
        newGalam.setPosition(lng,lat);

        ArrayList<ArrayList<Object>> ops = new ArrayList();
        for(int i=0;i<100;i++){
            ops.add(new ArrayList<Object>(ops));
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Continue or Exit >> ");
        String dec = scan.next();



        while(!dec.equals("Exit")){
            System.out.print("1. Enter Observatory data \n2. Enter Galamsey data  \n3. Monitoring Statistics\n" + "\nPrompt >> ");
            int input = scan.nextInt();

            switch (input){
                case 1:
                    observatoryData();
                    /*FileReader fileReader = new FileReader("C:\\Users\\Basingnaa\\Desktop\\icp\\Observatory Data.txt");
                    Scanner scan1 = new Scanner(filereader);
                    while(scan1.hasNext()) {
                        System.out.println(scan1.nextLine());
                    }*/

                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;

                case 2:
                    galamseyData();
                    /*FileReader fileReader2 = new FileReader("C:\\Users\\Basingnaa\\Desktop\\icp\\Galamsey Data.txt");
                    Scanner scan2 = new Scanner(fileReader2);
                    while(scan2.hasNext()){
                        System.out.println(scan2.nextLine());
                    }*/
                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;
                case 3:
                    FileReader fileReader = new FileReader("C:\\Users\\Basingnaa\\Desktop\\icp\\Observatory Data.txt");
                    Scanner scan1 = new Scanner(fileReader);
                    while(scan1.hasNext()) {
                        System.out.println(scan1.nextLine());
                    }
                    FileReader fileReader2 = new FileReader("C:\\Users\\Basingnaa\\Desktop\\icp\\Galamsey Data.txt");
                    Scanner scan2 = new Scanner(fileReader2);
                    while(scan2.hasNext()){
                        System.out.println(scan2.nextLine());
                    }

                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;

                default:
                    System.out.println("Input error: Please follow the prompt to select 1, 2 or 3");
                    break;
            }
        }
    }
}



