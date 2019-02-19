package com.itheima.web;

import com.itheima.bean.User;
import com.itheima.service.UserService;
import com.itheima.utils.C3P0Utils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1.获得请求参数(用户名,密码)
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //2调用业务
            UserService userService = new UserService();
            User user =userService.login(username,password);

            //3.判断是否登录成功,说白了就是判断User是否为null
            if (user != null){
                response.getWriter().print("Login Success...");
            }else{
                response.getWriter().print("Login Faled...");
            }
        } catch (Exception e) {
            response.getWriter().print("Login Faled...");
            e.printStackTrace();

        }
    }
}
