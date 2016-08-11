package com.revotech.news.resources;

import java.util.ResourceBundle;

/**
 * Created by Revotech on 22.06.2016.
 */
public class PageManager {

    public volatile static PageManager instance;
    private static ResourceBundle bundle;

    public static final String BUNDLE_NAME = "page";

    // #PAGES
    public static final String PATH_PAGE_ADD = "PATH_PAGE_ADD";
    public static final String PATH_PAGE_LIST = "PATH_PAGE_LIST";
    public static final String PATH_PAGE_VIEW = "PATH_PAGE_VIEW";
    public static final String PATH_PAGE_EDIT = "PATH_PAGE_EDIT";
    public static final String PATH_PAGE_INDEX = "PATH_PAGE_INDEX";

    public static PageManager getInstance() {
        if (instance == null) {
            synchronized (PageManager.class) {
                if (instance == null) {
                    instance = new PageManager();
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
