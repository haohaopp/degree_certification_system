package com.common.servlet;

import com.common.dao.UserinfoDao;
import com.common.entity.Userinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * ClassName:UserinfoServlet
 * Description:
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    UserinfoDao userinfoDao = new UserinfoDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码集 防止接收参数乱码
        request.setCharacterEncoding("utf-8");
        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
        response.setCharacterEncoding("utf-8");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String user_id = request.getParameter("user_id");
        String permissions = request.getParameter("permissions");
        String created_at = request.getParameter("created_at");
        String email = request.getParameter("email");
        String username = request.getParameter("username");

        Userinfo obj = new Userinfo();

        obj.setUser_id(Integer.parseInt(user_id));
        obj.setUsername(username);
        obj.setPassword(password);
        obj.setRole(role);
        obj.setPermissions(permissions);
        obj.setEmail(email);
        obj.setCreated_at(created_at);

        int update = userinfoDao.save(obj);
        if (update > 0) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("msg", "用户注册失败");   //绑定接受参数
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
