# Template Method Pattern


> 들어가며

증권업에서는 주문을 처리하는 프로세스가 유사하거나 동일한 경우가 많을 것입니다. 
예를 들어, 주문 유효성 검사, 주문 실행, 주문 확정 처리 등은 다양한 주문 유형에서 공통적으로 수행될 것입니다. Template Method 패턴을 적용하면 이러한 공통된 프로세스를 일관되게 정의할 수 있을 것이라 생각됩니다.

또한 주식 시장이나 금융 시장은 변화가 빠르며 규정 및 정책도 자주 변경됩니다. Template Method 패턴을 사용하면 공통된 프로세스를 한 곳에서 수정하면 되기 때문에 변경 사항을 쉽게 적용할 수 있습니다.

새로운 주문 유형이나 추가적인 주문 처리 단계가 필요한 경우, 새로운 클래스를 생성하여 Template Method를 구현하면 됩니다. 이로써 기존 코드에 영향을 미치지 않고 시스템을 확장할 수 있습니다.

따라서, Template Method Pattern을 정리해보려 합니다.

---
목차는 다음과 같습니다.

1. Template Method Pattern란?
   + 패턴 사용 시기
   + 장단점
2. Template Method Pattern을 적용한 예제 : 주식 매매
   + 비효율적인 코드 : Before
      - 문제 상황
   + Template Method Pattern을 적용한 코드 : After
      - UML 클래스 다이어그램
      - 코드


---

## Template Method Pattern란?
상위 클래스에서 처리의 뼈대를 결정하고 하위 클래스에서 그 구체적 내용을 결정하는 디자인 패턴입니다.

+ GoF의 디자인 패턴에 의하면, 템플릿 메소드 패턴을 아래와 같이 정의합니다.

   > 알고리즘의 구조를 메소드에 정의하고, 하위 클래스에서 알고리즘 구조의 변경없이 알고리즘을 재정의 하는 패턴이다. 알고리즘이 단계별로 나누어 지거나, 같은 역할을 하는 메소드이지만 여러곳에서 다른형태로 사용이 필요한 경우 유용한 패턴이다.

+ 토비의 스프링에 의하면, 템플릿 메소드 패턴을 아래와 같이 정의합니다.

   > 상속을 통해 슈퍼클래스의 기능을 확장할 때 사용하는 가장 대표적인 방법이다. 변하지 않는 기능은 슈퍼클래스에 만들어두고 자주 변경되며 확장할 기능은 서브클래스에서 만들도록 한다.

### 패턴 사용 시기
+ 클라이언트가 알고리즘의 특정 단계만 확장하고, 전체 알고리즘이나 해당 구조는 확장하지 않도록 할때
  
+ 동일한 기능은 상위 클래스에서 정의하면서 확장, 변화가 필요한 부분만 하위 클래스에서 구현할 때
 
### Template Method Pattern 장점
1. 상위 추상클래스로 로직을 공통화 하여 코드의 중복을 줄일 수 있습니다.

2. 서브 클래스의 역할을 줄이고, 핵심 로직을 상위 클래스에서 관리하므로서 관리가 용이해집니다.
3. 클라이언트가 대규모 알고리즘의 특정 부분만 재정의하도록 하여, 알고리즘의 다른 부분에 발생하는 변경 사항의 영향을 덜 받도록 합니다.
   
### Template Method Pattern 단점
1. 알고리즘의 제공된 골격에 의해 유연성이 제한될 수 있습니다.

2. 알고리즘 구조가 복잡할수록 템플릿 로직 형태를 유지하기 어려워진다.
3. 추상 메소드가 많아지면서 클래스의 생성, 관리가 어려워질 수 있습니다.
4. 상위 클래스에서 선언된 추상 메소드를 하위 클래스에서 구현할 때, 그 메소드가 어느 타이밍에서 호출되는지 클래스 로직을 이해해야 할 필요가 있습니다.
5. 로직에 변화가 생겨 상위 클래스를 수정할 때, 모든 서브 클래스의 수정이 필요 할수도 있습니다.
6. 하위 클래스를 통해 기본 단계 구현을 억제하여 리스코프 치환 법칙Visit Website을 위반할 여지가 있습니다.

## Template Method Pattern을 적용한 예제 : 주식 매매

