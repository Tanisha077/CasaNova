import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;

public class Booking extends JFrame {

    public Booking(String villaName, String price) {

        // ================= WINDOW =================

        setTitle("CasaNova - Booking");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(
                new Color(255, 245, 248)
        );


        // ================= HEADING =================

        JLabel heading = new JLabel("Book Your Stay");
        heading.setFont(
                new Font("Segoe UI", Font.BOLD, 30)
        );
        heading.setForeground(
                new Color(219, 112, 147)
        );
        heading.setBounds(180, 40, 300, 40);
        add(heading);


        // ================= VILLA =================

        JLabel villa = new JLabel(
                "Villa: " + villaName
        );

        villa.setFont(
                new Font("Segoe UI", Font.BOLD, 20)
        );

        villa.setBounds(
                80,
                120,
                450,
                30
        );

        add(villa);


        // ================= PRICE =================

        JLabel cost = new JLabel(
                "Price: " + price
        );

        cost.setFont(
                new Font("Segoe UI", Font.PLAIN, 18)
        );

        cost.setBounds(
                80,
                160,
                350,
                30
        );

        add(cost);


        // ================= NAME LABEL =================

        JLabel nameLabel = new JLabel("Name:");

        nameLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 16)
        );

        nameLabel.setBounds(
                80,
                220,
                100,
                30
        );

        add(nameLabel);


        // ================= NAME FIELD =================

        JTextField name = new JTextField();

        name.setFont(
                new Font("Segoe UI", Font.PLAIN, 15)
        );

        name.setBounds(
                180,
                220,
                250,
                30
        );

        add(name);


        // ================= DAYS LABEL =================

        JLabel daysLabel = new JLabel("Days:");

        daysLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 16)
        );

        daysLabel.setBounds(
                80,
                270,
                100,
                30
        );

        add(daysLabel);


        // ================= DAYS FIELD =================

        JTextField days = new JTextField();

        days.setFont(
                new Font("Segoe UI", Font.PLAIN, 15)
        );

        days.setBounds(
                180,
                270,
                250,
                30
        );

        add(days);


        // ================= CONFIRM BUTTON =================

        JButton confirm = new JButton(
                "Confirm Booking"
        );

        confirm.setBounds(
                180,
                340,
                200,
                40
        );

        confirm.setBackground(
                new Color(219, 112, 147)
        );

        confirm.setForeground(Color.WHITE);

        confirm.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        confirm.setFocusPainted(false);

        add(confirm);


        // ================= BOOKING ACTION =================

        confirm.addActionListener(e -> {

            // Get user input

            String customerName =
                    name.getText().trim();

            String daysText =
                    days.getText().trim();


            // ================= NAME VALIDATION =================

            if (customerName.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your name.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );

                name.requestFocus();

                return;
            }


            // ================= DAYS VALIDATION =================

            if (daysText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter number of days.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );

                days.requestFocus();

                return;
            }


            // ================= CONVERT DAYS =================

            int numberOfDays;

            try {

                numberOfDays =
                        Integer.parseInt(daysText);

                if (numberOfDays <= 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Days must be greater than 0.",
                            "Validation Error",
                            JOptionPane.WARNING_MESSAGE
                    );

                    days.requestFocus();

                    return;
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid number of days.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );

                days.requestFocus();

                return;
            }


            // ================= DATABASE CONNECTION =================

            try {

                Conn c = new Conn();


                // Check connection

                if (c.con == null) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Database connection failed!\n\n"
                                    + "Please check your MySQL connection, "
                                    + "username and password.",
                            "Database Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }


                // ================= SQL QUERY =================

                String query =
                        "INSERT INTO bookings "
                                + "(name, villa, price, days) "
                                + "VALUES (?, ?, ?, ?)";


                // ================= PREPARED STATEMENT =================

                PreparedStatement ps =
                        c.con.prepareStatement(query);


                // Set values

                ps.setString(
                        1,
                        customerName
                );

                ps.setString(
                        2,
                        villaName
                );

                ps.setString(
                        3,
                        price
                );

                ps.setInt(
                        4,
                        numberOfDays
                );


                // ================= EXECUTE =================

                int result =
                        ps.executeUpdate();


                // ================= SUCCESS =================

                if (result > 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Booking saved successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );


                    // Close resources

                    ps.close();
                    c.con.close();


                    // Open confirmation

                    dispose();

                    new Confirmation(
                            villaName
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Booking could not be saved.",
                            "Booking Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }


            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Booking Failed!\n\n"
                                + "Reason: "
                                + ex.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        });


        // ================= SHOW WINDOW =================

        setVisible(true);
    }


    // ================= MAIN =================

    public static void main(String[] args) {

        new Booking(
                "Goa Luxury Villa",
                "₹4,500 / Night"
        );

    }
}
