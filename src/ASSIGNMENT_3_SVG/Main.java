package ASSIGNMENT_3_SVG;

import java.sql.SQLOutput;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        final int ARR_MAX = 16;

        int[] dashArr = {2,1,3,4};

        // Create class objects
        Stroke s1 = new Stroke(0,0,0,2 );
        DashedStroke ds1 = new DashedStroke(0,0,0,2,dashArr);
        Fill f1 = new Fill(128,0,0,128);
        Circle c1 = new Circle(12,12,8,s1,f1);
        Line l1 = new Line(2,8,2,8,s1);
        Rectangle r1 = new Rectangle(25,30,0,0, s1, f1);
        RoundedRectangle r2 = new RoundedRectangle(25,25,0,0,5, ds1, f1);

        // Testing print methods
        s1.print();
        System.out.println();

        f1.print();
        System.out.println();

        c1.print();
        System.out.println();

        l1.print();
        System.out.println();

        r1.print("My rectangle");
        System.out.println();

        r1.print();
        System.out.println();

        r2.print();
        System.out.println();

    }
}
