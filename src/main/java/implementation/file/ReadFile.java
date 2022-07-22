package main.java.implementation.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static main.java.exceptions.Exceptions.*;

public class ReadFile {
    private static File inputFile;
    private static java.io.FileReader fileReader;
    private static BufferedReader bufferedReader;

    /**
     * Open a file to read.
     *
     * @param pathFile
     */
    public static void openReader(String pathFile) throws FileNotFoundException {
        try {
            inputFile = new File(pathFile);
            fileReader = null;
            fileReader = new FileReader(inputFile);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(openReaderException);
            System.out.println(fileNotFoundException);
            throw new FileNotFoundException(openReaderException);
        }
        bufferedReader = new BufferedReader(fileReader);
    }

    /**
     * Close the reader.
     */
    public static void closeReader() throws Exception{
        if (fileReader == null) {
            throw new NullPointerException(fileReaderIsNullException);
        }
        try {
            fileReader.close();
        } catch (IOException IOException) {
            System.out.println(closeReaderException);
            System.out.println(IOException);
            throw new IOException(closeReaderException);
        }
        bufferedReader.close();
    }

    /**
     * Read a line.
     *
     * @return a line read.
     */
    public static String readLine() throws Exception{
        if (fileReader == null) {
            throw new NullPointerException(fileReaderIsNullException);
        }
        try {
            return bufferedReader.readLine();
        } catch (IOException IOException) {
            System.out.println(readLineException);
            System.out.println(IOException);
            throw new IOException(readLineException);
        }
    }

    /**
     * Read all lines.
     *
     * @return a list of all the lines on the file.
     */
    public static List<String> readAllLines() throws Exception {
        if (fileReader == null) {
            throw new NullPointerException(fileReaderIsNullException);
        }
        List<String> lines = new ArrayList<>();
        String line;
        try {
            while ((line = ReadFile.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException IOException) {
            System.out.println(readLineException);
            System.out.println(IOException);
            throw new Exception(readLineException);
        }
        return lines;
    }
}
