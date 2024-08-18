#include <iostream>
#include <bits/stdc++.h>
using namespace std;

struct Publication
{
    string title;
    double price;
    string authName;

    friend struct Publication::Book
    {
        int count;
        void getDatd()
        {
            cout << "Enter the book's title: ";
            cin >> ;
            cout << "Enter the author's name: ";
            cin >> authName;
            cout << "Enter the price: ";
            cin >> price;
        }
        void displayData()
        {
            cout << "Book's title: " << title << endl;
            cout << "Author's name: " << name << endl;
            cout << "Book's price: " << price << endl;
        }
    } book;

    friend struct Publication::Ebook
    {
        double time;
        void getDatd()
        {
            cout << "Enter the ebook's title: ";
            cin >> title;
            cout << "Enter the author's name: ";
            cin >> authName;
            cout << "Enter the price: ";
            cin >> price;
        }
        void displayData()
        {

            cout << "EBook's title: " << title << endl;
            cout << "Author's name: " << name << endl;
            cout << "Book's price: " << price << endl;
        }
    } ebook;
} publication;
int main()
{
    publication.book.getDatd();
    publication.book.displayData();
    publication.ebook.getDatd();
    publication.ebook.displayData();
    return 0;
}