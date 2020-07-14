package com.atguigu.ignite.test.trash;

import java.sql.*;

/**
 * @Classname AddIgnite
 * @Description TODO
 * @Date 2020/7/12 14:38
 * @Created by 86153
 */
public class AddIgnite {
    public static void main(String[] args) throws Exception{
        // Register JDBC driver
        Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

        // Open JDBC connection
        Connection conn = DriverManager.getConnection("jdbc:ignite:thin://hadoop102/");

        // Get data
        try (Statement stmt = conn.createStatement()) {
            try (ResultSet rs =
                         stmt.executeQuery("SELECT p.name, c.name " +
                                 " FROM Person p left join City c " +
                                 " on p.city_id = c.id")) {

                while (rs.next())
                    System.out.println(rs.getString(1) + ", " + rs.getString(2));
            }
        }

    }
}
