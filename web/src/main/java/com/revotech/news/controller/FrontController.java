package com.revotech.news.controller;

import com.revotech.news.command.ActionCommand;
import com.revotech.news.command.factory.ActionFactory;
import com.revotech.news.resources.MessageManager;
import com.revotech.news.resources.PageManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Revotech on 14.06.2016.
 */
@SuppressWarnings("serial")
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
    // ATTRIBUTES
    private static String NULL_PAGE_ATTRIBUTE = "nullPage";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page;
        List<FileItem> multiParts = null;
        ActionFactory client = new ActionFactory();
        try {
            multiParts = new ServletFileUpload(
                    new DiskFileItemFactory()).parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        ActionCommand command = client.defineCommand(request, multiParts);
        page = command.execute(request, multiParts);
        MessageManager messageManager = MessageManager.getInstance();
        PageManager pageManager = PageManager.getInstance();
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = pageManager.getProperty(PageManager.PATH_PAGE_INDEX);
            request.getSession().setAttribute(NULL_PAGE_ATTRIBUTE, messageManager.getProperty(MessageManager.MESSAGE_NULL_PAGE));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}