import javax.xml.crypto.Data;
import java.sql.*;

public class DataBase {

    private static final String databaseUrl = "jdbc:sqlite:";
    private static final String databaseName = "sampleDataBase.db";
    private static DataBase sampleDataBase;

    private DataBase(){
        createTable();
    }

    public static DataBase getSampleDataBaseInstance(){
        if (sampleDataBase == null){
            sampleDataBase = new DataBase();
        }
        return sampleDataBase;
    }

    /*public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:sampleDataBase.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

     */

    private Connection getConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(databaseUrl+databaseName);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createTable() {
        String createStatement =
                "CREATE TABLE IF NOT EXISTS `shopping_list_entry` ( " +
                        "`checked` INTEGER NOT NULL, " +
                        "`amount` INTEGER NOT NULL, " +
                        "`title` TEXT NOT NULL);";
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(createStatement);

        } catch (Exception e) {
            System.exit(0);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //connect();
    }
}
