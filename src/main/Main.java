package main;

import basics.Color;
import basics.light.AmbientLight;
import basics.light.Light;
import output.Scene;
import xml.XMLParser;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){

        XMLParser xmlParser = new XMLParser("src/scenes/example1.xml");
        xmlParser.setAll();
        System.out.println("position: ");
        System.out.println(xmlParser.getCamera().getPosition().getX());
        System.out.println(xmlParser.getCamera().getPosition().getY());
        System.out.println(xmlParser.getCamera().getPosition().getZ());
        System.out.println("lookAt: ");
        System.out.println(xmlParser.getCamera().getLookAt().getX());
        System.out.println(xmlParser.getCamera().getLookAt().getY());
        System.out.println(xmlParser.getCamera().getLookAt().getZ());
        System.out.println("up: ");
        System.out.println(xmlParser.getCamera().getUp().getX());
        System.out.println(xmlParser.getCamera().getUp().getY());
        System.out.println(xmlParser.getCamera().getUp().getZ());
        System.out.println("horizontal_fov: ");
        System.out.println(xmlParser.getCamera().getAngle());
        System.out.println("resolution: ");
        System.out.println(xmlParser.getCamera().getHorizontal());
        System.out.println(xmlParser.getCamera().getVertical());
        System.out.println("max_bounces");
        System.out.println(xmlParser.getCamera().getMaxBounces());
        System.out.println("lights: ");
        for(int i = 0; i < xmlParser.getLights().size(); ++i){
            System.out.println(xmlParser.getLights().get(i));
        }
    }
}
