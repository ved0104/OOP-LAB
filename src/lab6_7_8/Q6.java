package lab6_7_8;//lab6_7_8.Q6) Write a function Model-of-Category for a Tata motor dealers, which accepts category of car customer
//is looking for and returns the car Model available in that category. the function should accept the
//following categories “SUV”, “SEDAN”, “ECONOMY”, and “MINI” which in turn returns “TATA SAFARI” ,
//        “TATA INDIGO” , “TATA INDICA” and “TATA NANO” respectively

import java.util.*;

class Cars{
    private String str=new String();
    public void Input(){
        Scanner sc=new Scanner(System.in);
        str=sc.nextLine();
    }
    public void Output(){
        if(str.equals("SUV")){
            System.out.println("TATA SAFARI");
        }else if(str.equals("SEDAN")){
            System.out.println("TATA INDIGO");
        }else if(str.equals("ECONOMY")){
            System.out.println("TATA INDICA");
        }else if(str.equals("MINI")){
            System.out.println("TATA NANO");
        }
    }
}
public class Q6 {
    public static void main(String[] args) {
        Cars cars=new Cars();
        cars.Input();
        cars.Output();
    }
}
