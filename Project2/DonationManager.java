/**
 * 
 * DonationManager Class
 * @author felixyu00
 *
 */


public class DonationManager implements DonationManageInterface {
	
	Container container =  new Container(99);
	VolunteerLine volunteer_line = new VolunteerLine(99);
	RecipientLine recipient_line = new RecipientLine(99);
	private Recipient recipient;
	private DonationPackage donation_package;
	private Volunteer volunteer;
	private double weight;
	

	public DonationManager(){
	}
	

	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		return (container.loadContainer(dPackage));
	}

	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		return(volunteer_line.addNewVolunteer(v));
	}
	
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		return(recipient_line.addNewRecipient(r));
	}

	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		if(!volunteer_line.volunteerLineEmpty()) {
			if(!recipient_line.recipientLineEmpty()){
				if(!container.isEmpty()){
					this.donation_package = container.removePackageFromContainer();
					this.weight = donation_package.getWeight();
					this.volunteer = volunteer_line.volunteerTurn();
					volunteer_line.addNewVolunteer(volunteer);
					this.recipient = recipient_line.recipientTurn();
				}//end of third if
				else {
					throw new ContainerException("Container is empty.");
				}//end of third else
			}//end of second if
			else {
				throw new RecipientException ("Recipient Queue is empty.");
			}//end of second else
		}//end of third if
		else {
			throw new VolunteerException ("Volunteer Queue is empty.");
		}//end of first else
		int final_weight = (int) weight;
		return final_weight;
	}


	@Override
	public DonationPackage[] managerArrayPackage() {
		return container.toArrayPackage();
	}

	@Override
	public Volunteer[] managerArrayVolunteer() {
		return volunteer_line.toArrayVolunteer();
	}

	@Override
	public Recipient[] managerArrayRecipient() {
		return recipient_line.toArrayRecipient();
	}
	
	public String toString() {
		return volunteer.getName() + " donated " + donation_package.getDescription() + " that weighs " + weight + " lbs to " + recipient.getName() + "." ;
	}

	

}
