# Design Pattern Assignment

## Design Pattern
- 프로그램 개발에서 빈번하게 나타나는 과제를 해결하기 위한 방법 중 하나이다.
- 소프트웨어 개발 과정에서 같은 실수를 반복하지 않기 위해 자신들의 시행착오를 바탕으로 특정 상황에서 발생하는 문제 패턴을 발견하고 해결 방안을 기록한 것을 뜻한다.
- 재이용하기 좋은 형태로 특정의 규약을 묶어서 정리하여 특정한 상황에서 구조적인 문제를 해결하는 방식이다.
- 즉, 소프트웨어 설계 시 또는 프로그램 개발 과정에서 특정한 부분에서 빈번하게 발생하는 문제를 정리하여 상황에 따라 해결할 수 있는 해결책(패턴)을 뜻한다.
- 라이브러리나 프레임워크가 도와 주지 못하는 부분을 도와 주는 것이 바로 디자인 패턴이다.
- 디자인 패턴을 완전히 익혀 두면 어떤 코드가 스파게티 코드인지 금방 깨달을 수 있고, 그 코드를 수정할 때 패턴을 적용해서 코드를 개선할 수 있다.

<br/>

### 디자인 패턴의 구조
디자인 패턴은 3 가지 구조로 이루어져 있다.

<br/>

1. 콘텍스트(Context)    
    문제가 발생하는 여러 상황으로 즉, 패턴이 적용될 상황을 뜻한다.    
    패턴은 상황에 맞게 써야 하고, 항상 유효하지 않는다.    
2. 문제(Problem)    
    패턴이 적용되어서 해결되어야 할 필요가 있는 디자인 이슈들을 말한다.    
    이는 여러 제약 사항과 영향력도 문제 해결을 위해 고려해야 한다.    
3. 해결(Solution)    
    문제를 해결하도록 설계를 구성하는 요소들과 그 요소들 사이의 관계, 책임, 협력을 말한다.    
    Solution은 구체적인 구현 방법 및 다양한 상황에 적용할 수 있는 일종의 템플릿을 뜻한다.
    
<br/>

### GoF 디자인 패턴
- 1995년 GoF(Gang of Four) 라고 불리는 4명의 유명한 개발자들인 Erich Gamma, Richard Helm, Ralph Johnson, John Vissides가 처음으로 디자인 패턴을 구체화하였다.
- GoF의 디자인 패턴은 소프트웨어 공학에서 가장 많이 사용되는 디자인 패턴이다.
- 목적에 따라 Gof 디자인 패턴은 생성, 구조, 행위 3가지로 분류하였다.

<br/>

1. 생성 패턴(Creational Pattern)
    - 객체 생성과 관련된 패턴으로 객체의 생성 및 조합을 캡슐화해 객체가 생성되거나 변경되어도 프로그램에 영향을 미치지 않게 하는 유연성을 높여 주는 패턴이다.
2. 구조 패턴(Structural Pattern)
    - 더 큰 구조를 형성하기 위해 클래스, 객체들을 어떻게 구성하고 합성할지 정하는 데 활용할 수 있는 패턴이다.
    - 복잡한 구조 개발과 유지 보수를 쉽게 만들어 준다.
3. 행동 패턴(Behavioral Pattern)
    - 반복적으로 사용되는 객체들의 상호 작용을 패턴화한 것이다.
    - 객체나 클래스 사이에서 상호 작용하는 방법과 책임을 분산하는 방법을 정의하는 패턴이다.
    - 객체나 클래스의 유형을 정의하는 것이 아니라 클래스 사이의 책임과 협력에 대한 유형을 제시한다.

<br/>

### GoF 디자인 패턴의 종류
| 생성 패턴 | 구조 패턴 | 행위 패턴 |
| --- | --- | --- |
| Abstract Factory | Adapter | Chain of Responsibility |
| Builder | Bridge | Command |
| Factory Method | Composite | Interpreter |
| Prototype | Decorator | Iterator |
| Singleton | Facade | Mediator |
|  | Flyweight | Memento |
|  | Proxy | Observer |
|  |  | State |
|  |  | Strategy |
|  |  | Template Method |
|  |  | Visitor |

