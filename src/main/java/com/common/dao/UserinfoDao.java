package com.common.dao;

import com.common.entity.Userinfo;
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
 * ClassName:UserinfoDao
 * Description: 用户信息数据库操作处理
 */
public class UserinfoDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * MethodName :保存
     * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
     *
     * @param userinfo 数据对象
     */
    public int save(Userinfo userinfo) {

        String sql = "insert into userinfo (user_id,username,password,role,permissions,email,created_at)  values (? ,? ,? ,? ,? ,? ,?)";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, userinfo.getUser_id());
            pstmt.setObject(2, userinfo.getUsername());
            pstmt.setObject(3, userinfo.getPassword());
            pstmt.setObject(4, userinfo.getRole());
            pstmt.setObject(5, userinfo.getPermissions());
            pstmt.setObject(6, userinfo.getEmail());
            pstmt.setObject(7, userinfo.getCreated_at());
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
        String sql = "delete from userinfo  where user_id = ?";
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
     * @param userinfo 与数据库表对应的对象
     */
    public int update(Userinfo userinfo) {
        String sql = " update userinfo set username = ?,password = ?,role = ?,permissions = ?,email = ?,created_at = ? where user_id = ? ";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, userinfo.getUsername());
            pstmt.setObject(2, userinfo.getPassword());
            pstmt.setObject(3, userinfo.getRole());
            pstmt.setObject(4, userinfo.getPermissions());
            pstmt.setObject(5, userinfo.getEmail());
            pstmt.setObject(6, userinfo.getCreated_at());
            pstmt.setInt(7, userinfo.getUser_id());
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
    public Userinfo queryById(int id) {
        String sql = "select * from userinfo where user_id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Userinfo userinfo = new Userinfo();
                userinfo.setUser_id(rs.getInt("user_id"));
                userinfo.setUsername(rs.getString("username"));
                userinfo.setPassword(rs.getString("password"));
                userinfo.setRole(rs.getString("role"));
                userinfo.setPermissions(rs.getString("permissions"));
                userinfo.setEmail(rs.getString("email"));
                userinfo.setCreated_at(rs.getString("created_at"));
                return userinfo;
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
    public List<Userinfo> queryAll(String keyword) {
        String sql = "select * from userinfo";
        if (null != keyword) {
            sql = sql + "  where username like  '%" + keyword + "%'";
        }
        List<Userinfo> list = new ArrayList<Userinfo>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Userinfo.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Userinfo userinfo = new Userinfo();
                userinfo.setUser_id(rs.getInt("user_id"));
                userinfo.setUsername(rs.getString("username"));
                userinfo.setPassword(rs.getString("password"));
                userinfo.setRole(rs.getString("role"));
                userinfo.setPermissions(rs.getString("permissions"));
                userinfo.setEmail(rs.getString("email"));
                userinfo.setCreated_at(rs.getString("created_at"));
                list.add(userinfo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, pstmt);
        }
        return list;
    }


    public List<Userinfo> queryMyStudent(String orgid) {
        String sql = "select userinfo.* from  userinfo,user_institution_bindings where userinfo.user_id=user_institution_bindings.student_id  and org_id="+orgid;
        List<Userinfo> list = new ArrayList<Userinfo>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Userinfo.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Userinfo userinfo = new Userinfo();
                userinfo.setUser_id(rs.getInt("user_id"));
                userinfo.setUsername(rs.getString("username"));
                userinfo.setPassword(rs.getString("password"));
                userinfo.setRole(rs.getString("role"));
                userinfo.setPermissions(rs.getString("permissions"));
                userinfo.setEmail(rs.getString("email"));
                userinfo.setCreated_at(rs.getString("created_at"));
                list.add(userinfo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, pstmt);
        }
        return list;
    }

    public Userinfo login(String username,String role) {
        String sql = "select * from userinfo where username = ?  and role= ?  ";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setString(1, username);
            pstmt.setString(2, role);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Userinfo userinfo = new Userinfo();
                userinfo.setUser_id(rs.getInt("user_id"));
                userinfo.setUsername(rs.getString("username"));
                userinfo.setPassword(rs.getString("password"));
                userinfo.setRole(rs.getString("role"));
                userinfo.setPermissions(rs.getString("permissions"));
                userinfo.setEmail(rs.getString("email"));
                userinfo.setCreated_at(rs.getString("created_at"));
                return userinfo;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, pstmt);
        }
        return null;
    }


}
