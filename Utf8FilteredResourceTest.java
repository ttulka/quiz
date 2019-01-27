import java.io.File;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Utf8FilteredResourceTest {

    static final File testFile = new File("test.txt");

    @Test
    public void contentTest() throws Exception {
        String content = new Utf8FilteredResource(new RawTextFile(testFile)).content();

        assertEquals("To je ale pekrsn k!", content);
    }

    @Test
    public void saveContentTest() throws Exception {
        Parser parser = new Parser();
        parser.setFile(testFile);

        String content = parser.getContent();

        File fileToSave = new File(this.getClass().getName() + ".saveContentTest.txt");

        parser.setFile(fileToSave);

        parser.saveContent(content);

        fileToSave.delete();

        assertEquals(content, parser.getContent());
    }
}
