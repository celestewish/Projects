// Generic code for class priority_queue_heap for Assignment 7 
// Name: Lauren Rousell
// Class: CS 3305/H01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 7
// IDE Name: IntelliJ
public class PQ_heap<E extends Comparable<E>>
{	private Heap<E> heap;
    private final int CAPACITY = 100;
    // Constructor method
   public PQ_heap() {
       heap = new Heap<>();
   }
	
	// Return true if priority queue is empty; otherwise return false
   public boolean is_empty() {
       return heap.getSize() == 0;
   }
	
	// Return true if priority queue is full; otherwise return false
   public boolean is_full() {
       return heap.getSize() == CAPACITY;
   }

	// Return (don't remove) the front element from the priority queue
	// Precondition: priority queue is not empty.
   public E front() {
       if (heap.getSize() == 0){
           return null;
       }
       else{
           return heap.returnList(0);
       }
   }

	// return number of elements in the queue
   public int size() {
       return heap.getSize();
   }
   
	// Remove the largest value from this priority queue and return it.
	// Precondition: priority queue is not empty.
   public void dequeue() {
       if (heap.getSize() == 0){
           return;
       }
       else{
           heap.remove();
           heap.priority();
       }
   }

	// Inserts the 'value' into the priority queue.
	// Precondition: priority queue is not full
   public void enqueue(E value) {
       if (heap.getSize() == CAPACITY){
           System.out.println("Heap is full");
       }
       else{
           heap.add(value);
           heap.priority();
       }
   }

   public void printPriorityHeap(){
       heap.printHeap();
   }
};
