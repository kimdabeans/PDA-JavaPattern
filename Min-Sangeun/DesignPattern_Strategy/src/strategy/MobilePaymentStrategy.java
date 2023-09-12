package strategy;

/**
 * 모바일 결제 방식을 위한 결제 전략을 구현한 클래스
 */
public class MobilePaymentStrategy implements PaymentStrategy {

    private String mobileNumber;   // 사용자의 핸드폰 번호를 저장하는 변수
    private String password;      // 모바일 결제 비밀번호를 저장하는 변수

    /**
     * 모바일 결제 정보를 초기화하기 위한 생성자
     *
     * @param mobileNumber   초기화할 핸드폰 번호
     * @param password       초기화할 결제 비밀번호
     */
    public MobilePaymentStrategy(String mobileNumber, String password) {
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    /**
     * 결제를 진행하는 메서드 
     * 결제 금액과 화폐 단위를 받아서 해당 핸드폰 번호로 모바일 결제가 완료되었다는 메시지 출력
     * 
     * @param amount        결제할 금액
     * @param currencyUnit  화폐 단위 (예: 원, 달러 등)
     */
    @Override
    public void pay(int amount, String currencyUnit) {
        System.out.println(amount + " " + currencyUnit + " 을 " + mobileNumber + "번호로 모바일 결제하였습니다.");
    }
}

