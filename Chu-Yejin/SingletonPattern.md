# Singleton Pattern

## **싱글턴 패턴**

### **싱글턴 패턴이란?**

`Singleton`: 인스턴스를 하나만 생성할 수 있는 클래스 → 단 하나의 유일한 객체

싱글턴 패턴은 어떤 클래스의 인스턴스를 하나만 생성하고, 그 인스턴스에 대한 전역 접근을 제공하는 디자인 패턴입니다. 이는 클래스의 인스턴스가 단 하나만 존재하도록 보장하며, 다른 객체들은 이 인스턴스에 대한 참조를 얻어와 사용할 수 있습니다.

객체 생성 요청이 여러번 발생하더라도 새롭게 메모리를 할당하여 인스턴스를 만드는 것이 아닌 기존에 생성되어 있던 인스턴스를 참조하므로 불필요한 메모리 사용을 줄일 수 있지만, mock 객체를 만들 수 없기 때문에 테스트가 어렵다는 단점이 있습니다.

### **싱글턴 패턴 구현**

```java
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {
        // 초기화 코드
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // 메소드
}
```

private 생성자와 정적 메소드를 통해 인스턴스를 생성하고 반환합니다.

### **싱글턴 패턴의 문제점**

멀티스레드 환경에서 여러 스레드가 동시에 getInstance()를 호출하면 여러 개의 싱글턴 객체가 생성될 수 있습니다.

### **동시성 문제 해결 방법**

1. **Synchronized**

```java
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {
        // 초기화 코드
    }

    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // 메소드
}

```

`synchronized`를 사용하여 getInstance() 메소드를 동기화하면 멀티스레드 환경에서의 동시 접근을 막을 수 있습니다. 하지만 성능 저하가 발생할 수 있습니다.

1. **처음부터 Singleton 인스턴스 생성**

```java
public class Singleton {
    private static Singleton uniqueInstance = new Singleton();

    private Singleton() {
        // 초기화 코드
    }

    public static Singleton getInstance() {
        return uniqueInstance;
    }

    // 메소드
}
```

클래스가 로딩될 때 인스턴스를 생성하므로 동기화 문제와 성능 문제를 해결합니다. 그러나 사용하지 않을 경우 자원이 낭비될 수 있습니다.

1. **DCL(Double-Checked Locking)**

```java
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
        // 초기화 코드
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    // 메소드
}
```

DCL을 사용하여 성능 저하를 최소화하고 동시성 문제를 해결합니다. `volatile` 은 변수의 변경 사항을 즉시 Main Memory에 반영함으로써 멀티스레드 환경에서의 안정성을 보장합니다.

### 직렬화와 리플렉션

1. 직렬화와 역직렬화 (Serialization & Deserialization)
    
    직렬화된 객체를 역직렬화할 때 새로운 인스턴스가 생성되어 싱글턴 속성을 위반할 수 있습니다. 이를 해결하기 위해 `readResolve()` 메소드를 구현할 수 있습니다.
    
2. 리플렉션 (Reflection)
리플렉션을 사용하면 런타임에 private 생성자에 접근하여 새로운 인스턴스를 생성할 수 있으므로, 보안을 위해 리플렉션을 방어하는 코드를 추가해야 합니다.

### **enum class**

```java
public enum SingletonEnum {
    INSTANCE;
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
```

다른 프로그래밍 언어에서 열거형(Enum)은 단순히 정수나 타입이지만, 자바에서의 Enum은 일종의 클래스로 취급됩니다. 이 Enum 객체를 이용하면 아주 간단하게 싱글턴 객체를 구성할 수 있습니다. 애초에 멤버를 만들때 private로 만들고 한번만 초기화 하기 때문에 Enum을 이용한 싱글턴 패턴은 멀티스레드 환경에서 안전하며 직렬화와 리플렉션 문제도 없습니다.

### **정리**

- 싱글턴 패턴은 클래스의 인스턴스를 하나만 생성하고, 그 인스턴스에 대한 전역 접근을 제공합니다.
- **왜 Singleton 패턴을 사용할까요?**
    - 한 번의 객체 생성으로 재사용이 가능하기 때문에 메모리 낭비를 방지할 수 있습니다.
    - 싱글톤으로 생성된 객체는 전역성을 띄기 때문에 다른 객체 간에 공유가 쉽다는 장점이 있습니다.
- **어떤 점을 주의해야할까요?**
    - 싱글톤은 하나의 객체만을 공통으로 사용하고 있기 때문에 싱글톤 객체를 사용하는 객체 간의 결합도가 높아져 Open-Closed Principle에 어긋날 가능성이 있습니다.
    - 싱글톤 객체를 수정할 경우 이를 참조하고 있는 모든 값들이 변경되어야 하기 때문에 변경에 유연하게 대처하기 어렵습니다.
    - 멀티 스레드 환경에서는 동시성 문제와 성능 문제에 주의해야 합니다.
- 자바의 Enum을 사용하는 방법은 가장 안전하고 간편한 싱글톤 구현 방법 중 하나입니다.

## **싱글턴 패턴 예제 프로그램**

물건을 관리하는 창고 시스템을 상상해봅시다. 창고에서는 물건을 추가하고 제거하는 기능이 필요하며, 창고에는 하나의 인스턴스만 있어야 합니다. 이를 싱글톤 패턴을 사용하여 구현해보겠습니다.

