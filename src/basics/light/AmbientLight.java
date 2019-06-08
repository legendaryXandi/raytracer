package basics.light;

import basics.Color;
import basics.Vec3;
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
    public Vec3 getDirection() {
        return null;
    }

    @Override
    public Vec3 getPosition() {
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
