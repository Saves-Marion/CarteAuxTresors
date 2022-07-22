package main.java.models;

import main.java.enums.ElementTypeEnum;
import main.java.enums.MouvementEnum;
import main.java.enums.OrientationEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static main.java.enums.ElementTypeEnum.A;

public class Adventurer extends Coordinates {
    private String name;
    private Integer numberTreasure;
    private OrientationEnum orientation;
    private ArrayList<MouvementEnum> mouvement;

    public Adventurer(String name, Integer horizontal, Integer vertical, OrientationEnum orientation, ArrayList<MouvementEnum> mouvement){
        super(horizontal, vertical);
        this.setName(name);
        this.setNumberTreasure(0);
        this.setOrientation(orientation);
        this.setMouvement(mouvement);
    }

    /**
     * Retrieve the information of the line beginning by "A" meant to create the adventurers.
     *
     * @param lines
     * @return a list of the information of an adventurer.
     * The informations are a list of string: A, name, horizontal, vertical, orientation, mouvements.
     */
    public static List<List<String>> findAdventurerLines(List<String> lines) {
        List<List<String>> adventurerLines = new ArrayList<>();
        for (String line : lines) {
            List<String> contentLine = Arrays.stream(line.replaceAll("\\s+", "").toUpperCase(Locale.ROOT).split("-")).toList();
            if ( A.toString().equals(contentLine.get(0)) ) {
                System.out.println(line);
                adventurerLines.add(contentLine);
            }
        }
        return adventurerLines;
    }

    public String toString() {
        return "A - " + this.getName() + " - " + this.getHorizontal() + " - " + this.getVertical() + " - " + this.getOrientation() + " - "+ this.getNumberTreasure();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberTreasure() {
        return numberTreasure;
    }

    public void setNumberTreasure(Integer numberTreasure) {
        this.numberTreasure = numberTreasure;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationEnum orientation) {
        this.orientation = orientation;
    }

    public ArrayList<MouvementEnum> getMouvement() {
        return mouvement;
    }

    public void setMouvement(ArrayList<MouvementEnum> mouvement) {
        this.mouvement = mouvement;
    }
}
