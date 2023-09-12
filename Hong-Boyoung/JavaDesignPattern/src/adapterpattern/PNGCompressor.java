package adapterpattern;
/**
 * PNGCompressor 클래스는 AdvancedMediaCompressor 인터페이스를 구현하여 주어진 이미지를 PNG 파일로 압축합니다.
 */
public class PNGCompressor implements AdvancedMediaCompressor{
    /**
     * 이미지를 PNG 파일로 압축하는 메서드 입니다.
     *
     * @param fileName  PNG 파일로 압축할 이미지 파일의 이름
     */
    @Override
    public void compressPNG(String fileName) {
        System.out.println("Compressing to PNG file. Name: "+ fileName);
    }
    /**
     * 이미지를 GIF 파일로 압축하는 메서드 입니다.
     * GIF 파일 압축은 지원하지 않으므로 아무 동작도 수행하지 않습니다.
     *
     * @param fileName  GIF 파일로 압축할 이미지 파일의 이름
     */
    @Override
    public void compressGIF(String fileName) {
        //아무 동작도 수행하지 않음
    }
}
