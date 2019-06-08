package output;

import basics.Camera;
import basics.Vec3;
import object.Surface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Image {

    private String outputFileName;
    private BufferedImage bufferedImage;

    private Scene scene;

    public Image(String inputFileName){
        scene = new Scene(inputFileName);
    }

    public void create(){
        scene.setAll();
        outputFileName = scene.getOutputFileName();
        int height = scene.getCamera().getVertical();
        int width = scene.getCamera().getHorizontal();
        private basics.Color [][] pixels = new basics.Color [width][height];

        Camera camera = scene.getCamera();
        List<Surface> surfaces = scene.getSurfaces();

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Color white = new Color(Float.parseFloat("1.0"),Float.parseFloat("1.0"), Float.parseFloat("1.0"));

        for(int i = 0; i < width; ++i){
            for(int j = 0; j < height; ++j){
//                bufferedImage.setRGB(i, j, white.getRGB());

                double scalarHorizontal = camera.getRightBorder() * (i+0.5)/camera.getHorizontal();
                double scalarVertical = camera.getTopBorder() * (i+0.5)/camera.getVertical();

                Vec3 directionHelperHorizontal = camera.getSideVector().scalarMultiplication(scalarHorizontal);
                Vec3 directionHelperVertical = camera.getUpVector().scalarMultiplication(scalarVertical);
                Vec3 direction = directionHelperHorizontal.add(directionHelperVertical);
                direction = direction.add(camera.getBackVectorFOV()).normalize();


                Surface surface = null;
                double closestIntersectionPoint = Double.MAX_VALUE;

                for(int k = 0; k < surfaces.size(); ++i){
                    double currentIntersectionPoint = surface.calculateIntersection(camera.getPosition(), direction);
                    if(currentIntersectionPoint > 0){
                        if(currentIntersectionPoint < closestIntersectionPoint){
                            surface = surfaces.get(k);
                            closestIntersectionPoint = currentIntersectionPoint;
                        }
                    }
                }

                if(surface != null){
                    pixels[i][j] = surface.getMaterialSolid().getColor();
                }
            }
        }

        File output = new File(outputFileName);
        try {
            ImageIO.write(bufferedImage, "png", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
