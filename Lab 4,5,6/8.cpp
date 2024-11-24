// Experiment 8: Write a C++ Program to implement the arithmetic operations multiplication on complex
// numbers using the concept of this pointer, inline functions and scope resolution operator.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Complex
{
private:
    int real, imag;

public:
    Complex(int r, int i)
    {
        real = r;
        imag = i;
    }
    inline Complex multiply(Complex &c)
    {
        Complex result(0, 0);
        result.real = (this->real * c.real) - (this->imag * c.imag);
        result.imag = (this->real * c.real) + (this->imag * c.imag);
        return result;
    }
    void display();
};
    void Complex::display()
    {
        cout << "Real part: " << real << endl;
        cout << "Imag part: " << imag << endl;
    }
int main()
{
    Complex c1(3, 4), c2(5, 6);
    Complex c3=c1.multiply(c2);
    c3.display();
    return 0;
}