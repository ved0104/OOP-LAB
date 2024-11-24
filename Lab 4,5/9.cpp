// Experiment 7: Create a record of 10 employee which contains following information: emp_id.,
// emp_name, and age. Create a C++ (OOPs concept) program to search an employee with its emp_id.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Employee
{
    int emp_id;
    string emp_name;
    int age;

public:
    void getData()
    {

        cout << "Enter Emp_id: ";
        cin >> emp_id;
        cout << "Enter Emp_name: ";
        cin >> emp_name;
        cout << "Enter age: ";
        cin >> age;
    }
    friend bool searchID(int id, Employee emp)
    {
        if (emp.emp_id == id)
        {
            return true;
        }
        return false;
    }
    void showData()
    {
        cout << "Emp_id: " << emp_id << endl;
        cout << "Emp_name: " << emp_name << endl;
        cout << "Age: " << age << endl;
    }
};
int main()
{
    int n=1;
    Employee e[n];
    for (int i(0); i < n; i++)
    {
        e[i].getData();
    }
    int id;
    cout << "Enter emp_id to search: ";
    cin >> id;
    for (int i = 0; i < n; i++)
    {
        if (searchID(id, e[i])) e[i].showData();
        else cout<<"no such id exists";
    }
    return 0;
}