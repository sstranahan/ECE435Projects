package EX5_Inheritance_Setters_getters;

public class Rectangle {

    protected double x;
    protected double y;
    protected double width;
    protected double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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

    public double getArea() {
        return width * height;
    }

    public void print(String label){
        System.out.println("Rectangle object: " + label);
        System.out.println("     x: " + x);
        System.out.println("     y: " + y);
        System.out.println(" width: " + width);
        System.out.println("height: " + height);
    }
}
