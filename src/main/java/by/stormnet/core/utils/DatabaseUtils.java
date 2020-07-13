package by.stormnet.core.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASS = "";

    private static Connection getH2Connection() {
        Connection conn = null;

        try {
            System.out.println("Connection to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void createTable() {
        Connection connection = getH2Connection();
        Statement statement = null;

        try {
            System.out.println("Creating table in given database...");
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Users " +
                    "(id INTEGER NOT NULL, " +
                    "first_name VARCHAR(255), " +
                    "last_name VARCHAR(255), " +
                    "age INTEGER, " +
                    "PRIMARY KEY (id))";

            statement.execute(sql);
            System.out.println("Table was created");
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, statement);
        }
    }

    public static boolean insertData(List<String> sqlStatements) {
        Connection connection = getH2Connection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            for (String sql : sqlStatements) {
                statement.executeUpdate(sql);
            }
            statement.close();
            connection.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closeConnection(connection, statement);
        }
    }

    public static List<String> read(String sqlStatement) {
        List<String> results = new ArrayList<>();
        Connection connection = getH2Connection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStatement);

            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");

                results.add("ID: " + id + ", " + "First Name: " + first + ", " + "Last Name: " + last + ", " + "Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    public static void updateAndDelete(String sqlStatement) {
        Connection connection = getH2Connection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, statement);
        }
    }

    private static void closeConnection(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Resources closed!");

    }
}

