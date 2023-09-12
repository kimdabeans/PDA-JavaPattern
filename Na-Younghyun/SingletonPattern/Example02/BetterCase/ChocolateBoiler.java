package SingletonPattern.Example02.BetterCase;

/**
 * 변화 1: 추가적인 메서드 - Singleton 패턴 구현
 *
 * Before(BadCase): 다중 인스턴스 생성으로 상태 불일치가 일어날 가능성이 있습니다.
 * After(BetterCase): Singleton 패턴을 도입하여, ChocolateBoiler 인스턴스를 오직 하나만 생성하고 여러 곳에서 공유할 수 있도록 개선했습니다.
 *
 */
public class ChocolateBoiler {

  private boolean empty;
  private boolean boiled;

  // ChocolateBoiler의 유일한 인스턴스
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
  public static ChocolateBoiler getInstance(){
    if(uniqueInstance == null){
      uniqueInstance = new ChocolateBoiler();
    }
    return uniqueInstance;
  }


  /**
   * 보일러에 재료를 채웁니다.
   * 보일러가 비어있을 때만 동작합니다.
   */
  public void fill(){
    if(isEmpty()){
      empty = false;
      boiled = false;
    }
  }

  /**
   * 보일러의 내용물을 비웁니다.
   * 보일러가 차있고, 내용물이 끓지 않은 상태일 때 동작합니다.
   */
  public void drain(){
    if(!isEmpty() && !isBoiled()){
      empty = true;
    }
  }

  /**
   * 보일러의 내용물을 끓입니다.
   * 보일러가 차있고, 내용물이 끓지 않은 상태일 때 동작합니다.
   */
  public void boil(){
    if(!isEmpty() && !isBoiled()){
      boiled = true;
    }
  }

  /**
   * 보일러가 비어있는지 여부를 반환합니다.
   *
   * @return 보일러가 비어있으면 true, 그렇지 않으면 false
   */
  public boolean isEmpty(){
    return empty;
  }

  /**
   * 보일러의 내용물이 끓는지 여부를 반환합니다.
   *
   * @return 내용물이 끓으면 true, 그렇지 않으면 false
   */
  public boolean isBoiled(){
    return boiled;
  }
}
