package edu.me.shapes;

public class RoundedRectangle extends Rectangle {

    private double r;

    public RoundedRectangle(double x, double y, double width, double height, double r) {
        super(x, y, width, height);
        this.r = r;
    }

    @Override
    public void print(String label) {
        System.out.print("Rounded ");
        super.print(label);
        System.out.println("     r: " + r);
    }

    @Override
    public double getArea() {
        return super.getArea() - (r * r * (4 - Math.PI));
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
