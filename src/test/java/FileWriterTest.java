package test.java;

import main.java.implementation.file.WriteFile;
import main.java.models.Map;
import org.junit.jupiter.api.Test;

import static main.java.exceptions.Exceptions.fileWriterIsNullException;
import static org.junit.jupiter.api.Assertions.fail;

public class FileWriterTest{

    @Test
    public void testWriteFileShouldThrowFileNotFoundException() throws Exception {
        Map map = new Map(3, 5);
        try {
            WriteFile.writeFile(map);
            fail("Should throw NullPointerException when one try to write in a file that does not exist.");
        } catch (NullPointerException nullPointerException) {
            assert (nullPointerException.getMessage().contains(fileWriterIsNullException));
        }
    }

    @Test
    public void testCloseWriterShouldThrowNullPointerException() throws Exception {
        try {
            WriteFile.closeWriter();
            fail("Should throw NullPointerException when one try to write in a file that does not exist.");
        } catch (NullPointerException nullPointerException) {
            assert (nullPointerException.getMessage().contains(fileWriterIsNullException));
        }
    }
}
