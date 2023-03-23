package edu.up.isgc.raytracer.tools;

/**
 * @author Gabriel Morales
 *
 */
public class Material {
    private double shininess;
    private double ambient;
    private double reflectiveIndex;
    private double refractiveIndex;

    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    public double getAmbient() {
        return ambient;
    }

    public void setAmbient(double ambient) {
        this.ambient = ambient;
    }

    public double getReflectiveIndex() {
        return reflectiveIndex;
    }

    public void setReflectiveIndex(double reflectiveIndex) {
        this.reflectiveIndex = reflectiveIndex;
    }

    public double getRefractiveIndex() {
        return refractiveIndex;
    }

    public void setRefractiveIndex(double refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
    }

    /**
     * constructor of the material of the objects
     * @param shininess how shiny the object is
     * @param ambient the ambient index
     * @param reflectiveIndex index of reflection
     * @param refractiveIndex index of refraction
     */
    public Material(double shininess, double ambient, double reflectiveIndex, double refractiveIndex) {
        setAmbient(ambient);
        setShininess(shininess);
        setReflectiveIndex(reflectiveIndex);
        setRefractiveIndex(refractiveIndex);
    }
}
