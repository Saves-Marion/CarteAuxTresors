package main.java.models;

import main.java.enums.ElementTypeEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static main.java.enums.ElementTypeEnum.M;

public class Mountain extends Coordinates {

    public Mountain(Integer horizontal, Integer vertical){
        super(horizontal, vertical);
    }

    /**
     * Retrieve the information of the line beginning by "M meant to create the mountains.
     *
     * @param lines
     * @return a list of the information of a mountain.
     * The informations are a list of string: M, horizontal, vertical.
     */
    public static List<List<String>> findMountainLines(List<String> lines) {
        List<List<String>> mountainLines = new ArrayList<>();
        for (String line : lines) {
            List<String> contentLine = Arrays.stream(line.replaceAll("\\s+", "").toUpperCase(Locale.ROOT).split("-")).toList();
            if ( M.toString().equals(contentLine.get(0)) ) {
                System.out.println(line);
                mountainLines.add(contentLine);
            }
        }
        return mountainLines;
    }

    public String toString() {
        return "M - " + this.getHorizontal() + " - " + this.getVertical();
    }
}
