package basics.light;

import basics.Color;

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

    public void setColor(Color color) {
        this.color = color;
    }
}
