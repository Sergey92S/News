package com.revotech.news.command;

import com.revotech.news.NewsService;
import com.revotech.news.exceptions.DaoException;
import com.revotech.news.resources.MessageManager;
import com.revotech.news.resources.PageManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Revotech on 14.06.2016.
 */
public class DeleteCommand extends ActionCommand {
    private static Logger logger = Logger.getLogger(DeleteCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, List<FileItem> multiParts) {
        String page;
        Integer[] i = new Integer[1];
        NewsService newsService = NewsService.getInstance();
        try {
            String news = request.getParameter(OPTION_ATTRIBUTE);
            logger.debug("News: " + news);
            i[0] = Integer.parseInt(news);
            newsService.deleteNews(i);
            request.setAttribute(DELETE_SUCCESS_MESSAGE, messageManager.getProperty(MessageManager.MESSAGE_DELETE_SUCCESS));
            request.getSession().setAttribute(RESULT3_ATTRIBUTE,
                    newsService.getAllNews());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        page = pageManager.getProperty(PageManager.PATH_PAGE_LIST);
        logger.debug("DeleteCommand returned: " + page);
        return page;
    }
}