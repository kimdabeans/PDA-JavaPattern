# Strategy Pattern


> 들어가며

증권 시장은 빠르게 변화하고, 안정성과 신뢰성이 매우 중요한 분야입니다.
디자인 패턴은 이러한 환경에서 안정성을 제공하고, 빠르게 변화하는 요구사항에 대응할 수 있도록 도와주기 때문에 증권 개발에서 디자인 패턴의 적용은 중요한 역할을 합니다.
증권 시스템 개발에서 가장 많이 사용될만한 디자인 패턴을 정리해보고자 하며 첫번째로 **Strategy Pattern**을 선택했습니다.


증권 개발에서는 다양한 거래 전략을 구현하고 유연하게 교체해야할 때가 많을 것이라고 생각됩니다.
Strategy Pattern을 사용하면 **각 전략들을 독립적으로 구현하고 실행할 수 있으며, 시스템의 유연성과 확장성을 향상시킵니다.**


Strategy Pattern을 UML 클래스 다이어그램, 코드와 함께 여러 예제를 통해 더욱 자세하게 알아보겠습니다.


----
목차는 다음과 같습니다.

1. Strategy Pattern란?
   + Strategy Pattern 특징
   + 사용 시기
   + 패턴 장단점
    
2. Strategy Pattern 예제 1: 주식, 선물, 옵션에 따른 매매 전략
   +  클린하지 않은 문제의 코드 : before
   +  Strategy Pattern을 사용하여 변경한 코드 : after
       - UML 클래스 다이어그램
       - 코드
3. 좀 더 확장한 Strategy Pattern 예제 2 : 주식 트레이딩 시뮬레이션의 유연한 전략 교체
   + Strategy Pattern을 적용하지 않은 코드 : before
       - 문제 발생 상황
   +  Strategy Pattern을 이용한 코드 :after
       - UML 클래스 다이어그램
       - 코드
4. 정리

----

## Strategy Pattern란?

전략 패턴은 **실행(런타임) 중에 알고리즘(전략, 작전, 방안)을 선택하여 객체의 동작을 실시간으로 바뀌도록 하는 행위 디자인 패턴**입니다..


즉, 어떤 일을 수행하는 알고리즘이 여러가지 일때, 동작들을 미리 전략으로 정의함으로써 손쉽게 전략을 교체할 수 있는, **알고리즘 변형이 빈번하게 필요한 경우**에 적합한 패턴입니다.

<img src="https://github.com/eunsiver/shinhan-Design-Oattern/assets/76419984/de139aa6-78d5-4f7c-9918-79784f012ea0" width="700" >

