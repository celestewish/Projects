//Name: Lauren Rousell
//Class: CS 3305/H01
//Term: Fall 2024
//Instructor: Dr. Haddad
//Assignment: 2
//IDE Name: IntelliJ
import java.util.Random;
import java.util.Scanner;
public class EvenCount {
    /*this code allows you to generate a random array, print it
    and count the number of even integers in said array*/
    public static void main(String[] args) {
        //initializing variables
        int[] myArray = new int[10];
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        boolean isTrue = true;
        //this while loop controls the user's interface
        while (isTrue) {
            System.out.println("\n-----------------MAIN MENU--------------\n" +
                    "1. Populate array with random values\n" +
                    "2. Count even values and display output\n" +
                    "3. Exit program\n\n" +
                    "Enter option number:");
            //this switch case allows the user to cycle between possible options
            switch (sc.nextInt()) {
                //this case creates a random array
                case 1:
                    for (int i = 0; i < myArray.length; i++) {
                        myArray[i] = rand.nextInt(1000);
                    }
                    break;
                    //this case prints the array and counts the even values in said array
                case 2:
                    System.out.print("Array values:        ");
                    printArray(myArray);
                    System.out.println();
                    System.out.println("Even values count:   " + countEvens(myArray) + " values\n");
                    break;
                    //this case ends the loop and stops the code
                case 3:
                    isTrue = false;
            }
        }
    }
    //counts the number of even numbers in an array
    public static int countEvens(int[] myArray){
        //initializes variables used
        int count = 0;
        //checks to see if array is empty
        //is also the base case
        if (myArray == null || myArray.length == 0){
            return 0;
        }
        //checks for odd number, then removes odd number and continues
        if (myArray[0] % 2 != 0) {
            myArray = removeFirstElement(myArray);
            return countEvens(myArray);
        }
        //checks for even number, removes even number, adds to count and continues
        else if (myArray[0] % 2 == 0) {
            myArray = removeFirstElement(myArray);
            count += countEvens(myArray) + 1;
        }
        //returns final count
        return count;
    }
    //this is the method i used to remove the first element of the array for my algorithm to work
    public static int[] removeFirstElement(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0]; //returns an empty array if input is null or empty
        }

        //creates a new array that is one element shorter
        int[] newArray = new int[array.length - 1];

        //copies the elements from the original array, starting from index 1
        System.arraycopy(array, 1, newArray, 0, newArray.length);

        return newArray;
    }
    //this prints the array
    public static void printArray(int[] array) {
        //checks to see if the array is empty
        if (array == null || array.length == 0) {
            return;
        }
        //prints out the array
        for (int i = 0; i < array.length; i++) {
            //these selection statements makes sure that a comma isn't used on the last value
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            }
            else {
                System.out.print(array[i]);
            }
        }
    }
}