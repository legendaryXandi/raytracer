package basics.light;

import basics.Color;
import basics.Coordinate;
import basics.Fallof;

public interface Light {

    public Color getColor();
    public Coordinate getDirection();
    public Coordinate getPosition();
    public Fallof getFallof();
}
