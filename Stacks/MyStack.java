//Name: Lauren Rousell
//Class: CS 3305/H01
//Term: Fall 2024
//Instructor: Dr. Haddad
//Assignment: 4
//IDE Name: IntelliJ
//this program is used to create the Stack blueprint
public class MyStack<E> {
    //attributes
    private Node top;
    private int size;

    //constructor
    public MyStack() {
        top = null;
        size = 0;
    }

    //here are the methods
    //this method pushes data on top of the stack
    public <E> void push (E data){
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
            size++;
        }
        else{
            newNode.next = top;
            top = newNode;
            size++;
        }
    }
    //this method removes the first element on the stack but doesnt return it
    public <E> void pop(){
        if(isEmpty()){
            return;
        }
        else {
            top = top.next;
            size--;
        }
    }
    //this method returns the first element of the stack
    public <E> E top(){
        if(top == null){
            return null;
        }
        else{
            Node current = top;
            pop();
            return (E) current.data;
        }
    }
    //returns the size
    public <E> int size(){
        return size;
    }
    //checks if empty
    public <E> boolean isEmpty() {
        if (size == 0)
            return true;
        else return false;
    }
    //prints the stack
    public <E> void print(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }
        else {
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    //is the node class
    private class Node<E>
    {
        private E data;  //data field
        private Node<E> next; //link field

        public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}
