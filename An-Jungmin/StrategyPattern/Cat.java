package StrategyPattern;


public abstract class Cat {

    /**
     * 고양이의 먹는 행동을 나타내는 EatBehavior 객체입니다.
     */
    public EatBehavior eatBehavior;

    /**
     * Cat 클래스의 기본 생성자입니다.
     */
    public Cat() {
    }

    /**
     * 고양이의 외모를 나타내는 추상 메서드입니다.
     */
    public abstract void display();

    /**
     * 고양이가 먹는 행동을 수행하는 메서드입니다.
     */
    public void performEat() {
        eatBehavior.eat();
    }

    /**
     * 고양이의 울음 소리를 나타내는 메서드입니다.
     * 모든 고양이는 "야옹~"이라고 울음 소니다.
     */
    public void meow() {
        System.out.println("모든 고양이는 야옹~");
    }

    public void setEatBehavior(EatBehavior eat) {
        eatBehavior = eat;
    }
}
