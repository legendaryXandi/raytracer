package basics.light;

import basics.Color;
import basics.Coordinate;
import basics.Fallof;

public class AmbientLight implements Light{

    private Color color;

    public AmbientLight(Color color) {
        this.color = color;
    }

    public AmbientLight() {
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Coordinate getDirection() {
        return null;
    }

    @Override
    public Coordinate getPosition() {
        return null;
    }

    @Override
    public Fallof getFallof() {
        return null;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
