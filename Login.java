import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JLabel heading, tagline, usernameLabel, passwordLabel, signup;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public Login() {

        // Window Settings
        setTitle("CasaNova - Login");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Background Color
        getContentPane().setBackground(new Color(255, 245, 248));

        // Heading
        heading = new JLabel("Welcome to CasaNova");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 36));
        heading.setForeground(new Color(219, 112, 147));
        heading.setBounds(260, 40, 500, 50);
        add(heading);

        // Tagline
        tagline = new JLabel("Your Home Away From Home");
        tagline.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tagline.setForeground(Color.GRAY);
        tagline.setBounds(320, 90, 350, 25);
        add(tagline);

        // Username Label
        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        usernameLabel.setBounds(300, 160, 120, 25);
        add(usernameLabel);

        // Username Field
        usernameField = new JTextField();
        usernameField.setBounds(300, 190, 400, 40);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(usernameField);

        // Password Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        passwordLabel.setBounds(300, 260, 120, 25);
        add(passwordLabel);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(300, 290, 400, 40);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(300, 370, 400, 45);
        loginButton.setBackground(new Color(219, 112, 147));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(this);
        add(loginButton);

        // Sign Up Label
        signup = new JLabel("Don't have an account? Sign Up");
        signup.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        signup.setForeground(Color.DARK_GRAY);
        signup.setBounds(380, 440, 250, 25);
        add(signup);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText().trim();
        String password = String.valueOf(passwordField.getPassword());

        if (username.equals("admin") && password.equals("1234")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!"
            );

            dispose();
            new Home();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password!"
            );
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
