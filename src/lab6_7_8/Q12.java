package lab6_7_8;

import java.util.Scanner;

//Q.12) you have to enter a range from a and b and search how many no. of times a pattern n. occurs
//between the range a and b.
//Eg :i/p:enter range :0 100
//Enter pattern: 13
//o/p: the no. times 13 occurred betwwn 0 to 100:1
//Eg :i/p:enter range :100 1000
//Enter pattern: 13
//o/p: the no. times 13 occurred betwwn 100 to 1000:
//        (in this 13,113,131,132,133.139,213,313,.913 all these will be counted)
public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter range: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Enter a pattern");
        String pattern = sc.next();
        sc.nextLine();
        int count=0;

        int length = pattern.length();

        for (int i = a; i <= b; i++) {
            String str = i + "";
            for (int j = 0; j <= str.length() - length; j++) {
                if (j + length <= str.length() && str.substring(j).startsWith(pattern)) {
                    System.out.print(i+" ");
                    count++;
                }
            }
        }
        System.out.println("\nCount: "+count);
    }
}
