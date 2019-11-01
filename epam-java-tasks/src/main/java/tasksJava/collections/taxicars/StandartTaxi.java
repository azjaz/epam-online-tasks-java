package tasksJava.collections.taxicars;

import java.util.Objects;

import tasksJava.collections.taxitypes.StandartType;

public class StandartTaxi extends TaxiCar {
	
	private StandartType type;
	
	public StandartTaxi(int maxSpeed, int fuelEconomy, int carPrice, StandartType type) {
		super(maxSpeed, fuelEconomy, carPrice);
		this.type = type;
	}
	
	
	public StandartType getType() {
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
		if (!(obj instanceof StandartTaxi)) return false;
		StandartTaxi standartTaxi = (StandartTaxi) obj;
		return type == standartTaxi.type;
	}
	@Override
	public String toString() {
		return StandartTaxi.class.getSimpleName() + super.toString().replace("]", ", type=" + type + "]");
	}
	
	

}
