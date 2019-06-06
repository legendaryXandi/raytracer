package basics;

public class Camera {

    private Coordinate position;
    private Coordinate lookAt;
    private Coordinate up;

    private int angle;
    private int horizontal;
    private int vertical;

    private int maxBounces;

    public Camera(Coordinate position) {
        this.position = position;
    }

    public Camera() {

    }

    public Camera(Coordinate position, Coordinate lookAt, Coordinate up, int angle, int horizontal, int vertical, int maxBounces) {
        this.position = position;
        this.lookAt = lookAt;
        this.up = up;
        this.angle = angle;
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.maxBounces = maxBounces;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Coordinate getLookAt() {
        return lookAt;
    }

    public void setLookAt(Coordinate lookAt) {
        this.lookAt = lookAt;
    }

    public Coordinate getUp() {
        return up;
    }

    public void setUp(Coordinate up) {
        this.up = up;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public int getMaxBounces() {
        return maxBounces;
    }

    public void setMaxBounces(int maxBounces) {
        this.maxBounces = maxBounces;
    }
}
