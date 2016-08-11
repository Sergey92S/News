package com.revotech.news.dao;

import com.revotech.news.exceptions.DaoException;
import com.revotech.news.resources.SqlManager;
import com.revotech.news.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Revotech on 14.06.2016.
 */
public abstract class BaseDao<T> implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);
    protected Transaction transaction = null;
	protected static SqlManager sqlManager;
    public static HibernateUtil util = null;
    public static final String DATE_FROM = "yyyy-mm-dd";
    public static final String DATE_TO = "dd/mm/yyyy";

    public BaseDao(){
        sqlManager = SqlManager.getInstance();
    }

    public void saveOrUpdate(T t) throws DaoException {
        try {
            util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            log.info("saveOrUpdate(t):" + t);
            transaction.commit();
            log.info("Save or update (commit):" + t);
        } catch (HibernateException e) {
            log.error("Error save or update News in Dao" + e);
            transaction.rollback();
            throw new DaoException(e);
        }

    }

    public List<T> get(Serializable id) throws DaoException {
        log.info("Get class by id:" + id);
        T t;
        List<T> buf = new ArrayList<>();
        try {
            util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            t = (T) session.get(getPersistentClass(), id);
            transaction.commit();
            log.info("get clazz:" + t);
        } catch (HibernateException e) {
            transaction.rollback();
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        buf.add(t);
        return buf;
    }

    public T load(Serializable id) throws DaoException {
        log.info("Load class by id:" + id);
        T t;
        try {
            util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            t = (T) session.load(getPersistentClass(), id);
            log.info("load() clazz:" + t);
            session.isDirty();
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            transaction.rollback();
            throw new DaoException(e);
        }
        return t;
    }

    public void delete(T t) throws DaoException {
        try {
            util = HibernateUtil.getHibernateUtil();
            Session session = util.getSession();
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error delete News in Dao" + e);
            transaction.rollback();
            throw new DaoException(e);
        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
