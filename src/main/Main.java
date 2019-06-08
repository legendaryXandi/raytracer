package main;

import basics.Camera;
import basics.Vec3;
import object.Sphere;
import output.Image;
import output.Scene;

public class Main {

    public static void main(String args[]){

        Image image = new Image("src/scenes/example2.xml");
        image.create();

        /*Sphere s = new Sphere();
        s.setPosition(new Vec3(0,0,0));
        s.setRadius(5);
        System.out.println(s.calculateIntersection(new Vec3(0,0,-10), new Vec3(0,0,1)));*/

        Vec3 v1 = new Vec3(1,2,3);
        Vec3 v2 = new Vec3(4,5,6);

        Vec3 result = v1.add(v2);
        System.out.println(result.getX() + "|" + result.getY() + "|" + result.getZ());

        result = v1.scalarMultiplication(3);
        System.out.println(result.getX() + "|" + result.getY() + "|" + result.getZ());

        Double resultDouble = v1.dotProduct(v2);
        System.out.println(resultDouble);

        result = v1.crossProduct(v2);
        System.out.println(result.getX() + "|" + result.getY() + "|" + result.getZ());

        result = v1.normalize();
        System.out.println(result.getX() + "|" + result.getY() + "|" + result.getZ());

        resultDouble = v1.vecProduct(v2);
        System.out.println(resultDouble);

        Camera camera = new Camera(new Vec3(0,0,-10),new Vec3(0,0,0), new Vec3(0,1,0),45,512,512,50);

        System.out.println(camera.getSideVector().getX() + "|" + camera.getSideVector().getY() + "|" + camera.getSideVector().getZ());

        int anteil = 360/45/2;
//        System.out.println(anteil);
        System.out.println(Math.PI/(360/45/2));
        System.out.println(Math.PI/4);
        System.out.println(0.5*255);
    }
}
