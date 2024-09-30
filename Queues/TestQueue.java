//Name: Lauren Rousell
//Class: CS 3305/H01
//Term: Fall 2024
//Instructor: Dr. Haddad
//Assignment: 5
//IDE Name: IntelliJ
import java.util.Scanner;
//this method allows the user to do basic operations with queues
public class TestQueue {
    public static void main(String[] args) {
        //variables
        Queue<Integer> queue = new Queue<Integer>();
        Scanner sc = new Scanner(System.in);
        Integer selection = 0;
        //while loop that controls interface
        while (true) {
            System.out.println("--------MAIN MENU--------\n" +
                    "1 – Enqueue element\n" +
                    "2 – Dequeue element\n" +
                    "3 – Get front element\n" +
                    "4 – get queue size\n" +
                    "5 – Is Empty queue?\n" +
                    "6 - Print queue\n" +
                    "7 - Exit program\n\n" +
                    "Enter option number:");
            //switch that allows user to make choices
            switch (sc.nextInt()) {
                //enqueue integer
                case 1:
                    sc.nextLine();
                    System.out.println("Enter integer:");
                    selection = sc.nextInt();
                    System.out.print("Queue before adding value: ");
                    queue.printQueue();
                    queue.enqueue(selection);
                    System.out.print("Queue after adding value:  ");
                    queue.printQueue();
                    System.out.println();
                    break;
                    //dequeue integer
                    case 2:
                        System.out.println("Queue before removing value: ");
                        queue.printQueue();
                        queue.dequeue();
                        System.out.print("Queue after removing value:  ");
                        queue.printQueue();
                        System.out.println();
                        break;
                        //returns front value
                        case 3:
                            System.out.println("Front element is " + queue.front());
                            break;
                            //returns queue size
                            case 4:
                                System.out.println("Queue size is " + queue.size());
                                break;
                                //checks if queue is empty
                                case 5:
                                    System.out.println("Is Empty queue is " + queue.isEmpty());
                                    break;
                                    //prints queue
                                    case 6:
                                        queue.printQueue();
                                        System.out.println();
                                        break;
                                        //ends program
                                        case 7:
                                            System.exit(0);
                                            break;
            }
        }
    }
}
