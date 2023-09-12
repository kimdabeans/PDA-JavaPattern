package java0825_builder2;

/**
 * `Director` 클래스는 Builder 패턴을 사용하여 텍스트 형식의 문서를 생성하는 역할을 수행합니다.
 * 이 클래스는 특정 Builder 인스턴스를 받아서 해당 빌더를 사용하여 문서를 생성합니다.
 * 문서 생성 과정을 구체화하고, 필요한 메서드를 호출하여 문서를 만들고 반환합니다.
 *
 * @author Cho Hayoung
 */
public class Director {
    
    private Builder btype;

    /**
     * `Director` 클래스의 생성자입니다. 특정 Builder 인스턴스를 받아서 초기화합니다.
     *
     * @param btype Builder 인스턴스
     */
    Director(Builder btype) {
        this.btype = btype;
    }
    
    /**
     * 문서 생성 과정을 구체화하는 메서드입니다. 각 항목을 Builder에 추가하고 문서를 완성합니다.
     */
    public void construct() {
        btype.strTitle("coffeeRecipe");
        btype.strAdd("americano");
        btype.makeItems(new String[] {
            "water 40 &",
            " espresso 4",
            "and bon appétit!"
        });
        btype.strAdd("latte");
        btype.makeItems(new String[] {
            "milk 40 &",
            " espresso 4",
            "and bon appétit!"
        });
        btype.strClose();
    }

    /**
     * 제목과 내용을 사용하여 텍스트 문서를 생성하고 해당 문서를 문자열 형태로 반환합니다.
     *
     * @param title    문서의 제목
     * @param coffee   문서의 내용
     * @return 생성된 텍스트 문서를 문자열 형태로 반환합니다.
     */
    public String makeStr(String title, coffeeRecipe coffee) {
        this.btype.strTitle(title);
        this.btype.strAdd(coffee.toString());
        this.btype.strClose();
        return btype.getStringFormat();
    }
}
