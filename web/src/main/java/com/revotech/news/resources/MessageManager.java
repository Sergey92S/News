package com.revotech.news.resources;

import java.util.ResourceBundle;

/**
 * Created by Revotech on 22.06.2016.
 */
public class MessageManager {

    public volatile static MessageManager instance;
    private static ResourceBundle bundle;

    public static final String BUNDLE_NAME = "msg";

    // #MESSAGES
    public static final String MESSAGE_DELETE_SUCCESS = "MESSAGE_DELETE_SUCCESS";
    public static final String MESSAGE_NULL_PAGE = "MESSAGE_NULL_PAGE";

    // #ERRORS
    public static final String MESSAGE_VALIDATION_ERROR = "MESSAGE_VALIDATION_ERROR";

    public static MessageManager getInstance() {
        if (instance == null) {
            synchronized (MessageManager.class) {
                if (instance == null) {
                    instance = new MessageManager();
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
