/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.raytracer.objects;

import edu.up.isgc.raytracer.Intersection;
import edu.up.isgc.raytracer.Ray;
import edu.up.isgc.raytracer.Vector3D;
import edu.up.isgc.raytracer.tools.Material;

import java.awt.*;

/**
 * @author Jafet Rodríguez
 */
public class Camera extends Object3D {
    // 0 is fovh
    // 1 is fovv
    private float[] fieldOfView = new float[2];
    private float defaultZ = 15f;
    // 0 is width
    // 1 is height
    private int[] resolution;
    private float[] nearFarPlanes = new float[2];

    /**
     * The camera that shoots the rays that raytrace the objects in the scene
     * @param position position of the camera
     * @param fieldOfViewHorizontal is the horizontal size of the observable space
     * @param fieldOfViewVertical is the vertical size of the observable space
     * @param widthResolution width of the image that is going to be generated
     * @param heightResolution height of the image that is going to be generated
     * @param nearPlane the closest distance an object can be of the camera to be rendered
     * @param farPlane the further distance an object can be of the camera to be rendered
     * @param material is null, this is a parameter inherited from Onject3D
     */
    public Camera(Vector3D position, float fieldOfViewHorizontal, float fieldOfViewVertical, int widthResolution, int heightResolution, float nearPlane, float farPlane, Material material) {
        super(position, Color.black, material);
        setFieldOfViewHorizontal(fieldOfViewHorizontal);
        setFieldOfViewVertical(fieldOfViewVertical);
        setResolution(new int[]{widthResolution, heightResolution});
        setNearFarPlanes(new float[]{nearPlane, farPlane});
    }

    public float[] getFieldOfView() {
        return fieldOfView;
    }

    public void setFieldOfView(float[] fieldOfView) {
        this.fieldOfView = fieldOfView;
    }

    public float getFieldOfViewHorizontal() {
        return fieldOfView[0];
    }

    public void setFieldOfViewHorizontal(float fov) {
        fieldOfView[0] = fov;
    }

    public float getFieldOfViewVertical() {
        return fieldOfView[1];
    }

    public void setFieldOfViewVertical(float fov) {
        fieldOfView[1] = fov;
    }

    public float getDefaultZ() {
        return defaultZ;
    }

    public void setDefaultZ(float defaultZ) {
        this.defaultZ = defaultZ;
    }

    public int[] getResolution() {
        return resolution;
    }

    public void setResolution(int[] resolution) {
        this.resolution = resolution;
    }

    public int getResolutionWidth() {
        return getResolution()[0];
    }

    public int getResolutionHeight() {
        return getResolution()[1];
    }

    /**
     * this function determines all the posible positions of x,y,z that are inside the field of view and the clipping planes
     * @return this function returns a matrix of possible positions of the rays
     */
    public Vector3D[][] calculatePositionsToRay() {
        float angleMaxX = 90 - (getFieldOfViewHorizontal() / 2f);
        float radiusMaxX = getDefaultZ() / (float) Math.cos(Math.toRadians(angleMaxX));

        float maxX = (float) Math.sin(Math.toRadians(angleMaxX)) * radiusMaxX;
        float minX = -maxX;

        float angleMaxY = 90 - (getFieldOfViewVertical() / 2f);
        float radiusMaxY = getDefaultZ() / (float) Math.cos(Math.toRadians(angleMaxY));

        float maxY = (float) Math.sin(Math.toRadians(angleMaxY)) * radiusMaxY;
        float minY = -maxY;

        Vector3D[][] positions = new Vector3D[getResolutionWidth()][getResolutionHeight()];
        float posZ = getDefaultZ();
        for (int x = 0; x < positions.length; x++) {
            for (int y = 0; y < positions[x].length; y++) {
                float posX = minX + (((maxX - minX) / (float) getResolutionWidth()) * x);
                //float posY = minY + (((maxY - minY) / (float) getResolutionHeight()) * y);
                float posY = maxY - (((maxY - minY) / (float) getResolutionHeight()) * y);
                positions[x][y] = new Vector3D(posX, posY, posZ);
            }
        }

        return positions;
    }

    public float[] getNearFarPlanes() {
        return nearFarPlanes;
    }

    public void setNearFarPlanes(float[] nearFarPlanes) {
        this.nearFarPlanes = nearFarPlanes;
    }

    /**
     * if a ray intersects the camera it returns a null intersection
     * @param ray the ray that intersects the camera
     * @return a null intersection
     */
    @Override
    public Intersection getIntersection(Ray ray) {
        return new Intersection(Vector3D.ZERO(), -1, Vector3D.ZERO(), null);
    }
}
