package ASSIGNMENT_3_SVG;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

// TODO: Write algorithm to generate image
// TODO: Path class

public class Main {
    public static void main(String[] args) {

        final double RANGE_MIN = 0.8;
        final double RANGE_MAX = 0.9;

        final int R_MAX = 25;
        final int CANVAS_X = 1920;
        final int CANVAS_Y = 1080;

        Random r = new Random();

        final int STROKE_ARR_MAX = 16;
        final int CIRC_ARR_MAX = 1000;

        Boolean collision = false;

        // Testing methods
    //    System.out.println(getDoubleInRange(RANGE_MIN, RANGE_MAX));
    //    System.out.println(getRandSign());


        Stroke s1 = new Stroke(0,0,0,5);
        Fill f1 = new Fill (255, 255, 0, 1.0);

        Circle[] circArr = new Circle[CIRC_ARR_MAX];

        circArr[0] = new Circle((int)(Math.random() * CANVAS_X),(int)(Math.random() * CANVAS_Y), (int)(Math.random() * R_MAX),s1, f1);

        // Method to draw algorithmic connected circles
        for (int i = 1; i < CIRC_ARR_MAX; i++) {

            circArr[i] = new Circle((int)(Math.random() * CANVAS_X),(int)(Math.random() * CANVAS_Y), (int)(Math.random() * R_MAX),s1, f1);

        }

        SvgMaker svg = new SvgMaker("myFile.svg",CANVAS_X,CANVAS_Y);

        svg.initFileWriter();
        svg.writeRootTag();

        for (int i = 0; i < CIRC_ARR_MAX; i++) {
            svg.drawCircle(circArr[i]);
        }

        svg.writeClosingTag();
    }

    public static double getDoubleInRange(double rangeMin, double rangeMax) {
        Random r = new Random();
        return (rangeMin + (rangeMax - rangeMin) * r.nextDouble());
    }

    public static int getRandSign() {
        Random r = new Random();
        return ( r.nextBoolean() ? 1 : -1 );
    }

    public static double getCenterDist(Circle c1, Circle c2) {
        double distX = c1.getCx() - c2.getCx();
        double distY = c1.getCy() - c2.getCy();
        return Math.sqrt((distX * distX) + (distY * distY));
    }

}
