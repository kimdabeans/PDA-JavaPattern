package afterTemplateMethod;

/**
 * 김치찌개를 만드는 클래스입니다. 템플릿 메소드 패턴을 사용하여 미리 정의된
 * 끓이는 과정을 가지고 있으며, 김치를 추가하는 구체적인 단계를 구현합니다.
 */
public class KimchiStew extends Stew{
    /**
     * 김치를 찌개에 추가하는 메소드입니다.
     * KimchiStew 클래스만이 가진 기능을 유연하게 적용할 수 있습니다.
     */
    @Override
    public void addExtraIngredients(){
        System.out.println("김치를 넣는다.");
    }
}
