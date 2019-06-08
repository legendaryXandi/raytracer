package basics;

public class Ray {
    private Vec3 start;
    private Vec3 direction;

    public Ray(Vec3 start, Vec3 direction){
        this.start = start;
        this.direction = direction;
    }

    public Ray(){

    }

    public Vec3 getPointOnRay(double parameter){
        Vec3 temp = direction.scalarMultiplication(parameter);
        return start.add(temp);
    }
}
