package xml;

import basics.*;
import basics.light.*;
import basics.transformations.*;
import object.Mesh;
import object.Sphere;
import object.Surface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scene {

    private String outputFileName;

    private Color backgroundColor = new Color();
    private Camera camera = new Camera();
    private List<Light> lights = new ArrayList<>();
    private List<Surface> surfaces = new ArrayList<>();
    private List<Transformations> transformations = new ArrayList<>();

    private Document xmlDocument;

    public Scene(String inputFilename) {

        File file = new File(inputFilename);
        DocumentBuilderFactory factory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder builder = null;


            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }

        try {
            xmlDocument = builder.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setAll(){
        setOutputFileName();
        setBackgroundColor();
        setCamera();
        setLights();
        setSurfaces();
    }


    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    private void setBackgroundColor() {
        Double r = Double.parseDouble(xmlDocument
                .getElementsByTagName("background_color")
                .item(0)
                .getAttributes()
                .getNamedItem("r")
                .getNodeValue());
        Double g = Double.parseDouble(xmlDocument
                .getElementsByTagName("background_color")
                .item(0)
                .getAttributes()
                .getNamedItem("g")
                .getNodeValue());
        Double b = Double.parseDouble(xmlDocument
                .getElementsByTagName("background_color")
                .item(0)
                .getAttributes()
                .getNamedItem("b")
                .getNodeValue());

        backgroundColor = new Color(r,g,b);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    private void setCamera() {
        Double positionX = Double.parseDouble(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                        .getElementsByTagName("position")
                        .item(0).getAttributes().getNamedItem("x").getNodeValue());
        Double positionY = Double.parseDouble(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("position")
                .item(0).getAttributes().getNamedItem("y").getNodeValue());
        Double positionZ = Double.parseDouble(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("position")
                .item(0).getAttributes().getNamedItem("z").getNodeValue());

        Coordinate position = new Coordinate(positionX, positionY, positionZ);

        Double lookAtX = Double.parseDouble(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("lookat")
                .item(0).getAttributes().getNamedItem("x").getNodeValue());
        Double lookAtY = Double.parseDouble(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("lookat")
                .item(0).getAttributes().getNamedItem("y").getNodeValue());
        Double lookAtZ = Double.parseDouble(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("lookat")
                .item(0).getAttributes().getNamedItem("z").getNodeValue());

        Coordinate lookAt = new Coordinate(lookAtX, lookAtY, lookAtZ);

        Double upX = Double.parseDouble(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("up")
                .item(0).getAttributes().getNamedItem("x").getNodeValue());
        Double upY = Double.parseDouble(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("up")
                .item(0).getAttributes().getNamedItem("y").getNodeValue());
        Double upZ = Double.parseDouble(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("up")
                .item(0).getAttributes().getNamedItem("z").getNodeValue());

        Coordinate up = new Coordinate(upX, upY, upZ);

        int horizontalFov = Integer.parseInt(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("horizontal_fov")
                .item(0).getAttributes().getNamedItem("angle").getNodeValue());

        int resolutionHorizontal = Integer.parseInt(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("resolution")
                .item(0).getAttributes().getNamedItem("horizontal").getNodeValue());

        int resolutionVertical = Integer.parseInt(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("resolution")
                .item(0).getAttributes().getNamedItem("vertical").getNodeValue());

        int maxBounces = Integer.parseInt(((Element)xmlDocument
                .getElementsByTagName("camera")
                .item(0))
                .getElementsByTagName("max_bounces")
                .item(0).getAttributes().getNamedItem("n").getNodeValue());

        camera = new Camera(position, lookAt, up, horizontalFov, resolutionHorizontal, resolutionVertical, maxBounces);
    }

    public List<Light> getLights() {
        return lights;
    }

    public void setOutputFileName(){
        outputFileName = xmlDocument
                .getElementsByTagName("scene")
                .item(0)
                .getAttributes()
                .getNamedItem("output_file")
                .getNodeValue();

        System.out.println(outputFileName);

    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    private void setLights() {
        if(xmlDocument.getElementsByTagName("ambient_light").getLength()>0){
            Double r = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("ambient_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("r").getNodeValue());
            Double g = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("ambient_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("g").getNodeValue());
            Double b = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("ambient_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("b").getNodeValue());

            Color ambientColor = new Color(r,g,b);
            AmbientLight ambientLight = new AmbientLight(ambientColor);
            lights.add(ambientLight);
        }
        if(xmlDocument.getElementsByTagName("parallel_light").getLength()>0){
            Double r = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("parallel_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("r").getNodeValue());
            Double g = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("parallel_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("g").getNodeValue());
            Double b = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("parallel_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("b").getNodeValue());

            Color parallelColor = new Color(r,g,b);

            Double x = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("parallel_light")
                    .item(0))
                    .getElementsByTagName("direction")
                    .item(0).getAttributes().getNamedItem("x").getNodeValue());
            Double y = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("parallel_light")
                    .item(0))
                    .getElementsByTagName("direction")
                    .item(0).getAttributes().getNamedItem("y").getNodeValue());
            Double z = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("parallel_light")
                    .item(0))
                    .getElementsByTagName("direction")
                    .item(0).getAttributes().getNamedItem("z").getNodeValue());

            Coordinate direction = new Coordinate(x,y,z);
            ParallelLight parallelLight = new ParallelLight(parallelColor, direction);
            lights.add(parallelLight);
        }
        if(xmlDocument.getElementsByTagName("point_light").getLength()>0){
            Double r = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("point_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("r").getNodeValue());
            Double g = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("point_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("g").getNodeValue());
            Double b = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("point_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("b").getNodeValue());

            Color pointLightColor = new Color(r,g,b);

            Double x = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("point_light")
                    .item(0))
                    .getElementsByTagName("position")
                    .item(0).getAttributes().getNamedItem("x").getNodeValue());
            Double y = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("point_light")
                    .item(0))
                    .getElementsByTagName("position")
                    .item(0).getAttributes().getNamedItem("y").getNodeValue());
            Double z = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("point_light")
                    .item(0))
                    .getElementsByTagName("position")
                    .item(0).getAttributes().getNamedItem("z").getNodeValue());

            Coordinate position = new Coordinate(x,y,z);
            PointLight pointLight = new PointLight(pointLightColor, position);
            lights.add(pointLight);
        }
        if(xmlDocument.getElementsByTagName("spot_light").getLength()>0){
            Double r = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("r").getNodeValue());
            Double g = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("g").getNodeValue());
            Double b = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("color")
                    .item(0).getAttributes().getNamedItem("b").getNodeValue());

            Color spotLightColor = new Color(r,g,b);

            Double x = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("position")
                    .item(0).getAttributes().getNamedItem("x").getNodeValue());
            Double y = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("position")
                    .item(0).getAttributes().getNamedItem("y").getNodeValue());
            Double z = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("position")
                    .item(0).getAttributes().getNamedItem("z").getNodeValue());

            Coordinate position = new Coordinate(x,y,z);

            Double directionX = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("direction")
                    .item(0).getAttributes().getNamedItem("x").getNodeValue());
            Double directionY = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("direction")
                    .item(0).getAttributes().getNamedItem("y").getNodeValue());
            Double directionZ = Double.parseDouble(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("direction")
                    .item(0).getAttributes().getNamedItem("z").getNodeValue());

            Coordinate direction = new Coordinate(directionX, directionY, directionZ);

            int alpha1 = Integer.parseInt(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("fallof")
                    .item(0).getAttributes().getNamedItem("alpha1").getNodeValue());
            int alpha2 = Integer.parseInt(((Element)xmlDocument
                    .getElementsByTagName("spot_light")
                    .item(0))
                    .getElementsByTagName("fallof")
                    .item(0).getAttributes().getNamedItem("alpha2").getNodeValue());

            Fallof fallof = new Fallof(alpha1, alpha2);
            SpotLight spotLight = new SpotLight(spotLightColor, position, direction, fallof);
            lights.add(spotLight);
        }
    }

    public List<Surface> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(List<Surface> surfaces) {
        this.surfaces = surfaces;
    }

    private void setSurfaces() {

        int sphereCount = 0;
        int meshCount = 0;

        for(int i = 0; i < xmlDocument.getElementsByTagName("surfaces").item(0).getChildNodes().getLength(); ++i){
            if (xmlDocument.getElementsByTagName("surfaces")
                    .item(0).getChildNodes().item(i)
                    .getNodeName().equals("sphere")) {

                Double radius = Double.parseDouble(((Element)xmlDocument
                        .getElementsByTagName("sphere")
                        .item(sphereCount))
                        .getAttributes()
                        .getNamedItem("radius")
                        .getNodeValue());

                Double positionX = Double.parseDouble(((Element)xmlDocument
                        .getElementsByTagName("sphere")
                        .item(sphereCount))
                        .getElementsByTagName("position")
                        .item(0).getAttributes().getNamedItem("x").getNodeValue());
                Double positionY = Double.parseDouble(((Element)xmlDocument
                        .getElementsByTagName("sphere")
                        .item(sphereCount))
                        .getElementsByTagName("position")
                        .item(0).getAttributes().getNamedItem("y").getNodeValue());
                Double positionZ = Double.parseDouble(((Element)xmlDocument
                        .getElementsByTagName("sphere")
                        .item(sphereCount))
                        .getElementsByTagName("position")
                        .item(0).getAttributes().getNamedItem("z").getNodeValue());

                Coordinate spherePosition = new Coordinate(positionX, positionY, positionZ);

                MaterialSolid materialSolid = null;
                MaterialTextured materialTextured = null;

                if (((Element) xmlDocument.getElementsByTagName("sphere")
                        .item(sphereCount)).getElementsByTagName("material_solid").getLength()>0){


                    Double r = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("color").item(0)
                            .getAttributes().getNamedItem("r").getNodeValue());
                    Double g = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("color").item(0)
                            .getAttributes().getNamedItem("g").getNodeValue());
                    Double b = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("color").item(0)
                            .getAttributes().getNamedItem("b").getNodeValue());

                    Color sphereColor = new Color(r,g,b);


                    Double ka = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("ka").getNodeValue());
                    Double kd = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("kd").getNodeValue());
                    Double ks = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("ks").getNodeValue());
                    Double exponent = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("exponent").getNodeValue());

                    Phong spherePhong = new Phong(ka, kd, ks, exponent);

                    Double reflectance = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("reflectance").item(0)
                            .getAttributes().getNamedItem("r").getNodeValue());

                    Double transmittance = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("transmittance").item(0)
                            .getAttributes().getNamedItem("t").getNodeValue());

                    Double refraction = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("refraction").item(0)
                            .getAttributes().getNamedItem("iof").getNodeValue());

