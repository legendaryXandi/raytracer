package basics.light;

import basics.Color;
import basics.Coordinate;

public class ParallelLight implements Light{

    private Color color;
    private Coordinate direction;

    public ParallelLight(Color color, Coordinate direction) {
        this.color = color;
        this.direction = direction;
    }

    public ParallelLight() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Coordinate getDirection() {
        return direction;
    }

    public void setDirection(Coordinate direction) {
        this.direction = direction;
    }
}
