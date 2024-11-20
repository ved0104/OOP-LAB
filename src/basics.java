import java.util.Scanner;

public class basics {
    public static int quotient(int number1, int number2) {
        if (number2 == 0)
            throw new ArithmeticException("Division by zero is not possible");
        System.out.println("Executed after throw");
        return number1 / number2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y;
        x = sc.nextInt();
        y = sc.nextInt();
        int result;
        result = quotient(x, y);
        System.out.println(x + " divided by " + y + " is " + x / y);

    }
}
//        long value=Long.MAX_VALUE+1;
//        System.out.println(value);
