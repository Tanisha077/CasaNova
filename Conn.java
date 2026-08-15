import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    public Connection con;

    public Conn() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url =
                    "jdbc:mysql://localhost:3306/VillaNest"
                            + "?useSSL=false"
                            + "&allowPublicKeyRetrieval=true"
                            + "&serverTimezone=UTC";

            String username = "root";
            String password = "system";

            con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("DATABASE CONNECTED SUCCESSFULLY!");

        } catch (Exception e) {

            System.out.println("DATABASE CONNECTION FAILED!");
            System.out.println("ERROR: " + e.getMessage());

            e.printStackTrace();

            con = null;
        }
    }

    public static void main(String[] args) {

        Conn c = new Conn();

        if (c.con != null) {
            System.out.println("CONNECTION TEST PASSED!");
        } else {
            System.out.println("CONNECTION TEST FAILED!");
        }
    }
}
