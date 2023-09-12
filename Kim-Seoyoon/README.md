# PDA_JAVA_PATTERN
# Factory Method Pattern
## Factory Method Pattern
팩토리 메소드 패턴은 부모 클래스에 알려지지 않은 구체 클래스를 생성하는 패턴으로, 자식 클래스에서 어떤 객체를 생성할지 결정하도록하는 생성패턴이다.
객체 생성 코드를 하나의 공간에서 생성하므로 코드의 유지 보수가 쉬워 단일 책임 원칙을 만족하고 기존의 클라이언트 코드를 건드리지 않고 새로운 타입의 객체를 생성할 수 있어 개방/폐쇄 원칙을 만족한다는 장점이 있다.
패턴을 구현하기 위해 많은 서브 클래스를 만들어 구현해야 하므로 코드의 복잡성이 증가한다는 단점이 있다.

## Factory Method Pattern 선정 이유
스프링의 Dependency Injection 컨테이너에서 위의 패턴을 사용하기 때문에 스프링 컨테이너는 다양한 형식의 설정 정보를 받아들일 수 있다.
앞으로 하게 될 프로젝트에서 Spring을 사용하는 만큼 위 패턴의 작동 방식을 이해하고 활용하는 것이 중요하다고 생각하여 위의 패턴을 선정하게 되었다.

## Description
다양한 종류와 가격을 가지고 있는 인형 객체를 생성하는 코드다.
Doll클래스를 상속받아 구체적인 인형 클래스의 종류와 가격을 가진 인스턴스를 생성한다.
DollFactory를 통해 팩토리 메소드를 정의하고 인터페이스를 상속받은 인형 팩토리 클래스들은 각각의 인형 객체를 생성한다.
![Factory_Method_UML](https://github.com/Seoyun0626/PDA_JAVA_PATTERN/assets/104416283/2a2ebafe-b047-4318-a2f8-222f759d332c)


## Files
`Doll.java` 추상클래스로 모든 인형 클래스의 기본 틀 정의

`MickeyDoll.java, PoohDoll.java, RyanDoll.java` Doll 추상클래스를 상속받아 인형의 종류와 가격을 설정하는 초기화 작업 수행

`DollType.java` Doll 클래스의 type 멤버 변수에 대한 열거형 클래스로 객체의 유형을 정의하기 위해 사용

`DollFactory.java` create메소드를 구현하여 구체적인 인형 객체를 생성하도록 하는 인터페이스

`MickeyDollFactory.java, PoohDollFactory.java, RyanDollFactory.java` create메소드를 오버라이드하여 인형 객체를 생성하고 반환하는 팩토리 메소드 패턴 구현

`Main.java` 팩토리 메소드 패턴을 활용하는 클라이언트 코드로 print 메소드를 호출하여 각 인형의 정보 출력

## Usage
`Main.java`

# Strategy Pattern
## Strategy Pattern
객체들이 할 수 있는 행위에 대해 클래스를 생성하고, 유사한 행위들을 캡슐화 하는 인터페이스를 정의하여, 객체의 행위를 동적으로 바꾸고 싶을 때 직접 행위를 수정하지 않고 전략을 바꿔주기만 함으로써 행위를 유연하게 확장하는 패턴이다.
알고리즘을 캡슐화하여 코드 재사용성이 높고 알고리즘을 쉽게 변경 및 대체할 수 있다는 유연함이 있다.
추가적인 클래스 및 인터페이스가 필요하기 때문에 코드 복잡성이 증가될 수 있다.

## Strategy Pattern 선정 이유
Strategy 패턴의 장점인 유연성과 확장성, 유지 보수성, 코드 재사용은 객체 지향 디자인 원칙 준수를 위한 도구로 사용되기 때문에 이 패턴에 대한 완벽한 숙지가 중요하다고 생각하여 이 패턴을 선정하게 되었다.

## Description
Strategy 패턴을 사용하여 MARIOKART 게임 캐릭터와 그들의 행동을 구현하는 코드이다.
BananaItem, MushroomItem 인터페이스는 각각 바나나 아이템과 버섯 아이템을 정의하고 하위 클래스에서 어떠한 기능을 가지고 있는지 구체화 한다.
MARIOKART 클래스는 각각 캐릭터의 행동을 수행하고 setBananaItem, setMushroomIte 메소드를 통해 아이템을 동적으로 변경할 수 있도록 한다.
![Strategy_Pattern_UML](https://github.com/Seoyun0626/PDA_JAVA_PATTERN/assets/104416283/2a137fd2-515d-433a-89be-b0f57b740632)

## Files
`Doll.java` 추상클래스로 모든 인형 클래스의 기본 틀 정의

`BananaItem.java,MushroomItem.java` 바나나 아이템, 버섯 아이템을 정의하는 인터페이스

`LongSlide.java ShortSlide.java, LongSpeed.java, ShortSpeed.java` BananaItem, MushroomItem 인터페이스를 구현하여 행동 구체화

`MARIOKART.java` 캐릭터의 행동수행 메소드와 어떤 아이템을 가진 생성자를 생성할지 결정

`Mario.java, Luigi.java, DonkeyKong.java` MARIOKART를 상속받아 특정 캐릭터 구현

`Main.java` Strategy 패턴을 활용하여 캐릭터의 행동을 동적으로 변경

## Usage
`Main.java`

# Singleton Pattern
## Singleton Pattern
인스턴스를 불필요하게 생성하지 않고 오직 한 개의 인스턴스만 생성하여 재사용을 위해 사용되는 디자인 패턴
static을 사용하여 별도의 메모리 영역을 얻으면서 한번의 new 연산자를 통해 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있다.
멀티스레드 환경에서 객체가 1개 이상 생성되는 오류 발생 여지가 있다.

## Singleton Pattern 선정 이유
멀티스레드 환경에서 생기는 오류들을 방지하기 위해 하나의 Singleton 패턴에서 여러가지 유형의 Singleton 패턴이 있는 것을 알게 된 후 다양한 유형의 Singleton 패턴을 숙지하면 적절한 상황에서 효율적으로 패턴을 사용할 수 있을 것 같아 위의 패턴을 선정하였다.

## Description
Singleton 패턴을 사용하여 여러개의 객체 생성을 제한하고, 프로그램 내에서 하나의 고유한 인스턴스만을 공유하기 위한 코드이다.
여러가지 유형의 Singleton 패턴 중 Lazyholder Singleton 패턴 기법을 사용하여 멀티스레드 환경에서 Thread-safe와 성능향상을 제공한다.

![Singleton_Pattern_UML](https://github.com/Seoyun0626/PDA_JAVA_PATTERN/assets/104416283/505c7a84-0da2-44c1-b868-5a6661360428)


## Files
`Singleton.java` 하나의 인스턴스만 생성하는 Singleton 패턴 파일

`Main.java` 한 개의 인스턴스만 생성된 것을 확인하는 파일

## Usage
`Main.java`
