# Factory Method Pattern

> 들어가며

증권 시스템과 같이 다양한 객체가 동적으로 생성되고 확장 가능해야 하는 상황에서 팩토리 메소드 패턴은 객체 생성과 관련된 복잡성을 관리하고 시스템을 더 견고하고 확장 가능하게 만드는데 도움을 줍니다.


증권 시스템은 시간이 지남에 따라 새로운 유형의 금융 상품이나 증권 종류가 계속해서 추가될 수 있습니다. 팩토리 메소드 패턴을 사용하면 이러한 새로운 객체 유형을 손쉽게 추가할 수 있습니다. 각 새로운 객체 유형에 대한 팩토리를 만들어서 기존 코드를 수정하지 않고도 시스템을 확장할 수 있습니다.

더 자세하게 Factory Method Pattern에 대해 알아보겠습니다.


---

목차는 다음과 같습니다.

1. Factory Method Pattern란?
   + 기본 UML 클래스 다이어그램
   + 사용시기
   + 장단점
2. 증권에 적용한 Factory Method Pattern 예제 : 금융 제품 관리와 공장 메서드 패턴 활용
   + 패턴 적용 전 비효율적인 코드 : before
   + Factory Method Pattern 적용 코드 : after
       - UML 클래스 다이어그램
       - 코드
3. 더 나아가서 적용해보면 좋을 패턴
4. 정리

---

## Factory Method Pattern란?
### Factory Method Pattern 기본 클래스 다이어그램
<img src="https://github.com/eunsiver/shinhan-Design-Oattern/assets/76419984/14ec8c49-4d9c-4336-84b5-f72bcefe7122" width=600>

클래스 다이어그램을 보면, 상위 클래스(추상적인 뼈대, 프레임워크) 쪽에 있는 Creator와 Product의 관계가 하위 클래스(살을 붙인 구체적인 내용)이 있는 ConcreteCreator와 ConcreteProduct의 관계와 병행하고 있음을 알 수 있습니다.

+ 프레임워크

    * Product : 제품 구현을 추상화
      
    * Creator : Product 역을 생성하는 추상 클래스입니다. 구체적인 내용은 하위 클래스 ConcreteCreator가 결정합니다. Creator 역은 실제로 생성할 ConcreteProduct 역에 대해서는 아는 바가 없습니다. Creator 역이 아는 것은 Product 역과 인스턴스 생성 메소드(factory Method)를 호출하면 Product가 생성되는 것뿐입니다. new를 사용해 실제 인스턴스를 생성하는 대신에, 인스턴스를 생성하는 메소드를 호출함으로써 구체적인 클래스 이름에 의한 속박에서 자유롭게 합니다.

+ 구체적인 내용 : 구체적인 살을 붙이는 쪽
  
    * ConcreteProduct : 제품 구현체

    * ConcreteCreator : 구체적인 제품을 만들 클래스를 결정합니다.

### Factory Method Pattern 사용시기
+ 클래스 생성과 사용의 처리 로직을 분리하여 결합도를 낮추고자 할 때
  
+ 코드가 동작해야 하는 객체의 유형과 종속성을 캡슐화를 통해 정보 은닉 처리 할 경우
+ 라이브러리 혹은 프레임워크 사용자에게 구성 요소를 확장하는 방법을 제공하려는 경우 
+ 기존 객체를 재구성하는 대신 기존 객체를 재사용하여 리소스를 절약하고자 하는 경우

 
### Factory Method Pattern 장점
+ 생성자(Creator)와 구현 객체(concrete product)의 **강한 결합을 피할 수 있**습니다.
  
+ 팩토리 메서드를 통해 객체의 생성 후 **공통으로 할 일을 수행하도록 지정**해줄 수 있습니다.
+ **캡슐화, 추상화**를 통해 생성되는 객체의 구체적인 타입을 감출 수 있습니다.
+ **단일 책임 원칙 준수** : 객체 생성 코드를 한 곳 (패키지, 클래스 등)으로 이동하여 코드를 유지보수하기 쉽게 할수 있으므로 원칙을 만족합니다.
+ **개방/폐쇄 원칙 준수** : 기존 코드를 수정하지 않고 새로운 유형의 제품 인스턴스를 프로그램에 도입할 수 있어 원칙을 만족합니다. (확장성 있는 전체 프로젝트 구성이 가능)
+ 생성에 대한 인터페이스 부분과 생성에 대한 구현 부분을 따로 나뉘었기 때문에 패키지 분리하여 개별로 여러 개발자가 협업을 통해 개발할 수 있습니다.
### Factory Method Pattern 단점
+ 복잡성 증가 : 
    각 제품 구현체마다 팩토리 객체들을 모두 구현해주어야 하기 때문에, 구현체가 늘어날때 마다 팩토리 클래스가 증가하여 서브 클래스 수가 폭발합니다. 따라서 코드의 복잡성이 증가합니다.


