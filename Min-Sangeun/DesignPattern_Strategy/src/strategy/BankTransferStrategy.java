package strategy;

/**
 * 무통장 입금을 위한 결제 전략을 구현한 클래스
 */
public class BankTransferStrategy implements PaymentStrategy {

    private String bankName;       // 은행의 이름을 저장하는 변수
    private String accountNumber;  // 계좌 번호를 저장하는 변수

    /**
     * 무통장 입금 계좌 정보를 초기화하기 위한 생성자
     *
     * @param bankName       초기화할 은행의 이름
     * @param accountNumber  초기화할 계좌 번호
     */
    public BankTransferStrategy(String bankName, String accountNumber) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    /**
     * 결제를 진행하는 메서드 
     * 결제 금액과 화폐 단위를 받아서 해당 계좌로 입금되었다는 메시지를 출력
     * 
     * @param amount        결제할 금액
     * @param currencyUnit  화폐 단위 (예: 원, 달러 등)
     */
    @Override
    public void pay(int amount, String currencyUnit) {
        System.out.println(amount + " " + currencyUnit + " 을 " + accountNumber + "로 입금하였습니다.");
    }
}
