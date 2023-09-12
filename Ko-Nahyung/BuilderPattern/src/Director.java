/**
 * Builder 인스턴스를 통해서, 하나의 문서를 만드는 클래스입니다.
 */
public class Director {
	
	/**
	 * Builder 클래스의 builder
	 */
	private Builder builder;
	
	/**
	 * Director 클래스 생성자입니다.
	 * 
	 * @param builder Builder 클래스의 인스턴스 
	 */
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	/**
	 * 문서를 구성합니다.
	 * 
	 * 이때, builder 인스턴스를 이용하여 문서를 구성합니다.
	 */
	public void construct() {
		builder.makeTitle("메뉴판");
		builder.makeString("찌개류");
		builder.makeItems(new String[] {
				"김치찌개",
				"된장찌개",
				"부대찌개",
				"순두부찌개"
		});
		builder.makeString("볶음류");
		builder.makeItems(new String[] {
			"돼지불고기",
			"소불고기",
			"돼지고기 숙주 볶음",
			"제육볶음"
		});
		builder.makeString("음료/주류");
		builder.makeItems(new String[] {
			"망고주스",
			"콜라",
			"사이다",
			"소주",
			"맥주",
			"막걸리"
		});
		builder.close();
	}	
}
