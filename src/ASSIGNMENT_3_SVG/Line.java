package ASSIGNMENT_3_SVG;



public class Line {
    // Private Variables
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    private  Stroke stroke;

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
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Line - " + label + ":");
        System.out.println("***********************************************************************************************************");
        System.out.println("X1: " + x1 + "\tX2: " + x2 + "\tY1: " + y1
                + "\tY2: " + y2 + "\tStroke: " + stroke);
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

    public void print() {
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Line: ");
        System.out.println("***********************************************************************************************************");
        System.out.println("X1: " + x1 + "\tX2: " + x2 + "\tY1: " + y1
                + "\tY2: " + y2 + "\tStroke: " + stroke.toString());
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

}