* Strategy(전략) 역 : 모든 전략 구현체에 대한 공용 인터페이스입니다.
* ConcreteStrategy(구체적인 전략) 역: Strategy 역의 인터페이스를 실제로 구현합니다. 여기서 구체적인 전략(작전, 방안, 방법, 알고리즘)을 실제로 프로그래밍합니다.
* Context(문맥) 역 : Strategy 역을 이용합니다. ConcreteStrategy의 인스턴스를 갖고 있다가 필요에 따라서 이용합니다.(어디까지나 호출하는 것은 Strategy의 인터페이스입니다.

> 프로그래밍에서 Context란 Contents를 담는 그 무언가를 뜻하며, 어떤 객체를 핸들링하기 위해 접근 수단입니다.
> 즉, 물컴에 물이 담겨 있으면 물은 Contents가 되고, 물컵은 Context가 되며, 물을 핸들링 하기 위한 접근 수단이 됩니다.

### Strategy Pattern 특징
### 사용 시기
* 전략 알고리즘의 여러 버전 또는 변형이 필요할 때 클래스화를 통해 관리
* 알고리즘 코드가 노출되어서는 안 되는 데이터에 액세스 하거나 데이터를 활용할 때 **(캡슐화)**
* 알고리즘의 동작이 **런타임에 실시간으로 교체** 되어야 할때

### 장점
* 알고리즘을 정의하고 캡슐화하여 런타임 시에 알고리즘을 선택하는 데 사용됨
* 알고리즘을 쉽게 변경 및 대체할 수 있으므로 유연함
* 알고리즘 추가 및 수정을 할 때 코드 수정이 최소화되므로 확장성이 높아짐
* 알고리즘을 캡슐화했기에 코드 재사용성이 좋음
* 각각 알고리즘을 독립적으로 테스트할 수 있으므로 용이함

### 단점
* 추가적인 클래스 및 인터페이스가 필요하기에 코드 복잡성이 증가될 수 있음
* 런타임 시에 알고리즘을 선택하는 데 추가적인 오버헤드 발생 가능
* 전략패턴을 구현하는 것이 어려울 수 있으므로, 적절한 분석과 설계가 필요함


## Strategy Pattern 예제 1: 주식, 선물, 옵션에 따른 매매 전략

증권 시스템 개발에 접목하여 주식, 선물, 옵션에 따라 매매 전략을 변경하는 예시를 들어보겠습니다.

### 클린하지 않은 문제의 코드 : Before
```java
public class TradingSystem {
    public static final int STOCK=0;
    public static final int FUTURES=1;
    public static final int OPTIONS=2;

    private int state;

    public void setStrategy(int state) {
        this.state = state;
    }

    public void executeTrading() {
        if (state == STOCK) {
            System.out.println("주식 매매 전략을 실행합니다.");
        } else if (state == FUTURES) {
            System.out.println("선물 매매 전략을 실행합니다.");
        } else if (state == OPTIONS) {
           System.out.println("옵션 매매 전략을 실행합니다.");
        }
    }
}
```

```java
public class Client {
    public static void main(String[] args) {

        TradingSystem tradingSystem = new TradingSystem();

        // 주식(Stock) 전략을 선택하고 실행합니다.
        tradingSystem.setStrategy(TradingSystem.STOCK);
        tradingSystem.executeTrading(); 

        // 선물(Futures) 전략을 선택하고 실행합니다.
        tradingSystem.setStrategy(TradingSystem.FUTURES);
        tradingSystem.executeTrading();
    }
}
```
위 코드를 살펴보면 state 매개변수의 값에 따라서 간접적으로 executeTrading() 함수의 동작을 제어하도록 되어 있습니다.
상태에 따라 다른 전략을 실행하려면 상수를 메소드에 전달하여 조건문으로 필터링하고 해당 전략을 실행합니다.

그러나 상태 변수를 통한 분기문은 가독성이 떨어질 뿐 아니라 새로운 전략을 추가할 때 코드를 변경해야 하므로 확장성이 부족합니다. 또한 if else 지옥에 빠질 수 있기 때문에 좋지 않은 코드 입니다.

코드를 더 개선하려면 Strategy Pattern을 사용하여 상태에 따른 분기문을 제거하고 각 전략을 독립적으로 관리하는 것이 좋습니다.


### Strategy Pattern을 사용하여 변경한 코드 : After
#### 클래스 구성
<img src="https://github.com/eunsiver/shinhan-Design-Oattern/assets/76419984/6a283db0-9e88-4a6b-b6e6-78003c67f4a2" width="1000" >

* `TradingStrategy` 인터페이스: 이 인터페이스는 모든 거래 전략 클래스가 구현해야 하는 메소드를 정의합니다. `executeStrategy` 메소드는 구체적인 거래 전략을 실행하는데 사용됩니다.

* 구체적인 거래 전략 클래스: 이 클래스들은 `TradingStrategy` 인터페이스를 구현하고, 특정한 종류의 거래 전략을 구체적으로 정의합니다. 각 클래스는 `executeStrategy` 메소드를 오버라이드하여 해당 전략을 실행합니다.

  - `StockTradingStrategy`: 주식 매매 전략을 정의하는 클래스입니다.
  - `FuturesTradingStrategy`: 선물 매매 전략을 정의하는 클래스입니다.
  - `OptionsTradingStrategy`: 옵션 매매 전략을 정의하는 클래스입니다.

* `TradingSystem` 클래스: 이 클래스는 거래 전략을 사용하는 컨텍스트를 나타냅니다. `TradingStrategy` 인터페이스 형태의 전략 객체를 가지며, 이 객체를 사용하여 거래를 실행합니다. `setStrategy` 메소드를 사용하여 전략을 설정하고, `executeTrading` 메소드를 호출하여 전략을 실행합니다. 이 클래스는 전략 객체를 동적으로 교체할 수 있습니다.

전략 패턴을 사용하면 거래 전략과 같이 알고리즘이 변경 가능한 부분을 클래스로 캡슐화하고, 실행 시간에 전략을 선택하거나 변경할 수 있어 시스템의 유연성과 확장성을 높일 수 있습니다.

#### 코드

```JAVA
// 전략 인터페이스
public interface TradingStrategy {
   public abstract void executeStrategy();
}

// 구체적인 주식 매매 전략
public class StockTradingStrategy implements TradingStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("주식 매매 전략을 실행합니다.");
        // 주식 매매에 대한 구체적인 로직을 구현합니다.
    }
}

// 구체적인 선물 매매 전략
public class FuturesTradingStrategy implements TradingStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("선물 매매 전략을 실행합니다.");
        // 선물 매매에 대한 구체적인 로직을 구현합니다.
    }
}

// 구체적인 옵션 매매 전략
public class OptionsTradingStrategy implements TradingStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("옵션 매매 전략을 실행합니다.");
        // 옵션 매매에 대한 구체적인 로직을 구현합니다.
    }
}
```

```java
// 전략을 사용하는 컨텍스트 클래스
public class TradingSystem {
    private TradingStrategy strategy;

    public void setStrategy(TradingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeTrading() {
        strategy.executeStrategy();
        // 다른 공통 로직을 수행합니다.
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        TradingSystem tradingSystem = new TradingSystem();

        // 주식 매매 전략 사용
        tradingSystem.setStrategy(new StockTradingStrategy());
        tradingSystem.executeTrading();

        // 선물 매매 전략 사용
        tradingSystem.setStrategy(new FuturesTradingStrategy());
        tradingSystem.executeTrading();

        // 옵션 매매 전략 사용
        tradingSystem.setStrategy(new OptionsTradingStrategy());
        tradingSystem.executeTrading();
    }
}
```
필요에 따라 새로운 전략을 추가하려면 해당 전략을 구현한 클래스를 작성하고, 이를 TradingSystem에서 사용하도록 설정하면 더 다양한 매매 전략을 지원하고 확장하기 쉬워집니다.
즉, 추가로 전략을 등록할때, 코드의 수정없이 빠르게 기능을 확장할 수 있습니다.
결국 OOP의 핵심인 유지보수를 용이하게 하기 위해, 이러한 Strategy Pattern을 적용하여 프로그램을 구성해나가야 합니다.

## 좀 더 확장한 Strategy Pattern : 주식 트레이딩 시뮬레이션의 유연한 전략 교체

이번에는 주식 매수로 전략 패턴을 사용해보겠습니다.
먼저 OCP에 위반한 코드를 보겠습니다.

주식은 하는 사람들은 저마다 매수 전략과 매도 전략이 있습니다.
이를 코드로 표현하며 다음과 같습니다.

### 시나리오
* 길동이는 ROE 지표를 보고 매수를 하고, 목표가가 되면 매도합니다.
* 민수는 PER 지표를 보고 매수하고, 목표가가 되면 매도합니다.

### Strategy Pattern을 적용하지 않은 코드

```java
public abstract class StockTrader {
	public abstract void buy();
	public abstract void sell();
}

class Gildong extends StockTrader {
	@Override
	public void buy() {
		System.out.println("by ROE");
	}

	@Override
	public void sell() {
		System.out.println("by target");
	}
}

class Minsu extends StockTrader {
	@Override
	public void buy() {
		System.out.println("by PER");
	}

	@Override
	public void sell() {
		System.out.println("by target");
	}
}

public class Main {
	public static void main(String[] args) {
		// Chulsu 객체 생성
		Gildong chulsu = new Gildong();
		System.out.println("Gildong's trading strategies:");
		chulsu.buy();
		chulsu.sell();

		// Minsu 객체 생성
		Minsu minsu = new Minsu();
		System.out.println("\nMinsu's trading strategies:");
		minsu.buy();
		minsu.sell();
	}
}
```

실행 결과는 다음과 같습니다.
```
Gildong's trading strategies:
by ROE
by target

Minsu's trading strategies:
by PER
by target
```
#### 문제 발생 지점
PER 지표를 보고 매수하는 민수가 ROE 지표를 보고 매수하는 철수보다 수익률이 좋아서, 길동이도 PER 지표로 매수 전략을 바꾸려고 합니다.
> 그러나 이는 철수의 코드를 고쳐야하기 때문에 OCP에 위배된 코드가 됩니다.

목표가 매도 전략은 두 사람 모두 사용합니다. 만약 목표가 매도 전략을 수정해야한다면, 두 사람의 코드 모두 변경해야 합니다. 
> 이 부분이 DRY 원칙에 위배되고 수정할 때 한쪽만 수정하거나 잘못 수정하면 버그가 발생할 확률이 높습니다.

이 문제를 Strategy Pattern을 이용해 해결해보겠습니다.

### Strategy Pattern을 이용한 코드

#### UML 클래스 다이어그램
<img src="https://github.com/eunsiver/shinhan-Design-Oattern/assets/76419984/7673fa0c-56fb-4aab-a9f7-337ca0e27d19" width=1000>

전략 패턴(Strategy Pattern)을 사용하여 주식 거래자(Gildong와 Minsu)의 매수와 매도 전략을 동적으로 변경할 수 있는 예제입니다.

* BuyStrategy 인터페이스: 주식 매수 전략을 정의하는 인터페이스입니다. 이 인터페이스에는 buy 메소드가 선언되어 있습니다.

* BuyRoe 클래스와 BuyPer 클래스: BuyStrategy 인터페이스를 구현하는 구체적인 클래스입니다. BuyRoe 클래스는 ROE(주당순이익)를 기반으로 주식을 매수하는 전략을 나타내고, BuyPer 클래스는 PER(주가수익비율)를 기반으로 주식을 매수하는 전략을 나타냅니다.

* SellStrategy 인터페이스: 주식 매도 전략을 정의하는 인터페이스입니다. 이 인터페이스에는 sell 메소드가 선언되어 있습니다.

* SellTarget 클래스: SellStrategy 인터페이스를 구현하는 구체적인 클래스로, 목표 가격에 도달했을 때 주식을 매도하는 전략을 나타냅니다.

* StockTrader 추상 클래스: 이 클래스는 주식 거래자를 나타내며, 주식 매수 전략과 매도 전략을 가지고 있습니다. 생성자를 통해 초기 전략을 설정하고, setBuyStrategy와 setSellStrategy 메소드를 사용하여 동적으로 전략을 변경할 수 있습니다. buy와 sell 메소드는 현재 설정된 매수 및 매도 전략을 실행합니다.

* Gildong 클래스와 Minsu 클래스: StockTrader를 상속받는 구체적인 주식 거래자 클래스입니다. 각 주식 거래자 객체는 자신만의 매수 전략과 매도 전략을 가지고 있습니다.

#### 코드

```java
// BuyStrategy 인터페이스
public interface BuyStrategy {
    public abstract void buy();
}

// BuyRoe 클래스
public class BuyRoe implements BuyStrategy {
    @Override
    public void buy() {
        System.out.println("by ROE");
    }
}

// BuyPer 클래스
public class BuyPer implements BuyStrategy {
    @Override
    public void buy() {
        System.out.println("by PER");
    }
}
```

```java
// SellStrategy 인터페이스
public interface SellStrategy {
    public abstract void sell();
}

// SellTarget 클래스
public class SellTarget implements SellStrategy {
    @Override
    public void sell() {
        System.out.println("by target");
    }
}
```

```java
// StockTrader 클래스
public abstract class StockTrader {
    private SellStrategy sellStrategy;
    private BuyStrategy buyStrategy;

    public StockTrader(BuyStrategy buyStrategy,SellStrategy sellStrategy){
	this.buyStrategy = buyStrategy;
	this.sellStrategy = sellStrategy;
    }

    public void setBuyStrategy(BuyStrategy buyStrategy) {
        this.buyStrategy = buyStrategy;
    }

    public void setSellStrategy(SellStrategy sellStrategy) {
        this.sellStrategy = sellStrategy;
    }

    public void buy() {
        buyStrategy.buy();
    }

    public void sell() {
        sellStrategy.sell();
    }
}
```

```java
// Gildong 클래스
class Gildong extends StockTrader {
	public Gildong(BuyStrategy buyStrategy, SellStrategy sellStrategy) {
		super(buyStrategy, sellStrategy);
	}
}

// Minsu 클래스
class Minsu extends StockTrader {
	public Minsu(BuyStrategy buyStrategy, SellStrategy sellStrategy) {
		super(buyStrategy, sellStrategy);
	}
}
```

이제 Gildong의 ROE 매수 전략을 PER 매수 전략으로 동적으로 변경해보겠습니다.

```java
// Main 클래스
public class Main {
    public static void main(String[] args) {
	
      BuyStrategy gildongBuyStrategy = new BuyRoe(); // Gildong의 매수 전략
      SellStrategy gildongSellStrategy = new SellTarget(); // Gildong의 매도 전략
      Gildong gildong = new Gildong(gildongBuyStrategy, gildongSellStrategy);

      // Minsu 객체 생성
      BuyStrategy minsuBuyStrategy = new BuyPer(); //Minsu의 매수 전략
      SellStrategy minsuSellStrategy = new SellTarget(); // Minsu의 매도 전략
      Minsu minsu = new Minsu(minsuBuyStrategy, minsuSellStrategy);

      System.out.println("\nMinsu's trading strategies:");
      minsu.buy();
      minsu.sell();

      System.out.println("Gildong's trading strategies:");
      gildong.buy();
      gildong.sell();

      // 동적으로 길동의 매수 전략 변경
      gildong.setBuyStrategy(new BuyPer());
      System.out.println("\nGildong's updated trading strategies:");
      gildong.buy();
      gildong.sell();

    }
}
```

위 코드의 결과는 다음과 같습니다.
```
Gildong's trading strategies:
by ROE
by target

Minsu's trading strategies:
by PER
by target

Gildong's updated trading strategies:
by PER
by target
```

다음과 같이 코드를 변경하면,
1. 길동과 민수의 매매 전략을 setter 메서드로 언제든 자유롭고 손쉽게 변경할 수 있습니다.
2. PER, ROE 전략 외에 PBR, EPS, EV/EBITDA 등의 다른 매수 전략도 BuyStrategy 클래스를 상속받아 추가할 수 있습니다.
3. StockTrader의 코드는 매수 매도 전략에 의해 변경될 일은 없어졌습니다.
4. 반복된 매도 방법에 대한 코드 또한 Sell 전략에 의해 재사용될 수 있게 됐습니다.

이처럼 StockTrader 클래스가 두 행동을 상속 또는 구현하는 것이 아니라 구성(Composition)되어 행동을 부여받는 전략 패턴을 사용해보았습니다.

## 정리

매매 전략을 통해 Strategy Pattern을 알아 봤습니다.

정리하자면, 전략 패턴(Strategy Pattern)은 행위 패턴 중 하나로, 알고리즘을 정의하고 이를 캡슐화하여 동적으로 교환 가능하게 하는 디자인 패턴입니다. 이를 통해 객체의 행동을 변경하고 확장하기 용이하며, 유지보수성과 유연성을 증가시킵니다.

전략 패턴을 활용하여 증권 분야에서 고객 서비스 향상과 효율적인 자산 관리를 위한 기반을 마련하고 안정적인 수익을 추구하는데 도움을 주는 개발자가 되겠습니다.
