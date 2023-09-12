package observer;

/**
 * Investor 클래스는 주식 관찰자(Observer)의 구현입니다.
 */
public class Investor implements StockObserver {
    private String name;

    /**
     * 주식 관찰자(Investor) 객체를 생성합니다.
     *
     * @param name 투자자의 이름
     */
    public Investor(String name) {
        this.name = name;
    }

    /**
     * 주식 가격이 변경될 때 호출되는 메서드입니다.
     *
     * @param price 새로운 주식 가격
     */
    @Override
    public void update(double price) {
        System.out.println(name + "님, 주식 가격이 " + price + "로 변동했습니다.");
    }
}