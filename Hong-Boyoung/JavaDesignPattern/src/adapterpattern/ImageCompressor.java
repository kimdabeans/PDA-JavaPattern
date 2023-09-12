package adapterpattern;
/**
 * ImageCompressor 클래스는 MediaCompressor 인터페이스를 구현하여 다양한 이미지 파일 형식으로 압축할 수 있도록 지원합니다.
 * 이 클래스는 주어진 이미지 파일 형식에 따라 적절한 압축 방법을 선택하거나 MediaAdapter를 사용하여 고급 형식의 이미지 파일로 압축합니다..
 */
public class ImageCompressor implements MediaCompressor {
    MediaAdapter mediaAdapter;
    /**
     * compress 메서드는 주어진 이미지 파일 형식과 파일 이름을 기반으로 해당 이미지 파일을 압축합니다.
     * 이 메서드는 주어진 이미지 파일 형식이 "JPEG"인 경우 내장 지원을 통해 압축하며,
     * "PNG" 또는 "GIF"인 경우 MediaAdapter를 사용하여 해당 파일 형식에 맞는 AdvancedMediaCompressor를 호출하여 압축합니다.
     * 지원하지 않는 형식인 경우 "Invalid media" 메시지가 표시됩니다.
     *
     * @param imageType  압축할 이미지 파일 형식 (예: "JPEG", "PNG", "GIF" 등)
     * @param fileName   압축할 이미지 파일의 이름
     */
    @Override
    public void compress(String imageType, String fileName) {

        // 내장 지원을 통해 JPEG 음악 파일 재생
        if(imageType.equalsIgnoreCase("JPEG")){
            System.out.println("Compressing to JPEG file. Name: " + fileName);
        }

        // MediaAdapter를 사용하여 다른 이미지 파일 형식 압축 지원
        else if(imageType.equalsIgnoreCase("PNG") || imageType.equalsIgnoreCase("GIF")){
            mediaAdapter = new MediaAdapter(imageType);
            mediaAdapter.compress(imageType, fileName);
        }

        // 지원하지 않는 형식인 경우 예외 처리
        else{
            System.out.println("Invalid media. " + imageType + " format not supported");
        }
    }
}
