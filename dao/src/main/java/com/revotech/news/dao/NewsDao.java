package com.revotech.news.dao;

import com.revotech.news.entities.News;
import com.revotech.news.exceptions.DaoException;
import com.revotech.news.resources.SqlManager;
import com.revotech.news.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Revotech on 14.06.2016.
 */
public final class NewsDao extends BaseDao<News> {
    public volatile static NewsDao instance;
    private static Logger log = Logger.getLogger(NewsDao.class);
    public static final String ID = "ids";

    private NewsDao() {
        super();
    }

    public static NewsDao getInstance() {
        if (instance == null) {
            synchronized (NewsDao.class) {
                if (instance == null) {
                    instance = new NewsDao();
                }
            }
        }
        return instance;
    }

    public List<News> getAllNews() throws DaoException {
        SimpleDateFormat sdf1 = new SimpleDateFormat(DATE_FROM);
        SimpleDateFormat sdf2 = new SimpleDateFormat(DATE_TO);
        Date date = null;
        List<News> ai;
        try {
            util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(sqlManager.getProperty(SqlManager.SQL_SELECT_ALL_NEWS));
            ai = query.list();
            for (News buf : ai) {
                try {
                    date = sdf1.parse(buf.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                buf.setDate(sdf2.format(date));
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error getAllNews() News" + e);
            transaction.rollback();
            throw new DaoException(e);
        }
        return ai;
    }

    public int getId(News news) throws DaoException {
        int id = -1;
        try {
            util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(sqlManager.getProperty(SqlManager.SQL_SELECT_ID));
            query.setString(0, news.getAuthor());
            query.setString(1, news.getDate());
            query.setString(2, news.getTitle());
            query.setString(3, news.getContent());
            query.setString(4, news.getImage());
            id = (int) query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error deleteNews() News" + e);
            transaction.rollback();
            throw new DaoException(e);
        }
        return id;
    }

    public void deleteNews(Integer[] ids) throws DaoException {
        try {
            util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(sqlManager.getProperty(SqlManager.SQL_DELETE_NEWS));
            query.setParameterList(ID, ids);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error deleteNews() News" + e);
            transaction.rollback();
            throw new DaoException(e);
        }
    }

}
