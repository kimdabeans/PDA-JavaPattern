package StrategyPattern;
/**
 * 길고양이를 나타내는 클래스로, 먹는 행동을 설정할 수 있습니다.
 */
public class StrayCat extends Cat {

    /**
     * 길고양이의 생성자입니다.
     * 기본적으로 먹을 수 있는 행동(`CanEat`)으로 설정됩니다.
     */
    public StrayCat() {
        eatBehavior = new CanEat(); // 먹을 수 있게 설정.
    }

    /**
     * 길고양이를 나타냅니다.
     */
    @Override
    public void display() {
        System.out.println("나는 길냥이다");
    }
}