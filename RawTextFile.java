import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RawTextFile implements TextResource {

    private final File file;

    public RawTextFile(File file) {
        this.file = file;
    }

    @Override
    public String content() throws IOException {
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            StringBuilder sb = new StringBuilder();
            int data;
            while ((data = inputStream.read()) > 0) {
                sb.append((char) data);
            }
            return sb.toString();
        }
    }

    @Override
    public void save(String content) throws Exception {
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            for (byte b : content.getBytes()) {
                outputStream.write(b);
            }
        }
    }
}
