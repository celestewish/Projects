/*
  This class defines a linked list that stores integer values.
  The class does NOT use Head and Tail pointer as the textbook class deos.
*/

import java.util.List;
public class LinkedList_No_HT
{
   public Node ListName;

   //constructor method. 
   public LinkedList_No_HT()
   {
      ListName = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (ListName == null)
         ListName = new Node(data); //one node list
      else 
      {
         Node temp = ListName;
         while (temp.next != null) 
         {
            temp = temp.next;
         }
         
         temp.next = new Node(data); //link new node as last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node
   /*This method creates a node to temporarily hold the data added by
   the user and then adds that data to the front of the list.
    */
   public void addFirstNode(int data)
   {
         Node newNode = new Node(data);
         newNode.next = ListName;
         ListName = newNode;
   }
     
      
   //method #2: add node at index
   /*This data adds input from the user to the list
   at a particular index also specified by the user.
    */
   public void addAtIndex(int index, int data)
   {
      //checks if value is being added at the first index
         if (index == 0){
            addFirstNode(data);
         }
         //checks to see if it can be added at the last node
         else if (index == countNodes()){
            addLastNode(data);
         }
         //checks for invalid index
         else if(index >= countNodes() || index < 0){
            System.out.println("Invalid index, try again");
         }
         /*this is the loop that iteratives through the list until
         it reaches the specific index
          */
         else{
            Node current = ListName;
            Node temp = ListName.next;
            for (int i = 1; i < index; i++){
               current = current.next;
               temp = temp.next;
            }
            //after said index is found the list is updated
            current.next = new Node(data);
            (current.next).next = temp;
         }
   }
      
      
   //method #3: remove first node
   /*this method checks to see if the first node is empty
   if not, then it removes the first node.
    */
   public void removeFirstNode()
   {
         if (ListName == null){
            System.out.println("List is Empty");
            return;
         }
         ListName = ListName.next;
   }
      
      
   //method #4: remove last node
   //this list remove the last node
   public void removeLastNode()
   {
      //checks if list is null
      if (ListName == null){
         System.out.println("List is Empty");
         return;
      }
      /*if the list has only one index, if so, the head (ListName in this instance)
      is made null.
       */
      else if (ListName.next == null){
         ListName = null;
         return;
      }
      /*otherwise the list iterates to the last index and uses current as the node
      to hold the current value (hence the name)
       */
      Node current = ListName;
      while (current.next.next != null){
         current = current.next;
      }
      //the list hits the last value, said last value is made null
      current.next = null;
   }
    
    
   //method #5: remove node at index
   public void removeAtIndex(int index)
   {
      //the head is made the current node and the node holding the previous index is set to null
      Node current = ListName;
      Node previous = null;
      //holds the current index value
      int currentIndex = 0;
      //checks if index is the first node
         if (index == 0){
            removeFirstNode();
         }
         //checks if list is empty or value does not exist
         else if (ListName == null){
            System.out.println("List is Empty");
         }
         //checks for invalid index
         else if(index >= countNodes() || index < 0){
            System.out.println("Invalid index, try again");
         }
         //iterates through the list until the desired index is reached
         while (current != null && currentIndex < index){
            previous = current;
            current = current.next;
            currentIndex++;
         }
         //node at the specific index is removed
       if (previous == null){
          current.next = null;
       }
       else {
          previous.next = current.next;
       }
   }
          
   //method #6: countNodes
   //counts the nodes in the list
   public int countNodes()
   {
      //holds the list size count
      int listSize= 0;
      //is going to hold the current node
      Node current = ListName;
      //iterates through the list keeping count of each node
      while (current != null){
         listSize++;
         current = current.next;
      }
      //returns list size
      return listSize; 
   }

   
   //method #7: pritnInReverse (must be a Recursive method)
   //prints the List in reverse using recursion
   public void printInReverseRecursive(Node L)
   {
      //checks to see if list is empty
      if (L == null){
         return;
      }
      /*if the list isn't empty, then the list is iterated through by the
      method calling itself. the node's pointer that points to the next node is passed
      through. this continues until the value passed through is null. when this value is reached
      the base case causes the stack to slowly be emptied, printing the list in reverse.
       */
      printInReverseRecursive(L.next);
      //as the stack is emptied, it reached this line of code which prints the data value
      //even though the data was fed in normally, it now prints in reverse due to LIFO
      System.out.print(L.data + "   ");
   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = ListName;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

