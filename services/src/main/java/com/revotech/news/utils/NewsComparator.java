package com.revotech.news.utils;

import com.revotech.news.entities.News;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Revotech on 14.06.2016.
 */
public class NewsComparator implements Comparator<News> {
    public static final String DATE = "dd/mm/yyyy";

    public int compare(News o1, News o2) {
        SimpleDateFormat sdf1 = new SimpleDateFormat(DATE);
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf1.parse(o1.getDate());
            date2 = sdf1.parse(o2.getDate());
            String s1 = o1.getDate();
            String s2 = o2.getDate();
            date1 = sdf1.parse(s1);
            date2 = sdf1.parse(s2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date1 == null || date2 == null)
            return 0;
        int i = date1.compareTo(date2);
        return i;
    }
}
