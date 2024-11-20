package FigPackage_Q8;

public class Demo {
    public static void main(String[] args) {
        Figure figure1=new Cone(10,2,3);
        figure1.calcArea();
        figure1.calcVolume();
        figure1.dispArea();
        figure1.dispVolume();

        Figure figure2=new Sphere(10);
        figure2.calcArea();
        figure2.calcVolume();
        figure2.dispArea();
        figure2.dispVolume();

        Figure figure3=new Cylinder(10,2);
        figure3.calcArea();
        figure3.calcVolume();
        figure3.dispArea();
        figure3.dispVolume();
    }
}
