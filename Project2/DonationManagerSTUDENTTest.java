import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * 
 * Student JUnit test for the Donation Manager class methods
 * @author felixyu00
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}

	@Test
	public void testManagerLoadcontainer()   { //test addition of donation packages
	
		try {
			manager.managerLoadContainer(new DonationPackage("Pens",12));
			manager.managerLoadContainer(new DonationPackage("Books",12));
			manager.managerLoadContainer(new DonationPackage("NoteBooks",11));
			manager.managerLoadContainer(new DonationPackage("chairs",20));
			manager.managerLoadContainer(new DonationPackage("laptop",14));
			 
		} catch (ContainerException e) {
			assertTrue("This should not have thrown an exception", false);
			System.out.println("Should not throw exception.");
		}	 	 
	}
	 
	@Test
	public void testManagerQueueVolunteer() { //test addition of volunteer
		try {
			manager.managerQueueVolunteer(new  Volunteer("John"));
			manager.managerQueueVolunteer(new  Volunteer("Adam"));
			manager.managerQueueVolunteer(new  Volunteer("Nichole"));
			manager.managerQueueVolunteer(new  Volunteer("Allan"));
			manager.managerQueueVolunteer(new  Volunteer("Mary"));
			manager.managerQueueVolunteer(new  Volunteer("David"));
			
		} catch (VolunteerException e) {
			assertTrue("This should not have thrown an exception", false);
			System.out.println("Should not throw exception.");
		}
	 
	}

	@Test
	public void testManagerQueueRecipientSTUDENT() { //test addition of recipient
		try {
			manager.managerQueueRecipient(new  Recipient("Jennifer"));
			manager.managerQueueRecipient(new  Recipient("Felix"));
			manager.managerQueueRecipient(new  Recipient("Gary"));
			manager.managerQueueRecipient(new  Recipient("Mathew"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e + "here");
		}
	}

	@Test
	public void testDonatePackage() { //test donation functionality
	    Volunteer v1;
	    Recipient r1;
	    DonationPackage d1;
	    
	    v1 = new Volunteer("Monica"); 
		r1 =  new Recipient("MC College");
		
		d1 =  new DonationPackage("pens",10);

		
		try {
			manager.managerLoadContainer(d1);	
			manager.managerQueueVolunteer(v1);    //add a volunteer
			manager.managerQueueRecipient(r1);   //Add a recipient
			assertEquals(manager.donatePackage(),10);    // donation process should be successful, this should remove the package from
			                                            // the container and recipients from the queue, Volunteer is enqueued again to the 
														// Volunteer line
			
		} catch (ContainerException | VolunteerException | RecipientException e) {
			 
			e.printStackTrace();
		}
	} 
	
	@Test
	public void testtoString() { //test the return of donation transcript string
	    Volunteer v1;
	    Recipient r1;
	    DonationPackage d1;
	    
	    v1 = new Volunteer("Monica"); 
		r1 =  new Recipient("MC College");
		
		d1 =  new DonationPackage("pens",10);

		
		try {
			manager.managerLoadContainer(d1);	
			manager.managerQueueVolunteer(v1);    //add a volunteer
			manager.managerQueueRecipient(r1);   //Add a recipient
			manager.donatePackage();             // donation process should be successful, this should remove the package from
			                                            // the container and recipients from the queue, Volunteer is enqueued again to the 
														// Volunteer line.
			
			assertEquals(manager.toString(),"Monica donated pens that weighs 10.0 lbs to MC College."); //test string returned after donation
			
		} catch (ContainerException | VolunteerException | RecipientException e) {
			 
			e.printStackTrace();
		}
	} 

}
