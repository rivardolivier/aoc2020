package day3;

import java.util.HashMap;
import java.util.List;

public class Map {

    private List<String> mapData;
    private Integer positionX, positionY;

    public List<String> getMapData() {
        return mapData;
    }

    public void setMapData(List<String> mapData) {
        this.mapData = mapData;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Boolean move(Integer x, Integer y) {

        positionX+=x;
        positionY+=y;
        if (positionY>= mapData.size()) {
            return null;
        }

        String line = mapData.get(positionY);
        int valueOnLine = positionX%(line.length());
        return line.charAt(valueOnLine) == "#".charAt(0);
    }
}
