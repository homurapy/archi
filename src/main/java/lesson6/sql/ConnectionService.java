package lesson6.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionService {
    private static ConnectionService INSTANCE;

    private ConnectionService() {
    }

    public static ConnectionService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ConnectionService();
        return INSTANCE;
    }

    public static Connection connectSQLite() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:src/main/resources/dataBase.db");
        } catch (SQLException exc) {
            throw new RuntimeException("SWW", exc);
        }
    }

    public static void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
