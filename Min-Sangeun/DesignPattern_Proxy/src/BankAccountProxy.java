/**
 * 은행 계좌의 프록시 클래스
 * 인증을 통해 계좌 생성 및 접근 관리 
 */
class BankAccountProxy implements BankAccount {
    private RealBankAccount realBankAccount;
    private String password;
    private boolean accountCreated = false;
    private static final String AUTH_PASSWORD = "password123";

    /**
     * BankAccountProxy 생성자.
     *
     * @param password 계좌 접근 및 생성에 필요한 비밀번호.
     */
    public BankAccountProxy(String password) {
        this.password = password;
    }

    /**
     * 새로운 계좌를 생성 
     * 인증이 필요하며, 이미 계좌가 생성된 상태에서는 생성되지 않는다.
     */
    public void createAccount() {
        if (authenticate()) {
            if (realBankAccount == null) {
                realBankAccount = new RealBankAccount();
                accountCreated = true;
                System.out.println("계좌가 생성되었습니다.");
            } else {
                System.out.println("계좌가 이미 있습니다.");
            }
        } else {
            System.out.println("인증에 실패했습니다. 계좌가 생성되지 않았습니다.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (accountCreated && authenticate()) {
            realBankAccount.deposit(amount);
        }
    }

    @Override
    public double getBalance() {
        if (accountCreated && authenticate()) {
            return realBankAccount.getBalance();
        }
        System.out.println("접근이 거부되었습니다. 인증 상태나 계좌 생성 상태를 확인하세요.");
        return -1;
    }

    @Override
    public void withdraw(double amount) {
        if (accountCreated && authenticate()) {
            realBankAccount.withdraw(amount);
        }
    }

    /**
     * 사용자 비밀번호와 저장된 비밀번호를 비교하여 인증
     * 
     * @return 비밀번호가 일치하면 true, 그렇지 않으면 false.
     */
    private boolean authenticate() {
        return password.equals(AUTH_PASSWORD);
    }
}
