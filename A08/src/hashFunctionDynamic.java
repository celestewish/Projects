import java.util.LinkedList;
import java.util.Scanner;

// Name: Lauren Rousell
// Class: CS 3305/H01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 8
// IDE Name: IntelliJ
public class hashFunctionDynamic {
    public static void main(String[] args) {
        //variables
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};
        Scanner sc = new Scanner(System.in);
        String myString = "";
        //loop that controls interface
        while (true){
            System.out.println("-----MAIN MENU--------------------\n" +
                    "1. Run HF4 (Student Designed HF)\n" +
                    "2. Display outputs\n" +
                    "3. Exit program\n" +
                    "Enter option number:");
            //takes user input
            switch (sc.nextInt()){
                //hashing function
                case 1:
                    myString = HF4(keys);
                    break;
                    //prints results
                    case 2:
                        System.out.println(myString);
                        break;
                        //ends program
                        case 3:
                            System.exit(0);
                            break;
            }
        }
    }
    //uses chaining to store extra inputs
    public static String HF4(int[] intArray) {
        //variables
        int[][] table = new int[10][2];
        LinkedList<Integer>[] extraValues = new LinkedList[10];
        String value = "";
        //creates a bucket for overflow using linked lists
        for (int i = 0; i < 10; i++){
            extraValues[i] = new LinkedList<>();
        }
        for (int i = 0; i < 50; i++) {
            //truncation hashing
            int hashIndex = hash(intArray[i]);
            //checks for collisions
            //if collision, then stores in overflow
            if (table[hashIndex][0] != 0){
                extraValues[hashIndex].add(intArray[i]);
                table[hashIndex][1] = extraValues[hashIndex].getLast();
            }
            //if no collision, then stores normally
            else {
                table[hashIndex][0] = intArray[i];
            }
        }
        //final results printed here
        value += ("Static\tPart\tDynamic (Linked-List) Part\n");
        value += ("Index\tKey\n");
        value += ("-------------------------------------------------------------------------\n");
        for (int i = 0; i < 10; i++) {
            value += (i + "\t\t" + table[i][0] + "\t");
            for (int y = 0; y < extraValues[i].size()-1; y++) {
                value += (extraValues[i].get(y) + ", ");
                if (y == extraValues[i].size()-2) {
                    value += (extraValues[i].get(y));
                }
            }
            value += "\n";
        }
        value += ("-------------------------------------------------------------------------\n");
        return value;
    }
    public static int hash(int key) {
        //transferring the key from int to string
        String keyString = Integer.toString(key);

        //extracting last two digits
        String truncatedString = keyString.substring(Math.max(0, keyString.length() - 2));

        //convert back to integer
        int truncatedValue = Integer.parseInt(truncatedString);

        //bring back to table size, unlike my last program, the table size here is 10
        return truncatedValue % 10;
    }
}
