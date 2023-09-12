package templateMethod.after;

/**
 * Hamburger 클래스는 햄버거를 만들기 위한 템플릿 메소드 패턴을 구현한 추상 클래스입니다.
 * 템플릿 메소드 패턴을 활용하여 햄버거 제작 프로세스를 정의하며,
 * 이 클래스를 상속하는 구체적인 햄버거 종류 클래스가 구체적인 구현을 제공합니다.
 */
public abstract class Hamburger {
    /**
     * 햄버거를 만들기 위한 알고리즘을 가진 템플릿 메소드입니다.
     * 각각의 단계는 구체적인 구현 클래스에서 제공됩니다.
     */
    public final void cook() {
        cookPatty();
        cutBread();
        addToppings();
        if (customerWantsPackaging()) {
            packaging();
        }
    }

    /**
     * 고기 패티를 만들기 위한 추상 메소드입니다.
     * 구체적인 구현 클래스에서 해당 메소드를 구현해야 합니다.
     */
    public abstract void cookPatty();

    /**
     * 햄버거를 포장하기 위한 추상 메소드입니다.
     * 구체적인 구현 클래스에서 해당 메소드를 구현해야 합니다.
     */
    public abstract void packaging();

    /**
     * 빵을 자르는 메소드입니다.
     * 템플릿 메소드 내에서 공통적으로 사용됩니다.
     */
    public final void cutBread() {
        System.out.println("빵 자르기");
    }

    /**
     * 토핑을 추가하는 메소드입니다.
     * 템플릿 메소드 내에서 공통적으로 사용됩니다.
     */

    public final void addToppings() {
        System.out.println("토핑 추가하기");
    }

    /**
     * 포장 여부를 결정하는 "hook" 메소드입니다.
     * 구체적인 구현 클래스에서 필요에 따라 오버라이드할 수 있습니다.
     * 기본적으로는 포장을 하도록 구현되어 있습니다.
     *
     * @return 포장을 할지 여부를 나타내는 불리언 값
     */
    boolean customerWantsPackaging() {
        return true;
    }
}