package object;

import basics.MaterialSolid;
import basics.MaterialTextured;
import basics.transformations.Transformations;

import java.util.List;

public class Mesh implements Surface{
    private String name;
    private MaterialTextured materialTextured;
    private MaterialSolid materialSolid;
    private List<Transformations> transformations;

    public Mesh(String name) {
        this.name = name;
    }

    public Mesh() {
    }

    public Mesh(String name, MaterialTextured materialTextured, List<Transformations> transformations) {
        this.name = name;
        this.materialTextured = materialTextured;
        this.transformations = transformations;
    }

    public Mesh(String name, MaterialSolid materialSolid, List<Transformations> transformations) {
        this.name = name;
        this.materialSolid = materialSolid;
        this.transformations = transformations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaterialTextured getMaterialTextured() {
        return materialTextured;
    }

    public void setMaterialTextured(MaterialTextured materialTextured) {
        this.materialTextured = materialTextured;
    }

    public MaterialSolid getMaterialSolid() {
        return materialSolid;
    }

    public void setMaterialSolid(MaterialSolid materialSolid) {
        this.materialSolid = materialSolid;
    }

    public List<Transformations> getTransformations() {
        return transformations;
    }

    public void setTransformations(List<Transformations> transformations) {
        this.transformations = transformations;
    }
}
