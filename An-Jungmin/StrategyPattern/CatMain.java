package StrategyPattern;

/**
 * 전략 패턴(Strategy Pattern)을 사용하여 고양이의 먹는 행동을 테스트하는 클래스입니다.
 */
public class CatMain {

    public static void main(String[] args) {
        // 먹을 수 있는 고양이 생성
        Cat strayCat = new StrayCat();
        strayCat.performEat(); // "냠냠" 출력

        // 먹을 수 없는 고양이로 먹는 행동 변경
        strayCat.setEatBehavior(new CannotEat());
        strayCat.performEat(); // "나는 못먹어..." 출력
    }
}