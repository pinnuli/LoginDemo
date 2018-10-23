package com.pinnuli.dao.impl;

import com.pinnuli.bean.UserBean;
import com.pinnuli.dao.UserDao;
import com.pinnuli.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @description:
 * @author: pinnuli
 * @date: 2018-10-23
 */

public class UserDaoImpl implements UserDao {

    @Override
    public int save(UserBean user) {
        int saveResult = 0;
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "insert into user(username,email,password,state,code) values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getState());
            pstmt.setString(5, user.getCode());
            saveResult = pstmt.executeUpdate();
            DBUtil.close(conn, pstmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saveResult;

    }

    @Override
    public int activeUser(String code) {
        int activeResult = 0;
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "update user set state=1 where code=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, code);
            activeResult = pstmt.executeUpdate();
            DBUtil.close(conn, pstmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activeResult;
    }

    @Override
    public boolean checkUsername(String username) {
        ResultSet rs;
        boolean checkResult = false;
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "select * from user where username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            checkResult = rs.next();
            DBUtil.close(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkResult;
    }

    @Override
    public boolean checkEmail(String email) {
        ResultSet rs;
        boolean checkResult = false;
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "select * from user where email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            checkResult = rs.next();
            DBUtil.close(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkResult;
    }

    @Override
    public boolean checkPassword(String password) {
        ResultSet rs;
        boolean checkResult = false;
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "select * from user where password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            rs = pstmt.executeQuery();
            checkResult = rs.next();
            DBUtil.close(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkResult;
    }

    @Override
    public boolean checkUsernameAndPassword(UserBean user) {
        ResultSet rs;
        boolean checkResult = false;
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "select * from user" +
                    " where username = ? and password = ? and state = 1";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            rs = pstmt.executeQuery();
            checkResult = rs.next();
            DBUtil.close(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkResult;
    }
}
