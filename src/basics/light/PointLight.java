package basics.light;

import basics.Vec3;
import basics.Fallof;

import java.awt.*;

public class PointLight implements Light{

    private Color color;
    private Vec3 position;

    public PointLight(Color color, Vec3 position) {
        this.color = color;
        this.position = position;
    }

    public PointLight() {
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Vec3 getDirection() {
        return null;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vec3 getPosition() {
        return position;
    }

    @Override
    public Fallof getFallof() {
        return null;
    }

    public void setPosition(Vec3 position) {
        this.position = position;
    }
}