## Factory Method Pattern : 금융 제품 관리와 공장 메서드 패턴 활용

### 팩토리 메서드 패턴 적용 전 코드 : Before

먼저 팩토리 메서드 패턴을 적용하기 전의 비효율적인 코드를 보겠습니다.

```java
public class Product {
    private String type;
    
    public Product(String type) {
        this.type = type;
    }
    
    public void use() {
        if (type.equalsIgnoreCase("Stock")) {
            System.out.println("증권을 매수합니다.");
        } else if (type.equalsIgnoreCase("Bond")) {
            System.out.println("채권을 매수합니다.");
        } else if (type.equalsIgnoreCase("Fund")) {
            System.out.println("펀드를 매수합니다.");
        }
    }
    
    public void explain() {
        if (type.equalsIgnoreCase("Stock")) {
            System.out.println("증권은 자본금 증식 및 배당금 수익을 제공합니다.");
        } else if (type.equalsIgnoreCase("Bond")) {
            System.out.println("채권은 고정수익을 제공합니다.");
        } else if (type.equalsIgnoreCase("Fund")) {
            System.out.println("펀드는 포트폴리오 분산 및 수익 증식을 제공합니다.");
        }
    }
}

// 테스트
public class Main {
    public static void main(String[] args) {
        Product stock = new Product("Stock");
        stock.use();
        stock.explain();
        
        Product bond = new Product("Bond");
        bond.use();
        bond.explain();
        
        Product fund = new Product("Fund");
        fund.use();
        fund.explain();
    }
}
```

결과는 다음과 같습니다.
```
증권을 매수합니다.
증권은 자본금 증식 및 배당금 수익을 제공합니다.
채권을 매수합니다.
채권은 고정수익을 제공합니다.
펀드를 매수합니다.
펀드는 포트폴리오 분산 및 수익 증식을 제공합니다.
```

여기서는 `Product` 클래스의 생성자에서 입력받은 `type` 필드를 가지고 `if else`문으로 객체 생성과 메서드를 호출하고 있습니다. 이 경우, `Product` 클래스는 자식 클래스를 가지지 않고 `switch case`나 `if else`문 등으로 객체생성, 메서드 호출을 처리하고 있으므로 확장성과 유지보수성이 좋지 않습니다. 팩토리 패턴을 사용하면 객체 생성과정을 추상화하여 객체생성과 메서드호출을 분리하므로 이러한 문제를 해결할 수 있습니다.


### 팩토리 메서드 패턴을 적용한 코드 : After

#### UML 클래스 다이어그램
<img src="https://github.com/eunsiver/shinhan-Design-Oattern/assets/76419984/bc7aa76e-87ce-4905-b4db-2801ac9c03d6" width=1500> 

+ `Product` 추상 클래스는 제품의 공통적인 특성을 정의하는 역할을 합니다. 이 클래스를 상속받은 클래스들인 `Stock`, `Bond`, `Fund` 클래스는 각각의 제품의 특성을 구현하는 역할을 합니다.

+ `Factory` 추상 클래스는 제품 객체를 생성하는 역할을 합니다. `create` 메서드를 가지고 있고, 이를 구현한 각각의 서브 클래스들이 실제로 객체를 생성합니다. `Factory` 클래스는 `StockFactory`, `BondFactory`, `FundFactory` 세 개의 서브 클래스를 가지고 있습니다.

+ 각각의 서브 클래스들은 `createProduct` 메서드를 구현하고 있으며, 이 메서드에서는 해당 제품(`Stock`, `Bond`, `Fund`)의 객체를 생성하여 반환합니다. 실제 Product 객체를 생성하는 것은 `Factory` 클래스가 아닌 각각의 서브 클래스에서 이루어지게 됩니다.

+ 이렇게 함으로써, 제품이 추가될 때마다 새로운 서브 클래스를 추가하기만 하면 되기 때문에 코드의 유연성과 확장성이 높아지는 장점이 있습니다. 또한, `Factory`와 각각의 서브 클래스들 간의 결합도가 낮아서 유지보수에 용이하다는 장점이 있습니다.

#### 코드

```java
public abstract class Product {
    public abstract void use();
    public abstract void explain();
}


// 주식 클래스
public class Stock extends Product {
    private String name;

    public Stock(String name) {
        this.name = name;
    }

    @Override
    public void use() {
        System.out.println("증권을 매수합니다. (이름: " + name + ")");
    }

    @Override
    public void explain() {
        System.out.println("증권은 자본금 증식 및 배당금 수익을 제공합니다.");
    }
}

// 채권 클래스
public class Bond extends Product {
    private int maturityYear;

    public Bond(int maturityYear) {
        this.maturityYear = maturityYear;
    }

    @Override
    public void use() {
        System.out.println("채권을 매수합니다. (만기 연도: " + maturityYear + ")");
    }

    @Override
    public void explain() {
        System.out.println("채권은 고정수익을 제공합니다.");
    }
}

// 펀드 클래스
public class Fund extends Product {
    private String strategy;

    public Fund(String strategy) {
        this.strategy = strategy;
    }

    @Override
    public void use() {
        System.out.println("펀드를 매수합니다. (전략: " + strategy + ")");
    }

    @Override
    public void explain() {
        System.out.println("펀드는 포트폴리오 분산 및 수익 증식을 제공합니다.");
    }
}
```



