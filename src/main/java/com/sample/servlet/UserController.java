package com.sample.servlet;

import com.sample.ejb.UserBean;
import com.sample.jpa.entity.UserEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserController extends HttpServlet {

    @EJB
    private UserBean userBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("Test from GUI" + System.currentTimeMillis());
        userBean.saveUser(userEntity);
        resp.getWriter().println("create user with id: " + userEntity.getId());
    }
}
