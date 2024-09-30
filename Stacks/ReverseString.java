import java.util.Scanner;
//this program reverses a string inputted by the user
public class ReverseString {
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        String myString = "";
        //loop that controls interface
        while (true){
            System.out.println("-----------------MAIN MENU---------------\n" +
                    "1 – Read input string of words\n" +
                    "2 – Reverse string and display outputs\n" +
                    "3 - Exit program\n\n" +
                    "Enter option number:");
            //switch that gives user options
            switch (sc.nextInt()){
                //allows user to enter the string
                case 1:
                    sc.nextLine();
                    System.out.print("Enter string: ");
                    myString = sc.nextLine();
                    break;
                    //reverses the string
                    case 2:
                        sc.nextLine();
                        String reversedString = reverseString(myString);
                        System.out.println("Entered string:  " + myString);
                        System.out.println("Reversed string: " + reversedString);
                        break;
                        //ends the program
                        case 3:
                            System.exit(0);
                            break;
            }
        }
    }
    //this method reverses the string
    public static String reverseString(String str) {
        //variables
        MyStack<String> myStack = new MyStack<String>();
        StringBuilder reversed = new StringBuilder();
        //this variable transfers the string to a string array
        String[] myStringArray  = str.split(" ");
        //pushes each word into a stack
        for (int i = 0; i < myStringArray.length; i++) {
            myStack.push(myStringArray[i]);
        }
        //adds the words from the stack into a new variable
        while (!myStack.isEmpty()) {
            reversed.append((String) myStack.top());
            reversed.append(" ");
        }
        //returns the variable as a string
        return reversed.toString();
    }
}
