## 사용한 디자인 패턴

1. Factory Method Pattern
2. Abstract Factory Pattern
3. SingleTon Pattern 

이번 과제에서 공부한 패턴은 위와 같다.

먼저 수업 시간에 Factory Method 패턴에 대해 다루며 Abstract Factory 패턴과 어떤 차이가 있는지 궁금했고,

각 패턴은 어떤 특징이 있으며 어떠한 상황에서 Factory Method 패턴 혹은 Abstract Factory 패턴을 쓰는지에 대해 고민해보며 정리하였다.

다음으로 디자인 패턴 중 가장 널리 쓰이는 패턴인 SingleTon Pattern에 대해 공부하며 싱글톤 패턴을 구현하는 방법에 여러 가지가 있음을 알 수 있었다. 따라서 이번 과제를 통해 각 방법은 어떠한 차이가 있고 장단점이 무엇인지에 대해 학습해보며 정리하였다. 

Readme에 첨부한 코드들은 간략한 설명만 포함되어 있으며, javadoc은 Git에 첨부한 코드를 통해 확인하실 수 있습니다. 

## 0. Simple Factory Pattern

팩토리 패턴에는 Factory Method 패턴과 Abstract Factory 패턴이 있다. 

이 두가지 패턴에 앞서 Simple Factory 패턴에 대해 정리하였다.

Simple Factory Pattern은 간단히 말해 객체를 생성하는 클래스를 따로 두는 패턴을 말한다.

factory_pattern 패키지의 SimplePhoneFactory 클래스를 보면 createPhone 메서드의 switch문를 통해 클라이언트가 주문할 휴대폰의 객체를 직접 생성하는 것을 볼 수 있다.

