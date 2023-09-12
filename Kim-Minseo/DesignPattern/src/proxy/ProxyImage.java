package proxy;

/**
 * ProxyImage는 이미지를 로드하는 데 사용되는 프록시 패턴의 구현입니다.
 * 이 클래스는 실제 이미지 로딩을 지연시키고, 필요한 경우에만 실제 이미지를 로드하여
 * 성능 향상 및 자원 절약을 가능하게 합니다.
 */
public class ProxyImage implements Image {

    private RealImage image; // 실제 이미지 객체
    private String imageName; // 이미지의 이름 또는 경로

    /**
     * ProxyImage의 생성자는 이미지의 이름 또는 경로를 받아와 초기화합니다.
     *
     * @param imageName 이미지의 이름 또는 경로
     */
    public ProxyImage(String imageName) {
        this.imageName = imageName;
    }

    /**
     * 이미지를 출력합니다. 이미지가 로드되지 않은 경우에는 실제 이미지 객체를 생성하고 출력하며,
     * 이미지가 이미 로드된 경우에는 바로 출력합니다.
     */
    @Override
    public void print() {
        if(image == null) {
            image = new RealImage(imageName);
            image.print();
        }
        else {
            image.diskImage();
        }
    }
}