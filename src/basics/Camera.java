package basics;

public class Camera {

    private Vec3 position;
    private Vec3 lookAt;
    private Vec3 up;

    private int angle;
    private int horizontal;
    private int vertical;

    private int maxBounces;

    private Vec3 backVector;
    private Vec3 sideVector;
    private Vec3 upVector;

    private double leftBorder;
    private double rightBorder;
    private double topBorder;
    private double bottomBorder;

    private double fov;
    private Vec3 backVectorFOV;

    public Camera(Vec3 position) {
        this.position = position;
    }

    public Camera() {

    }

    public Camera(Vec3 position, Vec3 lookAt, Vec3 up, int angle, int horizontal, int vertical, int maxBounces) {
        this.position = position;
        this.lookAt = lookAt;
        this.up = up;
        this.angle = angle;
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.maxBounces = maxBounces;

        backVector = position.subtract(lookAt).normalize();
        sideVector = up.crossProduct(backVector).normalize();
        upVector = backVector.crossProduct(sideVector).normalize();

        leftBorder = horizontal/2.0*-1;
        rightBorder = horizontal/2.0;
        topBorder = vertical/2.0;
        bottomBorder = vertical/2.0*-1;

        fov = topBorder/Math.tan(Math.PI/4);
        backVectorFOV = backVector.scalarMultiplication(fov*-1);
    }

    public Vec3 getPosition() {
        return position;
    }

    public void setPosition(Vec3 position) {
        this.position = position;
    }

    public Vec3 getLookAt() {
        return lookAt;
    }

    public void setLookAt(Vec3 lookAt) {
        this.lookAt = lookAt;
    }

    public Vec3 getUp() {
        return up;
    }

    public void setUp(Vec3 up) {
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

    public Vec3 getBackVector() {
        return backVector;
    }

    public void setBackVector(Vec3 backVector) {
        this.backVector = backVector;
    }

    public Vec3 getSideVector() {
        return sideVector;
    }

    public void setSideVector(Vec3 sideVector) {
        this.sideVector = sideVector;
    }

    public Vec3 getUpVector() {
        return upVector;
    }

    public void setUpVector(Vec3 upVector) {
        this.upVector = upVector;
    }

    public double getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(double leftBorder) {
        this.leftBorder = leftBorder;
    }

    public double getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(double rightBorder) {
        this.rightBorder = rightBorder;
    }

    public double getTopBorder() {
        return topBorder;
    }

    public void setTopBorder(double topBorder) {
        this.topBorder = topBorder;
    }

    public double getBottomBorder() {
        return bottomBorder;
    }

    public void setBottomBorder(double bottomBorder) {
        this.bottomBorder = bottomBorder;
    }

    public double getFov() {
        return fov;
    }

    public void setFov(double fov) {
        this.fov = fov;
    }

    public Vec3 getBackVectorFOV() {
        return backVectorFOV;
    }

    public void setBackVectorFOV(Vec3 backVectorFOV) {
        this.backVectorFOV = backVectorFOV;
    }
}
