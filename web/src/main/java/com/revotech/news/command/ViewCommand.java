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
public class ViewCommand extends ActionCommand {
    private static Logger logger = Logger.getLogger(ViewCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, List<FileItem> multiParts) {
        String page;
        NewsService newsService = NewsService.getInstance();
        try {
            request.getSession().setAttribute(RESULT_ATTRIBUTE,
                    newsService.get(Integer.parseInt(request.getParameter(OPTION_ATTRIBUTE))));
            request.getSession().setAttribute(FLAG_ATTRIBUTE, DEFINITION_EDIT);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        page = pageManager.getProperty(PageManager.PATH_PAGE_VIEW);
        logger.debug("Request items : ");
        logger.debug("ViewCommand returned: " + page);
        return page;
    }
}
