- [Strategy Pattern](#strategy-pattern)
- [Observer Pattern](#observer-pattern)
- [Factory Method Pattern](#factory-method-pattern)

# Strategy Pattern

### 실행 중에 알고리즘 전략을 선택하여 객체의 동작을 실시간으로 바뀌도록 할 수 있게 하는 행위 디자인 패턴.

알고리즘을 정의하고 캡슐화해서 클라이언트로부터 알고리즘을 분리해서 독립적으로 변경할 수 있음. 알고리즘 변형이 빈번할 경우 적합한 패턴. 

![Untitled](https://github.com/102sae/PDA-JavaPattern/assets/95170874/9d9e1188-0e9b-492c-8d1c-f8fbcaed6e7c)

전략 알고리즘의 기본 알고리즘 
```java
// 전략(추상화된 알고리즘)
interface IStrategy {
    void doSomething();
}

// 전략 알고리즘 A
class ConcreteStrateyA implements IStrategy {
    public void doSomething() {}
}

// 전략 알고리즘 B
class ConcreteStrateyB implements IStrategy {
    public void doSomething() {}
}
```

```java
// 컨텍스트(전략 등록/실행)
class Context {
    IStrategy Strategy; // 전략 인터페이스를 합성(composition)
	
    // 전략 교체 메소드
    void setStrategy(IStrategy Strategy) {
        this.Strategy = Strategy;
    }
	
    // 전략 실행 메소드
    void doSomething() {
        this.Strategy.doSomething();
    }
}
```

```java
// 클라이언트(전략 교체/전략 실행한 결과를 얻음)
class Client {
    public static void main(String[] args) {
        // 1. 컨텍스트 생성
        Context c = new Context();

        // 2. 전략 설정
        c.setStrategy(new ConcreteStrateyA());

        // 3. 전략 실행
        c.doSomething();

        // 4. 다른 전략 설정
        c.setStrategy(new ConcreteStrateyB());

        // 5. 다른 전략 시행
        c.doSomething();
    }
}
```

### 예시

모든 고양이가 meow하고 울기 때문에 슈퍼 클래스로 작성하고 각 고양이의 이름은 다르기 때문에 `display()`를 오버라이드를 함.
![Untitled (1)](https://github.com/102sae/PDA-JavaPattern/assets/95170874/55e372df-4938-48c6-9bc8-b67c21526aa0)

 이때 `eat()` 기능을 추가하면 먹지 못하는 고양이 인형 클래스에도 `eat` 기능이 추가 됨.

### 해결 방안

**방법 1. 상속 이용하기.**

![Untitled (2)](https://github.com/102sae/PDA-JavaPattern/assets/95170874/2f1f8e68-2a7a-4ae1-a366-15aba651d80b)

서브 클래스가 슈퍼 클래스의 일부, 혹은 전체 행위를 할 수 없어야 하는 경우에는 그 메소드를 오버라이드 하여 아무것도 하지 않도록 변경해야 한다. 이러면 서브 클래스에서 코드가 중복되고, 모든 고양이의 행동을 예측하기 힘들며, 실행 시에 특징을 변경하기 힘들기 때문에 좋은 해결책이 아니다. 


**방법 2. 인터페이스 이용하기.**

`display()`나` meow()`와 같은 공통된 성질 및 행위는 Cat이라는 슈퍼 클래스에 두고 상속받고, `eat()`과 같이 선택적인 기능은 interface로 정의한다. 그리고 그 기능이 필요한 고양이만 인터페이스를 구현한다. 
![Untitled (3)](https://github.com/102sae/PDA-JavaPattern/assets/95170874/4aa01aa4-02ec-47fa-9291-aeb8ad721c1f)


필요한 기능만 골라 사용할 수 있지만, `eat()` 메소드 코드를 재사용하지 못해서 코드의 중복이 발생한다. 그리고 `eat()`에 대한 행위의 변경 사항이 발생하면 하위 클래스 코드를 모두 변경해야한다는 문제가 발생한다. 

**💡프로그램은 항상 변하기 때문에 변하는 부분은 캡슐화하여 변하지 않은 부분으로부터 분리해야 한다.** 

**방법 3. Strategy Pattern 이용하기**

바뀌는 부분과 그렇지 않은 부분 분리하기. 

바뀌는 부분 : `eat()`과 `sleep()` → cat 클래스와 분리하여 메소드를 나타낼 클래스의 집합을 만들기.  

이제 `eat()`과 `sleep()`은 cat에서 구현하지 않음. 인터페이스를 이용하여 구현하는데 이 행동만을 목적으로 하는 클래스의 집합을 만들기. 

![Untitled (4)](https://github.com/102sae/PDA-JavaPattern/assets/95170874/99162907-bb78-4d38-8b3d-9b393f2db5f2)

이렇게 구현하면 기능을 재사용할 수 있음.

eat 행동을 cat 클래스에서 정의한 메소드를 써서 구현하지 않고 다른 클래스에 위임이 가능함. 

 
![Untitled (5)](https://github.com/102sae/PDA-JavaPattern/assets/95170874/dce99a28-a82b-4866-aef5-fd1083028ba5)
![Untitled (6)](https://github.com/102sae/PDA-JavaPattern/assets/95170874/cac969ef-2070-4766-9103-3a33ba544f84)

`eat()` 기능을 전략적으로 변경이 가능.


---
# Observer Pattern

객체들간의 일대다 의존 관계를 만들어 하나의 객체가 변하면 이 객체에 의존하는 객체들이 모두 알림을 받고 자동으로 업데이트 되는 방식으로 일대다 의존성을 정의하는 디자인 패턴.

신문사(주제) + 구독자(observer)

<img width="442" alt="Untitled (7)" src="https://github.com/102sae/PDA-JavaPattern/assets/95170874/95f009c6-a22b-4ba5-be28-3b2084aefff7">

주제와 옵저버는 일대다 관계. 주제의 상태가 바뀌면 옵저버에서 정보가 전달된다. 

### 홈런 기록원

<img width="506" alt="Untitled (8)" src="https://github.com/102sae/PDA-JavaPattern/assets/95170874/2e0e3163-cbe8-417c-95ed-7dae4d2b93a6">

홈런이 나올 때마다 datasChanged() 메소드가 호출됨.

HomerunData.java

```java
public HomerunData {
	public void datasChanged(){
		float exitVelocity = getVelocity();
		string pitch = getPitch();
		string count = getCount();

		currentConditionDisplay.update(exitVelocity, pitch, count);

} 
```

이 코드의 문제점은 홈런이 추가될 때마다 코드를 변경해야 되고, 인터페이스가 아닌 구현으로 코딩을 하고있기 때문에 변화되는 부분을 캡슐화하지 못한 코드라고 불 수 있다. 

**💡상호작용하는 객체 사이에는 가능하면 느슨한 결합(Loose Coupling)을 사용해야 함. 객체 사이의 상호 의존성을 최소화.**

옵서버 패턴을 적용하면,

- Subject 라는 데이터를 관리하는 단 하나의 대상을 두고 변경 시에만 동기화를 하여 Observer 들이 공유하도록 함
- 모든 대상이 데이터를 관리하지 않아도 됨


<img width="542" alt="Untitled (9)" src="https://github.com/102sae/PDA-JavaPattern/assets/95170874/041954a0-ef93-49ec-b9c1-46128aa3eb46">

### 옵저버 데이터 방식의 push vs pull

homerunData가 변경되어 세가지 중 하나만 갱신되는 상황에서도 update를 할때는 모든 데이터를 다시 보내야 한다. 여기서 공의 구속을 추가하게 되면 update 메소드에서는 구속 데이터를 사용하지 않더라도 모든 디스플레이에 있는 update 메소드를 바꿔야 한다.

### pull 방식으로 코드 변경

update의 메소드를 인자없이 호출하도록 수정

HomerunData.java

```java
// HomerunData.java
@Override
    public void notifyObservers() {
		/**
     * 등록된 옵저버들에게 업데이트를 통지합니다.
     */
        for(Observer observer: observers) {
            observer.update();
        }

    }
    
    
 /**
 * 주제(Subject)에서 발생한 변경 사항을 관찰하고 업데이트하는 인터페이스입니다.
 */
 // Observer.java
 public interface Observer {
/**
 * 주제(Subject)에서 발생한 변경 사항을 관찰하고 업데이트하는 인터페이스입니다.
 */
    void update();
}
```

CurrentConditionsDisplay.java

```java

import ObserverPattern.DisplayElement;
import ObserverPattern.Observer;
import ObserverPattern.HomerunData;

/**
 * 현재 상황을 표시하는 디스플레이 클래스입니다.
 * Observer 및 DisplayElement 인터페이스를 구현합니다.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float exitVelocity; // 타구의 출구 속도
    private String pitch; // 투구 구종
    private String count; // 볼 카운트
    private HomerunData homerunData; // 홈런 데이터

    /**
     * CurrentConditionsDisplay 객체를 생성합니다.
     * 
     * @param homerunData 홈런 데이터를 전달받는 생성자입니다.
     */
    public CurrentConditionsDisplay(HomerunData homerunData) {
        this.homerunData = homerunData;
    }

    /**
     * Observer 인터페이스의 update 메서드를 구현합니다.
     * 홈런 데이터를 업데이트하고, 디스플레이를 갱신합니다.
     */
    @Override
    public void update() {
        this.exitVelocity = homerunData.getVelocity();
        this.pitch = homerunData.getPitch();
        this.count = homerunData.getCount();

        display();
    }

    /**
     * DisplayElement 인터페이스의 display 메서드를 구현합니다.
     * 현재 상황을 출력합니다.
     */
    @Override
    public void display() {
        System.out.println("홈런 분석표: 타구 속도: " + exitVelocity + ", 구종: " + pitch + ", 볼 카운트: " + count);
    }
}
```

- 장점
    - 어떤 클래스이던간에 상관없이 Observer 인터페이스를 구현하기만 하면 데이터 변경 시 알림을 받을 수 있다
    - Subject 는 각 Observer 들이 실제로 어떤 클래스인지 알 필요 없이 일관된 인터페이스로 데이터 변경 알림을 줄 수 있다
    - 새로운 Observer 를 추가해야 하는 경우에도 Subject 는 코드의 변경 없이 이를 행할 수 있음

---

# Factory Method Pattern

인스턴스 생성을 하위클래스에 위임하여 유연하고 확장 가능한 구조를 구현하는 것.

객체를 생성할 때 필요한 인터페이스를 만들고 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정을 함. 

인스턴스의 생성 방법을 상위 클래스에서 결정하되, 구체적인 클래스의 이름까지는 결정하지 않음. ⇒ 인스턴스 생성을 위한 프레임워크 + 실제 인스턴스를 생성하는 클래스

### 예제

```java
class Bank{
    void issuanceCheck() {}
    void openAccount() {}
    void exchange() {}
}

class Shinhan extends Bank{}
class NH extends Bank{}
class KB extends Bank{}

class BankBranch{
    Bank Banking(String type) {
        Bank bank;

        if (type.equals("shinhan")) {
            bank= new Shinhan();
        } else if (type.equals("NH")) {
            bank= new NH();
        } else if (type.equals("KB")) {
            bank= new KB();
        }

        bank.issuanceCheck();
        bank.openAccount();
        bank.exchange();
        return bank;
    }
}
```

Bank는 수표 발행, 계좌 개설, 환전을 한다고 했을 때, 만약 NH가 아니라 Hana를 추가하고 싶다면 은행 종류가 바뀔때마다 코드를 계속 고쳐야 한다. → BankBranch 클래스가 은행 종류에 의존적인 상태. 

**💡 캡슐화가 필요!**

객체 생성을 처리하는 클래스를 Factory라고 함. 은행 객체를 생성.

```java
public class BankFactory{

    public Bank createBank(String type) {
        Bank bank= null;

        if (type.equals("Shinhan")) {
            bank= new Shinhan();
        } else if (type.equals("NH")) {
            bank= new NH();
        } else if(type.equals("KB")) {
            bank= new KB();
        } 
    return bank;,
    }
}
```

BankBranch.java

```java
class BankBranch{
		BankFactory factory;

    Bank Banking(String type) {
        Bank bank;

        bank = factory.createBank(type);

        bank.issuanceCheck();
        bank.openAccount();
        bank.exchange();
        return bank;
    }
}
```

<img width="516" alt="image" src="https://github.com/102sae/PDA-JavaPattern/assets/95170874/7a15e984-92de-46ec-8044-5687f49271e8">


이렇게 코드를 분리해주면 BankBranch는 더이상 Bank 클래스에 의존하지 않고, Banking에 집중할 수 있다.

### 의존성 뒤집기 원칙(Dependenct Inversion Principle)]

고수준 구성 요소(은행 지점)가 저수준 구성 요소(Account)에 의존하면 안되며, 항상 추상화에 의존하게 만들어야 함.
<img width="446" alt="Untitled (10)" src="https://github.com/102sae/PDA-JavaPattern/assets/95170874/9234d99e-9329-4256-96c1-e4ecb44e1a79">

모든 은행 객체를 직접 생성해야하므로, 은행 지점은 모든 은행 객체에 직접 의존하게 됨. 그리고 은행 클래스 구현이 변경되거나 은행을 추가하면 의존하는 객체때문에 수정이 불편함.

<img width="417" alt="Untitled (11)" src="https://github.com/102sae/PDA-JavaPattern/assets/95170874/173130e0-6e95-4d66-ad7e-4fc9840f653d">

팩토리 메소드 패턴을 적용하면 추상 클래스에 의존하게 됨. 
