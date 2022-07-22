package main.java.implementation;

import main.java.implementation.file.ReadFile;
import main.java.implementation.file.WriteFile;
import main.java.implementation.mouvement.Mouvement;
import main.java.models.Map;

import java.util.List;

import static main.java.configuration.FileNameConfiguration.fileInputName;
import static main.java.configuration.FileNameConfiguration.fileOutputName;

public class TreasureMap {

    static Map map;

    /**
     * Read the file, create a map, fill it with mountains, treasures and adventurers,
     * move the adventurers on the map and write the result.
     */
    public static void runTreasureMap() throws Exception {
        System.out.println("---The Start ---\n");

        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the input file : ");
        fileInputName = sc.nextLine();
        System.out.println("Please enter the name of the output file : ");
        fileOutputName = sc.nextLine();
        */

        ReadFile.openReader(fileInputName);
        List<String> lines = ReadFile.readAllLines();
        System.out.println("---The file is read ---");
        ReadFile.closeReader();

        map = Map.createMap(lines);
        System.out.println("---The map is create --- \n");

        System.out.println("\n---The adventurers start their mouvements ---");
        Mouvement.allMouvement(map);
        System.out.println("---The mouvements are done --- \n");

        WriteFile.openWriter(fileOutputName);
        WriteFile.writeFile(map);
        WriteFile.closeWriter();
        System.out.println("\n---The End ---");
    }
}
