# 목차

1. ADAPTER PATTERN
2. BRIDGE PATTERN
3. FACTORY PATTERN
4. PROXY PATTERN 
    1. beforeProxy
    2. afterProxy
5. STATE PATTERN
    1. beforeState
    2. afterState
       
---



# 1. ADAPTER PATTERN
<img width="581" alt="adapter" src="https://github.com/hee-bin/dp/assets/62937225/c16eec6b-1355-4d50-acbe-0b620a478f4b">

1. **`Banner`** 클래스:
    - **`Banner`** 클래스는 문자열을 괄호로 묶거나 별표로 묶어서 출력하는 기능을 제공합니다.
    - **`string`** 멤버 변수에 출력할 문자열을 저장합니다.
    - **`showWithParen()`** 메소드는 문자열을 괄호로 묶어서 출력합니다.
    - **`showWithAster()`** 메소드는 문자열을 별표로 묶어서 출력합니다.
2. **`Print`** 추상 클래스:
    - **`Print`** 클래스는 출력 기능을 제공하는 추상 클래스입니다.
    - **`printWaek()`**과 **`pirntStrong()`** 메소드는 각각 출력을 하는 기능입니다.  이 메소드들은 서브클래스에서 구현되어야 합니다.
3. **`PrintBanner`** 클래스:
    - **`PrintBanner`** 클래스는 **`Print`** 클래스를 상속받아 구현합니다.
    - **`banner`** 멤버 변수에 **`Banner`** 객체를 생성합니다.
    - **`PrintBanner`** 클래스는 **`Print`** 인터페이스를 구현하며, **`printWaek()`** 메소드와 **`pirntStrong()`** 메소드를 오버라이드하여 **`Banner`** 클래스의 메소드를 호출합니다. 이를 통해 **`Print`** 인터페이스의 메소드를 **`Banner`** 클래스의 기능으로 매핑합니다.
4. **`Client`** 클래스:
    - **`Client`** 클래스는 **`Print`** 인터페이스를 이용하여 출력 기능을 테스트합니다.
    - **`main`** 메소드에서 **`PrintBanner`** 객체를 생성하고, **`printWaek()`**와 **`pirntStrong()`** 메소드를 호출하여 각각 Banner 클래스의 메소드(showWithParen(), showWithAster() )가 적용된 출력

---



# 2. BRIDGE PATTERN
<img width="293" alt="bridge" src="https://github.com/hee-bin/dp/assets/62937225/7598488e-9836-43c4-9b6c-6574dd3a3147">

1. **`DisplayImpl`** 클래스:
    - **`DisplayImpl`** 클래스는 Display의 구현을 제공하는 추상 클래스입니다.
    - **`rawOpen()`**, **`rawPrint()`**, **`rawClose()`**는 각각 문자열 출력을 시작,  출력,  마무리하는 추상 메서드입니다.
2. **`StringDisplayImpl`** 클래스:
    - **`StringDisplayImpl`** 클래스는 **`DisplayImpl`**을 상속받아 문자열을 이용한 표시 기능을 제공합니다.
    - **`string`** 멤버 변수에 출력할 문자열을 저장하고, **`width`** 변수에 문자열의 길이를 저장합니다.
    - **`rawOpen()`**, **`rawPrint()`**, **`rawClose()`**를 구현하여 각각 문자열 출력을 시작, 출력, 마무리하는 기능을 제공합니다.
3. **`Display`** 클래스:
    - **`Display`** 클래스는 **`DisplayImpl`**을 가져와서 표시 기능을 제공합니다.
    - **`open()`**, **`print()`**, **`close()`** 메소드는 각각 **`DisplayImpl`**의 **`rawOpen()`**, **`rawPrint()`**, **`rawClose()`**를 호출합니다.
    - **`display()`** 메소드는 문자열 출력을 시작하고, 출력하고, 마무리하는 과정을 순서대로 수행합니다.
4. **`CountDisplay`** 클래스:
    - **`CountDisplay`** 클래스는 **`Display`** 클래스를 확장하여 여러 번 표시하는 기능을 추가로 제공합니다.
    - **`multiDisplay(int times)`** 메소드는 주어진 횟수만큼 문자열을 반복하여 출력합니다.
