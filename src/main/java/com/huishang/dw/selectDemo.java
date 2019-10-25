package com.huishang.dw;

import java.sql.*;

/**
 * @author zhang_fei
 * @create 2019-10-22 17:11
 */
public class selectDemo {

    //数据库的配置
    static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dbUrl="jdbc:sqlserver://114.115.161.58:35043;DatabaseName=CRM_RETAIL_DW";
    static String us="zhangfei";
    static String pw="dHBMwvp1JDQsGQ6f";

    //连接数据库构造构造方法
    public  static Connection getConn(String dbDriver, String dbUrl, String us, String pw){
        Connection conn=null;
        try {
            Class.forName(dbDriver);
            conn= DriverManager.getConnection(dbUrl,us,pw);
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        }catch(SQLException e1){
            e1.printStackTrace();
        }
        return conn;
    }

    //查询表select
    public static void main(String[] args) throws SQLException {
        Connection conn=getConn(driverName, dbUrl, us, pw);
        Statement sta=conn.createStatement();
        ResultSet rs=sta.executeQuery("select * from CRM_POI_INFo");
        while(rs.next()){
            System.out.println("111");
            System.out.println(rs.toString());
        }
    }
}
