package adapterpattern;
/**
 * MediaCompressor 인터페이스는 이미지를 여러 확장자로 압축할 수 있는 메서드를 정의합니다.
 */
public interface MediaCompressor {
    /**
     * 주어진 이미지 파일을 압축합니다.
     *
     * @param imageType 이미지 확장자 유형 (예: "JPEG", "PNG", "GIF" 등)
     * @param fileName  압축할 이미지 파일의 이름
     */
    public void compress(String imageType, String fileName);
}