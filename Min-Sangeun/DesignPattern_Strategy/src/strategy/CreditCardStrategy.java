package strategy;

/**
 * 신용 카드를 이용한 결제 전략을 구현한 클래스
 */
public class CreditCardStrategy implements PaymentStrategy {

    private String cardNumber;      // 카드 번호를 저장하는 변수
    private String cvv;             // 카드의 CVV(검증 코드)를 저장하는 변수
    private String dateOfExpiry;    // 카드의 만료일자를 저장하는 변수

    /**
     * 신용 카드 정보를 초기화하기 위한 생성자
     *
     * @param cardNumber    초기화할 카드 번호
     * @param cvv           초기화할 카드의 CVV(검증 코드)
     * @param dateOfExpiry  초기화할 카드의 만료 일자
     */
    public CreditCardStrategy(String cardNumber, String cvv, String dateOfExpiry) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    /**
     * 결제를 진행하는 메서드
     * 결제 금액과 화폐 단위를 받아서 신용 카드로 결제되었다는 메시지 출력
     * 
     * @param amount        결제할 금액
     * @param currencyUnit  화폐 단위 (예: 원, 달러 등)
     */
    @Override
    public void pay(int amount, String currencyUnit) {
        System.out.println(amount + " " + currencyUnit + "을 신용 카드로 결제하였습니다.");
    }
}

