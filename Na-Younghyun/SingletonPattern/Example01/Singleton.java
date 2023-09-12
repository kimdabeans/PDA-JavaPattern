package SingletonPattern.Example01;

/**
 * 싱글톤 패턴(Singleton Pattern)을 구현한 클래스.
 * 이 클래스는 단 하나의 인스턴스만 생성하고, 그 인스턴스를 공유하는 패턴을 구현합니다.
 *
 * @author younghyun
 * @version 1.0
 */
public class Singleton {

  private static Singleton singleton = new Singleton();

  /**
   * 생성자는 private으로 선언되어 외부에서 직접 인스턴스를 생성할 수 없도록 합니다.
   */
  private Singleton() {
    System.out.println("인스턴스를 생성했습니다.");
  }

  /**
   * 유일한 인스턴스를 반환하는 정적 메서드입니다.
   *
   * @return 유일한 Singleton 인스턴스
   */
  public static Singleton getInstance() {
    return singleton;
  }
}

