import java.util.Scanner;
//Name: Lauren Rousell
//Class: CS 3305/H01
//Term: Fall 2024
//Instructor: Dr. Haddad
//Assignment: 2
//IDE Name: IntelliJ
/*This code computes the average grades that a class has using recursion.
 */
public class AverageGrades {
    //the main method
    public static void main(String[] args) {
        //initializing variables
        Scanner sc = new Scanner(System.in);
        int size = 0;
        int grades = 0;
        int[] average = new int[0];
        //the loop that controls the interface
        while (true){
            System.out.println("\n\n--------MAIN MENU-------\n" +
                    "1. Read class size\n" +
                    "2. Read class grades\n" +
                    "3. Compute class average\n" +
                    "4. Exit program\n\n" +
                    "Enter option number: ");
            //the switch statement that allows the user to cycle through options
            switch(sc.nextInt()){
                //allows them to enter the size
                case 1:
                    System.out.println("Enter class size: ");
                    size = sc.nextInt();
                    average = new int[size];
                    break;
                    //allows them to enter the grades
                case 2:
                    for (int i = 0; i < size; i++) {
                        System.out.println("Enter grade number " + (i + 1) + ": ");
                        average[i] = sc.nextInt();
                    }
                    break;
                    //allows them to calculate the average of the grades entered
                case 3:
                    System.out.println("You entered class size: " + size +
                                       "\nYou entered grades:     " + printArray(average)+
                                       "\nClass average:          " + findAverage(average, size));
                    break;
                    //ends the program
                case 4:
                    System.exit(0);
            }
        }
    }
    //this simply prints the array
    public static String printArray(int[] array){
        String myString = "";
        for (int i = 0; i < array.length; i++) {
            myString = array[i] + " ";
        }
        return myString;
    }
    //this finds the average of the array
    public static double findAverage(int[] grades, int size){
        //the base case
        if (size == 0){
            return 0;
        }
        //this algorithm computes the average of the elements in the array
        else{
            return ((findAverage(grades, size - 1) * (size - 1)) + grades[size - 1]) / size;
        }
    }
}
