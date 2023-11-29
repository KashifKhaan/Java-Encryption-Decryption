import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

    private JTextField inputField, keyField, outputField;
    private JButton encryptButton, decryptButton;
    private JLabel inputLabel, keyLabel, outputLabel;

    public Main() {
        setTitle("Text Encryption and Decryption");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inputLabel = new JLabel("Input Text:");
        inputLabel.setBounds(30, 20, 80, 25);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(120, 20, 200, 25);
        add(inputField);

        keyLabel = new JLabel("Key:");
        keyLabel.setBounds(30, 50, 80, 25);
        add(keyLabel);

        keyField = new JTextField();
        keyField.setBounds(120, 50, 100, 25);
        add(keyField);

        encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(80, 90, 100, 25);
        encryptButton.addActionListener(this);
        add(encryptButton);

        decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(200, 90, 100, 25);
        decryptButton.addActionListener(this);
        add(decryptButton);

        outputLabel = new JLabel("Result:");
        outputLabel.setBounds(30, 130, 80, 25);
        add(outputLabel);

        outputField = new JTextField();
        outputField.setBounds(120, 130, 200, 25);
        outputField.setEditable(false);
        add(outputField);

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encryptButton) {
            String inputText = inputField.getText();
            String key = keyField.getText();
            String encryptedText = encryptText(inputText, Integer.parseInt(key));
            outputField.setText(encryptedText);
        } else if (e.getSource() == decryptButton) {
            String inputText = inputField.getText();
            String key = keyField.getText();
            String decryptedText = decryptText(inputText, Integer.parseInt(key));
            outputField.setText(decryptedText);
        }
    }

    private String encryptText(String text, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            char encryptedChar = (char) (character + key);
            encrypted.append(encryptedChar);
        }
        return encrypted.toString();
    }

    private String decryptText(String text, int key) {
        StringBuilder decrypted = new StringBuilder();
        String decryptedChar = inputField.getText();
        decrypted.append(decryptedChar);
        return decrypted.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