5. **`main`** 클래스:
    - **`main`** 클래스는 Bridge 패턴을 사용하여 **`Display`**를 생성하고 사용하는 예시를 제공합니다.
    - **`Display`**와 **`CountDisplay`** 객체를 생성하고 각각의 **`display()`** 메소드를 호출하여 문자열을 출력합니다.
    - **`StringDisplayImpl`** 객체를 생성하여 **`rawOpen()`**, **`rawPrint()`**, **`rawClose()`** 메소드를 호출하여 문자열을 출력합니다.

---



# 3. FACTORY PATTERN
<img width="442" alt="factory" src="https://github.com/hee-bin/dp/assets/62937225/f3e5667e-e1cb-4915-a6a1-89e4ed028680">

이 코드는 추상 팩토리 패턴(Abstract Factory Pattern)을 구현하고 있습니다. 이 패턴은 관련된 객체들을 생성하는 인터페이스를 제공하며, 어떤 구상 클래스들이 생성될지는 서브 클래스에서 결정합니다. 이 패턴을 사용하여 제품을 생성하는 구조를 갖추고 있습니다.

1. **`Factory`** 클래스:
    - **`Factory`** 클래스는 제품을 생성하는 추상 팩토리입니다.
    - **`create(String owner)`** 메서드는 제품을 생성하고 등록하는 과정을 담당합니다.
    - **`createProduct(String owner)`** 메서드는 구상 제품을 생성하는 추상 메서드입니다.
    - **`registerProduct(Product product)`** 메서드는 생성된 제품을 등록하는 추상 메서드입니다.
2. **`Product`** 추상 클래스:
    - **`Product`** 클래스는 추상 제품을 나타냅니다.
    - **`use()`** 메서드는 제품을 사용하는 기능을 정의하는 추상 메서드입니다.
3. **`IDCardFactory`** 클래스:
    - **`IDCardFactory`** 클래스는 ID 카드를 생성하는 구상 팩토리입니다. **`Factory`**를 상속합니다.
    - **`createProduct(String owner)`** 메서드는 구상 제품인 **`IDCard`**를 생성합니다.
    - **`registerProduct(Product product)`** 메서드는 생성된 제품을 등록합니다.
4. **`IDCard`** 클래스:
    - **`IDCard`** 클래스는 ID 카드를 나타냅니다. **`Product`**를 상속합니다.
    - **`owner`** 멤버 변수는 ID 카드의 소유자를 나타냅니다.
    - **`use()`** 메서드는 ID 카드를 사용하는 기능을 정의합니다.
5. **`Key`** 클래스:
    - **`Key`** 클래스는 열쇠를 나타냅니다. **`Product`**를 상속합니다. 
6. **`KeyFactory`** 클래스:
    - **`KeyFactory`** 클래스는 열쇠를 생성하는 구상 팩토리입니다. **`Factory`**를 상속합니다.
    - **`createProduct(String owner)`** 메서드는 구상 제품인 **`Key`**를 생성합니다.
    - **`registerProduct(Product product)`** 메서드는 생성된 제품을 등록합니다.

### console 결과
<img width="387" alt="factoryResult" src="https://github.com/hee-bin/dp/assets/62937225/c2dbbe65-5638-4054-9549-91cb1adc9320">

---



# 4. PROXY PATTERN
## beforeProxy
<img width="308" alt="beforeProxy" src="https://github.com/hee-bin/dp/assets/62937225/815928ee-049d-4247-9076-bd000e2ba80a">
<img width="211" alt="beforeProxyResult" src="https://github.com/hee-bin/dp/assets/62937225/5dd5586b-bce8-4b00-8791-574595a3a769">

1. **Printable 인터페이스**:
    - 프린터와 프린터 프록시를 구현하기 위한 기본적인 동작을 정의합니다.
    - **`setPrinterName(String name)`**: 프린터의 이름을 설정합니다.
    - **`getPrinterName()`**: 현재 프린터의 이름을 가져옵니다.
    - **`print(String string)`**: 주어진 문자열을 출력합니다.
