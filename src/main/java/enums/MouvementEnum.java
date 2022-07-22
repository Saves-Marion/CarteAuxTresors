package main.java.enums;

public enum MouvementEnum {
    A("A"),
    G("G"),
    D("D"),
    O("O");

    private String deplacement;

    MouvementEnum(String deplacement) {
        this.deplacement = deplacement;
    }
}
