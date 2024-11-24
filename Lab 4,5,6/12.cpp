// Experiment 10: (Operator Overloading)
// Design a class named vector to model a one-dimensional array with integer elements.
// Overload the followimg operators to perform the intended task:
// (i) Operator ‘<<’ to output a vector object
// (ii) Operator ‘>>’ to input a vector object in the form [10, 20, 30, . . .].
// (iii) Operator ‘+’ to add two vector objects.
// (iv) Operator ‘-‘ to subtract a given vector object from another vector object.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Vector
{
    int num[5];

public:
    friend ostream &operator<<(ostream &myout, Vector &v);
    friend istream &operator>>(istream &myin, Vector &v);
    // Vector operator+(Vector &v1,Vector &v2){
    //     while(i!=v1.size())
    // }
};

ostream &operator<<(ostream &myout, Vector &v){
    for(int i(0);i<5;i++){
        cout<<v.num[i]<<" ";
    }
    return myout;
}
istream &operator>>(istream &myin, Vector &v){
    for(int i(0);i<5;i++){
        cin>>v.num[i];
    }
    return myin;
}

int main()
{
    Vector v1;
    cin>>v1;
    cout<<v1;
    return 0;
}