// Write a program to find mean of two numbers belonging to two different classes using
// friend function.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
class Class2;
class Class1
{
    double x;
    public:
    Class1(double x){
        this->x=x;
    }
    friend double mean(Class1 x,Class2 y);
};
class Class2
{
    double y;
    public:
    Class2(double y){
        this->y=y;
    }
    friend double mean(Class1 x,Class2 y);
};
double mean(Class1 obj1, Class2 obj2)
{
    return (obj1.x + obj2.y) / 2;
}
int main()
{
    Class1 c1(2);
    Class2 c2(3);

    cout<<mean(c1, c2);
    return 0;
}