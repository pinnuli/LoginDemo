package com.pinnuli.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: 数据库连接工具类
 * @author: pinnuli
 * @date: 2018-4-23
 */

public class DBUtil {

    private static ComboPooledDataSource cpds = null;

    static {
        cpds = new ComboPooledDataSource("mysql");
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
