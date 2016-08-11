package com.revotech.news.command;

import com.revotech.news.NewsService;
import com.revotech.news.exceptions.DaoException;
import com.revotech.news.resources.PageManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Revotech on 14.06.2016.
 */
public class CancelCommand extends ActionCommand {
    private static Logger logger = Logger.getLogger(CancelCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, List<FileItem> multiParts) {
        String page;
        if (request.getSession().getAttribute(FLAG_ATTRIBUTE).toString().equals(DEFINITION_NEWSLIST)) {
            NewsService newsService = NewsService.getInstance();
            try {
                request.getSession().setAttribute(RESULT3_ATTRIBUTE,
                        newsService.getAllNews());
            } catch (DaoException e) {
                e.printStackTrace();
            }
            page = pageManager.getProperty(PageManager.PATH_PAGE_LIST);
        } else if (request.getSession().getAttribute(FLAG_ATTRIBUTE).toString().equals(DEFINITION_EDIT)) {
            NewsService newsService = NewsService.getInstance();
            try {
                request.getSession().setAttribute(RESULT_ATTRIBUTE,
                        newsService.get(Integer.parseInt(request.getSession().getAttribute(OPTION_ATTRIBUTE).toString())));
            } catch (DaoException e) {
                e.printStackTrace();
            }
            page = pageManager.getProperty(PageManager.PATH_PAGE_VIEW);
        } else {
            page = pageManager.getProperty(PageManager.PATH_PAGE_ADD);
        }
        logger.debug("CancelCommand returned: " + page);
        return page;
    }
}