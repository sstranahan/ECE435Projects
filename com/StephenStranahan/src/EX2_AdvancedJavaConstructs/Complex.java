package EX2_AdvancedJavaConstructs;

import java.lang.String;
import java.math.*;

public class Complex {

    // member variables
    private double x;
    private double y;

    // methods
    public Complex(double x_in, double y_in) {
        x = x_in;
        y = y_in;
    }

    public Complex() {
        y=0;
        x=0;
    }

    public double magnitude() {
        double sum = x*x + y*y;
        return Math.sqrt(sum);
    }

    public void conjugate() {
        y = -y;
    }

    // Could also implement this as static with two arguments, wouldnt have to call from a Complex object
    public Complex add(Complex other) {
        Complex result = new Complex();

        result.x = this.x + other.x;
        result.y = this.y + other.y;

        return result;
    }

    public String toString() {
        String str;
        str = "\n   x: " + x + "\n   y: " + y ;
        return str;
    }

    public void print(String label) {
        String str = toString();
        System.out.println("\nComplex object: " + label);
        System.out.println(str);
    }

    public void print() {
        String str = toString();
        System.out.println("\nComplex object (no label): ");
        System.out.println(str);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
