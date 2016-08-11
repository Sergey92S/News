package com.revotech.news.command;

import com.revotech.news.NewsService;
import com.revotech.news.entities.News;
import com.revotech.news.exceptions.DaoException;
import com.revotech.news.resources.MessageManager;
import com.revotech.news.resources.PageManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Revotech on 14.06.2016.
 */
public class SaveCommand extends ActionCommand {
    private static Logger logger = Logger.getLogger(SaveCommand.class.getName());
    private String page;

    @Override
    public String execute(HttpServletRequest request, List<FileItem> multiParts) {
        NewsService newsService = NewsService.getInstance();
        News news = new News();
        Map<String, String> requestList = new HashMap<>();
        requestList.put(PARAM_AUTHOR.toUpperCase(), null);
        requestList.put(PARAM_DATE.toUpperCase(), null);
        requestList.put(PARAM_TITLE.toUpperCase(), null);
        requestList.put(PARAM_CONTENT.toUpperCase(), null);
        requestList.put(PARAM_IMAGE.toUpperCase(), null);

        try {
            request.setCharacterEncoding(PARAM_UTF);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {

            getRequestParam(request, multiParts, requestList);

            if (validation(requestList.get(PARAM_AUTHOR.toUpperCase()).trim(), requestList.get(PARAM_DATE.toUpperCase()).trim(),
                    requestList.get(PARAM_TITLE.toUpperCase()).trim(), requestList.get(PARAM_CONTENT.toUpperCase()).trim(), requestList.get(PARAM_IMAGE.toUpperCase()).trim())) {

                if(ServletFileUpload.isMultipartContent(request)) {
                    try {
                        for (FileItem item : multiParts) {
                            if (!item.isFormField()) {
                                String name = new File(item.getName()).getName();
                                item.write(new File(UPLOAD_DIRECTORY+ File.separator + name));
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace(); }
                }
                news.setAuthor(requestList.get(PARAM_AUTHOR.toUpperCase()));
                news.setDate(requestList.get(PARAM_DATE.toUpperCase()));
                news.setTitle(requestList.get(PARAM_TITLE.toUpperCase()));
                news.setContent(requestList.get(PARAM_CONTENT.toUpperCase()));
                news.setImage(requestList.get(PARAM_IMAGE.toUpperCase()));
                newsService.saveOrUpdate(news);
                request.getSession().setAttribute(RESULT_ATTRIBUTE,
                        newsService.get(newsService.getId(news)));
                page = pageManager.getProperty(PageManager.PATH_PAGE_VIEW);
            } else {
                request.setAttribute(ERROR_VALIDATION_MESSAGE, messageManager.getProperty(MessageManager.MESSAGE_VALIDATION_ERROR));
                page = pageManager.getProperty(PageManager.PATH_PAGE_ADD);
            }

        } catch (DaoException e) {
            e.printStackTrace();
        }

        logger.debug("SaveCommand returned: " + page);
        return page;
    }

}

