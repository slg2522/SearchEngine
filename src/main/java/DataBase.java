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

    // Connection is used to perform database-related operations(crete table, delete data, insert data,...)
    private Connection getConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(databaseUrl+databaseName);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // create table using this method
    private void createTable() {
        String createStatement =
                "CREATE TABLE IF NOT EXISTS url_data (\n " +
                        " id integer INTEGER PRIMARY KEY,\n" +
                        "url TEXT NOT NULL\n" +
                        ");";
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(createStatement);

        } catch (Exception e) {
            System.exit(0);
        }
    }

    // method for inserting
    public void insert(String url) {
        String insertStatement = "INSERT INTO url_data(url) VALUES(?)";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1,url);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //connect();
    }
}
