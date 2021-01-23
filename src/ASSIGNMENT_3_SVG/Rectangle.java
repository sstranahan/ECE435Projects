package ASSIGNMENT_3_SVG;

import sun.security.util.Length;

public class Rectangle {

    // Public variables
    public int length;
    public int width;
    public int x;
    public int y;
    public Stroke stroke;
    public Fill fill;


    // Public methods
    public double getArea() {
        return length * width;
    }

    public void print(String label){
        System.out.println("\tRectangle: ");
        System.out.println("Origin X: " + x + "\tOrigin Y: " + y + "\tLength: " + length + "\tWidth: " + width
                + "\tStroke: " + stroke.toString() + "\tFill: " + fill.toString());
    }

}
