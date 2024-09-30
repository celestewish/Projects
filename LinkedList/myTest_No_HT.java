
import java.util.Scanner;

public class myTest_No_HT
{
   public static void main (String[] args)
           //this allows the user to edit and work with a LinkedList
   {
      //variables
      LinkedList_No_HT myList = new LinkedList_No_HT(); //create a list object
      Scanner sc = new Scanner(System.in);
      int userInput;
      int switchInput;
      while(true){
         //the interface
         System.out.println("\n---------MAIN MENU--------\n" +
                 "1 – Add First Node\n" +
                 "2 – Add Last Node\n" +
                 "3 – Add At Index\n" +
                 "4 – Remove First Node\n" +
                 "5 – Remove Last Node\n" +
                 "6 – Remove At Index\n" +
                 "7 – Print List Size\n" +
                 "8 – Print List Forward\n" +
                 "9 – Print List In Reverse\n" +
                 "10- Exit program\n\n" +
                 "Enter option number:");
         userInput = sc.nextInt();
         sc.nextLine();
         //allows the user to pick their desired option
         switch(userInput){
            //enter first node
            case 1:
               System.out.println("Enter First Node: ");
               switchInput = sc.nextInt();
               sc.nextLine();
               System.out.println("Adding value "+ switchInput + " as first node");
               System.out.print("List content before adding 25 is:  ");
               myList.printList();
               System.out.print("\nList content after adding 25 is:   ");
               myList.addFirstNode(switchInput);
               myList.printList();
               break;
               //enter last node
            case 2:
               System.out.println("Enter Last Node: ");
               switchInput = sc.nextInt();
               sc.nextLine();
               System.out.println("Adding value "+ switchInput + " as last node");
               System.out.print("List content before adding 25 is:  ");
               myList.printList();
               System.out.print("\nList content after adding 25 is:   ");
               myList.addLastNode(switchInput);
               myList.printList();
               break;
               //enter node at specific index
            case 3:
               System.out.println("Enter value to add");
               int value = sc.nextInt();
               sc.nextLine();
               System.out.println("Enter Index: ");
               switchInput = sc.nextInt();
               sc.nextLine();
               System.out.println("Adding value "+ switchInput + " as index");
               System.out.print("List content before adding 25 is:  ");
               myList.printList();
               System.out.print("\nList content after adding 25 is:   ");
               myList.addAtIndex(switchInput, value);
               myList.printList();
               break;
               //remove first node
            case 4:
               System.out.println("Method removeFirstNode()");
               System.out.print("List content before removing first node is: ");
               myList.printList();
               System.out.print("\nList content after removing first node is:  ");
               myList.removeFirstNode();
               myList.printList();
               break;
               //remove last node
            case 5:
               System.out.println("Method removeLastNode()");
               System.out.print("List content before removing last node is: ");
               myList.printList();
               System.out.print("\nList content after removing last node is:  ");
               myList.removeLastNode();
               myList.printList();
               break;
               //remove at specific index
            case 6:
               System.out.println("Enter index to remove at: ");
               switchInput = sc.nextInt();
               sc.nextLine();
               System.out.print("List before removing at index is:  ");
               myList.printList();
               System.out.print("\nList after removing at index is:   ");
               myList.removeAtIndex(switchInput);
               myList.printList();
               break;
               //prints list length
            case 7:
               myList.printList();
               System.out.println("\nThe list size is "+ myList.countNodes()+ " node(s) long");
               break;
               //prints list
            case 8:
               System.out.println("Print List Forward");
               myList.printList();
               break;
               //prints list in reverse
            case 9:
               myList.printList();
               System.out.println("\nPrint List Reverse");
               myList.printInReverseRecursive(myList.ListName);
               break;
               //ends program
            case 10:
               System.exit(0);
         }
      }
   } 
}
    
