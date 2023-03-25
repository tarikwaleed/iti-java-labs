import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Lab12 {
    public static void main(String[] args) {
        try {
            // Create a JDBCRowSet object
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();

            // Set the properties of the rowSet object
            rowSet.setUrl("jdbc:mysql://localhost:3306/mydatabase");
            rowSet.setUsername("root");
            rowSet.setPassword("password");

            // Set the query to be executed
            rowSet.setCommand("SELECT * FROM mytable");

            // Execute the query and get the result
            rowSet.execute();

            // Print the result
            while (rowSet.next()) {
                System.out.println("ID: " + rowSet.getInt("id"));
                System.out.println("First Name: " + rowSet.getString("first_name"));
                System.out.println("Last Name: " + rowSet.getString("last_name"));
                System.out.println("Gender: " + rowSet.getString("gender"));
                System.out.println("Age: " + rowSet.getInt("age"));
                System.out.println("Address: " + rowSet.getString("address"));
                System.out.println("Phone Number: " + rowSet.getString("phone_number"));
                System.out.println("Vacation Balance: " + rowSet.getInt("vacation_balance"));
            }

            // Close the rowSet object
            rowSet.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
