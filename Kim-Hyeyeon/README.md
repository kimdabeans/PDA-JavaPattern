# Java Design Pattern
> ⚙️ __사용한 디자인 패턴__
> 
> Factory Method Pattern, Observer Pattern, Composite Pattern

<br/>

<br/>

## 1️⃣ Factory Method Pattern
* __Checking Account, Saving Account를 만들어서 돈을 입출금하는 시나리오__
<img src="https://github.com/hyeyeonismm/PDA-JavaPattern/assets/91720344/d1ed69c4-5ea7-474c-a679-bba08565a511" width="60%">

팩토리 메서드 패턴은 객체 생성 과정을 서브 클래스에게 위임하는 방식으로 객체 생성을 캡슐화한다. `Account` 인터페이스를 통해 `make()`, `deposit()` 과 같은 계좌 관련 메서드들을 정의한다. `CheckingAccount`와 `SavingAccount` 클래스는 해당 인터페이스를 구현하는 계좌 클래스이며 입금, 출금, 잔액 표시와 같은 기본 메서드들을 정의한다. `CheckingAccount`의 경우 출금시 잔액이 부족하면 경고메시지가 출력되고, `SavingAccount` 클래스의 경우 `withdraw()` 메서드를 실행하면 적금계좌이기 때문에 출금이 불가능하다는 메시지를 출력한다. `AccountFactory` 클래스에서는 계좌의 유형에 따라 객체를 생성 및 반환한다. 예금(CheckingAccount)과 적금(SavingAccount)으로 나뉘어져 있으며 `creatAccount()` 메서드를 통해 계좌를 생성한다. `Client` 클래스는 메인 클래스로서 계좌 작업을 시뮬레이션하게 된다. `performAccountOperation()`메서드를 통해 계좌를 생성하고 입출금 작업을 수행하며 잔액을 표시할 수 있다.

<br/>

