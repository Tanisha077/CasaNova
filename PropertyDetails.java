import javax.swing.*;
import java.awt.*;

public class PropertyDetails extends JFrame {

    public PropertyDetails() {

        // ================= WINDOW =================

        setTitle("CasaNova - Property Details");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(
                new Color(255, 245, 248)
        );


        // ================= HEADER =================

        JPanel navbar = new JPanel();
        navbar.setLayout(null);
        navbar.setBounds(0, 0, 1000, 80);
        navbar.setBackground(
                new Color(219, 112, 147)
        );
        add(navbar);

        JLabel title = new JLabel("CasaNova");
        title.setFont(
                new Font("Segoe UI", Font.BOLD, 30)
        );
        title.setForeground(Color.WHITE);
        title.setBounds(40, 20, 250, 40);
        navbar.add(title);


        // ================= PROPERTY NAME =================

        JLabel heading = new JLabel("Goa Luxury Villa");
        heading.setFont(
                new Font("Segoe UI", Font.BOLD, 30)
        );
        heading.setBounds(50, 100, 400, 40);
        add(heading);


        // ================= IMAGE =================

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/villa1.jpeg")
        );

        Image image = icon.getImage()
                .getScaledInstance(
                        450,
                        280,
                        Image.SCALE_SMOOTH
                );

        JLabel villaImage =
                new JLabel(new ImageIcon(image));

        villaImage.setBounds(
                50,
                170,
                450,
                280
        );

        add(villaImage);


        // ================= DETAILS CARD =================

        JPanel details = new JPanel();
        details.setLayout(null);
        details.setBounds(
                560,
                150,
                350,
                330
        );
        details.setBackground(Color.WHITE);
        add(details);


        // ================= LOCATION =================

        JLabel location =
                new JLabel("Goa, India");

        location.setFont(
                new Font("Segoe UI", Font.PLAIN, 18)
        );

        location.setBounds(
                30,
                30,
                250,
                30
        );

        details.add(location);


        // ================= RATING =================

        JLabel rating =
                new JLabel("★★★★★ 4.9 Rating");

        rating.setFont(
                new Font("Segoe UI", Font.PLAIN, 18)
        );

        rating.setBounds(
                30,
                80,
                250,
                30
        );

        details.add(rating);


        // ================= PRICE =================

        JLabel price =
                new JLabel("₹4,500 / Night");

        price.setFont(
                new Font("Segoe UI", Font.BOLD, 22)
        );

        price.setBounds(
                30,
                130,
                250,
                40
        );

        details.add(price);


        // ================= DESCRIPTION =================

        JLabel description =
                new JLabel(
                        "<html>"
                                + "Beautiful luxury villa with<br>"
                                + "private pool, beach view<br>"
                                + "and premium facilities."
                                + "</html>"
                );

        description.setFont(
                new Font("Segoe UI", Font.PLAIN, 16)
        );

        description.setBounds(
                30,
                180,
                280,
                70
        );

        details.add(description);


        // ================= RESERVE BUTTON =================

        JButton reserve =
                new JButton("Reserve Now");

        reserve.setBounds(
                90,
                260,
                170,
                45
        );

        reserve.setBackground(
                new Color(219, 112, 147)
        );

        reserve.setForeground(Color.WHITE);

        reserve.setFont(
                new Font("Segoe UI", Font.BOLD, 16)
        );

        reserve.setFocusPainted(false);

        details.add(reserve);


        // ================= BUTTON ACTION =================

        reserve.addActionListener(e -> {

            dispose();

            new Booking(
                    "Goa Luxury Villa",
                    "₹4,500 / Night"
            );

        });


        setVisible(true);
    }


    // ================= MAIN =================

    public static void main(String[] args) {

        new PropertyDetails();

    }
}
