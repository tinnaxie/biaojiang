/**
 * 
 */
package com.itinna.smalltool;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

/**
 * @author tinna
 *
 */
public class JdbcConection {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // 建立数据库 连接
            String url = "jdbc:mysql://localhost:3306/biaojiang?characterEncoding=UTF-8";
            String uid = "root";
            String pw = "123456";
            conn = (Connection) DriverManager.getConnection(url, uid, pw);
            System.out.println("数据库连接成功!!!");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        getConnection();
    }

}
