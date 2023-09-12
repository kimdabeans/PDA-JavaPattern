package factory.idcard;

import factory.framework.*;

/**
 * ID 카드를 표현하는 클래스.
 */
public class IDCard extends Product{
    private String owner;

    /**
     * 주어진 소유주 정보로 IDCard 객체를 생성하고 초기화합니다.
     * @param owner 카드의 소유주 이름
     */
    IDCard(String owner) {
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(owner + "의 카드를 사용합니다.");
    }

    /**
     * 카드의 소유주 정보를 반환합니다.
     * @return 카드의 소유주 이름
     */
    public String getOwner() {
        return this.owner;
    }
}