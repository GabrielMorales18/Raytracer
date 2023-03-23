/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.raytracer;

import edu.up.isgc.raytracer.lights.DirectionalLight;
import edu.up.isgc.raytracer.lights.Light;
import edu.up.isgc.raytracer.lights.PointLight;
import edu.up.isgc.raytracer.objects.*;
import edu.up.isgc.raytracer.tools.Material;
import edu.up.isgc.raytracer.tools.OBJReader;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jafet Rodríguez & Gabriel Morales
 */
public class Raytracer {

    /**
     * main function where the image is created, here you define your scenes and
     * create the materials, objects, lights and cameras.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Date());

        //scene1
        Scene scene01 = new Scene();
        Material material = new Material(0, 0.1, 0.1, 0);
        Material material7 = new Material(0, 0.1, 0.5, 0);
        Material material2 = new Material(45, 0.1,  0.1, 0);
        Material material3 = new Material(25, 0.1,  0, 0);
        Material material4 = new Material(2, 0.1,  0, 0);
        Material material5 = new Material(50, 0.05,  0.01, 0);
        Material material6 = new Material(40, 0.05,  0.05, 0);
        scene01.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 1200, 1200, 8.2f, 50f, null));
        /*scene01.addLight(new DirectionalLight(Vector3D.ZERO(), new Vector3D(0.0, 0.0, 1.0), Color.WHITE, 0.8));
        scene01.addLight(new DirectionalLight(Vector3D.ZERO(), new Vector3D(0.0, -0.1, 0.1), Color.WHITE, 0.2));
        scene01.addLight(new DirectionalLight(Vector3D.ZERO(), new Vector3D(-0.2, -0.1, 0.0), Color.WHITE, 0.2));*/
        scene01.addLight(new PointLight(new Vector3D(-1f, 3f, 1f), Color.white, 5f, null));
        scene01.addLight(new PointLight(new Vector3D(3f, 5f, 5f), Color.white, 4f, null));
        scene01.addObject(OBJReader.GetPolygon("scene1_objs/Plane.obj", new Vector3D(1.5f, -3.5f, 1f), new Color(0, 195, 255), material));
        scene01.addObject(OBJReader.GetPolygon("scene1_objs/helmet.obj", new Vector3D(1.5f, -3.3f, 7f), new Color(245, 228, 73), material2));
        scene01.addObject(OBJReader.GetPolygon("scene1_objs/sword.obj", new Vector3D(1.5f, -3.3f, 8f), new Color(176, 176, 176), material6));
        scene01.addObject(OBJReader.GetPolygon("scene1_objs/piedras1.obj", new Vector3D(1.5f, -3.3f, 8f), new Color(156, 150, 100), material4));
        scene01.addObject(OBJReader.GetPolygon("scene1_objs/piedras2.obj", new Vector3D(1.5f, -3.3f, 8f), new Color(110, 97, 80), material4));
        scene01.addObject(OBJReader.GetPolygon("scene1_objs/piedras3.obj", new Vector3D(1.5f, -3.3f, 8f), new Color(110, 97, 80), material4));
        scene01.addObject(OBJReader.GetPolygon("scene1_objs/onimask.obj", new Vector3D(1.5f, -3.3f, 8f), new Color(158, 29, 0), material3));
        scene01.addObject(OBJReader.GetPolygon("scene1_objs/katana.obj", new Vector3D(1.5f, -3.3f, 8f), Color.white, material5));
        scene01.addObject(OBJReader.GetPolygon("scene1_objs/vplane1.obj", new Vector3D(1.5f, -3.3f, 8f), Color.white, material7));
        scene01.addObject(OBJReader.GetPolygon("scene1_objs/vplane2.obj", new Vector3D(1.5f, -3.3f, 8f), Color.white, material7));

