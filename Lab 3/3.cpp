// Experiment 3. Income tax for individuals is computed on slab rates as follows:
// Income Tax Payable
// Upto Rs. 1,00,000/- Nill
// From Rs. 1,00,001/- to Rs. 1,50,000/- 10% of the excess over Rs. 1,00,000/-
// From Rs. 1,51,001/- to Rs. 200,000/- 20% of the excess over Rs. 1,50,000/-
// Above Rs. 2,00,000/- 30% of the excess over Rs. 2,00,000/-
// The input contains name of the individual and income and the desired output is the name of the 
// individual and amount of tax to be paid by the individual.
// Create a class to represent an employee. It include the following:
//  Data Members:
//  Name
//  Income
//  Tax due
//  Member Functions:
//  To input data
//  To compute tax
//  To output the desired information

#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class IncomeTax{
    private:
    string name;
    double income;
    double tax=0;

    public:
    void getData(){
        cout<<"Enter Employee's name: ";
        cin>>name;
        cout<<"Enter income of the Employee: ";
        cin>>income;
    }

    double computeTax(){
        if(income<0) cout<<"Enter valid income."<<endl;
        else if(income<=100000) tax=0;
        else if(income>100001 && income<=150000) tax=(income-100000)*0.10;
        else if(income>150001 && income<=200000) tax=(income-150000)*0.20;
        else tax=(income-200000)*0.30;
    }

    void display(){
        cout<<name<<", your income is: "<<income<<endl;
        cout<<"Tax to be paid: "<<tax<<endl;
    }
};
int main()
{
    IncomeTax it;
    it.getData();
    it.computeTax();
    it.display();
    return 0;
}
