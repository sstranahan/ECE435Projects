package edu.me.shapes;

public class Circle extends Shape{
    private double x;
    private double y;
    private double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public void print(String label) {
        System.out.println("Circle object: " + label);
        System.out.println("     x: " + x);
        System.out.println("     y: " + y);
        System.out.println("     r: " + r);
    }
}