2. **Printer 클래스**:
    - 프린터를 나타내는 클래스입니다.
    - **구현한 Printable 인터페이스 메서드**:
        - **`setPrinterName(String name)`**: 프린터의 이름을 설정합니다.
        - **`getPrinterName()`**: 현재 프린터의 이름을 가져옵니다.
        - **`print(String string)`**: 주어진 문자열을 출력합니다.
    - **생성자**:
        - **`Printer()`**: 기본 생성자로, 프린터를 생성하면서 초기화 작업을 수행합니다. (무거운 작업으로 가정)
        - **`Printer(String name)`**: 주어진 이름으로 프린터를 생성합니다.
3. **main 클래스**:
    -  프린터를 생성하고 동작을 테스트합니다.

현재 구조에서는 프록시를 사용하지 않아 실제 프린터의 무거운 작업이 프린터 객체 생성 시마다 발생합니다. 이 때문에 프록시 패턴을 활용하여 프록시 객체가 필요한 시점에만 실제 프린터 객체를 생성하도록 설계할 수 있습니다.

## afterProxy
<img width="352" alt="afterProxy" src="https://github.com/hee-bin/dp/assets/62937225/368dfd89-0403-47f6-b413-f8d1aad8e1ab">
<img width="286" alt="afterProxyResult" src="https://github.com/hee-bin/dp/assets/62937225/265bc881-6e9a-475c-8f37-fd97ba8d62ec">

1. **Printable 인터페이스**:
    - Printable 인터페이스는 프린터 관련 작업을 정의합니다.
    - 이 인터페이스를 구현한 클래스는 setPrinterName, getPrinterName, print 메소드를 구현해야 합니다.
2. **Printer 클래스**:
    - Printer 클래스는 Printable 인터페이스를 구현합니다.
    - 프린터의 이름을 나타내는 **`name`** 멤버 변수를 가집니다.
    - **`setPrinterName`** 메소드는 프린터의 이름을 설정합니다.
    - **`getPrinterName`** 메소드는 현재 프린터의 이름을 출력합니다.
    - **`print`** 메소드는 주어진 문자열을 출력합니다. 출력 시 프린터의 이름과 함께 출력됩니다.
    - **`heavyjob`** 메소드는 무거운 작업을 가정하고, 해당 메시지를 출력합니다.
3. **PrinterProxy 클래스**:
    - PrinterProxy 클래스는 Printable 인터페이스를 구현합니다.
    - 프린터의 이름을 나타내는 **`name`** 멤버 변수와 실제 프린터를 나타내는 **`real`** 멤버 변수를 가집니다.
    - **`setPrinterName`** 메소드는 실제 프린터가 생성되어 있다면 실제 프린터의 이름을 설정하고, 그렇지 않다면 프록시 자체의 이름을 설정합니다.
    - **`getPrinterName`** 메소드는 실제 프린터가 생성되어 있다면 실제 프린터의 이름과 프록시의 이름을 출력합니다.
    - **`print`** 메소드는 실제 프린터가 생성되어 있지 않다면 실제 프린터를 생성합니다. 그리고 실제 프린터를 이용하여 출력을 수행합니다.
4. **main 클래스**:
    - main 클래스는 프린터와 프린터 프록시를 테스트합니다.
    - 먼저 PrinterProxy 객체를 생성하고, getPrinterName을 호출하여 초기 상태를 확인합니다.
    - 그 다음 setPrinterName을 사용하여 프린터의 이름을 설정하고, 다시 getPrinterName을 호출하여 변경된 이름을 확인합니다.
    - 마지막으로 print 메소드를 호출하여 메시지를 출력하고, 다시 getPrinterName을 호출하여 이름이 그대로 유지되는지 확인합니다.

이러한 클래스들은 프린터와 프린터 프록시의 동작을 구현하고 있습니다. 프록시를 사용함으로써 실제 프린터의 생성 시점을 지연시키고, 필요할 때만 생성하도록 설계되어 있습니다.

**`PrinterProxy`** 클래스에서는 초기에 **`real`** 변수를 **`null`**로 설정합니다. 이는 **`Printer`** 인스턴스를 생성하지 않고, 프록시만 생성되어 있음을 의미합니다. **`print`** 메서드가 호출되기 전까지는 **`PrinterProxy`** 클래스에서 별도의 **`Printer`** 인스턴스가 생성되지 않습니다. 대신, **`realize`** 메서드가 호출되면 **`real`** 변수가 초기화되고, 이때 비로소 **`Printer`** 인스턴스가 생성됩니다. 결과적으로, **`print`** 메서드를 호출하기 전까지는 무거운 작업을 수행하는 **`Printer`** 인스턴스를 생성하지 않아도 됩니다. 이렇게 함으로써 불필요한 자원 소모를 방지하고, 필요한 시점에만 **`Printer`** 인스턴스를 생성하여 성능을 최적화할 수 있습니다.

