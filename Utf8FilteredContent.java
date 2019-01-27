class Utf8FilteredContent {

    private final String content;

    public Utf8FilteredContent(String content) {
        this.content = content;
    }

    public String content() {
        StringBuilder sb = new StringBuilder();
        for (byte b : content.getBytes()) {
            if ((char)b < 0x80) {
                sb.append((char) b);
            }
        }
        return sb.toString();
    }
}