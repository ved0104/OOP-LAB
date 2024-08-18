// Experiment 2:
// The librarian in a library wants an application that will calculate the due date for a book given the issue date. The no. Of
// days in which the book is due can be decided by the librarian at the time of issued a book. For e.g. If the librarian enters
// the current date as 14-01-99 and the no of days in which the book is due as 15, then your program should calculate the
// due date and give the output as 29-01-99.
// Note: Use the concept of inline, default argument, const function and static function.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Library //constructing a class for the library
{
public:
    int issueDate = 0; // the date at which the book is issued
    int dueDate = 0; // the date at which the book is due
    int days = 0;   // no of days in which book is due

    Library(int iD = 1, int d = 15)
    {
        issueDate = iD;
        days = d;
    }
    void CalDueDate()
    {
        dueDate = (issueDate + days)%30;
        cout << "Due date: " << dueDate;
    }
};
int main()
{
    Library l(20,15);
    l.CalDueDate();
    return 0;
}