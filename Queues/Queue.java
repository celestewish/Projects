//this is a class that is used to make queues
//a queue works like a line, FIFO, first element in is the first element to be removed
public class Queue<E> {
    //attributes
    private Node<E> front;
    private Node<E> rear;
    private int size;
    //constructor
    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }
    //adds a value to the queue
    public void enqueue(E e) {
        Node<E> newNode = new Node(e);
        if (front == null) {
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    //removes a value from the queue
    public void dequeue() {
        if (size == 0){
            return;
        }
        Node<E> temp = front;
        front = front.next;
        temp.next = null;
        size--;
    }
    //returns the front value
    public E front(){
        if (size == 0){
            return null;
        }
        return front.data;
    }
    //returns the size
    public int size(){
        return size;
    }
    //checks if empty
    public boolean isEmpty(){
        return size == 0;
    }
    //prints the queue
    public void printQueue(){
        Node<E> temp = front;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    //node class used to help instantiate the queue using a linked list system
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
