package FactoryPattern.Example02.After;

public class Main {
  public static void main(String[] args) {
    // 케이크 공장 생성
    CakeFactory factory = new CakeFactory();

    // 케이크 가게 생성
    CakeStore cakeStore = new CakeStore(factory);

    // 케이크 주문 및 서빙 시뮬레이션
    Cake chocolateCake = cakeStore.orderCake("chocolate");
    System.out.println("주문한 케이크: " + chocolateCake.getName());
    Cake vanillaCake = cakeStore.orderCake("vanilla");
    System.out.println("주문한 케이크: " + vanillaCake.getName());
    Cake strawberryCake = cakeStore.orderCake("strawberry");
    System.out.println("주문한 케이크: " + strawberryCake.getName());
  }
}

