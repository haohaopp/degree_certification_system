package com.common.servlet;

import com.common.dao.UserinfoDao;
import com.common.entity.Userinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginOutServlet", urlPatterns = "/LoginOutServlet")
public class LoginOutServlet extends HttpServlet {

    UserinfoDao userinfoDao = new UserinfoDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //清除session
        request.getSession().invalidate();
        response.sendRedirect("login.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
