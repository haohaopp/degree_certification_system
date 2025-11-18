package com.common.servlet;

import com.common.dao.User_institution_bindingsDao;
import com.common.entity.User_institution_bindings;

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
* ClassName:User_institution_bindingsServlet
* Description:学生关系请求处理
*/
@WebServlet(name = "User_institution_bindingsServlet",urlPatterns = "/User_institution_bindingsServlet")
public class User_institution_bindingsServlet extends HttpServlet {

    User_institution_bindingsDao user_institution_bindingsDao = new User_institution_bindingsDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码集 防止接收参数乱码
        request.setCharacterEncoding("utf-8");
        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
        response.setCharacterEncoding("utf-8");
        if(request.getParameter("type").equals("save")){
            //插入操作业务...
            save(request,response);
        }else if (request.getParameter("type").equals("delete")){
            //删除操作业务...
            delete(request,response);
        }else if (request.getParameter("type").equals("update")){
            //修改操作业务...
            update(request,response);
        }else if (request.getParameter("type").equals("query")){
            //查询所有操作业务...
            query(request,response);
        }else if (request.getParameter("type").equals("get")){
            //查询id操作业务...
            get(request,response);
        }else if (request.getParameter("type").equals("edit")){
            //查询id获取 跳转编辑页面...
            edit(request,response);
        }else if (request.getParameter("type").equals("add")){
            //查询id获取 跳转编辑页面...
            add(request,response);
        }else{
            System.err.println("动作类型不匹配！");
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("write something here!");

        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }




    //添加User_institution_bindings信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String org_id=request.getParameter("org_id");
        String student_id=request.getParameter("student_id");
        String bind_date=request.getParameter("bind_date");
        String binding_id=request.getParameter("binding_id");

        User_institution_bindings obj=new  User_institution_bindings();

        obj.setBinding_id(Integer.parseInt(binding_id));
        obj.setStudent_id(Integer.parseInt(student_id));
        obj.setOrg_id(Integer.parseInt(org_id));
        obj.setBind_date(bind_date);
        user_institution_bindingsDao.save(obj);//调用数据库添加
        response.sendRedirect("User_institution_bindingsServlet?type=query");
    }

    //修改User_institution_bindings信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String org_id=request.getParameter("org_id");
        String student_id=request.getParameter("student_id");
        String bind_date=request.getParameter("bind_date");
        String binding_id=request.getParameter("binding_id");

        User_institution_bindings obj=new  User_institution_bindings();

        obj.setBinding_id(Integer.parseInt(binding_id));
        obj.setStudent_id(Integer.parseInt(student_id));
        obj.setOrg_id(Integer.parseInt(org_id));
        obj.setBind_date(bind_date);

        user_institution_bindingsDao.update(obj); //调用数据库修改功能
        response.sendRedirect("User_institution_bindingsServlet?type=query");
    }


    //根据主键id删除User_institution_bindings信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        user_institution_bindingsDao.delete(id);//调用数据库删除
        response.sendRedirect("User_institution_bindingsServlet?type=query");
    }


    //User_institution_bindings查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String keyword=request.getParameter("keyword");
        if(null!=keyword){
            request.setAttribute("keyword",keyword);;//绑定参数
        }
        List<User_institution_bindings>  user_institution_bindingsList=user_institution_bindingsDao.queryAll(keyword); //调用数据库查询所有
        request.setAttribute("user_institution_bindingsList",user_institution_bindingsList);   //绑定接受参数
        request.getRequestDispatcher("user_institution_bindingsList.jsp").forward(request,response);
    }


    //User_institution_bindings根据主键id查询数据
    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        User_institution_bindings  user_institution_bindings=user_institution_bindingsDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("user_institution_bindings",user_institution_bindings);   //绑定接受参数
        request.getRequestDispatcher("user_institution_bindingsDetail.jsp").forward(request,response);
    }

    //User_institution_bindings根据主键id查询数据 跳转到编辑页面
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        User_institution_bindings  user_institution_bindings=user_institution_bindingsDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("user_institution_bindings",user_institution_bindings);   //绑定接受参数
        request.getRequestDispatcher("user_institution_bindingsUpdate.jsp").forward(request,response);
    }


    //User_institution_bindings跳转到添加页面
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user_institution_bindingsAdd.jsp").forward(request,response);
    }



}
