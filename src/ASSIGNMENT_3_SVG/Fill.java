package ASSIGNMENT_3_SVG;

public class Fill {
    // Private variables
    private int red;
    private int green;
    private int blue;
    private double opacity;

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

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    // Public methods
    public Fill(){
        red = 0;
        green = 0;
        blue = 0;
        opacity = 0;
    }

    public Fill(int red, int green, int blue, double opacity) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        if (opacity <= 1.0 && opacity >= 0.0) {
            this.opacity = opacity;
        }
        else {
            System.out.println("Error - opacity must be between 0 and 1.");
            System.exit(1);
        }
    }

    public void print(String label) {
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Fill - " + label + ":" );
        System.out.println("***********************************************************************************************************");
        System.out.println("Red: " + red + "\tGreen: " + green + "\tBlue: " + blue);
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

    public void print() {
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Fill: ");
        System.out.println("***********************************************************************************************************");
        System.out.println("Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\tOpacity: " + opacity);
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

    public String toString() {
        return ("Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\tOpacity: " + opacity);
    }
}
