package main;

import basics.Camera;
import basics.Vec3;
import object.Sphere;
import output.Image;
import output.Scene;

public class Main {

    public static void main(String args[]){

        if(args.length > 0){
            String fileName = args[0];

            Image image = new Image("src/scenes/" + fileName);
            image.create();
        }
        else{
            System.out.println("no file name in parameter");
        }



    }
}
