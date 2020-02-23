public class MyQueue <T> implements QueueInterface<T>{

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
	 public MyQueue() {
	   frontNode = null;
	   lastNode = null;
	   size = 0;
	  }
	  
	@Override
	public boolean isEmpty() {
		return (frontNode == null);
	}

	@Override
	public boolean isFull() {
	     int count = 0;
		 for (Node n = frontNode; n != null; n = n.next) {
			 count++;
		 }
		 if (count >= size) {
			 return true;
		 }
		 else {
			 return false;
		 }
	}

	@Override
	public T dequeue() throws Exception {
	    if (isEmpty()) {
		      throw new Exception ("This queue is empty.");
		    }
		    else {
		    	T t = frontNode.data;
		    	frontNode = frontNode.next;
		    	size--;
		    	return t;
		    }
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	//add item to the end of the list.
	public boolean enqueue(T item) throws Exception {
		   Node lastLastNode = lastNode;
		   lastNode = new Node();
		   lastNode.data = item;
		   lastNode.next = null;
		   if (isEmpty()) {
		     frontNode = lastNode;
		     size++;
		     return true;
		   }
		   else {
			 if(!isFull()) {
		     lastLastNode.next = lastNode;
		     size++;
		     return true;
			 }
			 else {
				 throw new Exception("This queue is full.");
			 }
		   }
	}

	@Override
	public T[] toArray() {
	     int count = 0;
		 for (Node n = frontNode; n != null; n = n.next) {
			 count++;
		 }
		
		T[] d= (T[]) new Object[count];
		int num_one = 0;
		for (Node n = frontNode; n != null; n = n.next) {
			 d[num_one] = n.data; 
			 num_one++;
		 }
		 return d;
	}//end of toArrayRecipient()
}//end of class
