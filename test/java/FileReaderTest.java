package test.java;

import main.java.implementation.file.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static main.java.exceptions.Exceptions.fileReaderIsNullException;
import static main.java.exceptions.Exceptions.openReaderException;
import static org.junit.jupiter.api.Assertions.fail;

public class FileReaderTest {

    @Test
    void testOpenReaderShouldThrowFileNotFoundException() {
        try {
            ReadFile.openReader("pathInvalid.txt");
            fail("Should throw FileNotFoundException when one try to open a file that does not exist.");
        } catch (FileNotFoundException fileNotFoundException) {
            assert (fileNotFoundException.getMessage().contains(openReaderException));
        }
    }

    @Test
    void testCloseReaderWhenNoFileReaderShouldThrowNullPointerException() throws Exception {
        try {
            ReadFile.closeReader();
            fail("Should throw a null pointer exception when one try to close a file that does not exist.");
        } catch (NullPointerException nullPointerException) {
            assert (nullPointerException.getMessage().contains(fileReaderIsNullException));
        }
    }

    @Test
    void testReadLineWhenNoFileReaderShouldThrowNullPointerException() throws Exception {
        try {
            ReadFile.readLine();
            fail("Should throw a null pointer exception when one try to read a file that does not exist.");
        } catch (NullPointerException nullPointerException) {
            assert (nullPointerException.getMessage().contains(fileReaderIsNullException));
        }
    }

    @Test
    void testReadAllLinesWhenNoFileReaderShouldThrowNullPointerException() throws Exception {
        try {
            ReadFile.readAllLines();
            fail("Should throw a null pointer exception when one try to read a file that does not exist.");
        } catch (NullPointerException nullPointerException) {
            assert (nullPointerException.getMessage().contains(fileReaderIsNullException));
        }
    }
}
