package main.java.implementation.mouvement;

import main.java.enums.MouvementEnum;
import main.java.enums.OrientationEnum;
import main.java.models.Adventurer;
import main.java.models.Map;
import main.java.models.Mountain;
import main.java.models.Treasure;

import java.util.ArrayList;
import java.util.List;

public class Mouvement {

    /**
     * Make all the adventurers move all their step.
     *
     * @param map
     */
    public static void allMouvement(Map map) {
        int maxMouvement = map.getMaxMouvement();
        List<Adventurer> adventurers = map.getAdventurers();
        for (int i = 0; i < maxMouvement; i++) {
            System.out.println("\n");
            for (Adventurer adventurer : adventurers) {
                Mouvement.mouvement(map, adventurer, i);
            }
        }
    }

    /**
     * Find the next step of the adventurer.
     *
     * @param map
     * @param adventurer
     * @param numberMouvement
     */
    public static void mouvement(Map map, Adventurer adventurer, int numberMouvement) {
        System.out.println("Do the adventurer " + adventurer.getName() + " move ?");
        ArrayList<MouvementEnum> completeMouvement = adventurer.getMouvement();
        MouvementEnum mouvement;
        if (completeMouvement.size() > numberMouvement) {
            mouvement = completeMouvement.get(numberMouvement);
        }
        else {
            System.out.println("No, it's done.");
            return;
        }
        OrientationEnum orientation = adventurer.getOrientation();
        switch (mouvement) {
            case A:
                takeAStep(map, adventurer, orientation);
                break;
            case G:
                System.out.println("He turn left.");
                Orientation.changeOrientationToTheLeft(adventurer, orientation);
                break;
            case D:
                System.out.println("He turn right.");
                Orientation.changeOrientationToTheRight(adventurer, orientation);
                break;
            default:
                break;
        }
    }

    /**
     * The adventurer take a step. He move if their is no mountain or adventurer in the next step.
     * He can retrieve a treasure if he has the occasion.
     *
     * @param map
     * @param adventurer
     * @param orientation
     */
    public static void takeAStep(Map map, Adventurer adventurer, OrientationEnum orientation) {
        Integer horizontal = adventurer.getHorizontal();
        Integer vertical = adventurer.getVertical();
        switch (orientation) {
            case N:
                if (isTheAdventurerAbleToMove(map, horizontal, vertical - 1)) {
                    adventurer.setVertical(vertical - 1);
                    System.out.println("Yes, he move to the north and is now in case " + adventurer.getHorizontal() + " - " + adventurer.getVertical());
                    pickUpTreasure(map.getTreasures(), adventurer);
                }
                break;
            case O:
                if (isTheAdventurerAbleToMove(map, horizontal - 1, vertical)) {
                    adventurer.setHorizontal(horizontal - 1);
                    System.out.println("Yes, he ouest to the north and is now in case " + adventurer.getHorizontal() + " - " + adventurer.getVertical());
                    pickUpTreasure(map.getTreasures(), adventurer);
                }
                break;
            case S:
                if (isTheAdventurerAbleToMove(map, horizontal, vertical + 1)) {
                    adventurer.setVertical(vertical + 1);
                    System.out.println("Yes, he ouest to the south and is now in case " + adventurer.getHorizontal() + " - " + adventurer.getVertical());
                    pickUpTreasure(map.getTreasures(), adventurer);
                }
                break;
            case E:
                if (isTheAdventurerAbleToMove(map, horizontal + 1, vertical)) {
                    adventurer.setHorizontal(horizontal + 1);
                    System.out.println("Yes, he est to the north and is now in case " + adventurer.getHorizontal() + " - " + adventurer.getVertical());
                    pickUpTreasure(map.getTreasures(), adventurer);
                }
                break;
            default:
                break;
        }
    }

    /**
     * Return true if a case is on the map.
     *
     * @param map
     * @param horizontal
     * @param vertical
     * @return boolean true if the next step is on the map.
     */
    public static boolean isOnMap(Map map, Integer horizontal, Integer vertical) {
        if (horizontal < 0 || vertical < 0) {
            return false;
        }
        return horizontal < map.getHorizontalSize() && vertical < map.getVerticalSize();
    }

    /**
     * Return true if the position is not a position of a mountain.
     *
     * @param mountains
     * @param horizontalAdventurer
     * @param verticalAdventurer
     * @return boolean true if next step is not a mountain
     */
    public static boolean isNotMountain(List<Mountain> mountains, Integer horizontalAdventurer, Integer verticalAdventurer) {
        for (Mountain mountain : mountains) {
            Integer horizontalMountain = mountain.getHorizontal();
            Integer verticalMountain = mountain.getVertical();
            if (horizontalMountain.equals(horizontalAdventurer) && verticalMountain.equals(verticalAdventurer)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return true if the position is not a position of another adventurer.
     *
     * @param adventurers
     * @param horizontalAdventurer
     * @param verticalAdventurer
     * @return boolean true if next step is not the position of another adventurer
     */
    public static boolean isNotOccupiedByAnotherAdventurer(List<Adventurer> adventurers, Integer horizontalAdventurer, Integer verticalAdventurer) {
        for (Adventurer adventurer : adventurers) {
            Integer horizontalOtherAdventurer = adventurer.getHorizontal();
            Integer verticalOtherAdventurer = adventurer.getVertical();
            if (horizontalOtherAdventurer.equals(horizontalAdventurer) && verticalOtherAdventurer.equals(verticalAdventurer)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return if the adventurer can move to the next step.
     * To be able to move the next step must belong to the map, no be a mountain, no having another adventurer on it.
     *
     * @param map
     * @param horizontal
     * @param vertical
     * @return boolean true if the adventurer can move to the next step.
     */
    public static boolean isTheAdventurerAbleToMove(Map map, Integer horizontal, Integer vertical) {
        return isOnMap(map, horizontal,vertical) && isNotMountain(map.getMountains(), horizontal, vertical) && isNotOccupiedByAnotherAdventurer(map.getAdventurers(), horizontal, vertical) ;
    }

    /**
     * If the adventurer is on a treasure he can retrieve a treasure.
     * The number of treasure on the box will decrease and the number of treasure on the adventurer
     * pocket will increase.
     *
     * @param treasures
     * @param adventurer
     */
    public static void pickUpTreasure(List<Treasure> treasures, Adventurer adventurer) {
        Integer horizontalAdventurer = adventurer.getHorizontal();
        Integer verticalAdventurer = adventurer.getVertical();
        for (Treasure treasure : treasures) {
            Integer horizontalTreasure = treasure.getHorizontal();
            Integer verticalTreasure = treasure.getVertical();
            if (horizontalTreasure.equals(horizontalAdventurer) && verticalTreasure.equals(verticalAdventurer) && treasure.getNumberTreasure() != 0) {
                System.out.println("He has found a treasure !");
                treasure.setNumberTreasure(treasure.getNumberTreasure() - 1);
                adventurer.setNumberTreasure(adventurer.getNumberTreasure() + 1);
                break;
            }
        }
    }
}
