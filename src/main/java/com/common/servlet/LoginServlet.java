package com.common.servlet;

import com.common.dao.UserinfoDao;
import com.common.entity.Userinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:UserinfoServlet
 * Description:
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    UserinfoDao userinfoDao = new UserinfoDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码集 防止接收参数乱码
        request.setCharacterEncoding("utf-8");
        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
        response.setCharacterEncoding("utf-8");

        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String role = request.getParameter("role");

        Userinfo userinfo = userinfoDao.login(username, role);
        if (userinfo != null && password.equals(userinfo.getPassword())) {
            //登录以后将信息放入session中
            request.getSession().setAttribute("loginUser", userinfo);
            response.sendRedirect("UserinfoServlet?type=edit&id=" + userinfo.getUser_id());
        } else {
            request.setAttribute("msg", "角色或者用户名或者密码错误");   //绑定接受参数
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }


}
