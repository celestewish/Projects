import java.util.Scanner;
public class Vowels {
    /* This code allows you to calculate the number of vowels in a string
    using recursion.
     */
    public static void main(String[] args) {
        //initiation of variables
        Scanner sc = new Scanner(System.in);
        String s = "";
        //this loop controls the interface
        while (true){
            System.out.println("\n---------MAIN MENU---------\n" +
                    "1. Read input string\n" +
                    "2. Compute number of vowels\n" +
                    "3. Exit program\n\n" +
                    "Enter option number: ");
            //this switch case allows the user to switch between options
            switch (sc.nextInt()){
                //allows the user to enter a string
                case 1:
                    sc.nextLine();
                    System.out.println("Enter string: ");
                    s = sc.nextLine();
                    break;
                    //allows the user to calculate the number of vowels and prints the result
                case 2:
                    int vowelNum = countVowels(s);
                    System.out.println("You entered string: " + s +
                    "\nNumber of vowels:   " + vowelNum);
                    break;
                    //ends the program
                case 3:
                    System.exit(0);
            }
        }
    }
    //this method counts the number of vowels in a string using recursion
    public static int countVowels(String s) {
        //initializing variables
        int count = 0;
        //checks to see if string is empty, this is the base case
        if (s.isEmpty()){
            return count;
        }
        //if not empty the else statement starts the recursion process
        else {
            /*checks for any vowels, if there are any, then the count variable is increased
            and the method calls itself. the argument passed to the method chops off the first
            character of the string which allows us to get closer to the base case
             */
            if (s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' ||
                    s.charAt(0) == 'o' || s.charAt(0) == 'u' || s.charAt(0) == 'A'
            || s.charAt(0) == 'E' || s.charAt(0) == 'I' || s.charAt(0) == 'O' || s.charAt(0) == 'U') {
                count+= countVowels(s.substring(1)) + 1;
            }
            //if there are no vowels, the string is shortened and the method calls itself
            else {
                return countVowels(s.substring(1));
            }
        }
        //returns the final count value
        return count;
    }
}
