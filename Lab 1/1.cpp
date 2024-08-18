// Suppose the postal rates for mailing letters are as follows:
//  Rs. 0.50 per 10 grams for the first 50 grams,
//  Rs. 0.40 per 10 grams for the next 100 grams,
//  Rs. 0.25 per 10 grams for the next 250 grams, and
//  Rs 25 per kilogram for letters weighing more than 400 grams.
// Write a program that prompts for the weight of a letter and prints the postage to be 
//  paid.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// Define a struct to represent weight and its associated cost
struct weight
{
    int mass = 0; // weight in grams
    double cost = 0; // cost in rupees

    // Function to calculate the cost based on the weight
    double calWeight(int mass)
    {
        // Calculate cost for weights up to 50 grams
        if(mass <= 50)
        {
            cost = mass * 0.05; // Rs. 0.50 per 10 grams
        }
        // Calculate cost for weights between 51-150 grams
        else if(mass > 50 && mass <= 150)
        {
            cost = 50 * 0.05 + (mass - 50) * 0.04; // Rs. 0.40 per 10 grams
        }
        // Calculate cost for weights between 151-400 grams
        else if(mass > 150 && mass <= 400)
        {
            cost = 50 * 0.05 + 100 * 0.04 + (mass - 150) * 0.025; // Rs. 0.25 per 10 grams
        }
        // Calculate cost for weights above 400 grams
        else if (mass > 400)
        {
            cost = mass * 0.025; // Rs 25 per kilogram
        }
        return cost;
    }
} w; // create an instance of the weight struct

int main()
{
    double wt, cost; // variables to store user input and calculated cost

    cout << "Enter the weight of the letter: " << endl;
    cin >> wt; 

    // Calculate the cost based on the user input
    cost = w.calWeight(wt);

    // Display the calculated cost
    cout << "Calculated cost of the letter in Rs: " << cost << endl;

    return 0;
}