//                    System.out.println("solid!");
                    materialSolid = new MaterialSolid(sphereColor, spherePhong, reflectance, transmittance, refraction);
                }
                if (((Element) xmlDocument.getElementsByTagName("sphere")
                        .item(sphereCount)).getElementsByTagName("material_textured").getLength()>0){
//                    System.out.println("textured!");

                    String name = (((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("texture").item(0)
                            .getAttributes().getNamedItem("name").getNodeValue());


                    Double ka = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("ka").getNodeValue());
                    Double kd = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("kd").getNodeValue());
                    Double ks = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("ks").getNodeValue());
                    Double exponent = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("exponent").getNodeValue());

                    Phong spherePhong = new Phong(ka, kd, ks, exponent);

                    Double reflectance = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("reflectance").item(0)
                            .getAttributes().getNamedItem("r").getNodeValue());

                    Double transmittance = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("transmittance").item(0)
                            .getAttributes().getNamedItem("t").getNodeValue());

                    Double refraction = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("sphere").item(sphereCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("refraction").item(0)
                            .getAttributes().getNamedItem("iof").getNodeValue());

                    materialTextured = new MaterialTextured(name, spherePhong, reflectance, transmittance, refraction);
                }


                if(((Element) xmlDocument.getElementsByTagName("sphere").item(sphereCount))
                        .getElementsByTagName("transform").getLength()>0){
                    for(int j = 0; j < ((Element) xmlDocument.getElementsByTagName("sphere")
                            .item(sphereCount)).getElementsByTagName("transform")
                            .item(0).getChildNodes().getLength(); ++j){

                        String currentTransformation = ((Element) ((Element) xmlDocument
                                .getElementsByTagName("sphere").item(sphereCount))
                                .getElementsByTagName("transform").item(0))
                                .getChildNodes().item(j).getNodeName();

                        if(currentTransformation.equals("translate") || currentTransformation.equals("scale")){
                            Double x = Double.parseDouble(((Element) ((Element) xmlDocument
                                    .getElementsByTagName("sphere").item(sphereCount))
                                    .getElementsByTagName("transform").item(0))
                                    .getChildNodes().item(j)
                                    .getAttributes().getNamedItem("x").getNodeValue());

                            Double y = Double.parseDouble(((Element) ((Element) xmlDocument
                                    .getElementsByTagName("sphere").item(sphereCount))
                                    .getElementsByTagName("transform").item(0))
                                    .getChildNodes().item(j)
                                    .getAttributes().getNamedItem("y").getNodeValue());

                            Double z = Double.parseDouble(((Element) ((Element) xmlDocument
                                    .getElementsByTagName("sphere").item(sphereCount))
                                    .getElementsByTagName("transform").item(0))
                                    .getChildNodes().item(j)
                                    .getAttributes().getNamedItem("z").getNodeValue());

                            if(currentTransformation.equals("translate")){
                                Coordinate translationCoordinate = new Coordinate(x,y,z);
                                Translation translation = new Translation(translationCoordinate);
                                transformations.add(translation);
                            }
                            else if(currentTransformation.equals("scale")){
                                Coordinate scaleCoordinate = new Coordinate(x,y,z);
                                Scaling scaling = new Scaling(scaleCoordinate);
                                transformations.add(scaling);
                            }


                        }

                        else if(currentTransformation.equals("rotateX") || currentTransformation.equals("rotateY") || currentTransformation.equals("rotateZ")){
                            Double theta = Double.parseDouble(((Element) ((Element) xmlDocument
                                    .getElementsByTagName("sphere").item(sphereCount))
                                    .getElementsByTagName("transform").item(0))
                                    .getChildNodes().item(j)
                                    .getAttributes().getNamedItem("theta").getNodeValue());

                            Transformations rotation;
                            switch (currentTransformation) {
                                case "rotateX": {
                                    rotation = new RotateX(theta);
                                    break;
                                }
                                case "rotateY": {
                                    rotation = new RotateY(theta);
                                    break;
                                }
                                case "rotateZ": {
                                    rotation = new RotateZ(theta);
                                    break;
                                }
                                default: rotation = new RotateX(theta);
                            }
                            transformations.add(rotation);
                        }
                    }
                }

                Sphere sphere = new Sphere(radius, spherePosition);

                if(materialSolid!= null){
                    sphere.setMaterialSolid(materialSolid);
                }
                if(materialTextured!= null){
                    sphere.setMaterialTextured(materialTextured);
                }
                if(transformations.size()>0){
                    sphere.setTransformations(transformations);
                }
                surfaces.add(sphere);
                System.out.println(sphere);

                transformations = new ArrayList<>();
                sphereCount++;
            }


            if (xmlDocument.getElementsByTagName("surfaces")
                    .item(0).getChildNodes().item(i)
                    .getNodeName().equals("mesh")) {

                String name = ((Element)xmlDocument
                        .getElementsByTagName("mesh")
                        .item(meshCount))
                        .getAttributes()
                        .getNamedItem("name")
                        .getNodeValue();


                MaterialSolid materialSolid = null;
                MaterialTextured materialTextured = null;

                if (((Element) xmlDocument.getElementsByTagName("mesh")
                        .item(meshCount)).getElementsByTagName("material_solid").getLength()>0){


                    Double r = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("color").item(0)
                            .getAttributes().getNamedItem("r").getNodeValue());
                    Double g = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("color").item(0)
                            .getAttributes().getNamedItem("g").getNodeValue());
                    Double b = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("color").item(0)
                            .getAttributes().getNamedItem("b").getNodeValue());

                    Color meshColor = new Color(r,g,b);


                    Double ka = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("ka").getNodeValue());
                    Double kd = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("kd").getNodeValue());
                    Double ks = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("ks").getNodeValue());
                    Double exponent = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("exponent").getNodeValue());

                    Phong meshPhong = new Phong(ka, kd, ks, exponent);

                    Double reflectance = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("reflectance").item(0)
                            .getAttributes().getNamedItem("r").getNodeValue());

                    Double transmittance = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("transmittance").item(0)
                            .getAttributes().getNamedItem("t").getNodeValue());

                    Double refraction = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_solid").item(0))
                            .getElementsByTagName("refraction").item(0)
                            .getAttributes().getNamedItem("iof").getNodeValue());

