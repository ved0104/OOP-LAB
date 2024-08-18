// Experiment 8: Write class and object based program to deposit or withdraw money in a bank account
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class BankSystem
{
private:
    string user_name;
    string password = "qwerty";
    int balance = 200000;

public:
    void deposit_money()
    {
        string pass;
        double deposit;
        cout<<"\nTo deposit money"<<endl;
        cout << "Enter user name: ";
        cin >> user_name;
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
                balance+=deposit;
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
    void withdraw_money()
    {
        string pass;
        double withdraw;
        cout<<"\nTo withdraw money"<<endl;
        cout << "Enter user name: ";
        cin >> user_name;
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
                balance-=withdraw;
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
};
int main()
{
    BankSystem task;
    cout << "Welcome. " << endl;
    task.deposit_money();
    task.withdraw_money();
    return 0;
}