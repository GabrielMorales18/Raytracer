/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.raytracer.objects;

import edu.up.isgc.raytracer.IIntersectable;
import edu.up.isgc.raytracer.Vector3D;
import edu.up.isgc.raytracer.tools.Material;

import java.awt.*;

/**
 *
 * @author Jafet Rodríguez
 */
public abstract class Object3D implements IIntersectable {

    private Vector3D position;
    private Color color;
    private Material material;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Vector3D getPosition() {
        return position;
    }

    public void setPosition(Vector3D position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * abstract class of Object3D, it is the base of all the objects created in the scene
     * @param position the position of the object
     * @param color the color of the object
     * @param material the material of the object, if it has material
     */
    public Object3D(Vector3D position, Color color, Material material) {
        setPosition(position);
        setColor(color);
        setMaterial(material);
    }

}