![image](https://github.com/wnsdnjs70/PDA-JavaPattern/assets/43106344/e640dbe3-7e45-4443-a490-c435f2e33c1b)


**심플 팩토리 패턴은 단순히 객체를 만드는 작업을 하나의 팩토리 클래스에 모아두는 것을 의미한다.**

```java
//휴대폰을 만드는 공장인 SimplePhoneFactory
public class SimplePhoneFactory {
    public Phone orderPhone(String type) {
        Phone phone = createPhone(type);
        phone.complete();
        return phone;
    }
    private Phone createPhone(String type) {
        return switch (type) {
            case "IPHONE" -> new IPhone();
            case "ANDROID" -> new AndroidPhone();
            default -> null;
        };
    }
}

//휴대폰 인터페이스
public interface Phone {
    void complete();
    void call();
}

//아이폰
public class IPhone implements Phone{
    @Override
    public void complete() {
        System.out.println("아이폰 완성");
    }

    @Override
    public void call() {
        System.out.println("아이폰으로 전화를 한다");
    }
}

//안드로이드 폰
public class AndroidPhone implements Phone{
    @Override
    public void complete() {
        System.out.println("안드로이드폰 완성");
    }

    @Override
    public void call() {
        System.out.println("안드로이드폰으로 전화를 한다");
    }
}

//클라이언트는 휴대폰 공장에 휴대폰을 주문한다.
public class SimpleFactoryClient{
    public static void main(String[] args){

        SimplePhoneFactory simplePhoneFactory = new SimplePhoneFactory();

        Phone iPhone = simplePhoneFactory.orderPhone("ANDROID");
				iPhone.call();

				Phone androidPhone = simplePhoneFactory.orderPhone("IPHONE");
        androidPhone.call();
    }
}

// 실행 결과
안드로이드폰 완성
안드로이드폰으로 전화를 한다
```

## 1. Factory Pattern (Before)

팩토리 메소드 패턴의 정의는 아래과 같다.

> 객체를 생성하기 위한 인터페이스를 정의하는 과정에서 어떤 클래스의 인스턴스를 만들지는 서브 클래스에서 결정한다.
> 

즉, 클래스의 인스턴스를 만드는 일을 서브클래스에게 맡기는 것이다.

다시 말해 심플 팩토리 패턴의 createPhone() 부분에서 Factory에서 직접 객체를 만드는 것을 Factory를 상속한 서브 클래스에서 객체를 만들게끔 하는 것이 팩토리 메소드 패턴이다.

![image](https://github.com/wnsdnjs70/PDA-JavaPattern/assets/43106344/f5e5a563-b998-4958-8d8c-aa267d591bc5)


![image](https://github.com/wnsdnjs70/PDA-JavaPattern/assets/43106344/311f04fb-094e-4ebc-b88b-3a7b8c033809)


**작성한 코드의 UML 다이어그램과 팩토리 메서드 패턴의 UML을 매핑해보면 아래와 같다.**

PhoneFactory : Creator

AndroidPhoneFactory, IPhoneFactory : ConcreteCreator

AndroidPhone, IPhone : Product

먼저 Framework 패키지는 추상화 레벨이 높은 패키지로 휴대폰을 생성할 수 있는 공장인 PhoneFactory 인터페이스와 휴대폰의 기능을 정의하고 있는 Phone 인터페이스가 위치한다. 

PhoneFactory 인터페이스는 내부 메서드를 통해 Phone을 생성하고 있다. 

Concrete 패키지는 Framework 패키지의 인터페이스들을 구현한 구현체들이 모인 패키지로 PhoneFactory 인터페이스를 구현한 AndroidPhoneFactory, IPhoneFactory로 구성되어 있고,

이들은 각각 Phone 인터페이스를 구현한 AndroidPhone과 IPhone을 생성하고 있다. 

```java
// 휴대폰을 생성하는 기능을 담은 PhoneFactory 인터페이스
public interface PhoneFactory {
    Phone orderPhone();
    Phone createPhone();
}

// PhoneFactory를 구현해 아이폰을 생성하는 IPhoneFactory 클래스
public class IPhoneFactory implements PhoneFactory {
    @Override
		public Phone orderPhone() {
			Phone phone = createPhone();
			phone.complete();
			return phone;
		}
		@Override
    public Phone createPhone() {
        return new IPhone();
    }
}

// PhoneFactory를 구현해 안드로이드폰을 생성하는 AndroidPhoneFactory 클래스
public class AndroidPhoneFactory implements PhoneFactory {
    @Override
		public Phone orderPhone() {
			Phone phone = createPhone();
			phone.complete();
			return phone;
		}
		@Override
    public Phone createPhone() {
        return new AndroidPhone();
    }
}

// 휴대폰의 기능을 정의한 Phone 인터페이스
public interface Phone {
    void complete();
    void call();
}
// Phone 인터페이스를 구현해 아이폰의 기능을 구현한 IPhone 클래스
public class IPhone implements Phone{
    @Override
    public void complete() { System.out.println("아이폰 완성"); }
    @Override
    public void call() { System.out.println("아이폰으로 전화를 한다"); }
}
// Phone 인터페이스를 구현해 안드로이드폰의 기능을 구현한 AndroidPhone 클래스
public class AndroidPhone implements Phone{
    @Override
    public void complete() {System.out.println("안드로이드폰 완성");}
    @Override
    public void call() {System.out.println("안드로이드폰으로 전화를 한다");}
}
// 클라이언트가 휴대폰을 주문하는 FactoryPatternClient 클래스
public class Practice {
    public static void main(String[] args){
        IPhoneFactory iPhoneFactory = new IPhoneFactory();
        Phone iPhone= iPhoneFactory.orderPhone();
        iPhone.call();

        AndroidPhoneFactory androidPhoneFactory = new AndroidPhoneFactory();
        Phone androidPhone= androidPhoneFactory.orderPhone();
        androidPhone.call();
    }
}

// 실행 결과
아이폰 완성
아이폰으로 전화를 한다
안드로이드폰 완성
안드로이드폰으로 전화를 한다
```

### Simple Factory Method  vs  Factory Method

- 휴대폰 객체를 직접 생성하는 SimplePhoneFactory 클래스를 인터페이스화 했다.
- 구현체로 IPhoneFactory, AndroidPhoneFactory를 만들어 해당 클래스의 createPhone() 메서드를 통해 각자의 Factory에서 Phone 인터페이스의 구현체인 IPhone과 AndroidPhone을 만들었다.
- 이를 통해 서브클래스(IPhoneFactory,AndroidPhoneFactory)에서 어떤 객체를 생성할지 결정할 수 있어야 한다는 **팩토리 메서드 패턴의 정의를 충족할 수 있다.**
- 이런 구조를 가지면 앞으로 휴대폰의 종류가 여러개로 늘어난다 해도 Phone 인터페이스의 구현체만 따로 생성하고, createPhone() 메서드의 분기 처리만 해줌으로써 확장에 열려있는 구조가 된다.
- 즉, **팩토리 메서드 패턴을 통해  OCP(개방 폐쇄의 원칙 : Open Close Principle)를 만족할 수 있다.**

### Factory Method Pattern의 장점

Factory Method Pattern에 대해 공부하고 코드를 작성해보고, UML을 그려보며 파악한 팩토리 메서드 패턴의 장점은 아래와 같다. 

- 생성자(Creator)와 구현 객체(concrete product)의 강한 결합을 피할 수 있다.
- 팩토리 메서드를 통해 객체의 생성 후 공통으로 할 일을 수행하도록 지정해줄 수 있다.
- 캡슐화, 추상화를 통해 생성되는 객체의 구체적인 타입을 감출 수 있다.
- SRP(단일 책임 원칙) 준수 : 객체 생성 코드를 한 곳 (패키지, 클래스 등)으로 이동하여 코드를 유지보수하기 쉽게 할수 있으므로 단일 책임 원칙을 만족할 수 있다.
- OCP(개방/폐쇄 원칙) 준수 : 기존 코드를 수정하지 않고 새로운 유형의 제품 인스턴스를 프로그램에 도입할 수 있어 개방 폐쇄 원칙을 만족할 수 있다.
- 생성에 대한 인터페이스 부분과 생성에 대한 구현 부분을 따로 나뉘었기 때문에 패키지를 분리하여 여러 개발자가 개별적으로 협업할 수 있다.

### Factory Method Pattern의 사용 시기

패턴에 대해 공부하며 어떠한 상황에서 해당 패턴을 사용해야 실질적인 효과를 볼 수 있을지 생각해 보았다. 

- 클래스 생성과 사용의 처리 로직을 분리하여 결합도를 낮추고자 하는 경우
- 코드가 동작해야 하는 객체의 유형과 종속성을 캡슐화를 통해 정보 은닉 처리 할 경우
- 라이브러리 혹은 프레임워크 사용자에게 구성 요소를 확장하는 방법을 제공하려는 경우
- 기존 객체를 재구성하는 대신 기존 객체를 재사용하여 리소스를 절약하고자 하는 경우

## 2. Abstract Factory Pattern (After)

앞서 살펴본 Factory Method Pattern은 OCP, SRP를 만족하는 구조를 가지고 있었다. 

하지만 휴대폰 팩토리에서 다양한 조합의 제품을 만들어야 할 때 기존의 팩토리 메서드 패턴은 유용하지 않다. 예를 들어 휴대폰을 만들 때 애플의 공장에서는 아이폰을 만들고 아이폰에 들어가는 프로세서에는 IOS를 설치해야 한다고 가정해 보자, 혹은 삼성의 공장에서는 안드로이드 폰을 만들고 폰에 들어가는 프로세서는 구글의 OS를 설치해야 한다고 생각해보자. 

이러한 상황에서 기존의 팩토리 메서드를 사용하면 여러 구체화 클래스를 선택할 수 없다. 이러한 상황을 해결할 수 있는 방법이 바로 Abstract Factory Pattern이다. 

추상 팩토리 패턴의 정의는 아래와 같다. 

> 구체적인 클래스에 의존하지 않고 서로 연관되거나 의존적인 객체들의 조합을 만드는 인터페이스를 제공하는 패턴
> 

앞서 기술한 `메소드 팩토리 패턴`에서는 `PhoneFactory` 인터페이스의 구현체인 `IPhoneFactory`, `AndroidPhoneFactory` 클래스가 각각 IPhone, Android 객체 하나씩을 생성하는 구조였다. 

**추상 팩토리 패턴은** **이러한 구조를 한 번 더 감싸서 하나의 Factory에서 여러개의 제품군(Product)조합을 생성할 수 있게 해주는 패턴이다.**

![image](https://github.com/wnsdnjs70/PDA-JavaPattern/assets/43106344/2ee63498-331c-4a4c-a745-cbdf5f3300e4)

추상 팩토리 패턴의 개념적 구조를 UML로 나타내어 보았다. 

- **AbstractFactory** : 최상위 공장 클래스. 여러개의 제품들을 생성하는 여러 메소드들을 추상화 함.
- **ConcreteFactory** : 서브 공장 클래스들은 타입에 맞는 제품 객체를 반환하도록 메소드들을 재정의한다.
- **AbstractProduct** : 각 타입의 제품들을 추상화한 인터페이스
- **ConcreteProduct (ProductA ~ ProductB)** : 각 타입의 제품 구현체들. 이들은 팩토리 객체로부터 생성된다.
- **Client** : Client는 추상화된 인터페이스만을 이용하여 제품을 받기 때문에, 구체적인 제품, 공장에 대해서는 모른다.

![image](https://github.com/wnsdnjs70/PDA-JavaPattern/assets/43106344/d2a5c2a9-1ef8-47ab-8c74-0a5c0e1bdc6d)


위는 추상 팩토리 패턴의 구조를 적용해 팩터리 메서드 패턴을 개선한 UML이다. 

Framework 패키지에는 추상화 레벨이 높은 인터페이스들이 위치하며 Concrete 패키지에는 이러한 인터페이스들을 구현한 구현체들이 속해 있다.

먼저 OS, Phone 인터페이스는 각각 OS와 휴대폰의 기능을 정의하고 있다. 이러한 개별 Product를 선택해 휴대폰을 만들 수 있는 휴대폰 공장의 역할을 수행하는 PhoneFactory가 OS, Phone 인터페이스를 생성하고 있고, 어떠한 휴대폰을 만들 것인지 클라이언트의 요청을 받아 적절한 휴대폰 공장을 생성하는 PhoneFactoryOfFactory라 PhoneFactory를 생성하고 있다. 

다음으로 PhoneFactoryOfFactory 인터페이스를 구현한 DefaultFactoryOfFactory 클래스가 각각 AndroidPhoneFactory와 IPhoneFactory를 생성하고 있고, 이들은 GoogleOS, IOS, AndroidPhone, IPhone 등의 적절한 Product 들을 조합해 휴대폰을 생성할 수 있다. 

아래는 아이폰에 IOS를, 안드로이드 폰에 GoogleOS를 설치해야 한다는 요구사항이 추가된 경우에 기존의 팩토리 메서드 패턴을 추상 팩토리 패턴으로 개선한 코드이다. 

```java
// 휴대폰을 생성하는 PhoneFactory를 한 번 더 감싼 PhoneFactoryOfFactory 인터페이스
public interface PhoneFactoryOfFactory {
    PhoneFactory requestPhone(String company);
}
// PhoneFactoryOfFactory 인터페이스를 구현해 적절한 팩토리를 리턴하는 클래스
public class DefaultPhoneFactoryOfFactory implements PhoneFactoryOfFactory{
    @Override
    public PhoneFactory requestPhone(String company) {
        switch (company) {
            case "IPHONE":
                return new IPhoneFactory();
            case "ANDROID":
                return new AndroidPhoneFactory();
        }
        throw new IllegalArgumentException();
    }
}
// 휴대폰을 생성하는 기능을 담은 PhoneFactory 인터페이스 
public interface PhoneFactory {
    Phone createPhone();
    OS createOS();
}
// PhoneFactory 인터페이스를 구현해 아이폰을 생성하는 IPhoneFactory
public class IPhoneFactory implements PhoneFactory{
    @Override
    public Phone createPhone() {
        OS os = createOS();
        os.installOS();
        return new IPhone();
    }
    @Override
    public OS createOS() {
        return new IOS();
    }
}
// PhoneFactory 인터페이스를 구현해 안드로이드폰을 생성하는 AndroidPhoneFactory
public class AndroidPhoneFactory implements PhoneFactory{
    @Override
    public Phone createPhone() {
        OS os = createOS();
        os.installOS();
        return new AndroidPhone();
    }
    @Override
    public OS createOS() {
        return new GoogleOS();
    }
}
// OS를 설치하는 기능을 담은 OS 인터페이스 
public interface OS {
    void installOS();
}
// OS 인터페이스를 구현한 IOS 클래스 
public class IOS implements OS {
    @Override
    public void installOS() {
        System.out.println("IOS 설치");
    }
}
// OS 인터페이스를 구현한 GoogleOS 클래스 
public class GoogleOS implements OS {
    @Override
    public void installOS() {
        System.out.println("구글OS 설치");
    }
}
// 휴대폰의 기능을 담은 Phone 인터페이스 
public interface Phone {
    public void call();
    public void playGame();
}
// Phone 인터페이스를 구현한 IPhone 클래스
public class IPhone implements Phone{
    @Override
    public void call() {
        System.out.println("아이폰으로 전화하다");
    }
    @Override
    public void playGame() {
        System.out.println("아이폰으로 게임하다");
    }
}
// Phone 인터페이스를 구현한 AndriodPhone 클래스 
public class AndroidPhone implements Phone{
    @Override
    public void call() {
        System.out.println("안드로이드로 전화하다");
    }
    @Override
    public void playGame() {
        System.out.println("안드로이드로 게임하다");
    }
}

public class AbstractFactoryClient {
    public static void main(String[] args) {

        PhoneFactoryOfFactory phoneFactoryOfFactory = new DefaultPhoneFactoryOfFactory();
        
				PhoneFactory iphoneFactory= phoneFactoryOfFactory.requestPhone("IPHONE");   //아이폰을 산다.
        Phone iphone = iphoneFactory.createPhone();
        iphone.call();
        iphone.playGame();

        PhoneFactory androidPhoneFactory = phoneFactoryOfFactory.requestPhone("ANDROID");   //안드로이드폰을 산다.
        Phone androidPhone = androidPhoneFactory.createPhone();
        androidPhone.call();
        androidPhone.playGame();

    }
}

// 실행 결과
IOS 설치
아이폰으로 전화하다
아이폰으로 게임하다
구글OS 설치
안드로이드로 전화하다
안드로이드로 게임하다
```

코드를 보면 `PhoneFactory`에서 `Phone`과 `OS`를 생성할 수 있는데 `IPhoneFactory`는 `IPhone`과 `IOS`조합으로 객체를 생성할 수 있고, `AndroidPhoneFactory`는 `AndroidPhone`과 `GoogleOS`조합으로 객체를 생성할 수 있다. **즉, PhoneFactory는 Phone과 OS를 조합하는 구현체를 제공한다.** 

이처럼 추상 팩토리 패턴을 활용하면 여러 구현체를 조합해 원하는 Product를 만들 수 있다. 

코드를 작성해보며 느낀 **추상 팩토리 패턴의 장점은 아래와 같다.** 

- 구체적인 클래스를 사용자로부터 **분리**할 수 있다.
- 사용자가 사용할 때는 정의된 인터페이스에 정의된 추상 메서드를 사용만 하면 된다.
- 제품군을 쉽게 대체할 수 있다.
    - 만약 iPhone 대신 블랙베리 폰을 생성하고 싶다면 BlackBerry 클래스를 구현 후 IPhoneFactory 클래스를 BlackBerryFactory 클래스로 변경만 하면 된다.
- 객체를 생성하는 코드를 분리해 클라이언트 코드와 결합도를 낮출 수 있다.
- SRP, OCP 를 준수할 수 있다.

### 추상 팩토리 패턴의 사용 시기

코드를 작성해보며 추상 팩토리 패턴을 언제 어떻게 사용해야 하는지에 대해서 고민하여 정리해보았다. 

- 관련 제품의 다양한 제품 군과 함께 작동해야 할때, 해당 제품의 구체적인 클래스에 의존하고 싶지 않은 경우
- 여러 제품군 중 하나를 선택해서 시스템을 설정해야하고 한 번 구성한 제품을 다른 것으로 대체할 수도 있을 때
- 제품에 대한 클래스 라이브러리를 제공하고, 그들의 구현이 아닌 인터페이스를 노출시키고 싶을 때

## 3. SingleTon Pattern

**싱글톤 패턴**이란 **단 하나의 유일한 객체를 만들기 위한** 코드 패턴이다.

쉽게 말하자면 **메모리 절약**을 위해, 인스턴스가 필요할 때 똑같은 인스턴스를 **새로 만들지 않고 기존의 인스턴스를 가져와 활용**하는 기법을 말한다.

보통 싱글톤 패턴이 적용된 객체가 필요한 경우는 그 객체가 **리소스를 많이 차지하는 역할**을 하는 무거운 클래스일때 적합하다.

아래는 싱글톤 패턴을 구현한 UML이다. 

![image](https://github.com/wnsdnjs70/PDA-JavaPattern/assets/43106344/0d552d05-9c77-4735-ac9e-3f954c4eda16)


싱글톤 패턴을 구현하는 방법은 다음과 같다. 

- 외부에서 마구잡이로 new 생성자를 통해 인스턴스화 하는 것을 제한하기 위해 클래스 생성자 메서드에 private 키워드를 붙여주면 된다.
- getInstance() 메서드에 생성자 초기화를 하여 클라이언트가 싱글톤 클래스를 생성해서 사용하려면 getInstance() 메서드를 통해 객체를 반환한다.

아래에는 싱글톤을 구현하는 다양한 방법들에 대해 나열해보았다. 

### 3-1. **Eager Initialization**

- 한번만 미리 만들어두는, 가장 직관적이면서도 심플한 기법이다.
- static final 이라 멀티 쓰레드 환경에서도 안전하다.
- 그러나 static 멤버는 당장 객체를 사용하지 않더라도 메모리에 적재하기 때문에 만일 리소스가 큰 객체일 경우, 공간 자원 낭비가 발생하다.
- 예외 처리를 할 수 없다.

```java
class Singleton {
    // 싱글톤 클래스 객체를 담을 인스턴스 변수
    private static final Singleton INSTANCE = new Singleton();

    // 생성자를 private로 선언 (외부에서 new 사용 X)
    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

### 3-2. **Static block initialization**

- static block 을 이용해 예외를 잡을 수 있다.
- 그러나 여전히 static 의 특성으로 사용하지도 않는데도 공간을 차지한다.

```java
class Singleton {
    // 싱글톤 클래스 객체를 담을 인스턴스 변수
    private static Singleton instance;

    // 생성자를 private로 선언 (외부에서 new 사용 X)
    private Singleton() {}
    
    // static 블록을 이용해 예외 처리
    static {
        try {
            instance = new Singleton();
        } catch (Exception e) {
            throw new RuntimeException("싱글톤 객체 생성 오류");
        }
    }

    public static Singleton getInstance() {
        return instance;
    }
}
```

### 3-3. **Lazy initialization**

- 객체 생성에 대한 관리를 내부적으로 처리
- 메서드를 호출했을 때 인스턴스 변수의 null 유무에 따라 초기화 하거나 있는 걸 반환하는 기법
- 위의 미사용 고정 메모리 차지의 한계점을 극복
- 그러나 쓰레드 세이프(Thread Safe) 하지 않는 치명적인 단점을 가지고 있음 (아래 설명)

```java
class Singleton {
    // 싱글톤 클래스 객체를 담을 인스턴스 변수
    private static Singleton instance;

    // 생성자를 private로 선언 (외부에서 new 사용 X)
    private Singleton() {}
	
    // 외부에서 정적 메서드를 호출하면 그제서야 초기화 진행 (lazy)
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // 오직 1개의 객체만 생성
        }
        return instance;
    }
}
```

### 3-4. **Bill Pugh Solution (LazyHolder)**

- 가장 안전하고 효율적인 방법 중 하나이다.
- 멀티쓰레드 환경에서 안전하고 Lazy Loading도 가능한 완벽한 싱글톤 기법이다.
- 클래스 안에 내부 클래스(holder)를 두어 JVM의 클래스 로더 매커니즘과 클래스가 로드되는 시점을 이용한 방법 → Thread Safe하다.
- static 메소드에서는 static 멤버만을 호출할 수 있기 때문에 내부 클래스를 static으로 설정한다.
- 내부 클래스의 메모리 누수 문제를 해결하기 위하여 내부 클래스를 static으로 설정한다.
- 다만 클라이언트가 임의로 싱글톤을 파괴할 수 있다는 단점이 있다.

```java
class Singleton {

    private Singleton() {}

    // static 내부 클래스를 이용
    // Holder로 만들어, 클래스가 메모리에 로드되지 않고 getInstance 메서드가 호출되어야 로드됨
    private static class SingleInstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }
}
```

### 3-5. **Enum 이용**

- 가장 안전하고 효율적인 방법 중 하나이다.
- enum은 애초에 멤버를 만들때 private로 만들고 한번만 초기화 하기 때문에 thread safe하다.
- enum 내에서 상수 뿐만 아니라, 변수나 메서드를 선언해 사용이 가능하기 때문에, 이를 이용해 싱글톤 클래스 처럼 응용이 가능하다.
- 위의 Bill Pugh Solution 기법과 달리, 클라이언트에서 Reflection을 통한 공격에도 안전하다.
- 하지만 만일 싱글톤 클래스를 멀티톤(일반적인 클래스)로 마이그레이션 해야할때 처음부터 코드를 다시 짜야 되는 단점이 존재한다.
- 클래스의 상속이 필요할때, enum 외의 클래스 상속은 불가능하다.

```java
enum SingletonEnum {
    INSTANCE;

    private final Client dbClient;
	
    SingletonEnum() {
        dbClient = Database.getClient();
    }

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }

    public Client getClient() {
        return dbClient;
    }
}

public class Main {
    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.getInstance();
        singleton.getClient();
    }
}
```

### 싱글톤 패턴 실행 결과

```java
public class SingletonMain {
	
	public static void main(String[] args) {

        // Singleton.getInstance() 를 통해 싱글톤 객체를 각기 변수마다 받아와도 똑같은 객체 주소를 가리킴
        SingletonEager singletonEager1 = SingletonEager.getInstance();
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazyHolder singletonLazyHolder1 = SingletonLazyHolder.getInstance();
        SingletonStaticBlock singletonStaticBlock1 = SingletonStaticBlock.getInstance();

        System.out.println(singletonEager1.toString()); 
        System.out.println(singletonLazy1.toString()); 
        System.out.println(singletonLazyHolder1.toString()); 
        System.out.println(singletonStaticBlock1.toString()); 

        System.out.println("-----------------------------------------------");
        
        SingletonEager singletonEager2 = SingletonEager.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        SingletonLazyHolder singletonLazyHolder2 = SingletonLazyHolder.getInstance();
        SingletonStaticBlock singletonStaticBlock2 = SingletonStaticBlock.getInstance();
        
        System.out.println(singletonEager2.toString()); 
        System.out.println(singletonLazy2.toString()); 
        System.out.println(singletonLazyHolder2.toString()); 
        System.out.println(singletonStaticBlock2.toString()); 
       
    }
}

// 실행 결과
singleton_pattern.SingletonEager@1e643faf
singleton_pattern.SingletonLazy@6e8dacdf
singleton_pattern.SingletonLazyHolder@7a79be86
singleton_pattern.SingletonStaticBlock@34ce8af7
-----------------------------------------------
singleton_pattern.SingletonEager@1e643faf
singleton_pattern.SingletonLazy@6e8dacdf
singleton_pattern.SingletonLazyHolder@7a79be86
singleton_pattern.SingletonStaticBlock@34ce8af7
```

실행 결과에서 볼 수 있듯이 싱글톤 패턴을 사용하여 생성한 객체는 같은 주소값을 가리키고 있다. 

### 싱글톤 패턴의 단점

싱글톤 패턴에 대해 공부하며 생각해본 싱글톤 패턴의 단점은 아래와 같다. 

1. **모듈간 의존성이 높아진다.**
- 싱글톤을 이용할 때 대부분 인터페이스가 아닌 클래스의 객체를 미리 생성하고 static 메소드를 이용해 사용하기 때문에 클래스 사이에 강한 의존성과 높은 결합이 생기게 된다.
- 하나의 싱글톤 클래스를 여러 모듈들이 공유를 하기 때문에 만일 싱글톤의 인스턴스가 변경되면 이를 참조하는 모듈들도 수정이 필요하게 된다.
- 클라이언트 코드 중 너무 많은 곳에서 사용하면 클래스간의 결합도가 높아져 오히려 패턴을 사용 안하느니만 못하게 될 수도 있다.
2. **S.O.L.I.D 원칙에 위배되는 사례가 많다.**
- 싱글톤 패턴은 인스턴스를 하나만 생성하기 때문에 여러가지 책임을 지니게 되는 경우가 많아 단일 책임 원칙(SRP)를 위배할 위험이 있다.
- 싱글톤 인스턴스가 혼자 너무 많은 일을 하거나, 많은 데이터를 공유시키면 다른 클래스들 간의 결합도가 높아지게 되어 개방-폐쇄 원칙(OCP)에도 위배될 수 있다.
- 의존 관계상 클라이언트가 인터페이스와 같은 추상화가 아닌, 구체 클래스에 의존하게 되어 의존 역전 원칙(DIP)도 위반하게 된다.
- 따라서 싱글톤 인스턴스를 너무 많은 곳에서 사용할 경우 잘못된 디자인 형태가 될 수도 있다.

이처럼 싱글톤 기법은 오직 한 개의 인스턴스 생성을 보증하여 효율을 찾을 수 있지만, 그에 못지많게 수반되는 문제점도 많다. 결과적으로 이러한 문제들을 안고있는 싱글톤 패턴은 유연성이 많이 떨어지는 패턴이라고 할 수 있다. 하지만 스프링 컨테이너와 같은 프레임워크의 도움을 받으면 싱글톤 패턴의 문제점들을 보완하면서 장점의 혜택을 누릴 수 있다.
