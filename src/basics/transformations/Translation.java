package basics.transformations;

import basics.Coordinate;

public class Translation implements Transformations {
    private Coordinate coordinate;

    public Translation(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Translation() {
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
