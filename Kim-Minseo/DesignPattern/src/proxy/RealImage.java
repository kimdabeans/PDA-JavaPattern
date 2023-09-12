package proxy;

/**
 * RealImage 클래스는 실제 이미지를 나타내며 Image 인터페이스를 구현합니다.
 * 이 클래스는 이미지를 로드하고 출력하는 기능을 제공합니다.
 */
public class RealImage implements Image {

    private String imageName; // 이미지의 이름 또는 경로

    /**
     * RealImage의 생성자는 이미지의 제목을 받아와 초기화합니다.
     *
     * @param imageString 이미지의 제목
     */
    public RealImage(String imageString) {
        this.imageName = imageString;
    }

    /**
     * 이미지를 출력합니다. 이미지가 로드하고 해당 이미지의 이름을 출력합니다.
     */
    @Override
    public void print() {
        System.out.println("이미지 로딩 : " + imageName);
    }

    /**
     * 이미지를 디스크에서 캐싱하고, 이미지의 이름을 출력합니다.
     */
    public void diskImage() {
        System.out.println("이미지 캐싱 : " + imageName);
    }
}