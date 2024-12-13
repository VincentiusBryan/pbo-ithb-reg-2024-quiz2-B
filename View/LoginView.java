package View;

import Controller.LoginController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private JTextField fieldEmailnya;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {
        setTitle("Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        JLabel labelEmailnya = new JLabel("Email:");
        labelEmailnya.setBounds(30, 30, 80, 25);
        panel.add(labelEmailnya);

        fieldEmailnya = new JTextField(20);
        fieldEmailnya.setBounds(120, 30, 250, 25);
        panel.add(fieldEmailnya);

        JLabel labelPasswordnya = new JLabel("Password:");
        labelPasswordnya.setBounds(30, 100, 80, 25);
        panel.add(labelPasswordnya);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(120, 100, 250, 25);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = fieldEmailnya.getText();
                String password = new String(passwordField.getPassword());

                LoginController controller = new LoginController();
                Integer userId = controller.loginUser(email, password);

                if (userId != null) {
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                    new ArtworkListView(userId).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Gagal");
                }
            }
        });
    }

    public static void main(String[] args) {
        new LoginView().setVisible(true);
    }
}
