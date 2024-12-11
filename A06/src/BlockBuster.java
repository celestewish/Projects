// Name: Lauren Rousell
// Class: CS 3305/H01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: IntelliJ

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//this class simulates a fake BlockBuster database that stores and manages their movie inventory
public class BlockBuster {
    public static void main(String[] args) {
        //variables
        BST<String> movies = new BST<>();
        Scanner sc = new Scanner(System.in);
        String title;
        int quantity;
        //while loop that controls interface
        while (true){
            System.out.println("-----------MAIN MENU---------\n" +
                    "1. Add new title\n" +
                    "2. Remove a title\n" +
                    "3. Update a title\n" +
                    "4. Search for a title\n" +
                    "5. Rental (check-out title)\n" +
                    "6. Return (check-in title)\n" +
                    "7. List inventory\n" +
                    "8. Exit program\n\n" +
                    "Enter option number:");
            //switch that allows user to make choices
            switch (sc.nextInt()){
                //allows a title to be added and a specific quantity of said quantity
                case 1:
                    sc.nextLine();
                    System.out.println("Enter movie title:");
                    title = sc.nextLine();
                    System.out.println("Enter movie quantity:");
                    quantity = sc.nextInt();
                    for (int i = 0; i < quantity; i++) {
                        movies.insert(title);
                    }
                    System.out.println("Added "+quantity+" titles of the movie "+title);
                    break;
                    //allows all of a particular title to be removed
                case 2:
                    sc.nextLine();
                    System.out.println("Enter movie title:");
                    title = sc.nextLine();
                    if(movies.search(title)){
                        quantity = movies.getCount(title);
                        for (int i = 0; i < quantity; i++){
                            movies.delete(title);
                        }
                        System.out.println("Removed the movie "+title);
                    }
                    else{
                        System.out.println("Title not found");
                    }
                        break;
                        //allows the user to update the quantity of the title
                case 3:
                    sc.nextLine();
                    System.out.println("Enter movie title to update quantity of:");
                    title = sc.nextLine();
                    System.out.println("Enter movie quantity:");
                    quantity = sc.nextInt();
                    int forCompare = movies.getCount(title);
                    if (movies.search(title)) {
                        if (forCompare < quantity) {
                            for (int i = 0; i < quantity - forCompare; i++) {
                                movies.insert(title);
                            }
                        } else {
                            for (int i = 0; i < forCompare - quantity; i++) {
                                movies.delete(title);
                            }
                        }
                        System.out.println("Updated to "+quantity+" titles of the movie "+title);
                    }
                    else{
                        System.out.println("Title not found");
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter movie title:");
                    title = sc.nextLine();
                    if (movies.search(title)){
                        System.out.println(title + " is in our library.");
                    }
                    else{
                        System.out.println("Title not found");
                    }
                    break;
                //allows exactly one movie to be removed
                case 5:
                    sc.nextLine();
                    System.out.println("Enter movie title to rent:");
                    title = sc.nextLine();
                    if (movies.search(title)){
                        movies.delete(title);
                        System.out.println(title + " is rented.");
                    }
                    else{
                        System.out.println("Title not found");
                    }
                    break;
                //allows exactly one movie to be added
                case 6:
                    sc.nextLine();
                    System.out.println("Enter movie title to return:");
                    title = sc.nextLine();
                    if (movies.search(title)){
                        movies.insert(title);
                        System.out.println(title + " is returned.");
                    }
                    else{
                        System.out.println("Title not found");
                    }
                    break;
                //allows the user to print all available movies and their quantities
                case 7:
                    sc.nextLine();
                    System.out.println("Inventory:");
                    movies.returnCounts();
                    break;
                //ends program
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
