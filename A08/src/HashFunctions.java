import java.util.Scanner;
// Name: Lauren Rousell
// Class: CS 3305/H01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 8
// IDE Name: IntelliJ
public class HashFunctions {
    public static void main(String[] args) {
        //variables
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};
        Scanner scan = new Scanner(System.in);
        //loop that controls interface
        while(true){
            System.out.println("-----MAIN MENU--------------------------------------\n" +
                    "1. Run HF1 (Division method with Linear Probing)\n" +
                    "2. Run HF2 (Division method with Quadratic Probing)\n" +
                    "3. Run HF3 (Division method with Double Hashing)\n" +
                    "4. Run HF4 (Student Designed HF)\n" +
                    "5. Exit program\n" +
                    "Enter option number:");
            //switch that takes user input
            switch(scan.nextInt()){
                //linear probing
                case 1:
                    HF1(keys);
                    break;
                    //quadratic probing
                    case 2:
                        HF2(keys);
                        break;
                        //double hashing
                        case 3:
                            HF3(keys);
                            break;
                            //my own method
                            case 4:
                                HF4(keys);
                                break;
                                //exit
                                case 5:
                                    System.exit(0);
                                    break;
            }
        }
    }
    //hash function with linear probing
    public static void HF1(int[] intArray) {
        //variables
        int[][] table = new int[50][2];
        int probeValues = 0;
        //loop that hashes
        for (int i = 0; i < 50; i++) {
            int probes = 0;
            int hashIndex = intArray[i] % 50;
            //handles collisions
            while (table[hashIndex][0] != 0){
                hashIndex = (hashIndex + 1) % 50;
                probes++;
            }
            //stores values
            table[hashIndex][0] = intArray[i];
            table[hashIndex][1] = probes;
        }
        //prints results
        System.out.println("Hash table resulted from HF1:");
        System.out.println("Index\tKey\t\tprobes");
        System.out.println("------------------------");
        for (int i = 0; i < 50; i++) {
            System.out.println(i + "\t\t" + table[i][0] + "\t" + table[i][1]);
        }
        System.out.println("------------------------");
        for(int i = 0; i < 50; i++){
            probeValues += table[i][1];
        }
        System.out.println("\nSum of probe values = " + probeValues);
    }
    //hash function with quadratic probing
    public static void HF2(int[] intArray) {
        //variables
        int[][] table = new int[50][2];
        int probeValues = 0;
        //hashing loop
        for (int i = 0; i < 50; i++) {
            int counter = 0;
            int hashIndex = intArray[i] % 50;
            //collision handling
            while (table[hashIndex][0] != 0){
                counter++;
                hashIndex = (intArray[i] + (counter * counter)) % 50;
            }
            //stores values
            table[hashIndex][0] = intArray[i];
            table[hashIndex][1] = counter;
        }
        //displays output
        System.out.println("Hash table resulted from HF2:");
        System.out.println("Index\tKey\t\tprobes");
        System.out.println("------------------------");
        for (int i = 0; i < 50; i++) {
            System.out.println(i + "\t\t" + table[i][0] + "\t" + table[i][1]);
        }
        System.out.println("------------------------");
        for(int i = 0; i < 50; i++){
            probeValues += table[i][1];
        }
        System.out.println("\nSum of probe values = " + probeValues);
    }
    //hash function with double hashing
    public static void HF3(int[] intArray) {
        //variables
        int[][] table = new int[50][2];
        int cannotHash = 0;
        int probeValues = 0;
        //hashing loop
        for (int i = 0; i < 50; i++) {
            boolean canHash = true;
            int counter = 0;
            int hashIndex = intArray[i] % 50;
            int hashIndex2 = 30 - (intArray[i] % 25);
            //handles collisions
            while (table[hashIndex][0] != 0) {
                //handles unhashable keys
                if (counter >= 50){
                    System.out.println("Unable to hash key " + intArray[i] + " to the table");
                    canHash = false;
                    break;
                }
                else {
                    counter++;
                    hashIndex = (hashIndex + hashIndex2) % 50;
                }
            }
            //stores input
            if (canHash) {
                table[hashIndex][0] = intArray[i];
                table[hashIndex][1] = counter;
            }
            //if cant, tracks that value
            else{
                cannotHash++;
            }
        }
        //displays output
        System.out.println("Hash table resulted from HF3:");
        System.out.println("Index\tKey\t\tprobes");
        System.out.println("------------------------");
        for (int i = 0; i < 50; i++) {
            System.out.println(i + "\t\t" + table[i][0] + "\t" + table[i][1]);
        }
        System.out.println("------------------------");
        for(int i = 0; i < 50; i++){
            probeValues += table[i][1];
        }
        System.out.println("\nSum of probe values = " + probeValues);
        System.out.println("\n" + cannotHash + " key(s) unable to store in the table.");
    }
    //my own unique hashing method that uses truncation
    public static void HF4(int[] intArray) {
        int[][] table = new int[50][2];
        int cannotHash = 0;
        int probeValues = 0;
        for (int i = 0; i < 50; i++) {
            boolean canHash = true;
            int counter = 0;
            //i used the truncation method here
            int hashIndex = hash(intArray[i]);
            //here i use double hashing. there wasnt logic behind the choice
            // i just kept trying random equations until i found something that works
            int hashIndex2 = (hashIndex * hashIndex) % 50;
            //checks for collisions
            while(table[hashIndex][0] != 0){
                if (counter >= 50){
                    System.out.println("Unable to hash key " + intArray[i] + " to the table");
                    canHash = false;
                    break;
                }
                else {
                    counter++;
                    //similar situation here, i just kept trying stuff until it worked
                    //i dont fully understand why
                    hashIndex = hash(intArray[i] * hashIndex2 * counter^8) % 50;
                }
            }
            //if i can hash a key, i add it to the table
            if (canHash) {
                table[hashIndex][0] = intArray[i];
                table[hashIndex][1] = counter;
            }
            //if i cant, i keep track of what cannot be hashed
            else{
                cannotHash++;
            }
        }
        //final results printed here
        System.out.println("Hash table resulted from HF4:");
        System.out.println("Index\tKey\t\tprobes");
        System.out.println("------------------------");
        for (int i = 0; i < 50; i++) {
            System.out.println(i + "\t\t" + table[i][0] + "\t" + table[i][1]);
        }
        System.out.println("------------------------");
        for(int i = 0; i < 50; i++){
            probeValues += table[i][1];
        }
        System.out.println("\nSum of probe values = " + probeValues);
        System.out.println("\n" + cannotHash + " key(s) unable to store in the table.");
    }
    public static int hash(int key) {
        //transferring the key from int to string
        String keyString = Integer.toString(key);

        //extracting last two digits
        String truncatedString = keyString.substring(Math.max(0, keyString.length() - 2));

        //convert back to integer
        int truncatedValue = Integer.parseInt(truncatedString);

        //bring back to table size
        return truncatedValue % 50;
    }
}
