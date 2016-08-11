package com.revotech.news.command;

import javax.servlet.http.HttpServletRequest;

import com.revotech.news.NewsService;

import java.sql.SQLException;
import java.util.List;

import com.revotech.news.exceptions.DaoException;
import com.revotech.news.resources.PageManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

/**
 * Created by Revotech on 14.06.2016.
 */
public class NewsListCommand extends ActionCommand {
    private static Logger logger = Logger.getLogger(NewsListCommand.class.getName());
    private String page;

    @Override
    public String execute(HttpServletRequest request, List<FileItem> multiParts) {
        logger.debug("FLAG: " + request.getSession().getAttribute(FLAG_ATTRIBUTE));
        NewsService newsService = NewsService.getInstance();
        try {
            request.getSession().setAttribute(RESULT3_ATTRIBUTE,
                    newsService.getAllNews());
            request.getSession().setAttribute(TOTALCOUNT_ATTRIBUTE,
                    newsService.getAllNews().size());
            request.getSession().setAttribute(FLAG_ATTRIBUTE, DEFINITION_NEWSLIST);
            page = pageManager.getProperty(PageManager.PATH_PAGE_LIST);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        logger.debug("FLAG: " + request.getSession().getAttribute("flag"));
        logger.debug("NewsListCommand returned: " + page);
        return page;
    }

}
