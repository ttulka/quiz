import java.io.File;
import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    static final File testFile = new File("test.txt");

    @Test
    public void getContentTest() throws IOException {
        Parser parser = new Parser();
        parser.setFile(testFile);

        String content = parser.getContent();

        assertEquals("To je ale pÅ\u0099ekrÃ¡snÃ½ kÅ¯Å\u0088!", content);
    }

    @Test
    public void getContentWithoutUnicodeTest() throws Exception {
        Parser parser = new Parser();
        parser.setFile(testFile);

        String content = parser.getContentWithoutUnicode();

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
