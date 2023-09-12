package abstract_factory_pattern;

public class IOS implements OS {
    @Override
    public void installOS() {
        System.out.println("IOS 설치");
    }
}
