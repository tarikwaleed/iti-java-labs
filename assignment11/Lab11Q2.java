import java.sql.*;

public class Lab11Q2 {
    public static void main(String[] args) {
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");

            // Create a PreparedStatement for updating the vacation balance and first name of employees over 45 years old
            PreparedStatement stmt = conn.prepareStatement("UPDATE Employee SET Vacation_Balance = 45, F_Name = ? WHERE Age > 45");

            // Get the employees over 45 years old and their gender
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("SELECT Id, F_Name, L_Name, Gender FROM Employee WHERE Age > 45");

            // Loop through the employees and add them to the batch with their updated first name
            while (rs.next()) {
                String id = rs.getString("Id");
                String firstName = rs.getString("F_Name");
                String lastName = rs.getString("L_Name");
                String gender = rs.getString("Gender");
                String title = gender.equals("M") ? "Mr. " : "Mrs. ";
                String newFirstName = title + firstName;

                stmt.setString(1, newFirstName);
                stmt.addBatch();
            }

            // Execute the batch
            int[] updateCounts = stmt.executeBatch();

            // Print the update counts for each employee
            for (int i = 0; i < updateCounts.length; i++) {
                System.out.println("Employee with ID " + (i+1) + " updated " + updateCounts[i] + " rows.");
            }

            // Close the resources
            rs.close();
            selectStmt.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
