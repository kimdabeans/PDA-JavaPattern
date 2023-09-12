# Factory Method Pattern

# 팩토리 메소드 패턴이란?
![](https://velog.velcdn.com/images/hyunjinny/post/2e7621d3-e8cc-4997-b51e-c5ee1317bc61/image.png)

Factory란 한국어로 공장을 의미하는 만큼, 부모 클래스에서 객체들을 생성할 수 있는 인터페이스를 제공하지만, 자식 클래스들이 생성될 객체들의 유형을 변경할 수 있도록 하는 생성 패턴입니다.

객체를 생성하는 메소드를 추상화하여 서브 클래스에서 실제 객체의 타입을 결정하는 패턴입니다. 이 패턴은 객체 생성과 관련된 코드를 클라이언트 코드와 분리시켜, 클라이언트가 객체의 구체적인 클래스에 의존하지 않도록 합니다. 이렇게 하면 코드의 유지보수성과 확장성이 향상됩니다.

# 예제 프로그램 [BEFORE_ver]

## IceCream 프로그램

IceCream.java

```java
/**
 * 아이스크림 클래스입니다. 아이스크림 맛 정보와 먹는 동작을 정의합니다.
 */
class IceCream {
    private String flavor;

    /**
     * 아이스크림 객체를 생성합니다.
     *
     * @param flavor 아이스크림의 맛 정보.
     */
    public IceCream(String flavor) {
        this.flavor = flavor;
    }

    /**
     * 아이스크림의 맛 정보를 반환합니다.
     *
     * @return 아이스크림의 맛 정보.
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * 아이스크림을 먹는 동작을 나타냅니다.
     */
    public void eat() {
        System.out.println(flavor + " 아이스크림을 먹습니다!");
    }
}
```

IceCreamShop.java

```java
/**
 * 아이스크림을 주문하고 제공하는 아이스크림 가게 클래스입니다.
 */
public class IceCreamShop {
    /**
     * 주어진 맛의 아이스크림을 주문하고 반환합니다.
     *
     * @param flavor 아이스크림의 맛 정보.
     * @return 주문한 아이스크림 객체.
     * @throws IllegalArgumentException 지원하지 않는 아이스크림 맛을 주문한 경우 발생합니다.
     */
    public IceCream orderIceCream(String flavor) {
        IceCream iceCream = createIceCream(flavor);
        prepareIceCream(iceCream);
        return iceCream;
    }

    /**
     * 주어진 맛에 따라 아이스크림 객체를 생성합니다.
     *
     * @param flavor 아이스크림의 맛 정보.
     * @return 생성된 아이스크림 객체.
     * @throws IllegalArgumentException 지원하지 않는 아이스크림 맛을 주문한 경우 발생합니다.
     */
    private IceCream createIceCream(String flavor) {
        switch (flavor) {
            case "초콜릿":
                return new ChocolateIceCream();
            case "바닐라":
                return new VanillaIceCream();
            default:
                throw new IllegalArgumentException("지원하지 않는 아이스크림 맛입니다: " + flavor);
        }
    }

    /**
     * 주어진 아이스크림을 준비하는 동작을 나타냅니다.
     *
     * @param iceCream 준비할 아이스크림 객체.
     */
    private void prepareIceCream(IceCream iceCream) {
        System.out.println(iceCream.getFlavor() + " 아이스크림을 준비합니다.");
    }

    /**
     * 주 애플리케이션 진입점입니다. 아이스크림 가게를 생성하고 아이스크림을 주문하는 예제를 수행합니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        IceCreamShop shop = new IceCreamShop();
        IceCream iceCream1 = shop.orderIceCream("초콜릿");
        IceCream iceCream2 = shop.orderIceCream("바닐라");

        iceCream1.eat(); // 출력: 초콜릿 아이스크림을 먹습니다!
        iceCream2.eat(); // 출력: 바닐라 아이스크림을 먹습니다!
    }
}
```

VanillaIceCream.java

```java
/**
 * 바닐라 아이스크림 클래스입니다. {@link IceCream}을 상속합니다.
 * 바닐라 맛의 아이스크림을 나타내며, 부모 클래스인 {@link IceCream}의 생성자를 호출하여 초기화합니다.
 */
class VanillaIceCream extends IceCream {
    /**
     * 바닐라 아이스크림을 생성합니다.
     */
    public VanillaIceCream() {
        super("바닐라");
    }
}
```

ChocolateIceCream.java

```java
/**
 * 초콜릿 아이스크림 클래스입니다. {@link IceCream}을 상속합니다.
 * 초콜릿 맛의 아이스크림을 나타내며, 부모 클래스인 {@link IceCream}의 생성자를 호출하여 초기화합니다.
 */
class ChocolateIceCream extends IceCream {
    /**
     * 초콜릿 아이스크림을 생성합니다.
     */
    public ChocolateIceCream() {
        super("초콜릿");
    }
}

```

위에 코드는 Factory Method 패턴을 적용하지 않은 프로그램입니다.<br>

관련 프로그램의 javadoc은 **FactoryMethodBefore/docs/** 에 들어있습니다.<br>
| 클래스명 | 링크                                        |
| --------- | ---------------------------------------- |
| IceCream Class | [IceCream Class](./FactoryMethodBefore/docs/IceCream.html) |
| IceCreamShop Class | [IceCreamShop Class](./FactoryMethodBefore/docs/IceCreamShop.html) |
| VanillaIceCream Class | [VanillaIceCream Class](./FactoryMethodBefore/docs/VanillaIceCream.html) |
| ChocolateIceCream Class | [ChocolateIceCream Class](./FactoryMethodBefore/docs/ChocolateIceCream.html) |

이 프로그램은 아래와 같은 여러가지 비효율적인 부분들들이 있습니다.<br>

**팩토리 메소드 패턴 적용 전:**

1. 새로운 제품을 추가하려면 **`IceCreamShop`** 클래스를 직접 수정해야 합니다. 예를 들어, 새로운 맛의 아이스크림을 추가하려면 해당 메소드를 추가하고 관련 클래스를 수정해야 합니다.
2. **`IceCreamShop`** 클래스가 모든 객체 생성 코드를 포함하므로 코드가 복잡해질 수 있고, 유지보수가 어려울 수 있습니다.
3. 클라이언트 코드(**`main`** 메소드)가 구체적인 클래스에 의존하므로 유연성이 떨어질 수 있습니다. 클라이언트 코드가 바닐라 아이스크림 또는 초콜릿 아이스크림을 생성하는 방법을 알고 있어야 합니다.

# 예제 프로그램 [AFTER_ver]

**이러한 단점들을 해결하기 위해 Factory Method 패턴을 활용해 코드를 수정해보았습니다.**

Factory.java

```java
package framework;

/**
 * 객체를 생성하는 메서드를 정의하는 추상 Factory 클래스입니다.
 */
public abstract class Factory {
    /**
     * 제품을 생성합니다.
     *
     * @param owner 제품의 소유자 정보.
     * @return 생성된 제품.
     */
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    /**
     * 구체적인 제품을 생성합니다.
     *
     * @param owner 제품의 소유자 정보.
     * @return 생성된 제품.
     */
    protected abstract Product createProduct(String owner);

    /**
     * 제품을 등록합니다.
     *
     * @param product 등록할 제품.
     */
    protected abstract void registerProduct(Product product);
}
```

Product.java

```java
package framework;

/**
 * 제품에 대한 추상 베이스 클래스입니다.
 */
public abstract class Product {
    /**
     * 제품을 사용합니다.
     */
    public abstract void use();
}
```

IceCream.java

```java
package icecream;

import framework.Product;

/**
 * 아이스크림을 나타내는 구체적인 제품 클래스입니다.
 */
public class IceCream extends Product {
    private String flavor;

    /**
     * 특정 맛의 아이스크림을 생성합니다.
     *
     * @param flavor 아이스크림의 맛 정보.
     */
    public IceCream(String flavor) {
        this.flavor = flavor;
    }

    /**
     * 아이스크림을 사용합니다.
     */
    @Override
    public void use() {
        System.out.println(flavor + " 아이스크림을 즐깁니다!");
    }

    /**
     * 아이스크림의 맛을 반환합니다.
     *
     * @return 아이스크림의 맛 정보.
     */
    public String getFlavor() {
        return flavor;
    }
}
```

IceCreamFactory.java

```java
package icecream;

import framework.Factory;
import framework.Product;

/**
 * 아이스크림 제품을 생성하는 구체적인 팩토리 클래스입니다.
 */
public class IceCreamFactory extends Factory {
    /**
     * 특정 맛의 아이스크림 제품을 생성합니다.
     *
     * @param flavor 아이스크림의 맛 정보.
     * @return 생성된 아이스크림 제품.
     */
    @Override
    protected Product createProduct(String flavor) {
        return new IceCream(flavor);
    }

    /**
     * 아이스크림 제품을 등록합니다.
     *
     * @param product 등록할 아이스크림 제품.
     */
    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 아이스크림 데이터베이스에 등록했습니다.");
    }
}
```

Main.java

```java
import framework.Factory;
import framework.Product;
import icecream.IceCreamFactory;

