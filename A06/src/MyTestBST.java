// Name: Lauren Rousell
// Class: CS 3305/H01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: IntelliJ
import java.util.Scanner;
public class MyTestBST {
    //this program tests the BST class
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Tree Data Type (integer or string):");
        //the next few lines initializes a tree to be a String tree or an Integer tree
        BST tree = null;
        if (sc.nextLine().equalsIgnoreCase("integer")){
            tree = new BST<Integer>();
        }
        //i made this an else so that if the user enters something strange, a tree can be safely created
        else {
            tree = new BST<String>();
        }
        //while loop that controls interface
        while (true){
            System.out.println("\n----------------MAIN MENU---------------\n" +
                    "0.  Enter Tree Data Type (integer or string)\n" +
                    "1.  Insert Data Element\n" +
                    "2.  Delete Data Element\n" +
                    "3.  Search for Data Element\n" +
                    "4.  Print Tree Size\n" +
                    "5.  Path from Root to Data Element\n" +
                    "6.  Check if Empty Tree\n" +
                    "7.  Print Preorder Traversal\n" +
                    "8.  Print Inorder Traversal\n" +
                    "9.  Print Postorder Traversal\n" +
                    "10. Exit program\n\n" +
                    "Enter option number:");
            //switch that allows user to make choices
            switch (sc.nextInt()){
                //note that every option checks to see if the information is in string or integer type
                //allows user to reinstantiate a tree of a different type or event the same type, just empty the existing tree
                case 0:
                    sc.nextLine();
                    System.out.println("Enter Tree Data Type (integer or string):");
                    if (sc.nextLine().equalsIgnoreCase("integer")){
                        tree = new BST<Integer>();
                    }
                    else {
                        tree = new BST<String>();
                    }
                    break;
                    //inserts data
                    case 1:
                        sc.nextLine();
                        System.out.println("Testing method Insert Data Element (Option 1)");
                        try {
                            if (sc.hasNextInt()) {
                                int temp = sc.nextInt();
                                System.out.print("BST before inserting " + temp + " (Inorder):  ");
                                tree.inorder();
                                tree.insert(temp);
                                System.out.print("\nBST after inserting  " + temp + "  (Inorder): ");
                                tree.inorder();
                            } else if (sc.hasNextLine()) {
                                String temp = sc.nextLine();
                                System.out.print("BST before inserting " + temp + " (Inorder):  ");
                                tree.inorder();
                                tree.insert(temp);
                                System.out.print("\nBST after inserting " + temp + " (Inorder): ");
                                tree.inorder();
                            }
                        } catch (ClassCastException e) {
                            throw new ClassCastException("Wrong type");
                        }
                        break;
                        //deletes data
                        case 2:
                            sc.nextLine();
                            System.out.println("Testing method Delete Data Element (Option 2)");
                            if (sc.hasNextInt()){
                                int temp = sc.nextInt();
                                System.out.print("BST before deleting " + temp + " (Inorder):  ");
                                tree.inorder();
                                tree.delete(temp);
                                System.out.print("\nBST after deleting " + temp + " (Inorder): ");
                                tree.inorder();
                            }
                            else if (sc.hasNextLine()){
                                String temp = sc.nextLine();
                                System.out.print("BST before deleting " + temp + " (Inorder):  ");
                                tree.inorder();
                                tree.delete(temp);
                                System.out.print("\nBST after deleting " + temp + " (Inorder): ");
                                tree.inorder();
                            }
                            break;
                            //searches for a value
                            case 3:
                                sc.nextLine();
                                System.out.println("Testing method Search for Data Element (Option 3)");
                                if (sc.hasNextInt()){
                                    int temp = sc.nextInt();
                                    System.out.println("Search for " + temp + "? " + tree.search(temp));
                                }
                                else if (sc.hasNextLine()){
                                    String temp = sc.nextLine();
                                    System.out.println("Search for " + temp + "? " + tree.search(temp));
                                }
                                break;
                                //returns tree size
                                case 4:
                                    sc.nextLine();
                                    System.out.println("Testing method Print Tree Size (Option 4)");
                                    System.out.println("Tree size: " + tree.getSize());
                                    break;
                                    //path to root method
                                    case 5:
                                        sc.nextLine();
                                        System.out.println("Testing method Path from Root to Data Element (Option 5)");
                                        if (sc.hasNextInt()){
                                            int temp = sc.nextInt();
                                            System.out.print("Path from root to " + temp + ": ");
                                            java.util.ArrayList<BST.TreeNode<Integer>> path = tree.path(temp);
                                            for (int i = 0; path != null && i < path.size(); i++)
                                                System.out.print(path.get(i).element + " ");
                                        }
                                        else if (sc.hasNextLine()){
                                            String temp = sc.nextLine();
                                            System.out.print("Path from root to " + temp + ": ");
                                            java.util.ArrayList<BST.TreeNode<String>> path = tree.path(temp);
                                            for (int i = 0; path != null && i < path.size(); i++)
                                                System.out.print(path.get(i).element + " ");
                                        }
                                        break;
                                        //checks to see if tree is empty
                                        case 6:
                                            sc.nextLine();
                                            System.out.println("Testing method Check if Empty Tree (Option 6)");
                                            System.out.println("Is empty tree? " + tree.isEmpty());
                                            break;
                                            //testing preorder traversal
                                            case 7:
                                                sc.nextLine();
                                                System.out.println("Testing method Preorder Traversal (Option 7)");
                                                System.out.print("Preorder: ");
                                                tree.preorder();
                                                break;
                                                //testing inorder traversal
                                                case 8:
                                                    sc.nextLine();
                                                    System.out.println("Testing method Inorder Traversal (Option 8)");
                                                    System.out.print("Inorder: ");
                                                    tree.inorder();
                                                    break;
                                                    //testing postorder traversal
                                                    case 9:
                                                        sc.nextLine();
                                                        System.out.println("Testing method Postorder Traversal (Option 9)");
                                                        System.out.print("Postorder: ");
                                                        tree.postorder();
                                                        break;
                                                        //ends program
                                                        case 10:
                                                            System.exit(0);
                                                            break;
            }
        }
    }
}