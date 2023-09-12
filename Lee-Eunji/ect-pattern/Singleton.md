# Singleton Pattern

### 기본 클래스 다이어그램

<img src="https://github.com/eunsiver/shinhan-Design-Oattern/assets/76419984/2b0458d8-f331-4dac-92ea-f145b6dae365" width=200>

생성자 Singleton의 앞부분에 ~가 붙은 이유는 Singleton이 private임을 명시하기 위해서입니다.
또, getInstance에 밑줄이 있는 이유는 이 메소드가 static 메소드(클래스 메소드)이기 때문입니다.


### Singleton 클래스

#### 1. 초기화
Singleton클래스는 인스턴스를 하나만 만들 수 있는, Singleton은 static 필드로 정의되고 Singleton 클래스의 인스턴스에서 초기화합니다.
초기화는 Singleton 클래스를 로드할 때 한 번만 실행됩니다.

#### 2. private 생성자
Singleton 클래스의 생성자는 private로 되어 있습니다. 이는 Singleton 클래스 외부에서 생성자 호출을 금지하기 위해서입니다.
만약, `new Singleton()`과 같은 코드가 이 클래스 외부에 있어도 컴파일할때 에러가 발생합니다.

처음부터 프로그래머가 주의해서 new 하지 않도록 해주면, 생성자를 private로 할 필요는 없습니다. 하지만 Singleton 패턴은 프로그래머가 어떤 실수를 하더라도 인스턴스가 하나만 생성되는 것을 보증하는 패턴입니다.
이 보증을 위해 생성자를 private로 해 두는 것입니다. 

#### 3. getInstance
Sinleton 클래스의 유일한 인스턴스를 얻는 메소드로 getInstance가 제공됩니다. 이 getInstance는 static Factory Method의 일종입니다. 


### Singleton 코드

```java
public class Singleton{
  private static Singleton singleton = new Singleton();

  // 생성자는 외부에서 호출하지 못하게 private으로 지정해야 한다.
  private Singleton(){
    System.out.println("인스턴스를 생성했습니다.");
  }

  public static Singleton getInstance(){
    return singleton;
  }
}
```
위와 같이 초기에 인스턴스를 생성하게 된다면 multi-thread 환경에서도 다른 객체들은 getInstance를 통해 하나의 인스턴스를 공유할 수 있습니다.

```java
public class Main{
  public static void main(String[] args){

    System.out.println("Start.");
    Singleton obj1 = Singleton.getInstance();
    Singleton obj2 = Singleton.getInstance();

    if(obj1 == obj2){
      System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
    }
    else{
      System.out.println("obj1과 obj2는 같은 인스턴스가 아닙니다.");
    }
    System.out.println("End.");
  }
}
```

결과는 다음과 같다.
```
Start.
인스턴스를 생성했습니다.
obj1과 obj2는 같은 인스턴스입니다.
End.
```

### 유일한 인스턴스는 언제 생성될까?
실행 결과를 주의 깊게 보면, 'Start.'라고 표시한 다음 '인스턴스를 생성했습니다.'라고 표시된 것을 알 수 있다. 프로그램 실행 후 처음 getInstance 메소드를 호출할 때, Singleton 인스턴스가 초기화됩니다. 그리고 이때 static 필드가 초기화되며 유일한 인스턴스가 만들어집니다. 

### enum을 이용한 Singleton
enum의 요소는 상수로서 인스턴스의 유일성을 보증받습니다. 예를 들어, java.time.Month.APRIL은 달력의 4월을 나타내는 인스턴스이자 시스템에서 유일한 인스턴스입니다. 그러므로 요소를 하나만 가지는 enum을 이용하여 다음과 같이 Singleton 패턴을 구현할 수 있습니다.

```java
enum Singleton{
  INSTANCE;
  public void hello(){  
    System.out.println("hello is called.");
  }
}
```
이때 유일한 인스턴스는 Singleton.Instance라는 식으로 액세스할 수 있습니다. hello 메소드를 호출하는 구문은 다음과 같습니다.
```java
Singleton.Instance.hello();
```

### 관련 패턴
다음 패턴에서는 Singleton 패턴이 사용될 수 있습니다.
* Abstract Factory 패턴
* Builder 패턴
* Factory 패턴
* Flyweigth 패턴
* Prototype 패턴
* State 패턴


