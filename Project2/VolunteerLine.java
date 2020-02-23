/**
 * 
 * Volunteer line Class
 * @author felixyu00
 *
 */

public class VolunteerLine implements VolunteerLineInterface{
	
	 //initialize front and last nodes, and the size of the queue
	 private Node frontNode;
	 private Node lastNode; 
	 private int size; 

	 //node class initiating two required node date values
	 private class Node
	 { 
	   Volunteer data;
	   Node next;
	 }//end of inner Node class
	 
	public VolunteerLine(int i) {
	 frontNode = null;
	 lastNode = null;
     size = i;
	}//end of VolunteerLine() constructor

	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		   Node lastLastNode = lastNode;
		   lastNode = new Node();
		   lastNode.data = v;
		   lastNode.next = null;
		   if (volunteerLineEmpty()) {
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
	}//end of addNewVolunteer()

	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
	    if (volunteerLineEmpty()) {
		      throw new RecipientException ("This line is empty.");
		    }
		    else {
		    	Volunteer v = frontNode.data;
		    	frontNode = frontNode.next;
		    	return v;
		    }
	}//end of volunteerTurn()

	@Override
	public boolean volunteerLineEmpty() {
		return (frontNode == null);
	}//end of volunteerLineEmpty()

	@Override
	public Volunteer[] toArrayVolunteer() {
		   int count = 0;
			 for (Node n = frontNode; n != null; n = n.next) {
				 count++;
			 }
			
			Volunteer [] v_list = new Volunteer [count]; 
			int num_one = 0;
			for (Node n = frontNode; n != null; n = n.next) {
				 v_list[num_one] = n.data; 
				 num_one++;
			 }
			 return v_list;
	}//end of arrayVolunteer()

	
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
