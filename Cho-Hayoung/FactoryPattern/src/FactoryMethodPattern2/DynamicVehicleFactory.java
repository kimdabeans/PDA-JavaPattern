package FactoryMethodPattern2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * DynamicVehicleFactory 클래스는 동적으로 다양한 차량(Vehicle) 객체를 생성하는 팩토리 클래스입니다.
 * 이 클래스는 Reflection을 사용하여 등록된 차량 타입에 따라 객체를 생성합니다.
 * 새로운 차량 타입을 등록하고 차량 객체를 생성하는 기능을 제공합니다.
 * 
 * @author Cho hayoung
 */
public class DynamicVehicleFactory {
    // Class 클래스 객체와 이를 구분하는 이니셜 문자열을 저장하는 HashMap 컬렉션
    private static final Map<String, Class<? extends Vehicle>> registeredTypes = new HashMap<>();

    // 팩토리 객체가 생성됨에 동시에 미리 등록
    static {
        registeredTypes.put("Car", Car.class);
        registeredTypes.put("ElectricCar", ElectricCar.class);
        registeredTypes.put("Truck", Truck.class);
    }

    /**
     * 새로운 차량 타입을 등록합니다.
     *
     * @param type 등록할 차량 타입
     * @param cls  차량 타입에 해당하는 클래스
     */
    public static void registerType(String type, Class<? extends Vehicle> cls) {
        registeredTypes.put(type, cls);
    }

    /**
     * 주어진 타입에 해당하는 차량 객체를 생성합니다.
     *
     * @param type 차량 타입
     * @return 생성된 차량 객체
     * @throws NoSuchMethodException      - 해당 제품 클래스에 기본 생성자가 없는 경우
     * @throws IllegalAccessException     - 접근 권한이 없는 생성자를 호출한 경우
     * @throws InstantiationException     - 인스턴스 생성 중 예외가 발생한 경우
     * @throws IllegalArgumentException    - 유효하지 않은 인수로 생성자를 호출한 경우
     * @throws InvocationTargetException - 생성자 호출 중 예외가 발생한 경우

     */
    public static Vehicle create(String type) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
        Vehicle vehicle = null;

        vehicle = getVehicle(type);
 
        return vehicle;
    }

    /**
     * 지정된 제품 타입에 해당하는 {@link Vehicle} 객체를 반환합니다.
     *
     * @param type 제품의 종류를 나타내는 문자열
     * @return 해당 제품 타입의 {@link Vehicle} 인스턴스
     * @throws SecurityException 
     * @throws NoSuchMethodException      - 해당 제품 클래스에 기본 생성자가 없는 경우
     * @throws IllegalAccessException     - 접근 권한이 없는 생성자를 호출한 경우
     * @throws InstantiationException     - 인스턴스 생성 중 예외가 발생한 경우
     * @throws IllegalArgumentException    - 유효하지 않은 인수로 생성자를 호출한 경우
     * @throws InvocationTargetException - 생성자 호출 중 예외가 발생한 경우
     */
    private static Vehicle getVehicle(String type) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // 1. 원하는 제품명의 Class 클래스 객체를 가져옴
        Class<?> cls = registeredTypes.get(type);

        // 2. 제품 객체의 생성자를 가져옴
        Constructor<?> vehicleConstructor = cls.getDeclaredConstructor();

        // 3. Reflection API를 통해 인스턴스화를 하고 업캐스팅 하여 반환
        return (Vehicle) vehicleConstructor.newInstance();
    }
}
