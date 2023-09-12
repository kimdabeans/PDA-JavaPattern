package SingletonPattern.Example02.BadCase;

public class Main {

  public static void main(String[] args) {
    ChocolateBoiler boiler1 = new ChocolateBoiler();
    ChocolateBoiler boiler2 = new ChocolateBoiler();

    System.out.println("Boiler 1 Empty: " + boiler1.isEmpty());
    System.out.println("Boiler 2 Empty: " + boiler2.isEmpty());

    boiler1.fill();
    boiler1.boil();
    boiler1.drain();

    System.out.println("Boiler 1 Empty: " + boiler1.isEmpty());
    System.out.println("Boiler 2 Empty: " + boiler2.isEmpty());

    // 두 개의 객체가 서로 다른 인스턴스임을 확인합니다.
    System.out.println("Boiler 1 == Boiler 2: " + (boiler1 == boiler2)); // false
  }
}
