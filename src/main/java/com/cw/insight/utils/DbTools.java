package com.cw.insight.utils;

import java.sql.*;
import java.util.List;

public class DbTools {
    private Connection conn=null;
    private Statement statement=null;

    public void open(String driver,String jdbcUrl,String userName,String userPwd) {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(jdbcUrl,userName,userPwd);
            statement = conn.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql) {
        try {
            return statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
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

    public static ResultSet doQuery(String sql){
        DbTools jdbc= new DbTools();
        jdbc.open("com.mysql.jdbc.Driver","jdbc:mysql://www.hi5399.xyz:3306/insight-wx","insight-wx","insight123!");
        ResultSet rs =  jdbc.executeQuery(sql);
        return rs;
    }

    public static int doUpdate(String sql){
        DbTools jdbc= new DbTools();
        jdbc.open("com.mysql.jdbc.Driver","jdbc:mysql://www.hi5399.xyz:3306/insight-wx","insight-wx","insight123!");
        int count =  jdbc.executeUpdate(sql);
        return count;
    }

    public static boolean checkIfExist(String sql){
        try {
            ResultSet rs = DbTools.doQuery(sql);
            if(rs != null && rs.next()){
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String args[])
    {
        try {
            DbTools jdbc= new DbTools();
            jdbc.open("com.mysql.jdbc.Driver","jdbc:mysql://www.hi5399.xyz:3306/insight-wx","insight-wx","insight123!");
            ResultSet rs =  jdbc.executeQuery("select * from insight_user");

            while(rs.next()){
                String email = rs.getString("openid") ;
                System.out.println(email);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
