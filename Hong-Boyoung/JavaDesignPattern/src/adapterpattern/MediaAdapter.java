package adapterpattern;
/**
 * MediaAdapter 클래스는 MediaCompressor 인터페이스를 구현하여 다양한 이미지 파일 형식으로 압축할 수 있도록 지원합니다.
 * 이 클래스는 AdvancedMediaCompressor 구현한 구체적인 클래스(예: PNGCompressor, GIFCompressor)를 사용하여 고급 형식의 이미지 파일로 압축합니다.
 */
public class MediaAdapter implements MediaCompressor {

    AdvancedMediaCompressor advancedImageCompressor;
    /**
     * MediaAdapter 생성자는 주어진 이미지 파일 형식에 따라 적절한 AdvancedMediaCompressor를 생성합니다.
     *
     * @param imageType  압축할 이미지 파일 확장자 (예: "PNG" 또는 "GIF")
     */
    public MediaAdapter(String imageType){

        if(imageType.equalsIgnoreCase("PNG") ){
            advancedImageCompressor = new PNGCompressor();

        }else if (imageType.equalsIgnoreCase("GIF")){
            advancedImageCompressor = new GIFCompressor();
        }
    }
    /**
     * compress 메서드는 주어진 이미지 파일 형식에 따라 해당 AdvancedMediaCompressor를 사용하여 이미지 파일을 압축합니다.
     *
     * @param imageType  압축할 이미지 파일 확장자 (예: "PNG" 또는 "GIF")
     * @param fileName   압축할 이미지 파일
     */
    @Override
    public void compress(String imageType, String fileName) {

        if(imageType.equalsIgnoreCase("PNG")){
            advancedImageCompressor.compressPNG(fileName);
        }
        else if(imageType.equalsIgnoreCase("GIF")){
            advancedImageCompressor.compressGIF(fileName);
        }
    }
}
