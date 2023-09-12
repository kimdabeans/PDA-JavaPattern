package strategy;

/**
 * 페이팔을 이용한 결제 전략을 구현한 클래스
 */
public class PaypalStrategy implements PaymentStrategy {

    private String email;      // 사용자의 페이팔 이메일 주소를 저장하는 변수
    private String password;   // 페이팔 로그인 비밀번호를 저장하는 변수

    /**
     * 페이팔 로그인 정보를 초기화하기 위한 생성자
     *
     * @param email  초기화할 페이팔 이메일 주소
     * @param pwd    초기화할 페이팔 비밀번호
     */
    public PaypalStrategy(String email, String pwd) {
        this.email = email;
        this.password = pwd;
    }

    /**
     * 결제를 진행하는 메서드
     * 결제 금액과 화폐 단위를 받아서 페이팔로 결제가 완료되었다는 메시지 출력
     * 
     * @param amount        결제할 금액
     * @param currencyUnit  화폐 단위 (예: 원, 달러 등)
     */
    @Override
    public void pay(int amount, String currencyUnit) {
        System.out.println(amount + " " + currencyUnit + "을(를) 페이팔로 결제하였습니다.");
    }
}

