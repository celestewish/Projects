//Name: Lauren Rousell
//Class: CS 3305/H01
//Term: Fall 2024
//Instructor: Dr. Haddad
//Assignment: 4
//IDE Name: IntelliJ
import java.util.Scanner;
//this program checks to see if a string is a palindrome
//unlike last time, it is based off of each character, not the full words
public class CheckPalindrome {
    //main method
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        String inputString = "";
        //loop that controls interface
        while (true){
            System.out.println("-----------------MAIN MENU----------------\n" +
                    "1 – Read input string\n" +
                    "2 – Check palindrome and display output\n" +
                    "3 - Exit program\n\n" +
                    "Enter option number:");
            //switch that allows user to make decisions
            switch (sc.nextInt()){
                //enter a string of choice
                case 1:
                    sc.nextLine();
                    System.out.println("Enter string:");
                    inputString = sc.nextLine();
                    break;
                    //checks to see if palindrome
                    case 2:
                        System.out.println("Entered String:   " + inputString);
                        System.out.println("Judgement:        " + CheckPalindrome(inputString));
                        break;
                        //ends program
                        case 3:
                            System.exit(0);
                            break;
            }
        }
    }
    //this program checks to see if the input string is a palindrome
    public static String CheckPalindrome(String str) {
        //variables
        MyStack<Character> stack = new MyStack<Character>();
        StringBuilder palindrome = new StringBuilder();
        //adds the string's characters to a stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        //unloads the stack into a stringbuilder
        while (!stack.isEmpty()) {
            palindrome.append((Character) stack.top());
        }
        //converts string builder to string
        String myPalindromeString = palindrome.toString();
        //checks to see if the string is a palindrome, if so, it returns the word palindrome
        if (myPalindromeString.equalsIgnoreCase(str)) {
            return "Palindrome";
        }
        //if not, it returns not palindrome
        else{
            return "Not Palindrome";
        }
    }
}
