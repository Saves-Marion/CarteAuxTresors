package main.java.models;

public class Coordinates {

    private Integer horizontal;
    private Integer vertical;

    public Coordinates(Integer horizontal, Integer vertical){
        this.setHorizontal(horizontal);
        this.setVertical(vertical);
    }
    public Integer getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Integer horizontal) {
        this.horizontal = horizontal;
    }

    public Integer getVertical() {
        return vertical;
    }

    public void setVertical(Integer vertical) {
        this.vertical = vertical;
    }
}
