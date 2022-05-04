package com.github.evacode.fill.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * db util
 */
public class DbConnectionUtil {
    private static final HikariDataSource ds;

    static {
        HikariConfig config = new HikariConfig("/hikari.properties");
        ds = new HikariDataSource(config);
    }


    /**
     * get connection from pool
     *
     * @return db connection
     * @throws SQLException sql exception
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
