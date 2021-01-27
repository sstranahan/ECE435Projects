package ASSIGNMENT_3_SVG;

// ECE 435 - Assignment 3
// Prof. Paul Watta
// Author: Stephen Stranahan
// January, 2021

// TODO: Generate unique image

public class Main {
    public static void main(String[] args) {

        double minDistance = 50000;
        int minIdx = 0;

        // Max size of strokeArray for dashed stroke
        final int STROKE_ARR_MAX = 16;
        // Number of circles to draw
        final int CIRC_ARR_MAX = 500;
        // Max radius of circle
        final int RADIUS_MAX = 20;

        SvgMaker svg = new SvgMaker("myFile.svg",1920,1080);

        svg.initFileWriter();
        svg.writeRootTag();

        Stroke s1 = new Stroke(0,0,0,5);
        Fill f1 = new Fill (255, 255, 0, 1.0);

        Circle[] circArr = new Circle[CIRC_ARR_MAX];

        // Initial circle at center of canvas
        circArr[0] = new Circle(960, 540, (int)(Math.random()*RADIUS_MAX), s1, f1);

        // Loop through - creating all circles and moving them into contact with closest circle to them
        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            circArr[i] = new Circle((int)(Math.random() * 1920),(int)(Math.random() * 1080), (int)(Math.random()*RADIUS_MAX), s1, f1);
            for (int j = 0; j < i; j++) {
                if (getDistance(circArr[i], circArr[j]) < minDistance) {
                    minDistance = getDistance(circArr[i], circArr[j]);
                    minIdx = j;
                }
            }
            moveCircle(circArr[i], circArr[minIdx]);
            minDistance = 50000;
            minIdx = 0;
        }

        // Write objects to .svg file
        for (int i = 0; i < CIRC_ARR_MAX; i++) {
            svg.drawCircle(circArr[i]);
        }
        svg.writeClosingTag();
    }


    // Returns angle off x-axis of line between two given points
    public static double getAngle(Circle c1, Circle c2) {
        return Math.atan2(c2.getCy() - c1.getCy(), c2.getCx() - c1.getCx());
    }

    // Returns distance between 2 points
    public static double getDistance(Circle c1, Circle c2) {
        return Math.sqrt(((c1.getCx() - c2.getCx())*(c1.getCx() - c2.getCx()))+((c1.getCy() - c2.getCy())*(c1.getCy() - c2.getCy())));
    }

    // Moves circle into contact with other circle
    public static void moveCircle(Circle mover, Circle fixed) {
        double theta = getAngle(fixed, mover);
        mover.setCx(((int)(fixed.getCx() + ((mover.getR() + fixed.getR()) * Math.cos(theta)))));
        mover.setCy(((int)(fixed.getCy() + ((mover.getR() + fixed.getR()) * Math.sin(theta)))));
    }
}

