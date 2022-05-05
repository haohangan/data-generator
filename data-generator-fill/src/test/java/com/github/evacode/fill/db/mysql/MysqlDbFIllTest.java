package com.github.evacode.fill.db.mysql;

import com.github.evacode.fill.db.SelectUtil;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MysqlDbFIllTest {


    @Test
    public void testQueryColumn() throws SQLException {
        String schema = "data_test";
        String table = "table_test";
        String sql = "SELECT * FROM information_schema.`COLUMNS` WHERE table_schema = ?  AND `TABLE_NAME` =  ?";
        List<Map<String, Object>> list = SelectUtil.queryList(sql, new MapListHandler(), schema, table);
        Assert.assertNotNull(list);
        list.forEach(System.out::println);
    }
}
