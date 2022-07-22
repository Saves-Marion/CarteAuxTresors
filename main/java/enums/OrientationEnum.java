package main.java.enums;

public enum OrientationEnum {
    N("N"),
    S("S"),
    E("E"),
    O("O");

    private String orientation;

    OrientationEnum(String orientation) {
        this.orientation = orientation;
    }
}
