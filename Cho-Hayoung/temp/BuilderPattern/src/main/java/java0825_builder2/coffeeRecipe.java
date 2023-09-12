package java0825_builder2;

public class coffeeRecipe {
	private boolean alcol;
	private int size;
	private int milk;
	private int espresso;
	private int water;
	private int sugar;

	public coffeeRecipe(coffeeBuilder coffeeBuilder) {
		this.alcol = coffeeBuilder.alcol;
		this.size = coffeeBuilder.size;
		this.milk = coffeeBuilder.milk;
		this.espresso = coffeeBuilder.espresso;
		this.water = coffeeBuilder.water;
		this.sugar = coffeeBuilder.sugar;
	}

	public static class coffeeBuilder {
		// 필수 매개 변수 
		private final boolean alcol;
		// 선택 매개변수 
        private int size = 0;
        private int milk = 0;
        private int espresso = 0;
        private int water = 0;
        private int sugar = 0;
		public coffeeBuilder(boolean alcol) {

			this.alcol = alcol;
		}
		public coffeeBuilder size(int size) {
			this.size = size;
			return this;
		}
		public coffeeBuilder milk(int milk) {
			this.milk = milk;
			return this;

		}
		public coffeeBuilder espresso(int espresso) {
			this.espresso = espresso;
			return this;

		}
		public coffeeBuilder water(int water) {
			this.water = water;
			return this;

		}
		public coffeeBuilder sugar(int sugar) {
			this.sugar = sugar;
			return this;

		}
        public coffeeRecipe build() {
        	return new coffeeRecipe(this);
        }
        
        
        
	}
	
	public String toString() {
		
		
		return "alcol : "+this.alcol + "\nsize : " + this.size + "\nmilk: " + this.milk+"\n espresso : "+this.espresso+"\n water: "+this.water +"\n sugar : "+this.sugar; 
		
	}
	
}
