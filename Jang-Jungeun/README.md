## 1. Adapter Pattern

|  | 적용 전 | 적용 후 |
| :-------: | :-------: | :-------: |
||<img src="https://github.com/jang294/PDA-JavaPattern/assets/98522102/f85d9d10-6fcd-4eb8-a282-9b51abb50ade" width = "400">|<img src="https://github.com/jang294/PDA-JavaPattern/assets/98522102/f85d9d10-6fcd-4eb8-a282-9b51abb50ade" width = "400">|
| 코드 중복 및 재사용  | 원화를 다른 통화로 변환하는 메서드인 convertToDollar, convertToEuro, convertToYen 이 중복된다. | Client 클래스에 있는 원화를 통화로 변환하는 메서드를 재사용할 수 있습니다. 변환 로직을 중복 작성할 필요가 없다.  |
| 확장성 | 새로운 통화가 추가되거나 환율이 변경될 때, 모든 변환 메서드를 수정해야 하기 때문에 유지보수가 어려워진다. | 새로운 통화를 추가하거나 환율을 변경할 때, Client 클래스에 이미 있는 변환 메서드를 재사용하고, Adapter 클래스의 생성자만 수정하면 되기 때문에 다른 코드를 변경하지 않아도 된다. |
| 유연성 | 새로운 변환 방법을 추가하거나 환율 데이터를 동적으로 변경하기 어렵다. | 새로운 변환 방법을 추가하거나 환율 데이터를 동적으로 변경하기 쉽다. |

## 2. Factory Method Pattern

## 3. Observer Pattern
