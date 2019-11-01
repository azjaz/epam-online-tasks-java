package tasksJava.collections.taxicars;

import java.util.Objects;

import tasksJava.collections.taxitypes.FamilyType;

public class FamilyTaxi extends TaxiCar {
	
	private FamilyType type;

	public FamilyTaxi(int maxSpeed, int fuelEconomy, int carPrice, FamilyType type) {
		super(maxSpeed, fuelEconomy, carPrice);
		this.type = type;
	}
	

	public FamilyType getType() {
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
		if (!(obj instanceof FamilyTaxi)) return false;
		FamilyTaxi familyTaxi = (FamilyTaxi) obj;
		return type == familyTaxi.type;
			
	}

	@Override
	public String toString() {
		return FamilyTaxi.class.getSimpleName() + super.toString().replace("]", ", type=" + type + "]");
	}
	
	

}
