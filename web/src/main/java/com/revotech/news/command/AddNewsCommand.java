package com.revotech.news.command;

import com.revotech.news.resources.PageManager;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Revotech on 14.06.2016.
 */
public class AddNewsCommand extends ActionCommand {

    @Override
    public String execute(HttpServletRequest request, List<FileItem> multiParts) {
        return pageManager.getProperty(PageManager.PATH_PAGE_ADD);
    }
}
