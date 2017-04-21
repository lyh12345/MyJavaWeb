package base;

import java.sql.*;

/**
 * Created by Administrator on 2017/4/3.
 */
public class Connect {
    private Statement stmt;
    private Connection conn;
    ResultSet rs;

    public Connect() {
        stmt = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SCHOOL", "sa", "935686942");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        rs = null;
    }

    public ResultSet executeQuery(String sql) {
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Data.executeQuery:" + e.getMessage());
        }
        return rs;
    }

    public int executeUpdate(String sql) {
        int t = 0;
        try {
            stmt = conn.createStatement();
            t = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Data.executeUpdate:" + e.getMessage());
        }
        return t;
    }

    public void closeStmt() {
        try {
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Data.executeQuery:" + e.getMessage());
        }

    }

    public void closeConn() {
        try {

            conn.close();
        } catch (SQLException e) {
            System.err.println("Data.executeQuery:" + e.getMessage());
        }
    }
}
