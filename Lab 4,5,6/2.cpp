//  Experiment 2. The monthly telephone bill is to be computed as follows:
//  Minimum Rs. 200 for up to 100 calls
//  Plus Rs. 0.60 per call for next 50 calls
//  Plus Rs. 0.50 per call for next 50 calls
//  Plus Rs. 0.40 per call for any call beyond 200 calls.
// The input contains the name of the customer and the number of calls made and the desired output is the name 
// and telephone bill to be paid by the customer.
// Create a class to represent an employee. It should include the following:
//  Data Members:
//  Name 
//  Number of calls
//  Bill amount
//  Member Functions:
//  To input data
//  To compute bill
//  To output the desired information
// Using this class, write a program to accomplish the intended task.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Employee
{
    private: 
    string name;
    int numCalls;
    float cost;

    public:
    void inputData()
    {
        cout << "Enter customer's name: ";
        cin >> name;
        cout << "Enter the number of calls: ";
        cin >> numCalls;
    }
    double computeBill()
    {
        if(numCalls<=100) {cost=200;}
        else if(numCalls>100 && numCalls<=150){
            cost=200+(numCalls-100)*0.6;
        }
        else if(numCalls>150 && numCalls<=200){
            cost=200+50*0.6+(numCalls-150)*0.5;
        }
        else if(numCalls>200)
        {
            cost=200+50*0.6+50*0.5+(numCalls-200)*0.4;
        }
        return cost;
    }

    void outputInfo()
    {
        cout<<"Name: "<<name<<endl;
        cout<<"Bill for "<<name<<" is "<<cost<<" Rs."<<endl;
    }
};
int main()
{
    Employee emp;
    double cost=0;
    emp.inputData();
    cost=emp.computeBill();
    emp.outputInfo();
    return 0;
}