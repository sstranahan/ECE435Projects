package ASSIGNMENT_3_SVG;

public class Fill {
    public int red;
    public int green;
    public int blue;

    public Fill(){
        red = 0;
        green = 0;
        blue = 0;
    }

    public Fill(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void print(String label) {
        System.out.println("Fill object: " + label);
        System.out.println("   red: " + red);
        System.out.println("   green: " + green);
        System.out.println("   blue: " + blue);
    }
}
