package TollCollectionV3;

public class TollCollectionStation {
	
	private int amountOfBooths;
	
	public TollCollectionStation(int booths) {
		amountOfBooths = booths;
	}
	
	Booth[] booths;
	
	int totalToll;
	// Setters
	public void setamountOfBooths( int booths) {
		amountOfBooths = booths;
		}
	
	// Getter for toll rate
	public double getTotalToll( int booths) {
		double totalToll = 0;
		// Loop that keeps track of toll booths
		for (int i = 0; i < amountOfBooths; i++) {
			booths = i + 1;
			totalToll = totalToll * 0;
		}
		return totalToll;
		
	}

}
