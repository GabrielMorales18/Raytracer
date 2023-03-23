/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.raytracer.lights;

import edu.up.isgc.raytracer.Intersection;
import edu.up.isgc.raytracer.Vector3D;
import edu.up.isgc.raytracer.tools.Material;

import java.awt.*;

/**
 *
 * @author Jafet Rodríguez
 */
public class DirectionalLight extends Light {
    private Vector3D direction;

    /**
     * This is the constructor of the directional light, it is a light that only goes to a specified direction
     * @param position where the light is placed
     * @param direction the direction in which the light rays are going to go
     * @param color the color of the light
     * @param intensity the intensity of the light
     * @param material this needs to be null, it is a parameter inherited from object3D
     */
    public DirectionalLight(Vector3D position, Vector3D direction, Color color, double intensity, Material material){
        super(position, color, intensity, material);
        setDirection(Vector3D.normalize(direction));
    }

    public Vector3D getDirection() {
        return direction;
    }

    public void setDirection(Vector3D direction) {
        this.direction = direction;
    }

    /**
     * this function gets the dot product of the direction of the light with the normal of the intersection
     * @param intersection the intersection with an object
     * @return the dot product between the normal of the intersection with the direction of the light multiplied by -1 if its bigger than zero
     *         if zero is bigger than the dot product it returns zero
     */
    @Override
    public float getNDotL(Intersection intersection) {
        return (float)Math.max(Vector3D.dotProduct(intersection.getNormal(), Vector3D.scalarMultiplication(getDirection(), -1.0)), 0.0);
    }
}
