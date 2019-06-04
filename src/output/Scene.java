package output;

import basics.Camera;
import basics.Color;
import basics.light.Light;
import object.Surface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Scene {
    private Color backgroundColor = new Color();
    private Camera camera = new Camera();
    private List<Light> lights;
    private List<Surface> surfaces;

    private int width = 50;
    private int height = 50;
    private String outputFileName = "output.jpg";

    private BufferedImage bufferedImage;

    public Scene(){
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < width; ++i){
            for (int j = 0; j < height; ++j){
//                bufferedImage.setRGB(i, j, Color.BLACK.getRGB());
            }
        }
    }

    public Scene(int width, int height){
        this.width = width;
        this.height = height;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < width; ++i){
            for (int j = 0; j < height; ++j){
//                bufferedImage.setRGB(i, j, Color.BLACK.getRGB());
            }
        }
    }

    public void writeToFile(){
        File output = new File(outputFileName);
        try {
            ImageIO.write(bufferedImage, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