주식 매매 시스템에서 Template Method 패턴은 주로 매매 주문을 처리하는 부분에 적용될 수 있을 것이라 생각합니다. 매매 주문은 매수(Buy), 매도(Sell) 두 가지 주요 동작으로 구성됩니다.


이 두 동작은 공통된 프로세스를 갖고 있지만, 세부적인 구현이 다를 수 있습니다.
이런 상황에서 Template Method 패턴을 사용하면 공통된 프로세스를 추상 클래스로 정의하고, 구체적인 동작인 하위 클래스에서 구현하도록 할 수 있습니다.


Template Method Pattern을 사용하기 전의 코드와 사용한 코드를 비교해보도록 하겠습니다.

### 1. 비효율적인 코드 : Before

```java
// BuyOrder 클래스
public class BuyOrder {

    private String stockSymbol;
    private int quantity;
    private double price;

    public BuyOrder(String stockSymbol, int quantity, double price) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
    }

    public void validateOrder() {
        // 매수 주문 유효성 검사
        // 예: 계좌 잔고 확인, 주식 가격 확인 등
    }

    public void placeOrder() {
        // 주식을 실제로 매수하는 로직
        // 예: 주식 거래소와 통신하여 주문 실행
    }

    public void confirmOrder() {
        // 매수 주문 확정 처리
        // 예: 주문 번호 발급, 거래 내역 저장 등
    }
}
```

```java
// SellOrder 클래스 (매도 주문에 대한 클래스도 비슷하게 구현)
public class SellOrder {

    private String stockSymbol;
    private int quantity;
    private double price;

    public SellOrder(String stockSymbol, int quantity, double price) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
    }

    public void validateOrder() {
        // 매도 주문 유효성 검사
        // 예: 계좌 잔고 확인, 주식 가격 확인 등
    }

    public void placeOrder() {
        // 주식을 실제로 매수하는 로직
        // 예: 주식 거래소와 통신하여 주문 실행
    }

    public void confirmOrder() {
        // 매도 주문 확정 처리
        // 예: 주문 번호 발급, 거래 내역 저장 등
    }
}
```

#### 위 코드의 주요 문제 상황

1. **중복 코드** : 위 코드를 보면, BuyOrder과 SellOrder에서 validateOrder(), placeOrder(), confirmOrder() 같이 코드가 중복되어 있습니다. 코드 중복은 유지 관리 및 확장에 어려움을 초래할 수 있습니다.

2. **유지보수의 어려움** : 유지보수할 때 각 주문 처리 메서드를 변경해야할 경우, 여러 클래스에서 변경해야 합니다. 이로 인해 오류가 발생할 가능성이 높아집니다.

3. **확장성 부족** : 새로운 주문 유형이 추가되거나 주문 처리 프로세스가 변경되어야 하는 경우, 모든 주문 클래스를 수정해야 합니다.

> 이러한 문제를 해결하기 위해 Template Method 패턴을 사용합니다. 주문 처리의 공통된 프로세스를 추상 메서드로 정의하고, 각 주문 유형에서 이를 구체적으로 구현하면 중복 코드가 제거되고, 확장 및 유지보수가 용이해집니다.


### 2. Template Method Pattern을 적용한 코드 : After

#### 클래스 다이어그램
<img src="https://github.com/eunsiver/shinhan-Design-Oattern/assets/76419984/7069c0f2-43f9-4643-b0eb-5b003aefdb90" width=600>

+ `AbstractOrder 클래스`: 이 클래스는 주문 처리 프로세스를 정의하는 템플릿 메서드인 executeOrder()를 포함하고 있습니다. 이 메서드 안에서 주문 처리의 일련의 단계를 나타내며, 각 단계는 추상 메서드로 정의되어 있습니다.

   + validateOrder(): 구체적인 주문 유효성 검사 로직을 구현해야 하는 추상 메서드입니다. 예를 들어, 주문이 유효한지 확인하는 로직이 들어갑니다.
   + placeOrder(): 주문을 실제로 처리하는 로직을 구현해야 하는 추상 메서드입니다. 주문을 실행하는 특정 동작이 이 메서드 안에 들어갑니다.
   + confirmOrder(): 주문을 확정 처리하는 로직을 구현해야 하는 추상 메서드입니다. 주문이 확정되면 주문 번호 발급이나 거래 내역 저장과 같은 작업이 여기서 이루어질 수 있습니다.
