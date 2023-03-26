import java.sql.*;
        import java.io.FileInputStream;
        import java.util.Properties;
        import javax.sql.DataSource;
        import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceExample {

    public static void main(String[] args) {

        try {
            // Load the properties file with database connection details
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("database.properties");
            props.load(fis);

            // Create a DataSource object with the database connection details
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(props.getProperty("url"));
            dataSource.setUser(props.getProperty("username"));
            dataSource.setPassword(props.getProperty("password"));

            // Create a connection to the database
            Connection conn = dataSource.getConnection();

            // Execute a query to select different fields from a table
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM users");

            // Print the query results in a specific format
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Age: %d\n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
            }

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
