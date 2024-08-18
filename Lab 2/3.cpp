// Experiment 3. Design a class named Data with day, month and year (all of type int) as its data members declared in
// private section of the class. Define the following constructor for the class:
// (i) Zero argument constructor that initialize the day, month and year data members to 12, 3 and 1993 respectively.
// (ii) Parameterized constructor which takes three arguments, all of which are declared with default values as 12, 10 and
// 2000 respectively the day, month and year data members with corresponding arguments.
// (iv) Copy constructor.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Data
{
private:
    int day,month,year;
public:
    Data(){
        this->day=12;
        this->month=3;
        this->year=1993;
        cout<<"Default constructor";
    }
    Data(int day=12,int month=10,int year=2000){
        this->day=day;
        this->month=month;
        this->year=year;
        cout<<"Parameterised constructor";
    }
};

int main()
{
    Data d1(12,12,2000);
    Data d2(d1);
    return 0;
}