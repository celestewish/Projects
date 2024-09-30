//Name: Lauren Rousell
//Class: CS 3305/H01
//Term: Fall 2024
//Instructor: Dr. Haddad
//Assignment: 5
//IDE Name: IntelliJ
import java.util.Scanner;
//this program tests if a string is a palindrome in two different ways
public class TestPalindrome {
    //main method
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        String input = "";
        //while loop that controls interface
        while (true){
            System.out.println("-----------------MAIN MENU---------------\n" +
                    "1. Test character-by-character palindrome\n" +
                    "2. Test word-by-word palindrome\n" +
                    "3. Exit program\n\n" +
                    "Enter option number: ");
            //switch the allows user to make choices
            switch(sc.nextInt()){
                //checks to see if a string is a palindrome based on character-by-character
                case 1:
                    sc.nextLine();
                    System.out.println("Input a character-by-character palindrome: ");
                    input = sc.nextLine();
                    System.out.println("You selected:   Option 1" +
                            "\nYou entered:    " + input +
                            "\nJudgment:       " + isCharPalindrome(input));
                    break;
                    //checks to see if a string is a palindrome based on word-by-word
                    case 2:
                        sc.nextLine();
                        System.out.println("Input a word-by-word palindrome: ");
                        input = sc.nextLine();
                        System.out.println("You selected:   Option 2" +
                                "\nYou entered:    " + input +
                                "\nJudgment:       " + isWordPalindrome(input));
                        break;
                        //ends program
                        case 3:
                            System.exit(0);
                            break;
            }
        }

    }
    //this method checks to see if a string is a palindrome based on characters
    public static String isCharPalindrome(String str) {
        //variable
        Queue<Character> q = new Queue<Character>();
        //inputs string characters in reverse to a queue
        for (int i = str.length() - 1; i >= 0; i--) {
            //note that all punctuation is ignored
            if (Character.isLetter(str.charAt(i))) {
                q.enqueue(str.charAt(i));
            }
        }
        //dequeues those characters into a string builder
        StringBuilder myStr = new StringBuilder();
        while (!q.isEmpty()) {
            myStr.append(q.front());
            q.dequeue();
        }
        //the original string is transferred to a string builder so that we can ignore spaces
        StringBuilder myStr2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                myStr2.append(str.charAt(i));
            }
        }
        //compares the results
        if (myStr.toString().equalsIgnoreCase(myStr2.toString())) {
            return "Palindrome";
        }
        else{
            return "Not Palindrome";
        }
    }
    //this method checks to see if a string is a palindrome based on words
    public static String isWordPalindrome(String str) {
        //variable
        Queue<String> q = new Queue<String>();
        String[] words = str.split(" ");
        //the words are loaded into a queue in reverse
        for (int i = words.length - 1; i >= 0; i--) {
            q.enqueue(words[i]);
        }
        //dequeues the string values into a string builder
        StringBuilder myStr = new StringBuilder();
        while (!q.isEmpty()) {
            myStr.append(q.front());
            q.dequeue();
        }
        //the original sentence is loaded into a string builder so that spaces are ignored
        StringBuilder myStr2 = new StringBuilder();
        for (String word : words) {
            myStr2.append(word);
        }
        //compared to see if it is a palindrome
        //note that all punctuation is ignored
        if (myStr.toString().replaceAll("[^a-zA-Z]", "").equalsIgnoreCase(myStr2.toString().replaceAll("[^a-zA-Z]", ""))){
            return "Palindrome";
        }
        else{
            return "Not Palindrome";
        }
    }
}
