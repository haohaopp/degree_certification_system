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
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ClassName:UserinfoServlet
 * Description:用户信息请求处理
 */
@WebServlet(name = "UserinfoServlet", urlPatterns = "/UserinfoServlet")
public class UserinfoServlet extends HttpServlet {

    UserinfoDao userinfoDao = new UserinfoDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码集 防止接收参数乱码
        request.setCharacterEncoding("utf-8");
        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
        response.setCharacterEncoding("utf-8");
        if (request.getParameter("type").equals("save")) {
            //插入操作业务...
            save(request, response);
        } else if (request.getParameter("type").equals("delete")) {
            //删除操作业务...
            delete(request, response);
        } else if (request.getParameter("type").equals("update")) {
            //修改操作业务...
            update(request, response);
        } else if (request.getParameter("type").equals("query")) {
            //查询所有操作业务...
            query(request, response);
        } else if (request.getParameter("type").equals("get")) {
            //查询id操作业务...
            get(request, response);
        } else if (request.getParameter("type").equals("edit")) {
            //查询id获取 跳转编辑页面...
            edit(request, response);
        } else if (request.getParameter("type").equals("add")) {
            //查询id获取 跳转编辑页面...
            add(request, response);
        } else if (request.getParameter("type").equals("send")) {
            //查询id获取 跳转编辑页面...
            send(request, response);
        } else {
            System.err.println("动作类型不匹配！");
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("write something here!");

        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    //添加Userinfo信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        userinfoDao.save(obj);//调用数据库添加
        response.sendRedirect("UserinfoServlet?type=query");
    }

    //修改Userinfo信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        userinfoDao.update(obj); //调用数据库修改功能
        response.sendRedirect("UserinfoServlet?type=query");
    }


    //根据主键id删除Userinfo信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        userinfoDao.delete(id);//调用数据库删除
        response.sendRedirect("UserinfoServlet?type=query");
    }


    //Userinfo查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String keyword = request.getParameter("keyword");
        if (null != keyword) {
            request.setAttribute("keyword", keyword);
            ;//绑定参数
        }
        List<Userinfo> userinfoList = userinfoDao.queryAll(keyword); //调用数据库查询所有
        request.setAttribute("userinfoList", userinfoList);   //绑定接受参数
        request.getRequestDispatcher("userinfoList.jsp").forward(request, response);
    }


    //Userinfo根据主键id查询数据
    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        Userinfo userinfo = userinfoDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("userinfo", userinfo);   //绑定接受参数
        request.getRequestDispatcher("userinfoDetail.jsp").forward(request, response);
    }

    //Userinfo根据主键id查询数据 跳转到编辑页面
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        Userinfo userinfo = userinfoDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("userinfo", userinfo);   //绑定接受参数
        request.getRequestDispatcher("userinfoUpdate.jsp").forward(request, response);
    }

    //Userinfo根据主键id查询数据 跳转到编辑页面
    protected void send(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr = request.getParameter("id");
        List<Userinfo> userinfoList = userinfoDao.queryMyStudent(idStr);//调用数据库根据主键查询
        request.setAttribute("userinfoList", userinfoList);   //绑定接受参数
        request.getRequestDispatcher("sendList.jsp").forward(request, response);
    }


    //Userinfo跳转到添加页面
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("userinfoAdd.jsp").forward(request, response);
    }


}
