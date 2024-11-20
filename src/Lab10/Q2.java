package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Q2 {
    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user_management";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "veddub0110";

    // Creates the main GUI window
    private void createGUI() {
        JFrame frame = new JFrame("Login and Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setResizable(false);

        // Center the application on the screen
        frame.setLocationRelativeTo(null);

        // Create the main panel with CardLayout to switch between Login and Registration panels
        JPanel mainPanel = new JPanel(new CardLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);

        // Create and add Login and Registration panels to the main panel
        JPanel loginPanel = createLoginPanel(mainPanel);
        JPanel registrationPanel = createRegistrationPanel(mainPanel);

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registrationPanel, "Register");

        // Add the main panel to the frame and make it visible
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Creates the Login panel
    private JPanel createLoginPanel(JPanel mainPanel) {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBackground(new Color(200, 230, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Font and UI components for the login panel
        Font font = new Font("Arial", Font.BOLD, 14);
        JLabel usernameLabel = createStyledLabel("Username:", font);
        JTextField usernameField = createStyledTextField(font);
        JLabel passwordLabel = createStyledLabel("Password:", font);
        JPasswordField passwordField = createStyledPasswordField(font);
        JButton loginButton = createStyledButton("Login", font);
        JButton registerButton = createStyledButton("Register", font);

        // Add components to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Placeholder for layout
        panel.add(loginButton);
        panel.add(new JLabel()); // Placeholder for layout
        panel.add(registerButton);

        // Action listener for Login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (loginUser(username, password)) {
                JOptionPane.showMessageDialog(panel, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(panel, "Invalid credentials. Please try again.");
            }
        });

        // Action listener for Register button to switch to Registration panel
        registerButton.addActionListener(e -> {
            CardLayout layout = (CardLayout) mainPanel.getLayout();
            layout.show(mainPanel, "Register");
        });

        return panel;
    }

    // Creates the Registration panel
    private JPanel createRegistrationPanel(JPanel mainPanel) {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(230, 255, 200));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Font and UI components for the registration panel
        Font font = new Font("Arial", Font.BOLD, 14);
        JLabel usernameLabel = createStyledLabel("Username:", font);
        JTextField usernameField = createStyledTextField(font);
        JLabel passwordLabel = createStyledLabel("Password:", font);
        JPasswordField passwordField = createStyledPasswordField(font);
        JLabel emailLabel = createStyledLabel("Email:", font);
        JTextField emailField = createStyledTextField(font);
        JButton registerButton = createStyledButton("Register", font);
        JButton backButton = createStyledButton("Back to Login", font);

        // Add components to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(new JLabel()); // Placeholder for layout
        panel.add(registerButton);
        panel.add(new JLabel()); // Placeholder for layout
        panel.add(backButton);

        // Action listener for Register button
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();

            if (registerUser(username, password, email)) {
                JOptionPane.showMessageDialog(panel, "Registration successful!");
                CardLayout layout = (CardLayout) mainPanel.getLayout();
                layout.show(mainPanel, "Login");
            } else {
                JOptionPane.showMessageDialog(panel, "Registration failed. Username might already exist.");
            }
        });

        // Action listener for Back button to switch to Login panel
        backButton.addActionListener(e -> {
            CardLayout layout = (CardLayout) mainPanel.getLayout();
            layout.show(mainPanel, "Login");
        });

        return panel;
    }

    // Utility method to create styled labels
    private JLabel createStyledLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }

    // Utility method to create styled text fields
    private JTextField createStyledTextField(Font font) {
        JTextField field = new JTextField();
        field.setFont(font);
        return field;
    }

    // Utility method to create styled password fields
    private JPasswordField createStyledPasswordField(Font font) {
        JPasswordField field = new JPasswordField();
        field.setFont(font);
        return field;
    }

    // Utility method to create styled buttons
    private JButton createStyledButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(new Color(100, 150, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    // Handles user login by checking the database for matching credentials
    private boolean loginUser(String username, String password) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Returns true if a match is found
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Handles user registration by inserting new user data into the database
    private boolean registerUser(String username, String password, String email) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        // Launch the application in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new Q2().createGUI());
    }
}
