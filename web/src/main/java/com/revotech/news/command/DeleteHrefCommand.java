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
public class DeleteHrefCommand extends ActionCommand {
    private static Logger logger = Logger.getLogger(DeleteHrefCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, List<FileItem> multiParts) {
        String page;
        NewsService newsService = NewsService.getInstance();
        try {
            String[] news;
            if ((news = request.getParameterValues(NEWSTODELETE_ATTRIBUTE)) != null) {
                Integer[] j = new Integer[news.length];
                int i=0;
                for (String buf : news) {
                    j[i] = Integer.parseInt(buf);
                    i++;
                }
                newsService.deleteNews(j);
                request.setAttribute(DELETE_SUCCESS_MESSAGE, messageManager.getProperty(MessageManager.MESSAGE_DELETE_SUCCESS));

            } else {
                request.setAttribute(ERROR_VALIDATION_MESSAGE, messageManager.getProperty(MessageManager.MESSAGE_VALIDATION_ERROR));
            }
            request.getSession().setAttribute(RESULT3_ATTRIBUTE,
                    newsService.getAllNews());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        page = pageManager.getProperty(PageManager.PATH_PAGE_LIST);
        logger.debug("DeleteHrefCommand returned: " + page);
        return page;
    }
}
