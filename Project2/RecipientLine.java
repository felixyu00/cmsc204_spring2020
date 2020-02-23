/**
 * 
 * Recipient Class
 * @author felixyu00
 *
 */

public class RecipientLine implements RecipientLineInterface{
	
	 //initialize front and last nodes, and the size of the queue
	 private Node frontNode;
	 private Node lastNode; 
	 private int size; 

	 //node class initiating two required node date values
	 private class Node
	 { 
	   Recipient data;
	   Node next;
	 }//end of inner Node class
	 
	public RecipientLine(int i) {
	 frontNode = null;
	 lastNode = null;
     size = i;
	}//end of RecipientLine() constructor

	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		Node lastLastNode = lastNode;
		lastNode = new Node();
		lastNode.data = rc;
		lastNode.next = null;
		if (recipientLineEmpty()) {
			frontNode = lastNode;
			return true;
			}
		else {
			if(!isFull()) {
				lastLastNode.next = lastNode;
				return true;
				}
			else {
				throw new RecipientException("This line is full.");
				}
			}
	}//end of addNewRecipient()

	@Override
	public Recipient recipientTurn() throws RecipientException {
	    if (recipientLineEmpty()) {
	      throw new RecipientException ("This line empty.");
	    }
	    else {
	    	Recipient r = frontNode.data;
	    	frontNode = frontNode.next;
	    	return r;
	    }
	}//end of recipientTurn()
	
	@Override
	public boolean recipientLineEmpty() {
		return (frontNode == null);
	}//end of recipientLineEmpty()

	@Override
	public Recipient[] toArrayRecipient() {
	     int count = 0;
		 for (Node n = frontNode; n != null; n = n.next) {
			 count++;
		 }
		
		Recipient [] r_list = new Recipient [count]; 
		int num_one = 0;
		for (Node n = frontNode; n != null; n = n.next) {
			 r_list[num_one] = n.data; 
			 num_one++;
		 }
		 return r_list;
	}//end of toArrayRecipient()

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
	}//end of isFull()
	
}//end of class
