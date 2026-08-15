import javax.swing.*;
import java.awt.*;

public class Confirmation extends JFrame {

    public Confirmation(String villaName) {

        // Window
        setTitle("VillaNest - Booking Confirmation");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(
                new Color(255, 245, 248)
        );

        // ================= HEADER =================

        JPanel header = new JPanel();
        header.setBounds(0, 0, 700, 80);
        header.setBackground(
                new Color(219, 112, 147)
        );
        header.setLayout(null);
        add(header);

        JLabel title = new JLabel("VillaNest");
        title.setFont(
                new Font("Segoe UI", Font.BOLD, 28)
        );
        title.setForeground(Color.WHITE);
        title.setBounds(30, 20, 250, 40);
        header.add(title);

        // ================= SUCCESS ICON =================

        JLabel tick = new JLabel("✔");
        tick.setFont(
                new Font("Segoe UI", Font.BOLD, 70)
        );
        tick.setForeground(
                new Color(46, 204, 113)
        );
        tick.setBounds(315, 95, 80, 80);
        add(tick);

        // ================= SUCCESS MESSAGE =================

        JLabel success =
                new JLabel("Booking Successful!");

        success.setFont(
                new Font("Segoe UI", Font.BOLD, 30)
        );
        success.setForeground(
                new Color(219, 112, 147)
        );
        success.setBounds(180, 170, 350, 40);
        add(success);

        // ================= THANK YOU =================

        JLabel thanks =
                new JLabel(
                        "Thank you for choosing VillaNest."
                );

        thanks.setFont(
                new Font("Segoe UI", Font.PLAIN, 18)
        );
        thanks.setBounds(190, 220, 350, 30);
        add(thanks);

        // ================= VILLA NAME =================

        JLabel villa =
                new JLabel("Property : " + villaName);

        villa.setFont(
                new Font("Segoe UI", Font.BOLD, 18)
        );
        villa.setBounds(220, 270, 300, 30);
        add(villa);

        // ================= BOOKING ID =================

        JLabel bookingId =
                new JLabel("Booking ID : CN1025");

        bookingId.setFont(
                new Font("Segoe UI", Font.PLAIN, 18)
        );
        bookingId.setBounds(220, 305, 250, 30);
        add(bookingId);

        // ================= HOME BUTTON =================

        JButton home =
                new JButton("Back to Home");

        home.setBounds(250, 380, 180, 45);

        home.setBackground(
                new Color(219, 112, 147)
        );

        home.setForeground(Color.WHITE);

        home.setFont(
                new Font("Segoe UI", Font.BOLD, 16)
        );

        home.setFocusPainted(false);

        add(home);

        home.addActionListener(e -> {

            dispose();
            new Home();

        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Confirmation("Goa Luxury Villa");
    }
}
