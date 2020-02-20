package project;

import java.util.Scanner;


public class MonitoringIO{

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        System.out.print("Continue or Exit >> ");
        String dec = scan.next();




        while (!dec.equals("Exit")) {
            System.out.print("1. Enter Observatory data \n2. Enter Galamsey data  \n3. Monitoring Statistics\n" + "\nPrompt >> ");
            int input = scan.nextInt();

            switch (input) {
                case 1:
                    Scanner obs = new Scanner(System.in);
                    System.out.println("Enter Observatory name: ");
                    String name = obs.nextLine();
                    System.out.println("Enter Country name: ");
                    String country = obs.nextLine();
                    System.out.println("Enter Area Covered: ");
                    int area = obs.nextInt();
                    System.out.println("Enter Starting Year: ");
                    int yr = obs.nextInt();
                    UtilityClass coll = null;
                    Observatory newObs = new Observatory(name,country,yr,area,coll);
                    newObs.event = coll;
                    newObs.writeToDb();
                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;

                case 2:
                    Scanner gam = new Scanner(System.in);
                    System.out.println("Enter Observatory");
                    String obsName = gam.nextLine();
                    System.out.println("Enter Vegetation Colour(GREEN, BROWN, YELLOW): ");
                    String colour = gam.nextLine();
                    String col = colour.toUpperCase();
                    System.out.println("Enter Year of Event: ");
                    int yrs = gam.nextInt();
                    System.out.println("Enter Longitude: ");
                    double lng = gam.nextDouble();
                    System.out.println("Enter Latitude: ");
                    double lat = gam.nextDouble();
                    Galamsey newGalam = new Galamsey(obsName,Galamsey.VC.valueOf(col),yrs,lat,lng);
                    System.out.println(String.valueOf(newGalam.getObs() + newGalam.getVeg_colour())+ newGalam.getYear_of_event() + newGalam.getLatitude()+ newGalam.getLongitude());
                    newGalam.writeDb();
                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;
                case 3:
                    System.out.println("Enter Existing Observatory Name");
                    Scanner st = new Scanner(System.in);
                    String obname = st.nextLine();
                    MonitorStats monitor = new MonitorStats();
                    int col_value = 1;
                    System.out.println("Average colour value is: " + monitor.obv_avgColourValue(obname));
                    System.out.println("Largest colour value is: " + monitor.obv_largestColourValue(obname));
                    System.out.println("Galamsey with colour value above " + col_value + " is " + monitor.obv_colourValueAbove(col_value));
                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;
                }
            }
        }
    }