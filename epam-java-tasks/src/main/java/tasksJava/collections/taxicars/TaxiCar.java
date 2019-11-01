package tasksJava.collections.taxicars;

import java.util.Objects;

public class TaxiCar {
	
	private int maxSpeed;
	private int fuelEconomy;
	private int carPrice;
	
	public TaxiCar(int maxSpeed, int fuelEconomy, int carPrice) {
		super();
		this.maxSpeed = maxSpeed;
		this.fuelEconomy = fuelEconomy;
		this.carPrice = carPrice;
	}
	
	

	public int getMaxSpeed() {
		return maxSpeed;
	}



	public int getFuelEconomy() {
		return fuelEconomy;
	}



	public int getCarPrice() {
		return carPrice;
	}



	@Override
	public int hashCode() {
		return Objects.hash(fuelEconomy, maxSpeed, carPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof TaxiCar)) return false;
		TaxiCar taxiCar = (TaxiCar) obj;
		return (fuelEconomy == taxiCar.fuelEconomy)
				&& (maxSpeed == taxiCar.maxSpeed) && (carPrice == taxiCar.carPrice);
				
		
	}

	@Override
	public String toString() {
		return " [maxSpeed=" + maxSpeed + ", fuelEconomy=" + fuelEconomy + ", carPrice=" + carPrice + "]";
	}
	
	

}
