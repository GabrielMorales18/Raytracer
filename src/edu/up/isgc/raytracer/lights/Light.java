/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.raytracer.lights;

import edu.up.isgc.raytracer.Intersection;
import edu.up.isgc.raytracer.Ray;
import edu.up.isgc.raytracer.Vector3D;
import edu.up.isgc.raytracer.objects.Object3D;
import edu.up.isgc.raytracer.tools.Material;

import java.awt.*;

/**
 *
 * @author Jafet Rodríguez
 */
public abstract class Light extends Object3D {
    private double intensity;

    /**
     * abstract class of light, all the light classes are made based in this class
     * @param position the position of the light
     * @param color the color of the light
     * @param intensity the intensity of the light
     * @param material needs to be null, parameter inherited from Object3D
     */
    public Light(Vector3D position, Color color, double intensity, Material material){
        super(position, color, material);
        setIntensity(intensity);
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public abstract float getNDotL(Intersection intersection);

    public Intersection getIntersection(Ray ray){
        return new Intersection(Vector3D.ZERO(), -1, Vector3D.ZERO(), null);
    }
}
