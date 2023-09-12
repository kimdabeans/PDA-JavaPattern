## strategy 패턴

![전략](https://github.com/JZU0/Java-design-patterns/assets/97423172/345a870f-9e5e-411b-b08a-cb3f7ef70e8f)

strategy 패턴은 **같은 기능이지만 서로 다른 전략**을 가진 클래스들을 각각 캡슐화하여 상호교환할 수 있도록 하는 패턴이다.


##### 즉, 어떤 일을 수행하는 알고리즘이 다수일 때, 동작들을 미리 전략으로 정의함으로써 손쉽게 전략을 교체할 수 있는 **알고리즘 변형이 빈번하게 필요한 경우**에 적합한 패턴이다.

#### 전략 패턴은 OOP의 집합체라고 할 수 있다.
###### 전략 패턴은 우리가 지금까지 자바 언어를 공부하면서 배운 여러 객체 지향 문법 기법들인, SOLID 원칙의 OCP 원칙Visit Website, DIP 원칙과 합성(compositoin), 다형성(polymorphism), 캡슐화(encapsulation) 등 OOP 기술들의 총 집합 버전이라고 보면 된다.


#### strategy 패턴을 사용하면 좋은 시기는 다음과 같다.
- 전략 알고리즘의 여러 버전 또는 변형이 필요할 때 클래스화를 통해 관리
- 알고리즘 코드가 노출되어서는 안 되는 데이터에 액세스 하거나 데이터를 활용할 때
- 알고리즘의 동작이 런타임에 실시간으로 교체 되어야 할때


#### 전략 패턴은 아래와 같은 주의점이 있다.
1. 알고리즘이 많아질수록 관리해야할 객체의 수가 늘어난다는 단점이 있다.
2. 만일 어플리케이션 특성이 알고리즘이 많지 않고 자주 변경되지 않는다면, 새로운 클래스와 인터페이스를 만들어 프로그램을 복잡하게 만들 이유가 없다.
3. 개발자는 적절한 전략을 선택하기 위해 전략 간의 차이점을 파악하고 있어야 한다.

---


### 예제를 통해 살펴보자.

학생이 계산기를 사용한다고 가정해보자.

크게 덧셈과 뺄셈을 진행하는 계산기라고 할 때, 필요한 때에 연산을 바꿔서 진행할 수 있다.

###### ICalculator interface
```
public interface ICalculator {
    public  abstract double execute(double n1, double n2);
}
```
###### PlusCalculator class
```
public class PlusCalculator implements ICalculator {
    @Override
    public double execute(double n1, double n2) {
        return n1+n2;
    }
}
```
###### MinusCalculator class
```
public class MinusCalculator implements ICalculator {
    @Override
    public double execute(double n1, double n2) {
        return n1-n2;
    }
}
```
PlusCalculator와 MinusCalculator는 ICalculator를 상속받아 각자의 기능을 구현한다.

###### Student class
```
public class Student {
    private ICalculator ICalculator;
    private double n1;
    private double n2;

    public double operate(){
        return ICalculator.execute(n1,n2);
    }

    public void setCalculator(ICalculator ICalculator){
        this.ICalculator = ICalculator;
    }

    public void changeNumber(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
```
setCalculator 메소드를 통해 원하는 연산으로 교체할 수 있다.

###### Main class
```
public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        
        student.changeNumber(9,12);
        
        student.setCalculator(new PlusCalculator());
        double result1 = student.operate();
        System.out.println(result1);
        
        student.setCalculator(new MinusCalculator());
        double result2 = student.operate();
        System.out.println(result2);
    }
}
```
###### 실행결과
![result](https://github.com/JZU0/Java-design-patterns/assets/97423172/2a7bb3f6-b583-4338-bf3f-d2c653b778bc)

---

### 코드의 전체적인 구조를 알기 위해 UML 클래스 다이어그램을 살펴보자.

|<b>TemplateMethod UML</b> |
| :--: |
| ![TemplateMethodUML](https://github.com/JZU0/Java-design-patterns/assets/97423172/ad0e7f2b-af0e-450b-948e-f7222b8a1119)|


#### ICalculator 인터페이스에는 연산을 위한 추상 메소드가 정의되어있다.
#### PlusCalculator 클래스 안에는 ICalculator 인터페이스를 구현하는 클래스 중 하나이다. 인터페이스를 구현한다는 것은 execute 메소드를 구현하는 것이다.
#### MinusCalculator 클래스 또한 ICalculator 인터페이스의 execute 메소드를 구현한다.
#### Student는 계산하는 학생을 표현한 클래스이다. setCalculator 메소드로 계산기의 연산을 변화시킨다.
#### 연산을 미리 정의해두면서, 연산 교체가 쉽게 가능하다는 것을 알 수 있다. 

---

#### Strategy 패턴을 사용하는 예제
##### JAVA
- Collections의 sort() 메서드에 의해 구현되는 compare() 메서드에 이용
- javax.servlet.http.HttpServlet에서 service() 메서드와 모든 doXXX() 메서드에 이용
- javax.servlet.Filter의 doFilter() 메서드에 이용

##### JAVA뿐만 아니라 Node.js의 passport.js 라이브러리가 전략 패턴으로 구성 되어있다. 






 
