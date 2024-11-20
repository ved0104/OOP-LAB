//Q.4) Develop a basic student management system to add, delete, update, and view
//        student records.
//        Requirements:
//         Create a form with fields like Student ID, Name, Age, Gender, Department, etc.
//         Provide buttons for Add, Update, Delete, and View.
//         Use a JTable to display the list of students.
//         Use JDBC to connect to a MySQL database and perform CRUD operations.
//         Implement ActionListener for each button to handle respective actions.
package Lab10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Q4 extends JFrame {
    private JTextField txtId, txtName, txtAge, txtGender, txtDepartment;
    private JTable table;
    private DefaultTableModel tableModel; //uses a Vector of Vectors to store the cell value objects.

    public Q4() {
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create form fields
        txtId = new JTextField(10);
        txtName = new JTextField(10);
        txtAge = new JTextField(10);
        txtGender = new JTextField(10);
        txtDepartment = new JTextField(10);

        // Create buttons
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnView = new JButton("View");

        // Create table
        String[] columnNames = {"Student ID", "Name", "Age", "Gender", "Department"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add components to the frame
        add(new JLabel("Student ID:"));
        add(txtId);
        add(new JLabel("Name:"));
        add(txtName);
        add(new JLabel("Age:"));
        add(txtAge);
        add(new JLabel("Gender:"));
        add(txtGender);
        add(new JLabel("Department:"));
        add(txtDepartment);
        add(btnAdd);
        add(btnUpdate);
        add(btnDelete);
        add(btnView);
        add(scrollPane);

        // Add action listeners
        btnAdd.addActionListener(e -> addStudent());
        btnUpdate.addActionListener(e -> updateStudent());
        btnDelete.addActionListener(e -> deleteStudent());
        btnView.addActionListener(e -> viewStudents());

        setVisible(true);
    }

    // JDBC connection method
    private Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/student_management";
            String user = "root";
            String password = "veddub0110";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Add student method
    private void addStudent() {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO students (name, age, gender, department) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, txtName.getText());
            statement.setInt(2, Integer.parseInt(txtAge.getText()));
            statement.setString(3, txtGender.getText());
            statement.setString(4, txtDepartment.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student added successfully!");
            clearFields();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding student: " + e.getMessage());
        }
    }

    // Update student method
    private void updateStudent() {
        try {
            int studentId = Integer.parseInt(txtId.getText());
            if (studentId <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Student ID.");
                return;
            }

            try (Connection connection = getConnection()) {
                String sql = "UPDATE students SET name=?, age=?, gender=?, department=? WHERE student_id=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, txtName.getText());
                statement.setInt(2, Integer.parseInt(txtAge.getText()));
                statement.setString(3, txtGender.getText());
                statement.setString(4, txtDepartment.getText());
                statement.setInt(5, studentId);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Student updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "No student found with the given ID.");
                }
                clearFields();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating student: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for Age and Student ID.");
        }
    }

    // Delete student method
    private void deleteStudent() {
        try {
            int studentId = Integer.parseInt(txtId.getText());
            if (studentId <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Student ID.");
                return;
            }

            try (Connection connection = getConnection()) {
                String sql = "DELETE FROM students WHERE student_id=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, studentId);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Student deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "No student found with the given ID.");
                }
                clearFields();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting student: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for Student ID.");
        }
    }

    // View students method
    private void viewStudents() {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM students";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Clear the table before displaying new data
            tableModel.setRowCount(0);

            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String department = resultSet.getString("department");
                tableModel.addRow(new Object[]{id, name, age, gender, department});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving students: " + e.getMessage());
        }
    }

    // Clear input fields
    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtGender.setText("");
        txtDepartment.setText("");
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Q4());
    }
}