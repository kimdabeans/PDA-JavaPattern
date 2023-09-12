package proxy;
/**
 * 이 클래스는 이미지 출력을 위한 프록시 패턴을 구현한 예제입니다.
 * Homepage 클래스는 실제 이미지 출력 작업을 Image 프록시에 위임하고,
 * 이미지 출력 시간을 측정하여 결과를 출력합니다.
 */

public class Homepage {
    private Image proxy;

    /**
     * Homepage 클래스의 생성자입니다.
     *
     * @param proxy 이미지 출력을 위임할 Image 프록시 객체
     */
    public Homepage(Image proxy) {
        this.proxy = proxy;
    }

    /**
     * 이미지를 그리는 메서드입니다. 이미지 출력 시간을 측정하고 결과를 출력합니다.
     */
    public void draw() {
        long startTime = System.currentTimeMillis();
        proxy.print();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("치킨 버거 사진을 불러오기 위해 " + resultTime + "초를 사용했습니다.\n");
    }
}