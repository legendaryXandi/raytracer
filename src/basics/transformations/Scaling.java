package basics.transformations;

import basics.Coordinate;

public class Scaling implements Transformations {
    private Coordinate coordinate;

    public Scaling(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Scaling() {
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
