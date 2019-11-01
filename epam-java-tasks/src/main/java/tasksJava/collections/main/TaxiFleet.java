package tasksJava.collections.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
		int taxiFleetCost = 0;
		for(TaxiCar taxiCar : taxiCars) {
			taxiFleetCost += taxiCar.getCarPrice();
		}
		return taxiFleetCost;
	}
	
	public TaxiFleet sortTaxiFleetOnFuelEconomy() {
		Collections.sort(taxiCars, new Comparator<TaxiCar>() {
			public int compare(TaxiCar obj1, TaxiCar obj2) {
				return obj1.getFuelEconomy() - obj2.getFuelEconomy();
			}
		});
		return this;
	}
	
	public TaxiCar getTaxiCarOnMaxSpeedBounds(int minBound, int maxBound) {
		for(TaxiCar taxiCar : taxiCars) {
			if(taxiCar.getMaxSpeed() > minBound && taxiCar.getMaxSpeed() < maxBound) {
				return taxiCar;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "TaxiFleet [" + taxiCars + "]";
	}
	

}
