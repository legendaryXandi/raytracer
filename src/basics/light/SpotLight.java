package basics.light;

import basics.Color;
import basics.Coordinate;
import basics.Fallof;

public class SpotLight implements Light{

    private Color color;
    private Coordinate direction;
    private Coordinate position;
    private Fallof fallof;

    public SpotLight(Color color, Coordinate direction, Coordinate position, Fallof fallof) {
        this.color = color;
        this.direction = direction;
        this.position = position;
        this.fallof = fallof;
    }

    public SpotLight() {
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

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Fallof getFallof() {
        return fallof;
    }

    public void setFallof(Fallof fallof) {
        this.fallof = fallof;
    }
}
