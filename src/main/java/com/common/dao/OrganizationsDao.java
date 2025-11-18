package com.common.dao;

import com.common.entity.Organizations;
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
* ClassName:OrganizationsDao
* Description: 机构企业数据库操作处理
*/
public class OrganizationsDao{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
    * MethodName :保存
    * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
    * @param organizations 数据对象
    */
    public int  save(Organizations organizations){

        String sql = "insert into organizations (org_id,org_name,org_type,contact_email,contact_phone)  values (? ,? ,? ,? ,?)" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,organizations.getOrg_id());
            pstmt.setObject(2,organizations.getOrg_name());
            pstmt.setObject(3,organizations.getOrg_type());
            pstmt.setObject(4,organizations.getContact_email());
            pstmt.setObject(5,organizations.getContact_phone());
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
        String sql = "delete from organizations  where org_id = ?" ;
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
    * @param organizations 与数据库表对应的对象
    */
    public int update(Organizations organizations) {
        String sql = " update organizations set org_name = ?,org_type = ?,contact_email = ?,contact_phone = ? where org_id = ? ";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,organizations.getOrg_name());
            pstmt.setObject(2,organizations.getOrg_type());
            pstmt.setObject(3,organizations.getContact_email());
            pstmt.setObject(4,organizations.getContact_phone());
            pstmt.setInt(5,organizations.getOrg_id());
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
    public Organizations queryById(int id){
        String sql = "select * from organizations where org_id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Organizations organizations = new Organizations();
            organizations.setOrg_id(rs.getInt("org_id"));
                organizations.setOrg_name(rs.getString("org_name"));
                organizations.setOrg_type(rs.getString("org_type"));
                organizations.setContact_email(rs.getString("contact_email"));
                organizations.setContact_phone(rs.getString("contact_phone"));
                return organizations;
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
    public List<Organizations> queryAll(String keyword){
        String sql = "select * from organizations" ;
        if(null!=keyword){
            sql=sql +"  where org_name like  '%"+keyword+"%'";
        }
        List<Organizations> list = new ArrayList<Organizations>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Organizations.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Organizations organizations = new Organizations();
            organizations.setOrg_id(rs.getInt("org_id"));
                organizations.setOrg_name(rs.getString("org_name"));
                organizations.setOrg_type(rs.getString("org_type"));
                organizations.setContact_email(rs.getString("contact_email"));
                organizations.setContact_phone(rs.getString("contact_phone"));
                list.add(organizations);
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
