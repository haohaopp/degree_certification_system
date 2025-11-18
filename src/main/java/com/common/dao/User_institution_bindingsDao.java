package com.common.dao;

import com.common.entity.User_institution_bindings;
import com.common.util.DbUtil;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.lang.reflect.Method;

/**
* ClassName:User_institution_bindingsDao
* Description: 学生关系数据库操作处理
*/
public class User_institution_bindingsDao{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
    * MethodName :保存
    * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
    * @param user_institution_bindings 数据对象
    */
    public int  save(User_institution_bindings user_institution_bindings){

        String sql = "insert into user_institution_bindings (binding_id,student_id,org_id,bind_date)  values (? ,? ,? ,?)" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,user_institution_bindings.getBinding_id());
            pstmt.setObject(2,user_institution_bindings.getStudent_id());
            pstmt.setObject(3,user_institution_bindings.getOrg_id());
            pstmt.setObject(4,user_institution_bindings.getBind_date());
            int i =  pstmt.executeUpdate();
            return i;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    /**
    * MethodName: 删除
    * Description: 将一个属性与数据库表属性相对应的对象从数据库中删除(通过设置该对象id,通过id删除信息记录)
    */
    public int delete(int id){
        String sql = "delete from user_institution_bindings  where binding_id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            int i = pstmt.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    /**
    * MethodName 修改
    * Description 通过id修改数据库表
    * @param user_institution_bindings 与数据库表对应的对象
    */
    public int update(User_institution_bindings user_institution_bindings) {
        String sql = " update user_institution_bindings set student_id = ?,org_id = ?,bind_date = ? where binding_id = ? ";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,user_institution_bindings.getStudent_id());
            pstmt.setObject(2,user_institution_bindings.getOrg_id());
            pstmt.setObject(3,user_institution_bindings.getBind_date());
            pstmt.setInt(4,user_institution_bindings.getBinding_id());
            int i = pstmt.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    /**
    * MethodName 查询
    * Description 通过id查询数据库信息记录(通过设置该对象id,通过id查询信息记录)
    */
    public User_institution_bindings queryById(int id){
        String sql = "select * from user_institution_bindings where binding_id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                User_institution_bindings user_institution_bindings = new User_institution_bindings();
            user_institution_bindings.setBinding_id(rs.getInt("binding_id"));
            user_institution_bindings.setStudent_id(rs.getInt("student_id"));
            user_institution_bindings.setOrg_id(rs.getInt("org_id"));
                user_institution_bindings.setBind_date(rs.getString("bind_date"));
                return user_institution_bindings;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return null;
    }

    /**
    * MethodName 查询
    * Description 通过id查询数据库信息记录(通过设置该对象id,通过id查询信息记录)
    */
    public List<User_institution_bindings> queryAll(String keyword){
        String sql = "select * from user_institution_bindings" ;
        if(null!=keyword){
            sql=sql +"  where student_id like  '%"+keyword+"%'";
        }
        List<User_institution_bindings> list = new ArrayList<User_institution_bindings>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = User_institution_bindings.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                User_institution_bindings user_institution_bindings = new User_institution_bindings();
            user_institution_bindings.setBinding_id(rs.getInt("binding_id"));
            user_institution_bindings.setStudent_id(rs.getInt("student_id"));
            user_institution_bindings.setOrg_id(rs.getInt("org_id"));
                user_institution_bindings.setBind_date(rs.getString("bind_date"));
                list.add(user_institution_bindings);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return list;
    }

}
