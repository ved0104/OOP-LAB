package lab6_7_8;

import java.util.Scanner;

//Q.11) You have to enter a string and check whether it is a perfect string or not. A perfect string is a string
//which has occurrence of every character only once.
//Eg. absdhkqwertyuioplmnvczx

class checkPerfectString{
    private String str;

    public checkPerfectString(String str) {
        this.str = str;
    }
    public boolean checkString(){
        int[] arr=new int[256];
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)]++;
        }
        for (int j : arr) {
            if (j > 1) {
                return false;
            }
        }
        return true;
    }
}
public class Q11 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str= input.next();
        checkPerfectString check =new checkPerfectString(str);
        if (!check.checkString()) {
            System.out.println("Not a perfect String");
        }else{
            System.out.println("Perfect String");
        }
    }
}
