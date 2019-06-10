package basics;

import basics.light.AmbientLight;
import basics.light.Light;
import basics.light.ParallelLight;
import object.Sphere;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialSolid {

    private Color color;
    private Phong phong;
    private double reflectance;
    private double transmittance;
    private double refraction;

    private Sphere sphere;

    public Sphere getSphere() {
        return sphere;
    }

    public void setSphere(Sphere sphere) {
        this.sphere = sphere;
    }

    private List<Light> lights = new ArrayList<>();

    public MaterialSolid(Color color, Phong phong, double reflectance, double transmittance, double refraction) {
        this.color = color;
        this.phong = phong;
        this.reflectance = reflectance;
        this.transmittance = transmittance;
        this.refraction = refraction;
    }

    public MaterialSolid() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public int calculatePhongColor(Vec3 point, Vec3 cameraOrigin) {
        int finalR = 0;
        int finalG = 0;
        int finalB = 0;

        int ambientR = 0;
        int ambientG = 0;
        int ambientB = 0;

        int diffuseR = 0;
        int diffuseG = 0;
        int diffuseB = 0;

        int specularR = 0;
        int specularG = 0;
        int specularB = 0;

        Vec3 lightVector = new Vec3();
        for(Light currentLight : lights){
            if(currentLight instanceof ParallelLight){
                lightVector.setX(currentLight.getDirection().getX()*-1);
                lightVector.setY(currentLight.getDirection().getY()*-1);
                lightVector.setZ(currentLight.getDirection().getZ()*-1);

                Vec3 normalVector = sphere.calculateNormal(point);
                double diffuseIntensity = Math.max(normalVector.vecProduct(lightVector),0);

                /*diffuseR = (int) (color.getRed()*phong.getKd()*diffuseIntensity);
                diffuseG = (int) (color.getGreen()*phong.getKd()*diffuseIntensity);
                diffuseB = (int) (color.getBlue()*phong.getKd()*diffuseIntensity);*/

                diffuseR = (int) (color.getRed()*phong.getKd()*diffuseIntensity/2);
                diffuseG = (int) (color.getGreen()*phong.getKd()*diffuseIntensity/2);
                diffuseB = (int) (color.getBlue()*phong.getKd()*diffuseIntensity/2);


                Vec3 reflectionHelper = normalVector.scalarMultiplication(diffuseIntensity*2);
                Vec3 reflectionVector = reflectionHelper.subtract(lightVector).normalize();
                Vec3 reflectionViewDirection = cameraOrigin.subtract(point).normalize();
                double reflectionScalar = Math.max(reflectionVector.vecProduct(reflectionViewDirection),0);
                double specularIntensity = Math.pow(reflectionScalar,phong.getExponent());

                specularR = (int) (currentLight.getColor().getRed()*phong.getKs()*specularIntensity);
                specularG = (int) (currentLight.getColor().getGreen()*phong.getKs()*specularIntensity);
                specularB = (int) (currentLight.getColor().getBlue()*phong.getKs()*specularIntensity);

                /*specularR = (int) (color.getRed()*phong.getKs()*specularIntensity);
                specularG = (int) (color.getGreen()*phong.getKs()*specularIntensity);
                specularB = (int) (color.getBlue()*phong.getKs()*specularIntensity);
*/

                double distanceFromLightToPoint = lightVector.subtract(point).dotProduct(lightVector);




            }
            if(currentLight instanceof AmbientLight){
                ambientR = (int) (color.getRed() * phong.getKa());
                ambientG = (int) (color.getGreen() * phong.getKa());
                ambientB = (int) (color.getBlue() * phong.getKa());
            }

        }
        finalR = ambientR + diffuseR + specularR;
        finalG = ambientG + diffuseG + specularG;
        finalB = ambientB + diffuseB + specularB;
        if(finalR>255){
            finalR = 255;
        }
        if(finalR<0){
            finalR = 0;
        }
        if(finalG>255){
            finalG = 255;
        }
        if(finalG<0){
            finalG = 0;
        }
        if(finalB>255){
            finalB = 255;
        }
        if(finalB<0){
            finalB = 0;
        }


//        System.out.println(finalR + "|" + finalG + "|" + finalB);
        Color outputColor = new Color(finalR, finalG, finalB);
        return outputColor.getRGB();
    }

    public List<Light> getLights() {
        return lights;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }
}
