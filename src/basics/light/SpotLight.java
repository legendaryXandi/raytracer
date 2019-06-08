package basics.light;

import basics.Color;
import basics.Vec3;
import basics.Fallof;

public class SpotLight implements Light{

    private Color color;
    private Vec3 direction;
    private Vec3 position;
    private Fallof fallof;

    public SpotLight(Color color, Vec3 direction, Vec3 position, Fallof fallof) {
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

    public Vec3 getDirection() {
        return direction;
    }

    public void setDirection(Vec3 direction) {
        this.direction = direction;
    }

    public Vec3 getPosition() {
        return position;
    }

    public void setPosition(Vec3 position) {
        this.position = position;
    }

    public Fallof getFallof() {
        return fallof;
    }

    public void setFallof(Fallof fallof) {
        this.fallof = fallof;
    }
}