### 사용 시기 
+ 지정한 클래스의 인스턴스가 반드시 1개만 존재한다는 것을 보증하고 싶을때
+ 프로그램 내에서 여러 부분에서 해당 객체를 공유하여 사용해야 할때
+ 객체가 **리소스를 많이 차지하는 역할을 하는 무거운 클래스일때**

> 데이터베이스 연결 모듈, 디스크 연결, 네트워크 통신, DBCP 커넥션풀, 스레드풀, 캐시, 로그 기록 객체 등에 이용된다. 

### 싱글톤 패턴의 이점
+ 메모리 측면의 이점
싱글톤 패턴을 사용하게 된다면 한개의 인스턴스만을 고정 메모리 영역에 생성하고 추후 해당 객체를 접근할 때 **메모리 낭비를 방지**할 수 있습니다.
+ 속도 측면의 이점
생성된 인스턴스를 사용할 때는 **이미 생성된 인스턴스를 활용하여 속도 측면에 이점**이 있습니다.
+ 데이터 공유가 쉽다
전역으로 사용하는 인스턴스이기 때문에 다른 여러 클래스에서 데이터를 **공유하며 사용**할 수 있습니다. 하지만 **동시성 문제가 발생**할 수 있어 이 점은 유의하여 설계하여야 합니다.

### 싱글톤 패턴의 문제점

- **테스트하기 어렵다는 것입니다.**
  싱글톤 인스턴스는 자원을 공유하고 있기 때문에 테스트가 결정적으로 격리된 환경에서 수행되려면 매번 인스턴스의 상태를 초기화시켜주어야 합니다. 그렇지 않으면 어플리케이션 전역에서 상태를 공유하기 때문에 테스트가 온전하게 수행되지 못합니다.

- 의존 관계상 클라이언트가 구체 클래스에 의존하게 됩니다. new 키워드를 직접 사용하여 클래스 안에서 객체를 생성하고 있으므로, 이는 **SOLID 원칙 중 DIP를 위반하게 되고 OCP 원칙 또한 위반할 가능성이 높**습니다.

- **모듈간 의존성이 높**아집니다.
  대부분의 싱글톤을 이용하는 경우 인터페이스가 아닌 클래스의 객체를 미리 생성하고 정적 메소드를 이용해 사용하기 때문에 클래스 사이에 강한 의존성과 높은 결합이 생기게 됩니다.
  즉, 하나의 싱글톤 클래스를 여러 모듈들이 공유를 하니까, 만일 싱글톤의 인스턴스가 변경되면 이를 참조하는 모듈들도 수정이 필요하게 됩니다.
  또한 클라이언트 코드에서 너무 많은 곳에서 사용하면 클래스간의 결합도가 높아져 오히려 패턴을 사용 안하느니만 못하게 될 수도 있습니다.

- 이외에도 자식클래스를 만들수 없다는 점과, 내부 상태를 변경하기 어렵다는 점 등 여러가지 문제들이 존재재합니다. 결과적으로 이러한 문제들을 안고있는 싱글톤 패턴은 유연성이 많이 떨어지는 패턴이라고 할 수 있습니다.

> 따라서 직접 유저가 만들어 사용하는 것 보다는, **스프링 컨테이너 같은 프레임워크**의 도움을 받으면 싱글톤 패턴의 문제점들을 보완하면서 장점의 혜택을 누릴 수 있습니다.
스프링 프레임워크에서는 **싱글톤 패턴이란게 없고 내부적으로 클래스의 제어를 Ioc(Inversion Of Control) 방식의 컨테이너에게 넘겨 컨테이너가 관리**하기 때문에, 이를 통해 **평범한 객체도 하나의 인스턴스 뿐인 싱글턴으로 존재가 가능**하기 때문에 싱글톤 단점이 없습니다.


##### 참고 문헌
+ https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%EC%8B%B1%EA%B8%80%ED%86%A4Singleton-%ED%8C%A8%ED%84%B4-%EA%BC%BC%EA%BC%BC%ED%95%98%EA%B2%8C-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90
+ https://tecoble.techcourse.co.kr/post/2020-11-07-singleton/
  
