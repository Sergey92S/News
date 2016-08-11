package com.revotech.news.command;

import javax.servlet.http.HttpServletRequest;

import com.revotech.news.resources.PageManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Revotech on 14.06.2016.
 */
public class EmptyCommand extends ActionCommand {
    private static Logger logger = Logger.getLogger(EmptyCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, List<FileItem> multiParts) {
        String page = pageManager.getProperty(PageManager.PATH_PAGE_LIST);
        logger.debug("EmptyCommand returned: " + page);
        return page;
    }

}