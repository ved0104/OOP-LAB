// Experiment 5: Assume that a publishing company markets prints books and digital books (electronic
// form – CD’). Create a class named Publication with data members named title, price, and author’s name.
// From Publication class, derive two classes named Book and Ebook. The Book class adds a page count data
// member named pcount while Ebook adds data member playing time name ptime. Each of these classes
// must have member function getDatd() to read class specific data from keyboard and displayData() to
// output the class specific data to the computer screen. Write a program to test these classes.

#include <iostream>
using namespace std;

class Publication
{
public:
    string title;
    double price;
    string authName;
};
class Book : public Publication
{
public:
    int count;
    void getData()
    {
        cout << "Enter the book's title: ";
        getline(cin, title);
        cout << "Enter the author's name: ";
        getline(cin, authName);
        cout << "Enter the price: ";
        cin >> price;
        cout << "How many pages have you read? ";
        cin >> count;
    }
    void displayData()
    {
        cout << "Book's title: " << title << endl;
        cout << "Author's name: " << authName << endl;
        cout << "Book's price: " << price << endl;
        cout << "Page count: " << count << endl;
    }
};

class Ebook : public Publication
{
public:
    int time;
    void getData()
    {
        cout << "Enter the Ebook's title: ";
        cin>>title;
        cout << "Enter the author's name: ";
        cin>>authName;
        cout << "Enter the price: ";
        cin >> price;
        cout << "How much time have you read? ";
        cin >> time;
    }
    void displayData()
    {
        cout << "Book's title: " << title << endl;
        cout << "Author's name: " << authName << endl;
        cout << "Book's price: " << price << endl;
        cout << "Time Read: " << time << endl;
    }
};
int main()
{
    Book b;
    b.getData();
    b.displayData();
    Ebook e;
    e.getData();
    e.displayData();
    return 0;
}