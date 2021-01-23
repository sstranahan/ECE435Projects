package ASSIGNMENT_3_SVG;



public class Line {
    // Public Variables
    public int x1;
    public int x2;
    public int y1;
    public int y2;

    public Stroke stroke;

    // Public Methods
    public Line(int x1, int x2, int y1, int y2, Stroke stroke) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.stroke = stroke;
    }

    public double getLength() {
        return Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
    }

    public void print(String label) {
        System.out.println("Line - " + label + ":");
        System.out.println("X1: " + x1 + "\tX2: " + x2 + "\tY1: " + y1
                + "\tY2: " + y2 + "\tStroke: " + stroke);
    }

    public void print() {
        System.out.println("Line: ");
        System.out.println("X1: " + x1 + "\tX2: " + x2 + "\tY1: " + y1
                + "\tY2: " + y2 + "\tStroke: " + stroke);
    }

}
