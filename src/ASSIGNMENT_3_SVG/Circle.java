package ASSIGNMENT_3_SVG;

public class Circle {

    // Member variables
    public double cx;
    public double cy;
    public double r;

    //Methods
    public Circle() { }
    public Circle(double cx, double cy, double r) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    public double getArea() {
        return(Math.PI * r * r);
    }

}