<br/>

> 이 문서에서는 디자인 패턴에 등장하는 클래스나 인스턴스의 관계를 나타내기 위해 UML을 이용한다. 
>

<br/>
<br/>

## Example!
위에서 설명한 디자인 패턴 중 Strategy 패턴, Template Method 패턴, Factory Method 패턴의 예제 프로그램을 개발했다.  
패턴을 학습하면서 예제 프로그램을 개발해 봄으로써 해당 패턴을 더 깊게 이해해 보고자 했다.

<br/>

### Strategy Pattern Example
#### Strategy Pattern?
Strategy Pattern이란, ‘Strategy’의 뜻인 ‘전략’ 의 의미처럼 알고리즘을 바꿔서 같은 문제를 다른 방법으로 해결하기 쉽게 만들어 주는 패턴이다.  
동일 계열의 알고리즘들을 정의하고, 각각 캡슐화하며 이들을 상호 교환이 가능하도록 만든다.  
또한 알고리즘을 사용하는 사용자로부터 독립적으로 알고리즘이 변경될 수 있도록 하는 패턴이다.

<br/>

##### Strategy Pattern의 등장 인물
- Strategy(전략) 역
    - 전략을 이용하기 위한 인터페이스(API)를 결정한다.
    - 예제 프로그램에서는 PageReplacementStrategy 인터페이스가 이 역할을 맡았다.
- ConcreteStrategy(구체적인 전략) 역
    - Strategy 역의 인터페이스(API)를 실제로 구현한다.
    - 여기서 구체적인 전략(작전, 방안, 방법, 알고리즘)을 실제로 프로그래밍한다.
    - 예제 프로그램에서는 FIFOStrategy 클래스와 LRUStrategy 클래스, LFUStrategy 클래스가 이 역할을 맡았다.
- Context(문맥) 역
    - Strategy 역을 이용한다.
    - ConcreteStrategy의 인스턴스를 가지고 있다가 필요에 따라서 이용한다.
        - 어디까지나 호출하는 것은 Strategy의 인터페이스(API)이다.
    - 예제 프로그램에서는 MemoryManager 클래스가 이 역할을 맡았다.

<br/>

