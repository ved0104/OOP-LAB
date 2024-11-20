package FigPackage_Q8;

public class Cone extends Figure {
    private double s, h;

    public Cone(double r, double s, double h) {
        super(r);
        this.s = s;
        this.h = h;
    }

    @Override
    public void calcArea() {
        a = (pi * r * s) + (pi * r * r);
    }

    @Override
    public void calcVolume() {
        v = (pi * r * r * h) / 3;
    }

    @Override
    public void dispArea() {
        System.out.println("Area of Cone is: " + a);
    }

    @Override
    public void dispVolume() {
        System.out.println("Volume of Cone is: " + v);

    }
}
