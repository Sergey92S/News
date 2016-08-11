package com.revotech.news;

import com.revotech.news.dao.NewsDao;
import com.revotech.news.entities.News;
import com.revotech.news.exceptions.DaoException;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Revotech on 14.06.2016.
 */
public class NewsDaoTest extends TestCase {

    @Test
    public void test() throws DaoException {
        NewsDao newsDao = NewsDao.getInstance();
        assertTrue(newsDao.getAllNews().size() > 1);
        //assertEquals(1, newsDao.get(1).size());
        News news = new News();
        news.setDate("2016-06-01");
        news.setImage("Winter.jpg");
        news.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.!!! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        news.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        news.setAuthor("Author");
        //assertEquals(1, newsDao.getId(news));
    }

}
