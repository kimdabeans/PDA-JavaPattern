package FactoryMethodPattern2;

import java.lang.reflect.InvocationTargetException;

/**
 * `App` 클래스는 Factory Method 패턴을 사용하여 다양한 유형의 교통 수단 객체를 생성하고 사용하는 예제를 제공합니다.
 * 이 클래스는 미리 등록된 객체 및 다이나믹 팩토리를 사용하여 교통 수단을 생성합니다.
 *
 * 다이나믹 팩토리를 통해 교통 수단의 제품 객체를 동적으로 등록하고 생성할 수 있습니다.
 * 초기에는 "Car"와 "Truck" 유형의 교통 수단이 미리 등록되어 있으며, "Bicycle" 유형의 교통 수단을 동적으로 등록하는 예제가 포함되어 있습니다.
 * 
 * 위 예제에서는 다양한 교통 수단 객체를 생성하고 엔진을 시작합니다.
 * "Bicycle" 유형의 교통 수단은 초기에 등록되어 있지 않았지만, 동적으로 등록하여 사용할 수 있습니다.
 * @author Cho Hayoung
 */
public class App {
	public static void main(String args[]) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//미리 등록된 객체 
		Vehicle car = DynamicVehicleFactory.create("Car");
		car.startEngine();
		Vehicle truck = DynamicVehicleFactory.create("Truck");
		truck.startEngine();
	
		// 다이나믹 팩토리에 동적으로 제품 객체 등록 
		DynamicVehicleFactory.registerType("Bicycle", Bicycle.class);
		Vehicle bicycle = DynamicVehicleFactory.create("Bicycle");
		bicycle.startEngine();
		
		
	}
} 

