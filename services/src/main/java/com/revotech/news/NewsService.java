package com.revotech.news;

import com.revotech.news.dao.NewsDao;
import com.revotech.news.entities.News;
import com.revotech.news.exceptions.DaoException;
import com.revotech.news.utils.NewsComparator;

import java.util.Collections;
import java.util.List;

/**
 * Created by Revotech on 14.06.2016.
 */
public final class NewsService {
    private NewsDao dao;
    public volatile static NewsService instance;

    public NewsService() {
        dao = NewsDao.getInstance();
    }

    public static NewsService getInstance() {
        if (instance == null) {
            synchronized (NewsService.class) {
                if (instance == null) {
                    instance = new NewsService();
                }
            }
        }
        return instance;
    }

    public void saveOrUpdate(News account) throws DaoException {
        dao.saveOrUpdate(account);
    }

    public List<News> getAllNews() throws DaoException {
        List<News> news = dao.getAllNews();
        Collections.sort(news, new NewsComparator());
        return news;
    }

    public List<News> get(int id) throws DaoException {
        return dao.get(id);
    }

    public int getId(News news) throws DaoException {
        return dao.getId(news);
    }

    public void deleteNews(Integer[] id) throws DaoException {
        dao.deleteNews(id);
    }
}