//                    System.out.println("solid!");
                    materialSolid = new MaterialSolid(meshColor, meshPhong, reflectance, transmittance, refraction);
                }
                if (((Element) xmlDocument.getElementsByTagName("mesh")
                        .item(meshCount)).getElementsByTagName("material_textured").getLength()>0){
//                    System.out.println("textured!");

                    String name2 = (((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("texture").item(0)
                            .getAttributes().getNamedItem("name").getNodeValue());


                    Double ka = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("ka").getNodeValue());
                    Double kd = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("kd").getNodeValue());
                    Double ks = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("ks").getNodeValue());
                    Double exponent = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("phong").item(0)
                            .getAttributes().getNamedItem("exponent").getNodeValue());

                    Phong meshPhong = new Phong(ka, kd, ks, exponent);

                    Double reflectance = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("reflectance").item(0)
                            .getAttributes().getNamedItem("r").getNodeValue());

                    Double transmittance = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("transmittance").item(0)
                            .getAttributes().getNamedItem("t").getNodeValue());

                    Double refraction = Double.parseDouble(((Element) ((Element) xmlDocument
                            .getElementsByTagName("mesh").item(meshCount))
                            .getElementsByTagName("material_textured").item(0))
                            .getElementsByTagName("refraction").item(0)
                            .getAttributes().getNamedItem("iof").getNodeValue());

                    materialTextured = new MaterialTextured(name2, meshPhong, reflectance, transmittance, refraction);
                }


                if(((Element) xmlDocument.getElementsByTagName("mesh").item(meshCount))
                        .getElementsByTagName("transform").getLength()>0){
                    for(int j = 0; j < ((Element) xmlDocument.getElementsByTagName("mesh")
                            .item(meshCount)).getElementsByTagName("transform")
                            .item(0).getChildNodes().getLength(); ++j){

                        String currentTransformation = ((Element) ((Element) xmlDocument
                                .getElementsByTagName("mesh").item(meshCount))
                                .getElementsByTagName("transform").item(0))
                                .getChildNodes().item(j).getNodeName();

                        if(currentTransformation.equals("translate") || currentTransformation.equals("scale")){
                            Double x = Double.parseDouble(((Element) ((Element) xmlDocument
                                    .getElementsByTagName("mesh").item(meshCount))
                                    .getElementsByTagName("transform").item(0))
                                    .getChildNodes().item(j)
                                    .getAttributes().getNamedItem("x").getNodeValue());

                            Double y = Double.parseDouble(((Element) ((Element) xmlDocument
                                    .getElementsByTagName("mesh").item(meshCount))
                                    .getElementsByTagName("transform").item(0))
                                    .getChildNodes().item(j)
                                    .getAttributes().getNamedItem("y").getNodeValue());

                            Double z = Double.parseDouble(((Element) ((Element) xmlDocument
                                    .getElementsByTagName("mesh").item(meshCount))
                                    .getElementsByTagName("transform").item(0))
                                    .getChildNodes().item(j)
                                    .getAttributes().getNamedItem("z").getNodeValue());

                            if(currentTransformation.equals("translate")){
                                Coordinate translationCoordinate = new Coordinate(x,y,z);
                                Translation translation = new Translation(translationCoordinate);
                                transformations.add(translation);
                            }
                            else if(currentTransformation.equals("scale")){
                                Coordinate scaleCoordinate = new Coordinate(x,y,z);
                                Scaling scaling = new Scaling(scaleCoordinate);
                                transformations.add(scaling);
                            }


                        }

                        else if(currentTransformation.equals("rotateX") || currentTransformation.equals("rotateY") || currentTransformation.equals("rotateZ")){
                            Double theta = Double.parseDouble(((Element) ((Element) xmlDocument
                                    .getElementsByTagName("mesh").item(meshCount))
                                    .getElementsByTagName("transform").item(0))
                                    .getChildNodes().item(j)
                                    .getAttributes().getNamedItem("theta").getNodeValue());

                            Transformations rotation;
                            switch (currentTransformation) {
                                case "rotateX": {
                                    rotation = new RotateX(theta);
                                    break;
                                }
                                case "rotateY": {
                                    rotation = new RotateY(theta);
                                    break;
                                }
                                case "rotateZ": {
                                    rotation = new RotateZ(theta);
                                    break;
                                }
                                default: rotation = new RotateX(theta);
                            }
                            transformations.add(rotation);
                        }
                    }
                }

                Mesh mesh = new Mesh(name);

                if(materialSolid!= null){
                    mesh.setMaterialSolid(materialSolid);
                }
                if(materialTextured!= null){
                    mesh.setMaterialTextured(materialTextured);
                }
                if(transformations.size()>0){
                    mesh.setTransformations(transformations);
                }
                surfaces.add(mesh);
                System.out.println(mesh);


                transformations = new ArrayList<>();

                meshCount++;
            }


        }
    }
}
