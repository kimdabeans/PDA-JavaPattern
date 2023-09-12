package SingletonPattern.Example02.BadCase;


/**
 * 초콜릿 보일러 클래스입니다. 초콜릿 보일러는 초콜릿을 만들기 위해 사용됩니다.
 */
public class ChocolateBoiler {

  private boolean empty;
  private boolean boiled;


  /**
   * 초콜릿 보일러 객체를 생성합니다.
   * 초콜릿 보일러는 초기에 비어있고 끓지 않은 상태로 생성됩니다.
   */
  public ChocolateBoiler(){
    empty = true;
    boiled = false;
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
   * 보일러가 차있고, 내용물이 끓어있을 때만 동작합니다.
   */
  public void drain(){
    if(!isEmpty() && isBoiled()){
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
