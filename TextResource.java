public interface TextResource {

    String content() throws Exception;

    void save(String content) throws Exception;
}
