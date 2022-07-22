package main.java.enums;

public enum ElementTypeEnum {
    C("C"),
    T("T"),
    M("M"),
    A("A");

    private String typeElement;

    ElementTypeEnum(String typeElement) {
        this.typeElement = typeElement;
    }
}
