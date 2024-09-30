import java.util.Scanner;
//this program allows the user to do basic operations with a stack
public class TestMyStack {
    public static void main(String[] args) {
        //variables
        MyStack myStack = new MyStack();
        Scanner input = new Scanner(System.in);
        int selection = 0;
        //loop that controls interface
        while (true) {
            System.out.println("--------MAIN MENU-------\n" +
                    "1 – Push element\n" +
                    "2 – Pop element\n" +
                    "3 – Get top element\n" +
                    "4 – Get stack size\n" +
                    "5 – Is empty stack?\n" +
                    "6 - Print stack\n" +
                    "7 - Exit program\n\n" +
                    "Enter option number:");
            //switch that allows user to make choices
            switch (input.nextInt()) {
                //push element onto stack
                case 1:
                    System.out.println("Enter integer: ");
                    selection = input.nextInt();
                    System.out.println("Stack before adding " + selection);
                    myStack.print();
                    myStack.push(selection);
                    System.out.println("Stack after adding  " + selection);
                    myStack.print();
                    break;
                    //pop element from the stack
                    case 2:
                        System.out.println("Stack before popping");
                        myStack.print();
                        myStack.pop();
                        System.out.println("Stack after popping");
                        myStack.print();
                        break;
                        //returns the top value
                        case 3:
                            System.out.println("Stack before getting the top");
                            myStack.print();
                            System.out.println("The top value is " + myStack.top());
                            System.out.println("Stack after getting the top");
                            myStack.print();
                            break;
                            //returns the size
                            case 4:
                                System.out.println("The size of the stack is "+myStack.size());
                                break;
                                case 5:
                                    if (myStack.isEmpty()) {
                                        System.out.println("Stack is empty");
                                    }
                                    else {
                                        System.out.println("Stack isn't empty");
                                    }
                                    break;
                                    //prints the stack
                                    case 6:
                                        myStack.print();
                                        break;
                                        //ends the program
                                        case 7:
                                            System.exit(0);
            }
        }
    }
}
