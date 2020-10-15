package TollCollectionV3;

public class Booth {
	
	private double tollRateTotal;
	private int amountOfBooths;
	
	public Booth(double tollRate, int numberOfBooths) {
		tollRateTotal = tollRate;	
		amountOfBooths = numberOfBooths;
	}
	
	double boothTotal;
	
	// Setters
	public void setTollRateTotal(double tollRate) {
		tollRateTotal = tollRate;
	}
	
	// Getters
	public double getBoothTotal() {
		// Loop that keeps track of toll booths
		for (int i = 0; i < amountOfBooths; i++) {
			int displayArray;
			displayArray = i + 1;
			boothTotal = boothTotal * 0;
		boothTotal += tollRateTotal;
	}
	return boothTotal;

	}
}
