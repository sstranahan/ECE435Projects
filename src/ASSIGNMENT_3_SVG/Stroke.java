package ASSIGNMENT_3_SVG;

public class Stroke {

    // Private variables
    private int red;
    private int green;
    private int blue;
    private int strokeWidth;

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

// Public Methods
    public Stroke(int red, int green, int blue, int strokeWidth) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.strokeWidth = strokeWidth;
    }

    public void print(String label) {
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Stroke - " + label + ":");
        System.out.println("***********************************************************************************************************");
        System.out.println("Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\tWidth: " + strokeWidth);
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

    public void print() {
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Stroke: ");
        System.out.println("***********************************************************************************************************");
        System.out.println("Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\tWidth: " + strokeWidth);
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

    public String toString() {
        return ("Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\tWidth: " + strokeWidth);
    }
}
