package basics.light;

import basics.Color;
import basics.Coordinate;
import basics.Fallof;

public class PointLight implements Light{

    private Color color;
    private Coordinate position;

    public PointLight(Color color, Coordinate position) {
        this.color = color;
        this.position = position;
    }

    public PointLight() {
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Coordinate getDirection() {
        return null;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Coordinate getPosition() {
        return position;
    }

    @Override
    public Fallof getFallof() {
        return null;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }
}
