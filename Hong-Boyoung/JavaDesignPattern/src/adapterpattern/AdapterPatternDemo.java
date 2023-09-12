package adapterpattern;
/**
 * AdapterPatternDemo 클래스는 어댑터 패턴을 사용하여 다양한 이미지 파일 형식을 압축하는 것에 대한 데모를 제공합니다.
 * 이 클래스는 ImageCompressor 객체를 생성하고, 주어진 이미지 파일 형식과 파일 이름에 따라 이미지 파일을 압축합니다.
 * 주어진 이미지 파일 형식이 "JPEG"인 경우 내장 지원을 통해 압축하며,
 * "PNG" 또는 "GIF"인 경우 MediaAdapter를 사용하여 해당 파일 형식에 맞는 AdvancedMediaCompressor를 호출하여 압축합니다.
 * 지원하지 않는 형식인 경우 "Invalid media" 메시지가 표시됩니다.
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        ImageCompressor imageCompressor = new ImageCompressor();

        // JPEG 파일 압축
        imageCompressor.compress("JPEG", "beyond the horizon.JPEG");
        // GIF 파일 압축
        imageCompressor.compress("GIF", "alone.GIF");
        // PNG 파일 압축
        imageCompressor.compress("PNG", "far far away.PNG");
        // bmp 파일 압축(지원하지 않는 형식)
        imageCompressor.compress("bmp", "mind me.bmp");
    }
}
