package com.pinnuli.bean;

import com.pinnuli.util.MD5Util;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-10-23
 */

public class UserBean {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户账号状态：0表示未激活，1表示激活
     */
    private Integer state;

    /**
     * 激活码
     */
    private String code;

    public UserBean(){

    }

    public UserBean(String username, String password) {
        this.username = username;
        this.password = MD5Util.MD5Encode(password, "UTF-8");
    }

    public UserBean(String username, String email, String password, Integer state, String code) {
        this.username = username;
        this.email = email;
        this.password = MD5Util.MD5Encode(password, "UTF-8");
        this.state = state;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
