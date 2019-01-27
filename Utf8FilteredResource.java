public class Utf8FilteredResource implements TextResource {

    private final TextResource resource;

    public Utf8FilteredResource(TextResource resource) {
        this.resource = resource;
    }

    @Override
    public String content() throws Exception {
        return new Utf8FilteredContent(resource.content()).content();
    }

    @Override
    public void save(String content) throws Exception {
        resource.save(new Utf8FilteredContent(resource.content()).content());
    }
}