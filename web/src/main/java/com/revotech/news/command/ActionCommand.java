package com.revotech.news.command;

import com.revotech.news.resources.MessageManager;
import com.revotech.news.resources.PageManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Revotech on 14.06.2016.
 */
public abstract class ActionCommand {
    protected static PageManager pageManager;
    protected static MessageManager messageManager;

    // FILE PATH
    protected static final String UPLOAD_DIRECTORY = "C:\\Users\\Revotech\\IdeaProjects\\News\\web\\src\\main\\webapp";

    // REQUEST ATTRIBUTES
    protected static final String FLAG_ATTRIBUTE = "flag";
    protected static final String RESULT3_ATTRIBUTE = "result3";
    protected static final String RESULT2_ATTRIBUTE = "result2";
    protected static final String RESULT_ATTRIBUTE = "result";
    protected static final String OPTION_ATTRIBUTE = "option";
    protected static final String NEWSTODELETE_ATTRIBUTE = "newstodelete";
    protected static final String TOTALCOUNT_ATTRIBUTE = "totalCount";

    // ATTRIBUTE DEFINITION
    protected static final String DEFINITION_NEWSLIST = "newslist";
    protected static final String DEFINITION_EDIT = "edit";

    // REQUEST MESSAGES
    protected static final String DELETE_SUCCESS_MESSAGE = "deleteSuccessMessage";

    // REQUEST ERRORS
    protected static final String ERROR_VALIDATION_MESSAGE = "errorValidationMessage";

    // NEWS PARAMETERS
    protected static final String PARAM_AUTHOR = "author";
    protected static final String PARAM_DATE = "date";
    protected static final String PARAM_TITLE = "title";
    protected static final String PARAM_CONTENT = "content";
    protected static final String PARAM_IMAGE = "file";
    protected static final String PARAM_UTF = "UTF-8";

    protected ActionCommand(){
        pageManager = PageManager.getInstance();
        messageManager = MessageManager.getInstance();
    }

    public abstract String execute(HttpServletRequest request, List<FileItem> multiParts);

    protected boolean validation(String author, String date, String title, String content, String image) {
        if ((author == null) || (author.isEmpty())) {
            return false;
        }

        if ((date == null) || (date.isEmpty())) {
            return false;
        }

        if ((title == null) || (title.isEmpty())) {
            return false;
        }

        if ((content == null) || (content.isEmpty())) {
            return false;
        }

        if ((image == null) || (image.isEmpty())) {
            return false;
        }

        return true;
    }

    protected void getRequestParam(HttpServletRequest request, List<FileItem> multiParts, Map<String, String> requestList){
        if(ServletFileUpload.isMultipartContent(request)) {
            try {
                for (FileItem item : multiParts) {
                    if (item.isFormField()) {
                        if(item.getFieldName().equals(PARAM_AUTHOR)){
                            requestList.put(PARAM_AUTHOR.toUpperCase(), item.getString());
                        }
                        if(item.getFieldName().equals(PARAM_DATE)){
                            requestList.put(PARAM_DATE.toUpperCase(), item.getString());
                        }
                        if(item.getFieldName().equals(PARAM_TITLE)){
                            requestList.put(PARAM_TITLE.toUpperCase(), item.getString());
                        }
                        if(item.getFieldName().equals(PARAM_CONTENT)){
                            requestList.put(PARAM_CONTENT.toUpperCase(), item.getString());
                        }
                    } else{
                        if(item.getFieldName().equals(PARAM_IMAGE)){
                            requestList.put(PARAM_IMAGE.toUpperCase(), item.getName());
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
