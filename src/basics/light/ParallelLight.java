package basics.light;

import basics.Color;
import basics.Coordinate;
import basics.Fallof;

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

    @Override
    public Coordinate getPosition() {
        return null;
    }

    @Override
    public Fallof getFallof() {
        return null;
    }

    public void setDirection(Coordinate direction) {
        this.direction = direction;
    }
}
