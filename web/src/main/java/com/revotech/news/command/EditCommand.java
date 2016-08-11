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
public class EditCommand extends ActionCommand {
    private static Logger logger = Logger.getLogger(EditCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, List<FileItem> multiParts) {
        String page;
        NewsService newsService = NewsService.getInstance();
        String option = request.getParameter(OPTION_ATTRIBUTE);
        if (option == null) {
            option = request.getSession().getAttribute(OPTION_ATTRIBUTE).toString();
        }
        try {
            request.getSession().setAttribute(RESULT2_ATTRIBUTE,
                    newsService.get(Integer.parseInt(option)));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute(OPTION_ATTRIBUTE, request.getParameter(OPTION_ATTRIBUTE));
        page = pageManager.getProperty(PageManager.PATH_PAGE_EDIT);
        logger.debug("Request items EDIT!!!!: " + option);
        logger.debug("EditCommand returned: " + page);
        return page;
    }
}

