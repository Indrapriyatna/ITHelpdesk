package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                // Register the MySQL JDBC driver (optional in modern versions)
                // Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/helpdeskdb";
                String user = System.getenv("DB_USERNAME") != null ? System.getenv("DB_USERNAME") : "root";
                String password = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "";

                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
            conn = null; // Ensure conn is null on failure
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                System.err.println("Failed to close connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}