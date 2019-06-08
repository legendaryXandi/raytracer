package main;

import basics.Vec3;
import output.Image;
import output.Scene;

public class Main {

    public static void main(String args[]){

        Image image = new Image("src/scenes/example1.xml");
        image.create();

        Vec3 vec3 = new Vec3(0,1,0);
        vec3.normalize();
    }
}
