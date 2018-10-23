package com.pinnuli.servlet;

import com.pinnuli.service.UserService;
import com.pinnuli.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 激活
 * @author: pinnuli
 * @date: 2018-4-23
 */
@WebServlet(name = "ActiveServlet")
public class ActiveServlet extends HttpServlet {

    private static final long serialVersionUID = -3320552503780995497L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        System.out.println("code" + code);
        UserService userService = new UserServiceImpl();
        if (userService.activeUser(code)) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
