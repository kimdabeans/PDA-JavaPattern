# Observer Pattern

## **옵저버 패턴**

### **옵저버 패턴이란?**

옵저버 패턴은 어떤 객체의 상태가 변경될 때, 이 객체에 의존하는 다른 객체들에게 자동으로 알림을 보내는 패턴입니다. 이 패턴을 사용하면 느슨한 결합(Loose Coupling)을 구현할 수 있어 객체 간 유연한 상호작용을 가능하게 합니다.

**!!![일대다(one-to-many) 의존성 그림 삽입]**

> **느슨한 결합(Loose Coupling)**
객체들이 상호작용할 수는 있지만, 서로를 잘 모르는 관계를 의미합니다.
주제는 옵저버가 특정 인터페이스를 구현한다는 사실만 알 뿐, 옵저버가 무엇을 하는지 알 필요가 없습니다.
> 

### **Subject & Observer**

- 주제(Subject)는 상태 변화를 감시하고 있는 객체입니다. 주제는 상태 변화가 있을 때, 등록된 모든 옵저버에게 알림을 보내어 업데이트를 트리거합니다.
- 옵저버(Observer)는 주제(Subject)의 상태 변화를 관찰하고 반응하는 객체입니다. 여러 개의 옵저버가 주제에 등록될 수 있으며, 모든 옵저버는 주제의 상태 변경을 받아들이고 적절한 조치를 취합니다.
- **주제와 옵저버간의 데이터를 주고 받는 방식**
    - push: 주제가 옵저버에게 상태를 알리는 방식
    - pull: 옵저버가 주제로부터 상태를 끌어오는 방식주

### 정리

- 옵저버 패턴은 이벤트 처리, MVC 아키텍처, 실시간 데이터 스트리밍 등의 다양한 상황에서 활용됩니다. 주제와 옵저버를 통해 객체 간의 유연하고 확장 가능한 상호작용을 설계할 수 있으며, 코드를 더욱 모듈화하고 관리하기 쉽게 만들 수 있습니다.
- **왜 Observer 패턴을 사용할까요?**
    - 상태 변화를 주기적으로 조회하지 않고 자동으로 감지할 수 있습니다.
    - 코드를 변경하지 않고도 새 구독자 클래스를 도입할 수 있어 Open-Closed Principle을 준수합니다.
    - 상태를 변경하는 객체(주제)와 변경을 감지하는 객체(옵저버)의 관계를 느슨하게 유지할 수 있습니다.
- **어떤 점을 주의해야할까요?**
    - 구독자는 알림 순서를 제어할 수 없고, 무작위 순서로 알림을 받습니다.
    - 다수의 옵저버 객체를 등록 이후 해지하지 않는다면 메모리 누수가 발생할 수 있습니다.

## 옵저버 **패턴 예제 프로그램**

아래는 주식 가격 모니터링 시스템을 구현한 예제 코드입니다.

주식 가격의 변동을 관찰하고, 다양한 투자자에게 해당 변동사항을 통보하는 프로그램입니다. 이 시스템을 옵저버 패턴을 활용하여 구현해보겠습니다.

| 클래스 이름 | 설명 |
| --- | --- |
| StockSubject | 주식 주제(Subject)의 인터페이스 |
| StockObserver | 주식 옵저버(Observer)의 인터페이스 |
| Investor | 주식 투자자를 나타내는 클래스 |
| StockMarket | 주식 시장을 나타내는 클래스 |
| main | 동작 테스트용 클래스 |

![Observer_UML](https://prod-files-secure.s3.us-west-2.amazonaws.com/8c703a41-5bdf-4521-b2c6-403127eda65c/60062ca0-58ff-42e7-beed-81efc6dc8a8e/Untitled.png)

```java
package Observer;

public interface StockSubject {
    void registerObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers(double price);
}
```

```java
package Observer;

public interface StockObserver {
    void update(double price);
}
```

```java
package Observer;

public class Investor implements StockObserver {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name + "님, 주식 가격이 " + price + "로 변동했습니다.");
    }
}
```

```java
package Observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements StockSubject {
    private List<StockObserver> observers = new ArrayList<>();
    private double currentPrice;

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(double price) {
        for (StockObserver observer : observers) {
            observer.update(price);
        }
    }

    // 주식 가격 업데이트 시 호출
    public void updateStockPrice(double newPrice) {
        currentPrice = newPrice;
        notifyObservers(newPrice);
    }
}
```

```java
package Observer;

public class main {

	public static void main(String[] args) {
        // 주식 시장 객체 생성
        StockMarket stockMarket = new StockMarket();

        // 다양한 투자자 객체 생성 및 주식 시장 주제에 등록
        StockObserver investor1 = new Investor("John");
        stockMarket.registerObserver(investor1);

        StockObserver investor2 = new Investor("Alice");
        stockMarket.registerObserver(investor2);

        // 주식 가격 업데이트
        stockMarket.updateStockPrice(150.0); // 주식 가격 상승
        stockMarket.updateStockPrice(130.0); // 주식 가격 하락
    }

}
```

**`StockMarket`** 클래스가 주제(Subject)로 작용하며, 다양한 투자자들이 옵저버(Observer)로 등록되어 주식 가격의 변동을 관찰합니다. 주식 가격이 업데이트될 때마다 등록된 옵저버들에게 알림이 전달되고, 각 투자자는 업데이트 메서드를 호출하여 주식 가격 변동을 처리합니다.

## **중재자 패턴 vs. 옵서버 패턴**

중재자 패턴과 옵서버 패턴은 객체 간 상호작용을 관리하고 통제하는 데 사용되는 두 가지 패턴입니다.

중재자 패턴은 객체 간의 상호작용을 중앙화하고 관리하며, 객체들 사이의 결합도를 낮추는 데 중점을 둡니다. 한편, 옵서버 패턴은 객체의 상태 변화를 다른 객체에 효율적으로 알리기 위한 목적으로 사용되며, 객체 간의 느슨한 결합을 유지합니다.

- 중재자 패턴(Mediator Pattern): 서로 상호작용하는 객체들을 느슨하게 결합하여, 상호작용 로직을 캡슐화하고 중앙에서 관리합니다.
    - 장점
        - 시스템과 객체를 분리하여 재사용성을 향상시킵니다.
        - 제어 로직을 중앙화하여 관리가 용이합니다.
        - 객체 간 메시지 교환을 단순화하고 줄일 수 있습니다.
    - 단점: 중재자 객체가 복잡해질 수 있으며, 관리가 어려울 수 있습니다.
    - 서로 연관된 GUI 구성 요소와 같이 객체 간의 복잡한 상호작용을 관리하는 데 자주 사용됩니다.
- 옵서버 패턴(Observer Pattern): 객체 간의 일대다(one-to-many) 의존성을 정의하여 한 객체의 상태 변화가 다른 객체에 통지될 때 사용됩니다.
    - 장점
        - 객체 간의 상호작용을 분리하여 재사용성을 높입니다.
        - 주제(Subject)와 옵저버(Observer)를 독립적으로 재사용할 수 있습니다.
        - 특정 객체의 상태 변화를 다수의 객체에게 효율적으로 알릴 수 있습니다.
    - 단점: 상호작용 흐름을 이해하기 어려울 수 있으며, 복잡한 시나리오에서는 관리가 어려울 수 있습니다.
    - 상태 변화를 여러 객체에 통지해야 하는 경우, 이벤트 처리 및 GUI 업데이트와 같이 객체 간의 느슨한 결합이 필요한 상황에서 주로 사용됩니다.

---