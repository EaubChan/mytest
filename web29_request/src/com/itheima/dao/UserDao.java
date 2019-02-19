package com.itheima.dao;

import com.itheima.bean.User;
import com.itheima.utils.C3P0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public User findByUnameAndPwd(String username, String password) throws Exception {
        //2.使用JDBCTemplate根据用户名和密码查询数据库,获得User对象
        //a.new出模板对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        //b.sql语句
        String sql = "select * from t_user where username = ? and password = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        return user;
    }
}