```java
// ProductFactory 추상 클래스
public abstract class Factory {
    public Product create(String name, int maturityYear, String strategy) {
        Product p = createProduct(name, maturityYear, strategy);
        return p;
    }

    protected abstract Product createProduct(String name, int maturityYear, String strategy);
}

// 주식 제품 팩토리
public class StockFactory extends Factory {
    @Override
    protected Product createProduct(String name, int maturityYear, String strategy) {
        return new Stock(name);
    }
}

// 펀드 제품 팩토리
public class FundFactory extends Factory {
    @Override
    protected Product createProduct(String name, int maturityYear, String strategy) {
        return new Fund(strategy);
    }
}

// 채권 제품 팩토리
public class BondFactory extends Factory {
    @Override
    protected Product createProduct(String name, int maturityYear, String strategy) {
        return new Bond(maturityYear);
    }
}
```


```java
//테스트

public class Main {
    public static void main(String[] args) {
        Factory factory = new StockFactory();

        // 주식 제품 생성 및 사용
        Product stock1 = factory.create("AAPL", 0, "ETF");
        stock1.use();
        stock1.explain();

        // 또 다른 주식 제품 생성 및 사용
        Product stock2 = factory.create("GOOGL", 0, "PER");
        stock2.use();
        stock2.explain();

        System.out.println();

        factory = new BondFactory();

        // 채권 제품 생성 및 사용
        Product bond1 = factory.create("이표채", 5, "active");
        bond1.use();
        bond1.explain();

        // 또 다른 주식 제품 생성 및 사용
        Product bond2 = factory.create("복리채", 10, "passive");
        bond2.use();
        bond2.explain();

        System.out.println();

        factory = new FundFactory();

        // 펀드 제품 생성 및 사용
        Product fund1 = factory.create("에셋플러스", 0, "안정");
        fund1.use();
        fund1.explain();

        // 또 다른 펀드 제품 생성 및 사용
        Product fund2 = factory.create("마이다스", 0, "고수익");
        fund2.use();
        fund2.explain();
    }
}
```

결과는 다음과 같습니다.
```
증권을 매수합니다. (이름: AAPL)
증권은 자본금 증식 및 배당금 수익을 제공합니다.
증권을 매수합니다. (이름: GOOGL)
증권은 자본금 증식 및 배당금 수익을 제공합니다.

채권을 매수합니다. (만기 연도: 5)
채권은 고정수익을 제공합니다.
채권을 매수합니다. (만기 연도: 10)
채권은 고정수익을 제공합니다.

펀드를 매수합니다. (전략: 안정)
펀드는 포트폴리오 분산 및 수익 증식을 제공합니다.
펀드를 매수합니다. (전략: 고수익)
펀드는 포트폴리오 분산 및 수익 증식을 제공합니다.
```

## 더 나아가서 
현재 create에서 3가지 필드를 다 넣어야 생성이 되어야 되기 때문에 아직 비효율적인 코드라고 생각됩니다.
따라서 이 코드는 Builder Pattern을 이용하여 더 개선할 수 있을 것이라고 생각합니다. 이 부분은 추후에 업데이트 하겠습니다.


## 정리

지금까지 팩토리 메소드 패턴을 사용하여 다양한 금융 제품을 생성하고 사용하는 방법을 보여봤습니다. 주식, 채권 및 펀드와 같은 다양한 금융 제품을 구체적인 팩토리 클래스를 통해 생성할 수 있으며, 이를 통해 시스템의 확장성과 유지보수성을 향상시킬 수 있습니다.

팩토리 메소드 패턴은 객체 생성을 추상화하고 객체 생성에 필요한 세부사항을 숨기는 데 도움을 주며, 코드의 가독성과 유지보수성을 향상시킵니다. 복잡한 시스템에서 코드를 관리하고 확장하는 데 유용하며, 객체 지향 소프트웨어 개발에 중요한 개념이라고 생각합니다. 

하지만, 구현체가 늘어날 때 클래스의 수가 증가하고 복잡성이 높아질 수 있다는 단점이 있습니다. 상황에 맞춰 디자인 패턴을 개발하는 개발자가 되겠습니다.


##### 참고
* https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%ED%8C%A9%ED%86%A0%EB%A6%AC-%EB%A9%94%EC%84%9C%EB%93%9CFactory-Method-%ED%8C%A8%ED%84%B4-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EB%B0%B0%EC%9B%8C%EB%B3%B4%EC%9E%90#java
