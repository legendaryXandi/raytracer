package basics.light;

import basics.Vec3;
import basics.Fallof;

import java.awt.*;

public class ParallelLight implements Light{

    private Color color;
    private Vec3 direction;

    public ParallelLight(Color color, Vec3 direction) {
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

    public Vec3 getDirection() {
        return direction;
    }

    @Override
    public Vec3 getPosition() {
        return null;
    }

    @Override
    public Fallof getFallof() {
        return null;
    }

    public void setDirection(Vec3 direction) {
        this.direction = direction;
    }
}
