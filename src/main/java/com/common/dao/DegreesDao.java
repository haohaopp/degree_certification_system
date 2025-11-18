package com.common.dao;

import com.common.entity.Degrees;
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
 * ClassName:DegreesDao
 * Description: 学位证书数据库操作处理
 */
public class DegreesDao {
    OrganizationsDao organizationsDao = new OrganizationsDao();
    UserinfoDao userinfoDao = new UserinfoDao();

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * MethodName :保存
     * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
     *
     * @param degrees 数据对象
     */
    public int save(Degrees degrees) {

        String sql = "insert into degrees (degree_id,student_id,org_id,degree_name,issue_date,status)  values (? ,? ,? ,? ,? ,?)";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, degrees.getDegree_id());
            pstmt.setObject(2, degrees.getStudent_id());
            pstmt.setObject(3, degrees.getOrg_id());
            pstmt.setObject(4, degrees.getDegree_name());
            pstmt.setObject(5, degrees.getIssue_date());
            pstmt.setObject(6, degrees.getStatus());
            int i = pstmt.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, pstmt);
        }
        return 0;
    }

    /**
     * MethodName: 删除
     * Description: 将一个属性与数据库表属性相对应的对象从数据库中删除(通过设置该对象id,通过id删除信息记录)
     */
    public int delete(int id) {
        String sql = "delete from degrees  where degree_id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int i = pstmt.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, pstmt);
        }
        return 0;
    }

    /**
     * MethodName 修改
     * Description 通过id修改数据库表
     *
     * @param degrees 与数据库表对应的对象
     */
    public int update(Degrees degrees) {
        String sql = " update degrees set student_id = ?,org_id = ?,degree_name = ?,issue_date = ?,status = ? where degree_id = ? ";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, degrees.getStudent_id());
            pstmt.setObject(2, degrees.getOrg_id());
            pstmt.setObject(3, degrees.getDegree_name());
            pstmt.setObject(4, degrees.getIssue_date());
            pstmt.setObject(5, degrees.getStatus());
            pstmt.setInt(6, degrees.getDegree_id());
            int i = pstmt.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, pstmt);
        }
        return 0;
    }

    /**
     * MethodName 查询
     * Description 通过id查询数据库信息记录(通过设置该对象id,通过id查询信息记录)
     */
    public Degrees queryById(int id) {
        String sql = "select * from degrees where degree_id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Degrees degrees = new Degrees();
                degrees.setDegree_id(rs.getInt("degree_id"));
                degrees.setStudent_id(rs.getInt("student_id"));
                degrees.setOrg_id(rs.getInt("org_id"));
                degrees.setDegree_name(rs.getString("degree_name"));
                degrees.setIssue_date(rs.getString("issue_date"));
                degrees.setStatus(rs.getString("status"));
                degrees.setOrgUser(organizationsDao.queryById(degrees.getOrg_id()));
                degrees.setUserUser(userinfoDao.queryById(degrees.getStudent_id()));
                return degrees;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, pstmt);
        }
        return null;
    }

    /**
     * MethodName 查询
     * Description 通过id查询数据库信息记录(通过设置该对象id,通过id查询信息记录)
     */
    public List<Degrees> queryAll(String keyword) {
        String sql = "select * from degrees";
        if (null != keyword) {
            sql = sql + "  where student_id like  '%" + keyword + "%'";
        }
        List<Degrees> list = new ArrayList<Degrees>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Degrees.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Degrees degrees = new Degrees();
                degrees.setDegree_id(rs.getInt("degree_id"));
                degrees.setStudent_id(rs.getInt("student_id"));
                degrees.setOrg_id(rs.getInt("org_id"));
                degrees.setDegree_name(rs.getString("degree_name"));
                degrees.setIssue_date(rs.getString("issue_date"));
                degrees.setStatus(rs.getString("status"));
                degrees.setOrgUser(organizationsDao.queryById(degrees.getOrg_id()));
                degrees.setUserUser(userinfoDao.queryById(degrees.getStudent_id()));
                list.add(degrees);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, pstmt);
        }
        return list;
    }


    public List<Degrees> queryByUserID(String id) {
        String sql = "select * from degrees";
        sql = sql + "  where student_id=" + id + "";
        List<Degrees> list = new ArrayList<Degrees>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Degrees.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Degrees degrees = new Degrees();
                degrees.setDegree_id(rs.getInt("degree_id"));
                degrees.setStudent_id(rs.getInt("student_id"));
                degrees.setOrg_id(rs.getInt("org_id"));
                degrees.setDegree_name(rs.getString("degree_name"));
                degrees.setIssue_date(rs.getString("issue_date"));
                degrees.setStatus(rs.getString("status"));
                degrees.setOrgUser(organizationsDao.queryById(degrees.getOrg_id()));
                degrees.setUserUser(userinfoDao.queryById(degrees.getStudent_id()));
                list.add(degrees);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, pstmt);
        }
        return list;
    }
}
