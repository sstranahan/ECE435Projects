package ASSIGNMENT_3_SVG;


public class RoundedRectangle extends Rectangle{

    //Public variables
    int rx;

    // Public methods
    public RoundedRectangle(int length, int width, int x, int y, int rx, Stroke stroke, Fill fill) {
        super(length, width, x, y, stroke, fill);
        this.rx = rx;
    }

    // Override print functions
    public void print(String label){
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Rounded Rectangle - " + label + ":");
        System.out.println("***********************************************************************************************************");
        System.out.println("Origin X: " + super.getX() + "\tOrigin Y: " + super.getY() + "\tLength: " + super.getLength() + "\tWidth: " + super.getWidth()
                + "\tArea: " + getArea() + "\tRX: " + rx + "\nStroke: " + super.getStroke().toString() + "\nFill: " + super.getFill().toString());
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

    public void print(){
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Rounded Rectangle: " );
        System.out.println("***********************************************************************************************************");
        System.out.println("Origin X: " + super.getX() + "\tOrigin Y: " + super.getY() + "\tLength: " + super.getLength() + "\tWidth: " + super.getWidth()
                + "\tArea: " + getArea() + "\tRX: " + rx + "\nStroke: " + super.getStroke().toString() + "\nFill: " + super.getFill().toString());
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }
}
