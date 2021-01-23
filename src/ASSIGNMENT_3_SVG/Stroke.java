package ASSIGNMENT_3_SVG;

public class Stroke {

    // Public variables
    public int red;
    public int green;
    public int blue;
    public int strokeWidth;

    // Public Methods


    public Stroke(int red, int green, int blue, int strokeWidth) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.strokeWidth = strokeWidth;
    }

    public void print(String label) {
        System.out.println("\tStroke - " + label + ":");
        System.out.println("Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\tWidth: " + strokeWidth);
    }

    public void print() {
        System.out.println("\tStroke: ");
        System.out.println("Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\tWidth: " + strokeWidth);
    }

    public String toString() {
        return ("Stroke -- Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\tWidth: " + strokeWidth);
    }

}
