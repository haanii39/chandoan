/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class SQLServerConnUtils_SQLJDBC {
 
 // Kết nối vào SQLServer.
 // (Sử dụng thư viện điều khiển SQLJDBC)
 public static Connection getSQLServerConnection_SQLJDBC()
         throws ClassNotFoundException, SQLException {
     String hostName = "localhost";
     String sqlInstanceName = "NHIPHAN\\NHIPHAN";
     String database = "HOSPITAL";
     String userName = "sa";
     String password = "123";
 
     return getSQLServerConnection_SQLJDBC(hostName, sqlInstanceName,
             database, userName, password);
 }
 
 
 
 // Trường hợp sử dụng SQLServer.
 // Và thư viện SQLJDBC.
 private static Connection getSQLServerConnection_SQLJDBC(String hostName,
         String sqlInstanceName, String database, String userName,
         String password) throws ClassNotFoundException, SQLException {
    
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
     // Cấu trúc URL Connection dành cho SQLServer
     // Ví dụ:
     // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
 
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
 
}