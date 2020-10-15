package TollCollectionV3;

public class Vehicle {
	
	private int axleCount, vehicleType, paymentType;

	public Vehicle(int axels, int vehicle, int payment) {
		axleCount = axels;
		vehicleType = vehicle;
		paymentType = payment;
	}

	double toll;

	// Setters
	public void setVehicleType(int vehicle) {
		vehicleType = vehicle;
	}

	public void setAxleCount(int axels) {
		axleCount = axels;
	}

	public void setToll(double toll) {
		this.toll = toll;
	}

	public void setPaymentType(int payment) {
		paymentType = payment;
	}

	// Getters

	// Initial charge based on axle count
	public double getToll() {
		if (axleCount == 1) {
			toll = toll + 2;
		} else if (axleCount == 2) {
			toll = toll + 3;
		} else if (axleCount == 3) {
			toll = toll + 4;
		} else if (axleCount > 3) {
			toll = 4 + (5 * (axleCount - 3));
		}

		// Calculates toll rate based on vehiclType

		// Gas vehicles
		if (vehicleType == 1) {
			toll = toll + 0;
		}
		// Hybrid vehicles
		else if (vehicleType == 2) {
			toll = toll * 0.75;
		}
		// Electric vehicles
		else if (vehicleType == 3) {
			toll = toll * 0.5;
		}

		// Calculates final toll rate based on payment type

		// Credit/Debit
		if (paymentType == 1) {
			toll = toll * 1.15;
		}
		// Cash
		else if (paymentType == 2) {
			toll = toll + 0;
		}
		// Electronic
		else if (paymentType == 3) {
			toll = toll * 0.80;
		}
		return toll;
	}
	
	

	
	


}
