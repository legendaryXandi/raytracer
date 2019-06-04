package basics;

public class MaterialTextured {

    private String name;
    private Phong phong;
    private double reflectance;
    private double transmittance;
    private double refraction;

    public MaterialTextured(String name, Phong phong, double reflectance, double transmittance, double refraction) {
        this.name = name;
        this.phong = phong;
        this.reflectance = reflectance;
        this.transmittance = transmittance;
        this.refraction = refraction;
    }

    public MaterialTextured() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public double getReflectance() {
        return reflectance;
    }

    public void setReflectance(double reflectance) {
        this.reflectance = reflectance;
    }

    public double getTransmittance() {
        return transmittance;
    }

    public void setTransmittance(double transmittance) {
        this.transmittance = transmittance;
    }

    public double getRefraction() {
        return refraction;
    }

    public void setRefraction(double refraction) {
        this.refraction = refraction;
    }
}
