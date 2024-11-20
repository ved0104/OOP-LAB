package lab6_7_8;//
//lab6_7_8.Q5.)(Gas mileage ) Drivers are concerned with the mileage their automobiles get. One driver has kept track
//of several trips by recording the miles driven and gallons used for each tankful.Develop a java application
//that will input the miles driven and gallons used(both as in) for each trip.The program should calculate
//and display the miles per gallon obtained for each trip and print the combined miles per gallon obtained
//for all trips up to this point. All averaging calculate should produce floating point results. Use class scanner
//and sentinel-controlled repetition to obtain the data from the user
import java.util.*;
class Trip{
    private double miles=0;
    private double gallons=0;

    Trip(double miles,double gallons){
        this.miles=miles;
        this.gallons=gallons;
    }
    public void setGallons(double gallons) {
        this.gallons = gallons;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }
    public double displayMilesPerGallon(Trip trip) {
        double milesPerGallon = trip.miles / trip.gallons;
        return milesPerGallon;
    }
}
public class Q5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter How many trips: ");
        int n=sc.nextInt();
        double totalGallons=0;
        Trip[] trip =new Trip[n];

        for(int i=0;i<n;i++){
            System.out.println("lab6_7_8.Trip: "+i);
            System.out.println("Enter number of miles: ");
            double miles=sc.nextDouble();
            System.out.println("Enter gallons used: ");
            double gallons=sc.nextDouble();
            trip[i]=new Trip(miles,gallons);
            System.out.println("Miles Per Gallon for this trip: "+ trip[i].displayMilesPerGallon(trip[i]));
            totalGallons=totalGallons+trip[i].displayMilesPerGallon(trip[i]);
        }
        System.out.println("Combined Miles per Gallon: "+ totalGallons);
    }
}