##### Strategy Pattern의 클래스 다이어그램
![image](https://github.com/C0012S/PDA-JavaPattern/assets/66476874/0c250a9e-11a0-4643-bfe6-411ea4c247ad)

<br/>

인터페이스로 정의된 Strategy를 ConcreteStrategy1, ConcreteStrategy2, ConcreteStrategy3이 구현한다. 각 ConcreteStrategy 클래스는 특정한 전략을 구현한다.  
여러 개의 ConcreteStrategy 클래스는 존재할 수 있으며 필요에 따라 Context 클래스가 ConcreteStrategy의 인스턴스를 가지고 있다가 필요에 따라서 이용한다.

<br/>

##### Why Strategy Pattern?
Strategy 패턴은 다양한 상황에 따라 알고리즘을 변경하고 확장하기 위한 유용한 패턴 중 하나이다.  
이 패턴의 장점과 사용하는 이유는 다음과 같다.  
- 유연성과 확장성
    - Strategy 패턴은 알고리즘을 캡슐화하고, 이를 교체 가능한 객체로 만든다. 이로써 기존의 알고리즘을 변경하거나 새로운 알고리즘을 추가할 때 전체 시스템을 수정하지 않고도 쉽게 대응할 수 있다. 따라서 시스템이 더 유연하고 확장 가능하다.
- 재사용성
    - 각각의 알고리즘은 독립적으로 구현되며 재사용 가능하다. 동일한 전략을 다른 컨텍스트에서 사용하거나 다른 전략을 동일한 컨텍스트에서 사용할 수 있다.
- 유지 보수성
    - Strategy 패턴을 사용하면 변경이나 유지 보수가 쉬워진다. 알고리즘에 대한 수정 또는 버그 수정이 해당 알고리즘의 클래스에만 영향을 미치므로 다른 부분에는 영향을 미치지 않는다.
- 테스트 용이성
    - 각 전략은 독립적으로 테스트 가능하다. 따라서 특정 전략의 동작을 확인하고 검증하기 쉽다.
- 알고리즘 교체
    - 실행 중에 알고리즘을 동적으로 교체할 수 있다. 이는 런타임에 다양한 전략을 선택할 수 있는 장점을 제공한다. 예를 들어, 성능 향상을 위해 알고리즘을 변경하거나 사용자의 환경에 따라 다른 전략을 선택할 수 있습니다.
- 분리된 관심사
    - Strategy 패턴은 알고리즘을 컨텍스트로부터 분리하여 각각의 클래스가 하나의 주요 관심사에 집중하게 한다. 이로 인해 코드의 가독성이 향상되며, 단일 책임 원칙(Single Responsibility Principle)을 준수하는 디자인을 가능하게 한다.

<br/>
<br/>

#### Explain Example
페이지 교체 알고리즘은 스왑 영역으로 보낼 페이지를 결정하는 알고리즘으로, 메모리에서 앞으로 사용할 가능성이 적은 페이지를 대상 페이지로 선정하여 페이지 부재를 줄이고 시스템의 성능을 향상한다.  
페이지 교체 알고리즘에는 여러 가지 알고리즘이 있고, 알고리즘마다 각자의 장단점이 있다.  
페이지 교체 알고리즘이 작동하는 방식을 직접 눈으로 보고, 어떤 상황에서 어떤 알고리즘이 더 효율적인지 확인할 수 있으면 좋을 것 같다는 생각에 해당 프로그램을 개발했다.

<br/>

페이지 교체 알고리즘을 ‘전략’ 으로 생각하여 페이지 교체 알고리즘 자체를 Strategy 역으로, 각각의 페이지 교체 알고리즘은 ConcreteStrategy 역으로 구현했다.  
그리고 페이지 교체 알고리즘을 사용하여 메모리에서 앞으로 사용할 가능성이 적은 페이지를 대상 페이지로 선정하므로 MemoryManager를 Context 역으로 구현했다.

<br/>

##### 클래스 목록
| 클래스 이름 | 설명 | 역할 |
| --- | --- | --- |
| PageReplacementStrategy | 페이지 교체 알고리즘의 ‘전략’ 을 나타내는 인터페이스 | Strategy(전략) |
| FIFOStrategy | 페이지 교체 알고리즘의 FIFO 페이지 교체 알고리즘 전략 | ConcreteStrategy(구체적인 전략) |
| LRUStrategy | 페이지 교체 알고리즘의 LRU 페이지 교체 알고리즘 전략 | ConcreteStrategy(구체적인 전략) |
| LFUStrategy | 페이지 교체 알고리즘의 LFU 페이지 교체 알고리즘 전략 | ConcreteStrategy(구체적인 전략) |
| MemoryManager | 페이지 교체 알고리즘을 실행할 때 해당 알고리즘을 설정하고 실행 | Context(문맥) |
| Main | 동작 테스트용 클래스 |  |

<br/>

##### 클래스 다이어그램
![image](https://github.com/C0012S/PDA-JavaPattern/assets/66476874/d9a02866-85a5-4df0-947c-5f30e73dd8cb)

<br/>

인터페이스로 정의된 PageReplacementStrategy를 FIFOStrategy, LRUStrategy, LFUStrategy가 구현한다. 이는 ConcreteStrategy 역의 클래스로 특정한 전략을 구현한다.  
여러 개의 ConcreteStrategy 클래스가 존재할 수 있으며 필요에 따라 Context 역의 MemoryManager 클래스가 ConcreteStrategy 역의 클래스의 인스턴스를 가지고 있다가 필요에 따라서 이용한다.

<br/>

##### 코드
- PageReplacementStrategy.java

```java
package PageReplacement;

public interface PageReplacementStrategy {
	public abstract void replace(int demandPage);
}
```

<br/>

PageReplacementStrategy 인터페이스는 페이지 교체 알고리즘을 정의하는 인터페이스이다.   
모든 페이지 교체 알고리즘 클래스는 이 인터페이스를 구현해야 한다.

<br/>

- FIFOStrategy.java

```java
package PageReplacement;

public class FIFOStrategy implements PageReplacementStrategy {
	@Override
	public void replace(int demandPage) {
		System.out.println("FIFO 교체 알고리즘을 사용하여 " + demandPage + " 페이지를 교체합니다.");
	}
}
```

<br/>

FIFOStrategy 클래스는 FIFO(First-In, First-Out) 페이지 교체 알고리즘을 구현한 클래스이다.   
가장 먼저 들어온 페이지를 교체하는 알고리즘이지만, 해당 코드에서는 동작했다는 문자와 요구 페이지 번호만 출력한다.

<br/>

- LRUStrategy.java

```java
package PageReplacement;

public class LRUStrategy implements PageReplacementStrategy {
	@Override
	public void replace(int demandPage) {
		System.out.println("LRU 교체 알고리즘을 사용하여 " + demandPage + " 페이지를 교체합니다.");
	}
}
```

<br/>

LRUStrategy 클래스는 LRU(Least Recently Used) 페이지 교체 알고리즘을 구현한 클래스이다.   
가장 오랫동안 사용하지 않은 페이지를 교체하는 알고리즘이지만, 해당 코드에서는 동작했다는 문자와 요구 페이지 번호만 출력한다.

<br/>

- LFUStrategy.java

```java
package PageReplacement;

public class LFUStrategy implements PageReplacementStrategy {
	@Override
	public void replace(int demandPage) {
		System.out.println("LFU 교체 알고리즘을 사용하여 " + demandPage + " 페이지를 교체합니다.");
	}
}
```

<br/>

LFUStrategy 클래스는 LFU(Least Frequently Used) 페이지 교체 알고리즘을 구현한 클래스이다.   
가장 적게 사용된 페이지를 교체하는 알고리즘이지만, 해당 코드에서는 동작했다는 문자와 요구 페이지 번호만 출력한다.

<br/>

- MemoryManager.java

```java
package PageReplacement;

public class MemoryManager {
	private PageReplacementStrategy strategy;
	
	public MemoryManager() {
		
	}
	
	public MemoryManager(PageReplacementStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void setStrategy(PageReplacementStrategy strategy) {
        this.strategy = strategy;
    }

    public void requestPageReplacement(int demandPage) {
    	strategy.replace(demandPage);
    }
}
```

<br/>

MemoryManager 클래스는 페이지 교체 알고리즘을 실행하는 메모리 관리 클래스이다.   
페이지 교체 알고리즘을 선택하고 실행할 때 사용한다.

<br/>

- Main.java

```java
package PageReplacement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PageReplacementStrategy fifoStrategy = new FIFOStrategy();
		PageReplacementStrategy lruStrategy = new LRUStrategy();
		PageReplacementStrategy lfuStrategy = new LFUStrategy();
		MemoryManager memoryManager = new MemoryManager();
		
		while (true) {
			System.out.println("사용할 페이지 교체 알고리즘을 선택해 주세요.");
			System.out.println("1. FIFO 알고리즘");
            System.out.println("2. LRU 알고리즘");
            System.out.println("3. LFU 알고리즘");
            System.out.println("4. 종료");
            System.out.print("선택 (1/2/3): ");
			
			int strategyNum = Integer.parseInt(bf.readLine());
			if (strategyNum == 1) {
				System.out.print("교체할 페이지 : ");
				int demandPage = Integer.parseInt(bf.readLine());
				memoryManager.setStrategy(fifoStrategy);
				memoryManager.requestPageReplacement(demandPage);
			}
			else if (strategyNum == 2) {
				System.out.print("교체할 페이지 : ");
				int demandPage = Integer.parseInt(bf.readLine());
				memoryManager.setStrategy(lruStrategy);
				memoryManager.requestPageReplacement(demandPage);
			}
			else if (strategyNum == 3) {
				System.out.print("교체할 페이지 : ");
				int demandPage = Integer.parseInt(bf.readLine());
				memoryManager.setStrategy(lfuStrategy);
				memoryManager.requestPageReplacement(demandPage);
			}
			else if (strategyNum == 4) {
				break;
			}
			else {
				System.out.println("올바른 선택이 아닙니다. 다시 선택해 주세요.");
			}
			
			System.out.println();
		}
	}
}
```

<br/>

Main 클래스는 사용자와 상호 작용하여 페이지 교체 알고리즘을 선택하고 실행하는 메인 클래스이다.  
사용자 입력을 받아서 다음과 같이 동작한다.  
- 사용자가 1 번을 입력했을 경우
    - FIFO 페이지 교체 알고리즘을 사용한다.
- 사용자가 2 번을 입력했을 경우
    - LRU 페이지 교체 알고리즘을 사용한다.
- 사용자가 3 번을 입력했을 경우
    - LFU 페이지 교체 알고리즘을 사용한다.
- 사용자가 4 번을 입력했을 경우
    - 페이지 교체를 종료한다.
- 사용자가 그 외 번호를 입력했을 경우
    - 올바른 선택이 아니므로 다시 번호를 입력하도록 한다.

<br/>

##### 실행 결과
![image](https://github.com/C0012S/PDA-JavaPattern/assets/66476874/f1b13e24-a980-46c1-aebf-05c4e711f8c3)

![image](https://github.com/C0012S/PDA-JavaPattern/assets/66476874/afe36d5a-30d9-4c3f-9377-7322bec7ba17)

![image](https://github.com/C0012S/PDA-JavaPattern/assets/66476874/9f505f5e-df4f-493a-a9a8-f3912407b033)

![image](https://github.com/C0012S/PDA-JavaPattern/assets/66476874/e02832f5-de8f-4d3a-a141-6860658e8820)

![image](https://github.com/C0012S/PDA-JavaPattern/assets/66476874/3bf02102-b0d6-4de5-a954-dce3d6678221)

<br/>

##### Moreover… Strategy Pattern With Enum
Strategy 패턴을 적용하여 작성한 코드의 Main.java에서 원하는 페이지 교체 알고리즘을 선택하는 코드에서 알고리즘의 개수가 더 늘어난다면 if-else 문은 더 길어질 것이고, 불필요한 코드의 양은 더 많아질 것이다.  
동일한 타입의 값이 추가되고 동일한 동작을 하는 것에 비해 너무 많은 반복성 코드가 발생하게 된다.  
이를 해결하기 위해 Enum을 사용하여 이 상황을 해결하고자 했다.  
Enum을 적용한 코드는 StrategyWithEnum 폴더에서 볼 수 있다.  

<br/>

추가된 PageReplacementAlgorithm 코드와 변경된 Main 코드를 제외한 나머지 코드는 모두 같다.

<br/>

- PageReplacementAlgorithm.java

```java
package PageReplacement;

/**
 * 페이지 교체 알고리즘을 나타내는 Enum
 * @version 1.0
 * @author Park SangHee
 **/
public enum PageReplacementAlgorithm {
	FIFO(new FIFOStrategy()),
	LRU(new LRUStrategy()),
	LFU(new LFUStrategy());
	
	/**
	 * PageReplacementStrategy 인스턴스
	 **/
	private final PageReplacementStrategy strategy;

	/**
	 * PageReplacementAlgorithm의 생성자
	 * @param strategy 해당 페이지 교체 알고리즘을 나타내는 페이지 교체 알고리즘 인스턴스
	 **/
	PageReplacementAlgorithm(PageReplacementStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 해당 페이지 교체 알고리즘의 페이지 교체 알고리즘을 반환하는 메서드
	 * @return 페이지 교체 알고리즘 인스턴스
	 **/
	public PageReplacementStrategy getPageReplacementStrategy() {
		return strategy;
	}
}
```

<br/>

PageReplacementAlgorithm 클래스는 페이지 교체 알고리즘을 정의하는 Enum이다.  
FIFO 페이지 교체 알고리즘, LRU 페이지 교체 알고리즘, LFU 페이지 교체 알고리즘을 나타내는 Enum 상수가 정의되어 있다.  
각 Enum 상수는 해당 알고리즘을 실제로 구현한 객체를 생성하고 초기화하여 PageReplacementStrategy를 구현한 클래스 객체를 갖는다.  
Enum 상수별로 해당 알고리즘을 반환하는 getPageReplacementStrategy 메서드를 제공한다.

<br/>

- Main.java

```java
package PageReplacement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main Class : 페이지 교체 알고리즘을 수행하는 클래스
 * @version 1.0
 * @author Park SangHee
 **/
public class Main {
	/**
	 * 프로그램의 주요 실행 메서드
	 * 사용자가 페이지 교체 알고리즘을 선택할 수 있게 하고, 입력된 페이지 교체
	 * @param args 명령행 인수 배열
	 * @throws IOException 입출력 예외 발생 시
	 **/
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// MemoryManager 객체 생성
		MemoryManager memoryManager = new MemoryManager();
		
		while (true) {
			System.out.println("사용할 페이지 교체 알고리즘을 선택해 주세요.");
			System.out.println("1. FIFO 알고리즘");
            System.out.println("2. LRU 알고리즘");
            System.out.println("3. LFU 알고리즘");
            System.out.println("4. 종료");
            System.out.print("선택 : ");
			
            // 사용자가 선택한 번호
			int strategyNum = Integer.parseInt(bf.readLine());
			
			// 종료 번호 선택 시 반복문 종료
			if (strategyNum == 4) {
				break;
			}
			else if (strategyNum < 1 || strategyNum > 3) {
				// 보기의 번호가 아닐 경우 다시 선택해달라는 메시지를 출력하고, 다시 선택 가능하도록 반복
				System.out.println("올바른 선택이 아닙니다. 다시 선택해 주세요.");
				System.out.println();
				continue;
			}
			
			// 교체할 페이지 번호
			System.out.print("교체할 페이지 : ");
			int demandPage = Integer.parseInt(bf.readLine());
			
			// 선택한 페이지 교체 알고리즘을 MemoryManager에 설정하고, 페이지 교체 수행
			PageReplacementAlgorithm pageReplacementAlgorithm = PageReplacementAlgorithm.values()[strategyNum - 1];
			memoryManager.setStrategy(pageReplacementAlgorithm.getPageReplacementStrategy());
			memoryManager.requestPageReplacement(demandPage);
			
			System.out.println();
		}
	}
}
```

<br/>

기능은 Enum을 사용하기 전 Strategy 패턴 예제와 같다.  
그러나 Enum을 사용함으로써 페이지 교체 알고리즘을 더 쉽게 선택하고 사용할 수 있다.  
선택한 페이지 교체 알고리즘을 PageReplacementAlgorithm Enum을 통해 간단하게 설정하고 사용할 수 있으며, 코드의 가독성과 유지 보수성을 향상시킨다.  
이로써 새로운 페이지 교체 알고리즘을 추가하거나 기존 알고리즘을 변경하는 작업이 더 효율적으로 수행된다.

<br/>
<br/>

## Commit Message Convention
- ➕ [ADD] : 파일이나 부수적인 코드 추가
- ✅ [MOD] : 코드 및 내부 파일 수정
- 🗑 [DEL] : 쓸모없는 코드나 파일 삭제
- ✏️ [CORRECT] : 문법 오류 해결, 타입 변경, 이름 변경 등의 작은 수정
- 📄 [DOCS] : README 등의 문서 개정
- 🚚 [MOVE] : 프로젝트 파일 및 코드 이동
- 🔁 [RENAME] : 파일 이름 변경
- 🔀 [MERGE] : 다른 브랜치와의 충돌 해결 후 Merge
- ♻️ [REFACTOR] : 전면 수정
- 📝 [COMMENT]: 주석 추가 및 업데이트
- 📚 [JAVADOC]: JavaDoc 추가 및 업데이트
