
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Lab11Q1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "employee_db";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "password";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);

            String createTableSQL = "CREATE TABLE Employee ("
                    + "Id INT(11) NOT NULL AUTO_INCREMENT,"
                    + "F_Name VARCHAR(50) NOT NULL,"
                    + "L_Name VARCHAR(50) NOT NULL,"
                    + "Gender CHAR(1) NOT NULL,"
                    + "Age INT(11) NOT NULL,"
                    + "Address VARCHAR(100) NOT NULL,"
                    + "Phone_Number VARCHAR(20) NOT NULL,"
                    + "Vacation_Balance INT(11) NOT NULL,"
                    + "PRIMARY KEY (Id))";

            PreparedStatement createTableStmt = conn.prepareStatement(createTableSQL);
            createTableStmt.executeUpdate();
            System.out.println("Table created successfully.");

            String insertSQL = "INSERT INTO Employee (F_Name, L_Name, Gender, Age, Address, Phone_Number, Vacation_Balance) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
            insertStmt.setString(1, "John");
            insertStmt.setString(2, "Doe");
            insertStmt.setString(3, "M");
            insertStmt.setInt(4, 35);
            insertStmt.setString(5, "123 Main St");
            insertStmt.setString(6, "555-1234");
            insertStmt.setInt(7, 30);
            insertStmt.executeUpdate();

            insertStmt.setString(1, "Jane");
            insertStmt.setString(2, "Smith");
            insertStmt.setString(3, "F");
            insertStmt.setInt(4, 28);
            insertStmt.setString(5, "456 Elm St");
            insertStmt.setString(6, "555-5678");
            insertStmt.setInt(7, 30);
            insertStmt.executeUpdate();

            insertStmt.setString(1, "Bob");
            insertStmt.setString(2, "Jones");
            insertStmt.setString(3, "M");
            insertStmt.setInt(4, 45);
            insertStmt.setString(5, "789 Oak St");
            insertStmt.setString(6, "555-9012");
            insertStmt.setInt(7, 30);
            insertStmt.executeUpdate();

            insertStmt.setString(1, "Mary");
            insertStmt.setString(2, "Williams");
            insertStmt.setString(3, "F");
            insertStmt.setInt(4, 22);
            insertStmt.setString(5, "321 Maple St");
            insertStmt.setString(6, "555-3456");
            insertStmt.setInt(7, 30);
            insertStmt.executeUpdate();

            insertStmt.setString(1, "Tom");
            insertStmt.setString(2, "Brown");
            insertStmt.setString(3, "M");
            insertStmt.setInt(4, 50);
            insertStmt.setString(5, "987 Pine St");
            insertStmt.setString(6, "555-7890");
            insertStmt.setInt(7, 30);
            insertStmt.executeUpdate();

            System.out.println("Rows inserted successfully.");

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
