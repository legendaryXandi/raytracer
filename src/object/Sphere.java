package object;

import basics.Vec3;
import basics.MaterialSolid;
import basics.MaterialTextured;
import basics.transformations.Transformations;

import java.util.List;

public class Sphere implements Surface{
    private double radius;
    private Vec3 position;
    private MaterialSolid materialSolid;
    private MaterialTextured materialTextured;
    private List<Transformations> transformations;

    public Sphere(double radius, Vec3 position) {
        this.radius = radius;
        this.position = position;
    }

    public Sphere() {
    }

    public Sphere(double radius, Vec3 position, MaterialSolid materialSolid, List<Transformations> transformations) {
        this.radius = radius;
        this.position = position;
        this.materialSolid = materialSolid;
        this.transformations = transformations;
    }

    public Sphere(double radius, Vec3 position, MaterialTextured materialTextured, List<Transformations> transformations) {
        this.radius = radius;
        this.position = position;
        this.materialTextured = materialTextured;
        this.transformations = transformations;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Vec3 getPosition() {
        return position;
    }

    public void setPosition(Vec3 position) {
        this.position = position;
    }

    public MaterialSolid getMaterialSolid() {
        return materialSolid;
    }

    @Override
    public int calculatePhongColor(Vec3 point, Vec3 cameraOrigin) {
        return materialSolid.calculatePhongColor(point, cameraOrigin);
    }

    public void setMaterialSolid(MaterialSolid materialSolid) {
        this.materialSolid = materialSolid;
    }

    @Override
    public double calculateIntersection(Vec3 position, Vec3 direction) {
        //ray(parameter) = eye + parameter*direction
        //distance between point and center have to be equal to radius.
        //
        //use Mitternachtsformel to solve it

        double a = direction.vecProduct(direction);
        double b = 2*direction.vecProduct(position.subtract(this.position));
        double c = position.subtract(this.position).vecProduct(position.subtract(this.position)) - Math.pow(radius,2);

        int numberOfResults = 0;
        double result = 0;
        double resultPositive = 0;
        double resultNegative = 0;

        if((Math.pow(b,2)-(4*a*c)) == 0){
            result = -b/(2*a);
            numberOfResults = 1;
        }
        else if((Math.pow(b,2)-(4*a*c)) > 0){

            resultPositive = (-b+(Math.sqrt(Math.pow(b,2)-(4*a*c))))/(2*a);
            resultNegative = (-b-(Math.sqrt(Math.pow(b,2)-(4*a*c))))/(2*a);
            numberOfResults = 2;
        }

        //no intersection
        if (numberOfResults == 0){
            return Double.MAX_VALUE;
        }//one intersection
        else if(numberOfResults == 1){
            return result;
        }
        //two intersections
        else {
            if(resultPositive < 0 && resultNegative < 0){
                return Double.MAX_VALUE;
            }
            else if (resultPositive < 0){
                return resultNegative;
            }
            else if(resultNegative < 0){
                return resultPositive;
            }
            else{
                if(resultPositive < resultNegative){
                    return resultPositive;
                }
                else if(resultNegative < resultPositive){
                    return resultNegative;
                }
            }
        }

        return 0;
    }

    public MaterialTextured getMaterialTextured() {
        return materialTextured;
    }

    public void setMaterialTextured(MaterialTextured materialTextured) {
        this.materialTextured = materialTextured;
    }

    public List<Transformations> getTransformations() {
        return transformations;
    }

    public void setTransformations(List<Transformations> transformations) {
        this.transformations = transformations;
    }

    public Vec3 calculateNormal(Vec3 point){
        return point.subtract(position).normalize();
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                ", position=" + position +
                ", materialSolid=" + materialSolid +
                ", materialTextured=" + materialTextured +
                ", transformations=" + transformations +
                '}';
    }
}
