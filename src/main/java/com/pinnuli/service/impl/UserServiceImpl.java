package com.pinnuli.service.impl;

import com.pinnuli.bean.UserBean;
import com.pinnuli.dao.impl.UserDaoImpl;
import com.pinnuli.service.UserService;
import com.pinnuli.util.CodeUtil;
import com.pinnuli.util.MailUtil;
import com.pinnuli.util.ValidateCodeUtil;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-10-23
 */

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDaoImpl = new UserDaoImpl();


    @Override
    public String doRegister(String username, String password, String email, String validateCode, HttpSession session) {
        String msg;

        //校验验证码
        String randomString = (String) session.getAttribute(ValidateCodeUtil.RANDOM_CODE_KEY);
        if (!validateCode.toLowerCase().equals(randomString)) {
            msg = "注册失败，验证码错误";
            return msg;
        }

        //利用正则表达式验证邮箱是否符合邮箱的格式
        if (!email.matches("^\\w+@(\\w+\\.)+\\w+$")) {
            msg = "邮箱格式不正确";
            return msg;
        }

        //判断用户名和邮箱是否已存在
        if (userDaoImpl.checkUsername(username)) {
            msg = "该用户名已存在";
            return msg;
        }
        if (userDaoImpl.checkEmail(email)) {
            msg = "该邮箱已绑定过其他用户";
            return msg;
        }

        //生成激活码
        String code = CodeUtil.generateActiveCode();
        UserBean user = new UserBean(username, email, password, 0, code);
        //将用户保存到数据库，保存成功则开个线程的方式给用户发送一封邮件
        if (userDaoImpl.save(user) > 0) {
            new Thread(new MailUtil(email, code)).start();
            msg = "注册成功，请登录邮箱激活账号";
            return msg;
        }
        msg = "注册失败，请检查相关信息";
        return msg;
    }


    @Override
    public boolean activeUser(String code) {
        return userDaoImpl.activeUser(code) > 0;
    }

    @Override
    public String doLogin(String username, String password, String validateCode, HttpSession session) {
        String msg;
        UserBean user = new UserBean(username, password);

        //校验验证码
        String randomString = (String) session.getAttribute(ValidateCodeUtil.RANDOM_CODE_KEY);
        if (!validateCode.toLowerCase().equals(randomString)) {
            msg = "登录失败，验证码错误";
            return msg;
        }

        if (userDaoImpl.checkUsernameAndPassword(user)) {
            //登录成功把用户放到session中
            session.setAttribute("currentUser", user.getUsername());
            msg = "登录成功";
            return msg;
        }
        if (userDaoImpl.checkUsername(user.getUsername())) {
            msg = "登录失败，密码错误";
            return msg;
        }
        msg = "登录失败，用户不存在";
        return msg;
    }
}
