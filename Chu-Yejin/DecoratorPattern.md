# Decorator Pattern

## **데코레이터 패턴**

### **데코레이터 패턴이란?**

데코레이터 패턴은 객체에 추가 요소를 동적으로 더할 수 있는 패턴입니다. 이 패턴을 사용하면 기본 객체의 수정 없이 유연하게 기능을 확장할 수 있습니다.

데코레이터 패턴의 핵심 아이디어는 기본 객체(ConcreteComponent)를 감싸는 데코레이터(Decorator) 클래스를 생성하는 것입니다. 이 데코레이터 클래스는 동일한 인터페이스를 구현하고, 내부에 실제 기본 객체를 포함합니다. 이후 여러 개의 데코레이터 클래스를 조합하여 객체에 새로운 기능을 추가하거나 변경할 수 있습니다.

### 관련 패턴

- **Strategy 패턴**: Strategy 패턴은 객체가 특정 행동을 수행할 때, 해당 행동을 변경하거나 확장하기 위한 패턴입니다. 주로 알고리즘을 캡슐화하고 실행 중에 교체할 때 사용됩니다. 기존의 객체에 수정이 가해집니다.
- **Adapter 패턴**: Adapter 패턴은 서로 다른 인터페이스를 가진 두 객체 간에 상호 작용을 가능하게 하는 패턴입니다. 즉, 한 객체의 인터페이스를 다른 객체의 인터페이스에 맞추어줍니다.
- **Proxy 패턴**: Proxy 패턴은 다른 객체의 대리자 역할을 하는 객체를 제공하여, 실제 객체에 대한 접근을 제어하거나 추가적인 동작을 수행하는 패턴입니다.

### **정리**

- 데코레이터는 자기가 감싸고 있는 구성 요소의 메소드를 호출한 결과에 새로운 기능을 더함으로써 행동을 확장합니다.
- Open-Closed Principle을 준수합니다.
- 구성 요소를 감싸는 데코레이터의 개수에는 제한이 없습니다.
- 구성 요소의 클라이언트는 데코레이터의 존재를 알 수 없습니다.
- 데코레이터 패턴을 사용하면 작은 객체들이 매우 많이 추가될 수 있습니다. → 코드가 필요 이상으로 복잡해질 수 있습니다.
- **언제 Decorator 패턴을 사용하면 좋을까요?**
    - 객체의 책임이나 행동이 동적으로 바뀌어야할 때
    - 기존 클래스의 서브 클래스 만드는 것이 불가능하거나 비효율적일 때
    - 수용가능한 정도의 자잘한 크기의 객체들이 많이 등장할 때

## 데코레이터 **패턴 예제 프로그램**

스마트폰은 기본으로 전화와 문자 메시지 기능을 제공하고, 사용자는 앱을 추가하여 스마트폰에 다양한 기능을 추가할 수 있습니다. 스마트폰의 기능을 확장하는 데코레이터 패턴을 사용하여 카메라, 음악, 지도 등 다양한 앱을 추가하고, 각 앱의 추가 여부에 따라 전체 스마트폰의 가격과 기능을 동적으로 변경할 수 있도록 구현해보겠습니다.

| 클래스 이름 | 설명 |
| --- | --- |
| Smartphone | 스마트폰을 나타내는 추상 클래스 |
| BasicSmartphone | 기본 스마트폰을 나타내는 클래스 |
| AppDecorator | 앱 데코레이터를 나타내는 추상 클래스 |
| CameraApp | 카메라 앱을 나타내는 클래스 |
| MusicApp | 음악 앱을 나타내는 클래스 |
| main | 동작 테스트용 클래스 |