+ `BuyOrder 클래스와 SellOrder 클래스`: 이 두 클래스는 AbstractOrder를 상속합니다. 각 클래스는 특정 주문 유형(매수 또는 매도)에 대한 구체적인 로직을 제공합니다.

   + 생성자(BuyOrder와 SellOrder): 주문을 생성할 때 필요한 정보(주식 심볼, 수량, 가격 등)를 받아와서 필드에 저장합니다.
   
   + validateOrder(), placeOrder(), confirmOrder(): 이들 메서드는 상위 클래스에서 정의된 추상 메서드를 구체적으로 구현합니다. 매수 주문과 매도 주문에 따라 각각의 주문 유효성 검사, 주문 처리, 주문 확정 로직을 구현합니다.

 템플릿 메서드 패턴은 주요 동작의 프로세스를 정의하고, 구체적인 단계를 서브클래스에 위임하여 코드 재사용성과 확장성을 높이는 패턴입니다. 이 코드를 통해 매수와 매도 주문의 주문 처리 프로세스를 추상화하여 다양한 주문 유형을 처리할 수 있는 유연한 구조를 제공해보겠습니다.

#### 코드

```java
// AbstractOrder 클래스
public abstract class AbstractOrder {

    // Template Method: 주문 처리 프로세스
    public void executeOrder() {
        validateOrder();
        placeOrder();
        confirmOrder();
    }

    // 하위 클래스에서 구현해야 하는 메서드
    public abstract void validateOrder();
    public abstract void placeOrder();
    public abstract void confirmOrder();
}
```

```java
// BuyOrder 클래스
public class BuyOrder extends AbstractOrder {

    private String stockSymbol;
    private int quantity;
    private double price;

    public BuyOrder(String stockSymbol, int quantity, double price) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public void validateOrder() {
        // 매수 주문 유효성 검사
        // 예: 계좌 잔고 확인, 주식 가격 확인 등
    }

    @Override
    public void placeOrder() {
        // 주식을 실제로 매수하는 로직
        // 예: 주식 거래소와 통신하여 주문 실행
    }

    @Override
    public void confirmOrder() {
        // 매수 주문 확정 처리
        // 예: 주문 번호 발급, 거래 내역 저장 등
    }
}
```

```java
// SellOrder 클래스 (매도 주문에 대한 하위 클래스도 비슷하게 구현)
public class SellOrder extends AbstractOrder {

    private String stockSymbol;
    private int quantity;
    private double price;

    public SellOrder(String stockSymbol, int quantity, double price) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public void validateOrder() {
        // 매도 주문 유효성 검사
        // 예: 보유 주식 확인, 주문 가격 확인 등
    }

    @Override
    public void placeOrder() {
        // 주식을 실제로 매도하는 로직
        // 예: 주식 거래소와 통신하여 주문 실행
    }

    @Override
    public void confirmOrder() {
        // 매도 주문 확정 처리
        // 예: 주문 번호 발급, 거래 내역 저장 등
    }
}
```

StockTradingSystem 클래스: 이 클래스는 실제 주식 매매 시스템을 시뮬레이션하는 예제를 제공합니다. 매수 주문과 매도 주문을 생성하고 executeOrder()를 호출하여 주문 처리 프로세스를 실행합니다.
```java
// 주식 매매 시스템에서 사용 예제
public class StockTradingSystem {
    public static void main(String[] args) {
        // 매수 주문
        AbstractOrder buyOrder = new BuyOrder("AAPL", 100, 150.0);
        buyOrder.executeOrder();

        // 매도 주문
        AbstractOrder sellOrder = new SellOrder("GOOGL", 50, 2500.0);
        sellOrder.executeOrder();
    }
}
```
 
Template Method 패턴을 사용하여 매수 주문과 매도 주문에서 공통된 주문 처리 프로세스를 추상 클래스에 정의하고, 각각의 구체적인 동작을 하위 클래스에서 구현할 수 했습니다. 이렇게 하면 코드의 재사용성을 높이고, 확장 가능한 주문 처리 시스템을 만들 수 있습니다.


----

##### 참고
+ https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%ED%85%9C%ED%94%8C%EB%A6%BF-%EB%A9%94%EC%86%8C%EB%93%9CTemplate-Method-%ED%8C%A8%ED%84%B4-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EB%B0%B0%EC%9B%8C%EB%B3%B4%EC%9E%90
+ https://steady-coding.tistory.com/384
