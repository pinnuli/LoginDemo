package com.pinnuli.servlet;

import com.pinnuli.service.UserService;
import com.pinnuli.service.impl.UserServiceImpl;
import com.pinnuli.util.ValidateCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description: 注册
 * @author: pinnuli
 * @date: 2018-4-23
 */

@WebServlet(name = "register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = -3732914648910167171L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String validateCode = request.getParameter("validateCode");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();

        UserService userService = new UserServiceImpl();
        String msg = userService.doRegister(username, password, email, validateCode, session);
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/register_result.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
