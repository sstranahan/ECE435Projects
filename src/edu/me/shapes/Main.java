package edu.me.shapes;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> myList = new ArrayList<Shape>();

        Rectangle r1 = new Rectangle(0,0,10,10);
        Circle c1 = new Circle(0,0,10);
        Circle c2 = new Circle(10,10,15);
        RoundedRectangle r2 = new RoundedRectangle(10,10,20,25,3);

        myList.add(r1);
        myList.add(c1);
        myList.add(c2);
        myList.add(r2);

        for (int i = 0; i < myList.size(); i++) {
            myList.get(i).print(" ... ");
        }

    }
}
