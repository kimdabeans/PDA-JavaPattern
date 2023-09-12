package java0825_builder2;

/**
 * `Builder` 추상 클래스는 다양한 형식의 텍스트 문서를 생성하기 위한 메서드를 정의합니다.
 * 구체적인 형식의 문서 생성을 위해서는 이 클래스를 상속하고 필요한 메서드를 구현해야 합니다.
 *
 * @author Cho Hayoung
 */
public abstract class Builder {
    // 처리해야 할 데이터 객체를 field 로 받습니다.
    // 자식 클래스에서 해당 데이터를 사용해야 함으로 protected로 생성
    protected coffeeRecipe coffee;

    /**
     * 문서의 제목을 설정하는 추상 메서드입니다.
     *
     * @param title 문서의 제목
     */
    public abstract void strTitle(String title);

    /**
     * 문서에 항목을 추가하는 추상 메서드입니다.
     *
     * @param string 항목을 포함한 문자열
     */
    public abstract void strAdd(String string);

    /**
     * 문서를 닫는 추상 메서드입니다.
     */
    public abstract void strClose();

    /**
     * 문서의 항목들을 생성하는 추상 메서드입니다.
     *
     * @param items 항목 배열
     */
    public abstract void makeItems(String[] items);

    /**
     * 형식화된 문서 내용을 문자열로 반환하는 추상 메서드입니다.
     *
     * @return 형식화된 문서 내용을 문자열로 반환합니다.
     */
    public abstract String getStringFormat();
}
