package abstract_factory_pattern;

public class GoogleOS implements OS {
    @Override
    public void installOS() {
        System.out.println("구글OS 설치");
    }
}
