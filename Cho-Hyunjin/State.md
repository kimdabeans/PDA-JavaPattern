# State Pattern

# 스테이트 패턴이란?

![](https://velog.velcdn.com/images/hyunjinny/post/7a51dbbf-f956-4090-b0b5-6d67642c07b8/image.png)

스테이트 패턴(State Pattern)은 객체의 내부 상태가 변경될 때 객체의 행동(메서드)을 변경할 수 있도록 하는 행동 디자인 패턴 중 하나입니다. 스테이트 패턴은 주로 객체의 상태가 다양하고 상태에 따라 객체의 행동이 달라져야 할 때 사용됩니다. 이 패턴을 사용하면 상태 관련 코드를 객체 내부로 캡슐화하고, 객체의 행동을 상태 객체로 위임하여 코드의 유지보수성을 향상시킵니다.

# 예제 프로그램 [BEFORE_ver]

## 신호등 프로그램

InefficientTrafficLight.java

```java
public class InefficientTrafficLight {
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int YELLOW = 2;

    private int currentState = RED;

    public void change() {
        if (currentState == RED) {
            System.out.println("빨간 불 - 정지");
            // 빨간 불 상태에서의 동작을 수행
            // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
            currentState = GREEN;
        } else if (currentState == GREEN) {
            System.out.println("초록 불 - 진행");
            // 초록 불 상태에서의 동작을 수행
            // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
            currentState = YELLOW;
        } else if (currentState == YELLOW) {
            System.out.println("노란 불 - 경고");
            // 노란 불 상태에서의 동작을 수행
            // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
            currentState = RED;
        }
    }

    public static void main(String[] args) {
        InefficientTrafficLight trafficLight = new InefficientTrafficLight();

        // 상태 변경을 여러 번 반복하여 신호등 동작 시뮬레이션
        for (int i = 0; i < 5; i++) {
            trafficLight.change();
        }
    }
}
```

Main.java

```java
/**
 * 이 클래스는 주문을 처리하는 데 사용되는 식당 객체를 나타냅니다.
 */
public class MainWithoutProxy {
    /**
     * 주문 처리를 위한 메인 메소드입니다.
     */
    public static void main(String[] args) {
        // 식당 객체 생성
        RestaurantWithoutProxy restaurant = new RestaurantWithoutProxy();
        
        // 고객의 이름 설정
        restaurant.setCustomerName("Jinny");
        System.out.println("현재 주문자 이름: " + restaurant.getCustomerName());
        
        // 주문 처리
        restaurant.placeOrder("피자");
    }
}
```

위에 코드는 State 패턴을 적용하지 않은 프로그램입니다. <br>
이 프로그램의 관련 문서인 Javadoc은 **StateBefore/docs** 폴더에 있습니다.<br> 

이 프로그램은 아래와 같이 여러가지 비효율적인 부분들이 있습니다.

**스테이트 패턴 적용 전:**

1. **복잡한 조건문:** **`if`**문을 사용하여 상태를 관리하고, 각 상태에 따른 동작을 수행하는 코드가 길고 복잡해집니다.
2. **가독성 저하:** 각 상태와 상태 전환에 대한 로직이 한 곳에 모이기 때문에 코드의 가독성이 저하됩니다. 상태와 상태 동작이 함께 섞여 있어 코드 이해가 어려울 수 있습니다.
3. **유지보수 어려움:** 새로운 상태를 추가하거나 상태 전환 조건을 변경할 때 코드를 수정해야 하므로 유지보수가 어려워집니다.
4. **코드 중복:** 각 상태에서 동작을 수행하는 코드가 중복되어 사용될 가능성이 높습니다.

# 예제 프로그램 [AFTER_ver]

**이러한 단점들을 해결하기 위해 State 패턴을 활용해 코드를 수정해보았습니다.**

이러한 비효율성과 단점을 해결하기 위해 상태 패턴을 사용면, 아래와 같이 효율적인 코드를 작성할 수 있습니다.

TrafficLightState.java

```java
// 상태 패턴에서 사용할 상태 인터페이스
public interface TrafficLightState {
    void handle(TrafficLightContext context);
}
```

TrafficLightContext.java

```java
// 신호등 컨텍스트 클래스
public class TrafficLightContext {
    private TrafficLightState state;

    public TrafficLightContext() {
        // 초기 상태를 빨간 불로 설정
        state = new RedLightState();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        // 상태 변경 메소드
        state.handle(this);
    }
}
```

RedLightState.java

```java
// 빨간 불 상태 클래스
public class RedLightState implements TrafficLightState {
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("빨간 불 - 정지");
        // 빨간 불 상태에서의 동작을 수행
        // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
        context.setState(new GreenLightState());
    }
}
```

YellowLightState.java

```java
// 노란 불 상태 클래스
public class YellowLightState implements TrafficLightState {
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("노란 불 - 경고");
        // 노란 불 상태에서의 동작을 수행
        // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
        context.setState(new RedLightState());
    }
}
```

GreenLightState.java

```java
// 초록 불 상태 클래스
public class GreenLightState implements TrafficLightState {
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("초록 불 - 진행");
        // 초록 불 상태에서의 동작을 수행
        // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
        context.setState(new YellowLightState());
    }
}
```

Main.java

```java
public class Main {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();

        // 상태 변경을 여러 번 반복하여 신호등 동작 시뮬레이션
        for (int i = 0; i < 5; i++) {
            trafficLight.change();
        }
    }
}
```

**스테이트 패턴 적용 후:**

1. **유연성과 확장성:** 상태 패턴을 사용하면 각 상태를 별도의 클래스로 구현합니다. 예를 들어, 교통 신호등의 상태를 나타내기 위해 **`RedLightState`**, **`GreenLightState`**, **`YellowLightState`** 와 같은 구체적인 클래스를 생성할 수 있습니다. 이렇게 하면 새로운 상태를 추가하거나 기존 상태를 변경하기가 쉽습니다.
2. **가독성 향상:** 각 상태 클래스는 해당 상태에서의 동작을 명확하게 정의합니다. 예를 들어, **`RedLightState`** 클래스는 "빨간 불 - 정지" 동작을 포함하고, 이로 인해 코드의 가독성이 향상됩니다.
3. **중복 코드 제거:** 상태 패턴을 사용하면 각 상태에서 수행하는 동작을 중복해서 작성하지 않습니다. 예를 들어, 각 상태 클래스 내에 해당 상태에서의 동작을 구체적으로 구현하므로 코드 중복을 최소화합니다.
4. **상태 전환의 명확한 관리:** 상태 패턴을 사용하면 각 상태 클래스 내에 상태 전환 로직이 포함됩니다. 예를 들어, **`RedLightState`** 클래스에서 다음 상태로 전환하는 로직이 있습니다. 이로써 상태 전환 관련 코드가 한 곳에 집중되어 관리와 디버깅이 용이합니다.
5. **코드 분리와 모듈화:** 각 상태를 별도의 클래스로 구현하면 코드가 모듈화되고 분리됩니다. 이로써 코드의 구조가 더 명확해지며 각 상태 클래스는 자체적으로 상태에 대한 동작을 포함하므로 코드의 구성이 명확하게 분리됩니다.

# UML

![](https://velog.velcdn.com/images/hyunjinny/post/ccad4b5f-6ee6-4c8f-a938-21396d2ddd3b/image.png)

위 사진은 State Pattern을 사용해서 신호등을 구현한 프로그램의 UML입니다.클래스 및 인터페이스와 관련된 설명은 아래와 같습니다.

1. **TrafficLight (상태를 가지고 있는 컨텍스트 클래스):** **`TrafficLight`** 클래스는 상태 패턴의 컨텍스트 역할을 합니다. 이 클래스는 현재 상태를 관리하고, 상태에 따라 동작을 수행합니다. **`state`** 필드는 현재 상태를 저장하며, **`setState()`** 메소드를 통해 상태를 변경하고, **`change()`** 메소드는 상태에 따른 동작을 수행합니다.
2. **TrafficLightState (상태 인터페이스):** **`TrafficLightState`** 인터페이스는 모든 상태 클래스가 구현해야 하는 인터페이스입니다. **`handle()`** 메소드는 각 상태에서 수행할 동작을 정의합니다.
3. **RedLightState, GreenLightState, YellowLightState (구체적인 상태 클래스):** 각각의 상태 클래스는 **`TrafficLightState`** 인터페이스를 구현합니다. 각 상태 클래스는 **`handle()`** 메소드에서 해당 상태에서의 동작을 정의합니다. 예를 들어, **`RedLightState`**에서는 "빨간 불 - 정지" 동작을, **`GreenLightState`**에서는 "초록 불 - 진행" 동작을 정의합니다.

상태 패턴을 표현하고 있는 이 구조에서는, 컨텍스트 객체가 현재 상태를 관리하고, 각 상태 객체가 해당 상태에서의 동작을 구현함을 보여주고 있습니다. 상태 패턴은 객체의 상태에 따른 동작을 캡슐화하여 코드를 유지 보수하고 확장하기 쉽게 만들 수 있습니다.

# Javadoc <br>
javadoc 파일은 **StateAfter/docs** 폴더에 있습니다.<br>

# 결론

State Pattern을 활용해 상태 관련 로직을 캡슐화함으로써 유지보수와 확장이 더 쉬워지게 만들어봤습니다.<br>
또한 조건문을 최소화하여 코드의 가독성을 향상시켜보니 이 패턴의 장점을 느낄 수 있었습니다. <br>
이 패턴을 활용해 신호등 프로그램을 짜보니 새로운 상태를 추가하거나 기존 상태를 수정하기 쉬운 것 같고 효율적인 것 같습니다.<br>
