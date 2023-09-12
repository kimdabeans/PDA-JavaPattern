# 디자인 패턴이란?

디자인 패턴은 **소프트웨어 디자인에서 반복적으로 발생하는 문제를 어떻게 해결할 것인가**에 대한 일종의 솔루션입니다. 주로 객체 지향 프로그래밍에서 사용되며, 코드의 **재사용성**을 높이고 **추상화**에 기여하며 **유지 보수**를 용이하게 합니다.

‘GoF의 디자인패턴’은 **생성 패턴, 구조 패턴, 행동 패턴**의 3가지로 디자인 패턴을 구분합니다.

| 생성 패턴 | 구조 패턴 | 행동 패턴 |
| --- | --- | --- |
| 객체 생성의 추상화와 유연성에 집중합니다. | 클래스와 객체를 조합하여 더 큰 구조를 형성합니다.  | 객체 간 상호 작용 및 책임 분배에 집중합니다.  |
| Singleton, Abstract Factory, Factory Method, Builder, Prototype | Adapter, Composite, Decorator, Facade, Flyweight, Proxy | Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method |

이 글에서는 앞으로 우리가 배울 스프링에 자주 쓰이는 디자인패턴 4가지 *-Template Method, Factory Method, Proxy, Singleton-* 에 대해 살펴보겠습니다.
1. [Template Method](#1-template-method)
2. [Factory Method](#2-factory-method)
3. [Proxy](#3-proxy)
4. [Singleton](#4-singleton)

# 1 Template Method
<p align="center"><img width="211" alt="1-1" src="https://github.com/kimdabeans/PDA-JavaPattern/assets/83651335/961a36b7-c3e5-45c9-9da8-5401244112d8"></p>
<p align="center" style="color:gray">동일한 사람이지만 입는 옷에 따라 하는 일이 달라진다</p>

템플릿 메소드 패턴은 **부모 클래스에서 공통적인 알고리즘의 구조를 정의하고, 구체적인 단계를 자식 클래스에서 구현**하는 패턴입니다. 즉 변하지 않는 기능은 부모 클래스에, 자주 변경되며 확장할 기능은 자식 클래스에 만듭니다. 알고리즘의 구조를 일관되게 유지하면서도 확장 가능하도록 할 때 유용합니다.

## Template Method UML & Code

<p align="center"><img width="211" alt="1-2" src="https://github.com/kimdabeans/PDA-JavaPattern/assets/83651335/436e8a06-1125-4188-b3fd-072d986b1554"></p>

AbstractClass는 템플릿 메소드를 구현하고, 해당 템플릿 메소드에서 사용할 추상 메소드를 선언합니다. ConcreteClass는 추상 메소드를 구체적으로 구현합니다.

<p align="center"><img width="211" alt="burger" src="https://github.com/minseo205/PDA-JavaPattern/assets/83651335/7f87ba78-3fae-41de-bf24-4413f7731bb1"></p>

이해를 돕기 위해 John’s Burger라는 가상의 햄버거 가게가 있다고 가정하겠습니다. John’s Burger에서 햄버거를 만드는 과정을 통해 템플릿 메소드 패턴을 자세히 알아봅시다. John’s Burger의 대표 메뉴인 치킨 버거와 비프 버거를 만들어 보려고 합니다.

먼저 템플릿 메소드 패턴을 적용하기 전 코드입니다. 치킨 버거와 비프 버거는 패티가 각각 치킨, 버거인 점과 포장지가 다르다는 점을 제외하고 동일합니다. 즉 패티의 종류에 따라 조리하는 메소드인 `fryChicken`, `grillBeef`와 햄버거의 종류에 따라 알맞게 포장하는 메소드인 `chickenPackaging`, `beefPackaging`을 제외한 나머지 메소드는 모두 동일하지만, 각 클래스에서 해당 알고리즘을 일일이 기술해야 합니다.

### Before

```java
package templateMethod.before;

/**
 * BeefBurger 클래스는 구체적인 햄버거 제작 과정을 정의하고 있습니다.
 */
public class BeefBurger {

    /**
     * 비프 버거를 만드는 일련의 단계를 순차적으로 수행합니다.
     *
     * 1. 비프 패티를 굽는다.
     * 2. 빵을 자른다.
     * 3. 토핑을 추가한다.
     * 4. BeefBurger 포장지로 포장한다.
     */
    void cook() {
        grillBeef();
        cutBread();
        addToppings();
        beefPackaging();
    }

    /**
     * 비프 패티를 굽는 메서드입니다.
     */
    public void grillBeef() {
        System.out.println("비프 패티 굽기");
    }

    /**
     * 빵을 자르는 메서드입니다.
     */
    public void cutBread() {
        System.out.println("빵 자르기");
    }

    /**
     * 토핑을 추가하는 메서드입니다.
     */
    public void addToppings() {
        System.out.println("토핑 추가하기");
    }

    /**
     * BeefBurger를 포장지로 포장하는 메서드입니다.
     */
    public void beefPackaging() {
        System.out.println("BeefBurger 포장지로 포장하기");
    }
}
```

```java
package templateMethod.before;

/**
 * ChickenBurger 클래스는 구체적인 치킨 버거 제작 과정을 정의하고 있습니다.
 */
public class ChickenBurger {

    /**
     * 치킨 버거를 만드는 일련의 단계를 순차적으로 수행합니다.
     *
     * 1. 치킨 패티를 튀긴다.
     * 2. 빵을 자른다.
     * 3. 토핑을 추가한다.
     * 4. ChickenBurger 포장지로 포장한다.
     */
    void cook() {
        fryChicken();
        cutBread();
        addToppings();
        chickenPackaging();
    }

    /**
     * 치킨 패티를 튀기는 메서드입니다.
     */
    public void fryChicken() {
        System.out.println("치킨 패티 튀기기");
    }

    /**
     * 빵을 자르는 메서드입니다.
     */
    public void cutBread() {
        System.out.println("빵 자르기");
    }

    /**
     * 토핑을 추가하는 메서드입니다.
     */
    public void addToppings() {
        System.out.println("토핑 추가하기");
    }

    /**
     * BeefBurger를 포장지로 포장하는 메서드입니다.
     */
    public void chickenPackaging() {
        System.out.println("ChickenBurger 포장지로 포장하기");
    }
}
```

### After

<p align="center"><img width="445" alt="1-3" src="https://github.com/kimdabeans/PDA-JavaPattern/assets/83651335/583900cc-3539-4339-831a-4422cb905064"></p>

햄버거 만들기에 템플릿 메소드를 적용했습니다. 부모 클래스인 Hamburger는 ChickenBurger, BeefBurger라는 두 개의 자식 클래스를 가집니다. 앞서 패티의 종류에 따라 조리하는 메소드였던 `fryChicken`, `grillBeef`는 `cookPatty`라는 하나의 메소드로 통일한 후 세부 구현을 자식 클래스에게 넘겼습니다. 마찬가지로 햄버거의 종류에 따라 알맞게 포장하는 메소드였던 `chickenPackaging`, `beefPackaging`도 `packaging`이라는 하나의 메소드로 통일했습니다. 실체가 없는 추상 메소드인 `cookPatty`와 `packaging`을 사용하는 `cook` 메소드는 **템플릿 메소드**입니다. cook 메소드는 **햄버거를 조리하는 알고리즘**을 가지고 있으며, 추상 메소드 외에도 `cutBread`, `addToppings` 메소드를 사용합니다.

```java
package templateMethod.after;

/**
 * Hamburger 클래스는 햄버거를 만들기 위한 템플릿 메소드 패턴을 구현한 추상 클래스입니다.
 * 템플릿 메소드 패턴을 활용하여 햄버거 제작 프로세스를 정의하며,
 * 이 클래스를 상속하는 구체적인 햄버거 종류 클래스가 구체적인 구현을 제공합니다.
 */
public abstract class Hamburger {
    /**
     * 햄버거를 만들기 위한 알고리즘을 가진 템플릿 메소드입니다.
     * 각각의 단계는 구체적인 구현 클래스에서 제공됩니다.
     */
    public final void cook() {
        cookPatty();
        cutBread();
        addToppings();
        packaging();
    }

    /**
     * 고기 패티를 만들기 위한 추상 메소드와 햄버거를 포장하기 위한 추상 메소드입니다.
     * 구체적인 구현 클래스에서 해당 메소드를 구현해야 합니다.
     */
    public abstract void cookPatty();

    public abstract void packaging();

    /**
     * 빵을 자르는 메소드와 토핑을 추가하는 메소드 입니다.
     * 템플릿 메소드 내에서 공통적으로 사용됩니다.
     */
    public final void cutBread() {
        System.out.println("빵 자르기");
    }

    public final void addToppings() {
        System.out.println("토핑 추가하기");
    }
}
```

`cookPatty`와 `packaging`이 실제로 무슨 일을 하는지는 자식 클래스를 확인해 봐야 알 수 있습니다.

```java
package templateMethod.after;

/**
 * ChickenBurger 클래스는 햄버거를 만드는 템플릿 메소드 패턴을 활용한 클래스입니다.
 * Hamburger 클래스를 상속하며, Hamburger 클래스의 템플릿 메소드를 구체화합니다.
 */
public class ChickenBurger extends Hamburger {

    /**
     * 치킨 패티를 튀기는 메소드를 구체화합니다.
     */
    @Override
    public void cookPatty() {
        System.out.println("치킨 패티 튀기기");
    }

    /**
     * ChickenBurger를 포장하는 메소드를 구체화합니다.
     */
    @Override
    public void packaging() {
        System.out.println("ChickenBurger 포장지로 포장하기");
    }
}
```

```java
package templateMethod.after;

/**
 * BeefBurger 클래스는 햄버거를 만드는 템플릿 메소드 패턴을 활용한 클래스입니다.
 * Hamburger 클래스를 상속하며, Hamburger 클래스의 템플릿 메소드를 구체화합니다.
 */
public class BeefBurger extends Hamburger {

    /**
     * 고기 패티를 굽는 메소드를 구체화합니다.
     */
    @Override
    public void cookPatty() {
        System.out.println("고기 패티 굽기");
    }

    /**
     * BeefBurger를 포장하는 메소드를 구체화합니다.
     */
    @Override
    public void packaging() {
        System.out.println("BeefBurger 포장지로 포장하기");
    }
}
```

```java
package templateMethod.after;

/**
 * Main 클래스는 템플릿 메소드 패턴을 활용한 햄버거 제작 예시를 보여줍니다.
 */
public class Main {
    /**
     * Main 메서드는 프로그램의 진입점입니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {

        Hamburger chickenBurger = new ChickenBurger();
        Hamburger beefBurger = new BeefBurger();

        chickenBurger.cook();
        System.out.println("");
        beefBurger.cook();
    }
}
```

ChickenBurger, BeefBurger 모두 Hamburger의 자식 클래스 인스턴스이므로 상속한 `cook` 메소드를 호출할 수 있습니다. 이때 실제 동작은 ChickenBurger, BeefBurger 클래스에서 정해집니다.

```java
package templateMethod.after;

/**
 * Hamburger 클래스는 햄버거를 만들기 위한 템플릿 메소드 패턴을 구현한 추상 클래스입니다.
 * 템플릿 메소드 패턴을 활용하여 햄버거 제작 프로세스를 정의하며,
 * 이 클래스를 상속하는 구체적인 햄버거 종류 클래스가 구체적인 구현을 제공합니다.
 */
public abstract class Hamburger {
    /**
     * 햄버거를 만들기 위한 알고리즘을 가진 템플릿 메소드입니다.
     * 각각의 단계는 구체적인 구현 클래스에서 제공됩니다.
     */
    public final void cook() {
        cookPatty();
        cutBread();
        addToppings();
        if (customerWantsPackaging()) {
            packaging();
        }
    }

    /**
     * 고기 패티를 만들기 위한 추상 메소드입니다.
     * 구체적인 구현 클래스에서 해당 메소드를 구현해야 합니다.
     */
    public abstract void cookPatty();

    /**
     * 햄버거를 포장하기 위한 추상 메소드입니다.
     * 구체적인 구현 클래스에서 해당 메소드를 구현해야 합니다.
     */
    public abstract void packaging();

    /**
     * 빵을 자르는 메소드입니다.
     * 템플릿 메소드 내에서 공통적으로 사용됩니다.
     */
    public final void cutBread() {
        System.out.println("빵 자르기");
    }

    /**
     * 토핑을 추가하는 메소드입니다.
     * 템플릿 메소드 내에서 공통적으로 사용됩니다.
     */

    public final void addToppings() {
        System.out.println("토핑 추가하기");
    }

    /**
     * 포장 여부를 결정하는 "hook" 메소드입니다.
     * 구체적인 구현 클래스에서 필요에 따라 오버라이드할 수 있습니다.
     * 기본적으로는 포장을 하도록 구현되어 있습니다.
     *
     * @return 포장을 할지 여부를 나타내는 불리언 값
     */
    boolean customerWantsPackaging() {
        return true;
    }
}
```

추가로 hook 메소드라는 것이 있습니다. **hook 메소드는 템플릿 메소드에서 선택적으로 구현할 수 있는 메소드**로, 서브클래스에서 필요한 경우 오버라이딩할 수 있습니다.

### 출력 결과

```bash
치킨 패티 튀기기
빵 자르기
토핑 추가하기
ChickenBurger 포장지로 포장하기

고기 패티 굽기
빵 자르기
토핑 추가하기
Beefburger 포장지로 포장하기
```

## Don't call us, we'll call you

Template Method에서 부모 클래스는 자식 클래스에 정의된 연산을 호출할 수 있지만, **반대 방향의 호출은 불가능**합니다.  즉 자식 클래스의 역할을 줄이고, **핵심 로직을 부모 클래스에서 관리**합니다. 이러한 제어의 역전을 **할리우드 원칙**이라고도 합니다. *우리에게 전화하지 마세요, 우리가 당신을 부를 것입니다.*

그러나 상속을 사용하는 만큼 자식 클래스가 많아질 경우 클래스 계층이 복잡해질 수 있다는 것이 단점입니다. 또한 자식 클래스가 부모 클래스의 템플릿 메소드를 잘못 오버라이딩하여 부모의 규약을 위반할 경우 리스코프 치환 원칙을 위반할 수 있습니다.

# 2 Factory Method

<p align="center"><img width="211" alt="2-1" src="https://github.com/kimdabeans/PDA-JavaPattern/assets/83651335/0fe5eb5e-4be3-42f3-beae-a85b95ffe433"></p>

<p align="center" style="color:gray">같은 붕어빵 틀에서 만들어 지는 다양한 붕어빵들</p>

팩토리 메소드 패턴은 **공장 클래스로 캡슐화하여 객체 생성을 대신**합니다. 클라이언트가 직접 new 연산자로 제품을 생성하지 않고, **공장 클래스를 상속받는 서브 공장 클래스의 메소드가 제품 객체 생성을 책임**집니다. 단순하게 말하면, 인스턴스 생성 방법을 부모 클래스에서 결정하되 구체적인 내용은 자식 클래스에서 결정합니다.  클래스의 생성과 사용의 처리 로직을 분리하여 결합도를 낮추고 싶을 때 주로 사용합니다.

## Factory Method UML & Code

<p align="center"><img width="398" alt="2-2" src="https://github.com/kimdabeans/PDA-JavaPattern/assets/83651335/6798051c-daec-4fde-8857-5c0cd1f5d64d"></p>

Product는 생성될 인스턴스가 가저야 할 인터페이스를 결정하는 추상 클래스입니다. 구체적인 내용은 자식 클래스인 ConcreteProduct에서 결정합니다. Creator은 프레임워크 쪽으로, Product를 생성하는 추상 클래스입니다. 구체적인 내용은 ConcreteCreator가 결정합니다. new를 사용하여 **실제 인스턴스를 생성하는 대신, 인스턴스를 생성하는 메소드를 호출함으로써 구체적인 클래스 이름에 의한 속박에서 부모 클래스를 자유롭게** 합니다.

<p align="center"><img width="211" alt="burger" src="https://github.com/minseo205/PDA-JavaPattern/assets/83651335/df5b18d3-d824-456f-8097-71db52f3674b"></p>

John’s Burger는 어느덧 동네 맛집으로 자리 잡아 용산점, 강남점을 내게 되었습니다. 용산점과 강남점은 다른 지점이지만, 햄버거라는 제품을 만드는 햄버거 가게임은 동일합니다.

<p align="center"><img width="1073" alt="2-3" src="https://github.com/kimdabeans/PDA-JavaPattern/assets/83651335/0e25bfc1-3786-402e-a25f-8c50e9fce593"></p>

따라서 햄버거를 Product, JohnsBurger를 Creator, 체인점인 JohnsBurgerYongsan과 JohnsBurgerGangnam을 ConcreteCreator라고 하겠습니다. 각 체인점에서 만들어지는 햄버거들은 ConcreteProduct입니다.

```java
package factoryMethod;

/**
 * Hamburger 추상 클래스는 햄버거 객체를 나타내며, 서빙 메소드를 제공합니다.
 */
public abstract class Hamburger {
    /**
     * 햄버거를 서빙하는 추상 메소드입니다.
     * 구체적인 구현 클래스에서 이 메소드를 구현해야 합니다.
     */
    public abstract void serve();
}
```

```java
package factoryMethod;

/**
 * JohnsBurger 추상 클래스는 버거 주문과 생성을 관리하는 팩토리 메소드를 포함합니다.
 */
public abstract class JohnsBurger {
    /**
     * 주어진 버거 유형에 따라 버거를 주문하고 생성하는 메소드입니다.
     *
     * @param type 주문하려는 버거의 유형
     * @return 생성된 버거 객체
     */
    public Hamburger orderBurger(String type) {
        Hamburger hamburger = createBurger(type);
        hamburger.serve();
        return hamburger;
    }

    /**
     * 구체적인 팩토리 서브클래스에서 구현해야 하는 팩토리 메소드입니다.
     * 주어진 유형에 따라 적절한 버거를 생성합니다.
     *
     * @param type 생성할 버거의 유형
     * @return 생성된 버거 객체
     */
    abstract Hamburger createBurger(String type);
}
```

```java
package factoryMethod;

/**
 * JohnsBurgerGangnam 클래스는 Gangnam 지점에서 제공되는 햄버거 생성을 관리하는 팩토리 서브클래스입니다.
 */
public class JohnsBurgerGangnam extends JohnsBurger {
    /**
     * 주어진 버거 유형에 따라 Gangnam 지점에서 햄버거를 생성하는 메서드입니다.
     *
     * @param type 생성할 버거의 유형 (치킨 또는 비프)
     * @return 생성된 Gangnam 스타일 햄버거 객체
     */
    @Override
    Hamburger createBurger(String type) {
        if ("chicken".equals(type)) {
            return new GangnamStyleChickenBurger();
        } else if ("beef".equals(type)) {
            return new GangnamStyleBeefBurger();
        }
        return null;
    }
}

```

```java
package factoryMethod;

/**
 * JohnsBurgerYongsan 클래스는 Yongsan 지점에서 제공되는 햄버거 생성을 관리하는 팩토리 서브클래스입니다.
 */
public class JohnsBurgerYongsan extends JohnsBurger {
    /**
     * 주어진 버거 유형에 따라 Yongsan 지점에서 햄버거를 생성하는 메소드입니다.
     *
     * @param type 생성할 버거의 유형 (치킨 또는 비프)
     * @return 생성된 Yongsan 스타일 햄버거 객체
     */
    @Override
    Hamburger createBurger(String type) {
        if ("chicken".equals(type)) {
            return new YongsanStyleChickenBurger();
        } else if ("beef".equals(type)) {
            return new YongsanStyleBeefBurger();
        }
        return null;
    }
}
```
```java
package factoryMethod;

/**
 * GangnamStyleChickenBurger 클래스는 John's Burger 강남점에서 제공되는 치킨 버거를 나타내는 클래스입니다.
 * Hamburger 클래스를 상속하며, 치킨 버거를 서빙하는 메서드를 구현합니다.
 */
public class GangnamStyleChickenBurger extends Hamburger {
    /**
     * 치킨 버거를 서빙하는 메서드입니다.
     * 강남점의 치킨 버거에 대한 정보를 출력합니다.
     */
    @Override
    public void serve() {
        System.out.println("John's Burger 강남점의 치킨 버거");
        System.out.println("강남점의 치킨 버거는 꽤나 짭잘합니다.\n");
    }
}

```

```java
package factoryMethod;

/**
 * Main 클래스는 팩토리 메소드 패턴을 활용하여 햄버거 주문 및 생성을 시연하는 클래스입니다.
 */
public class Main {
    /**
     * Main 메서드는 프로그램의 진입점입니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        JohnsBurger yongsanStore = new JohnsBurgerYongsan();
        JohnsBurger gangnamStore = new JohnsBurgerGangnam();

        Hamburger yongsanChickenBurger = yongsanStore.orderBurger("chicken");
        Hamburger yongsanBeefBurger = yongsanStore.orderBurger("beef");
        Hamburger gangnamChickenBurger = gangnamStore.orderBurger("chicken");
        Hamburger gangnamBeefBurger = gangnamStore.orderBurger("beef");

    }
}
```

### 출력 결과

```bash
John's Burger 용산점의 치킨 버거
용산점의 치킨 버거는 담백합니다.

John's Burger 용산점의 비프 버거
용산점의 비프 버거는 상당히 푸짐합니다.

John's Burger 강남점의 치킨 버거
강남점의 치킨 버거는 꽤나 짭잘합니다.

John's Burger 강남점의 비프 버거
강남점의 비프 버거는 보다 고소합니다.
```

## 공장처럼 쉽게 제품을 찍어낸다

템플릿 메소드 패턴은 객체를 생성하는 코드를 한 곳으로 모아 코드의 유지보수가 쉽고 단일 책임 원칙을 준수합니다. 또한 기존 코드를 수정하지 않고 새로운 제품 인스턴스를 도입할 수 있으므로 개방 폐쇄 원칙을 준수합니다.

그러나 각 제품 구현체마다 팩토리 객체를 모두 구현해주어야 하므로, 팩토리 클래스가 증가하고 서브 클래스 수가 기하급수적으로 늘어납니다. 코드의 복잡성 또한 증가하는 단점이 있습니다.

## Template Method vs Factory Method

| Template Method | Factory Method |
| --- | --- |
| 행동 패턴 | 생성 패턴 |
| 부모 클래스에서 **알고리즘의 구조**를 정의하고, 자식 클래스에서 구현함 | 부모 클래스에서 **인스턴스 생성 방법**을 정의하고, 자식 클래스에서 실제 생성함 |

템플릿 메소드는 객체 간 상호 작용 및 책임 분배에 집중하는 행동 패턴이고, 팩토리 메소드는 객체 생성의 추상화와 유연성에 집중하는 생성 패턴입니다.

템플릿 메소드 패턴은 부모 클래스에서 공통적인 알고리즘의 구조를 정의하고, 구체적인 단계를 자식 클래스에서 구현합니다. 이 로직을 인스턴스 생성에 적용한 것이 팩토리 메소드 패턴입니다. 팩토리 메소드 패턴은 인스턴스 생성을 위한 프레임워크와 실제 인스턴스를 생성하는 클래스로 나누어 생각할 수 있습니다.

# 3 Proxy

<p align="center"><img width="211" alt="3-1" src="https://github.com/kimdabeans/PDA-JavaPattern/assets/83651335/e083649d-6b87-482d-82e7-f2c9b1999e91"></p>

<p align="center" style="color:gray">변호사는 피고인의 대리인 역할을 한다</p>

프록시 패턴은 **다른 객체에 대한 대리자 역할을 하는 객체를 제공하여 객체에 대한 접근을 제어**합니다. 프록시 객체는 실제 객체와 동일한 인터페이스를 가지며, 클라이언트는 프록시 객체를 거쳐 실제 객체에 접근합니다. 기능을 추가해야 하는데 원본 객체를 수정할 수 없는 상황을 극복하기 위해 사용합니다.

## Proxy UML & Code

<p align="center"><img width="624" alt="3-2" src="https://github.com/minseo205/PDA-JavaPattern/assets/83651335/b8dcd33f-7285-456f-ac2d-07261314da8b"></p>

Subject는 Proxy와 RealSubject를 하나로 묶는 인터페이스를 정의합니다. 인터페이스가 있기 때문에 Client는 Proxy와 RealSubject의 차이를 의식할 필요가 없습니다.
**Proxy는 Client의 요청을 최대한 처리하고, 꼭 필요한 경우에만 RealSubejct를 생성**합니다. RealSubject와 같은 이름의 메소드를 호출하며, 별도의 로직을 수행할 수 있습니다.
RealSubject는 대리인 역할의 Proxy가 감당하지 못할 때 등장하는 원본 대상 객체입니다.
Client는 Subject 인터페이스를 거쳐 프록시 객체를 생성합니다. 프록시를 매개로 RealSubject와 데이터를 주고 받습니다.

<p align="center"><img width="211" alt="burger" src="https://github.com/minseo205/PDA-JavaPattern/assets/83651335/2b3aaca2-d2b9-495b-8e8e-06c0468ec827"></p>

John’s Burger는 어느덧 한국을 대표하는 햄버거 가게가 되었고, 이에 맞춰 공식 홈페이지를 개설했습니다. 홈페이지에 방문하는 과정을 통해 프록시 패턴을 자세히 알아봅시다. 홈페이지에는 대표 메뉴인 치킨 버거 사진이 큼지막하게 있습니다. 여기서 프록시 객체를 사용하여 처음 홈페이지에 방문했을 때 해당 이미지를 캐싱 해두면 홈페이지 재방문 시 이미지 객체에 도달하지 않고도 프록시 객체에서 이미지를 출력할 수 있습니다.

<p align="center"><img width="624" alt="3-3" src="https://github.com/kimdabeans/PDA-JavaPattern/assets/83651335/4dae326d-c94a-4051-b83a-3e47c6278147"></p>

RealImage 클래스는 Image 인터페이스를 구현합니다. Proxy 클래스 또한 Image 인터페이스를 구현합니다. 이로서 Hompage 객체는 Proxy 객체가 사용되는지, RealImage 객체가 사용되는지 알 수 없게 됩니다.

```java
package proxy;
/**
 * 이 인터페이스는 이미지 출력을 정의하는 메서드를 포함합니다.
 * 다른 클래스에서 이 인터페이스를 구현하여 이미지 출력 동작을 구체화할 수 있습니다.
 */

public interface Image {
    /**
     * 이미지를 출력하는 메서드입니다.
     * 구체적인 이미지 출력 동작은 이 메서드를 구현하는 클래스에서 정의되어야 합니다.
     */
    public void print();
}
```

```java
package proxy;

/**
 * RealImage 클래스는 실제 이미지를 나타내며 Image 인터페이스를 구현합니다.
 * 이 클래스는 이미지를 로드하고 출력하는 기능을 제공합니다.
 */
public class RealImage implements Image {

    private String imageName; // 이미지의 이름 또는 경로

    /**
     * RealImage의 생성자는 이미지의 제목을 받아와 초기화합니다.
     *
     * @param imageString 이미지의 제목
     */
    public RealImage(String imageString) {
        this.imageName = imageString;
    }

    /**
     * 이미지를 출력합니다. 이미지가 로드하고 해당 이미지의 이름을 출력합니다.
     */
    @Override
    public void print() {
        System.out.println("이미지 로딩 : " + imageName);
    }

    /**
     * 이미지를 디스크에서 캐싱하고, 이미지의 이름을 출력합니다.
     */
    public void diskImage() {
        System.out.println("이미지 캐싱 : " + imageName);
    }
}
```

```java
package proxy;

/**
 * ProxyImage는 이미지를 로드하는 데 사용되는 프록시 패턴의 구현입니다.
 * 이 클래스는 실제 이미지 로딩을 지연시키고, 필요한 경우에만 실제 이미지를 로드하여
 * 성능 향상 및 자원 절약을 가능하게 합니다.
 */
public class ProxyImage implements Image {

    private RealImage image; // 실제 이미지 객체
    private String imageName; // 이미지의 이름 또는 경로

    /**
     * ProxyImage의 생성자는 이미지의 이름 또는 경로를 받아와 초기화합니다.
     *
     * @param imageName 이미지의 이름 또는 경로
     */
    public ProxyImage(String imageName) {
        this.imageName = imageName;
    }

    /**
     * 이미지를 출력합니다. 이미지가 로드되지 않은 경우에는 실제 이미지 객체를 생성하고 출력하며,
     * 이미지가 이미 로드된 경우에는 바로 출력합니다.
     */
    @Override
    public void print() {
        if(image == null) {
            image = new RealImage(imageName);
            image.print();
        }
        else {
            image.diskImage();
        }
    }
}
```

저장된 이미지가 없는 경우 RealImage 객체를 생성한 후 출력하므로 Proxy 객체가 RealImage 객체에 의존합니다. 저장된 이미지가 있는 경우에는 이를 바로 출력합니다.

```java
package proxy;
/**
 * 이 클래스는 이미지 출력을 위한 프록시 패턴을 구현한 예제입니다.
 * Homepage 클래스는 실제 이미지 출력 작업을 Image 프록시에 위임하고,
 * 이미지 출력 시간을 측정하여 결과를 출력합니다.
 */

public class Homepage {
    private Image proxy;

    /**
     * Homepage 클래스의 생성자입니다.
     *
     * @param proxy 이미지 출력을 위임할 Image 프록시 객체
     */
    public Homepage(Image proxy) {
        this.proxy = proxy;
    }

    /**
     * 이미지를 그리는 메서드입니다. 이미지 출력 시간을 측정하고 결과를 출력합니다.
     */
    public void draw() {
        long startTime = System.currentTimeMillis();
        proxy.print();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("치킨 버거 사진을 불러오기 위해 " + resultTime + "초를 사용했습니다.\n");
    }
}
```

```java
package proxy;
/**
 * 이 클래스는 프록시 패턴을 사용하여 이미지 출력 예제를 제공합니다.
 * Main 클래스는 프록시 이미지 객체를 생성하고 클라이언트 객체에 주입하여 이미지 출력을 관리합니다.
 */

public class Main {
    /**
     * 프로그램의 진입점입니다.
     * 첫 번째 이미지 출력은 프록시에서 이미지를 로드합니다.
     * 두 번째 이미지 출력은 프록시에 이미지가 이미 로드되어 있으므로 다시 로드하지 않습니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        ProxyImage proxy = new ProxyImage("chickenBurgerImage");
        Homepage homepage = new Homepage(proxy);

        homepage.draw();
        homepage.draw();
    }
}
```

### 출력 결과

```bash
이미지 로딩 : chickenBurgerImage
치킨 버거 사진을 불러오기 위해 2초를 사용했습니다.

이미지 캐싱 : chickenBurgerImage
치킨 버거 사진을 불러오기 위해 0초를 사용했습니다.
```

출력 결과를 보면, 처음 홈페이지에 방문했을 때 RealImage 객체에서 이미지를 출력하며 약 2초가 걸립니다. 반면 재방문했을 때는 Proxy 객체에서 이미지를 출력하고, 약 0초가 걸립니다. **프록시 객체가 실제 객체에 대한 접근을 차단하고 생성을 제한**하여 속도가 빨라졌다고 볼 수 있습니다.

## Speedy한 대리인

프록시 패턴은 대상 객체의 기존 코드를 변경하지 않고 새로운 기능을 추가하므로 개방 폐쇄 원칙을 준수합니다. 대상 객체는 자신의 기능에만 집중하고 추가 기능에 대한 역할은 프록시 객체에 위임하여 단일 책임 원칙을 준수합니다.

무엇보다 **Proxy 역할이 대리인이 되어 가능한 최대의 처리를 대신 하므로** 속도를 높일 수 있습니다. 초기화에 많은 시간이 걸리는 대규모 시스템일수록 진가가 발휘될 것입니다.

그러나 많은 프록시 클래스를 도입해야 하므로 코드의 복잡성이 증가합니다. 프록시 클래스에 들어가는 자원이 많은 경우 응답이 늦어지는 문제점도 있습니다.

# 4 Singleton

<p align="center"><img width="211" alt="4-1" src="https://github.com/kimdabeans/PDA-JavaPattern/assets/83651335/a48d0fea-a26c-4b13-b306-e800ba3beca1"></p>

<p align="center" style="color:gray">햇님은 하나다</p>

싱글톤 패턴은 **특정 클래스가 단 하나의 인스턴스만 가지고 있도록 보장**합니다. 리소스를 많이 차지하는 무거운 클래스가 필요할 때 주로 사용됩니다.

어떤 클래스가 최초로 인스턴스화된 후에는 **하나의 고유한 인스턴스만 사용 가능**하며, 이 인스턴스에는 **어디서나 접근**할 수 있습니다. 초기화 시점은 프로그램 시작 시점이 아닌 인스턴스가 실제로 필요한 시점으로, **지연 초기화**가 가능합니다.

## Singleton UML & Code

<p align="center"><img width="198" alt="4-2" src="https://github.com/kimdabeans/PDA-JavaPattern/assets/83651335/17a7945f-7e84-4365-9711-af166e3809f5"></p>

외부에서의 인스턴스 생성을 제한하기 위해 생성자 메소드에 private 키워드를 붙입니다. `getInstance`는 instance 변수가 null이라면 초기화를, null이 아니라면 이미 생성된 객체를 반환합니다.

```java
package singleton;
/**
 * 이 클래스는 싱글톤 디자인 패턴을 구현한 예제입니다.
 * 싱글톤 패턴은 클래스의 인스턴스가 하나만 생성되도록 보장하는 패턴입니다.
 */

public class Singleton {
    private static Singleton singleton = new Singleton();

    /**
     * 프라이빗 생성자로 외부에서의 인스턴스 생성을 방지합니다.
     * 이 생성자는 딱 한 번 호출되며, 인스턴스가 생성될 때 실행됩니다.
     */
    private Singleton() {
        System.out.println("인스턴스 생성");
    }

    /**
     * 싱글톤 인스턴스를 반환하는 정적 메서드입니다.
     *
     * @return 싱글톤 인스턴스
     */
    public static Singleton getInstance() {
        return singleton;
    }
}
```

```java
package singleton;
/**
 * 이 클래스는 Singleton 클래스를 사용하는 예제를 제공합니다.
 * Singleton 클래스의 인스턴스를 두 번 이상 생성하려고 시도하고,
 * 그 결과를 출력합니다.
 */

public class Main {
    /**
     * Main 메서드는 프로그램의 진입점입니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        System.out.println("Start");

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if (obj1 == obj2) {
            System.out.println("obj1 == obj2");
        } else {
            System.out.println("obj1 != obj2");
        }

        System.out.println("End");
    }
}
```


### 출력 결과

```bash
Start
인스턴스 생성
obj1 == obj2
End
```

`getInstance` 메소드를 통해 Singleton 인스턴스를 얻으며, 같은 인스턴스가 얻어지는지 확인합니다.
이때 인스턴스는 프로그램을 실행할 때 생성되지 않으며, **프로그램 실행 후 처음 `getInstance` 메소드를 호출할 때 static 필드가 초기화되며 유일한 인스턴스가 만들어집니다.**

## Singleton은 Antipattern?

싱글톤 패턴에서 생성자를 여러번 호출해도, 실제로 생성되는 객체는 한 개이며 최초 생성 이후에 호출된 생성자는 이미 생성한 객체를 반환시킵니다. 따라서 객체의 중복 생성을 피하고 메모리를 절약할 수 있습니다.

그러나 다음과 같은 문제점으로 인해 싱글톤 패턴은 객체 지향 프로그램의 안티 패턴으로도 불립니다. 싱글톤 인스턴스는 종종 여러 책임을 수행하여 단일 책임 원칙을 위반합니다. 의존 관계 상 클라이언트가 구체 클래스에 의존하여 의존관계 역전 원칙을 위반합니다. 이에 따라 다른 클래스와의 결합도가 높아져 개방 폐쇄 원칙을 위반할 가능성이 높습니다. 이외에도 테스트하기 어렵다는 단점이 있습니다.