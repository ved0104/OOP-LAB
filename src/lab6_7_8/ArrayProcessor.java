//Declare an interface called Function that has a method named evaluate that takes an int parameter
//and returns an int value. Create a class Half that implements Function. Make the implementation of the
//method evaluate() return the value obtained by dividing the int argument by 2.In a client, create a method
//that takes an arbitrary array of int values as parameter and returns an array that has the same length, but
//the value of an element in the new array is half that of the value in the corresponding element in the array
//passed as parameter. Let the implementation of this method create an instance of Half and use this
//instance to calculate the values in the array to be returned.
package lab6_7_8;

public class ArrayProcessor {
    // Method to process array using Function implementation
    public static int[] processArray(int[] input, Function func) {
        if (input == null) {
            return null;
        }

        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = func.evaluate(input[i]);
        }
        return result;
    }

    // Helper method to print arrays
    public static void printArray(int[] arr, String message) {
        System.out.print(message + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Create instance of Half
        Half half = new Half();

        // Test case 1: Regular array
        int[] test1 = {10, 20, 30, 40, 50};
        System.out.println("\nTest Case 1: Regular array");
        printArray(test1, "Original array");
        int[] result1 = processArray(test1, half);
        printArray(result1, "Half values");

        // Test case 2: Array with odd numbers
        int[] test2 = {15, 25, 35, 45, 55};
        System.out.println("\nTest Case 2: Array with odd numbers");
        printArray(test2, "Original array");
        int[] result2 = processArray(test2, half);
        printArray(result2, "Half values");

        // Test case 3: Array with zero
        int[] test3 = {0, 10, 0, 20, 0};
        System.out.println("\nTest Case 3: Array with zeros");
        printArray(test3, "Original array");
        int[] result3 = processArray(test3, half);
        printArray(result3, "Half values");

        // Test case 4: Array with negative numbers
        int[] test4 = {-10, -20, -30, -40, -50};
        System.out.println("\nTest Case 4: Array with negative numbers");
        printArray(test4, "Original array");
        int[] result4 = processArray(test4, half);
        printArray(result4, "Half values");

        // Test case 5: Empty array
        int[] test5 = {};
        System.out.println("\nTest Case 5: Empty array");
        printArray(test5, "Original array");
        int[] result5 = processArray(test5, half);
        printArray(result5, "Half values");

        // Test case 6: Single element array
        int[] test6 = {100};
        System.out.println("\nTest Case 6: Single element array");
        printArray(test6, "Original array");
        int[] result6 = processArray(test6, half);
        printArray(result6, "Half values");

        // Demonstrate null handling
        System.out.println("\nTest Case 7: Null array");
        int[] result7 = processArray(null, half);
        System.out.println("Result for null array: " + (result7 == null ? "null" : "not null"));
    }
}