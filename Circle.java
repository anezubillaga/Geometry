package ex1;

public class Circle implements Geometry {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcPerimeter() {
        return 2*radius * Math.PI;
    }

    @Override
    public double calcArea() {
        return radius*radius* Math.PI;
    }

    @Override
    public String toCSV() {
        return "circle,"+radius;
    }
    
}
