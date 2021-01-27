package ASSIGNMENT_3_SVG;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

// TODO: Write banner and inline comments

public class Main {
    public static void main(String[] args) {

        double minDistance = 50000;
        int minIdx = 0;

        final int STROKE_ARR_MAX = 16;
        final int CIRC_ARR_MAX = 500;

        SvgMaker svg = new SvgMaker("myFile.svg",1920,1080);

        svg.initFileWriter();
        svg.writeRootTag();

        Stroke s1 = new Stroke(0,0,0,5);
        Fill f1 = new Fill (255, 255, 0, 1.0);

        Circle[] circArr = new Circle[CIRC_ARR_MAX];

        circArr[0] = new Circle(960, 540, (int)(Math.random()*30), s1, f1);

        for (int i = 1; i < CIRC_ARR_MAX; i++) {
            circArr[i] = new Circle((int)(Math.random() * 1920),(int)(Math.random() * 1080), (int)(Math.random()*30), s1, f1);
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

    public static double getAngle(Circle c1, Circle c2) {
        return Math.atan2(c2.getCy() - c1.getCy(), c2.getCx() - c1.getCx());
    }

    public static double getDistance(Circle c1, Circle c2) {
        return Math.sqrt(((c1.getCx() - c2.getCx())*(c1.getCx() - c2.getCx()))+((c1.getCy() - c2.getCy())*(c1.getCy() - c2.getCy())));
    }

    public static void moveCircle(Circle mover, Circle fixed) {
        double theta = getAngle(fixed, mover);
        mover.setCx(((int)(fixed.getCx() + ((mover.getR() + fixed.getR()) * Math.cos(theta)))));
        mover.setCy(((int)(fixed.getCy() + ((mover.getR() + fixed.getR()) * Math.sin(theta)))));
    }
}

