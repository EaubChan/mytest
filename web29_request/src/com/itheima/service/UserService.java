package com.itheima.service;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;

public class UserService {
    public User login(String username, String password) throws Exception{
        //1处理业务
        //2调用dao
        UserDao userDao = new UserDao();
        User user = userDao.findByUnameAndPwd(username,password);
        return user;
    }
}
