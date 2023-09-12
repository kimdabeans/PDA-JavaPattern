package SingletonPattern.Example02.GoodCase;

public class Main {

  public static void main(String[] args) {
    // 두 번 객체를 생성해도 항상 동일한 인스턴스를 반환합니다.
    ChocolateBoiler boiler1 = ChocolateBoiler.getInstance();
    ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();

    // 두 객체가 동일한 인스턴스임을 확인합니다.
    System.out.println("Boiler 1 == Boiler 2: " + (boiler1 == boiler2)); // true

    // 보일러의 상태를 변경합니다.
    boiler1.fill();
    boiler1.boil();
    boiler1.drain();

    // 다른 객체로도 상태를 확인합니다.
    System.out.println("Boiler 2 Empty: " + boiler2.isEmpty()); // false
    System.out.println("Boiler 2 Boiled: " + boiler2.isBoiled()); // true
  }
}
