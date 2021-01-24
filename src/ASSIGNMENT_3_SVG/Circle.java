package ASSIGNMENT_3_SVG;

public class Circle {

    // Private variables
    private double cx;
    private double cy;
    private double r;
    private Stroke stroke;

    public double getCx() {
        return cx;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }

    public double getCy() {
        return cy;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Fill getFill() {
        return fill;
    }

    public void setFill(Fill fill) {
        this.fill = fill;
    }

    private Fill fill;

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
        System.out.println("***********************************************************************************************************");
        System.out.println("\tCircle - " + label + ":");
        System.out.println("***********************************************************************************************************");
        System.out.println("Center X: " + cx + "\tCenter Y: " + cy + "\tRadius: " + r
                + "\nStroke: " + stroke + "\nFill: " + fill);
        System.out.println("***********************************************************************************************************");
    }

    public void print() {
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Circle: ");
        System.out.println("***********************************************************************************************************");
        System.out.println("Center X: " + cx + "\tCenter Y: " + cy + "\tRadius: " + r
                + "\nStroke: " + stroke.toString() + "\nFill: " + fill.toString());
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

}
