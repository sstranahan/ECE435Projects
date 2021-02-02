package EX5_Inheritance_Setters_getters;

import edu.me.shapes.Rectangle;
import edu.me.shapes.RoundedRectangle;

public class Main {

    public static void main(String[] args) {

        printBanner();

        Rectangle r1 = new Rectangle(10,20,20,30);
        r1.print("r1");

        printBanner();

        RoundedRectangle r2 = new RoundedRectangle(10,20,20,30,5);
        r2.print("r2");

        printBanner();

        System.out.println("r1 area: " + r1.getArea());

        printBanner();
        System.out.println("r2 area: " + r2.getArea());

        printBanner();

    }

    public static void printBanner() {
        System.out.println("************************************************");
    }

}
