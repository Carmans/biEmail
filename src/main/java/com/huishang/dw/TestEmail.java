package com.huishang.dw;

import java.sql.*;
/*
 *  测试数据库连接的配置是否正常
 *  @author zhang_fei
 * @create 2019-10-22 11:24
*/
public class TestEmail {
    public static void main(String [] args)
    {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://114.115.161.58:35043;DatabaseName=CRM_RETAIL_DW";
        String userName="zhangfei";
        String userPwd="dHBMwvp1JDQsGQ6f";
        try
        {
            Class.forName(driverName);
            System.out.println("加载驱动成功！");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try{
            Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println("连接数据库成功！");
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
    }
}


