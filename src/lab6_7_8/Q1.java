package lab6_7_8;
// Create an application that calculate your daily driving cost , so that you can estimate how much
// money could be saved by car-pooling which also has other advantages such as reducing carbon
// emission and traffic congestion . The application should input the following information and display 
// the user's cost per day of driving to work.
//  total miles driven per day 
//  b)cost per gallon of gasoline
//  c)average fees per day 
//  d)tolls per day
import java.util.Scanner;

class DrivingCostCalculator {
    private double milesDrivenPerDay;
    private double costPerGallon;
    private double averageFeesPerDay;
    private double tollsPerDay;
    private double milesPerGallon;

    public DrivingCostCalculator(double milesDrivenPerDay, double costPerGallon,double averageFeesPerDay, double tollsPerDay, double milesPerGallon) {
        this.milesDrivenPerDay = milesDrivenPerDay;
        this.costPerGallon = costPerGallon;
        this.averageFeesPerDay = averageFeesPerDay;
        this.tollsPerDay = tollsPerDay;
        this.milesPerGallon = milesPerGallon;
    }

    public double calculateDailyCost() {
        double fuelCost = (milesDrivenPerDay / milesPerGallon) * costPerGallon;
        return fuelCost + averageFeesPerDay + tollsPerDay;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total miles driven per day: ");
        double milesDrivenPerDay = scanner.nextDouble();

        System.out.print("Enter cost per gallon of gasoline: ");
        double costPerGallon = scanner.nextDouble();

        System.out.print("Enter average fees per day (e.g., parking fees): ");
        double averageFeesPerDay = scanner.nextDouble();

        System.out.print("Enter tolls per day: ");
        double tollsPerDay = scanner.nextDouble();

        System.out.print("Enter miles per gallon of your vehicle: ");
        double milesPerGallon = scanner.nextDouble();

        System.out.print("Enter no of people for carpooling: ");
        double numOfPeople=scanner.nextInt();

        DrivingCostCalculator calculator = new DrivingCostCalculator(
                milesDrivenPerDay, costPerGallon, averageFeesPerDay, tollsPerDay, milesPerGallon);

        double dailyCost = calculator.calculateDailyCost();
        double perPersonCost=dailyCost/numOfPeople;
        double savings=dailyCost-perPersonCost;
        System.out.printf("Your daily driving cost is: $%.2f%n", savings);

        scanner.close();
    }
}