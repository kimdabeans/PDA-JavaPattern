
# Java 디자인 패턴

디자인 패턴을 사용한 간단한 Java 예제

## 디자인 패턴

1. **전략 패턴 및 팩토리 패턴**:
    - 간단한 택시 예약 서비스를 구현합니다.
    - 전략 패턴을 사용하여 여러 운송회사 모듈을 정의하고,
    - 팩토리 패턴을 사용하여 운송회사 모듈을 선택합니다.
    - [Strategy 패턴](strategyPattern/strategy-pattern.md)
    - [Factory 패턴](factoryPattern/factory-pattern.md)

2. **프록시 패턴**:
    - 프록시 패턴을 사용하여 프로필 데이터를 선취 프록시를 통해 조회합니다.
    - 선취한 프로필 조회 시, 선취 프록시가 캐시된 데이터를 반환합니다.
    - [Proxy 패턴](proxyPattern/proxy-pattern.md)

3. **Command 패턴 및 Composite 패턴**:
    - 간단한 은행 계좌 시스템을 구현합니다.
    - Command 패턴을 사용하여 입금 및 출금 명령을 처리합니다.
    - Composite 패턴을 사용하여 여러 명령을 하나로 그룹화합니다.
    - [Command 패턴 (before)](commandPattern1/command-pattern.md)
    - [Command 패턴 (after)](commandPattern2/singleton-pattern.md)

## 사용법

각 예제에 대한 실행 방법을 아래에서 확인할 수 있습니다.

### 전략 패턴

1. `strategyPattern` Package 에서 예약 로직 코드를 확인합니다.
2. `Client.java`에서 간단한 택시 예약 시나리오를 실행합니다.

### 팩토리 패턴

1. `factoryPattern` Package 에서 전략 구현 클래스를 인스턴스화 하는 팩토리 코드를 확인합니다.
2. `Client.java`에서 간단한 택시 예약 시나리오를 실행합니다.

### 프록시 패턴

1. `ProfileService.java` 파일에서 프로필 조회 인터페이스를 확인합니다.
2. `AttendeeProfileService.java`에서 실제 프로필 조회 로직을 확인합니다.
3. `AttendeeProfileProxy.java`에서 데이터를 선취해서 응답성을 높이는 선취 프록시를 확인합니다.
4. `Client.java`에서 프록시 패턴을 적용한 프로필 조회를 실행합니다.

### Command 패턴 및 Composite 패턴

1. `BankAccount.java` 파일에서 은행 계좌 클래스를 확인합니다.
2. `Command.java`, `BankAccountCommand.java`, `CompositeCommand.java`에서 Command 및 Composite 패턴을 확인합니다.
3. `Main.java`에서 간단한 은행 계좌 시나리오를 실행합니다.

### Enum 을 이용한 리팩토링

Concrete Implementor로 DepositAction과 WithdrawAction 클래스를 구현하고,
해당 액션을 나타내는 열거형인 ActionType도 포함하고 있습니다.

1. `ActionType.java` 파일에서 입금 및 출금 명령을 나타내는 열거형을 확인합니다.
2. `BankAccountAction.java` 파일에서 명령을 실행하고 되돌리기 위한 메소드를 확인합니다.
3. `DepositAction.java`, `WithdrawAction.java` 파일에서 Singleton 패턴을 사용하여 유일한 인스턴스를 생성하도록 구현한 액션 클래스를 확인합니다.
4. `Main.java`에서 간단한 은행 계좌 시나리오를 실행합니다.

## API 문서
위치: docs/index.html

## Settings
#### JDK
Oracle OpenJDK version 20.0.1
