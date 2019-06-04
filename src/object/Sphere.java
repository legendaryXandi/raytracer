package object;

import basics.Coordinate;
import basics.MaterialSolid;
import basics.MaterialTextured;
import basics.transformations.Transformations;

import java.util.List;

public class Sphere implements Surface{
    private double radius;
    private Coordinate position;
    private MaterialSolid materialSolid;
    private MaterialTextured materialTextured;
    private List<Transformations> transformations;

    public Sphere() {
    }

    public Sphere(double radius, Coordinate position, MaterialSolid materialSolid, List<Transformations> transformations) {
        this.radius = radius;
        this.position = position;
        this.materialSolid = materialSolid;
        this.transformations = transformations;
    }

    public Sphere(double radius, Coordinate position, MaterialTextured materialTextured, List<Transformations> transformations) {
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

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public MaterialSolid getMaterialSolid() {
        return materialSolid;
    }

    public void setMaterialSolid(MaterialSolid materialSolid) {
        this.materialSolid = materialSolid;
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
}