/**
 * 아이스크림 팩토리를 사용하는 메인 클래스입니다.
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = new IceCreamFactory();
        Product iceCream1 = factory.create("초콜릿");
        Product iceCream2 = factory.create("바닐라");

        iceCream1.use(); // 출력: 초콜릿 아이스크림을 즐깁니다!
        iceCream2.use(); // 출력: 바닐라 아이스크림을 즐깁니다!
    }
}
```

**팩토리 메소드 패턴 적용 후:**

1. **유연성과 확장성**: Factory Method 패턴을 적용하면 새로운 아이스크림 맛을 추가하기가 훨씬 쉬워집니다. 새로운 아이스크림 맛을 추가하려면 해당 아이스크림의 **`createIceCream`** 메소드를 구현하는 새로운 아이스크림 스토어 클래스를 만들기만 하면 됩니다. 예를 들어, **`StrawberryIceCreamStore`** 클래스를 추가하고 **`createIceCream`** 메소드를 구현하면 새로운 맛의 아이스크림을 만들 수 있습니다.
2. **클라이언트 코드의 간결성**: 클라이언트 코드에서는 단순히 **`IceCreamStore`** 클래스의 **`orderIceCream`** 메소드를 호출하면 됩니다. 클라이언트 코드는 구체적인 아이스크림 클래스나 아이스크림 스토어 클래스에 대한 지식이 없어도 됩니다.
3. **객체 생성의 추상화**: Factory Method 패턴을 사용하면 객체 생성 로직을 추상화하여 클라이언트 코드와 분리시킵니다. 클라이언트 코드는 어떤 아이스크림이 생성되는지에 대해 신경 쓰지 않고 단순히 **`IceCreamStore`** 를 통해 아이스크림을 주문할 수 있습니다.
4. **유지보수 용이성**: 새로운 아이스크림 맛을 추가하거나 기존 맛을 변경할 때 해당 아이스크림 스토어 클래스만 수정하면 됩니다. 다른 부분의 코드 변경이 필요하지 않습니다. 이는 코드의 유지보수성을 크게 향상시킵니다.

# UML

![](https://velog.velcdn.com/images/hyunjinny/post/8e49af12-0deb-4fe8-aedd-1a0db93bd420/image.png)
위 사진은 Factory Method를 활용해서 아이스크림 공장에서 아이스크림을 만들어내는 프로그램의 UML입니다.
관련 클래스 및 인터페이스의 설명은 아래와 같습니다.

1. **Main 클래스**:
    - **`Main`** 클래스는 프로그램의 진입점을 나타냅니다.
    - **`Factory`** 객체를 생성하고 이를 통해 **`Product`**를 생성하고 사용합니다.
2. **Factory 클래스**:
    - **`Factory`** 클래스는 객체 생성을 위한 Creator 클래스입니다.
    - **`createProduct`** 메소드를 선언하여 구체적인 팩토리 클래스에서 이를 구현하게 합니다.
    - **`Product`** 객체를 생성하고 사용하는 역할을 합니다.
3. **Product 클래스**:
    - **`Product`** 클래스는 제품(Product)에 대한 추상 베이스 클래스 또는 인터페이스를 나타냅니다.
    - **`use`** 메소드를 선언하여 제품을 사용하는 방법을 정의합니다.
4. **IceCream 클래스**:
    - **`IceCream`** 클래스는 구체적인 제품 클래스입니다.
    - **`Product`** 클래스를 상속하며 **`use`** 메소드를 구현하여 아이스크림을 사용하는 방법을 정의합니다.
5. **IceCreamFactory 클래스**:
    - **`IceCreamFactory`** 클래스는 구체적인 팩토리 클래스입니다.
    - **`Factory`** 클래스를 상속하며 **`createProduct`** 메소드를 구현하여 특정 맛의 아이스크림 제품을 생성합니다.

**`Factory`** 클래스를 통해 **`Product`** 를 생성하고, 구체적인 팩토리 클래스인 **`IceCreamFactory`** 에서 **`IceCream`** 객체를 생성합니다. 클라이언트 코드는 **`Factory`** 클래스를 사용하여 제품을 생성하고 사용합니다. Factory Method 패턴을 사용하면 객체 생성과 사용을 분리하여 코드의 확장성과 유지보수성을 향상시킵니다.

# Javadoc

Javadoc은 **FactoryMethodAfter/docs** 폴더에 있습니다. <br>
| 클래스명 | 링크                                        |
| --------- | ---------------------------------------- |
| Main Class | [Main Class](./FactoryMethodAfter/docs/Main.html) |
| Factory Class | [Factory Class](./FactoryMethodAfter/docs/Factory.html) |
| Product Class | [Product Class](./FactoryMethodAfter/docs/Product.html) |
| IceCream Class | [IceCream Class](./FactoryMethodAfter/docs/IceCream.html) |
| Ice Cream Shop Class | [Ice Cream Shop Class](./FactoryMethodAfter/docs/IceCreamShop.html) |




# 결론

Factory Method 패턴을 통해 소프트웨어 디자인에서 객체 생성을 추상화하고 유연성을 높이는데 유용하게 코드를 짤 수 있습니다.  <br>
또한 코드의 재사용성과 확장 가능성을 증가시킬 수 있으며, 객체 생성과 관련된 복잡성을 숨길 수 있습니다.<br>
'공장'이라는 의미에 맞게 부모 클래스에서 객체들을 자유롭게 생성할 수 있어 효율적인 패턴이라고 생각됩니다. <br>
