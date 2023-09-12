package java0825_builder2;
/**
 * coffeeRecipe 클래스는 커피 레시피 정보를 나타내는 클래스입니다.
 * 이 클래스는 커피의 알콜 유무와 다양한 매개변수(크기, 우유 양, 에스프레소 양, 물 양, 설탕 양)를 설정할 수 있으며,
 * 커피 레시피를 빌더 디자인 패턴을 활용하여 생성합니다.
 *
 * @author Cho hayoung
 */
public class coffeeRecipe {
    private boolean alcol;
    private int size;
    private int milk;
    private int espresso;
    private int water;
    private int sugar;

    /**
     * coffeeBuilder 클래스를 사용하여 coffeeRecipe 객체를 생성합니다.
     *
     * @param coffeeBuilder coffeeBuilder 객체
     */
    public coffeeRecipe(coffeeBuilder coffeeBuilder) {
        this.alcol = coffeeBuilder.alcol;
        this.size = coffeeBuilder.size;
        this.milk = coffeeBuilder.milk;
        this.espresso = coffeeBuilder.espresso;
        this.water = coffeeBuilder.water;
        this.sugar = coffeeBuilder.sugar;
    }

    /**
     * coffeeBuilder 클래스는 coffeeRecipe 객체를 생성하기 위한 빌더 클래스입니다.
     */
    public static class coffeeBuilder {
        // 필수 매개 변수
        private final boolean alcol;
        // 선택 매개변수
        private int size = 0;
        private int milk = 0;
        private int espresso = 0;
        private int water = 0;
        private int sugar = 0;

        /**
         * 커피의 알콜 유무를 설정하는 coffeeBuilder 클래스의 생성자입니다.
         *
         * @param alcol 커피의 알콜 유무 (true 또는 false)
         */
        public coffeeBuilder(boolean alcol) {
            this.alcol = alcol;
        }

        /**
         * 커피의 크기를 설정합니다.
         *
         * @param size 커피의 크기
         * @return coffeeBuilder 객체
         */
        public coffeeBuilder size(int size) {
            this.size = size;
            return this;
        }

        /**
         * 커피에 추가되는 우유 양을 설정합니다.
         *
         * @param milk 우유 양
         * @return coffeeBuilder 객체
         */
        public coffeeBuilder milk(int milk) {
            this.milk = milk;
            return this;
        }

        /**
         * 커피에 추가되는 에스프레소 양을 설정합니다.
         *
         * @param espresso 에스프레소 양
         * @return coffeeBuilder 객체
         */
        public coffeeBuilder espresso(int espresso) {
            this.espresso = espresso;
            return this;
        }

        /**
         * 커피에 추가되는 물 양을 설정합니다.
         *
         * @param water 물 양
         * @return coffeeBuilder 객체
         */
        public coffeeBuilder water(int water) {
            this.water = water;
            return this;
        }

        /**
         * 커피에 추가되는 설탕 양을 설정합니다.
         *
         * @param sugar 설탕 양
         * @return coffeeBuilder 객체
         */
        public coffeeBuilder sugar(int sugar) {
            this.sugar = sugar;
            return this;
        }

        /**
         * 설정된 정보를 바탕으로 coffeeRecipe 객체를 생성합니다.
         *
         * @return 생성된 coffeeRecipe 객체
         */
        public coffeeRecipe build() {
            return new coffeeRecipe(this);
        }
    }

    /**
     * coffeeRecipe 객체의 정보를 문자열로 반환합니다.
     *
     * @return coffeeRecipe 객체의 정보를 문자열 형태로 반환합니다.
     */
    public String toString() {
        return "alcol : " + this.alcol + "\nsize : " + this.size + "\nmilk: " + this.milk
                + "\nespresso : " + this.espresso + "\nwater: " + this.water + "\n sugar : " + this.sugar;
    }
}
