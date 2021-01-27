package ASSIGNMENT_3_SVG;

public class Path {
    private String dString;
    private Stroke stroke;
    private Fill fill;

    public String getdString() {
        return dString;
    }

    public void setdString(String dString) {
        this.dString = dString;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Fill getFill() {
        return fill;
    }

    public void setFill(Fill fill) {
        this.fill = fill;
    }

    public Path(String dString, Stroke stroke, Fill fill) {
        this.dString = dString;
        this.stroke = stroke;
        this.fill = fill;
    }

    public void print(String label) {
        System.out.println("***********************************************************************************************************");
        System.out.println("\tPath - " + label + ":");
        System.out.println("***********************************************************************************************************");
        System.out.println("dString: " + dString
                + "\nStroke: " + stroke + "\nFill: " + fill);
        System.out.println("***********************************************************************************************************");
    }

    public void print() {
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
        System.out.println("Path: ");
        System.out.println("***********************************************************************************************************");
        System.out.println("dString: " + dString
                + "\nStroke: " + stroke.toString() + "\nFill: " + fill.toString());
        System.out.println("***********************************************************************************************************");
        System.out.println("***********************************************************************************************************");
    }

}
