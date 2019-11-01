package tasksJava.collections.taxicars;

import java.util.Objects;

import tasksJava.collections.taxitypes.VIPType;

public class VIPTaxi extends TaxiCar {
	
	private VIPType type;
	
	public VIPTaxi(int maxSpeed, int fuelEconomy, int carPrice, VIPType type) {
		super(maxSpeed, fuelEconomy, carPrice);
		this.type = type;
	}
	

	public VIPType getType() {
		return type;
	}


	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (!(obj instanceof VIPTaxi)) return false;
		VIPTaxi vipTaxi = (VIPTaxi) obj;
		return type == vipTaxi.type;
			
	}


	@Override
	public String toString() {
		return VIPTaxi.class.getSimpleName() + super.toString().replace("]", ", type=" + type + "]");
	}
	
	

}
