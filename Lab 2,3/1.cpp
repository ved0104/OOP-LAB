// A department store places an order with a company for n pieces of miners, m pieces of 
// toasters, and P number of fans. The cost of each item is as follows:
//  Miners: Rs. 1,500 per piece
//  Toaster: Rs. 200 per piece
//  Fan: Rs. 450 per piece
// The discount allowed for various items are 5% for miners, 15% for fan, and 10% for toaster.
// The company charge 10% as sales tax on all items on net value after deducting the discount.
// Write a program that reads m, n, and p and computes the amount to be paid by the store.
// Note: Use the concept of inline, default argument, const function and static function.

#include<iostream>
#include<bits/stdc++.h>
using namespace std;

// Define a class to represent the store's order
class store {
    public:
    int m, n, p; // number of miners, toasters, and fans
    double cost = 0; // total cost of the order

    // Function to calculate the total cost of the order
    double calCost(int n, int m, int p) {
        // Calculate the cost of each item after discount
        cost = (n * 1500 - (n * 1500 * 0.05)) + 
               (m * 200 - (m * 200 * 0.1)) + 
               (p * 450 - (p * 450 * 0.15));

        // Add 10% sales tax on the net value after discount
        cost *= 1.1;
        return cost;
    }
};
int main() {
    store s; //an instance of the class store
    int m, n, p; // input variables for number of miners, toasters, and fans
    double cost; // variable to store the total cost

    cout << "Enter number of miners: ";
    cin >> n;

    cout << "Enter number of toasters: ";
    cin >> m;

    cout << "Enter number of fans: ";
    cin >> p;

    // Calculate the total cost using the calCost function
    cost = s.calCost(n, m, p);

    // Display the total cost
    cout << "Total cost = " << cost;
    return 0;
}