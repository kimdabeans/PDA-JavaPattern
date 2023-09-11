class IceCream {
    private String flavor;

    public IceCream(String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void eat() {
        System.out.println(flavor + " 아이스크림을 먹습니다!");
    }
}