package basics;

public class Vec3 {
    private double x;
    private double y;
    private double z;

    public Vec3(){

    }

    public Vec3(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Vec3 add(Vec3 vec3){
        return new Vec3(this.x + vec3.x, this.y + vec3.y, this.z + vec3.z);
    }

    public Vec3 subtract(Vec3 vec3){
        return new Vec3(this.x - vec3.x, this.y - vec3.y, this.z - vec3.z);
    }

    public double dotProduct(Vec3 right){
        return Math.sqrt(this.getX()*right.getX()
                +this.getY()*right.getY()
                +this.getZ()*right.getZ());
    }

    public Vec3 crossProduct(Vec3 right){
        return new Vec3(this.y * right.getZ() - this.z * right.getY(),
                        this.z * right.getX() - this.x * right.getZ(),
                        this.x * right.getY() - this.y * right.getX());
    }

    public Vec3 scalarMultiplication(double scalar){
        return new Vec3(this.x*scalar, this.y*scalar, this.z*scalar);
    }

    public Vec3 normalize(){
        Double lengthOfVector = Math.sqrt(Math.pow(this.getX(),2)
                +Math.pow(this.getY(),2)
                +Math.pow(this.getZ(),2));

        if(lengthOfVector != 0.0){
            return new Vec3(this.x/lengthOfVector, this.y/lengthOfVector, this.z/lengthOfVector);
        }

        return new Vec3(0,0,0);
    }
}
