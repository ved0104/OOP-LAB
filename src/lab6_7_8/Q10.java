package lab6_7_8;//Q.10) A string is entered like aabcdeaabcjlkjerwlaaabbsadfdsf...
//And you have to print those characters which exceed a given no. n entered by user.

import java.util.Scanner;

class checkExtraChar {
    private String str = new String();
    private int num;

    public checkExtraChar(String str, int num) {
        this.str = str;
        this.num = num;
    }

    public void checkExtra() {
        if (str.length()>num){
            System.out.println("Length Exceeded");
        }
        else{
            System.out.println("Length not Exceeded");
        }
        System.out.println("These are the extra Characters: ");
        for (int i=num;i<str.length();i++){
            System.out.print(str.charAt(i));
        }
    }
}

public class Q10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of characters you want to enter: ");
        int num = input.nextInt();
        System.out.println("Enter the String: ");
        String s = input.next();
        checkExtraChar check = new checkExtraChar(s, num);
        check.checkExtra();
    }
}
