package Project_1;


import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author  Mark Zoiku, Seyram Tamakloe, Anthony Basignaa
 * @version 1.0.0
 * @since 09-02-2020
 */
public class Galamsey {
    //Instance variables
    public enum VC {
        GREEN, YELLOW, BROWN
    }

    public VC veg_colour;
    public int colour_value;
    public double[] position;
    public int year_of_event;

    //Default constructor
    Galamsey(){
        veg_colour = VC.GREEN;
        colour_value = 0;
        year_of_event = 1990;
        position = new double[]{0,0};
    }

    /**
     *
     * @param veg_colour Enum value of the vegetation colour of the land
     * @param year_of_event Year value to be entered by the user
     * @param latitude longitude to be assigned to position array index 0
     * @param longitude latitude to be assigned to position array index 1
     */
    Galamsey(VC veg_colour, int year_of_event, double latitude, double longitude){
        this.veg_colour = veg_colour;

        if (veg_colour == VC.GREEN) {
            this.colour_value = 1;
        }
        else if(veg_colour == VC.YELLOW){
            this.colour_value = 2;
        }
        else if(veg_colour == VC.BROWN){
            this.colour_value = 3;
        }

        this.year_of_event = year_of_event;

        position = new double[]{longitude, latitude};
    }

    //MUTATOR METHODS FOR THE GALAMSEY CLASS
    public void setVeg_colour(VC veg_colour) { this.veg_colour = veg_colour; }

    public void setColour_value(int colour_value) {
        this.colour_value = colour_value;
    }

    public void setYear_of_event(int year_of_event) {
        this.year_of_event = year_of_event;
    }


    //ACCESSOR METHODS FOR GALAMSEY CLASS
    public VC getVeg_colour() {
        return veg_colour;
    }

    public int getColour_value() {
        return colour_value;
    }

    public int getYear_of_event() {
        return year_of_event;
    }

    public double getLongitude(){ return position[0]; }

    public double getLatitude(){return position[1];}

    public void writeDb() throws SQLException,Exception {
        WritetoDatabase util=new WritetoDatabase();
        util.writeToDatabaseGalamsey(getVeg_colour(),getYear_of_event(),getLongitude(),getLatitude());
    }

    @Override
    public String toString() {
        double latitude = this.position[0];
        double longitude = this.position[1];

        String position = ("Longitude: " + longitude + "" + "\nLatitude: " + latitude);

        return "\nVegetation colour: " + this.veg_colour + "\nColour value of vegetation: " + this.colour_value
                + "\nInitiated year: " + this.year_of_event + "\n" + position ;
    }

}