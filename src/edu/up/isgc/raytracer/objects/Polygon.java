/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.raytracer.objects;

import edu.up.isgc.raytracer.Intersection;
import edu.up.isgc.raytracer.Ray;
import edu.up.isgc.raytracer.Vector3D;
import edu.up.isgc.raytracer.tools.Barycentric;
import edu.up.isgc.raytracer.tools.Material;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jafet Rodríguez
 */
public class Polygon extends Object3D {

    public List<Triangle> triangles;


    public List<Triangle> getTriangles() {
        return triangles;
    }

    /**
     * polygon is every object that is composed by an array of triangles
     * @param position the position of the polygon
     * @param triangles the array of triangles that compose the polygon
     * @param color the color of the polygon
     * @param material the material of the polygon
     */
    public Polygon(Vector3D position, Triangle[] triangles, Color color, Material material){
        super(position, color, material);
        setTriangles(triangles);
    }

    /**
     * this function set the array of triangles of the polygon and it also sets the vertexes of each triangle into a hash
     * map of unique vertexes in case more than one triangle uses a vertex
     * @param triangles it receives an array of triangles
     */
    public void setTriangles(Triangle[] triangles) {
        Vector3D position = getPosition();
        Set<Vector3D> uniqueVertices = new HashSet<Vector3D>();
        for(Triangle triangle : triangles){
            uniqueVertices.addAll(Arrays.asList(triangle.getVertices()));
        }

        for(Vector3D vertex : uniqueVertices){
            vertex.setX(vertex.getX() + position.getX());
            vertex.setY(vertex.getY() + position.getY());
            vertex.setZ(vertex.getZ() + position.getZ());
        }

        this.triangles = Arrays.asList(triangles);
    }

    /**
     * if a ray intersects a triangle this functions makes a new intersection with the information of the intersected triangle
     * @param ray the ray that is intersecting
     * @return a new intersection with the position of the intersection,
     *         the distance to the origin of the ray, the normal of this intersection and the triangle that intersects
     */
    @Override
    public Intersection getIntersection(Ray ray) {
        double distance = -1;
        Vector3D normal = Vector3D.ZERO();
        Vector3D position = Vector3D.ZERO();

        for(Triangle triangle : getTriangles()){
            Intersection intersection = triangle.getIntersection(ray);
            double intersectionDistance = intersection.getDistance();
            if(intersection != null && intersectionDistance > 0 && (intersectionDistance < distance ||distance < 0)){
                distance = intersectionDistance;
                position = Vector3D.add(ray.getOrigin(), Vector3D.scalarMultiplication(ray.getDirection(), distance));

                normal = Vector3D.ZERO();
                double[] uVw = Barycentric.CalculateBarycentricCoordinates(position, triangle);
                Vector3D[] normals = triangle.getNormals();
                for(int i = 0; i < uVw.length; i++) {
                    normal = Vector3D.add(normal, Vector3D.scalarMultiplication(normals[i], uVw[i]));
                }
            }
        }

        if(distance == -1){
            return null;
        }

        return new Intersection(position, distance, normal, this);
    }
}
