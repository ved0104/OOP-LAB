// Experiment 7: WAP that uses an overloaded constructor to dynamically allocate memory to an array and thus find
// the largest of its elements

#include <iostream>
using namespace std;

class Array
{
private:
    int *arr;
    int size;

public:
    Array(int n)
    {
        size = n;
        arr = new int[size];
    }

    void input()
    {
        cout << "Enter " << size << " elements: ";
        for (int i = 0; i < size; i++)
        {
            cin >> arr[i];
        }
    }

    void findLargest()
    {
        int max = arr[0];
        for (int i = 1; i < size; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        cout << "Largest element: " << max << endl;
    }

    ~Array()
    {
        delete[] arr;
    }
};

int main()
{
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;

    Array a(n);
    a.input();
    a.findLargest();

    return 0;
}