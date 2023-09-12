/**
 * 아이스크림 클래스입니다. 아이스크림 맛 정보와 먹는 동작을 정의합니다.
 */
class IceCream {
    private String flavor;

    /**
     * 아이스크림 객체를 생성합니다.
     *
     * @param flavor 아이스크림의 맛 정보.
     */
    public IceCream(String flavor) {
        this.flavor = flavor;
    }

    /**
     * 아이스크림의 맛 정보를 반환합니다.
     *
     * @return 아이스크림의 맛 정보.
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * 아이스크림을 먹는 동작을 나타냅니다.
     */
    public void eat() {
        System.out.println(flavor + " 아이스크림을 먹습니다!");
    }
}