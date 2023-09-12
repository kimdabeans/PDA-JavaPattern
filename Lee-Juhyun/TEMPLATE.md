## TemplateMethod 패턴

![템플릿](https://github.com/JZU0/Java-design-patterns/assets/97423172/05fc2f5b-da03-4c0c-a7da-a19b537e4e9d)

TemplateMethod 패턴은 어떤 작업을 처리하는 일부분을 **서브 클래스로 캡슐화**해 전체 일을 수행하는 구조는 바꾸지 않으면서 특정 단계에서 수행하는 내역을 바꾸는 패턴이다.


즉, 전체적으로는 동일하면서 부분적으로는 다른 구문으로 구성된 메서드의 **코드 중복을 최소화** 할 때 유용하다.
다른 관점에서 보면 동일한 기능을 상위 클래스에서 정의하면서 **확장/변화가 필요한 부분만 서브 클래스에서 구현**할 수 있도록 한다.


##### 즉, 변하지 않는 기능(템플릿)은 상위 클래스에 만들어두고 자주 변경되며 확장할 기능은 하위 클래스에서 만들도록 하여, 상위의 메소드 실행 동작 순서는 고정하면서 세부 실행 내용은 다양화 될 수 있는 경우에 사용된다.


#### 템플릿 메소드 패턴을 사용하면 좋은 시기는 다음과 같다.
- 클라이언트가 알고리즘의 특정 단계만 확장하고, 전체 알고리즘이나 해당 구조는 확장하지 않도록 할 때
- 동일한 기능은 상위 클래스에서 정의하면서 확장, 변화가 필요한 부분만 하위 클래스에서 구현할 때  


#### 패턴의 장점
- 클라이언트가 대규모 알고리즘의 특정 부분만 재정의하도록 하여, 알고리즘의 다른 부분에 발생하는 변경 사항의 영향을 덜 받도록 한다.
- 상위 추상클래스로 로직을 공통화 하여 코드의 중복을 줄일 수 있다.
- 서브 클래스의 역할을 줄이고, 핵심 로직을 상위 클래스에서 관리하므로서 관리가 용이해진다


#### 패턴의 단점
- 알고리즘의 제공된 골격에 의해 유연성이 제한될 수 있다.
- 알고리즘 구조가 복잡할수록 템플릿 로직 형태를 유지하기 어려워진다.
- 추상 메소드가 많아지면서 클래스의 생성, 관리가 어려워질 수 있다.
- 상위 클래스에서 선언된 추상 메소드를 하위 클래스에서 구현할 때, 그 메소드가 어느 타이밍에서 호출되는지 클래스 로직을 이해해야 할 필요가 있다.
- 로직에 변화가 생겨 상위 클래스를 수정할 때, 모든 서브 클래스의 수정이 필요 할수도 있다.

---


### 예제를 통해 살펴보자.

찌개를 끓인다고 가정해보자.

된장찌개와, 김치찌개를 끓일 때 공통적으로 해야하는 단계도 있고 다른 재료를 넣어야하는 단계도 있을 것이다.


#### 먼저 TemplateMethod 패턴을 적용하지 않았을 때 : [전체 코드](beforeTemplateMethod) 
##### 만드는 법을 비교해보자.
|된장찌개|김치찌개|
|:---:|:---:|
|육수를 우린다|육수를 우린다|
|양파를 넣는다|양파를 넣는다|
|파를 넣는다|파를 넣는다|
|된장을 푼다|김치를 넣는다|

#### 간단하게 봤을 때도 중복되는 단계가 많다는 것을 알 수 있다.

##### 하나의 공통된 것을 두고, 상속을 통해 자식 클래스에서 다른 부분을 추가하면 코드 중복을 최소화 할 수 있을 것이라 판단된다.

*이때 TemplateMethod 패턴을 사용한다.*

#### TemplateMethod 패턴을 적용했을 때 : [전체 코드](afterTemplateMethod) 
##### 만드는 법을 비교해보자.
|                   공통된 단계                    |
|:-------------------------------------------:|
| 1.육수를 우린다<br/>2. 양파를 넣는다<br/>3.파를 넣는다.<br/> | 

|                    된장찌개                     |김치찌개|
|                    :---:                    |:---:|
|                   된장을 푼다                    |김치를 넣는다|


##### 공통된 단계를 하나로 묶고, 다른 부분을 구체화하여 중복을 최소한 것을 볼 수 있다.


---

### 코드의 전체적인 구조를 알기 위해 UML 클래스 다이어그램을 살펴보자.

|<b>TemplateMethod UML</b> |
| :--: |
| ![TemplateMethodUML](https://github.com/JZU0/Java-design-patterns/assets/97423172/869457ca-b6a6-4501-8956-9b111b36115b)|

#### Stew 클래스 안에는 makeStew 메소드가 정의되어 있고 makeStew 메소드 안에서 makeBroth, addOnions, addGreenOnions라는 세 개의 메소드와 addExtraIngredients 메소드가 사용된다.
#### 앞의 세개의 메소드는 공통된 부분을 정의한 부분이므로 private 메소드로 변경하지 않도록 구현했다. 
#### addExtraIngredients 메소드는 추상 메소드이고, 이 메소드를 실제로 구현하는 것은 Stew의 하위 클래스인 SoybeanPasteStew와 KimchiStew이다. 
#### 상위 추상클래스로 로직을 공통화 하여 코드의 중복을 줄인 것을 확인할 수 있다.


---

### 추가적으로 Template Method 실제 사용되는 예시를 보자..!

#### JAVA
- java.io.InputStream, java.io.OutputStream, java.io.Reader, java.io.Writer 의 일반 메서드를 하위 클래스가 재정의 한다.
- java.util.AbstractList, java.util.AbstractSet, java.util.AbstractMap 의 일반 메서드를 하위 클래스가 재정의 한다.
- javax.servlet.http.HttpServlet의 모든 doXXX()메서드는 기본적으로 응답에 HTTP 405 "Method Not Allowed" 리턴 코드를 보내기 때문에 이들을 상속하여 재정의 하여 사용한다.

#### AbstractMap

AbstractMap<K,V> 클래스에 정의 되어있는 get() 메서드를 이를 상속하는 HashMap, TreeMap 등 서브클래스에서 오버라이드하여 자신만의 구현 방법으로 다른 방식으로 재정의 하고 있는 것을 볼 수 있다. 꼭 추상 메소드를 재정의 해야되는게 아니라 일반 메소드도 템플릿에 고정되어 실행되는 것이라면 오버라이딩하여 재정의 하면 곧 알고리즘 변화가 되기 때문이다.

###### AbstractMap<K,V> 의 get() 메소드
```
public V get(Object key) {
    Iterator<Entry<K,V>> i = entrySet().iterator();
    if (key==null) {
        while (i.hasNext()) {
            Entry<K,V> e = i.next();
            if (e.getKey()==null)
                return e.getValue();
        }
    } else {
        while (i.hasNext()) {
            Entry<K,V> e = i.next();
            if (key.equals(e.getKey()))
                return e.getValue();
        }
    }
    return null;
}
```

###### HashMap<K,V> extends AbstractMap<K,V> 의 get() 메소드
```
public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(hash(key), key)) == null ? null : e.value;
}
```

###### TreeMap<K,V> extends AbstractMap<K,V> 의 get() 메소드
```
public V get(Object key) {
    Entry<K,V> p = getEntry(key);
    return (p==null ? null : p.value);
}
```

---

### Strategy Pattern VS Template Method

#### 비슷한 점
전략 패턴과 템플릿 메소드 패턴은 **알고리즘을 때에 따라 적용한다는 점**에서 공통점을 가지고 있다. 전략 및 템플릿 메소드 패턴은 [OCP](#ocp)을 충족하고 코드를 변경하지 않고 소프트웨어 모듈을 쉽게 확장할 수 있게 한다.

#### 다른 점
전략 패턴은 **합성**을 통해 해결책을 구하고, 템플릿 메소드 패터는 **상속**을 통해 해결책을 제시한다. 그래서 전략 패턴은 클라이언트와 객체 간의 결합이 느슨한 반면, 템플릿 메소드 패턴에서는 두 모듈의 결합도가 더 높다.
전략 패턴에서는 대부분 인터페이스를 사용하지만 템플릿 메소드 패턴에서는 주로 추상 클래스나 구체적인 클래스를 사용한다.
 
---

#### OCP
+ 개방 폐쇄 원칙 - OCP (Open Closed Principle)
> 개방 폐쇄의 원칙(OCP)이란 기존의 코드를 변경하지 않으면서, 기능을 추가할 수 있도록 설계가 되어야 한다는 원칙을 말한다. 보통 OCP를 확장에 대해서는 개방적(open)이고, 수정에 대해서는 폐쇄적(closed)이어야 한다는 의미로 정의한다.


 
