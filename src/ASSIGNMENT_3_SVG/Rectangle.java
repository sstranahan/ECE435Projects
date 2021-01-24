package ASSIGNMENT_3_SVG;

import sun.security.util.Length;

public class Rectangle {

    // Private variables
    private int length;
    private int width;
    private int x;
    private int y;
    private Stroke stroke;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Fill getFill() {
        return fill;
    }

    public void setFill(Fill fill) {
        this.fill = fill;
    }

    private Fill fill;


    // Public methods


    public Rectangle(int length, int width, int x, int y, Stroke stroke, Fill fill) {
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
        this.stroke = stroke;
        this.fill = fill;
    }

    public double getArea() {
        return length * width;
    }

    public void print(String label){
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Rectangle - " + label + ":");
        System.out.println("***********************************************************************************************************");
        System.out.println("Origin X: " + x + "\tOrigin Y: " + y + "\tLength: " + length + "\tWidth: " + width
                + "\tArea: " + getArea()  + "\nStroke: " + stroke.toString() + "\nFill: " + fill.toString());
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

    public void print(){
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Rectangle: " );
        System.out.println("***********************************************************************************************************");
        System.out.println("Origin X: " + x + "\tOrigin Y: " + y + "\tLength: " + length + "\tWidth: " + width
                + "\tArea: " + getArea()  + "\nStroke: " + stroke.toString() + "\nFill: " + fill.toString());
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

}
