/*
  This class define a linked list that stores integer values.
  The class does NOT use Head and Tail pointer as the textbook class deos.
  Same class as before, but now is generic.
*/
public class LinkedList_No_HT_Generic<E>
{
    public Node<E> ListName;

    //constructor method to create a list object with a specifc name.
    public LinkedList_No_HT_Generic()
    {
        ListName = null;
    }

    //method add node to end of list
    public <E> void addLastNode(E data)
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
    public <E> void addFirstNode(E data)
    {
        Node newNode = new Node(data);
        newNode.next = ListName;
        ListName = newNode;
    }


    //method #2: add node at index
   /*This data adds input from the user to the list
   at a particular index also specified by the user.
    */
    public <E extends Comparable<E>> void addAtIndex(E index, E data)
    {
        Integer listSize = countNodes();
        //checks if value is being added at the first index
        if (index.equals(0)){
            addFirstNode(data);
        }
        //checks to see if it can be added at the last node
        else if (index.equals(listSize)){
            addLastNode(data);
        }
        //checks for invalid index
        else if((Integer) index>= listSize || (Integer) index < 0){
            System.out.println("Invalid index, try again");
        }
         /*this is the loop that iteratives through the list until
         it reaches the specific index
          */
        else{
            Node current = ListName;
            Node temp = ListName.next;
            for (Integer i = 1; index.compareTo((E) i) < i; i++){
                current = current.next;
                temp = temp.next;
            }
            //after said index is found the list is updated
            current.next = new Node((Integer) data);
            (current.next).next = temp;
        }
    }


    //method #3: remove first node
   /*this method checks to see if the first node is empty
   if not, then it removes the first node.
    */
    public <E> void removeFirstNode()
    {
        if (ListName == null){
            System.out.println("List is Empty");
            return;
        }
        ListName = ListName.next;
    }


    //method #4: remove last node
    //this list remove the last node
    public <E> void removeLastNode()
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
    public <E extends Comparable<E>> void removeAtIndex(E index)
    {
        Integer listSize = countNodes();
        //the head is made the current node and the node holding the previous index is set to null
        Node current = ListName;
        Node previous = null;
        //holds the current index value
        Integer currentIndex = 0;
        //checks if index is the first node
        if (index.equals(0)){
            removeFirstNode();
        }
        //checks if list is empty or value does not exist
        else if (ListName == null){
            System.out.println("List is Empty");
        }
        //checks for invalid index
        else if((Integer) index >= listSize || (Integer) index < 0){
            System.out.println("Invalid index, try again");
        }
        //iterates through the list until the desired index is reached
        while (current != null && currentIndex < (Integer) index){
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
    public <E> int countNodes()
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
    public <E> void printInReverseRecursive(Node<E> L)
    {
        //checks to see if list is empty
        if (L == null){
            System.out.println("List is Empty");
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

    //this method returns the values in the LinkedList as a String
    //I added this so that WordsPalindrome would be a bit cleaner
    public <E> String returntoString()
    {
        Node temp;
        temp = ListName;
        StringBuilder result = new StringBuilder();
        while (temp != null)
        {
            result.append(temp.data);
            temp = temp.next;
        }
        return result.toString();
    }

    //================= end of your part ==============

    //this method returns the values in the LinkedList as a String
    public <E> void printList()
    {
        Node temp;
        temp = ListName;
        while (temp != null)
        {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
        return;
    }

    //class to create nodes as objects
    private class Node<E>
    {
        private E data;  //data field
        private Node<E> next; //link field

        public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
        public E returnNext(){
            if (next == null){
                return null;
            }
            else {
                return next.data;
            }
        }
    }
}

