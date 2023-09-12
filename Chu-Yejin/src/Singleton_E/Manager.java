package Singleton_E;

import java.util.ArrayList;
import java.util.List;

/**
 * 물건을 관리하는 창고의 관리자 클래스입니다.
 * 이 클래스는 Enum을 사용하여 싱글톤 패턴을 구현합니다.
 */
public enum Manager {
    INSTANCE; // 싱글톤 인스턴스

    private List<String> items; // 창고에 보관된 물건 목록

    /**
     * Enum 생성자에서 초기화합니다.
     */
    private Manager() {
        items = new ArrayList<>();
    }

    /**
     * 물건을 창고에 추가하는 메서드입니다.
     *
     * @param item 추가할 물건의 이름
     */
    public void addItem(String item) {
        items.add(item);
        System.out.println(item + "을(를) 창고에 추가했습니다.");
    }

    /**
     * 물건을 창고에서 제거하는 메서드입니다.
     *
     * @param item 제거할 물건의 이름
     */
    public void removeItem(String item) {
        if (items.remove(item)) {
            System.out.println(item + "을(를) 창고에서 제거했습니다.");
        } else {
            System.out.println(item + "을(를) 창고에서 찾을 수 없습니다.");
        }
    }

    /**
     * 현재 창고에 보관된 물건 목록을 조회하는 메서드입니다.
     */
    public void showItems() {
        System.out.println("창고에 보관된 물건 목록:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }
}