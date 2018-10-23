package com.pinnuli.servlet;

import com.pinnuli.service.UserService;
import com.pinnuli.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description: 登录
 * @author: pinnuli
 * @date: 2018-4-23
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = -3558756660728209099L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String validateCode = request.getParameter("validateCode");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        UserService userService = new UserServiceImpl();
        String msg = userService.doLogin(username, password, validateCode, session);
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/login_result.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
