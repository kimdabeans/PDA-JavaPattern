package Singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * 물건을 관리하는 창고의 관리자 클래스입니다.
 * 이 클래스는 싱글톤 패턴을 사용하여 하나의 관리자 인스턴스를 유지합니다.
 */
public class Manager {
    private static Manager instance; // 싱글톤 인스턴스
    private List<String> items; // 창고에 보관된 물건 목록

    /**
     * 외부에서 직접 인스턴스를 생성하지 못하도록, 생성자를 private으로 지정합니다.
     */
    private Manager() {
        items = new ArrayList<>();
    }

    /**
     * 창고 관리자 인스턴스를 얻는 메서드입니다.
     * 이미 인스턴스가 생성되어 있는 경우 기존 인스턴스를 반환하고, 생성되어 있지 않은 경우 새로운 인스턴스를 생성합니다.
     *
     * @return 창고 관리자 인스턴스
     */
    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
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