package basics;

public class Phong {
    private int ka;
    private int kd;
    private int exponent;

    public Phong(int ka, int kd, int exponent) {
        this.ka = ka;
        this.kd = kd;
        this.exponent = exponent;
    }

    public Phong() {
    }

    public int getKa() {
        return ka;
    }

    public void setKa(int ka) {
        this.ka = ka;
    }

    public int getKd() {
        return kd;
    }

    public void setKd(int kd) {
        this.kd = kd;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }
}
