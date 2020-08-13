package ex1;

public class Rectangle implements Geometry {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (width+height);
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public String toCSV() {
        return "rectangle,"+width+","+height;
    }
    
}
