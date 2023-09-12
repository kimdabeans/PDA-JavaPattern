package Singleton_E;

import Singleton.Manager;

public class main {
    public static void main(String[] args) {
        // 창고 관리자 인스턴스를 얻습니다.
        Manager manager = Manager.getInstance();

        // 물건을 창고에 추가합니다.
        manager.addItem("책");
        manager.addItem("의자");
        manager.addItem("컴퓨터");

        // 창고에 보관된 물건 목록을 조회합니다.
        System.out.println("현재 창고 상태:");
        manager.showItems();

        // 물건을 창고에서 제거합니다.
        manager.removeItem("의자");
        manager.removeItem("테이블"); // 창고에 없는 물건을 제거하려고 시도

        // 최종 물건 목록을 다시 조회합니다.
        System.out.println("최종 창고 상태:");
        manager.showItems();
    }
}
