package com.revotech.news.dataSources;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Revotech on 14.06.2016.
 */
public class DBConnection {
    private static DBConnection instance;

    private DBConnection() {
        Driver driver;
        Locale.setDefault(Locale.US);
        try {
            driver = (Driver) Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public synchronized Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
    }
}
