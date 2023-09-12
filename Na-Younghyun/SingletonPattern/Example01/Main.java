package SingletonPattern.Example01;

/**
 * Singleton 클래스를 테스트하는 메인 클래스.
 */
public class Main {

  public static void main(String[] args) {

    Singleton obj1 = Singleton.getInstance();
    Singleton obj2 = Singleton.getInstance();

    if (obj1 == obj2) {
      System.out.println("obj1과 obj2는 같은 인스턴스이다.");
    } else {
      System.out.println("obj1과 obj2는 같은 인스턴스가 아니다.");
    }
  }
}