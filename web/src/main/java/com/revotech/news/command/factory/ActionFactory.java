package com.revotech.news.command.factory;

import com.revotech.news.command.ActionCommand;
import com.revotech.news.command.EmptyCommand;
import com.revotech.news.command.enums.CommandEnum;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Revotech on 14.06.2016.
 */
public class ActionFactory {
    //MESSAGES
    private static String MESSAGE_WRONG_ACTION = ": command not found or wrong!";

    //ACTION COMMANDS
    private static String COMMAND_ACTION = "command";
    private static String SUBMIT_EDIT_ACTION = "multisubmitedit";
    private static String SUBMIT_ACTION = "multisubmit";


    //ACTION DEFINITIONS
    private static String SUBMIT_DEFINITION = "submit";
    private static String SAVE_DEFINITION = "Save";
    private static String UPDATE_DEFINITION = "Update";

    //ATTRIBUTES
    private static String WRONG_ACTION_ATTRIBUTE = "wrongAction";

    public ActionCommand defineCommand(HttpServletRequest request, List<FileItem> multiParts) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter(COMMAND_ACTION);


        if(ServletFileUpload.isMultipartContent(request)) {
            try {
                for (FileItem item : multiParts) {
                    if (item.isFormField() && item.getFieldName().equals(COMMAND_ACTION)) {
                        action = item.getString();
                        break;
                    }
                }
                if (action == null || action.isEmpty()) {
                    return current;
                }
                if (action.equals(SUBMIT_EDIT_ACTION)) {
                    for (FileItem item : multiParts) {
                        if (item.isFormField() && item.getFieldName().equals(SUBMIT_DEFINITION)) {
                            action = item.getString();
                            if(item.getString().equals(SAVE_DEFINITION)){
                                action = UPDATE_DEFINITION;
                                break;
                            }
                        }
                    }
                } else if (action.equals(SUBMIT_ACTION)) {
                    for (FileItem item : multiParts) {
                        if (item.isFormField() && item.getFieldName().equals(SUBMIT_DEFINITION)) {
                            action = item.getString();
                            break;
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else{
            if (action == null || action.isEmpty()) {
                return current;
            }
            if (action.equals(SUBMIT_EDIT_ACTION)) {
                action = request.getParameter(SUBMIT_DEFINITION);
                if (action.equals(SAVE_DEFINITION)) {
                    action = UPDATE_DEFINITION;
                }
            } else if (action.equals(SUBMIT_ACTION)) {
                action = request.getParameter(SUBMIT_DEFINITION);
            }
        }

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute(WRONG_ACTION_ATTRIBUTE, action + MESSAGE_WRONG_ACTION);
        }
        return current;
    }
}
