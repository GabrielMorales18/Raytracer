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
 * @author Jafet Rodríguez
 */
public class PointLight extends Light {
    /**
     * The point light is a light sphere that shoots light rays all around it
     * @param position the position of this light sphere
     * @param color the color of the light
     * @param intensity the intensity of the light
     * @param material needs to be null, parameter inherited from Object3D
     */
    public PointLight(Vector3D position, Color color, double intensity, Material material) {
        super(position, color, intensity, material);
    }

    /**
     * this function gets the dot product of the direction of the light with the normal of the intersection
     * @param intersection the intersection with an object
     * @return the dot product between the normal of the intersection with the direction of the light minus the position
     *         of the intersection if its bigger than zero if zero is bigger than the dot product it returns zero
     */
    @Override
    public float getNDotL(Intersection intersection) {
        return (float) Math.max(Vector3D.dotProduct(intersection.getNormal(),
                Vector3D.normalize(Vector3D.substract(getPosition(), intersection.getPosition()))), 0.0);
    }
}
