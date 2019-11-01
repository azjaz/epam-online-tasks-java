package tasksJava.collections.main;

import java.util.List;

import tasksJava.collections.taxicars.TaxiCar;

public class Launcher {
	static List<? extends TaxiCar> taxiCars = TaxiFleetCreator.getListOfTaxiCars();

	public static void main(String[] args) {
		int maxBound = 290;
		int minBound = 190;
		
		TaxiFleet taxiFleet = new TaxiFleet(taxiCars);
		
		System.out.println("The total cost of TaxiFleet is " + taxiFleet.getTaxiFleetCost() + " USD");
		System.out.println("TaxiFleet sorted by fuel economy is " + taxiFleet.sortTaxiFleetOnFuelEconomy().toString());
		System.out.println("The car with speed in bounds between " + minBound + " and " + maxBound + " is " +
							taxiFleet.getTaxiCarOnMaxSpeedBounds(minBound, maxBound));

	}

}
