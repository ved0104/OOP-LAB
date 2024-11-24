// Experiment 1:
// An employer plane to pay a bonus to employees. A bonus of 10% is to be paid to employees with earning 
// at least Rs. 2000/- of the earning to others. The input contains name and earning of an employee and the 
// desired output is name and bonus to be paid to the employee.
// Create a class to represent an employee. It should incluse the following:
//  Data Members:    
//  Name
//  Earn
//  Bonus
//  Member Functions:
//  To input data
//  To compute bonus
//  To output the desired information
// Using this class, write a program to accomplish the intended task.

#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class Employee{
    private:
    string name;
    double earning;
    double bonus=0;

    public:
    void getData(){
        cout<<"Enter employee's name: ";
        cin>>name;
        cout<<"Enter earning of the employee: ";
        cin>>earning;
    }

    float computeBonus(){
        if(earning>=2000){
            bonus+=0.1*earning;
        }
    }

    void display(){
        if (bonus!=0){
            cout<<endl<<name<<", Your bonus is "<<bonus<<" Rs."<<endl;
            cout<<"Thank You";
        }
        else{
            cout<<"Sorry, "<<name<<" you're not eligible for the bonus."<<endl;
        }
    }
};
int main()
{
    Employee emp;
    emp.getData();
    emp.computeBonus();
    emp.display();
    return 0;
}