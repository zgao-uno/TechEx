package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DButil {
	private static String url = null;
    private static String user = null;
    private static String password = null;
    
    static{
    	Properties properties = new Properties();
    	InputStream inputStream = DButil.class.getResourceAsStream("/config.properties");
    	try {
    		properties.load(inputStream);
    		url = properties.getProperty("url");
    		user = properties.getProperty("user");
    		password = properties.getProperty("password");
    		
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static Connection getConn() throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }
    
    public static void close(Connection connection, PreparedStatement preparedStatement){
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
