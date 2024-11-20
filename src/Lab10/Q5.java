package Lab10;
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;

public class Q5 extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JLabel statusBar;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openItem, saveItem, clearItem, exitItem;
    private JFileChooser fileChooser;

    public Q5() {
        // Frame settings
        setTitle("Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        textArea = new JTextArea();
        textArea.setFont(new Font("Courier New", Font.PLAIN, 16));
        textArea.setBackground(new Color(240, 248, 255)); // Light background color
        textArea.setForeground(Color.DARK_GRAY);

        statusBar = new JLabel(" Characters: 0 | Lines: 0 ");
        statusBar.setFont(new Font("Arial", Font.PLAIN, 14));
        statusBar.setBorder(BorderFactory.createEtchedBorder());

        fileChooser = new JFileChooser();

        // Create menu bar
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        clearItem = new JMenuItem("Clear");
        exitItem = new JMenuItem("Exit");

        // Add menu items to menu
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Add menu to menu bar
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Add action listeners
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        clearItem.addActionListener(this);
        exitItem.addActionListener(this);
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateStatus();
            }
        });

        // Add components to frame
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    // Handle menu actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openItem) {
            openFile();
        } else if (e.getSource() == saveItem) {
            saveFile();
        } else if (e.getSource() == clearItem) {
            textArea.setText("");
            updateStatus();
        } else if (e.getSource() == exitItem) {
            System.exit(0);
        }
    }

    // Open file
    private void openFile() {
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
                updateStatus();
            } catch (IOException ex) {
                showError("Error opening file: " + ex.getMessage());
            }
        }
    }

    // Save file
    private void saveFile() {
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                showError("Error saving file: " + ex.getMessage());
            }
        }
    }

    // Update status bar
    private void updateStatus() {
        String text = textArea.getText();
        int charCount = text.length();
        int lineCount = text.split("\n").length;
        statusBar.setText(" Characters: " + charCount + " | Lines: " + lineCount + " ");
    }

    // Show error message
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Q5().setVisible(true);
        });
    }
}

