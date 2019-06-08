package output;

import basics.Camera;
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

        System.out.println(surfaces.get(0).getMaterialSolid().getColor());
        System.out.println(surfaces.get(1).getMaterialSolid().getColor());
        System.out.println(surfaces.get(2).getMaterialSolid().getColor());
//        Vec3 position, Vec3 lookAt, Vec3 up, int angle, int horizontal, int vertical, int maxBounces
//        Camera camera = new Camera(new Vec3(0,0,-10),new Vec3(0,0,0), new Vec3(0,1,0),45,512,512,50);
//        List<Surface> surfaces = new ArrayList<>();

        /*
        <sphere radius="1.0">
			<position x="-2.1" y="0.0" z="-3.0"/>
			<material_solid>
				<color r="0.17" g="0.18" b="0.50"/>
				<phong ka="0.3" kd="0.9" ks="1.0" exponent="200"/>
				<reflectance r="0.0"/>
				<transmittance t="0.0"/>
				<refraction iof="2.3"/>
			</material_solid>
		</sphere>
         */

        /*Sphere sphere = new Sphere();
        sphere.setRadius(1);
        sphere.setPosition(new Vec3(0,0,0));
        surfaces.add(sphere);*/

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < width; ++i){
            for(int j = 0; j < height; ++j){
//                bufferedImage.setRGB(i, j, Color.WHITE.getRGB());


//                double scalarHorizontal = camera.getRightBorder() * (i+0.5)/camera.getHorizontal();
//                double scalarVertical = camera.getBottomBorder() * (j+0.5)/camera.getVertical();


                double scalarHorizontal = camera.getLeftBorder() + (camera.getRightBorder() - camera.getLeftBorder()) * (i+0.5)/width;
                double scalarVertical = camera.getTopBorder() + (camera.getBottomBorder() - camera.getTopBorder()) * (j+0.5)/height;


                Vec3 directionHelperHorizontal = camera.getSideVector().scalarMultiplication(scalarHorizontal);
                Vec3 directionHelperVertical = camera.getUpVector().scalarMultiplication(scalarVertical);
                Vec3 direction = directionHelperHorizontal.add(directionHelperVertical).add(camera.getBackVectorFOV());
                direction = direction.normalize();


                /*Vec3 directionHelper = new Vec3(0,0,0).add(camera.getSideVector().scalarMultiplication(scalarHorizontal), camera.getUpVector().scalarMultiplication(scalarVertical), camera.getBackVectorFOV());
                Vec3 direction3 = directionHelper.normalize();*/

/*
                Surface surface = null;
                double t = Double.MAX_VALUE-1;
                for(Surface o : surfaces){
                    double t2 = o.calculateIntersection(camera.getPosition(), direction);
                    if(t2 > 0 && t2 < t){
                        surface = o;
                        t = t2;
                    }
                }
                if(surface != null){
                    bufferedImage.setRGB(i,j, Color.WHITE.getRGB());
                }
                else{
                    bufferedImage.setRGB(i,j, Color.BLACK.getRGB());
                }*/


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
                    bufferedImage.setRGB(i,j, surface.getMaterialSolid().getColor().getRGB());
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
