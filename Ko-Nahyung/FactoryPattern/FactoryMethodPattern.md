# Factory Method Pattern

&ensp;Factory Method Pattern는 부모 클래스에서 객체들을 생성할 수 있는 인터페이스를 제공하지만, 자식 클래스들이 생성될 객체들의 유형을 변경할 수 있도록 하는 생성 패턴입니다.

### Factory Method Pattern UML
![Factory_before](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/e2287882-0a1a-4ba1-baa6-2bafafa57ef1)

Factory Method Pattern의 등장인물
- Product: 프레임워크 부분에 있습니다. 이 패턴으로 생성되는 인스턴스가 가져야 할 인터페이스를 결정하는 추상 클래스입니다. 구체적인 내용은 하뤼 클래스 ConcreteProduct에서 결정합니다. 위 UML에서는 Product에 해당합니다.
- Creator: 프레임워크 부분에 있습니다. Product 역을 생성하는 추상 클래스입니다. 구체적인 내용은 하위 클래스 ConcreteCreator가 결정합니다. 위 UML에서는 Factory클래스에 해당합니다. Creator 역은 실제로 생성할 ConcreteProduct역에 대해서 알지 못합니다. Creator역은 Product역과, 인스턴스 생성 메소드를 호출하면 Product가 생성된다는 것입니다. new를 사용하여 실제 인스턴스를 생성하지 않고, 인스턴스를 생성하는 메소드를 호출함으로써 구체적인 클래스 이름에 의한 속박에서 상위 클래스를 자유롭게 합니다.
- ConcreteProduct: 구체적인 내용에 해당하는 부분입니다. 구체적인 제품을 결정하며, 위 UML에서는 IDCard에 해당합니다.
- ConcreteCreator: 구체적인 내용에 해당하는 부분입니다. 구체적인 제품을 만들 클래스를 결정합니다. 위 UML에서는 IDCardFactory에 해당합니다.

