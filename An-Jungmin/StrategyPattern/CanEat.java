package StrategyPattern;
/**
 * 먹는 행동을 구현하는 클래스로, 먹을 수 있는 고양이의 동작을 나타냅니다.
 */
public class CanEat implements EatBehavior {

    /**
     * 고양이가 먹을 때 실행되는 메서드입니다.
     */
    @Override
    public void eat() {
        System.out.println("냠냠");
    }
}
