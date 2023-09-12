package SingletonPattern.Example02.GoodCase;


/**
 * 초콜릿 보일러 클래스입니다. 초콜릿 보일러는 초콜릿을 만들기 위해 사용됩니다.
 */

/**
 * 변화 2: Thread-safe 버전의 Singleton 패턴 구현
 *
 * Before(BetterCase): 여러 개의 스레드에서 동시에 실행되면 항상 인스턴스가 1개만 생성된다는 점이 보장되지 않습니다.
 * After(GoodCase): locking 메커니즘을 제공해서 여러 개의 스레드에서 동시에 실행되어도 항상 인스턴스가 한개만 생성되도록 개선했습니다.
 *
 */
public class ChocolateBoiler {

  private boolean empty;
  private boolean boiled;

  private static ChocolateBoiler uniqueInstance;

  /**
   * 초콜릿 보일러 객체를 생성합니다.
   * 초콜릿 보일러는 초기에 비어있고 끓지 않은 상태로 생성됩니다.
   */
  private ChocolateBoiler(){
    empty = true;
    boiled = false;
  }

  /**
   * 초콜릿 보일러의 유일한 인스턴스를 반환합니다.
   * 이 메서드를 통해 항상 동일한 인스턴스를 얻을 수 있습니다.
   *
   * @return 초콜릿 보일러의 유일한 인스턴스
   */
  public static synchronized ChocolateBoiler getInstance(){
    if(uniqueInstance == null){
      uniqueInstance = new ChocolateBoiler();
    }
    return uniqueInstance;
  }

  /**
   * 보일러에 재료를 채웁니다.
   * 보일러가 비어있을 때만 동작합니다.
   */
  public synchronized void fill(){
    if(isEmpty()){
      empty = false;
      boiled = false;
    }
  }

  /**
   * 보일러의 내용물을 비웁니다.
   * 보일러가 차있고, 내용물이 끓지 않은 상태일 때 동작합니다.
   */
  public synchronized void drain(){
    if(!isEmpty() && !isBoiled()){
      empty = true;
    }
  }

  /**
   * 보일러의 내용물을 끓입니다.
   * 보일러가 차있고, 내용물이 끓지 않은 상태일 때 동작합니다.
   */
  public synchronized void boil(){
    if(!isEmpty() && !isBoiled()){
      boiled = true;
    }
  }

  /**
   * 보일러가 비어있는지 여부를 반환합니다.
   *
   * @return 보일러가 비어있으면 true, 그렇지 않으면 false
   */
  public synchronized boolean isEmpty(){
    return empty;
  }

  /**
   * 보일러의 내용물이 끓는지 여부를 반환합니다.
   *
   * @return 내용물이 끓으면 true, 그렇지 않으면 false
   */
  public synchronized boolean isBoiled(){
    return boiled;
  }
}

