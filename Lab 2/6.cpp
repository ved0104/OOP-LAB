// Experiment 6: WAP that displays the name of topper in a class

#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Students{
    public:
        string name;
        double marks;
        void getData()
        {
            cout<<"Enter the name of the student:";
            cin>>name;
            cout<<"Enter the marks of the student: ";
            cin>>marks;
        }
};
int main()
{
    int num;
    cout<<"Enter number of students: "<<endl;
    cin>>num;
    Students s[num];

    for (int i = 0; i < num; i++)
    {
        s[i].getData();
    }
    int topper_marks=s[0].marks;
    cout<<topper_marks;
    int top_idx=0;
    for (int i = 1; i < num; i++)
    {
        if(s[i].marks>topper_marks)
        {
            topper_marks=s[i].marks;
            top_idx=i;
        }
    }
    cout<<"Topper: "<<s[top_idx].name<<endl;
    
    return 0;
}