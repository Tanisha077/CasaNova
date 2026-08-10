import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JTextField search;
    JButton searchButton;
    JButton aboutButton;
    JButton contactButton;
    JButton logoutButton;

    JPanel card1;
    JPanel card2;
    JPanel card3;

    public Home() {

        setTitle("CasaNova");
        setSize(1200,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(255,245,248));

        // ================= NAVBAR =================

        JPanel navbar = new JPanel();
        navbar.setBounds(0,0,1200,80);
        navbar.setLayout(null);
        navbar.setBackground(new Color(219,112,147));
        add(navbar);

        JLabel title = new JLabel("CasaNova");
        title.setFont(new Font("Segoe UI",Font.BOLD,30));
        title.setForeground(Color.WHITE);
        title.setBounds(30,18,250,40);
        navbar.add(title);

        search = new JTextField();
        search.setBounds(500,20,220,40);
        search.setFont(new Font("Segoe UI",Font.PLAIN,16));
        navbar.add(search);

        searchButton = new JButton("Search");
        searchButton.setBounds(730,20,100,40);
        navbar.add(searchButton);

        aboutButton = new JButton("About");
        aboutButton.setBounds(840,20,90,40);
        navbar.add(aboutButton);

        contactButton = new JButton("Contact");
        contactButton.setBounds(940,20,100,40);
        navbar.add(contactButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1050,20,100,40);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setForeground(new Color(219,112,147));
        navbar.add(logoutButton);

        // ================= HEADING =================

        JLabel heading = new JLabel("Featured Stays");
        heading.setFont(new Font("Segoe UI",Font.BOLD,28));
        heading.setBounds(50,100,300,40);
        add(heading);
        // ================= CARD 1 =================

        card1 = createCard(
                "/villa1.jpeg",
                "Goa Luxury Villa",
                "★★★★★ 4.9",
                "₹4,500 / Night"
        );

        card1.setBounds(50,170,320,380);
        add(card1);


        card2 = createCard(
                "/villa2.jpeg",
                "Beach House",
                "★★★★☆ 4.8",
                "₹5,200 / Night"
        );

        card2.setBounds(430,170,320,380);
        add(card2);


        card3 = createCard(
                "/villa3.jpeg",
                "Mountain Cabin",
                "★★★★★ 5.0",
                "₹6,000 / Night"
        );

        card3.setBounds(810,170,320,380);
        add(card3);

        // ================= BUTTON ACTIONS =================

        searchButton.addActionListener(this);

        aboutButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(this,
                    "CasaNova\n\n" +
                            "Version 1.0\n\n" +
                            "Developed By:\n" +
                            "Tanisha Soni\n\n" +
                            "Java Swing Project");

        });

        contactButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(this,
                    "Contact Us\n\n" +
                            "Email : support@casanova.com\n" +
                            "Phone : +91 9877099415");

        });

        logoutButton.addActionListener(e -> {

            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to Logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION);

            if(option == JOptionPane.YES_OPTION){

                dispose();
                new Login();

            }

        });

        setVisible(true);

    }
    // ================= CREATE CARD =================

    public JPanel createCard(String imagePath, String houseName, String rating, String price) {

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);

        // Image
        java.net.URL imageURL = getClass().getResource(imagePath);

        System.out.println("Looking for: " + imagePath);
        System.out.println("Found: " + imageURL);

        if (imageURL == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Image not found: " + imagePath
            );
            return card;
        }

        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage().getScaledInstance(320,180,Image.SCALE_SMOOTH);
        JLabel picture = new JLabel(new ImageIcon(image));
        picture.setBounds(0,0,320,180);
        card.add(picture);

        // Name
        JLabel name = new JLabel(houseName);
        name.setFont(new Font("Segoe UI",Font.BOLD,20));
        name.setBounds(20,195,250,30);
        card.add(name);

        // Rating
        JLabel rate = new JLabel(rating);
        rate.setBounds(20,230,200,25);
        card.add(rate);

        // Price
        JLabel cost = new JLabel(price);
        cost.setFont(new Font("Segoe UI",Font.BOLD,18));
        cost.setBounds(20,260,220,30);
        card.add(cost);

        // Book Button
        JButton book = new JButton("Book Now");
        book.setBounds(70,315,170,40);
        book.setBackground(new Color(219,112,147));
        book.setForeground(Color.WHITE);

        book.addActionListener(e -> {
            new Booking(houseName, price);
            dispose();
        });
        card.add(book);

        return card;
    }

    // ================= SEARCH =================

    @Override
    public void actionPerformed(ActionEvent e) {

        String text = search.getText().trim().toLowerCase();

        card1.setVisible(true);
        card2.setVisible(true);
        card3.setVisible(true);

        if(text.equals("goa")){

            card2.setVisible(false);
            card3.setVisible(false);

        }
        else if(text.equals("beach")){

            card1.setVisible(false);
            card3.setVisible(false);

        }
        else if(text.equals("mountain")){

            card1.setVisible(false);
            card2.setVisible(false);

        }
        else if(!text.isEmpty()){

            JOptionPane.showMessageDialog(this,
                    "Showing all properties.\nTry: goa, beach or mountain");

        }

    }
    public static void main(String[] args) {

        new Home();

    }

}