![Decorator_UML](https://github.com/kimdabeans/PDA-JavaPattern/assets/79244054/cedb4750-f638-4ea2-a0b9-16b7f9d31f67)

클라이언트는 기본 스마트폰 객체를 생성한 후, 필요한 앱 데코레이터를 추가하여 스마트폰의 설명과 가격을 동적으로 확장합니다. 이를 통해 기본 스마트폰에 필요한 앱들을 선택적으로 추가하거나 조합할 수 있습니다.

Smartphone은 추상 클래스로, 기본 스마트폰의 설명과 가격을 관리합니다. 데코레이터 패턴의 컴포넌트 역할을 합니다.
AppDecorator는 앱을 나타내는 추상 데코레이터 클래스로, 스마트폰에 추가될 앱들을 확장하는 역할을 합니다.
BasicSmartphone은 실제 구현체로, 기본 스마트폰의 설명과 가격을 정의합니다.
CameraApp은 앱 데코레이터 중 하나로, 스마트폰에 카메라 앱을 추가한 설명과 가격을 정의합니다.
MusicApp은 앱 데코레이터 중 하나로, 스마트폰에 음악 앱을 추가한 설명과 가격을 정의합니다.

```java
package decorator;

/**
 * 스마트폰에 추가 앱을 데코레이팅하는 역할을 합니다.
 */
public abstract class AppDecorator extends Smartphone {

    /**
     * 앱의 설명을 반환하는 추상 메서드입니다.
     *
     * @return 앱의 설명 문자열
     */
    public abstract String getDescription();
}
```

```java
package decorator;

/**
 * 스마트폰을 나타내는 추상클래스입니다.
 */
public abstract class Smartphone {
    protected String description = "Smartphone";

    /**
     * 스마트폰의 설명을 반환하는 메서드입니다.
     *
     * @return 스마트폰의 설명 문자열
     */
    public String getDescription() {
        return description;
    }

    /**
     * 스마트폰의 가격을 반환하는 추상 메서드입니다.
     *
     * @return 스마트폰의 가격
     */
    public abstract double cost();
}
```

```java
package decorator;

/**
 * 기본 스마트폰 클래스입니다.
 */
public class BasicSmartphone extends Smartphone {

    /**
     * 기본 스마트폰의 생성자입니다.
     */
    public BasicSmartphone() {
        description = "Basic Smartphone";
    }

    /**
     * 스마트폰의 가격을 반환하는 메서드입니다.
     *
     * @return 스마트폰의 가격
     */
    public double cost() {
        return 200.0;
    }
}
```

```java
package decorator;

/**
 * 스마트폰에 카메라 앱을 추가할 수 있는 클래스입니다.
 */
public class CameraApp extends AppDecorator {
    private Smartphone smartphone;

    /**
     * 카메라 앱의 생성자입니다.
     *
     * @param smartphone 스마트폰 객체
     */
    public CameraApp(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    /**
     * 스마트폰의 설명에 카메라 앱을 추가한 문자열을 반환하는 메서드입니다.
     *
     * @return 스마트폰 설명에 카메라 앱이 추가된 문자열
     */
    public String getDescription() {
        return smartphone.getDescription() + ", Camera App";
    }

    /**
     * 스마트폰 가격에 카메라 앱의 가격을 추가한 총 가격을 반환하는 메서드입니다.
     *
     * @return 스마트폰 가격에 카메라 앱 가격을 추가한 총 가격
     */
    public double cost() {
        return smartphone.cost() + 50.0;
    }
}
```

```java
package decorator;

/**
 * 스마트폰에 음악 앱을 추가할 수 있는 클래스입니다.
 */
public class MusicApp extends AppDecorator {
    private Smartphone smartphone;

    /**
     * 음악 앱의 생성자입니다.
     *
     * @param smartphone 스마트폰 객체
     */
    public MusicApp(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    /**
     * 스마트폰의 설명에 음악 앱을 추가한 문자열을 반환하는 메서드입니다.
     *
     * @return 스마트폰 설명에 음악 앱이 추가된 문자열
     */
    public String getDescription() {
        return smartphone.getDescription() + ", Music App";
    }

    /**
     * 스마트폰 가격에 음악 앱의 가격을 추가한 총 가격을 반환하는 메서드입니다.
     *
     * @return 스마트폰 가격에 음악 앱 가격을 추가한 총 가격
     */
    public double cost() {
        return smartphone.cost() + 30.0;
    }
}
```

```java
package decorator;

/**
 * 스마트폰에 앱을 추가하고 구매 정보를 출력하는 메인 클래스입니다.
 */
public class main {
    public static void main(String[] args) {
        // 기본 스마트폰 생성
        Smartphone smartphone = new BasicSmartphone();

        // 카메라 앱 추가
        smartphone = new CameraApp(smartphone);

        // 음악 앱 추가
        smartphone = new MusicApp(smartphone);

        // 최종 스마트폰 구매 정보 출력
        System.out.println("Smartphone: " + smartphone.getDescription());
        System.out.println("최종 금액: $" + smartphone.cost());
    }
}
```

BasicSmartphone 객체가 있는 상황을 상상해봅시다. 카메라 앱을 추가하고자 하면 이를 Camera App 객체로 감싸고, 여기에 음악 앱을 추가하고자 하면 MusicApp 객체로 감쌉니다. 이렇게 기존의 객체를 수정하는 것이 아니라 감싸는 과정(wrapping)을 통해 객체에 추가 요소를 동적으로 더할 수 있고, 서브클래스를 만들 때보다 유연하게 확장할 수 있습니다.

![decorating](https://github.com/kimdabeans/PDA-JavaPattern/assets/79244054/c12de503-59d2-4b1e-86ee-78f791ec2c51)

상속을 통해 서브클래스를 생성할 때, 그 행동은 컴파일 시점에서 완전히 결정되며, 모든 서브클래스에서 동일한 행동을 상속받아야 합니다. 그러나 객체의 행동을 확장하기 위해 구성을 사용하면, 기존 코드를 수정하지 않고도 새로운 코드를 만들어 실행 중에 동적으로 행동을 설정 할 수 있습니다. 이러한 방식은 코드 수정에 따른 버그나 의도하지 않은 부작용을 예방하는 데 도움이 됩니다.

하지만 데코레이터 패턴은 작은 객체들이 많이 추가될 수 있어서 코드가 복잡해질 수 있는 단점이 있습니다. 데코레이터 패턴의 복잡성을 관리하고 코드를 더 유연하게 만들기 위해 팩토리 패턴 또는 빌더 패턴을 사용할 수 있습니다.

먼저, 여러 데코레이터 객체를 생성하고 조합하는 부분을 팩토리 클래스로 분리하는 팩토리 패턴을 사용할 수 있습니다. 이렇게 하면 객체 생성과 조합 로직이 분리되어 코드를 더 간결하게 관리할 수 있습니다.

```java
// 팩토리 클래스
public class SmartphoneFactory {
    public static Smartphone createSmartphoneWithCameraAndMusicApp() {
        Smartphone smartphone = new BasicSmartphone();
        smartphone = new CameraApp(smartphone);
        smartphone = new MusicApp(smartphone);
        return smartphone;
    }
}

// 클라이언트 코드
public class Client {
    public static void main(String[] args) {
        Smartphone smartphone = SmartphoneFactory.createSmartphoneWithCameraAndMusicApp();
        System.out.println("Smartphone: " + smartphone.getDescription());
        System.out.println("최종 금액: $" + smartphone.cost());
    }
}
```

빌더 패턴을 사용하는 경우, 객체를 구성하는 과정을 더 유연하게 만들 수 있습니다. 클라이언트는 원하는 데코레이터를 선택하여 객체를 구성할 수 있습니다.

```java
// 빌더 인터페이스
public interface SmartphoneBuilder {
    Smartphone build();
}

// 빌더 구현 클래스
public class SmartphoneWithCameraAndMusicAppBuilder implements SmartphoneBuilder {
    private Smartphone smartphone;

    public SmartphoneWithCameraAndMusicAppBuilder() {
        smartphone = new BasicSmartphone();
        smartphone = new CameraApp(smartphone);
        smartphone = new MusicApp(smartphone);
    }

    public Smartphone build() {
        return smartphone;
    }
}

// 클라이언트 코드
public class Client {
    public static void main(String[] args) {
        SmartphoneBuilder builder = new SmartphoneWithCameraAndMusicAppBuilder();
        Smartphone smartphone = builder.build();
        System.out.println("Smartphone: " + smartphone.getDescription());
        System.out.println("최종 금액: $" + smartphone.cost());
    }
}
```