---



# 5. STATE PATTERN

## beforeState
<img width="104" alt="beforeState" src="https://github.com/hee-bin/dp/assets/62937225/f8029914-d6ea-4732-bc65-d1555266deec">

1. **`SecuritySystem`** 클래스는 주간과 야간에 따라 동작이 달라지는 보안 시스템을 구현합니다.
2. **`setClock(int hour)`** 메서드는 시간을 설정하며, 주간인 경우 **`isDayTime`** 변수를 **`true`**로 설정합니다.
3. **`useSafe()`** 메서드는 주간일 때는 "use safe"를 기록하고, 야간일 때는 "emergency!!!"를 경비 센터에 호출합니다.
4. **`callSecurityCenter(String message)`** 메서드는 경비 센터에 호출 메시지를 보냅니다.
5. **`recordLog(String message)`** 메서드는 경비 센터에 기록 메시지를 남깁니다.
6. **`main`** 메서드에서는 주어진 시간대에 따라 **`setClock`**을 호출하고 **`useSafe`**를 실행합니다.

**`SecuritySystem`** 클래스가 모든 동작을 포함하고 있어 이후 추가 수정 시 코드 가독성이 떨어지고 유지 보수가 비효율적일 수 있습니다. 또한, 새로운 상태가 추가되거나 기존 상태의 동작이 변경될 때 많은 수정이 필요합니다.

## afterState
<img width="411" alt="afterState" src="https://github.com/hee-bin/dp/assets/62937225/62640c0a-0ce1-4cc4-8a10-a36dab11873b">

1. **`State`** 인터페이스: 시간대에 따른 동작을 정의합니다. 각 상태는 **`doUse`**, **`doAlarm`**, **`doPhone`** 메서드를 구현하여 각각의 동작을 수행합니다.
2. **`StateEnum`** 열거형: 각 상태를 나타내며, 해당 상태에 대응하는 **`State`** 객체를 가지고 있습니다.
3. **`Context`** 인터페이스: 시스템의 상태와 시간을 설정하고, 경비 센터를 호출하며, 기록하는 역할을 정의합니다.
4. **`SafeFrame`** 클래스: 경비 시스템을 표현하는 GUI를 제공합니다. **`ActionListener`**를 구현하여 버튼 클릭 이벤트를 처리하고, **`Context`**를 구현하여 상태와 시간을 설정하며, 경비 센터 호출 및 기록을 관리합니다.
5. **`StateTransitionMap`** 클래스: 시간대별 상태 전환 규칙을 관리합니다. **`HourRange`** 내부 클래스는 시간 범위를 표현하고, 주어진 시간에 해당하는 상태를 반환합니다.

### main 프로세스 요약
1. **`main`** 클래스에서 **`SafeFrame`**을 생성합니다.
2. 무한 루프를 통해 0부터 23까지의 시간을 설정하고, **`setClock`** 메서드를 호출하여 시간을 업데이트합니다.
3. **`setClock`** 메서드에서는 현재 시간을 GUI에 표시하고, 시간별로 상태를 전환합니다.
4. 버튼 클릭 이벤트가 발생하면 **`ActionListener`**를 통해 각 상태의 동작을 수행합니다.
5. 상태별로 호출된 동작은 **`Context`**를 통해 경비 센터에 전달되어 기록됩니다.

State pattern 적용 전과 후의 가장 큰 차이점은 코드의 구조와 유지보수성입니다. 상태 패턴을 적용하면 각 상태의 동작을 별도의 클래스로 분리하여 관리할 수 있습니다. State pattern을 적용하면 각 상태를 별도의 클래스로 정의하고, 상태에 따라 다르게 동작하는 메서드를 구현합니다. 이렇게 하면 각 상태의 동작을 이해하기 쉽고, 상태를 추가하거나 변경해도 기존 코드에 영향을 덜 줍니다.
