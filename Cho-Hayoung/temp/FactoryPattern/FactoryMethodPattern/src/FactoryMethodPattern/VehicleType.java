package FactoryMethodPattern;

public enum VehicleType   {
		
	TRUCK{
		public Vehicle getVehicle(){
			return new Truck();
		}
	},
	CAR{
		public Vehicle getVehicle(){
			return new Car();
		}
	},
	ELECTRIC{
		public Vehicle getVehicle(){
			return new ElectricCar();
		}
	},
	
	HYBRID{
		@Override
		Vehicle getVehicle() {
			// TODO Auto-generated method stub
			return new HybridCar();
		}

		
		
	};

	abstract Vehicle getVehicle();
}
