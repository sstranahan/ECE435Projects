package ASSIGNMENT_3_SVG;

public class Fill {
    // Public variables
    public int red;
    public int green;
    public int blue;
    public double opacity;

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
        this.opacity = opacity;
    }

    public void print(String label) {
        System.out.println("Fill - " + label + ":" );
        System.out.println("\tRed: " + red + "\tGreen: " + green + "\tBlue: " + blue);
    }

    public void print() {
        System.out.println("Fill: ");
        System.out.println("\tRed: " + red + "\tGreen: " + green + "\tBlue: " + blue);
    }
}
