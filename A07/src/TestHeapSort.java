// Class Heap.java 
// Textbook - Listing 23.9, Page 878
// Name: Lauren Rousell
// Class: CS 3305/H01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 7
// IDE Name: IntelliJ
public class TestHeapSort { 
   /** A test method */
   public static void main(String[] args) {
    
      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53}; 
      
      System.out.print("Original List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");
         
      HeapSort.heapSort(list);  //sort the list
      
      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");   
//these are just the additional lists I was required to add by the assignment requirements
      Character[] list2 = {'w','f','A','X','T','Q','k','s','8','L','3','b','A','w','s','H','j','K','L'};
      System.out.print("\n\nOriginal List 2:\t");
      for (int i = 0; i < list2.length; i++)
         System.out.print(list2[i] + " ");
      HeapSort.heapSort(list2);
      System.out.print("\n\nSorted List 2:\t");
      for(int i = 0; i < list2.length; i++)
         System.out.print(list2[i] + " ");
//they simply load data into a list, and then sort that list using a heapsort for practice i suppose
      String[] list3 = {"Class", "Study", "Data", "Computing", "hard", "Structures,", "to pass."};
      System.out.print("\n\nOriginal List 3:\t");
      for (int i = 0; i < list3.length; i++)
         System.out.print(list3[i] + " ");
      HeapSort.heapSort(list3);
      System.out.print("\n\nSorted List 3:\t");
      for(int i = 0; i < list3.length; i++)
         System.out.print(list3[i] + " ");
   }
}
