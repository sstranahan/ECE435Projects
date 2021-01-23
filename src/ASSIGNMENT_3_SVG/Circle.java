package ASSIGNMENT_3_SVG;

public class Circle {

    // Member variables
    public double cx;
    public double cy;
    public double r;
    public Stroke stroke;
    public Fill fill;

    //Methods
    public Circle(double cx, double cy, double r, Stroke stroke, Fill fill) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
        this.stroke = stroke;
        this.fill = fill;
    }

    public double getArea() {
        return(Math.PI * r * r);
    }

    public void print(String label) {
        System.out.println("Circle - " + label + ":");
        System.out.println("Center X: " + cx + "\tCenter Y: " + cy + "\tRadius: " + r
                + "\tStroke: " + stroke + "\tFill: " + fill);
    }

    public void print() {
        System.out.println("Circle: ");
        System.out.println("Center X: " + cx + "\tCenter Y: " + cy + "\tRadius: " + r
                + "\tStroke: " + stroke + "\tFill: " + fill);
    }

}
