package com.common.servlet;

import com.common.dao.OrganizationsDao;
import com.common.entity.Organizations;

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
* ClassName:OrganizationsServlet
* Description:机构企业请求处理
*/
@WebServlet(name = "OrganizationsServlet",urlPatterns = "/OrganizationsServlet")
public class OrganizationsServlet extends HttpServlet {

    OrganizationsDao organizationsDao = new OrganizationsDao();

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




    //添加Organizations信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contact_phone=request.getParameter("contact_phone");
        String org_id=request.getParameter("org_id");
        String org_type=request.getParameter("org_type");
        String org_name=request.getParameter("org_name");
        String contact_email=request.getParameter("contact_email");

        Organizations obj=new  Organizations();

        obj.setOrg_id(Integer.parseInt(org_id));
        obj.setOrg_name(org_name);
        obj.setOrg_type(org_type);
        obj.setContact_email(contact_email);
        obj.setContact_phone(contact_phone);
        organizationsDao.save(obj);//调用数据库添加
        response.sendRedirect("OrganizationsServlet?type=query");
    }

    //修改Organizations信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contact_phone=request.getParameter("contact_phone");
        String org_id=request.getParameter("org_id");
        String org_type=request.getParameter("org_type");
        String org_name=request.getParameter("org_name");
        String contact_email=request.getParameter("contact_email");

        Organizations obj=new  Organizations();

        obj.setOrg_id(Integer.parseInt(org_id));
        obj.setOrg_name(org_name);
        obj.setOrg_type(org_type);
        obj.setContact_email(contact_email);
        obj.setContact_phone(contact_phone);

        organizationsDao.update(obj); //调用数据库修改功能
        response.sendRedirect("OrganizationsServlet?type=query");
    }


    //根据主键id删除Organizations信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        organizationsDao.delete(id);//调用数据库删除
        response.sendRedirect("OrganizationsServlet?type=query");
    }


    //Organizations查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String keyword=request.getParameter("keyword");
        if(null!=keyword){
            request.setAttribute("keyword",keyword);;//绑定参数
        }
        List<Organizations>  organizationsList=organizationsDao.queryAll(keyword); //调用数据库查询所有
        request.setAttribute("organizationsList",organizationsList);   //绑定接受参数
        request.getRequestDispatcher("organizationsList.jsp").forward(request,response);
    }


    //Organizations根据主键id查询数据
    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Organizations  organizations=organizationsDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("organizations",organizations);   //绑定接受参数
        request.getRequestDispatcher("organizationsDetail.jsp").forward(request,response);
    }

    //Organizations根据主键id查询数据 跳转到编辑页面
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Organizations  organizations=organizationsDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("organizations",organizations);   //绑定接受参数
        request.getRequestDispatcher("organizationsUpdate.jsp").forward(request,response);
    }


    //Organizations跳转到添加页面
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("organizationsAdd.jsp").forward(request,response);
    }



}
