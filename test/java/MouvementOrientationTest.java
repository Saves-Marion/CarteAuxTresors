package test.java;

import main.java.enums.MouvementEnum;
import main.java.implementation.mouvement.Mouvement;
import main.java.implementation.mouvement.Orientation;
import main.java.models.Adventurer;
import main.java.models.Map;
import main.java.models.Mountain;
import main.java.models.Treasure;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static main.java.enums.OrientationEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MouvementOrientationTest {

    @Test
    void testChangeOrientationToTheLeft() {
        ArrayList<MouvementEnum> mouvement = new ArrayList<>();
        mouvement.add(MouvementEnum.valueOf("G"));
        Adventurer adventurerNorth = new Adventurer("North", 1, 1, N, mouvement);
        Orientation.changeOrientationToTheLeft(adventurerNorth, N);
        Adventurer adventurerOuest = new Adventurer("Ouest", 1, 1, O, mouvement);
        Orientation.changeOrientationToTheLeft(adventurerOuest, O);
        Adventurer adventurerEst = new Adventurer("Est", 1, 1, E, mouvement);
        Orientation.changeOrientationToTheLeft(adventurerEst, E);
        Adventurer adventurerSouth = new Adventurer("South", 1, 1, S, mouvement);
        Orientation.changeOrientationToTheLeft(adventurerSouth, S);
        assertEquals(adventurerNorth.getOrientation(), O);
        assertEquals(adventurerOuest.getOrientation(), S);
        assertEquals(adventurerSouth.getOrientation(), E);
        assertEquals(adventurerEst.getOrientation(), N);
    }

    @Test
    void testChangeOrientationToTheRight() {
        ArrayList<MouvementEnum> mouvement = new ArrayList<>();
        mouvement.add(MouvementEnum.valueOf("D"));
        Adventurer adventurerNorth = new Adventurer("North", 1, 1, N, mouvement);
        Orientation.changeOrientationToTheRight(adventurerNorth, N);
        Adventurer adventurerOuest = new Adventurer("Ouest", 1, 1, O, mouvement);
        Orientation.changeOrientationToTheRight(adventurerOuest, O);
        Adventurer adventurerEst = new Adventurer("Est", 1, 1, E, mouvement);
        Orientation.changeOrientationToTheRight(adventurerEst, E);
        Adventurer adventurerSouth = new Adventurer("South", 1, 1, S, mouvement);
        Orientation.changeOrientationToTheRight(adventurerSouth, S);
        assertEquals(adventurerNorth.getOrientation(), E);
        assertEquals(adventurerOuest.getOrientation(), N);
        assertEquals(adventurerSouth.getOrientation(), O);
        assertEquals(adventurerEst.getOrientation(), S);
    }

    @Test
    void testTakeAStep() {
        Map map = new Map(3,4);
        ArrayList<MouvementEnum> mouvement = new ArrayList<>();
        mouvement.add(MouvementEnum.valueOf("A"));

        Integer horizontal = 1;
        Integer vertical = 1;
        Adventurer adventurerNorth = new Adventurer("North", horizontal, vertical, N, mouvement);
        Mouvement.takeAStep(map, adventurerNorth, adventurerNorth.getOrientation());
        assertEquals(adventurerNorth.getHorizontal(), horizontal);
        assertEquals(adventurerNorth.getVertical(), vertical - 1);

        Adventurer adventurerSouth = new Adventurer("South", horizontal, vertical, S, mouvement);
        Mouvement.takeAStep(map, adventurerSouth, adventurerSouth.getOrientation());
        assertEquals(adventurerSouth.getHorizontal(), horizontal);
        assertEquals(adventurerSouth.getVertical(), vertical + 1);

        Adventurer adventurerOuest = new Adventurer("Ouest", horizontal, vertical, O, mouvement);
        Mouvement.takeAStep(map, adventurerOuest, adventurerOuest.getOrientation());
        assertEquals(adventurerOuest.getHorizontal(), horizontal - 1);
        assertEquals(adventurerOuest.getVertical(), vertical);

        Adventurer adventurerEst = new Adventurer("Est", horizontal, vertical, E, mouvement);
        Mouvement.takeAStep(map, adventurerEst, adventurerEst.getOrientation());
        assertEquals(adventurerEst.getHorizontal(), horizontal + 1);
        assertEquals(adventurerEst.getVertical(), vertical);
    }

    @Test
    void testIsOnMap() {
        Map map = new Map(3,4);
        assertEquals(Mouvement.isOnMap(map, 1, 2), true);
        assertEquals(Mouvement.isOnMap(map, 0, 0), true);
        assertEquals(Mouvement.isOnMap(map, 3, 0), false);
        assertEquals(Mouvement.isOnMap(map, 0, 4), false);
        assertEquals(Mouvement.isOnMap(map, 3, 4), false);
        assertEquals(Mouvement.isOnMap(map, -1, -1), false);
    }

    @Test
    void testIsNotMountain() {
        Mountain mountain = new Mountain(1,2);
        List<Mountain> mountains = new ArrayList<>();
        mountains.add(mountain);
        assertEquals(Mouvement.isNotMountain(mountains, 1, 2), false);
        assertEquals(Mouvement.isNotMountain(mountains, 1, 1), true);
    }

    @Test
    void testPickUpTreasure() {
        ArrayList<MouvementEnum> mouvement = new ArrayList<>();
        mouvement.add(MouvementEnum.valueOf("D"));
        Adventurer adventurerNumberOne = new Adventurer("Lara", 1, 1, E, mouvement);
        Treasure treasure = new Treasure(1,1,1);
        Adventurer adventurerNumberTwo = new Adventurer("Laura", 1, 2, E, mouvement);
        Treasure noTreasure = new Treasure(1,2,0);
        List<Treasure> treasures = new ArrayList<>();
        treasures.add(treasure);
        treasures.add(noTreasure);

        assertEquals(adventurerNumberOne.getNumberTreasure(), 0);
        assertEquals(treasure.getNumberTreasure(), 1);
        assertEquals(adventurerNumberTwo.getNumberTreasure(), 0);
        assertEquals(noTreasure.getNumberTreasure(), 0);

        Mouvement.pickUpTreasure(treasures, adventurerNumberOne);
        Mouvement.pickUpTreasure(treasures, adventurerNumberTwo);

        assertEquals(adventurerNumberOne.getNumberTreasure(), 1);
        assertEquals(treasure.getNumberTreasure(), 0);
        assertEquals(adventurerNumberTwo.getNumberTreasure(), 0);
        assertEquals(noTreasure.getNumberTreasure(), 0);
    }

    @Test
    void testIsNotOccupiedByAnotherAdventurer() {
        ArrayList<MouvementEnum> mouvement = new ArrayList<>();
        mouvement.add(MouvementEnum.valueOf("D"));
        Adventurer adventurerNumberOne = new Adventurer("Lara", 1, 1, E, mouvement);
        Adventurer adventurerNumberTwo = new Adventurer("Laura", 1, 2, E, mouvement);
        List<Adventurer> adventurers = new ArrayList<>();
        adventurers.add(adventurerNumberOne);
        adventurers.add(adventurerNumberTwo);

        assertEquals(Mouvement.isNotOccupiedByAnotherAdventurer(adventurers, 1, 1), false);
        assertEquals(Mouvement.isNotOccupiedByAnotherAdventurer(adventurers, 1, 2), false);
        assertEquals(Mouvement.isNotOccupiedByAnotherAdventurer(adventurers, 1, 3), true);
    }
}
