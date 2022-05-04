package com.github.evacode.fill.db;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 * apache common dbUtil usage
 */
public class SelectUtil {
    private static final Logger LOG = Logger.getGlobal();
    static QueryRunner qr = new QueryRunner();

    /**
     * query many records
     *
     * @param sql    query sql
     * @param rsh    result handle
     * @param params sql params
     * @param <T>    result bean
     * @return list
     * @throws SQLException sql error
     */
    public static <T> List<T> queryList(String sql, BeanListHandler<T> rsh, Object... params) throws SQLException {
        Connection conn = DbConnectionUtil.getConnection();
        List<T> list = null;
        try {
            list = qr.query(conn, sql, rsh, params);
        } catch (SQLException e) {
            LOG.severe("queryList error" + e.getMessage());
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return list;
    }

    /**
     * query single records
     *
     * @param sql    query sql
     * @param rsh    result handle
     * @param params sql params
     * @param <T>    result bean
     * @return obj
     * @throws SQLException sql error
     */
    public static <T> T queryOne(String sql, BeanHandler<T> rsh, Object... params) throws SQLException {
        Connection conn = DbConnectionUtil.getConnection();
        T obj = null;
        try {
            obj = qr.query(conn, sql, rsh, params);
        } catch (SQLException e) {
            LOG.severe("queryOne error" + e.getMessage());
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return obj;
    }
}
