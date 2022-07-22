package main.java.implementation.mouvement;

import main.java.enums.OrientationEnum;
import main.java.models.Adventurer;

public class Orientation {

    /**
     * Turn the orientation of the adventurer to the left.
     *
     * @param adventurer
     * @param orientation
     */
    public static void changeOrientationToTheLeft(Adventurer adventurer, OrientationEnum orientation) {
        switch (orientation) {
            case N:
                adventurer.setOrientation(OrientationEnum.O);
                break;
            case O:
                adventurer.setOrientation(OrientationEnum.S);
                break;
            case S:
                adventurer.setOrientation(OrientationEnum.E);
                break;
            case E:
                adventurer.setOrientation(OrientationEnum.N);
                break;
        }
    }

    /**
     * Turn the orientation of the adventurer to the right.
     *
     * @param adventurer
     * @param orientation
     */
    public static void changeOrientationToTheRight(Adventurer adventurer, OrientationEnum orientation) {
        switch (orientation) {
            case N:
                adventurer.setOrientation(OrientationEnum.E);
                break;
            case O:
                adventurer.setOrientation(OrientationEnum.N);
                break;
            case S:
                adventurer.setOrientation(OrientationEnum.O);
                break;
            case E:
                adventurer.setOrientation(OrientationEnum.S);
                break;
        }
    }
}
