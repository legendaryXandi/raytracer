package output;

import basics.Camera;
import basics.Ray;
import basics.Vec3;
import object.Surface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        int height = scene.getCamera().getHorizontal();
        int width = scene.getCamera().getVertical();

        Camera camera = scene.getCamera();
        List<Surface> surfaces = scene.getSurfaces();

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < width; ++i){
            for(int j = 0; j < height; ++j){

                double scalarHorizontal = camera.getLeftBorder() + (camera.getRightBorder() - camera.getLeftBorder()) * (i+0.5)/width;
                double scalarVertical = camera.getTopBorder() + (camera.getBottomBorder() - camera.getTopBorder()) * (j+0.5)/height;


                Vec3 directionHelperHorizontal = camera.getSideVector().scalarMultiplication(scalarHorizontal);
                Vec3 directionHelperVertical = camera.getUpVector().scalarMultiplication(scalarVertical);
                Vec3 direction = directionHelperHorizontal.add(directionHelperVertical).add(camera.getBackVectorFOV());
                direction = direction.normalize();

                Ray currentRay = new Ray(camera.getPosition(), direction);

                Surface surface = null;
                double closestIntersectionPoint = Double.MAX_VALUE-1;

                for(int k = 0; k < surfaces.size(); ++k){
                    double currentIntersectionPoint = surfaces.get(k).calculateIntersection(camera.getPosition(), direction);
                    if(currentIntersectionPoint > 0){
                        if(currentIntersectionPoint < closestIntersectionPoint){
                            surface = surfaces.get(k);
                            closestIntersectionPoint = currentIntersectionPoint;
                        }
                    }
                }

                //kugel erwischt
                if(surface != null){
                    bufferedImage.setRGB(i,j, surface.calculatePhongColor(currentRay.getPointOnRay(closestIntersectionPoint), camera.getPosition()));
                }
                //hintergrund erwischt
                else{
                    bufferedImage.setRGB(i,j,scene.getBackgroundColor().getRGB());
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
