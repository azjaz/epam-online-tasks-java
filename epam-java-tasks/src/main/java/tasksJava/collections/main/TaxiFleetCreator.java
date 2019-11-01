package tasksJava.collections.main;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import tasksJava.collections.taxicars.FamilyTaxi;
import tasksJava.collections.taxicars.StandartTaxi;
import tasksJava.collections.taxicars.TaxiCar;
import tasksJava.collections.taxicars.VIPTaxi;
import tasksJava.collections.taxitypes.FamilyType;
import tasksJava.collections.taxitypes.StandartType;
import tasksJava.collections.taxitypes.VIPType;


public class TaxiFleetCreator {
		
	public static List<TaxiCar> getListOfTaxiCars() {
		String config = "..\\epam-java-tasks\\src\\main\\resources\\configCollection.properties";
		List<TaxiCar> initList = new ArrayList<>();
		Properties properties = new Properties();
		try (FileInputStream inputStream = new FileInputStream(config)) {
			if(inputStream != null) {
				properties.load(inputStream);
			 
			initList.add(new StandartTaxi(Integer.valueOf(properties.getProperty("maxSpeed0")),
					Integer.valueOf(properties.getProperty("fuelEconomy0")),
					Integer.valueOf(properties.getProperty("carPrice0")),
					StandartType.valueOf(properties.getProperty("type0"))));
			initList.add(new StandartTaxi(Integer.valueOf(properties.getProperty("maxSpeed1")), 
					Integer.valueOf(properties.getProperty("fuelEconomy1")),
					Integer.valueOf(properties.getProperty("carPrice1")),
					StandartType.valueOf(properties.getProperty("type1"))));
			initList.add(new VIPTaxi(Integer.valueOf(properties.getProperty("maxSpeed2")),
					Integer.valueOf(properties.getProperty("fuelEconomy2")),
					Integer.valueOf(properties.getProperty("carPrice2")),
					VIPType.valueOf(properties.getProperty("type2"))));
			initList.add(new VIPTaxi(Integer.valueOf(properties.getProperty("maxSpeed3")), 
					Integer.valueOf(properties.getProperty("fuelEconomy3")),
					Integer.valueOf(properties.getProperty("carPrice3")),
					VIPType.valueOf(properties.getProperty("type3"))));
			initList.add(new FamilyTaxi(Integer.valueOf(properties.getProperty("maxSpeed4")),
					Integer.valueOf(properties.getProperty("fuelEconomy4")),
					Integer.valueOf(properties.getProperty("carPrice4")),
					FamilyType.valueOf(properties.getProperty("type4"))));
		}
		} catch(IOException e) {e.printStackTrace();
		}
		
		return initList;
	}
	
}
