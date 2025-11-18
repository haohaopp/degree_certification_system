package com.common.entity;

/**
* ClassName:Userinfo
* Description: 用户信息实体类
*/
public class Userinfo {

    /**
    * 用户编号
    */
        private Integer user_id;
    /**
    * 用户名
    */
        private String username;
    /**
    * 用户密码
    */
        private String password;
    /**
    * 用户角色
    */
        private String role;
    /**
    * 用户权限
    */
        private String permissions;
    /**
    * 用户邮箱
    */
        private String email;
    /**
    * 创建时间
    */
        private String created_at;


        public Integer getUser_id() {
        return user_id;
        }

        public void setUser_id(Integer user_id) {
        this.user_id = user_id;
        }

        public String getUsername() {
        return username;
        }

        public void setUsername(String username) {
        this.username = username;
        }

        public String getPassword() {
        return password;
        }

        public void setPassword(String password) {
        this.password = password;
        }

        public String getRole() {
        return role;
        }

        public void setRole(String role) {
        this.role = role;
        }

        public String getPermissions() {
        return permissions;
        }

        public void setPermissions(String permissions) {
        this.permissions = permissions;
        }

        public String getEmail() {
        return email;
        }

        public void setEmail(String email) {
        this.email = email;
        }

        public String getCreated_at() {
        return created_at;
        }

        public void setCreated_at(String created_at) {
        this.created_at = created_at;
        }


}