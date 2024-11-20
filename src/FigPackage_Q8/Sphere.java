package FigPackage_Q8;

public class Sphere extends Figure {
    public Sphere(double r) {
        super(r);
    }

    @Override
    public void calcArea() {
        a = (4 * pi * r * r);
    }

    @Override
    public void calcVolume() {
        v = (4 * pi * r * r * r) / 3;
    }

    @Override
    public void dispArea() {
        System.out.println("Area of Sphere is: " + a);
    }

    @Override
    public void dispVolume() {
        System.out.println("Volume of Sphere is: " + v);

    }
}