‘Manager’는 창고 관리자입니다. 이 관리자는 전국의 창고를 관리하며, 어느 창고에서든 물건을 추가하거나 제거할 수 있습니다. 창고 관리자는 언제나 동일한 인스턴스여야 하며, 어떤 사람이든 창고 관리자를 호출할 때마다 항상 같은 관리자를 얻어야 합니다.

| 클래스 이름 | 설명 |
| --- | --- |
| Manager | 창고의 물건을 관리하는 클래스 |
| main | 동작 테스트용 클래스 |

![Singleton_UML](https://github.com/kimdabeans/PDA-JavaPattern/assets/79244054/39dd5563-1cfd-4a73-94e1-3f4e76359c79)

클래스 다이어그램을 살펴보면, Manager 클래스는 싱글턴 패턴을 적용하여 항상 하나의 유일한 인스턴스를 유지하며, 이 인스턴스를 통해 창고에서 물건을 추가하고 제거할 수 있습니다.

```java
package Singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * 물건을 관리하는 창고의 관리자 클래스입니다.
 * 이 클래스는 싱글톤 패턴을 사용하여 하나의 관리자 인스턴스를 유지합니다.
 */
public class Manager {
    private static Manager instance; // 싱글톤 인스턴스
    private List<String> items; // 창고에 보관된 물건 목록

    /**
     * 외부에서 직접 인스턴스를 생성하지 못하도록, 생성자를 private으로 지정합니다.
     */
    private Manager() {
        items = new ArrayList<>();
    }

    /**
     * 창고 관리자 인스턴스를 얻는 메서드입니다.
     * 이미 인스턴스가 생성되어 있는 경우 기존 인스턴스를 반환하고, 생성되어 있지 않은 경우 새로운 인스턴스를 생성합니다.
     *
     * @return 창고 관리자 인스턴스
     */
    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }

    /**
     * 물건을 창고에 추가하는 메서드입니다.
     *
     * @param item 추가할 물건의 이름
     */
    public void addItem(String item) {
        items.add(item);
        System.out.println(item + "을(를) 창고에 추가했습니다.");
    }

    /**
     * 물건을 창고에서 제거하는 메서드입니다.
     *
     * @param item 제거할 물건의 이름
     */
    public void removeItem(String item) {
        if (items.remove(item)) {
            System.out.println(item + "을(를) 창고에서 제거했습니다.");
        } else {
            System.out.println(item + "을(를) 창고에서 찾을 수 없습니다.");
        }
    }

    /**
     * 현재 창고에 보관된 물건 목록을 조회하는 메서드입니다.
     */
    public void showItems() {
        System.out.println("창고에 보관된 물건 목록:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }
}
```

```java
package Singleton;

/**
 * 창고 시스템을 실행하는 메인 클래스입니다.
 */
public class main {
    public static void main(String[] args) {
        // 창고 관리자 인스턴스를 얻습니다.
        Manager manager = Manager.getInstance();

        // 물건을 창고에 추가합니다.
        manager.addItem("책");
        manager.addItem("의자");
        manager.addItem("컴퓨터");

        // 창고에 보관된 물건 목록을 조회합니다.
        System.out.println("현재 창고 상태:");
        manager.showItems();

        // 물건을 창고에서 제거합니다.
        manager.removeItem("의자");
        manager.removeItem("테이블"); // 창고에 없는 물건을 제거하려고 시도

        // 최종 물건 목록을 다시 조회합니다.
        System.out.println("최종 창고 상태:");
        manager.showItems();
    }
}
```

아래 코드는 **`Manager`** 클래스를 Enum으로 정의하고, **`INSTANCE`**를 통해 싱글톤 인스턴스를 생성합니다. 이렇게 하면 Enum의 특성으로 인해 JVM에서 안전하게 싱글톤이 보장됩니다.

```java
package Singleton_E;

import java.util.ArrayList;
import java.util.List;

/**
 * 물건을 관리하는 창고의 관리자 클래스입니다.
 * 이 클래스는 Enum을 사용하여 싱글톤 패턴을 구현합니다.
 */
public enum Manager {
    INSTANCE; // 싱글톤 인스턴스

    private List<String> items; // 창고에 보관된 물건 목록

    /**
     * Enum 생성자에서 초기화합니다.
     */
    private Manager() {
        items = new ArrayList<>();
    }

    /**
     * 물건을 창고에 추가하는 메서드입니다.
     *
     * @param item 추가할 물건의 이름
     */
    public void addItem(String item) {
        items.add(item);
        System.out.println(item + "을(를) 창고에 추가했습니다.");
    }

    /**
     * 물건을 창고에서 제거하는 메서드입니다.
     *
     * @param item 제거할 물건의 이름
     */
    public void removeItem(String item) {
        if (items.remove(item)) {
            System.out.println(item + "을(를) 창고에서 제거했습니다.");
        } else {
            System.out.println(item + "을(를) 창고에서 찾을 수 없습니다.");
        }
    }

    /**
     * 현재 창고에 보관된 물건 목록을 조회하는 메서드입니다.
     */
    public void showItems() {
        System.out.println("창고에 보관된 물건 목록:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }
}
```

