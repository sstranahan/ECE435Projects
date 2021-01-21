package EX2_AdvancedJavaConstructs;

public class Main {

    public static void main (String[] args) {

        Complex cpx = new Complex(23.4,39.7);
        cpx.print("MyNum");

        cpx.setX(19.9);
        cpx.print("MyNum");

        Complex cpx2 = new Complex();
        cpx2.print("MyNum2");

        System.out.println();
        System.out.println("MyNum Magnitude: " + cpx.magnitude());

        Complex sum;
        sum = new Complex();

        sum = cpx.add(cpx2);
        sum.print("Sum Complex");
    }
}

// Note: CTRL + j for list of shortcuts