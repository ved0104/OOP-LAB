// Experiment 9: (Dynamic memory allocation with new, delete, and destructor)
// A Program to allocate contiguous memory for an array using the new operator and the object of the array
// is destroyed by the delete operator.

#include <iostream>
using namespace std;

class Array
{
    int size;

public:
    int *arr;
    Array(int size)
    {
        this->size = size;
        arr = new int[size];
    }
    ~Array()
    {
        delete[] arr;
        cout << "Destructor is called" << endl;
    }
};

int main()
{
    int size;
    cout << "Enter the size:" << endl;
    cin >> size;
    Array *a = new Array(size);
    for (int i = 0; i < size; i++)
    {
        cout << "Enter the element at position " << i <<" : "<< endl;
        cin >> a->arr[i];
    }
    for (int i = 0; i < size; i++)
    {
        cout << a->arr[i] << " ";
    }
    cout << endl;
    delete a;
}