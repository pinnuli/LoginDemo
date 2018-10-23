package com.pinnuli.service;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-10-23
 */
public interface UserService {

    /**
     * 根据用户提交信息注册用户
     *
     * @param userName     用户名
     * @param password     密码
     * @param email        邮箱
     * @param validateCode 验证码
     * @param session      连接会话
     * @return 注册结果信息
     */
    String doRegister(String userName, String password, String email, String validateCode, HttpSession session);

    /**
     * 激活账号
     *
     * @param code 激活码
     * @return 激活结果
     */
    boolean activeUser(String code);

    /**
     * 根据用户提交信息登录
     *
     * @param username     用户名
     * @param password     密码
     * @param validateCode 验证码
     * @param session      连接会话
     * @return 登录结果信息
     */
    String doLogin(String username, String password, String validateCode, HttpSession session);
}
