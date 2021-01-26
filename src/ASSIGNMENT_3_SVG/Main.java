package ASSIGNMENT_3_SVG;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

// TODO: Write algorithm to generate image
// TODO: Path class

public class Main {
    public static void main(String[] args) {

        double rangeMin = 0.98;
        double rangeMax = 1.0;

        Random r = new Random();

        System.out.println(((rangeMin + (rangeMax - rangeMin)) * r.nextDouble()
                * ( r.nextBoolean() ? 1 : -1 )));

        final int STROKE_ARR_MAX = 16;
        final int CIRC_ARR_MAX = 100;

        Stroke s1 = new Stroke(0,0,0,5);
        Fill f1 = new Fill (255, 255, 0, 1.0);

        Circle[] circArr = new Circle[CIRC_ARR_MAX];

        circArr[0] = new Circle((int)(Math.random() * 1290),(int)(Math.random() * 1080), (int)(Math.random() * 30),s1, f1);

        // Method to draw algorithmic connected circles
        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            circArr[i] = new Circle((int) ((((rangeMin + (rangeMax - rangeMin) * r.nextDouble())
                    * ( r.nextBoolean() ? 1 : -1 )) * circArr[i-1].getR()) + circArr[i-1].getCx()),
                    (int) ((((rangeMin + (rangeMax - rangeMin) * r.nextDouble())
                            * ( r.nextBoolean() ? 1 : -1 )) * circArr[i-1].getR()) + circArr[i-1].getCy()), (int)(Math.random() * 30), s1, f1);
        }

        Circle[] circArr2 = new Circle[CIRC_ARR_MAX];

        circArr2[0] = new Circle((int)(Math.random() * 1290),(int)(Math.random() * 1080), (int)(Math.random() * 30),s1, f1);

        // Method to draw algorithmic connected circles
        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            circArr2[i] = new Circle((int) ((((rangeMin + (rangeMax - rangeMin) * r.nextDouble())
                    * ( r.nextBoolean() ? 1 : -1 )) * circArr2[i-1].getR()) + circArr2[i-1].getCx()),
                    (int) ((((rangeMin + (rangeMax - rangeMin) * r.nextDouble())
                            * ( r.nextBoolean() ? 1 : -1 )) * circArr2[i-1].getR()) + circArr2[i-1].getCy()), (int)(Math.random() * 30), s1, f1);
        }

        Circle[] circArr3 = new Circle[CIRC_ARR_MAX];

        circArr3[0] = new Circle((int)(Math.random() * 1290),(int)(Math.random() * 1080), (int)(Math.random() * 30),s1, f1);

        // Method to draw algorithmic connected circles
        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            circArr3[i] = new Circle((int) ((((rangeMin + (rangeMax - rangeMin) * r.nextDouble())
                    * ( r.nextBoolean() ? 1 : -1 )) * circArr3[i-1].getR()) + circArr3[i-1].getCx()),
                    (int) ((((rangeMin + (rangeMax - rangeMin) * r.nextDouble())
                            * ( r.nextBoolean() ? 1 : -1 )) * circArr3[i-1].getR()) + circArr3[i-1].getCy()), (int)(Math.random() * 30), s1, f1);
        }

        Circle[] circArr4 = new Circle[CIRC_ARR_MAX];

        circArr4[0] = new Circle((int)(Math.random() * 1290),(int)(Math.random() * 1080), (int)(Math.random() * 30),s1, f1);

        // Method to draw algorithmic connected circles
        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            circArr4[i] = new Circle((int) ((((rangeMin + (rangeMax - rangeMin) * r.nextDouble())
                    * ( r.nextBoolean() ? 1 : -1 )) * circArr4[i-1].getR()) + circArr4[i-1].getCx()),
                    (int) ((((rangeMin + (rangeMax - rangeMin) * r.nextDouble())
                            * ( r.nextBoolean() ? 1 : -1 )) * circArr4[i-1].getR()) + circArr4[i-1].getCy()), (int)(Math.random() * 30), s1, f1);
        }

        Circle[] circArr5 = new Circle[CIRC_ARR_MAX];

        circArr5[0] = new Circle((int)(Math.random() * 1290),(int)(Math.random() * 1080), (int)(Math.random() * 30),s1, f1);

        // Method to draw algorithmic connected circles
        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            circArr5[i] = new Circle((int) ((((rangeMin + (rangeMax - rangeMin) * r.nextDouble())
                    * ( r.nextBoolean() ? 1 : -1 )) * circArr5[i-1].getR()) + circArr5[i-1].getCx()),
                    (int) ((((rangeMin + (rangeMax - rangeMin) * r.nextDouble())
                            * ( r.nextBoolean() ? 1 : -1 )) * circArr5[i-1].getR()) + circArr5[i-1].getCy()), (int)(Math.random() * 30), s1, f1);
        }

        SvgMaker svg = new SvgMaker("myFile.svg",1920,1080);

        svg.initFileWriter();
        svg.writeRootTag();

        for (int i = 0; i < CIRC_ARR_MAX; i++) {
            svg.drawCircle(circArr[i]);
        }
        for (int i = 0; i < CIRC_ARR_MAX; i++) {
            svg.drawCircle(circArr2[i]);
        }
        for (int i = 0; i < CIRC_ARR_MAX; i++) {
            svg.drawCircle(circArr3[i]);
        }
        for (int i = 0; i < CIRC_ARR_MAX; i++) {
            svg.drawCircle(circArr4[i]);
        }
        for (int i = 0; i < CIRC_ARR_MAX; i++) {
            svg.drawCircle(circArr5[i]);
        }

        svg.writeClosingTag();
    }
}
