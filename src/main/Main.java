package main;

import xml.Scene;

public class Main {

    public static void main(String args[]){

        Scene scene = new Scene("src/scenes/example1.xml");
        scene.setAll();
        System.out.println("position: ");
        System.out.println(scene.getCamera().getPosition().getX());
        System.out.println(scene.getCamera().getPosition().getY());
        System.out.println(scene.getCamera().getPosition().getZ());
        System.out.println("lookAt: ");
        System.out.println(scene.getCamera().getLookAt().getX());
        System.out.println(scene.getCamera().getLookAt().getY());
        System.out.println(scene.getCamera().getLookAt().getZ());
        System.out.println("up: ");
        System.out.println(scene.getCamera().getUp().getX());
        System.out.println(scene.getCamera().getUp().getY());
        System.out.println(scene.getCamera().getUp().getZ());
        System.out.println("horizontal_fov: ");
        System.out.println(scene.getCamera().getAngle());
        System.out.println("resolution: ");
        System.out.println(scene.getCamera().getHorizontal());
        System.out.println(scene.getCamera().getVertical());
        System.out.println("max_bounces");
        System.out.println(scene.getCamera().getMaxBounces());
        System.out.println("lights: ");
        for(int i = 0; i < scene.getLights().size(); ++i){
            System.out.println(scene.getLights().get(i));
        }
    }
}
