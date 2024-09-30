import java.util.Scanner;
//Name: Lauren Rousell
//Class: CS 3305/H01
//Term: Fall 2024
//Instructor: Dr. Haddad
//Assignment: 5
//IDE Name: IntelliJ
//this program allows the user to create their own array and then sort it
public class RadixSort {
    //main method
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        int ArraySize = 0;
        int[] array = new int[0];
        //loop that controls interface
        while (true){
            System.out.println("\n---------------MAIN MENU---------------\n" +
                    "1 – Read array size\n" +
                    "2 – Read array values\n" +
                    "3 – Run Radix Sort and print outputs\n" +
                    "4 – Exit program\n\n" +
                    "Enter option number:");
            //switch that allows user to make choices
            switch (sc.nextInt()){
                //pick array size
                case 1:
                    sc.nextLine();
                    System.out.println("Enter array size: ");
                    ArraySize = sc.nextInt();
                    array = new int[ArraySize];
                    break;
                    //fill array
                    case 2:
                        sc.nextLine();
                        for (int i = 0; i < ArraySize; i++){
                            System.out.println("Enter value for spot " + i +  ": ");
                            array[i] = sc.nextInt();
                        }
                        break;
                        //sort the array
                        case 3:
                            System.out.println("Array values before sorting: " + arraytoString(array));
                            array = RadixSort(array);
                            System.out.print("Array values after sorting:  " + arraytoString(array));
                            System.out.println();
                            break;
                            //end program
                            case 4:
                                System.exit(0);
                                break;
            }
        }
    }
    //this method sorts the array
    public static int[] RadixSort(int[] array){
        //uses helper methods to set the variables
        int max = Max(array);
        int maxDigits = CountDigits(max);

        //for loop that controls the sorting algorithm
        for (int digitPlace = 1; digitPlace <= maxDigits; digitPlace++) {
            //an array of 10 queues is created to store the digits for sorting
            Queue<Integer>[] myQueue = new Queue[10];
            //each queue is initialized
            for (int i = 0; i < 10; i++) {
                myQueue[i] = new Queue<>();
            }
            //each digit is loaded onto a queue based on their value
            for (int num : array) {
                int digit = ExtractDigits(num, digitPlace);
                myQueue[digit].enqueue(num);
            }
            //index counter for the next loop
            int index = 0;
            //collect digits and place them back into the array
            for (Queue<Integer> queue : myQueue){
                while (!queue.isEmpty()){
                    array[index++] = queue.front();
                    queue.dequeue();
                }
            }
        }
        return array;
    }
    //pulls the max value from the array and returns it
    public static int Max(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
    //counts the digits in a value
    //used to count digits in the max value from the array
    public static int CountDigits(int num){
        return (int) Math.log10(num) + 1;
    }
    //extracts the digits from a value
    public static int ExtractDigits(int num, int place){
        return (num / (int) Math.pow(10, place - 1)) % 10;
    }
    //converts the array data to a string
    public static String arraytoString(int[] array){
        String myString = "";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1){
                myString += array[i] + "";
                break;
            }
            myString += array[i] + ", ";
        }
        return myString;
    }
}
