
import java.sql.*;

public class Lab10 {
    public static void main(String[] args) {
        // JDBC driver name and database URL
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false&serverTimezone=UTC";

        // Database credentials
        String username = "root";
        String password = "mypassword";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Register JDBC driver
            Class.forName(driver);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, username, password);

            // Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT id, name, age FROM mytable";
            rs = stmt.executeQuery(sql);

            // Process the result set
            System.out.println("Printing data...");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.printf("ID: %d, Name: %s, Age: %d%n", id, name, age);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
