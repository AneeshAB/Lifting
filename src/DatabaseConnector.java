/**
 * Created by aneesh on 12/29/14.
 */

import java.sql.*;

public class DatabaseConnector {
    private static final String DEFAULT_DB_URL = "jdbc:mysql://localhost/lifting_log";
    private static final String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_PASSWORD = "password";

    private Connection connection; // Connection object

    private String dbUrl;
    private String username;
    private String password;

    // Testing
    public static void main(String[] args) {
        // Connect to database
        DatabaseConnector dbConnect = new DatabaseConnector();

        Workout workout = new Workout();

        Lift benchPress = new Lift("Bench Press");
        benchPress.addSet(new Set(5, 135));
        benchPress.addSet(new Set(5, 135));
        workout.addLift(benchPress);

        Lift deadlift = new Lift("Deadlift");
        deadlift.addSet(new Set(5, 225));
        workout.addLift(deadlift);

        dbConnect.addWorkout(workout);
    }

    // Constructors
    public DatabaseConnector() {
        this.setDbUrl(DEFAULT_DB_URL);
        this.setUsername(DEFAULT_USERNAME);
        this.setPassword(DEFAULT_PASSWORD);
    }

    // Getters
    private Connection getConnection() {
        return this.connection;
    }

    private String getDbUrl() {
        return this.dbUrl;
    }

    private String getUsername() {
        return this.username;
    }

    private String getPassword() {
        return this.password;
    }

    // Setters
    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    private void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    // Unique methods
    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver"); // Load MySQL driver
        this.setConnection(DriverManager.getConnection(this.getDbUrl(), this.getUsername(), this.getPassword()));
    }

    private void disconnect() throws SQLException {
        this.getConnection().close();
    }

    private void updateQuery(String sql) throws SQLException {
        this.getConnection().createStatement().executeUpdate(sql);
    }

    public void addWorkout(Workout workout) {
        // Connect to the database
        try {
            this.connect();
        }
        catch (ClassNotFoundException e) {
            System.out.println("JDBC MySQL driver not present.");
            return;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }

        // SQL Stuff
        for (Lift l : workout.getLifts()) { // Lift loop
            String sqlQuery = "CREATE TABLE IF NOT EXISTS " + "`" + l.getName() + "`"
                    + " (id INTEGER not NULL AUTO_INCREMENT, "
                    + " date DATE, "
                    + " reps INTEGER, "
                    + " weight INTEGER, "
                    + " PRIMARY KEY ( id ))";
            try {
                this.updateQuery(sqlQuery);
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                return;
            }

            for (Set s : l.getSets()) { // Set loop
                sqlQuery = "INSERT INTO " + "`" + l.getName() + "`" + " (date, reps, weight) VALUES ("
                        + "\"" + workout.getDateString() + "\"" + ", " + s.getNumReps() + ", " + s.getWeight() + ")";
                try {
                    this.updateQuery(sqlQuery);
                }
                catch (SQLException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }

        // Disconnect from the database
        try {
            this.disconnect();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
