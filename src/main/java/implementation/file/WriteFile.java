package main.java.implementation.file;

import main.java.models.Adventurer;
import main.java.models.Map;
import main.java.models.Mountain;
import main.java.models.Treasure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static main.java.exceptions.Exceptions.*;

public class WriteFile {
    private static File outputFile;
    private static java.io.FileWriter fileWriter;
    private static BufferedWriter bufferedWriter;
    private static StringBuffer stringBuffer;

    /**
     * Open a file to write to it.
     *
     * @param pathFile
     */
    public static void openWriter(String pathFile) throws IOException{
        try {
            outputFile = new File(pathFile);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            fileWriter = new FileWriter(outputFile.getAbsoluteFile());
        } catch (IOException IOException) {
            System.out.println(openWriterException);
            System.out.println(IOException);
            throw new IOException(openWriterException);
        }
        bufferedWriter = new BufferedWriter(fileWriter);
        stringBuffer = new StringBuffer();
    }

    /**
     * Write on the file all the information of the element on the map and the map itself.
     * In the order : map, mountains, treasures, adventurers.
     *
     * @param map
     */
    public static void writeFile(Map map) throws Exception {
        if (fileWriter == null && bufferedWriter == null) {
            throw new NullPointerException(fileWriterIsNullException);
        }
        System.out.println("The map is now :");
        writeMap(map);
        writeAllMountains(map.getMountains());
        writeAllTreasure(map.getTreasures());
        writeAllAdventurers(map.getAdventurers());
        try {
            bufferedWriter.write(stringBuffer.toString());
        } catch (IOException IOException) {
            System.out.println(writeFileException);
            System.out.println(IOException);
            throw new IOException(writeFileException);
        }
    }

    /**
     * Write on the file the treasures.
     *
     * @param treasures
     */
    public static void writeAllTreasure(List<Treasure> treasures) {
        for (Treasure treasure : treasures) {
            if (treasure.getNumberTreasure() > 0) {
                System.out.println(treasure.toString());
                writeLine(treasure.toString() + "\n");
            }
        }
    }

    /**
     * Write on the file the adventurers.
     *
     * @param adventurers
     */
    public static void writeAllAdventurers(List<Adventurer> adventurers) {
        for (Adventurer adventurer : adventurers) {
            System.out.println(adventurer.toString());
            writeLine(adventurer.toString() + "\n");
        }
    }

    /**
     * Write the map on the file.
     *
     * @param map
     */
    public static void writeMap(Map map) {
        System.out.println(map.toString());
        writeLine(map.toString() + "\n");
    }

    /**
     * Write on the file the mountains.
     *
     * @param mountains
     */
    public static void writeAllMountains(List<Mountain> mountains) {
        for (Mountain mountain : mountains) {
            System.out.println(mountain.toString());
            writeLine(mountain.toString() + "\n");
        }
    }

    /**
     * Close the writer.
     */
    public static void closeWriter() throws Exception {
        if (fileWriter == null && bufferedWriter == null) {
            throw new NullPointerException(fileWriterIsNullException);
        }
        try {
            bufferedWriter.close();
        } catch (IOException IOException) {
            System.out.println(closeWriterException);
            System.out.println(IOException);
            throw new IOException(closeWriterException);
        }
    }

    /**
     * Write a line in the buffer.
     *
     * @param ligne
     */
    public static void writeLine(String ligne) {
        stringBuffer.append(ligne);
    }
}
