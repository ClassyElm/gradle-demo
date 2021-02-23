package com.pjcraig.controller;

import com.pjcraig.entity.User;
import com.pjcraig.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/demo"}
)

public class DemoServlet extends HttpServlet {
    /**
     * Forwards the user to the demo results page.
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException Whether or not the servlet encounters an error.
     * @throws IOException Whether or not an IO exception occurs.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(User.class);

        List<User> users = dao.getAll();

        request.setAttribute("users", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/demo.jsp");
        dispatcher.forward(request, response);
    }
}