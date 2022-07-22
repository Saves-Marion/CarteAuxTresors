package main.java.models;

import main.java.enums.ElementTypeEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static main.java.enums.ElementTypeEnum.T;

public class Treasure extends Coordinates {

    private Integer numberTreasure;

    public Treasure(Integer horizontal, Integer vertical, Integer numberTreasure){
        super(horizontal, vertical);
        this.setNumberTreasure(numberTreasure);
    }

    /**
     * Retrieve the information of the line beginning by "T" meant to create the treasures.
     *
     * @param lines
     * @return a list of the information of a treasure.
     * The informations are a list of string: T, horizontal, vertical, the quantity of treasure in the chest.
     */
    public static List<List<String>> findTreasureLines(List<String> lines) {
        List<List<String>> treasureLines = new ArrayList<>();
        for (String line : lines) {
            List<String> contentLine = Arrays.stream(line.replaceAll("\\s+", "").toUpperCase(Locale.ROOT).split("-")).toList();
            if (T.toString().equals(contentLine.get(0)) ) {
                System.out.println(line);
                treasureLines.add(contentLine);
            }
        }
        return treasureLines;
    }

    public String toString() {
        return "T - " + this.getHorizontal() + " - " + this.getVertical() + " - " + this.getNumberTreasure();
    }

    public Integer getNumberTreasure() {
        return numberTreasure;
    }

    public void setNumberTreasure(Integer numberTreasure) {
        this.numberTreasure = numberTreasure;
    }
}
