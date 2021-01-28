package EX4_MoreAdvancedJava;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> intList;
        intList = new ArrayList<Integer>();

        intList.add(12);
        intList.add(45);
        intList.add(67);
        intList.add(111);
        intList.add(99);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }



    }

}
