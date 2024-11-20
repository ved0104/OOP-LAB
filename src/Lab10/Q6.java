//Q.6) Build a simple quiz application with multiple-choice questions.
//Requirements:
//         Display questions with four options and a Submit button.
// Track and display the score as the user progresses through the questions.
//         Provide a Next button to move to the next question.
//         Show a Finish button at the end of the quiz to display the final score.
// Use JLabel for questions and JRadioButton for answer choices.
package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q6 extends JFrame {
    // GUI Components
    private JLabel questionLabel; // Label to display the current question
    private JRadioButton[] options; // Array of radio buttons for answer options
    private ButtonGroup optionsGroup; // ButtonGroup to group the radio buttons
    private JButton nextButton; // Button to move to the next question
    private JButton finishButton; // Button to finish the quiz

    // Quiz logic variables
    private int currentQuestionIndex = 0; // Index of the current question
    private int score = 0; // Tracks the user's score

    // Sample questions and corresponding options
    private String[] questions = {
            "What is the capital of India?",
            "Which planet is known as the Blue Planet?",
            "What is the largest ocean on Earth?",
            "Which element has the chemical symbol 'O'?",
            "What is the square root of 16?"
    };

    private String[][] optionsText = {
            {"Berlin", "Madrid", "Delhi", "Lisbon"},
            {"Mars", "Earth", "Jupiter", "Saturn"},
            {"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"},
            {"Oxygen", "Gold", "Osmium", "Oganesson"},
            {"2", "4", "8", "16"}
    };

    // Indexes of correct answers corresponding to the questions array
    private int[] correctAnswers = {2, 1, 3, 0, 1};

    public Q6() {
        // Set up the main JFrame
        setTitle("Simple Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on screen
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        // Initialize GUI components
        questionLabel = new JLabel(); // Label to display the question
        options = new JRadioButton[4]; // Array for 4 answer options
        optionsGroup = new ButtonGroup(); // Group the radio buttons

        // Add question label to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Span across all columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the label
        add(questionLabel, gbc);

        // Add radio buttons for options to the frame
        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton(); // Initialize each option button
            optionsGroup.add(options[i]); // Add each button to the group
            gbc.gridx = 0;
            gbc.gridy = i + 1; // Position each option below the question
            gbc.gridwidth = 1; // Reset to 1 column
            gbc.anchor = GridBagConstraints.WEST; // Align to the left
            add(options[i], gbc);
        }

        // Add Next button
        nextButton = new JButton("Next");
        gbc.gridx = 0;
        gbc.gridy = options.length + 1; // Position below options
        add(nextButton, gbc);

        // Add Finish button (initially hidden)
        finishButton = new JButton("Finish");
        finishButton.setVisible(false);
        gbc.gridx = 1;
        add(finishButton, gbc);

        // Action listener for the Next button
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(); // Check if the selected answer is correct
                currentQuestionIndex++; // Move to the next question
                if (currentQuestionIndex < questions.length) {
                    loadQuestion(); // Load the next question
                } else {
                    nextButton.setVisible(false); // Hide Next button
                    finishButton.setVisible(true); // Show Finish button
                }
            }
        });

        // Action listener for the Finish button
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the final score in a dialog box
                JOptionPane.showMessageDialog(null, "Your final score is: " + score + "/" + questions.length);
                System.exit(0); // Exit the application
            }
        });

        loadQuestion(); // Load the first question
        setVisible(true); // Make the frame visible
    }

    // Load the current question and its options
    private void loadQuestion() {
        questionLabel.setText(questions[currentQuestionIndex]); // Set question text
        for (int i = 0; i < options.length; i++) {
            options[i].setText(optionsText[currentQuestionIndex][i]); // Set option text
            options[i].setSelected(false); // Deselect any previously selected option
        }
    }

    // Check if the selected answer is correct
    private void checkAnswer() {
        int selectedOption = -1;
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                selectedOption = i; // Get the selected option index
                break;
            }
        }
        if (selectedOption == correctAnswers[currentQuestionIndex]) {
            score++; // Increment score if the answer is correct
        }
    }

    public static void main(String[] args) {
        // Run the application on the Swing event dispatch thread
        SwingUtilities.invokeLater(() -> new Q6());
    }
}
