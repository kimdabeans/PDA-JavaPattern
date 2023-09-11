package aws3tier;

public class Local implements IRoutable {
    @Override
    public String getTargetId() {
        return "local";
    }
}
