package main.java.models;

import main.java.enums.ElementTypeEnum;
import main.java.enums.MouvementEnum;
import main.java.enums.OrientationEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static main.java.enums.ElementTypeEnum.C;

public class Map {
    private Integer horizontalSize;
    private Integer verticalSize;
    private List<Mountain> mountains;
    private List<Treasure> treasures;
    private static List<Adventurer> adventurers;

    public Map(Integer horizontalSize, Integer verticalSize){
        this.setHorizontalSize(horizontalSize);
        this.setVerticalSize(verticalSize);
        this.setMountains(new ArrayList<>());
        this.setTreasures(new ArrayList<>());
        this.setAdventurers(new ArrayList<>());
    }

    /**
     * Add a mountain to the list of mountains of the map.
     *
     * @param mountain
     */
    public void addMountain(Mountain mountain) {
        this.mountains.add(mountain);
    }

    /**
     * Add a treasure to the list of treasures of the map.
     *
     * @param treasure
     */
    public void addTreasure(Treasure treasure) {
        this.treasures.add(treasure);
    }

    /**
     * Add an adventurer to the list of adventurers of the map.
     *
     * @param adventurer
     */
    public void addAdventurer(Adventurer adventurer) {
        adventurers.add(adventurer);
    }

    /**
     * Return the maximum number of mouvement an adventurer present on the map have to do.
     *
     * @return the number max of mouvement.
     */
    public int getMaxMouvement() {
        int maxMouvement = 0;
        for (Adventurer adventurer : adventurers) {
            maxMouvement = Math.max(maxMouvement, adventurer.getMouvement().size());
        }
        return maxMouvement;
    }

    /**
     * Create a map and add mountains, treasures and adventurers to it through indication lines.
     *
     * @param lines
     * @return the map created
     */
    public static Map createMap(List<String> lines) {
        System.out.println("\nThe map is defined by :");
        List<String> mapLine = findMapLine(lines);

        System.out.println("The mountains are defined by :");
        List<List<String>> mountainLines = Mountain.findMountainLines(lines);

        System.out.println("The treasures are defined by");
        List<List<String>> treasureLines = Treasure.findTreasureLines(lines);

        System.out.println("The adventurers are defined by");
        List<List<String>> adventurerLines = Adventurer.findAdventurerLines(lines);

        Map map = new Map(Integer.parseInt(mapLine.get(1)), Integer.parseInt(mapLine.get(2)));

        for (List<String> mountainLine : mountainLines) {
            Mountain mountain = new Mountain(Integer.parseInt(mountainLine.get(1)), Integer.parseInt(mountainLine.get(2)));
            map.addMountain(mountain);
        }

        for (List<String> treasureLine : treasureLines) {
            Treasure treasure = new Treasure(Integer.parseInt(treasureLine.get(1)), Integer.parseInt(treasureLine.get(2)), Integer.parseInt((treasureLine.get(3))));
            map.addTreasure(treasure);
        }

        for (List<String> adventurerLine : adventurerLines) {
            ArrayList<MouvementEnum> mouvementEnums = new ArrayList<MouvementEnum>();
            String mouvements = adventurerLine.get(5);
            for (String mouvement : mouvements.split("")) {
                mouvementEnums.add(MouvementEnum.valueOf(mouvement));
            }
            Adventurer adventurer = new Adventurer(adventurerLine.get(1), Integer.parseInt(adventurerLine.get(2)), Integer.parseInt(adventurerLine.get(3)), OrientationEnum.valueOf(adventurerLine.get(4)), mouvementEnums);
            map.addAdventurer(adventurer);
        }

        return map;
    }

    /**
     * Retrieve the information of the line beginning by "C" meant to create the map.
     *
     * @param lines
     * @return a list of string with the map information : C, horizontal, vertical
     */
    public static List<String> findMapLine(List<String> lines) {
        List<String> mapLine = new ArrayList<>();
        for (String line : lines) {
            List<String> contentLine = Arrays.stream(line.replaceAll("\\s+", "").toUpperCase(Locale.ROOT).split("-")).toList();
            if ( C.toString().equals(contentLine.get(0)) ) {
                System.out.println(line);
                mapLine = contentLine;
            }
        }
        return mapLine;
    }

    public String toString() {
        return "C - " + this.getHorizontalSize() + " - " + this.getVerticalSize();
    }

    public Integer getHorizontalSize() {
        return horizontalSize;
    }

    public void setHorizontalSize(Integer horizontalSize) {
        this.horizontalSize = horizontalSize;
    }

    public Integer getVerticalSize() {
        return verticalSize;
    }

    public void setVerticalSize(Integer verticalSize) {
        this.verticalSize = verticalSize;
    }

    public List<Mountain> getMountains() {
        return mountains;
    }

    public void setMountains(List<Mountain> mountains) {
        this.mountains = mountains;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    public void setAdventurers(List<Adventurer> theAdventurers) {
        adventurers = theAdventurers;
    }
}