&ensp;UML에서는 Factory 클래스는 추상 클래스로 create 메서드를 갖고, createProduct와 registerProduct를 추상 메서드로 갖습니다. Product 클래스 역시 추상 클래스로, 하위 클래스에서 정의될 use 메서드를 추상 메서드로 갖고 있습니다.
&ensp;두 Factory 클래스와 Product 클래스를 IDCardFactory와 IDCard 클래스가 각각 상속하고 있습니다. 구체적인 createProduct와 registerProduct를 IDCardFactory에서 Override합니다. 마찬가지로, IDCard에서는 use메서드를 Override합니다.
&ensp;UML을 통해서, 클래스 생성과 사용의 처리 로직을 분리하여 결합도를 낮추고자 할 때, 이러한 패턴을 사용하는 것이 적합함을 알 수 있습니다. 또한, 이는 사용자에게 구성 요소를 확장하는 방법을 제공하기에 적합한 패턴임을 알 수 있습니다. 결국 Factory Method Pattern도 Open Closed Principle을 지키고 있음을 알 수 있습니다.
### Code
#### Factory.java
```java
package framework;

/**
 * 특정 Product를 생성하고자하는 Factory를 생성할 때, 부모 클래스로서 사용합니다.
 */
public abstract class Factory {
	/**
	 * Product의 생성 및 등록 과정을 통합하여 수행합니다.
	 * 
	 * @param owner Product의 주체 또는 소유자 정보입니다.
	 * @return 생성 및 등록된 Product p를 리턴합니다.
	 */
	public final Product create(String owner) {
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}
	
	/**
	 * Product를 생성합니다.
	 * 
	 * @return 새롭게 동적 할당하여 생성한 Product를 리턴합니다.
	 */
	protected abstract Product createProduct(String pname);
	
	/**
	 * Product를 등록합니다.
	 * Product에 따라서 서로 다른 등록 결과를 콘솔에 출력합니다.
	 */
	protected abstract void registerProduct(Product product);
}
```
#### Product.java
```java
package framework;

/**
 * Factory에서 만들고자 하는 새로운 Product를 생성할 때, 부모 클래스로서 사용합니다.
 */
public abstract class Product {
	/**
	 * Product의 사용 결과를 콘솔에 출력합니다.
	 */
	public abstract void use();
}
```
#### IDCardFactory.java
```java
package idcard;

import framework.*;

/**
 * Factory 클래스를 상속하여 만든, IDCard를 만드는 IDCardFactory 클래스입니다.
 */
public class IDCardFactory extends Factory {
	
	/**
	 * Factory에 정의된 추상 메소드 createProduct를 Override합니다.
	 * IDCard 인스턴스를 생성하여 리턴합니다.
	 * 
	 * @param owner IDCard의 owner입니다.
	 * @return owner을 parameter로하여 생성한 IDCard 인스턴스를 리턴합니다.
	 */
	@Override
	protected Product createProduct(String owner) {
		return new IDCard(owner);
	}
	
	/**
	 * Factory에 정의된 추상 메소드 registerProduct를 Override합니다.
	 * IDCard 정보와 IDCard 등록에 대한 정보를 콘솔창에 출력합니다.
	 * 
	 * @param product Product를 상속하는 IDCard
	 */
	@Override
	protected void registerProduct(Product product) {
		System.out.println(product + "을 등록했습니다.\n");
	}
}
```
#### IDCard.java
```java
package idcard;

import framework.Product;

/**
 * Product 클래스를 상속하여 만든, Factory에서 만들고자 하는 IDCard 클래스입니다.
 */
public class IDCard extends Product {
	
	/**
	 * IDCard의 owner값을 담을 변수입니다.
	 */
	private String owner;
	
	/**
	 * IDCard 생성자
	 * 
	 * @param owner IDCard의 소유자
	 */
	IDCard(String owner) {
		System.out.println(owner + "의 카드를 만듭니다.");
		this.owner = owner;
	}
	
	/**
	 * Product에 정의된 추상 메소드 use를 Override합니다.
	 * IDCard 사용에 대한 정보를 콘솔창에 출력합니다.
	 */
	@Override
	public void use() {
		System.out.println(this + "을 사용합니다.");
	}
	
	/**
	 * toString 메소드를 Overriding하여, IDCard에 대한 정보와 인스턴스의 owner를 하나의 string값으로 리턴합니다.
	 * 
	 * @return IDCard 인스턴스에 대한 정보와 인스턴스의 owner를 하나의 string값으로 리턴합니다.
	 */
	@Override
	public String toString() {
		return "[IDCard: "+ owner + "]";
	}
	
	/**
	 * IDCard의 owner를 리턴합니다.
	 * 
	 * @return 현재 IDCard의 owner를 리턴합니다.
	 */
	public String getOwner() {
		return this.owner;
	}
	
}
```
## 기존의 Factory Method Pattern 구조를 통해서 다른 실습 수행하기
### Factory Method Pattern UML
![Factory_after](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/4fbc3e7f-9626-4185-a4bb-7459eaaa3b60)
### 추가한 Code
#### FishBread.java
```java
package food;

import framework.*;

/**
 * Product 클래스를 상속하여 만든, Factory에서 만들고자 하는 FishBread 클래스입니다.
 */
public class FishBread extends Product{
	
	/**
	 * FishBread의 주재료에 대한 정보를 저장하는 변수입니다.
	 */
	private String ingredient;
	
	/**
	 * FishBread 생성자
	 * 
	 * @param ingredient FishBread의 주재료
	 */
	FishBread(String ingredient) {
		System.out.println(ingredient + "맛 붕어빵을 만듭니다.");
		this.ingredient = ingredient;
	}
	
	/**
	 * Product에 정의된 추상 메서드를 Override합니다.
	 * FishBread 사용에 대한 정보를 콘솔창에 출력합니다.
	 */
	@Override
	public void use() {
		System.out.println(this + "을 먹었습니다!!");
	}
	
	/**
	 * toString 메서드를 Overriding하여, FishBread에 대한 정보와 인스턴스의 ingredient를 하나의 string값으로 리턴합니다.
	 * 
	 * @return FishBread 인스턴스에 대한 정보와 인스턴스의 ingredient를 하나의 string값으로 리턴합니다.
	 */
	@Override
	public String toString() {
		return "["+ ingredient + " 붕어빵]";
	}
	
	/**
	 * FishBread의 ingredient를 리턴합니다.
	 * 
	 * @return 현재 FishBread의 ingredient를 리턴합니다.
	 */
	public String getIngredient() {
		return this.ingredient;
	}
}
```
#### FishBreadFactory.java
```java
package food;

import framework.*;

/**
 * Factory 클래스를 상속하여 만든, FishBread를 만드는 FishBreadFactory 클래스입니다.
 */
public class FishBreadFactory extends Factory{
	
	/**
	 * Factory에 정의된 추상 메소드 createProduct를 Override합니다.
	 * FishBread 인스턴스를 생성하여 리턴합니다.
	 * 
	 * @param ingredient FishBread의 ingredient
	 * @return ingredient을 parameter로하여 생성한 FishBread 인스턴스를 리턴합니다.
	 */
	@Override
	protected Product createProduct(String ingredient) {
		return new FishBread(ingredient);
	}
	
	/**
	 * Factory에 정의된 추상 메소드 registerProduct를 Override합니다.
	 * FishBread 정보와 FishBread 등록에 대한 정보를 콘솔창에 출력합니다.
	 * 
	 * @param product Product를 상속하는 FishBread
	 */
	@Override
	protected void registerProduct(Product product) {
		System.out.println(product + "굽는중...완성!\n");
	}
}
```
#### main.java
```java
import food.FishBreadFactory;
import framework.Factory;
import framework.Product;
import idcard.IDCardFactory;

/**
 * Main 클래스
 */
public class main {

	/**
	 * main 메소드로, 실제 Factory Method Pattern을 적용하여 작업을 수행하고 생성된 인스턴스를 사용합니다.
	 */
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product idcard1 = factory.create("Kangin Lee");
		Product idcard2 = factory.create("Heungmin Son");
		Product idcard3 = factory.create("MinJae Kim");
		idcard1.use();
		idcard2.use();
		idcard3.use();
		System.out.println("");
		
		Factory foodfactory = new FishBreadFactory();
		Product fishbread1 = foodfactory.create("팥");
		Product fishbread2 = foodfactory.create("슈크림");
		Product fishbread3 = foodfactory.create("반반");		
		fishbread1.use();
		fishbread2.use();
		fishbread3.use();
		
	}

}
```
#### 결과물
[IDCard Product에 대한 실행 결과]


![idcard](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/3daa33b8-8382-4dad-90c6-97af2cb99313)

[FishBread Product에 대한 실행 결과]


![fishbread](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/27cfa625-4aed-4130-8c92-5bad16dd89f7)

