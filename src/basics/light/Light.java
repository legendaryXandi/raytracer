package basics.light;

import basics.Color;
import basics.Vec3;
import basics.Fallof;

public interface Light {

    public Color getColor();
    public Vec3 getDirection();
    public Vec3 getPosition();
    public Fallof getFallof();
}
