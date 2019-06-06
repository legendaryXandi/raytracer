package output;

import basics.Camera;
import basics.Color;
import basics.light.Light;
import object.Surface;
import xml.XMLParser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Scene {

    private int width = 50;
    private int height = 50;
    private String inputFileName;
    private String outputFileName = "output.jpg";
    private XMLParser xmlParser;

    private BufferedImage bufferedImage;

    public Scene(String inputFileName, String outputFileName){
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.xmlParser = new XMLParser(inputFileName);

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