### 🖥️ 출력 화면
![image](https://github.com/hyeyeonismm/PDA-JavaPattern/assets/91720344/efe2d9ad-c7a1-4465-a3ef-e96db9c400c3)

<br/>

### 😞 Before Factory Method
```
public class Client {
    public static void main(String[] args) {
        // 직접 CheckingAccount 객체를 생성
        Account johnsAccount = new CheckingAccount("John", 5000);
        performAccountOperations(johnsAccount, 2000, 4000);
        System.out.println("=====================================");
        
        // 직접 SavingAccount 객체를 생성
        Account annasAccount = new SavingAccount("Anna", 1000);
        performAccountOperations(annasAccount, 3000, 2000);
    }

    private static void performAccountOperations(Account account, int depositAmount, int withdrawAmount) {
        account.make();
        account.displayBalance();
        account.deposit(depositAmount);
        account.displayBalance();
        account.withdraw(withdrawAmount);
        account.displayBalance();
    }
}
```

패턴을 적용하기 전은, 새로운 계좌를 추가하거나 계좌 생성 로직을 변경할 때마다 `Client` 클래스를 수정해야 한다. 패턴을 사용하면 `AccountFactory` 클래스의 `createAccount()` 메서드를 통해 객체 생성 로직을 수행할 수 있기 때문에 코드의 확장성이 높아지고 코드 변경에 따른 위험이 줄어든다.



<br/>

## 2️⃣ Observer Pattern
* __주가가 변경될 때마다 Client들에게 알림 메시지가 가는 앱__
<img src="https://github.com/hyeyeonismm/PDA-JavaPattern/assets/91720344/40c03389-c30e-42b2-aa40-2346b5c26677" width="60%">

Observer 패턴은 객체의 상태 변화를 다른 객체에게 통지하는 패턴이다. 이 패턴은 데이터의 변경이 일어나는 경우에 유용하기 때문에 주가가 변경될 때마다 고객에게 알림 메시지를 전송하는 시나리오를 구현했다.
`stock` 인터페이스는 주가 변화를 나타내는 인터페이스로 `updatePrice()`와 `getPrice()`로 메서드를 정의하고있다. `StockSystem` 클래스는 `Stock` 인터페이스를 구현하는 클래스로서 주식 가격이 변경될 때 모든 고객들에게 알림을 보낸다. `notifyAllClients()` 메서드를 사용하여 모든 고객들에게 주가 변경을 통지한다. `Notify` 인터페이스는 Observer 역할을 하는 클래스가 구현해야 하는 인터페이스로 `sendMessage()` 메서드를 통해 메시지를 전송하는 기능을 정의한다. `NotifyClient` 클래스는 실제 메시지 전송을 다양한 print 메서드를 통해 구현하며, `Client`와 `ClientDAO` 클래스를 통해 고객의 정보를 저장할 수 있다. `App`클래스를 통해 `stockSystem`의 객체를 생성하고 고객에게 메시지를 보내는 과정을 출력한다.

<br/>

### 🖥️ 출력 화면
![image](https://github.com/hyeyeonismm/PDA-JavaPattern/assets/91720344/b0fb1598-d1bc-415a-ba1f-77e0bc651a24)

<br/>


### 😞 Before Observer Pattern
```
public class StockSystem {
    private double price;

    public StockSystem(double price) {
        this.price = price;
    }

    public void updatePrice(double updatePrice) {
        this.price = updatePrice;
        
        // Directly notify the clients about the price change.
        Set<Client> clients = ClientDAO.getAllClients();
        for (Client client : clients) {
            sendNotification(client, "Stock price updated to " + getPrice());
        }
    }

    private void sendNotification(Client client, String message) {
        System.out.println("Sending message to " + client.getEmail() + " -> " + message);
    }

    public double getPrice() {
        return this.price;
    }
}
```
패턴을 적용한 후에는 `Notify`와 `Stock` 인터페이스를 분리하여 확장성을 높인다. 고객에게 메시지를 전송하는 프로세스를 직접 구현하지 않고 인터페이스를 통해 간접적으로 구현하여 새로운 알림 방식을 추가할 경우에는 `Notify` 인터페이스의 새로운 구현을 추가하기만 하면 된다. 따라서 기존 로직의 변경이 필요할 때 더 쉽게 적용할 수 있다.
  
<br/>

## 3️⃣ Composite Pattern
* __개인별 투자 포트폴리오 내의 보유 종목과 총 가격을 나타내는 시나리오__
<img src="https://github.com/hyeyeonismm/PDA-JavaPattern/assets/91720344/312a74c5-ba5f-4d11-8286-3277d4ad9dd7" width="60%">

Composite 패턴은 객체들의 그룹을 단일 인스턴스처럼 다루기 위한 패턴이다. 해당 시나리오에서는 `stock` 인터페이스를 통해 모든 주식 객체가 가져야하는 공통 메서드를 정의한다. `getStockName()`과 `getPrice()`를 메서드를 정의하고 있으며, 이는 `PersonalStock` 클래스와 `PersonalPortfolio` 클래스에서 구현된다. `PersonalStock` 클래스는 단일 주식을 나타내는 클래스이며, `PersonalPortfolio` 클래스는 주식을 포함하는 개인 별 포트폴리오를 나타내는 클래스이다. `Stock` 리스트와 `add()` 메서드를 사용하여 사용자가 보유하고 있는 주식을 추가할 수 있다. 해당 클래스에서는 `getPrice()` 메서드를 통해 보유하고 있는 모든 주식 종목명과 총 가격을 반환하는데, 이를 투자 포트폴리오라고 정의한다. `ResearchApp` 클래스는 메인 클래스로서 개별 포트폴리오를 생성하고, 보유 주식을 추가하여 목록을 출력한다. 

<br/>

### 🖥️ 출력 화면
![image](https://github.com/hyeyeonismm/PDA-JavaPattern/assets/91720344/328c493e-872d-4cf4-ac50-02a233cc9f20)

<br/>

### 😞 Before Composite Pattern
```
 public String listStocks() {
        StringBuilder stockNames = new StringBuilder();
        for (SimpleStock stock : stocks) {
            stockNames.append(stock.getName()).append(", ");
        }
        return stockNames.toString();
}
```
Stock 종목들을 추가할 때 코드가 복잡하다. 패턴을 적용하면 Stock 인터페이스를 구현하므로 개별 주식을 쉽게 추가할 수 있다.

<br/>
