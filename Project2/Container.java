/**
 * 
 * Container Class
 * @author felixyu00
 *
 */

public class Container implements ContainerInterface{
	
	private Node frontNode;     // top of stack
	private int size;           // size of the stack

    // helper linked list class
    private class Node {
    	DonationPackage data;
    	Node next;
    }
    public Container(int i) {
        frontNode = null;
        size = i;
    }
	@Override
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		if(isFull()) {
			throw new ContainerException("This container is full.");
		}
		Node oldfirstNode = frontNode;
		frontNode = new Node();
		frontNode.data = dPackage;
		frontNode.next = oldfirstNode;
		return true;
	}

	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException{
		if (frontNode == null) {
			throw new ContainerException("This container is empty.");
		}
		else {
			DonationPackage p = frontNode.data;        // save item to return
			frontNode = frontNode.next;            // delete first node
			return p;                   // return the saved item
		}
	}
	
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
	
	public boolean isEmpty() {
		return (frontNode == null);
	}

	@Override
	public DonationPackage[] toArrayPackage() {
	    int count = 0;
		for (Node n = frontNode; n != null; n = n.next) {
			 count++;
		}
		
		DonationPackage [] d = new DonationPackage [count]; 
		int num_one = 0;
		for (Node n = frontNode; n!= null; n = n.next) {
			 d[num_one] = n.data; 
			 num_one++;
		}
		
	    DonationPackage [] containerarray = new DonationPackage [d.length];
		int num_two = d.length;
		for (int cc = 0; cc < (d.length); cc++) {
			containerarray[cc] = d[num_two-1];
			num_two = num_two-1; 
		}
		return containerarray;
	}

}
