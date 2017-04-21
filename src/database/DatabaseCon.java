package database;

import java.sql.*;

/**
 * Created by lh
 * on 2017/3/29.
 */

public class DatabaseCon {

    private Connection connection = null;
    private Statement statement= null;
    private ResultSet resultSet = null;
    public DatabaseCon(){
        String usrName = "sa";
        String password = "935686942";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localHost:1433;DatabaseName=SCHOOL";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,usrName,password);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public ResultSet executeQuery(String sql){
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultSet;
    }
    public int executeUpdate(String sql){
        int rs = 0;
        try {
            statement = connection.createStatement();
            rs = statement.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void closeStatement(){
        try {
            statement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
