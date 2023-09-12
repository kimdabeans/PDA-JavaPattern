package Strategy;

/**
 * description    : Mario Kart 게임의 메인클래스로 각각의 캐릭터가 가진 item을 기반으로 캐릭터 인스턴스를 생성 후 현재 가지고 있는 item을 실행하는 것을 출력하는 클래스<br>
 * packageName    : Strategy<br>
 * fileName       : Main<br>
 * author         : seoyun<br>
 * date           : 2023-09-10<br>
 */
public class Main {
    public static void main(String args[])
    {
        /**
         * 각각의 인터페이스들이 가지고 있는 item 생성
         */
        MushroomItem longSpeed = new LongSpeed();
        MushroomItem shortSpeed = new ShortSpeed();
        BananaItem longSlide = new LongSlide();
        BananaItem shortSlide = new ShortSlide();

        /**
         *  Mario가 가지고 있는 아이템읆 매개변수로 하여 Mario인스턴스 생성
         */
        MARIOKART mario = new Mario(longSpeed,shortSlide);

        System.out.println("=========");

        mario.display();

        mario.getitem();
        /**
         * 마리오가 어떤 아이템 사용했는지 출력
         */
        mario.slide();
        mario.speed();

        /**
         * 마리오가 중간에 획득한 아이템 설정하는 메소드
         */
        mario.setBananaItem(longSlide);
        mario.slide();

        /**
         *  luigi 가지고 있는 아이템읆 매개변수로 하여 luigi인스턴스 생성
         */
        MARIOKART luigi = new Luigi(shortSpeed,shortSlide);
        System.out.println("=========");
        luigi.display();

        luigi.getitem();
        /**
         * 루이지가 어떤 아이템 사용했는지 출력
         */
        luigi.slide();
        luigi.speed();


        /**
         * 루이지가 중간에 획득한 아이템 설정하는 메소드
         */
        luigi.setBananaItem(longSlide);
        luigi.slide();

        /**
         *  donkeyKong 가지고 있는 아이템읆 매개변수로 하여 donkeyKong인스턴스 생성
         */
        MARIOKART donkeyKong = new DonkeyKong(shortSpeed,longSlide);
        System.out.println("=========");
        donkeyKong.display();

        donkeyKong.getitem();
        /**
         * 돈키콩이 어떤 아이템 사용했는지 출력
         */
        donkeyKong.slide();
        donkeyKong.speed();

        /**
         * 돈키콩이 중간에 획득한 아이템 설정하는 메소드
         */
        donkeyKong.setMushroomItem(longSpeed);
        donkeyKong.speed();
    }
}
