package ASSIGNMENT_3_SVG;

public class DashedStroke extends Stroke{
    int[] dashArray;

    public DashedStroke(int red, int green, int blue, int strokeWidth, int[] dashArray) {
        super(red, green, blue, strokeWidth);
        this.dashArray = dashArray;
    }

    public void print(String label) {
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Stroke - " + label + ":");
        System.out.println("***********************************************************************************************************");
        System.out.print("Red: " + super.getRed() + "\tGreen: " + super.getGreen() + "\tBlue: " + super.getBlue() + "\tWidth: " + super.getStrokeWidth() + "DashArray:");
        for (int i = 0; i < dashArray.length; i++) {
            System.out.print("\t" + dashArray[i]);
        }
        System.out.println();
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

    public void print() {
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Stroke: ");
        System.out.println("***********************************************************************************************************");
        System.out.println("Red: " + super.getRed() + "\tGreen: " + super.getGreen() + "\tBlue: " + super.getBlue() + "\tWidth: " + super.getStrokeWidth() + "DashArray:");
        for (int i = 0; i < dashArray.length; i++) {
            System.out.print("\t" + dashArray[i]);
        }
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }
}
