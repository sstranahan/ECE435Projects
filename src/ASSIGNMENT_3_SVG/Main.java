package ASSIGNMENT_3_SVG;

public class Main {
    public static void main(String[] args) {

        Stroke s1 = new Stroke(0,0,0,2 );
        Fill f1 = new Fill(128,0,0,128);

        Circle c1 = new Circle(12,12,8,s1,f1);
        Line l1 = new Line(2,8,2,8,s1);

        s1.print();
        f1.print();
        c1.print();
        l1.print();
    }
}
