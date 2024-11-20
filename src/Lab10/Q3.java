package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Calculator class implementing ActionListener for button handling
class Calculator implements ActionListener {
    JFrame frame; // Main application window
    JTextField textField; // Text field to display input and results
    JButton[] numberButtons = new JButton[10]; // Buttons for digits 0-9
    JButton[] functionButtons = new JButton[9]; // Buttons for functions like +, -, *, etc.
    JButton addButton, subButton, divButton, mulButton; // Arithmetic operator buttons
    JButton clrButton, decButton, eqlButton, delButton, negButton; // Special function buttons
    Font font = new Font("Serif", Font.PLAIN, 20); // Font style for buttons and text field
    double num1 = 0, num2 = 0; // Variables to store operands
    char operator; // Variable to store the selected operator
    double result; // Variable to store the result of operations

    // Constructor to set up the calculator UI
    Calculator() {
        // Setting up the frame
        frame = new JFrame("Calculator");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 650);
        frame.setLocationRelativeTo(null); // To align the window at the center if the screen

        // Initializing and setting up the text field
        textField = new JTextField();
        textField.setBounds(100, 50, 250, 50);
        textField.setFont(font);
        textField.setEditable(false);
        textField.setFocusable(false);

        // Initializing function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqlButton = new JButton("=");
        clrButton = new JButton("Clear");
        delButton = new JButton("Delete");
        negButton = new JButton("(-)");

        // Adding function buttons to an array for easy handling
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = eqlButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = delButton;
        functionButtons[8] = negButton;

        // Adding ActionListener and style to function buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setFont(font);
        }

        // Initializing number buttons and adding listeners
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(font);
        }

        // Setting positions for special function buttons
        negButton.setBounds(100, 500, 250 / 3, 50);
        delButton.setBounds(100 + 250 / 3, 500, 250 / 3, 50);
        clrButton.setBounds(100 + 500 / 3, 500, 250 / 3, 50);

        // Creating a panel to organize number and operator buttons in a grid
        Panel panel = new Panel();
        panel.setBounds(100, 125, 250, 350);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Adding buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqlButton);
        panel.add(divButton);

        // Adding components to the frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    // Handling button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handling number button clicks
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // Handling decimal button
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        // Handling operator buttons
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        // Handling equals button to perform the operation
        if (e.getSource() == eqlButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            textField.setText(String.valueOf(result));
            num1 = result; // Store the result for further calculations
        }

        // Handling clear button to reset the text field
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        // Handling delete button to remove the last character
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        // Handling negate button to toggle the sign
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}

// Main class to run the calculator
public class Q3 {
    public static void main(String[] args) {
        new Calculator(); // Create and display the calculator
    }
}
