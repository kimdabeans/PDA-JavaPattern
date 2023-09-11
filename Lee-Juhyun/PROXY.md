## Proxy 패턴 

프록시 패턴은 대상 원본 객체를 **대리하여 대신 처리하게 함으로써 로직의 흐름을 제어**하는 행동 패턴이다.


프록시(Proxy)의 사전적인 의미는 '대리인'이라는 뜻이다. 
즉, 누군가에게 어떤 일을 대신 시키는 것을 의미하는데, 이를 객체 지향 프로그래밍에 접목해보면 클라이언트가 대상 객체를 직접 쓰는게 아니라 
중간에 프록시(대리인)을 거쳐서 쓰는 코드 패턴이라고 보면 된다. 
따라서 대상 객체(Subject)의 메소드를 직접 실행하는 것이 아닌, 
대상 객체에 접근하기 전에 프록시(Proxy) 객체의 메서드를 접근한 후 추가적인 로직을 처리한뒤 접근하게 된다.

![image](https://github.com/JZU0/Java-design-patterns/assets/97423172/d09f93d8-6b74-4ba7-b455-ab166487c1e8)



#### 프록시 패턴을 사용했을 때 다음과 같은 효과를 얻을 수 있다.
1. 보안(Security) : 프록시는 클라이언트가 작업을 수행할 수 있는 권한이 있는지 확인하고 검사 결과가 긍정적인 경우에만 요청을 대상으로 전달한다.
2. 캐싱(Caching) : 프록시가 내부 캐시를 유지하여 데이터가 캐시에 아직 존재하지 않는 경우에만 대상에서 작업이 실행되도록 한다.
3. 데이터 유효성 검사(Data validation) : 프록시가 입력을 대상으로 전달하기 전에 유효성을 검사한다.
4. 지연 초기화(Lazy initialization) : 대상의 생성 비용이 비싸다면 프록시는 그것을 필요로 할때까지 연기할 수 있다.
5. 로깅(Logging) : 프록시는 메소드 호출과 상대 매개 변수를 인터셉트하고 이를 기록한다.
6. 원격 객체(Remote objects) : 프록시는 원격 위치에 있는 객체를 가져와서 로컬처럼 보이게 할 수 있다. 


#### 패턴을 사용하면 좋은 시기는 다음과 같다.
- 접근을 제어하거가 기능을 추가하고 싶은데, 기존의 특정 객체를 수정할 수 없는 상황일때
- 초기화 지연, 접근 제어, 로깅, 캐싱 등, 기존 객체 동작에 수정 없이 가미하고 싶을 때  


#### 패턴의 장점
- 개방 폐쇄 원칙(OCP)Visit Website 준수
  - 기존 대상 객체의 코드를 변경하지 않고 새로운 기능 추가 가능
- 단일 책임 원칙(SRP)Visit Website 준수
  - 대상 객체는 자신의 기능에만 집중 하고, 그 이외 부가 기능을 제공하는 역할을 프록시 객체에 위임하여 다중 책임 회피 가능
- 원래 하려던 기능을 수행하며 그외의 부가적인 작업(로깅, 인증, 네트워크 통신 등)을 수행하는데 유용하다
- 클라이언트는 객체를 신경쓰지 않고, 서비스 객체를 제어하거나 생명 주기를 관리할 수 있다.
- 사용자 입장에서는 프록시 객체나 실제 객체나 사용법은 유사하므로 사용성에 문제 되지 않는다.


#### 패턴의 단점
- 많은 프록시 클래스를 도입해야 하므로 코드의 복잡도가 증가한다.
  - 예를들어 여러 클래스에 로깅 기능을 가미 시키고 싶다면, 동일한 코드를 적용함에도 각각의 클래스에 해당되는 프록시 클래스를 만들어서 적용해야 되기 때문에 코드량이 많아지고 중복이 발생 된다.
  - 자바에서는 리플렉션에서 제공하는 동적 프록시(Dynamic Proxy) 기법을 이용해서 해결할 수 있다.
- 프록시 클래스 자체에 들어가는 자원이 많다면 서비스로부터의 응답이 늦어질 수 있다. 


---


### 예제를 통해 살펴보자.

주식 거래 프로그램을 만든다고 가정해보자.

주식 트레이딩 시스템은 약 3초의 시간이 걸리며, 완료 됐을 경우 주식 종류를 받는다.

#### 먼저 proxy 패턴을 적용하지 않았을 때 : [전체 코드](https://github.com/JZU0/Java-design-patterns/tree/main/Lee-Juhyun/beforeProxy) 
##### 메인 클래스와 결과를 간략히 살펴보면 다음과 같다.
```public class Main {
	public static void main(String[] args) {
		StockMarket ITStock = new StockMarket("IT 주식");
		StockMarket CarStock = new StockMarket("자동차 주식");
		StockMarket USAStock = new StockMarket("미국 주식");
		
		ITStock.successfulStockTrading();	
	}
}
```

![beforeproxy](https://github.com/JZU0/Java-design-patterns/assets/97423172/cc50b10e-0650-4992-934f-a124d22ea248)

##### 실행 결과를 보면 IT 주식의 거래가 완료되기까지 시간이 많이 소요되는 것을 알 수 있다. 
##### 다른 주식들의 거래를 수행하는 과정에서 시간을 많이 썼기 때문이다. 
##### 이를 특정 주식을 선택하기 전까지 주식 거래를 미리 진행시키지 않고, 선택한 주식만 거래를 시키면 해결할 수 있을 것이다.

*이때 proxy 패턴이 큰 역할을 한다!*

#### proxy 패턴을 적용했 때 : [전체 코드](https://github.com/JZU0/Java-design-patterns/tree/main/Lee-Juhyun/afterProxy) 
##### 메인 클래스와 결과를 간략히 살펴보면 다음과 같다.
```public class Main {
	public static void main(String[] args) {
		ITrading ITStock = new StockProxy("IT 주식");
		ITrading CarStock = new StockProxy("자동차 주식");
		ITrading USAStock = new StockProxy("미국 주식");
		
		ITStock.successfulStockTrading();
	}
}
```

![afterproxy](https://github.com/JZU0/Java-design-patterns/assets/97423172/017ead6c-4e1e-42d5-9402-2dc12f02dd78)


##### 클라이언트 코드자체는 크게 변하지 않았고, 똑같이 3개의 주식 거래를 하는 코드에 대상 객체 대신 프록시 객체에 할당한 점이 변화된 부분이다.  
##### 내부 동작 방식은 크게 변경 되었는데, 프록시 객체 내에서 타입 데이터를 지니고 있다가 사용자가 successfulStockTrading()를 호출하면 그때서야 대상 객체를 로드하여 타입을 저장하고 대상 객체의 successfulStockTrading() 메소드를 위임 호출함으로써 실제 메소드를 호출하는 시점에 트레이딩이 진행되기 때문에 불필요한 시간이 줄어든다.

---

### 코드의 전체적인 구조를 알기 위해 UML 클래스 다이어그램을 살펴보자.

|<b>Proxy pattern UML</b> |
| :--: |
| ![proxyUML](https://github.com/JZU0/Java-design-patterns/assets/97423172/00998f47-6c57-4859-9021-6d2e3b0bb39d)|

#### Proxy 패턴을 구현하는데 있어 중요한 것은 대상 객체와 프록시 객체를 하나로 묶어주는 인터페이스를 정의하는 것이다. 때문에 StockProxy클래스와 StockMarket클래스를 동일시하기 위해 공통 인터페이스인 ITrading을 정의하였다.
#### 여기서 StockMarket 클래스는 '본인'을 나타내는 클래스이다. StockMarket 클래스의 인스턴스 생성에 시간이 오래 걸린다는 전제로 프로그램을 작성하였기 때문에 successfulStockTrading 메소드는 무거운 작업을 나타낸다. 
#### proxy 패턴에서 가장 중요한 StockProxy 클래스는 대리인 역할을 하며, ITrading 인터페이스를 구현한다. type은 타입을 저장하고, proxyStock 필드는 '본인'을 저장한다.
#### Main 클래스는 StockProxy를 경유해서 StockMarket를 이용하는 클래스이다. 실행 결과를 보면 처음에는 인스턴스(본인)가 생성되지 않고, successfulStockTrading 메소드를 호출한 후에 생성되는 것을 확인할 수 있다. 








 
