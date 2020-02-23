public class MyStack <T> implements StackInterface<T> {
	
	private Node frontNode;     // top of stack 
	private int size;          // size of the stack
	
    // helper linked list class
    private class Node {
	private T data;
	private Node next;
    }
    public MyStack() {
        frontNode = null;
        size = 0;
    }
    
	@Override
	public boolean isEmpty() {
		return frontNode == null;
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
	public T pop() throws Exception{
		if (frontNode == null) {
			throw new Exception("This stack is empty.");
		}
		else {
			T p = frontNode.data;        // save item to return
			frontNode = frontNode.next;            // delete first node
			size--;
			return p;                   // return the saved item
		}                // return the saved item
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean push(T s) throws Exception {
		if(isFull()) {
			throw new Exception("This stack is full.");
		}
		Node oldfirstNode = frontNode;
		frontNode = new Node();
		frontNode.data = s;
		frontNode.next = oldfirstNode;
		size++;
		return true;
	}

	@Override
	public T[] toArray() {
	    int count = 0;
		for (Node n = frontNode; n != null; n = n.next) {
			count++;
		}
		
		T[] d= (T[]) new Object[count];
		int num_one = 0;
		for (Node n = frontNode; n!= null; n = n.next) {
			 d[num_one] = n.data;
			 num_one++;
		}
		
		T[] t= (T[]) new Object[d.length];
		int num_two = d.length;
		for (int cc = 0; cc < (d.length); cc++) {
			t[cc] = d[num_two-1];
			num_two = num_two-1; 
		}
		return t;
	}
}
