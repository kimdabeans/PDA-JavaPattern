package adapterpattern;
/**
 * AdvancedMediaCompressor 인터페이스는 이미지의 고급 확장자 파일로 압축하기 위한 메서드를 정의합니다.
 */
public interface AdvancedMediaCompressor {
    /**
     * PNG 이미지 파일로 압축합니다.
     *
     * @param fileName  PNG 파일로 압축할 이미지 파일의 이름.
     */
    public void compressPNG(String fileName);
    /**
     * GIF 이미지 파일로 압축합니다.
     *
     * @param fileName  GIF 파일로 압축할 이미지 파일의 이름.
     */
    public void compressGIF(String fileName);
}
