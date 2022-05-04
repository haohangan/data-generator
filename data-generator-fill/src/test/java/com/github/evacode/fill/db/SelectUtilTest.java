package com.github.evacode.fill.db;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * SelectUtil Tester.
 *
 * @author guihao
 * @version 1.0
 */
public class SelectUtilTest {

    /**
     * Method: queryList(String sql, BeanListHandler<T> rsh, Object... params)
     */
    @Test
    public void testQueryList() throws Exception {
        String sql = "select * from table_test";
        List<TableTest> list = SelectUtil.queryList(sql, new BeanListHandler<>(TableTest.class));
        Assert.assertNotNull(list);
        list.forEach(System.out::println);
    }

    /**
     * Method: queryOne(String sql, BeanHandler<T> rsh, Object... params)
     */
    @Test
    public void testQueryOne() throws Exception {
        String sql = "select * from table_test where id = ?";
        Object[] params = new Object[]{1};
        TableTest obj = SelectUtil.queryOne(sql, new BeanHandler<>(TableTest.class), params);
        Assert.assertNotNull(obj);
        System.out.println(obj);
    }


    public static class TableTest {
        private Integer id;
        private String name;
        private Integer age;
        private String phone;
        private String sex;
        private String ip;
        private String word;
        private String img;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        @Override
        public String toString() {
            return "TableTest{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", phone='" + phone + '\'' + ", sex='" + sex + '\'' + ", ip='" + ip + '\'' + ", word='" + word + '\'' + ", img='" + img + '\'' + '}';
        }
    }
}
