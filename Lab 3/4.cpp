// Experiment 4. Create a class to represent a bank account. It should include the following:
//  Data Members:
//  Name of account holder
//  Account number
//  Type of account
//  Balance amount
//  Member Function:
//  To initialize the data members with appropriate data
//  To deposit an amount
// To withdraw an amount after checking the balance
// To display details of account holder
// Write a program to use this class.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Bank
{
private:
    string name;
    int accNo;
    string accType;
    double balance = 100000;
    string password = "ved1234";
    string pass;

public:
    void getData()
    {
        cout << "Enter details of the account holder." << endl;
        cout << "Enter the name of the account holder: ";
        cin >> name;
        cout << "Enter the account number: ";
        cin >> accNo;
        cout << "Enter your password: ";
        cin >> pass;
        if (pass == password)
        {
            cout << "Welcome." << endl;
        }
        else
        {
            cout << "try again" << endl;
            // getData();
        }
    }

    void deposit()
    {
        double deposit;
        cout << "\nTo deposit money" << endl;
        cout << "Enter user name: ";
        cin >> name;
        cout << "Enter your password: ";
        cin >> pass;
        if (pass == password)
        {
            cout << "Successfully entered." << endl;
            cout << "You can now deposit your money.\n"
                 << endl;
            cout << "Current balance in your account: " << balance << endl;
            cout << "Enter amount to deposit: ";
            cin >> deposit;
            cout << "Enter your password again..." << endl;
            cin >> pass;
            if (pass == password)
            {
                cout << "Successfully deposited " << deposit << " in your bank account" << endl;
                balance += deposit;
                cout << "Current balance in your account: " << balance << endl;
            }
            else
            {
                cout << "Wrong password entered.";
            }
        }
        else
        {
            cout << "Wrong password entered.";
        }
    }
    void withdraw()
    {
        double withdraw;
        cout << "\nTo withdraw money" << endl;
        cout << "Enter user name: ";
        cin >> name;
        cout << "Enter your password: ";
        cin >> pass;
        if (pass == password)
        {
            cout << "Successfully entered." << endl;
            cout << "You can now withdraw your money.\n"
                 << endl;
            cout << "Current balance in your account: " << balance << endl;
            cout << "Enter amount to withdraw: ";
            cin >> withdraw;
            cout << "Enter your password again..." << endl;
            cin >> pass;
            if (pass == password)
            {
                cout << "Successfully withdrawn " << withdraw << " in your bank account" << endl;
                balance -= withdraw;
                cout << "Current balance in your account: " << balance << endl;
            }
            else
            {
                cout << "Wrong password entered.";
            }
        }
        else
        {
            cout << "Wrong password entered.";
        }
    }

    void details()
    {
        cout << "User name: " << name << endl;
        cout << "Account number: " << accNo << endl;
        cout << "Current Balance: " << balance << endl;
    }
};
int main()
{
    Bank b1;
    b1.getData();
    int choice;
    while (true)
    {
    cout<<"Enter your choice: ";
    cin>>choice;
    switch (choice) {
    case 1:
        b1.details();
        break;
    case 2:
        b1.deposit();
        break;
    case 3:
        b1.withdraw();
        break;

    default:
        cout << "Wrong choice.";
        break;
    }
}
return 0;
}