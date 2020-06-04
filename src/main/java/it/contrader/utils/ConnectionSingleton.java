package it.contrader.utils;

import java.sql.Connection;
import java.sql.DriverManager;

//@Author: Thanks to Salvatore Petrianni

public class ConnectionSingleton {


    private static Connection connection = null;


    private ConnectionSingleton() {
    }


    public static Connection getInstance() {
        if (connection == null) {
            try { 
                String vendor="mysql";
                //String driver="com.mysql.jdbc.Driver"; // That is the correct MYSQL driver from JDBC OLD VERSION
                String driver="com.mysql.cj.jdbc.Driver"; // That is the correct MYSQL driver from JDBC
                String host="127.0.0.1";
                String port="3306";
                String dbName="sampledb";
                String username="root";
                String password ="root";
                String jdbcAdditionalParams="useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useLegacyDatetimeCode=false&UseSSL=false"; //Added string UseSSL= false to force connection without SSL encryption protocol
                Class<?> c = Class.forName(driver);
               System.out.println("Ho caricato: " + c.getName());
                String url = "jdbc:" + vendor + "://" + host + ":" + port + "/" + dbName+"?"+jdbcAdditionalParams;
                connection = (Connection) DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
