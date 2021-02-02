package EX5_Inheritance_Setters_getters;

public class XSamples {

    private double xmin;
    private double xmax;
    private double step;

    private int n;
    private double[] x;

    public XSamples(double xmin_in, double xmax_in, double step_in){
        xmin = xmin_in;
        xmax = xmax_in;
        step = step_in;

        sample();
    }

    public void sample(){
        n = (int)((xmax-xmin)/step+1);
        x = new double[n];

        for (int i = 0; i < n; i++) {
            x[i] = xmin+i*step;
        }
    }
    public void print(String label){
        System.out.println("XSamples object: "+label);
        System.out.println("  [xmin,xmax]: ["+xmin+","+xmax+"]");
        System.out.println("  step: "+step);
        System.out.println("  n: "+n);
        System.out.print("  x:" );

        for (int i = 0; i < n; i++) {
            System.out.format("%.2f ", x[i]);
        }
    }

    public double getXmin() {
        return xmin;
    }

    public void setXmin(double xmin) {
        this.xmin = xmin;
        sample();
    }

    public double getXmax() {
        return xmax;
    }

    public void setXmax(double xmax) {
        this.xmax = xmax;
        sample();
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
        sample();
    }
}
