import java.util.Scanner;
// Name: Lauren Rousell
// Class: CS 3305/H01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 7
// IDE Name: IntelliJ

//this code allows you to do some simple functions with a priority queue that uses a heap tree
public class TestPQH {
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        PQ_heap myHeap;
        //this section forces the user to initialize the queue
        System.out.println("Enter Queue Type (integer or string)");
        String type = sc.nextLine();
        if (type.equalsIgnoreCase("integer")){
            myHeap = new PQ_heap<Integer>();
        }
        //if they dont put integer, they will always get a string tree
        //this is just to avoid errors if the user wants to be silly with their response
        else{
            myHeap = new PQ_heap<String>();
        }
        //while loop that controls interface
        while (true){
            System.out.println("----------------MAIN MENU---------------\n" +
                    "0. Enter Queue Type (integer or string)\n" +
                    "1. Enqueue Element\n" +
                    "2. Dequeue Element\n" +
                    "3. Check is_Full\n" +
                    "4. Check is_Empty\n" +
                    "5. Print PQueue Size\n" +
                    "6. Display Front Element\n" +
                    "7. Print PQueue Elements\n" +
                    "8. Exit program\n\n" +
                    "Enter option number:");
            //switch that allows user to make choices
            switch (sc.nextInt()){
                //reinitialize queue
                case 0:
                    sc.nextLine();
                    System.out.println("Enter Queue Type (integer or string)");
                    type = sc.nextLine();
                    if (type.equalsIgnoreCase("integer")){
                        myHeap = new PQ_heap<Integer>();
                    }
                    else{
                        myHeap = new PQ_heap<String>();
                    }
                    break;
                //enqueue data
                case 1:
                    sc.nextLine();
                    if (type.equalsIgnoreCase("integer")){
                        System.out.println("Enter integer to enqueue: ");
                        int enqueue = sc.nextInt();
                        myHeap.enqueue(enqueue);
                    }
                    else{
                        System.out.println("Enter String to enqueue: ");
                        String enqueue = sc.nextLine();
                        myHeap.enqueue(enqueue);
                    }
                    break;
                //dequeue data
                case 2:
                    sc.nextLine();
                    System.out.println("The element "+myHeap.front()+" has been dequeued.");
                    myHeap.dequeue();
                    break;
                //checks if full
                case 3:
                    System.out.println("Is PQueue full: "+myHeap.is_full());
                    break;
                //checks if empty
                case 4:
                    System.out.println("Is PQueue empty: " + myHeap.is_empty());
                    break;
                //prints size
                case 5:
                    System.out.println("PQueue size is "+myHeap.size());
                    break;
                //prints front element
                case 6:
                    System.out.println("Front element is "+ myHeap.front());
                    break;
                //prints queue
                case 7:
                    myHeap.printPriorityHeap();
                    break;
                //ends program
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
