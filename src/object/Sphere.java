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

    public void setMaterialSolid(MaterialSolid materialSolid) {
        this.materialSolid = materialSolid;
    }

    @Override
    public double calculateIntersection(Vec3 position, Vec3 direction) {
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
