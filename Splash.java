import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    public Splash() {

        // Window Settings
        setTitle("VillaNest");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Background Color
        getContentPane().setBackground(new Color(255, 245, 248));

        // ==========================
        // VillaNest Title
        // ==========================

        JLabel title = new JLabel("VillaNest");
        title.setFont(new Font("Segoe UI", Font.BOLD, 50));
        title.setForeground(new Color(219, 112, 147));
        title.setBounds(330, 120, 400, 60);
        add(title);

        // ==========================
        // Tagline
        // ==========================

        JLabel tagline = new JLabel("Find Your Perfect Stay");
        tagline.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        tagline.setForeground(Color.DARK_GRAY);
        tagline.setBounds(340, 190, 350, 30);
        add(tagline);

        // ==========================
        // Loading Text
        // ==========================

        JLabel loading = new JLabel("Loading...");
        loading.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        loading.setForeground(Color.GRAY);
        loading.setBounds(445, 430, 150, 30);
        add(loading);

        // ==========================
        // Progress Bar
        // ==========================

        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(300, 470, 400, 25);
        progressBar.setValue(70);
        progressBar.setStringPainted(true);
        add(progressBar);

        // Show Window
        setVisible(true);

        // ==========================
        // Open Login After 3 Seconds
        // ==========================

        Timer timer = new Timer(3000, e -> {

            dispose();      // Close Splash Screen
            new Login();    // Open Login Screen

        });

        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        new Splash();
    }
}
