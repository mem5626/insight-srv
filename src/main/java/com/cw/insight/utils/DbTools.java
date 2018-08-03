package com.cw.insight.utils;

import java.sql.*;
import java.util.List;

public class DbTools {
    private Connection conn = null;
    private Statement statement = null;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String JDBCURL = "jdbc:mysql://www.hi5399.xyz:3306/insight-wx";
    private static String USERNAME = "insight-wx";
    private static String PASSWORD = "insight123!";

    public void openConn() {
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
            statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql) {
        try {
            openConn();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            openConn();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            conn.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet doQuery(String sql) {
        DbTools tool = new DbTools();
        tool.openConn();
        ResultSet rs = tool.executeQuery(sql);
        return rs;
    }

    public static int doUpdate(String sql) {
        DbTools tool = new DbTools();
        tool.openConn();
        int count = tool.executeUpdate(sql);
        return count;
    }

    public static boolean checkIfExist(String sql) {
        try {
            ResultSet rs = DbTools.doQuery(sql);
            if (rs != null && rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String args[]) {
//        try {
//            DbTools jdbc = new DbTools();
//            jdbc.openConn();
//            ResultSet rs = jdbc.executeQuery("select * from insight_user");
//            while (rs.next()) {
//                String openid = rs.getString("openid");
//                System.out.println(openid);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String a = "abcdef";
        String x = a.substring(0,a.length()-1);
        String v = a.substring(a.length()-1);
        System.out.println(x);
        System.out.println(v);
    }
}
