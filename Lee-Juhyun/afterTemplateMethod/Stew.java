package afterTemplateMethod;

/**
 * 찌개를 만드는 추상 클래스입니다. 템플릿 메소드 패턴을 사용하여
 * 찌개 만들기의 미리 정의된 과정을 포함하고 있으며, 구체적인 재료를
 * 추가하는 메소드는 하위 클래스에서 구현되어야 합니다.
 */
public abstract class Stew {

    /**
     * 찌개 만들기의 템플릿 메소드입니다. 끓이는 과정은 고정되어 있고,
     * 구체적인 재료 추가 단계는 하위 클래스에서 구현됩니다.
     */
    public final void makeStew(){
        makeBroth();
        addOnions();
        addGreenOnions();
        addExtraIngredients();
    }

    /**
     * 육수를 만드는 메소드입니다.
     */
    private void makeBroth(){
        System.out.println("육수를 우린다.");
    }
    /**
     * 양파를 찌개에 추가하는 메소드입니다.
     */
    private void addOnions(){
        System.out.println("양파를 넣는다.");
    }
    /**
     * 파를 찌개에 추가하는 메소드입니다.
     */
    private void addGreenOnions(){
        System.out.println("파를 넣는다.");
    }

    /**
     * 구체적인 재료를 찌개에 추가하는 추상 메소드입니다.
     * 하위 클래스에서 이 메소드를 구현해야 합니다.
     */
    public abstract void addExtraIngredients();
}
