package com.atguigu.ignite.test.trash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/7/12 14:13
 * @Created by 86153
 */
public class Create {
    public static void main(String[] args) throws Exception{
        // Register JDBC driver.
        Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

        // Open JDBC connection.
        Connection conn = DriverManager.getConnection("jdbc:ignite:thin://hadoop102/");

        // Create database tables.
        try (Statement stmt = conn.createStatement()) {

            // Create table based on REPLICATED template.
            stmt.executeUpdate("CREATE TABLE City (" +
                    " id LONG PRIMARY KEY, name VARCHAR) " +
                    " WITH \"template=replicated\"");

            // Create table based on PARTITIONED template with one backup.
            stmt.executeUpdate("CREATE TABLE Person (" +
                    " id LONG, name VARCHAR, city_id LONG, " +
                    " PRIMARY KEY (id, city_id)) " +
                    " WITH \"backups=1, affinityKey=city_id\"");

            // Create an index on the City table.
            stmt.executeUpdate("CREATE INDEX idx_city_name ON City (name)");

            // Create an index on the Person table.
            stmt.executeUpdate("CREATE INDEX idx_person_name ON Person (name)");
        }
    }
}
