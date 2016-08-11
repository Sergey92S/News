package com.revotech.news.resources;

import java.util.ResourceBundle;

/**
 * Created by Revotech on 21.06.2016.
 */
public class SqlManager {

    public volatile static SqlManager instance;
    private static ResourceBundle bundle;

    public static final String BUNDLE_NAME = "sql";

    // #NEWS BaseDao
    public static final String SQL_SELECT_ALL_NEWS = "SQL_SELECT_ALL_NEWS";
    public static final String SQL_SELECT_ID = "SQL_SELECT_ID";
    public static final String SQL_DELETE_NEWS = "SQL_DELETE_NEWS";

    public static SqlManager getInstance() {
        if (instance == null) {
            synchronized (SqlManager.class) {
                if (instance == null) {
                    instance = new SqlManager();
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
