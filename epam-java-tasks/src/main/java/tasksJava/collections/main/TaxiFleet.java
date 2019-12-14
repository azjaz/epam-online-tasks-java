package tasksJava.collections.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import tasksJava.collections.taxicars.TaxiCar;

public class TaxiFleet {
	
	private List<? extends TaxiCar> taxiCars;

	public TaxiFleet(List<? extends TaxiCar> taxiCars) {
		super();
		this.taxiCars = taxiCars;
	}

	public List<? extends TaxiCar> getTaxiCars() {
		return taxiCars;
	}
	
	public int getTaxiFleetCost() {
		return taxiCars.stream()
				.mapToInt(TaxiCar :: getCarPrice)
				.sum();
	}
	
	public TaxiFleet sortTaxiFleetOnFuelEconomy() {
		List<? extends TaxiCar> sortedByFuelEconomy = taxiCars
				.stream()
				.sorted((o1, o2) -> o1.getFuelEconomy() - o2.getFuelEconomy())
				.collect(Collectors.toList());
		return this;
	}
	
	public List<? extends TaxiCar> getTaxiCarOnMaxSpeedBounds(int minBound, int maxBound) {
		List<? extends TaxiCar> carsInSpeedBounds = taxiCars
				.stream()
				.filter((p) -> p.getMaxSpeed() > minBound && p.getMaxSpeed() < maxBound)
				.collect(Collectors.toList());
		return carsInSpeedBounds;
	}

	@Override
	public String toString() {
		return "TaxiFleet [" + taxiCars + "]";
	}
	

}
