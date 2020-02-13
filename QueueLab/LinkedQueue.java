/**
 * 
 * A class that implements a queue of objects by using
 * a chain of linked nodes that has both front and end references
 * @author felixyu00
 *
 */

//a linked implementation of a queue compatible with generic data type <T>
class LinkedQueue <T> implements QueueInterface <T> {
	
	  //initialize front and last nodes, and the size of the queue
	  private Node frontNode;
	  private Node lastNode; 
	  private int size; 
	 
	  //node class initiating two required node date values
	  private class Node
	  { 
	    T data;
	    Node next;
	  }
	 
	  //default constructor
	  public LinkedQueue() {
	    frontNode = null;
		lastNode = null;
	    size = 0;
	  }
	  
	  //add item to the end of the list.
	  public void enqueue(T item) {
	    Node lastLastNode = lastNode;
	    lastNode = new Node();
	    lastNode.data = item;
	    lastNode.next = null;
	    if (isEmpty()) {
	      frontNode = lastNode;
	    }
	    else {
	      lastLastNode.next = lastNode;
	    }
	    size++;
	  }
	  
	  //remove item from the beginning of the list.
	  public T dequeue() {
	    T item = frontNode.data;
	    frontNode = frontNode.next;
	    if (isEmpty()) {
	      lastNode = null;
	    }
	    size--;
	    return item;
	    }
	
	  //allow peek at the front of the queue
	  public T getFront() {
		  if (isEmpty()) {
			  return null;
		  }
		  else {
			  return frontNode.data;
		  }
	  }
	  
	  //method determining if the queue is empty
	  public boolean isEmpty() {
	    return (size == 0);
	    }
	  
	  //return the size of the queue
	  public int size() {
	    return size;
	  }
	  
	  //clearing the queue
	  public void clear() {
		   frontNode = null;
		   lastNode = null;
	  }
}