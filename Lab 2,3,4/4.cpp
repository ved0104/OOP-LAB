// Experiment 4. Create a class named Student with the following specifications:
//  Private Members:
//  admno of type integer to represent admission number
//  Name of type character to represent name ( max 20 characters)
//  marksEng of type float to represent marks in the subject of English
//  marKsMaths of type float to represent marks in the subject of
//  mathematics
//  marksSci of type float to represent marks in the subject of Science
//  total of type float to represent total marks
//  compute() A function to compute sum of marks in English, Maths and
//  Science
//  Public Members:
//  readData() A function to accept the data for admNo, name, marksEng,
//  MarksMaths, marksSci. It also invokes compute function to
// Calculate total marks.
//  ShowData() A function that display all the data member on the
//  computer screen.
// Note: Use the concept of inline, scope resolution, default argument, const function and static function.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Student
{
private:
    int admNo;
    string name;
    float marksEng,marksMaths,marksSci,totalMarks;
    float compute();

public:
    void showData();
    void readData();
};

float Student::compute()
{
    float sum = marksEng + marksMaths + marksSci;
    return sum;
}

void Student::readData()
{
    cout << "Enter name: ";
    cin >> name;
    cout << "Enter admission number: ";
    cin >> admNo;
    cout << "Enter marks of English: ";
    cin >> marksEng;
    cout << "Enter the marks of Maths: ";
    cin >> marksMaths;
    cout << "Enter the marks of science: ";
    cin >> marksSci;
    totalMarks = compute();
}
void Student::showData()
{
    cout << "Name: " << name << endl;
    cout << "Adm no: " << admNo << endl;
    cout << "Marks in English: " << marksEng << endl;
    cout << "Marks in Maths: " << marksMaths << endl;
    cout << "Marks in Science: " << marksSci << endl;
    cout << "Total number of marks: " << totalMarks;
}

int main()
{
    Student students;
    students.readData();
    students.showData();
    return 0;
}