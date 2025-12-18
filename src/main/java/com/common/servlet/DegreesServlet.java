package com.common.servlet;

import com.alibaba.fastjson.JSON;
import com.common.dao.DegreesDao;
import com.common.entity.Degrees;
import com.common.util.DegreesObject;
import com.common.util.FabricBean;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:DegreesServlet
 * Description:学位证书请求处理
 */
@WebServlet(name = "DegreesServlet", urlPatterns = "/DegreesServlet")
public class DegreesServlet extends HttpServlet {

    DegreesDao degreesDao = new DegreesDao();

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
        } else if (request.getParameter("type").equals("join")) {
            //查询所有操作业务...
            join(request, response);
        } else if (request.getParameter("type").equals("show")) {
            //查询所有操作业务...
            show(request, response);
        } else if (request.getParameter("type").equals("myQuery")) {
            //查询所有操作业务...
            myQuery(request, response);
        } else if (request.getParameter("type").equals("myQueryTwo")) {
            //查询所有操作业务...
            myQueryTwo(request, response);
        } else if (request.getParameter("type").equals("get")) {
            //查询id操作业务...
            get(request, response);
        } else if (request.getParameter("type").equals("edit")) {
            //查询id获取 跳转编辑页面...
            edit(request, response);
        } else if (request.getParameter("type").equals("add")) {
            //查询id获取 跳转编辑页面...
            add(request, response);
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


    //添加Degrees信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String degree_id = request.getParameter("degree_id");
        String issue_date = request.getParameter("issue_date");
        String degree_name = request.getParameter("degree_name");
        String org_id = request.getParameter("org_id");
        String student_id = request.getParameter("student_id");
        String status = request.getParameter("status");

        Degrees obj = new Degrees();

        obj.setDegree_id(Integer.parseInt(degree_id));
        obj.setStudent_id(Integer.parseInt(student_id));
        obj.setOrg_id(Integer.parseInt(org_id));
        obj.setDegree_name(degree_name);
        obj.setIssue_date(issue_date);
        obj.setStatus(status);
        degreesDao.save(obj);//调用数据库添加

        Degrees degrees = degreesDao.queryById(obj.getDegree_id());
        DegreesObject obj2 = new DegreesObject();
        obj2.setId(1);
        obj2.setName("张三");
        obj2.setTimes("2025");
        obj2.setData("AAAA");
        obj2.setResult(obj);
        String ss = JSON.toJSONString(obj2);
        FabricBean.submitData(FabricBean.dataFlag, ss);

        response.sendRedirect("DegreesServlet?type=myQueryTwo&id=" + org_id);
    }

    //修改Degrees信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String degree_id = request.getParameter("degree_id");
        String issue_date = request.getParameter("issue_date");
        String degree_name = request.getParameter("degree_name");
        String org_id = request.getParameter("org_id");
        String student_id = request.getParameter("student_id");
        String status = request.getParameter("status");

        Degrees obj = new Degrees();

        obj.setDegree_id(Integer.parseInt(degree_id));
        obj.setStudent_id(Integer.parseInt(student_id));
        obj.setOrg_id(Integer.parseInt(org_id));
        obj.setDegree_name(degree_name);
        obj.setIssue_date(issue_date);
        obj.setStatus(status);

        degreesDao.update(obj); //调用数据库修改功能
        response.sendRedirect("DegreesServlet?type=query");
    }


    //根据主键id删除Degrees信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        degreesDao.delete(id);//调用数据库删除
        response.sendRedirect("DegreesServlet?type=query");
    }


    //Degrees查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String keyword = request.getParameter("keyword");
        if (null != keyword) {
            request.setAttribute("keyword", keyword);
            ;//绑定参数
        }
        List<Degrees> degreesList = degreesDao.queryAll(keyword); //调用数据库查询所有
        request.setAttribute("degreesList", degreesList);   //绑定接受参数
        request.getRequestDispatcher("degreesList.jsp").forward(request, response);
    }

    //Degrees查询数据库中的所有数据
    protected void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String keyword = request.getParameter("keyword");
        if (null != keyword) {
            request.setAttribute("keyword", keyword);
            ;//绑定参数
        }
        List<Degrees> degreesList = degreesDao.queryAll(keyword); //调用数据库查询所有
        for (Degrees degrees : degreesList) {
            DegreesObject obj = new DegreesObject();
            obj.setId(1);
            obj.setName("张三");
            obj.setTimes("2025");
            obj.setData("AAAA");
            obj.setResult(degrees);
            String ss = JSON.toJSONString(obj);
            FabricBean.submitData(FabricBean.dataFlag, ss);
        }
        request.setAttribute("degreesList", degreesList);   //绑定接受参数
        request.getRequestDispatcher("degreesList.jsp").forward(request, response);
    }

    //Degrees查询数据库中的所有数据
    protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Degrees> degreesList = new ArrayList<Degrees>();
        List<DegreesObject> dataList = FabricBean.queryData(FabricBean.dataFlag);
        for (DegreesObject obj : dataList) {
            System.out.println("obj = " + obj);
            degreesList.add(obj.getResult());
        }
        request.setAttribute("degreesList", degreesList);   //绑定接受参数
        request.getRequestDispatcher("degreesListshow.jsp").forward(request, response);
    }

    //Degrees查询数据库中的所有数据
    protected void myQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String uid = request.getParameter("id");
        List<Degrees> degreesList = degreesDao.queryAll(null); //调用数据库查询所有
        request.setAttribute("degreesList", degreesList);   //绑定接受参数
        request.setAttribute("uid", uid);   //绑定接受参数
        request.getRequestDispatcher("myQuery.jsp").forward(request, response);
    }

    //Degrees查询数据库中的所有数据
    protected void myQueryTwo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String uid = request.getParameter("id");
        List<Degrees> degreesList = degreesDao.queryAll(null); //调用数据库查询所有
        request.setAttribute("degreesList", degreesList);   //绑定接受参数
        request.setAttribute("uid", uid);   //绑定接受参数
        request.getRequestDispatcher("myQueryTwo.jsp").forward(request, response);
    }

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        // 设置纠错级别为高
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    //Degrees根据主键id查询数据
    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        Degrees degrees = degreesDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("degrees", degrees);   //绑定接受参数


        String basePath = request.getSession().getServletContext().getRealPath("/static");
        String codeImg = System.currentTimeMillis() + ".png";
        String QR_CODE_IMAGE_PATH = basePath + "/" + codeImg;
        try {
            // 二维码内容
            String qrCodeContent = JSON.toJSONString(degrees);
            // 二维码宽度
            int width = 350;
            // 二维码高度
            int height = 350;
            generateQRCodeImage(qrCodeContent, width, height, QR_CODE_IMAGE_PATH);
            System.out.println("二维码图片生成成功，路径为: " + QR_CODE_IMAGE_PATH);
        } catch (WriterException | IOException e) {
            System.err.println("生成二维码图片时出现错误: " + e.getMessage());
        }
        request.setAttribute("codeImg", codeImg);   //绑定接受参数


        request.getRequestDispatcher("degreesDetail.jsp").forward(request, response);
    }

    //Degrees根据主键id查询数据 跳转到编辑页面
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        Degrees degrees = degreesDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("degrees", degrees);   //绑定接受参数
        request.getRequestDispatcher("degreesUpdate.jsp").forward(request, response);
    }


    //Degrees跳转到添加页面
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("degreesAdd.jsp").forward(request, response);
    }


}
