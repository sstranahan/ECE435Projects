package ASSIGNMENT_3_SVG;

// ECE 435 - Assignment 3
// Prof. Paul Watta
// Author: Stephen Stranahan
// January, 2021

// TODO: Generate unique image

public class Main2 {
    public static void main(String[] args) {

        double minDistance = 50000;
        int minIdx = 0;

        // Max size of strokeArray for dashed stroke
        final int STROKE_ARR_MAX = 16;
        // Number of circles to draw
        final int CIRC_ARR_MAX = 100;
        // Max radius of circle
        final int RADIUS_MAX = 50;
        final double PI = 3.141592;

        SvgMaker svg = new SvgMaker("myFile.svg",1920,1080);

        svg.initFileWriter();
        svg.writeRootTag();

        Stroke s1 = new Stroke(0,0,0,5);
        Fill f1 = new Fill (255, 255, 0, 1.0);
        Fill f2 = new Fill (0, 255, 0, 1.0);
        Fill f3 = new Fill (0, 0, 255, 1.0);
        Fill f4 = new Fill (255, 0, 0, 1.0);

        Circle[] circArr = new Circle[CIRC_ARR_MAX];
        Circle[] circArr2 = new Circle[CIRC_ARR_MAX];
        Circle[] circArr3 = new Circle[CIRC_ARR_MAX];
        Circle[] circArr4 = new Circle[CIRC_ARR_MAX];

        // Initial circle at center of canvas
        circArr[0] = new Circle(960, 540, 20, s1, f1);
        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            int newR = (int )(Math.random() * RADIUS_MAX);
            circArr[i] = new Circle((int)(circArr[i-1].getCx() + ((circArr[i-1].getR() + newR) * Math.cos(PI/4))),
                    (int)(circArr[i-1].getCy() + ((circArr[i-1].getR() + newR) * Math.sin(PI/4))), newR, s1, f1);
        }

        circArr2[0] = new Circle(960, 540, 20, s1, f1);
        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            int newR = (int )(Math.random() * RADIUS_MAX);
            circArr2[i] = new Circle((int)(circArr2[i-1].getCx() + ((circArr2[i-1].getR() + newR) * Math.cos(3 * PI/4))),
                    (int)(circArr2[i-1].getCy() + ((circArr2[i-1].getR() + newR) * Math.sin(3 * PI/4))), newR, s1, f2);
        }

        circArr3[0] = new Circle(960, 540, 20, s1, f1);
        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            int newR = (int )(Math.random() * RADIUS_MAX);
            circArr3[i] = new Circle((int)(circArr3[i-1].getCx() + ((circArr3[i-1].getR() + newR) * Math.cos(5 * PI/4))),
                    (int)(circArr3[i-1].getCy() + ((circArr3[i-1].getR() + newR) * Math.sin(5 * PI/4))), newR, s1, f3);
        }

        circArr4[0] = new Circle(960, 540, 20, s1, f1);
        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            int newR = (int )(Math.random() * RADIUS_MAX);
            circArr4[i] = new Circle((int)(circArr4[i-1].getCx() + ((circArr4[i-1].getR() + newR) * Math.cos(7 * PI/4))),
                    (int)(circArr4[i-1].getCy() + ((circArr4[i-1].getR() + newR) * Math.sin(7 * PI/4))), newR, s1, f4);
        }

        // Write objects to .svg file
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
        svg.writeClosingTag();
    }


    // Returns angle off x-axis of line between two given points
    public static double getAngle(Circle c1, Circle c2) {
        return Math.atan2(c2.getCy() - c1.getCy(), c2.getCx() - c1.getCx());
    }

    // Returns distance between 2 points
    public static double getDistance(Circle c1, Circle c2) {
        return Math.sqrt(((c1.getCx() - c2.getCx())*(c1.getCx() - c2.getCx()))
                +((c1.getCy() - c2.getCy())*(c1.getCy() - c2.getCy())));
    }

    // Moves circle into contact with other circle
    public static void moveCircle(Circle mover, Circle fixed) {
        double theta = getAngle(fixed, mover);
        mover.setCx(((int)(fixed.getCx() + ((mover.getR() + fixed.getR()) * Math.cos(theta)))));
        mover.setCy(((int)(fixed.getCy() + ((mover.getR() + fixed.getR()) * Math.sin(theta)))));
    }
}