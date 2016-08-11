package com.revotech.news.resources;

import java.util.ResourceBundle;

/**
 * Created by Revotech on 21.06.2016.
 */
public class DBManager {

    public volatile static DBManager instance;
    private static ResourceBundle bundle;

    public static final String BUNDLE_NAME = "db";

    // #DB CONNECTION
    public static final String DRIVER_CLASS = "DRIVER_CLASS";
    public static final String JDBC_URL = "JDBC_URL";
    public static final String DB_USER = "DB_USER";
    public static final String DB_PASSWORD = "DB_PASSWORD";

    public static DBManager getInstance() {
        if (instance == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    instance = new DBManager();
                    bundle = ResourceBundle.getBundle(BUNDLE_NAME);
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return bundle.getString(key);
    }

}
