package java0825_builder;

/**
 * Builder 추상 클래스는 다양한 형식의 텍스트 문서를 생성하기 위한 메서드를 정의합니다.
 * 구체적인 형식의 문서 생성을 위해서는 이 클래스를 상속하고 필요한 메서드를 구현해야 합니다.
 */
public abstract class Builder {
    
    /**
     * 문서의 제목을 설정하는 추상 메서드입니다.
     *
     * @param title 문서의 제목
     */
    abstract void strTitle(String title);

    /**
     * 문서에 항목을 추가하는 추상 메서드입니다.
     *
     * @param str 항목을 포함한 문자열
     */
    abstract void strAdd(String str);

    /**
     * 문서를 닫는 추상 메서드입니다.
     */
    abstract void strClose();

    /**
     * 형식화된 문서 내용을 문자열로 반환하는 추상 메서드입니다.
     *
     * @return 형식화된 문서 내용을 문자열로 반환합니다.
     */
    public abstract String getStringFormat();
}
