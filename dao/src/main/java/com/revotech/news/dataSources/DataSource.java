package com.revotech.news.dataSources;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.revotech.news.resources.DBManager;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Revotech on 16.06.2016.
 */
public class DataSource {
    public volatile static DataSource datasource;
    private ComboPooledDataSource cpds;
    protected static DBManager dbManager;

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        dbManager = DBManager.getInstance();
        Locale.setDefault(Locale.US);
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass(dbManager.getProperty(DBManager.DRIVER_CLASS)); //loads the jdbc driver
        cpds.setJdbcUrl(dbManager.getProperty(DBManager.JDBC_URL));
        cpds.setUser(dbManager.getProperty(DBManager.DB_USER));
        cpds.setPassword(dbManager.getProperty(DBManager.DB_PASSWORD));
        // the settings below are optional -- c3p0 can work with defaults
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            synchronized (DataSource.class) {
                if (datasource == null) {
                    datasource = new DataSource();
                }
            }
        }
        return datasource;
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }
}
