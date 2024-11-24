// Experiment 8: (friend function with inline function, friend function with another class)
// Implement Two Class name is class_2,class_1 define one function name is exchange this function work in
// both class properties. friend function can be called by reference inthis case copies of the object are not
// made. Instead a pointer to the address of the object is passed

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Class_1;
class Class_2;

class Class_1
{
    int a;

public:
    Class_1(int a1)
    {
        a = a1;
    }
    inline int display1(){return a;}
    friend void exchange(Class_1 &obj1, Class_2 &obj2);
};

class Class_2
{
    int b;

public:
    Class_2(int b1)
    {
        b = b1;
    }
    inline int display2(){return b;}
    friend void exchange(Class_1 &obj1, Class_2 &obj2);
};
void exchange(Class_1 &obj1, Class_2 &obj2)
    {
        int temp=obj1.a;
        obj1.a=obj2.b;
        obj2.b=temp;
    }

int main()
{
    Class_1 c1(10);
    Class_2 c2(20);
    exchange(c1,c2);
    cout<<"C1:" <<c1.display1()<<endl;
    cout<<"C2:" <<c2.display2()<<endl;
    return 0;
}