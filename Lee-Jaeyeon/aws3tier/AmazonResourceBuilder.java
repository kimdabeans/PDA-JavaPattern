package aws3tier;

public interface AmazonResourceBuilder<T> {

    AmazonResourceBuilder<T> setConfiguration(Configuration config);
    T build();

}
