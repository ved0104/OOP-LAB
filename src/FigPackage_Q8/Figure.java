package FigPackage_Q8;

public abstract class Figure {
    protected double r, a, v, pi = 3.1428;

    public Figure(double r) {
        this.r = r;
    }

    public abstract void calcArea();
    public abstract void calcVolume();
    public abstract void dispArea();
    public abstract void dispVolume();
}


