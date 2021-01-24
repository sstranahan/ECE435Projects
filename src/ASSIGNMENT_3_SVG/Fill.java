package ASSIGNMENT_3_SVG;

public class Fill {
    // Private variables
    private int red;
    private int green;
    private int blue;
    private double opacity;

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
