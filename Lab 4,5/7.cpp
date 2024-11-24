// Write C++ program to calculate area of a cuboid. Convert the cuboid into a cube using a
// friend class

#include <iostream>
#include <bits/stdc++.h>
#include<math.h>
using namespace std;

class Area
{
    double length;
    double width;
    double height;

public:
    friend class ConvertToCube;
    Area(double l, double w, double h)
    {
        length=l;
        width=w;
        height=h;
    }
    double calculateAreaCuboid()
    {
        double areaOfCuboid = 0;
        areaOfCuboid = 2 * (length * width + width * height + height * length);
        return areaOfCuboid;
    }
};

class ConvertToCube{
    public:
    double calSide(Area &area){
        double testSide=cbrt(area.length*area.width*area.height);
        //converts it into a cube by setting its side to the average of the original dimensions
        area.length=testSide;
        area.width=testSide;
        area.height=testSide;
        return testSide;
    }
};

int main()
{
    Area a(10, 20, 30);
    cout<<"Area of Cuboid: "<<a.calculateAreaCuboid()<<endl;
    ConvertToCube c;
    cout<<"Size of the Cube: "<<c.calSide(a)<<endl;
    return 0;
}