import java.io.File;
import java.nio.file.Files;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RawTextFileTest {

    static final File testFile = new File("test.txt");

    @Test
    public void contentTest() throws Exception {
        String content = new RawTextFile(testFile).content();

        assertEquals("To je ale pÅ\u0099ekrÃ¡snÃ½ kÅ¯Å\u0088!", content);
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
