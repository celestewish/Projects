// Name: Lauren Rousell
// Class: CS 3305/H01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: IntelliJ

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RemoveDuplicates {
    //this program removes duplicates from a string and returns it inorder by using BSTs
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        String str = "";
        //while loop that controls interface
        while (true) {
            System.out.println("\n-----------------MAIN MENU---------------\n" +
                    "1. Read input string\n" +
                    "2. Remove duplicates and display outputs\n" +
                    "3. Exit program\n\n" +
                    "Enter option number:");
            //controls user choices
            switch (sc.nextInt()) {
                //allows user to input string
                case 1:
                    sc.nextLine();
                    System.out.println("Input string:");
                    str = sc.nextLine();
                    break;
                    //removes duplicates
                    case 2:
                        sc.nextLine();
                        RemoveDuplicates(str);
                        break;
                        //ends program
                        case 3:
                            System.exit(0);
                            break;
            }
        }
    }
    //this method prints out a string without the duplicate words
    public static void RemoveDuplicates(String str) {
        //variables
        String[] input = str.split(" ");
        ArrayList<String> list = new ArrayList<>();
        BST<String> tree = new BST<String>();
        //key thing to note here is I take the input string put it in an array and then put that array into an array list
        Collections.addAll(list, input);
        //removes duplicates
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i).equals(list.get(j))){
                    list.remove(i);
                }
            }
        }
        //inserts into a string
        for (String s : list) {
            tree.insert(s);
        }
        //prints the original text
        System.out.println("Original Text:\n"+str);
        //prints the processed version
        System.out.println("Processed Text:");
        tree.inorder();
    }
}
