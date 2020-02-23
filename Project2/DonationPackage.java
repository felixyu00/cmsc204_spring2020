
public class DonationPackage {

	private String description;
	private double weight;
	
	public DonationPackage(String description, double weight) {
		this.description = description;
		this.weight = weight;
	}

	public boolean isHeavy() {
		if(weight >= 20) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getWeight() {
		return weight;
	}

}
