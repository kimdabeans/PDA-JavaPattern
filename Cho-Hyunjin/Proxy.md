# Proxy Pattern

## 프록시 패턴이란?

![](https://velog.velcdn.com/images/hyunjinny/post/4684b810-63b7-41e1-9065-90c99cc28ce1/image.png)

프록시 패턴은 '대리인'이라는 뜻으로, 어떤 객체를 대신하여 해당 객체에 대한 접근을 제어하고 추가적인 기능을 제공하기 위한 디자인 패턴입니다. 이 패턴을 사용하면 객체에 직접 접근하는 대신 프록시 객체를 통해 간접적으로 접근할 수 있습니다. 이를 통해 다양한 상황에서 유용한 기능을 제공하거나 객체의 생성 및 초기화를 최적화할 수 있습니다.

## 예제 프로그램 [BEFORE_ver]

### Restaurant 프로그램
RestaurantWithoutProxy.java
```java
/**
 * RestaurantWithoutProxy 클래스는 주문 처리를 위한 식당 객체를 나타냅니다.
 */
public class RestaurantWithoutProxy {
    private String customerName;

    /**
     * RestaurantWithoutProxy 클래스의 생성자입니다.
     */
    public RestaurantWithoutProxy() {
        // 식당 객체 생성
    }

    /**
     * 고객의 이름을 설정합니다.
     *
     * @param name 설정할 고객 이름
     */
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    /**
     * 현재 설정된 고객의 이름을 반환합니다.
     *
     * @return 고객 이름
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 주문한 음식 항목을 처리하고 준비 과정을 시뮬레이션합니다.
     *
     * @param foodItem 주문한 음식 항목
     */
    public void placeOrder(String foodItem) {
        System.out.println("고객 " + customerName + "의 주문: " + foodItem + " 준비 중입니다.");
        // 음식 준비 시뮬레이션
        try {
            Thread.sleep(2000); // 2초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(foodItem + "가 완료되었습니다.");
    }
}
```
MainWithoutProxy.java
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
위에 코드는 Proxy 패턴을 적용하지 않은 프로그램입니다.<br>

해당 프로그램의 javadoc은 **ProxyBefore/docs** 에 있습니다.<br>
| 클래스명 | 링크                                        |
| --------- | ---------------------------------------- |
| MainWithoutProxy Class | [MainWithoutProxy Class](./ProxyBefore/docs/MainWithoutProxy.html) |
| RestaurantWithoutProxy Class | [RestaurantWithoutProxy Class](./ProxyBefore/docs/RestaurantWithoutProxy.html) |

이 프로그램은 아래와 같이 여러가지 비효율적인 부분들이 있습니다.

**프록시 패턴 적용 전:**
1. **객체 생성과 초기화**: 매 주문마다 `RestaurantWithoutProxy` 객체를 생성하고 초기화해야 합니다. 이로 인해 객체 생성 오버헤드와 초기화 시간이 추가되어 시간적으로 비효율적입니다.
2. **고객 정보 관리**: 고객의 이름을 변경하려면 `setCustomerName` 메서드를 호출하여 업데이트해야 하는데, 이 때 여러 번의 메서드 호출이 필요하다는 점이 비효율적입니다.
3. **복잡한 로직**: 주문 처리와 관련된 모든 로직이 `RestaurantWithoutProxy` 클래스에 직접 구현되어 있으므로 코드의 유지보수가 어렵습니다.

# 예제 프로그램 [AFTER_ver]

**이러한 단점들을 해결하기 위해 Proxy 패턴을 활용해 코드를 수정해보았습니다.**

FoodOrder.java
```java
/**
 * FoodOrder 인터페이스는 음식 주문과 관련된 동작을 정의합니다.
 */
public interface FoodOrder {
    /**
     * 주문 고객의 이름을 설정합니다.
     *
     * @param name 주문 고객의 이름
     */
    void setCustomerName(String name);

    /**
     * 주문 고객의 이름을 반환합니다.
     *
     * @return 주문 고객의 이름
     */
    String getCustomerName();

    /**
     * 주문을 생성하고 음식을 주문합니다.
     *
     * @param foodItem 주문하려는 음식 항목
     */
    void placeOrder(String foodItem);
}
```
FoodOrderProxy.java

```java
/**
 * FoodOrderProxy 클래스는 FoodOrder 인터페이스를 구현하며, 프록시 역할을 수행합니다.
 */
public class FoodOrderProxy implements FoodOrder {
    /**
     * 주문 고객의 이름을 나타내는 변수
     */
    private String customerName;

    /**
     * 실제 식당 객체를 참조하는 변수
     */
    private Restaurant real;

    /**
     * FoodOrderProxy 클래스의 기본 생성자입니다.
     * 주문 고객의 이름을 "미정"으로 초기화하고 실제 식당 객체를 초기화하지 않습니다.
     */
    public FoodOrderProxy() {
        this.customerName = "미정";
        this.real = null;
    }

    /**
     * FoodOrderProxy 클래스의 생성자입니다.
     *
     * @param customerName 주문 고객의 이름
     */
    public FoodOrderProxy(String customerName) {
        this.customerName = customerName;
        this.real = null;
    }

    @Override
    public void setCustomerName(String name) {
        if (real != null) {
            real.setCustomerName(name);
        }
        this.customerName = name;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void placeOrder(String foodItem) {
        realize();
        real.placeOrder(foodItem);
    }

    /**
     * 실제 객체를 생성하고 주문자의 이름을 설정합니다.
     */
    private void realize() {
        if (real == null) {
            real = new Restaurant();
            real.setCustomerName(customerName);
        }
    }
}
```

Restaurant.java

```java
/**
 * FoodOrderProxy 클래스는 FoodOrder 인터페이스를 구현하며, 프록시 역할을 수행합니다.
 */
public class FoodOrderProxy implements FoodOrder {
    /**
     * 주문 고객의 이름을 나타내는 변수
     */
    private String customerName;

    /**
     * 실제 식당 객체를 참조하는 변수
     */
    private Restaurant real;

    /**
     * FoodOrderProxy 클래스의 기본 생성자입니다.
     * 주문 고객의 이름을 "미정"으로 초기화하고 실제 식당 객체를 초기화하지 않습니다.
     */
    public FoodOrderProxy() {
        this.customerName = "미정";
        this.real = null;
    }

    /**
     * FoodOrderProxy 클래스의 생성자입니다.
     *
     * @param customerName 주문 고객의 이름
     */
    public FoodOrderProxy(String customerName) {
        this.customerName = customerName;
        this.real = null;
    }

    @Override
    public void setCustomerName(String name) {
        if (real != null) {
            real.setCustomerName(name);
        }
        this.customerName = name;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void placeOrder(String foodItem) {
        realize();
        real.placeOrder(foodItem);
    }

    /**
     * 실제 객체를 생성하고 주문자의 이름을 설정합니다.
     */
    private void realize() {
        if (real == null) {
            real = new Restaurant();
            real.setCustomerName(customerName);
        }
    }
}
```

Main.java

```java
/**
 * 주문 테스트를 위한 클래스입니다. FoodOrderProxy를 사용하여 주문 처리 과정을 시뮬레이션합니다.
 */
public class Main {
    /**
     * 프로그램의 진입점입니다.
     *
     * @param args 커맨드 라인 인수 (사용되지 않음)
     */
    public static void main(String[] args) {
        // FoodOrderProxy를 사용하여 주문 처리 과정을 시뮬레이션합니다.
        FoodOrder order = new FoodOrderProxy("Jinny");

        // 현재 주문자 이름을 출력합니다.
        System.out.println("현재 주문자 이름: " + order.getCustomerName());

        // 주문자의 이름을 변경하고 변경된 이름을 출력합니다.
        order.setCustomerName("Daniel");
        System.out.println("현재 주문자 이름: " + order.getCustomerName());

        // 주문을 생성하여 음식 주문을 처리합니다.
        order.placeOrder("피자");
    }
}

```

**프록시 패턴 적용 후:**

**1. 객체 생성 및 초기화 최적화:** **`FoodOrderProxy`**를 사용하여 객체를 생성 및 초기화하고, 필요한 경우 실제 **`Restaurant`** 객체를 생성합니다. 이로 인해 객체 생성 및 초기화 작업을 효율적으로 진행할 수 있습니다.<br>
**2. 고객 정보 관리 개선:** **`FoodOrderProxy`** 내에서 고객 정보를 관리하며, 클라이언트는 프록시를 통해 고객 정보를 업데이트할 수 있어 효율적입니다.<br>
**3. 코드 분리 및 유지보수 용이성:** 주문 처리 관련 로직은 **`Restaurant`** 클래스에서 분리되고, **`FoodOrderProxy`**에 중첩되어 있어 코드가 더 모듈화되어 유지보수를 쉽게 할 수 있습니다. 새로운 로직이나 변경이 필요한 경우 프록시 클래스만 수정하면 되어 효율적입니다.<br>
**4. 지연 로딩 및 비효율성 해결:** 실제 객체를 필요한 시점에 생성하므로 대기 시간이 오래 걸리는 작업에 대한 블록을 방지하고, 클라이언트 코드는 다른 작업을 수행할 수 있어 효율적입니다.<br>

# UML
![](https://velog.velcdn.com/images/hyunjinny/post/18f83f9b-01cf-492f-ac6b-899114761ee2/image.png)
이 UML은 Proxy패턴을 활용해 음식 주문을 처리하는 프로그램에 대한 UML입니다. <br>각각의 인터페이스 및 클래스에 대한 설명은 아래와 같습니다.

1. **FoodOrder 인터페이스**: 이 인터페이스는 주문과 관련된 동작을 정의합니다. **`setCustomerName`**, **`getCustomerName`**, **`placeOrder`** 메서드를 포함하고 있습니다.
2. **FoodOrderProxy 클래스**: 이 클래스는 **`FoodOrder`** 인터페이스를 구현하며, ***프록시 역할을 수행***합니다. **`customerName`** 필드는 주문 고객의 이름을 저장하고, **`real`** 필드는 실제 **`Restaurant`** 객체를 참조합니다. 이 클래스는 클라이언트가 **`Restaurant`** 객체에 대한 접근을 제어하고 지연 로딩을 수행합니다.
3. **Restaurant 클래스**: 이 클래스는 **`FoodOrder`** 인터페이스를 구현하여 음식 주문을 처리하는 실제 식당을 나타냅니다. 주문 고객의 이름을 관리하고 **`placeOrder`** 메서드를 통해 주문을 처리합니다.

프록시 패턴을 적용한 이 구조에서는 클라이언트는 **`FoodOrderProxy`** 객체를 통해 주문을 처리하며, 프록시는 실제 **`Restaurant`** 객체를 필요한 시점에 생성하거나 초기화합니다. 이를 통해 객체 생성 및 초기화를 최적화하고, 고객 정보를 관리하며, 지연 로딩을 수행할 수 있습니다.

# Javadoc
해당 프로그램의 javadoc은 **ProxyAfter/docs** 에 있습니다.<br>
| 클래스명 | 링크                                        |
| --------- | ---------------------------------------- |
| Main Class | [Main Class](./ProxyAfter/docs/Main.html) |
| FoodOrder Class | [FoodOrder Class](./ProxyAfter/docs/FoodOrder.html) |
| FoodOrderProxy Class | [FoodOrderProxy Class](./ProxyAfter/docs/FoodOrderProxy.html) |
| Restaurant Class | [Restaurant Class](./ProxyAfter/docs/Restaurant.html) |

# 결론

프록시 패턴이란, 실제 객체를 감싸고, 객체에 접근 및 제어를 추가로 수행하는 중간 역할을 하는 클래스를 생성하는 디자인 패턴을 말합니다. 이 패턴을 사용하면 객체의 생성 및 초기화를 최적화하고, 보안, 캐싱, 리소스 관리, 인터페이스 간소화 등 다양한 장점이 있습니다. 또한 클라이언트 코드와 실제 객체 간의 결합도를 낮추어 유지보수와 확장성을 향상시키며, 코드의 재사용성을 증가시킵니다. 따라서 프록시 패턴은 다양한 소프트웨어 시스템에서 사용될 수 있는 강력한 디자인 패턴 중 하나인 것 같아, 이 패턴을 활용해 더 효율적인 프로그램을 짤 수 있었습니다.
