//Name: Lauren Rousell
//Class: CS 3305/H01
//Term: Fall 2024
//Instructor: Dr. Haddad
//Assignment: 4
//IDE Name: IntelliJ
import java.util.Scanner;
//this program uses stacks to check if the parenthesis are balanced in a math equation
public class CheckBalance {
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        String input = "";
        //while loop that controls interface
        while(true) {
            System.out.println("---------------MAIN MENU--------------\n" +
                    "1 – Read input expression\n" +
                    "2 – Check if balanced\n" +
                    "3 - Exit program\n\n" +
                    "Enter option number:");
            //switch statement that allows user to make choices
            switch(sc.nextInt()) {
                //enter string
                case 1:
                    sc.nextLine();
                    System.out.println("Enter string: ");
                    input = sc.nextLine();
                    break;
                    //tests if string is balanced
                    case 2:
                        System.out.println("Entered expression:   " + input);
                        System.out.println("Judgment:             " + CheckBalance(input));
                        break;
                        //ends program
                        case 3:
                            System.exit(0);
                            break;
            }
        }
    }
    //this method checks to see if the string is balanced
    public static String CheckBalance(String str){
        //variables
        MyStack myStack = new MyStack();
        //this loop is used to read in parentheses, add them to the stack, and removes parenthesis if an end parenthesis is found
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //if a parenthesis is found it is added to the stack
            if (ch == '('){
                myStack.push(ch);
            }
            //if there are no open parenthesis, then the statement must be unbalanced and the value "unbalanced" is returned
            else if (ch == ')' && myStack.isEmpty()){
                return "Unbalanced";
            }
            //if a pair is found, the open parenthesis is removed. this means if every parenthesis has a pair, the stack will be empty
            else if (ch == ')' && !myStack.isEmpty()){
                myStack.pop();
            }
        }
        //if the stack is empty the equation is balanced
        if (myStack.isEmpty()){
            return "Balanced";
        }
        //if the stack isn't empty, the equation is unbalanced
        else{
            return "Unbalanced";
        }
    }
}
