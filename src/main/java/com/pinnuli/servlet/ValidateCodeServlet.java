package com.pinnuli.servlet;

import com.pinnuli.util.ValidateCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 验证码
 * @author: pinnuli
 * @date: 2018-4-23
 */

public class ValidateCodeServlet extends HttpServlet {

    private static final long serialVersionUID = -5959902910454750168L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new ValidateCodeUtil().getRandomCode(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
