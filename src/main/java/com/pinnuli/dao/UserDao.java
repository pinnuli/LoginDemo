package com.pinnuli.dao;

import com.pinnuli.bean.UserBean;

import java.sql.ResultSet;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-10-23
 */
public interface UserDao {

    /**
     * 保存用户信息
     * @param user 用户信息
     * @return 数据库影响行数
     */
    int save(UserBean user);

    /**
     * 激活账号
     * @param code 激活码
     * @return 数据库影响行数
     */
    int activeUser(String code);

    /**
     * 检查用户名是否存在
     * @param username 用户名
     * @return 检查结果
     */
    boolean checkUsername(String username);

    /**
     * 检查邮箱是否已绑定过
     * @param email 邮箱
     * @return 检查结果
     */
    boolean checkEmail(String email);

    /**
     * 检查用户密码是否存在
     * @param password 密码
     * @return 检查结果
     */
    boolean checkPassword(String password);

    /**
     * 检查用户是否存在
     * @param user 用户信息
     * @return 检查结果
     */
    boolean checkUsernameAndPassword(UserBean user);
}
