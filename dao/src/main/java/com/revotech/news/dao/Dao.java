package com.revotech.news.dao;

import com.revotech.news.exceptions.DaoException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Revotech on 11.07.2016.
 */
public interface Dao<T> {
    void saveOrUpdate(T t) throws DaoException;

    List<T> get(Serializable id) throws DaoException;

    T load(Serializable id) throws DaoException;

    void delete(T t) throws DaoException;
}