        //scene2
        Scene scene02 = new Scene();
        Material s2material = new Material(0, 0.1, 0, 0);
        Material s2material2 = new Material(15, 0.1,  0, 1.8);
        Material s2material3 = new Material(25, 0.1,  0, 0);
        Material s2material4 = new Material(2, 0.1,  0, 0);
        scene02.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 1200, 1200, 8.2f, 50f, null));
        scene02.addLight(new PointLight(new Vector3D(-1f, 3f, 1f), Color.white, 5f, null));
        scene02.addLight(new PointLight(new Vector3D(3f, 5f, 5f), Color.white, 4f, null));
        scene02.addObject(OBJReader.GetPolygon("scene2_objs/Plane.obj", new Vector3D(1.5f, -3.5f, 1f), Color.gray, s2material3));
        scene02.addObject(OBJReader.GetPolygon("scene2_objs/cat.obj", new Vector3D(0f, -3f, 8f), new Color(255, 102, 0), s2material));
        scene02.addObject(OBJReader.GetPolygon("scene2_objs/kiosko.obj", new Vector3D(0f, -3f, 8f), new Color(4, 0, 82), s2material4));
        scene02.addObject(OBJReader.GetPolygon("scene2_objs/gota.obj", new Vector3D(0f, -2.5f, 8f), Color.white, s2material2));
        scene02.addObject(OBJReader.GetPolygon("scene2_objs/gotas.obj", new Vector3D(0f, -2.5f, 8f), Color.white, s2material2));

        //scene3
        Scene scene03 = new Scene();
        Material s3material = new Material(5, 0.1, 0.6, 0);
        Material s3material2 = new Material(15, 0.1,  0.4, 0);
        Material s3material3 = new Material(35, 0.1,  0, 0);
        scene03.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 1200, 1200, 8.2f, 50f, null));
        scene03.addLight(new PointLight(new Vector3D(-1.2f, 0f, 17f), Color.yellow, 5f, null));
        scene03.addLight(new PointLight(new Vector3D(1.2f, 0f, 5f), Color.white, 4f, null));
        scene03.addObject(OBJReader.GetPolygon("scene3_objs/Plane.obj", new Vector3D(1.5f, -3.5f, 1f), Color.gray, s3material));
        scene03.addObject(OBJReader.GetPolygon("scene3_objs/plane2.obj", new Vector3D(1.5f, -3.5f, 1f), Color.gray, s3material));
        scene03.addObject(OBJReader.GetPolygon("scene3_objs/vplane1.obj", new Vector3D(1.5f, -3.5f, 1f), Color.white, s3material2));
        scene03.addObject(OBJReader.GetPolygon("scene3_objs/vplane2.obj", new Vector3D(1.5f, -3.5f, 1f), Color.white, s3material2));
        scene03.addObject(OBJReader.GetPolygon("scene3_objs/droid.obj", new Vector3D(0.5f, -3.5f, 8f), new Color(82, 74, 74), s3material3));
        scene03.addObject(OBJReader.GetPolygon("scene3_objs/droid2.obj", new Vector3D(0.5f, -3.5f, 8f), new Color(65, 51, 255), s3material3));



        BufferedImage image = raytrace(scene03);
        File outputImage = new File("image.png");
        try {
            ImageIO.write(image, "png", outputImage);
        } catch (IOException ioe) {
            System.out.println("Something failed");
        }
        System.out.println(new Date());
    }

    /**
     *function where the pixels of the image are painted and where the camera raytrace the objects of the scene
     * @param scene the function receives the scene with all its elements
     * @return the function returns the buffered image of the scene
     */
    public static BufferedImage raytrace(Scene scene) {
        Camera mainCamera = scene.getCamera();
        ArrayList<Light> lights = scene.getLights();
        float[] nearFarPlanes = mainCamera.getNearFarPlanes();
        BufferedImage image = new BufferedImage(mainCamera.getResolutionWidth(), mainCamera.getResolutionHeight(), BufferedImage.TYPE_INT_RGB);
        ArrayList<Object3D> objects = scene.getObjects();

        Vector3D[][] positionsToRaytrace = mainCamera.calculatePositionsToRay();
        for (int i = 0; i < positionsToRaytrace.length; i++) {
            for (int j = 0; j < positionsToRaytrace[i].length; j++) {
                double x = positionsToRaytrace[i][j].getX() + mainCamera.getPosition().getX();
                double y = positionsToRaytrace[i][j].getY() + mainCamera.getPosition().getY();
                double z = positionsToRaytrace[i][j].getZ() + mainCamera.getPosition().getZ();

                Ray ray = new Ray(mainCamera.getPosition(), new Vector3D(x, y, z));
                float cameraZ = (float) mainCamera.getPosition().getZ();
                Intersection closestIntersection = raycast(ray, objects, null, new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

                //Background color
                Color pixelColor = Color.BLACK;
                if (closestIntersection != null) {
                    pixelColor = Color.BLACK;
                    for (Light light : lights) {
                        if (closestIntersection.getObject().getMaterial().getReflectiveIndex() > 0){
                            Color rfl = reflection(scene, closestIntersection, ray, light, pixelColor, 0);
                            pixelColor = addColor(pixelColor, rfl);
                        }
                        else if (closestIntersection.getObject().getMaterial().getRefractiveIndex() > 0){
                            Color rfr = refraction(scene, closestIntersection, ray, light, pixelColor, 0);
                            pixelColor = addColor(pixelColor, rfr);
                        }
                        else{
                            Ray shadowRay = new Ray(closestIntersection.getPosition(), Vector3D.normalize(Vector3D.substract(light.getPosition(), closestIntersection.getPosition())));
                            Intersection shadow = raycast(shadowRay, objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

                            Color bp = BlinnPhong(mainCamera, closestIntersection, light, shadow);
                            pixelColor = addColor(pixelColor, bp);
                        }


                    }
                }
                image.setRGB(i, j, pixelColor.getRGB());
            }
        }

        return image;
    }

    /**
     *function that calculates the ambient color of an object by multiplying the light color,the ambient index and the object color
     * @param light it receives the light to obtain the color
     * @param closestIntersection it receives the closest intersection to obtain the ambient index
     * @return the function returns the ambient color
     */
    public static Color ambient(Light light, Intersection closestIntersection){

        Color lightColor = light.getColor();
        Color objColor = closestIntersection.getObject().getColor();
        float[] lightColors = new float[]{lightColor.getRed() / 255.0f, lightColor.getGreen() / 255.0f, lightColor.getBlue() / 255.0f};
        float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
        float[] ambientColors = new float[]{0, 0, 0};
        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
            ambientColors[colorIndex] = objColors[colorIndex] * (float) closestIntersection.getObject().getMaterial().getAmbient() * lightColors[colorIndex];
        }
        Color ambient = new Color(clamp(ambientColors[0], 0, 1),clamp(ambientColors[1], 0, 1),clamp(ambientColors[2], 0, 1));
        return ambient;
    }

    /**
     * function that calculates the diffuse color of an object by obtaining the distance between the closest intersection and the light to calculate the shadows
     * calculating the falloff of the lights. The diffuse is the result of multiplying the light color, the intensity of the light and the object color
     * @param light it receives the light for the light color, the intensity and for the distance
     * @param closestIntersection it receives the closest intersection for the falloff of the light
     * @param shadow it receives the shadow intersection for the shadows
     * @return the function returns the diffuse color
     */
    public static Color diffuse(Light light, Intersection closestIntersection, Intersection shadow){

        float nDotL = light.getNDotL(closestIntersection);
        float intensity = (float) (light.getIntensity() * nDotL);
        float distance = (float) Math.sqrt((Math.pow((closestIntersection.getPosition().getX() - light.getPosition().getX()), 2) + (Math.pow((closestIntersection.getPosition().getY() - light.getPosition().getY()), 2)) + (Math.pow((closestIntersection.getPosition().getZ() - light.getPosition().getZ()), 2))));
        if (light.getClass() == PointLight.class) {
            intensity = (intensity / (float) Math.pow(distance, 2));
        }
        if (shadow != null && shadow.getDistance() < distance){
            intensity = 0;
        }
        Color lightColor = light.getColor();
        Color objColor = closestIntersection.getObject().getColor();
        float[] lightColors = new float[]{lightColor.getRed() / 255.0f, lightColor.getGreen() / 255.0f, lightColor.getBlue() / 255.0f};
        float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
        float[] diffuseColors = new float[]{0, 0, 0};
        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
            diffuseColors[colorIndex] = objColors[colorIndex] * intensity * lightColors[colorIndex];
        }
        Color diffuse = new Color(clamp(diffuseColors[0], 0, 1),clamp(diffuseColors[1], 0, 1),clamp(diffuseColors[2], 0, 1));
        return diffuse;
    }

    /**
     * function that calculates the specular of an object by calculating the H vector and using it to get the specular index then the
     * specular is obtained by multiplying the object color, the specular index and the light color.
     * @param light it uses the light for the light color and for the position of the light
     * @param closestIntersection the closest intersection is used for getting the shininess of the object, we need its normal for the specular
     *                            index and for the object color
     * @param camera the camera is required for getting its position
     * @return it returns the specular color of the object if the shininess is bigger than zero, if the value is zero or less it returns black as specular
     */
    public static Color specular(Light light, Intersection closestIntersection, Camera camera){

        float shininess = (float) closestIntersection.getObject().getMaterial().getShininess();
        if (shininess > 0) {
            Vector3D vectorH = Vector3D.normalize(Vector3D.add(Vector3D.normalize(Vector3D.substract(light.getPosition(), closestIntersection.getPosition())), Vector3D.normalize(Vector3D.substract(camera.getPosition(), closestIntersection.getPosition()))));
            float specularIndex = (float) Math.pow(Math.max(Vector3D.dotProduct(closestIntersection.getNormal(), vectorH), 0), shininess);
            Color lightColor = light.getColor();
            Color objColor = closestIntersection.getObject().getColor();
            float[] lightColors = new float[]{lightColor.getRed() / 255.0f, lightColor.getGreen() / 255.0f, lightColor.getBlue() / 255.0f};
            float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
            float[] specularColors = new float[]{0, 0, 0};
            for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                specularColors[colorIndex] = objColors[colorIndex] * specularIndex * lightColors[colorIndex];
            }
            Color specular = new Color(clamp(specularColors[0], 0, 1), clamp(specularColors[1], 0, 1), clamp(specularColors[2], 0, 1));
            return specular;
        }
        else{
            Color specular = new Color(0,0,0);
            return specular;
        }
    }

    /**
     * This function calls the functions of ambient, diffuse and specular and it adds them all into one color that is the Blinn-Phong shading
     * @param camera the camera is used for the specular function
     * @param closestIntersection the closest intersection is used by the three functions
     * @param light the light is also used by the three functions
     * @param shadow the shadow is required fot the diffuse function
     * @return it returns de Blinn-Phong shading color
     */
    public static Color BlinnPhong(Camera  camera, Intersection closestIntersection, Light light, Intersection shadow){

        Color bliPh = new Color(0,0,0);

        bliPh = addColor(bliPh, ambient(light, closestIntersection));
        bliPh = addColor(bliPh, diffuse(light, closestIntersection, shadow));
        bliPh = addColor(bliPh, specular(light, closestIntersection, camera));

        return bliPh;
    }

    /**
     * This function calculates the reflection of the objects by getting the direction of the reflected ray and calculating
     * if it is reflected again in other surface using the Law of Reflection. The function also checks if the reflected intersection has reflection, refraction or none of them
     * @param scene we need the scene for the objects and the camera
     * @param closestIntersection we need the closest intersection for the object, the position and the normal
     * @param ray we need the direction of the ray when we calculate the reflected ray direction
     * @param light we use the lights in the diffuse, ambient and specular functions
     * @param pixelColor the pixel color is used for add it to the new colors we obtain in the function
     * @param depth the depth is how far the ray has gone, if it reaches a depth of 5 it stops reflecting
     * @return the function returns the color of the reflections.
     */
    public static Color reflection(Scene scene, Intersection closestIntersection, Ray ray, Light light, Color pixelColor, int depth){

        if (depth >= 5){
            return pixelColor;
        }

        Camera camera = scene.getCamera();
        float[] nearFarPlanes = camera.getNearFarPlanes();
        float cameraZ = (float) camera.getPosition().getZ();
        ArrayList<Object3D> objects = scene.getObjects();

        Ray shadowRay = new Ray(closestIntersection.getPosition(), Vector3D.normalize(Vector3D.substract(light.getPosition(), closestIntersection.getPosition())));
        Intersection shadow = raycast(shadowRay, objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

        Color diffuse = diffuse(light, closestIntersection, shadow);
        pixelColor = addColor(pixelColor, diffuse);
        Color specular = specular(light, closestIntersection, camera);
        pixelColor = addColor(pixelColor, specular);
        pixelColor = multiplyColor(pixelColor, (float) (1 - closestIntersection.getObject().getMaterial().getReflectiveIndex()));
        Color ambient = ambient(light, closestIntersection);
        pixelColor = addColor(pixelColor, ambient);

        Vector3D reflectDir = Vector3D.substract(ray.getDirection(), (Vector3D.scalarMultiplication(closestIntersection.getNormal(), (Vector3D.dotProduct(ray.getDirection(), closestIntersection.getNormal()) * 2))));
        Ray reflectedRay = new Ray(closestIntersection.getPosition(), reflectDir);
        Intersection reflectedInter = raycast(reflectedRay, objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

        if (reflectedInter != null && (closestIntersection.getObject().getMaterial().getReflectiveIndex() > 0) && (depth <= 5)){

            if(reflectedInter.getObject().getMaterial().getReflectiveIndex() > 0){

                Color reflectColor = reflection(scene, reflectedInter, reflectedRay, light, pixelColor, (depth + 1));
                reflectColor = multiplyColor(reflectColor, (float) reflectedInter.getObject().getMaterial().getReflectiveIndex());
                pixelColor = addColor(pixelColor, reflectColor);

            }
            else if(reflectedInter.getObject().getMaterial().getRefractiveIndex() > 0){
                Color refracColor = refraction(scene, reflectedInter, reflectedRay, light, pixelColor, (depth + 1));
                refracColor = multiplyColor(refracColor, (float) reflectedInter.getObject().getMaterial().getRefractiveIndex());
                pixelColor = addColor(pixelColor, refracColor);
            }
            else{
                pixelColor = BlinnPhong(camera, reflectedInter, light, shadow);
            }

        }

        return pixelColor;
    }

    /**
     * This function calculates the refraction of an object using the Snell's Law
     * @param scene we need the scene because we need the camera and the objects
     * @param closestIntersection we need the closest intersection because the formulas uses its position and its normal, we also need the object
     * @param ray the direction of the ray is needed
     * @param light the light is used in the ambient, diffuse and specular functions
     * @param pixelColor the pixel color is where we add all the new colors we obtain using the formulas
     * @param depth the depth is how far the ray has gone, if it reaches a depth of 5 it stops refracting
     * @return the function returns the color of the refractions.
     */
    public static Color refraction(Scene scene, Intersection closestIntersection, Ray ray, Light light, Color pixelColor, int depth){

        if (depth >= 5){
            return pixelColor;
        }

        Camera camera = scene.getCamera();
        float[] nearFarPlanes = camera.getNearFarPlanes();
        float cameraZ = (float) camera.getPosition().getZ();
        ArrayList<Object3D> objects = scene.getObjects();
        Vector3D refractDir;

        Ray shadowRay = new Ray(closestIntersection.getPosition(), Vector3D.normalize(Vector3D.substract(light.getPosition(), closestIntersection.getPosition())));
        Intersection shadow = raycast(shadowRay, objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

        Color diffuse1 = diffuse(light, closestIntersection, shadow);
        pixelColor = addColor(pixelColor, diffuse1);
        Color specular1 = specular(light, closestIntersection, camera);
        pixelColor = addColor(pixelColor, specular1);
        pixelColor = multiplyColor(pixelColor, (float) (1 - closestIntersection.getObject().getMaterial().getReflectiveIndex()));
        Color ambient1 = ambient(light, closestIntersection);
        pixelColor = addColor(pixelColor, ambient1);

        float nDotl = (float) Vector3D.dotProduct(ray.getDirection(), closestIntersection.getNormal());
        float cosI = clamp(-1, 1, nDotl);
        float etaI = 1;
        Vector3D n = closestIntersection.getNormal();
        float etaT = (float) closestIntersection.getObject().getMaterial().getRefractiveIndex();

        if (cosI < 0){

            cosI = -cosI;

        }
        else{

            float aux = etaI;
            etaI = etaT;
            etaT = aux;
            n = Vector3D.scalarMultiplication(n, -1);

        }

        float eta = etaI / etaT;
        float k = 1 - eta * eta * (1 - cosI * cosI);

        if(k < 0){

            refractDir = null;

        }
        else{

            refractDir = Vector3D.add(Vector3D.scalarMultiplication(ray.getDirection(), eta), Vector3D.scalarMultiplication(n, eta * cosI - Math.sqrt(k)));

        }
        Ray refractedRay = new Ray(closestIntersection.getPosition(), refractDir);
        Intersection refractedInter = raycast(refractedRay, objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

        if (refractedInter != null ){
            if(refractedInter.getObject().getMaterial().getRefractiveIndex() > 0){
                Color reflectColor = reflection(scene, refractedInter, refractedRay, light, pixelColor, (depth + 1));
                reflectColor = multiplyColor(reflectColor, (float) refractedInter.getObject().getMaterial().getReflectiveIndex());
                pixelColor = addColor(pixelColor, reflectColor);

            }

            else if(refractedInter.getObject().getMaterial().getReflectiveIndex() > 0){
                Color reflectColor = reflection(scene, refractedInter, refractedRay, light, pixelColor, (depth + 1));
                reflectColor = multiplyColor(reflectColor, (float) refractedInter.getObject().getMaterial().getRefractiveIndex());
                pixelColor = addColor(pixelColor, reflectColor);
            }
            else{
                pixelColor = BlinnPhong(camera, refractedInter, light, shadow);

            }

        }

        return pixelColor;
    }

    /**
     * clamp is a function that avoids a value to be bigger or smaller than the specified values
     * @param value the value you want to clamp
     * @param min the minimum value that its accepted
     * @param max the maximum value that its accepted
     * @return it returns the value if its between the min and max,but if its smaller or bigger the function returns the minimum or maximum value
     */
    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    /**
     * This function multiplies a color with a scalar
     * @param original the color you want to multiply
     * @param value the value that is going to multiply the color
     * @return the Color multiplied by the value
     */
    public static Color multiplyColor(Color original, float value){
        float red = clamp((original.getRed() / 255.0f) * value, 0, 1);
        float green = clamp((original.getGreen() / 255.0f) * value, 0, 1);
        float blue = clamp((original.getBlue() / 255.0f) * value, 0, 1);
        return new Color(red, green, blue);
    }

    /**
     * A function that adds a color to an original color
     * @param original the original color
     * @param otherColor the color that is going to be added
     * @return a new color, result of the operation
     */
    public static Color addColor(Color original, Color otherColor){
        float red = clamp((original.getRed() / 255.0f) + (otherColor.getRed() / 255.0f), 0, 1);
        float green = clamp((original.getGreen() / 255.0f) + (otherColor.getGreen() / 255.0f), 0, 1);
        float blue = clamp((original.getBlue() / 255.0f) + (otherColor.getBlue() / 255.0f), 0, 1);
        return new Color(red, green, blue);
    }

    /**
     * This function is the one that chooses the closest intersection of the given ray, it also checks that it is inside of the
     * clipping planes and that is in the front of the object
     * @param ray the ray that is being casted
     * @param objects all the objects in the scene
     * @param caster the object that casts the ray, this avoids that the ray collides with the same object that cast the ray
     * @param clippingPlanes the area in which the objects are being rendered
     * @return it returns the closest intersection
     */
    public static Intersection raycast(Ray ray, ArrayList<Object3D> objects, Object3D caster, float[] clippingPlanes) {
        Intersection closestIntersection = null;

        for (int k = 0; k < objects.size(); k++) {
            Object3D currentObj = objects.get(k);
            if (caster == null || !currentObj.equals(caster)) {
                Intersection intersection = currentObj.getIntersection(ray);
                if (intersection != null) {
                    double distance = intersection.getDistance();
                    if (distance >= 0 &&
                            (closestIntersection == null || distance < closestIntersection.getDistance()) &&
                            (clippingPlanes == null || (intersection.getPosition().getZ() >= clippingPlanes[0] &&
                                    intersection.getPosition().getZ() <= clippingPlanes[1]))) {
                        closestIntersection = intersection;
                    }
                }
            }
        }

        return closestIntersection;
    }
}
