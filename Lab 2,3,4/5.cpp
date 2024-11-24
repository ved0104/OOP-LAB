// WAP to add and substract two fractions. Let the add() accept the objects using call-by-value
// technique, subtract() using call-by-reference, and multiply() accept using the call-by-address technique.

#include <iostream>
using namespace std;

class Functions
{
private:
    double number;

public:
    Functions(double f)
    {
        number = f;
    }
    double add(Functions x)
    {
        return number + x.number;
    }
    double subract(Functions *y)
    {
        return number - y->number;
    }

    double multiply(Functions &y)
    {
        return number * y.number;
    }
};

int main()
{
    double f1, f2;
    cout << "Enter the number1" << endl;
    cin >> f1;
    cout << "Enter the number2" << endl;
    cin >> f2;
    Functions F1(f1), F2(f2);
    cout<<"Add: "<<F1.add(F2)<<endl;
    cout<<"Subtract: "<<F1.subract(&F2)<<endl;
    cout<<"Multiply: "<<F1.multiply(F2)<<endl;

        return 0;
}