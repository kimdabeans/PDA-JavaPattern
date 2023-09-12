package FactoryMethodPattern;

public class App {
	public static void main(String args[]){
		VehicleFactory vehicleFactory = new VehicleFactory();
		
		Vehicle vehicle = vehicleFactory.getVehicle(VehicleType.CAR);
		vehicle.startEngine();
		Vehicle hybrid = vehicleFactory.getVehicle(VehicleType.HYBRID);
		hybrid.startEngine();
	}
} 

