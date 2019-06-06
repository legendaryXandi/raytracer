package basics;

public class Phong {
    private double ka;
    private double kd;
    private double ks;
    private double exponent;

    public Phong(double ka, double kd, double ks, double exponent) {
        this.ka = ka;
        this.kd = kd;
        this.ks = ks;
        this.exponent = exponent;
    }

    public Phong() {
    }

    public double getKa() {
        return ka;
    }

    public void setKa(double ka) {
        this.ka = ka;
    }

    public double getKd() {
        return kd;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }

    public double getKs() {
        return ks;
    }

    public void setKs(double ks) {
        this.ks = ks;
    }

    public double getExponent() {
        return exponent;
    }

    public void setExponent(double exponent) {
        this.exponent = exponent;
    }
}
