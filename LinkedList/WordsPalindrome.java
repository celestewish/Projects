
import java.util.Scanner;
public class WordsPalindrome {
    //this program checks to see if a string is a palindrome using a LinkedList
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        String sentence = "";
        //this loop controls the interface
        while (true) {
            System.out.println("--------MAIN MENU-------\n" +
                    "1 – Enter a sentence\n" +
                    "2 – Check if palindrome\n" +
                    "3 - Exit program\n\n" +
                    "Enter option number:");
            switch (sc.nextInt()) {
                //this takes a sentence in as input
                case 1:
                    sc.nextLine();
                    System.out.println("Enter a sentence:");
                    sentence = sc.nextLine();
                    break;
                    //this calls the palindrome method
                    case 2:
                        makePalindrome(sentence);
                        break;
                        //ends the program
                        case 3:
                            System.exit(0);
                            break;
            }
        }
    }
    //this method checks to see if a sentence is a palindrome
    public static void makePalindrome(String word) {
        //variables
        LinkedList_No_HT_Generic list = new LinkedList_No_HT_Generic();
        LinkedList_No_HT_Generic list2 = new LinkedList_No_HT_Generic();
        //splits the sentence into an array
        String[] words = word.split(" ");
        //loads the sentence in backwards
        for (String word1 : words) {
            list.addFirstNode(word1);
        }
        //loads the sentence in forwards
        for (String word2 : words) {
            list2.addLastNode(word2);
        }
        //returns the LinkedList as a string
        String testString = list.returntoString();
        String testString2 = list2.returntoString();
        //checks to see if the strings match
        int isPalindrome = testString2.compareTo(testString);
        System.out.println("Input Sentence:   "+word);
        //if compareTo returns 0, this means that they match and are a palindrome
        if (isPalindrome == 0) {
            System.out.println("Judgment:         Palindrome");
        }
        //if compareTo doesnt return 0, it is not a palindrome
        else{
            System.out.println("Judgment:         Not Palindrome");
        }

    }
}
