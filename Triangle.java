package ex1;

public class Triangle implements Geometry {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calcPerimeter() {
        return base + 2*Math.sqrt(base*base + height*height/4);
    }

    @Override
    public double calcArea() {
        return base * height / 2;
    }

    @Override
    public String toCSV() {
        return "triangle,"+base+","+height;
    }
    
}
